/**
 * Created by wenhang on 3/14/14.
 */
public class MarchMadness {
    public static int calculateScores(boolean[] expected, boolean[] actual) {
        int score = 0;
        if (expected.length != actual.length) { return 0; }
        int l = expected.length;
        int[] compared = new int[l];

        for (int i = l - 1; i >= 0; i--) {
            boolean curr = (expected[i] == actual[i]);
            compared[i] = 0;
            if (curr) {
                if ((2*i + 2) >= l) { compared[i] = 1; continue; }
                compared[i] = (expected[i]) ? compared[2*i+1] : compared[2*i+2];
            }
        }

        for (int i : compared) {
            score += i;
        }

        return score;
    }

}
