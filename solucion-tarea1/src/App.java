public class App {
    public static void main(String[] args) throws Exception {
        LemonadeChange lemonade = new LemonadeChange();
        AssignCookies cookies = new AssignCookies();
        //test cases taken from the examples of both LeetCode problems
        System.out.println(lemonade.lemonadeChange(new int[]{5,5,5,10,20}));
        System.out.println(lemonade.lemonadeChange(new int[]{5,5,10,10,20}));
        System.out.println(cookies.findContentChildren(new int[]{1,2,3}, new int[]{1,1}));
        System.out.println(cookies.findContentChildren(new int[]{1,2}, new int[]{1,2,3}));
    }
}
