/**
 * Created by wenhang on 2/28/14.
 */
public class Test {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(-3);
        Solution solution = new Solution();
        System.out.print(solution.maxPathSum(t.right));
    }
}
