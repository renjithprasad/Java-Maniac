package edu.neu.csye6200.ca;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;


class CACanvas extends Canvas implements Runnable {


    private static CACanvas mCanvas;
    private volatile static int counter = 5;
    private static Graphics2D mGraphics2D;
    public static AtomicBoolean flag = new AtomicBoolean(false);
    static Thread thread;
    private ArrayList<CACell[]> mGenList;

    private CACanvas() {

    }

    static CACanvas getCACanvas() {
        if (mCanvas == null) {
            mCanvas = new CACanvas();
        }
        return mCanvas;
    }


    public void paint(Graphics graphics) {

        mGraphics2D = (Graphics2D) graphics;
        mGraphics2D.drawString(" STARTING AGAIN ", 0, 0);
        int xAxis = 0;
        int yAxis = 0;
        if (flag.get()) {
            for (CACell[] arr : mGenList) {
                for (CACell caCell : arr) {
                    xAxis += 7;
                    if (caCell.getState() == 0) {
                        System.out.print("  ");
                    } else if (caCell.getState() == 1) {
                        System.out.print("* ");
                        mGraphics2D.setColor(Color.black);
                        mGraphics2D.drawRect(xAxis, yAxis, 4, 4);
                        mGraphics2D.fillRect(xAxis, yAxis, 4, 4);
                    } else if (caCell.getState() == 2) {
                        System.out.print("+ ");
                        mGraphics2D.setColor(Color.black);
                        mGraphics2D.drawRect(xAxis, yAxis, 4, 4);
                        mGraphics2D.fillRect(xAxis, yAxis, 4, 4);
                    }
                }
                xAxis = 0;
                yAxis += 20;
                mGraphics2D.drawString("  ", xAxis, yAxis);
                try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            }
        }
    }


    void startAnimation(ArrayList<CACell[]> caGenerationArrayList) {
        flag.set(true);
        mGenList = caGenerationArrayList;
        thread = new Thread(this);
        thread.start();
    }

    void stopAnimation() {
        flag.set(false);

    }

    @Override
    public void run() {
        repaint();
    }


}


