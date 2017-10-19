package labone;

import labone.Digraph.ENode;
import labone.Digraph.VNode;

/**
 * This is a java doc comment.
 */
public final class QueryBridgeWords {
    /**
     * This is a java doc comment.
     */
    private QueryBridgeWords() {
    }

    // 桥接词查询
    /**
     * This is a java doc comment.
     */
    static VNode[] mVexs = Digraph.mVexs;

    /**
     * d.
     *
     * @param word1 a
     * @param word2 a
     * @return a
     */
    public static String getBridgeWords(String word1, String word2) {
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();

        int p1 = Digraph.getPosition(word1);
        int p2 = Digraph.getPosition(word2);

        String bridge = null;
        if (p1 >= 0 && p2 >= 0) {
            ENode node1 = mVexs[p1].firstEdge;
            ENode node2;
            StringBuilder builder = new StringBuilder();
            while (node1 != null) {
                int p = node1.ivex;
                node2 = mVexs[p].firstEdge;
                while (node2 != null) {
                    int p3 = node2.ivex;
                    if (p3 == p2) {
                        builder.append(mVexs[p].data).append(" ");
                        break;
                    }
                    node2 = node2.nextEdge;
                }
                node1 = node1.nextEdge;
            }
            bridge = builder.toString();
        }
        return bridge;
    }

    /**
     * 1.
     * @param word1 1
     * @param word2 1
     * @return 1
     */
    public static String bridgeWords(String word1, String word2) {

        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();

        int p1 = Digraph.getPosition(word1);
        int p2 = Digraph.getPosition(word2);

        String bridge = getBridgeWords(word1, word2);
        if (p1 >= 0 && p2 >= 0) {

            String[] bridgelist = getbridgeword(bridge);
            if (bridge.equals("")) {
                bridge = "No bridge words from \"" + word1
                        + "\" to \"" + word2 + "\"!";
            } else if (bridgelist.length == 1) {
                bridge = "The bridge words from \"" + word1 + "\" to \""
                        + word2 + "\" is: " + bridgelist[0];
            } else {
                bridge = "The bridge words from \"" + word1 + "\" to \""
                        + word2 + "\" are: ";
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < bridgelist.length; i++) {
                    builder.append(bridgelist[i]).append(" ");
                }
                bridge += builder.toString();
            }
        } else if (p1 < 0 && p2 < 0) {
            bridge = "No \"" + word1 + "\" and \"" + word2 + "\" in the graph!";
        } else if (p1 < 0) {
            bridge = "No \"" + word1 + "\" in the graph!";
        } else if (p2 < 0) {
            bridge = "No \"" + word2 + "\" in the graph!";
        }

        return bridge;
    }

    // 切割生成桥接词字符串数组

    /**
     * d.
     * @param bridgeword 1
     * @return 1
     */
    public static String[] getbridgeword(final String bridgeword) {
        final int length = 1000;
        String[] bridges;
        bridges = bridgeword.split(" ");
        return bridges;
    }

}
