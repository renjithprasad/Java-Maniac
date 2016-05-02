package edu.neu.csye6200.ca;


/**
 * Created by Renjith .
 */
public class Controller {

    public static void main(String args[]){
        EventListener caEventListener = EventListener.getCAEventListener();
        CAApp caApp = new CAApp(caEventListener);
        Thread thread = new Thread(caApp);
        thread.start();
    }
}
