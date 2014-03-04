/**
 * Created by wenhang on 2/10/14.
 */
public class Test {
    public static void main(String[] args) {
        test1(0,2);
        test1(2,4);
    }

    private static void test1(int m, int n) {
        int[] a = {1, 2, 3, 4, 5, 6};
        ListNode head = constructList(a);
        test(head, m, n);
    }


    private static ListNode constructList(int[] A) {
        ListNode head = new ListNode(A[0]);
        ListNode next = head;
        for (int i = 0; i < A.length - 1; i++) {
            next.next = new ListNode(A[i+1]);
            next = next.next;
        }
        return head;
    }

    private static void test(ListNode head, int m, int n) {
        Solution solution = new Solution();
        head = solution.reverseBetween(head, m, n);
//        head = solution.invert(head, 3);
        System.out.println("finished");
    }

}
