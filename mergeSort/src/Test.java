/**
 * Created by wenhang on 2/27/14.
 */
public class Test {
    public static void main(String[] args) {
        int[] a = new int[]{3,5,6,9,12,14,18,20,25,28};
        int m = a.length;
        int[] tmp = new int[]{30,32,34,36,38,40,42,44,46,48};
        int[] b = new int[m*2];
        for (int i = 0; i < tmp.length; i++) {
            b[i] = tmp[i];
        }
        Solution.mergeArray(a, b, m);
        System.out.println("Finished");
    }
}
