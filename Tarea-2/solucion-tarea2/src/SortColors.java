//Class of methods to solve the sort colors problem, LeetCode 75
//the class is renamed to Solution when the code is submited to LeetCode
public class SortColors {

    //This method sorts the three colors in place with a single pass over the array
    public void sortColors(int[] nums) {
        //the array is split in sections, reds before low, blues after high, the unknown values at mid
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while(true){
            //every value is already inside its own section
            if(mid > high){
                break;
            }
            if(nums[mid] == 0){
                //a red belongs at the start, it is sent behind low and both indexes move forward
                swap(nums, low, mid);
                low++;
                mid++;
            }else if(nums[mid] == 1){
                //a white is already in the middle section, so only mid moves forward
                mid++;
            }else if(nums[mid] == 2){
                //a blue goes to the end, the value received from high was never read so mid stays
                swap(nums, mid, high);
                high--;
            }else{
                //the input array was invalid, only the three colors are expected
                break;
            }
        }
    }

    //This method exchanges two values of the array to move them into their sections
    private void swap(int[] nums, int left, int right){
        //a value that already sits in its section is not exchanged with itself
        if(left == right){
            return;
        }
        int held = nums[left];
        nums[left] = nums[right];
        nums[right] = held;
    }

}
