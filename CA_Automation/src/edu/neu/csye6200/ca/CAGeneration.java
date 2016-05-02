package edu.neu.csye6200.ca;

import java.util.Random;

/**
 * Created by Renjith.
 */
class CAGeneration {
    private CACell[] caCells;
    private Random random;

    CAGeneration() {
        caCells = new CACell[64];
        random = new Random();
        fillCACell();
        printCaCells();
    }

    public void fillCACell() {
        for (int i = 0; i < caCells.length; i++) {
            if (i == caCells.length / 2) {
                caCells[i] = new CACell(i, 1);
            } else {
                caCells[i] = new CACell(i, 0);
            }
        }
    }
        
        
    CACell[] getCaCells() {
        return caCells;
    }

    void setCaCells(CACell[] caCells) {
        this.caCells = caCells;
    }

    void printCaCells() {
        for (CACell caCell : caCells) {
            if (caCell.getState() == 0)
                System.out.print("  ");
            else if (caCell.getState() == 1)
                System.out.print("* ");
            else if (caCell.getState() == 2)
                System.out.print("+ ");

        }
        System.out.println();
    }
}
