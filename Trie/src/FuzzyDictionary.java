import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenhang on 3/14/14.
 */
public class FuzzyDictionary {
    private static Node dictionary;
    private List<String> result = new ArrayList<String>();

    public List<String> findFuzzyWord(String s, int d, Node start) {

        if (d == 0) {
            traverseDictionary(start, s, result);
        }

        if (s.length() == 1) {
            for (Node n : start.children) {
                if (s.charAt(0) == n.c) {

                }
            }
        }

        // case 1: adding a letter in front of s
        for (Node n : start.children) {
            findFuzzyWord(s, d - 1, n);
        }
        // case 2: substituting a letter in s
        for (Node n : start.children) {
            if (n.c != s.charAt(0)) {
                findFuzzyWord(s.substring(1, s.length()), d - 1, n);
            } else {
                findFuzzyWord(s.substring(1,s.length()), d, n);
            }
        }
        // case 3: deleting a letter in s
        for (Node n : start.children) {
            findFuzzyWord(s.substring(1, s.length()), d - 1, start));
        }
    }
}

class Node {
    char c;
    boolean endOfWord;
    List<Node> children = new ArrayList<Node>();
    Node (char c) {
        this.c = c;
    }
}