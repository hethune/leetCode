/**
 * Created by wenhang on 2/9/14.
 */
public class Test {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        int [] a = {1, 1, 2, 2, 3};
        int [] b = {1};
        Solution solution = new Solution();
        int repeatedNumber = solution.singleNumber(a);
        System.out.println(repeatedNumber);
        repeatedNumber = solution.singleNumber(b);
        System.out.println(repeatedNumber);
    }

}
