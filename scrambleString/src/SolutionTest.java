import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by wenhang on 3/3/14.
 */
public class SolutionTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testIsScramble() throws Exception {
        String s1 = "great";
        String s2 = "rgeat";
        Solution solution = new Solution();
        assertTrue(solution.isScramble(s1, s2));
        s2 = "rgtae";
        assertTrue(solution.isScramble(s1, s2));
        s1 = "abcd";
        s2 = "bdac";
        assertFalse(solution.isScramble(s1, s2));
        s2 = "dbac";
        assertTrue(solution.isScramble(s1, s2));
    }
}
