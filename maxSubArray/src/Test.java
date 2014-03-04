/**
 * Created by wenhang on 2/9/14.
 */

import org.junit.* ;
import static org.junit.Assert.* ;

public class Test {
    public static void main(String[] args) {
       test2();
    }

    private  static void test1() {
        int[] A = { -2,1, -3,4, -1,2,1, -5,4};
        test(A);
    }

    private static void test2() {
        int[] A = { 1,2,-1,-2,2,1,-2,1 };
        test(A);
    }

    private static void test(int [] A) {
        Solution solution = new Solution();
        int result = solution.maxSubArray(A);
        System.out.println(result);
    }
}