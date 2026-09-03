import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        MergeSortedArray merger = new MergeSortedArray();
        SortColors colors = new SortColors();
        //test cases taken from the examples of both LeetCode problems
        //both methods work in place, so every case needs its own array to be printed after the call
        int[] firstCase = new int[]{1,2,3,0,0,0};
        merger.merge(firstCase, 3, new int[]{2,5,6}, 3);
        System.out.println(Arrays.toString(firstCase));
        int[] secondCase = new int[]{1};
        merger.merge(secondCase, 1, new int[]{}, 0);
        System.out.println(Arrays.toString(secondCase));
        int[] thirdCase = new int[]{0};
        merger.merge(thirdCase, 0, new int[]{1}, 1);
        System.out.println(Arrays.toString(thirdCase));
        int[] fourthCase = new int[]{2,0,2,1,1,0};
        colors.sortColors(fourthCase);
        System.out.println(Arrays.toString(fourthCase));
        int[] fifthCase = new int[]{2,0,1};
        colors.sortColors(fifthCase);
        System.out.println(Arrays.toString(fifthCase));
    }
}
