package edu.neu.csye6200.ca;

/**
 * Created by Renjith.
 */
class CARule {
    private static int[] ruleset1 = {0, 1, 0, 1, 2, 0, 0};
    private static int[] ruleset2 = {0, 1, 2, 0, 2, 0, 0};
    private static int[] ruleset3 = {2, 2, 1, 2, 1, 1, 1};
    private static int[] ruleset = ruleset1;

    static void setRule(int rule) {
        switch (rule){
            case 1:
                ruleset = ruleset1;
                break;
            case 2:
                ruleset = ruleset2;
                break;
            case 3:
                ruleset = ruleset3;
                break;
            default:
                break;
        }

    }

    static int getNextState(int left, int middle, int right) {
        //return ruleAvg(left, middle, right);
        return ruleUsingRuleSet(left, middle, right);
    }

    private static int ruleUsingRuleSet(int left, int middle, int right) {
        int index = left + middle + right;
        return ruleset[index];
    }

}
