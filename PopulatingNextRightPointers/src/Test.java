import java.util.ArrayList;

/**
 * Created by wenhang on 2/10/14.
 */
public class Test {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        TreeLinkNode head = constructBinaryTree(3);
        Solution solution = new Solution();
        solution.connect(head);
        System.out.println("Finished");
    }

    private static TreeLinkNode constructBinaryTree(int level) {
        ArrayList<TreeLinkNode> nodes = new ArrayList<TreeLinkNode>();
        int numOfNodes = (int) Math.pow(2.0, 1.0 * level);
        for (int i = 0; i < numOfNodes; i++) {
            TreeLinkNode node = new TreeLinkNode(i);
            nodes.add(node);
        }
        for (int i = 0; i < (numOfNodes/2 - 1) ; i++) {
            nodes.get(i).left = nodes.get(2*i + 1);
            nodes.get(i).right = nodes.get(2*i + 2);
        }
        return nodes.get(0);
    }
}
