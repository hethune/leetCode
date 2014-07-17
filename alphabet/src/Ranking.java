import java.util.*;

/**
 * Created by wenhang on 3/14/14.
 */
public class Ranking {
    public static List<Character> rank(String[] input) {
        Set<Node> heads = createGraph(input);
        List<Character> rankedResult = rank(heads);
        return rankedResult;
    }

    private static List<Character> rank(Set<Node> heads) {
        List<Character> result = new ArrayList<Character>();

        while(heads.size() != 0) {
            Set<Node> nextLevel = new HashSet<Node>();
            for (Node n : heads) {
                heads.remove(n);
                result.add(n.val);
                for (Node tmp : n.outgoing) {
                    tmp.incoming.remove(n);
                    nextLevel.add(tmp);
                }
            }
            heads = nextLevel;
        }
    }

    private static Set<Node> createGraph(String[] input) {
        Set<Node> heads = new HashSet<Node>();
        Set<Node> allNodes = new HashSet<Node>();
        Map<Character, Node> map = new HashMap<Character, Node>();
        if (input.length < 2) { return heads; }
        for (int i = 0; i < input.length - 1; i++) {
            String curr = input[i];
            String next = input[i+1];
            boolean swapped = false;

            if (curr.length() > next.length()) {
                String tmp = curr;
                curr = next;
                next = tmp;
                swapped = true;
            }

            int i;
            boolean same = true;
            for (i = 0; i < curr.length(); i++) {
                char c1 = curr.charAt(i);
                char c2 = next.charAt(i);
                Node n1 = (map.containsKey(c1)) ? map.get(c1) : new Node(c1);
                Node n2 = (map.containsKey(c2)) ? map.get(c2) : new Node(c2);
                map.put(c1, n1);
                map.put(c2, n2);
                if (!heads.contains(n1) && n1.inDegree() == 0) {
                    heads.add(n1);
                }

                if (!heads.contains(n2) && n2.inDegree() == 0) {
                    heads.add(n2);
                }

                if (same) {
                    if (c1 == c2) {
                        continue;
                    }
                    same = false;
                    if (swapped) {
                        n2.outgoing.add(n1);
                        n1.incoming.add(n2);
                        if (heads.contains(n1)) {
                            heads.remove(n1);
                        }
                    } else {
                        n1.outgoing.add(n2);
                        n2.incoming.add(n1);
                        if (heads.contains(n2)) {
                            heads.remove(n2);
                        }
                    }
                }
            }

            // curr = abcd next = abcd ef
            for (; i < next.length(); i++) {
                char c1 = next.charAt(i);
                Node n1 = (map.containsKey(c1)) ? map.get(c1) : new Node(c1);
                map.put(c1, n1);
            }
        }

        return heads;
    }
}


class Node{
    char val;
    List<Node> incoming;
    List<Node> outgoing;

    Node(char v) {
        this.v = v;
    }

    int inDegree() {
        return incoming.size();
    }

    int outDegree() {
        return outgoing.size();
    }
}
