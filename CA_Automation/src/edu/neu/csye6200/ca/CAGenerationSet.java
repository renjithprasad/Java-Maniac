package edu.neu.csye6200.ca;

import java.util.ArrayList;

/**
 * Created by Renjith.
 */
public class CAGenerationSet {
    private static ArrayList<CACell[]> caGenerationArrayList = new ArrayList<>();
    private static CAGenerationSet caGenerationSet;
    private volatile CAGeneration mCAGeneration;


    private CAGenerationSet() {
        mCAGeneration = new CAGeneration();
        caGenerationArrayList.add(mCAGeneration.getCaCells());
    }

    static CAGenerationSet getInstance() {
        if (caGenerationSet == null) {
            caGenerationSet = new CAGenerationSet();
        }
        return caGenerationSet;
    }

    void applyRulesForNextGeneration() {

        CACell[] caCell = mCAGeneration.getCaCells();
        caGenerationArrayList.add(caCell);
        if (caCell != null) {
            CACell[] newCells = new CACell[caCell.length];
            for (int i = 1; i < caCell.length - 1; i++) {
                int left = caCell[i - 1].getState();
                int middle = caCell[i].getState();
                int right = caCell[i + 1].getState();

                int newState = CARule.getNextState(left, middle, right);
                newCells[i] = new CACell(i, newState);
                newCells[i].increaseGenerationNo();
            }
            newCells[0] = caCell[0];
            newCells[0].increaseGenerationNo();
            newCells[caCell.length - 1] = caCell[caCell.length - 1];
            newCells[caCell.length - 1].increaseGenerationNo();
            mCAGeneration.setCaCells(newCells);
            caGenerationArrayList.add(mCAGeneration.getCaCells());
           // System.out.println("\nPrinting Generation " + newCells[0].getGeneration());
            mCAGeneration.printCaCells();
        }
    }

    public  ArrayList<CACell[]> getCaGenerationArrayList() {
        return caGenerationArrayList;
    }

    public void resetCells(){
        caGenerationArrayList.clear();
        mCAGeneration.fillCACell();
    }
}
