import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by wenhang on 3/3/14.
 */
public class SolutionTest {
    private ListNode head;
    @Before
    public void setUp() throws Exception {
        int max = 10;
        head = new ListNode(0);
        ListNode curr = head;
        for (int i = 1; i < max; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSortedListToBST() throws Exception {
        Solution solution = new Solution();
        TreeNode t = solution.sortedListToBST(head);
        System.out.println("finished");
    }
}
