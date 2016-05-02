package edu.neu.csye6200.ca;

/**
 * Created by Renjith.
 */
public class CACell {
    private int mState;
    private int mGeneration;
    private int mIndex;

    public CACell(int index, int state){
        mIndex = index;
        mState = state;
        mGeneration = 0;
    }
    public int getState() {
        return mState;
    }

    public void setState(int state) {
        this.mState = state;
    }

    public int getGeneration() {
        return mGeneration;
    }


    public void increaseGenerationNo() {
        ++mGeneration;
    }

    public int getIndex() {
        return mIndex;
    }


}
