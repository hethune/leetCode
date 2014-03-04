/**
 * Created by wenhang on 2/10/14.
 */
public class Test {
    public static void main(String[] args) {
        int n = 43;
//        if (args[0] != null) { n = Integer.parseInt(args[0]); }
        test1(n);
        test2(n);

    }

    public static void test1(int n) {
        Solution solution = new Solution();
        long start = System.currentTimeMillis();
        int ways = solution.climbStairs(n);
        long end = System.currentTimeMillis();
        long time = end -start;
        System.out.println("Method 1 costs " + time + " ms" );
        System.out.println(ways);
    }

    public static void test2(int n) {
        Solution solution = new Solution();
        long start = System.currentTimeMillis();
        int ways = solution.climbStairs2(n);
        long end = System.currentTimeMillis();
        long time = end -start;
        System.out.println("Method 2 costs " + time + " ms" );
        System.out.println(ways);
    }
}
