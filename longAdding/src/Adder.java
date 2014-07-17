/**
 * Created by wenhang on 3/21/14.
 */
public class Adder {
    public static String add(String a, String b) {
        StringBuffer buf = new StringBuffer();
        if (a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }

        int carryOn = 0;
        int offSet = a.length() - b.length();

        int i;

        for (i = b.length() - 1; i >= 0; i--) {
            char c1 = a.charAt(i + offSet);
            char c2 = b.charAt(i);

            int m = Character.getNumericValue(c1);
            int n = Character.getNumericValue(c2);

            int sum = (m + n + carryOn) % 10;
            carryOn = (m + n + carryOn) / 10;

            char cResult = (char) (sum + 48);

            buf.append(cResult);

        }

        for (int j = i + offSet; j >= 0; j--) {
            char c1 = a.charAt(i + offSet);
            int m = Character.getNumericValue(c1);
            int sum = (m + carryOn) % 10;
            carryOn = (m + carryOn) / 10;
            char cResult = (char) (sum + 48);
            buf.append(cResult);
        }

        return buf.reverse().toString();
    }
}
