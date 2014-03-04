/**
 * Created by wenhang on 2/23/14.
 */
import java.io.*;

public class Solution {
    private static int tot;
    private static int[] numbers;
    private static int missedNumber;
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        readFromStd();
        process();
        outToStd();
    }

    private static void process() {
        if (tot <= 2 || numbers.length <= 2) { return; }
        int diff1 = numbers[1] - numbers[0];
        int diff2 = numbers[2] - numbers[1];
        int diff = (diff1 > diff2) ? diff2 : diff1;

        for (int i = 1; i < numbers.length; i++) {
            int expected = numbers[i - 1] + diff;
            if (numbers[i] > expected) {
                missedNumber = expected;
                return;
            }
        }

        return;
    }

    private static void readFromStd() {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line;
        try {
            line = stdin.readLine();
            tot = Integer.parseInt(line);

            line = stdin.readLine();
            String[] numberAsString = line.split(" ");
            numbers = new int[numberAsString.length];
            for (int i = 0; i < numberAsString.length; i++) {
                numbers[i] = Integer.valueOf(numberAsString[i]).intValue();
            }
        } catch (Exception e) {

        }
    }

    private static void outToStd() {
        System.out.println(missedNumber);
    }
}