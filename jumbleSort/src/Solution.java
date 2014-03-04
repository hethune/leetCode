/**
 * Created by wenhang on 2/23/14.
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    private static String[] originalInput;
    private static List<String> stringInput;
    private static List<Integer> numberInput;
    private static boolean[] indexString;
    private static PriorityQueue<Integer> minQueueNum;
    private static PriorityQueue<String> minQueueString;

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        readFromStd();
        processInputs();
//        mySort();
        mergeSortedResults();
    }

    private static void mergeSortedResults() {
       int i = 0, j = 0;
       for (int b = 0; b < indexString.length; b++) {
           String tmp;
           String seperator = (b == indexString.length - 1) ? "" : " ";
           if (indexString[b]) {
               tmp = minQueueString.poll();
               j++;
           } else {
               tmp = Integer.toString(minQueueNum.poll());
               i++;
           }
           System.out.print(tmp + seperator);
       }
    }

    private static void mySort() {
        Collections.sort(numberInput);
        Collections.sort(stringInput);
    }

    private static void processInputs() {
        numberInput = new ArrayList<Integer>();
        stringInput = new ArrayList<String>();
        minQueueNum = new PriorityQueue<Integer>();
        minQueueString = new PriorityQueue<String>();

        indexString = new boolean[originalInput.length];
        for (int i = 0; i <originalInput.length; i++) {
            String s = originalInput[i];
            try {
                int tmp = Integer.parseInt(s);
                minQueueNum.add(tmp);
                indexString[i] = false;
            } catch(NumberFormatException e) {
                minQueueString.add(s);
                indexString[i] = true;
            }
        }
    }

    private static void readFromStd() {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line;
        try {
            line = stdin.readLine();
            originalInput = line.split(" ");
        } catch (Exception e) {

        }
    }

    private static void outputToStd() {
        String output = new String();
        for (String s : originalInput) {
            output += s + " ";
        }

        output = output.trim();
        System.out.print(output);
    }
}