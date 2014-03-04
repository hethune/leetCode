/**
 * Created by wenhang on 2/12/14.
 */
public class Test {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        int[] values = {10, 11, 12, 13, 14 ,15};
        int capacity = 4;

        test(values, capacity);
        capacity = 1;
        test(values, capacity);
        capacity = 0;
        test(values, capacity);

    }

    private static void test(int[] values, int capacity) {
        LRUCache cache = new LRUCache(capacity);
        for (int i = 0; i < values.length; i++) {
            cache.set(i, values[i]);
        }

        for (int i = 0; i < values.length; i++) {
            cache.get(i);
        }

        int v = cache.get(values.length/2);
        return;
    }
}
