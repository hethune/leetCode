import java.util.Arrays;

/**
 * You are given a function mergeArrays which takes in 2 sorted arrays as parameters. The first array has 'M' elements in it,
 * the second one also has 'M' elements, but it's capacity is 2*M. The function mergeArrays takes both the arrays as parameters
 * along with M. You are supposed to merge both the arrays into the second array such that the resulting array is sorted.
 * The section of the program which parses the input and displays the output will be handled by us.
 * Your task is to complete the body of the function or method provided, and to return the correct output.
 * Created by wenhang on 2/27/14.
 */
public class Solution {
    /* Write your custom functions here */
    static void mergeArray(int []a, int []b, int M ) {
        if (b.length < 2 * M) {
            System.err.println("B is not large enough");
            System.exit(1);
        }
        int[] c = new int[a.length];
        for (int i = 0; i < c.length; i++) {
            c[i] = b[i];
        }
        Arrays.sort(a);
        Arrays.sort(c);
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < c.length) {
            while (i < a.length && j < c.length && a[i] < c[j]) {
                b[k] = a[i];
                k++;
                i++;
            }
            while (i < a.length && j < c.length && a[i] == c[j]) {
                b[k] = a[i];
                k++;
                b[k] = c[j];
                i++;
                j++;
                k++;
            }
            while (i < a.length && j < c.length && a[i] > c[j]) {
                b[k] = c[j];
                j++;
                k++;
            }
        }

        while (i < a.length) {
            b[k] = a[i];
            k++;
            i++;
        }

        while (j < c.length) {
            b[k] = c[j];
            k++;
            j++;
        }
    }
}
