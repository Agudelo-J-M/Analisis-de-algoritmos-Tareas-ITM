import java.util.Arrays;

//Class of methods to solve the assign cookies problem, LeetCode 455
//the class is renamed to Solution when the code is submited to LeetCode
public class AssignCookies {

    //This method counts the biggest amount of children that can be satisfied with the cookies available
    public int findContentChildren(int[] g, int[] s) {
        //both arrays are sorted so the least greedy child and the smallest cookie are always the next candidates
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        int cookie = 0;
        while(child < g.length && cookie < s.length){
            //the greedy choice, the smallest cookie that still satisfies the child is the one assigned to him
            if(validateSize(s[cookie], g[child])){
                child++;
            }
            //a cookie too small for the current child is too small for every child left, so it's discarded
            cookie++;
        }
        return child;
    }

    //This method validates the size of the cookie against the greed factor of the child to know if he is satisfied
    private boolean validateSize(int size, int greed){
        boolean satisfies = false;
        if(size >= greed){
            satisfies = true;
        }
        return satisfies;
    }

}
