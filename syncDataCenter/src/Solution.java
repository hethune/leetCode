/**
 * Created by wenhang on 2/23/14.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static Map<Integer, Map<Integer, Boolean>> dataSetToCenterId;
    private static int tot;

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        readFromStd();
        copy();
    }

    private static void copy() {
        for (Integer i : dataSetToCenterId.keySet()) {
            Map<Integer, Boolean> curMap = dataSetToCenterId.get(i);
            for (int j = 0; j < tot; j++) {
                if (!curMap.containsKey(j)) {
                   int  origId = 0;
                   for (Integer tmp : curMap.keySet()) {
                       origId = tmp;
                       break;
                   }
                    System.out.println(i + " " + (origId + 1) + " " + (j + 1));
                }
            }
        }
        System.out.print("done");
    }

    private static void readFromStd() {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line;
        try {
            line = stdin.readLine();
            tot = Integer.parseInt(line);

            dataSetToCenterId = new HashMap<Integer, Map<Integer, Boolean>>();

            for (int i = 0; i < tot; i++) {
                line = stdin.readLine();
                String[] numberAsString = line.split(" ");
                ArrayList<Integer> numbers = new ArrayList<Integer>(numberAsString.length);
                numbers.add(i);
                for (int j = 1; j < numberAsString.length; j++) {
                    int setId = Integer.valueOf(numberAsString[j]).intValue();
                    numbers.add(Integer.valueOf(numberAsString[j]).intValue());
                    if (!dataSetToCenterId.containsKey(setId)) {
                        Map<Integer, Boolean> tmp = new HashMap<Integer, Boolean>();
                        tmp.put(i, true);
                        dataSetToCenterId.put(setId, tmp);
                    } else {
                        dataSetToCenterId.get(setId).put(i, true);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e.getStackTrace());
            System.exit(1);
        }
    }

}
