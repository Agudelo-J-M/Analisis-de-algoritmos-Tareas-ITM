//Class of methods to solve the lemonade change problem, LeetCode 860
//the class is renamed to Solution when the code is submited to LeetCode
public class LemonadeChange {

    //This method attends the line of customers one by one and tells if all of them can get their exact change
    public boolean lemonadeChange(int[] bills) {
        //the drawer only needs to count fives and tens, a twenty is never used to give change back
        int[] drawer = new int[2];
        boolean allAttended = true;
        for (int bill : bills){
            //validation to check if the current customer can be payed to stop attending the rest of the line
            if(!validateChange(drawer, bill)){
                allAttended = false;
                break;
            }
            drawer = giveChange(drawer, bill);
        }
        return allAttended;
    }

    //This method validates the bill of the customer against the drawer to know if his change can be payed
    private boolean validateChange(int[] drawer, int bill){
        boolean canPay = true;
        //a five needs no change at all so that customer is always attended
        if(bill == 10){
            canPay = drawer[0] > 0;
        }
        //a twenty is payed with a ten and a five or with three fives, having any of the two combinations is enough
        if(bill == 20){
            canPay = (drawer[1] > 0 && drawer[0] > 0) || drawer[0] > 2;
        }
        return canPay;
    }

    /**this method takes the bill of the customer into the drawer and takes out the bills of his change,
     * the greedy decision is made here, when the customer pays with a twenty the ten is always spent first
     * because a five is useful for every posible change and a ten is only useful for this one
    */
    private int[] giveChange(int[] drawer, int bill){
        if(bill == 5){
            drawer[0]++;
            return drawer;
        }
        if(bill == 10){
            drawer[0]--;
            drawer[1]++;
            return drawer;
        }
        //the greedy choice, the combination that commits the least amount of small bills
        if(drawer[1] > 0){
            drawer[1]--;
            drawer[0]--;
        }else{
            drawer[0] -= 3;
        }
        return drawer;
    }

}
