package edu.neu.csye6200.ca;

import java.util.ArrayList;

/**
 * Created by Renjith.
 */
public interface CanvasListener {
    void updateRule(String rule);
    void start(ArrayList<CACell[]> caGenerationArrayList);
    void stop();

}
