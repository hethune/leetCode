/**
 * Created by wenhang on 3/3/14.
 */
public class SolutionTest {
    @org.junit.Test
    public void testRotateRight() throws Exception {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        Solution s = new Solution();
        s.rotateRight(head, 1);
    }
}
