import static org.junit.Assert.assertEquals;

/**
 * Created by wenhang on 3/3/14.
 */
public class SolutionTest {
    @org.junit.Test
    public void testSqrt() throws Exception {
        Solution solution = new Solution();
        assertEquals(solution.sqrt(4), 2);
        assertEquals(solution.sqrt(5), 2);
        assertEquals(solution.sqrt(9), 3);
        assertEquals(solution.sqrt(2147395600), 46340);
        assertEquals(solution.sqrt(1510227509), 38861);
    }
}
