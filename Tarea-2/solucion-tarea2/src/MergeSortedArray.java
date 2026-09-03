//Class of methods to solve the merge sorted array problem, LeetCode 88
//the class is renamed to Solution when the code is submited to LeetCode
public class MergeSortedArray {

    //This method merges both sorted runs into nums1, which already has room for the n extra values
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //the tail of each run and the last free slot of nums1, the merge is written backwards
        int first = m - 1;
        int second = n - 1;
        int slot = m + n - 1;
        while(true){
            //the run of nums2 is consumed, whatever is left of nums1 is already in its place
            if(second == -1){
                break;
            }
            //a run already consumed never wins the slot, that is what copies the leftovers of nums2 by itself
            if(first >= 0 && takesSlot(nums1[first], nums2[second])){
                nums1[slot] = nums1[first];
                first--;
            }else{
                nums1[slot] = nums2[second];
                second--;
            }
            slot--;
        }
    }

    //This method validates the tail of nums1 against the tail of nums2 to know which value goes in the slot
    private boolean takesSlot(int nums1Value, int nums2Value){
        boolean takes = false;
        //the bigger tail takes the slot, that way no value of nums1 is overwritten before being read
        if(nums1Value > nums2Value){
            takes = true;
        }
        return takes;
    }

}
