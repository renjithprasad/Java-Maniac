package edu.neu.csye6200.ca;

import java.util.logging.Logger;

class CAApp extends JUIApp implements Runnable {
    private Logger log = Logger.getLogger(CAApp.class.getName());
    private CanvasListener mController;

    CAApp(CanvasListener controller) {
        super(controller);
        mController = controller;
    }


    @Override
    public void run() {
        frame.setSize(800, 500);
        log.info("We are in the constructor");
        frame.add(CACanvas.getCACanvas());
        frame.setVisible(true);
        System.out.println("CAApp is done");
    }

}
