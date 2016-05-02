package edu.neu.csye6200.ca;

import java.util.ArrayList;
import java.util.Arrays;

import static edu.neu.csye6200.ca.Constants.CA_RULES;
import static edu.neu.csye6200.ca.Constants.CA_START;
import static edu.neu.csye6200.ca.Constants.CA_STOP;
import static edu.neu.csye6200.ca.CACanvas.flag;
import static edu.neu.csye6200.ca.CACanvas.thread;

/**
 * Created by Renjith .
 */
public class EventListener implements CanvasListener {
    private static EventListener mCAEventListener;
    private CACanvas mCACanvas;

    private EventListener() {
        mCACanvas = CACanvas.getCACanvas();
    }

    static EventListener getCAEventListener() {
        if (mCAEventListener == null) {
            mCAEventListener = new EventListener();
        }
        return mCAEventListener;
    }

    @Override
    public void updateRule(String rule) {
        System.out.println(rule);
        int num = Arrays.asList(CA_RULES).indexOf(rule) +1;
        CARule.setRule(num);
    }

    @Override
    public void start(ArrayList<CACell[]> caGenerationArrayList) {
        System.out.println(CA_START);
        mCACanvas.startAnimation(caGenerationArrayList);


    }

    @Override
    public void stop() {
        System.out.println(CA_STOP);
        flag.set(false);
        try {
            thread.join(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
