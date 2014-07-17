import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenhang on 3/21/14.
 */
public class MagicContainers {
    public static void solve(int A, int B, int t) {
        boolean[][] pairedCache = new boolean[A + 1][B + 1];
        Node result = helper(0, 0, A, B, t, pairedCache);
        if (result == null) {
            System.out.println("No Solution");
        } else {
            while (result != null) {
                System.out.println("(" + result.a + ", " + result.b + ")");
                result = result.next;
            }
        }
    }

    private static Node helper(int a, int b, int A, int B, int t, boolean[][] cache) {
        if (a + b == t) {
            return new Node(a, b);
        }


        if (cache[a][b]) { return null; }

        cache[a][b] = true;

        Node parent = new Node(a, b);
        Node result = helper((a+b > A) ? A : a + b, (b + a - A > 0) ? b + a -A : 0, A, B, t, cache);
        if (result == null) {
            result = helper(a + b -B > 0 ? a + b - B : 0, a + b > B ? B : a + b, A, B, t, cache);
            if (result == null) {
                result = helper(a, 0, A, B, t, cache);
                if (result == null) {
                    result = helper(0, b, A, B, t, cache);
                    if (result == null) {
                        result = helper(a, B, A, B, t, cache);
                        if (result == null) {
                            result = helper(A, b, A, B, t, cache);
                            if (result == null) {
                                result = helper(A, B, A, B, t, cache);
                            }
                        }
                    }
                }
            }
        }


        if (result != null) {
            parent.next = result;
            return parent;
        }

        return null;

    }
}

class Node {
    int a;
    int b;
    Node next;
    Node(int a, int b) {
        this.a = a;
        this.b = b;
    }

}
