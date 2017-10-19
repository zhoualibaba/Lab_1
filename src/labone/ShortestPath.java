package labone;

import labone.Digraph.ENode;
import labone.Digraph.VNode;

/**
 * This is a java doc comment.
 */
public final class ShortestPath {
    /**
     * This is a java doc comment.
     */
    private ShortestPath() {
    }

    /**
     * This is a java doc comment.
     */
    static VNode[] mVexs = Digraph.mVexs;
    /**
     * This is a java doc comment.
     */
    static int vlen = mVexs.length;
    /**
     * This is a java doc comment.
     */
    static int[] minlen = new int[vlen];
    /**
     * This is a java doc comment.
     */
    static int[] visited = new int[vlen];
    /**
     * This is a java doc comment.
     */
    private static final int WEIGHT = 1000;
    /**
     * This is a java doc comment.
     */
    static int maxWeight = WEIGHT;
    /**
     * This is a java doc comment.
     */
    static int[][] path;
    /**
     * This is a java doc comment.
     */
    private static GraphViz gv = ShowDirectedGraph.gv;

    /**
     * This is a java doc comment.
     *
     * @param word 1
     * @return 1
     */
    public static int[][] getPath(final String word) {
        int[][] aPath = new int[vlen][vlen];
        int p = Digraph.getPosition(word);

        for (int i = 0; i < vlen; i++) {
            minlen[i] = maxWeight;
            visited[i] = 0;
        }

        minlen[p] = 0;
        visited[p] = 1;

        dijkstra(p, aPath);

        return aPath;
    }

    /**
     * d.
     *
     * @param p     1
     * @param aPath 1
     */
    private static void dijkstra(final int p, final int[][] aPath) {

        ENode node = mVexs[p].firstEdge;
        while (node != null) {

            int p1 = node.ivex;
            int w = node.weight;
            if (minlen[p] + w < minlen[p1]) {
                minlen[p1] = minlen[p] + w;
                for (int i = 0; i < vlen; i++) {
                    if (i == p) {
                        aPath[p1][i] = 1;
                    } else {
                        aPath[p1][i] = 0;
                    }
                }
            }
            node = node.nextEdge;
        }

        int visitWill = vlen;
        int min = maxWeight;
        for (int i = 0; i < vlen; i++) {
            if (visited[i] != 1 && minlen[i] < min) {
                min = minlen[i];
                visitWill = i;
            }
        }

        if (visitWill != vlen) {
            visited[visitWill] = 1;
            dijkstra(visitWill, aPath);
        }

    }

    /**
     * d.
     *
     * @param word 1
     * @return 1
     */
    public static String calcShortestPath(final String word) {
        String result = null;
        int p1 = Digraph.getPosition(word);
        if (p1 != -1) {
            path = getPath(word);
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < vlen; i++) {
                if (i != p1) {
                    builder.append(word).append("->").append(mVexs[i].data).append(": ").append(minlen[i]).append("\n");
                    shortpath(p1, i);
                }
            }
            result = builder.toString();
            ShowDirectedGraph.show("b");

        } else {
            result = "no " + word + " in this graph";
        }
        return result;
    }

    /**
     * 1.
     * @param p1 1
     * @param p2 1
     */
    public static void shortpath(final int p1, int p2) {
        String color = "[color = red]";
        while (p2 != p1) {
            //p2 = p1;
            for (int i = 0; i < vlen; i++) {
                if (path[p2][i] == 1) {
                    gv.changeAll(mVexs[i].data + "->"
                            + mVexs[p2].data, mVexs[i].data
                            + "->" + mVexs[p2].data + color);
                    p2 = i;
                    //shortpath = shortpath + " " + mVexs[p2].data;
                    break;
                }
            }
        }
    }

    /**
     * f.
     * @param word1 1
     * @param word2 1
     * @return 1
     */
    public static String calcShortestPath(final String word1,
                                          final String word2) {


        int p1 = Digraph.getPosition(word1);
        int p2 = Digraph.getPosition(word2);

        String result = "";

        if (p1 != -1 && p2 != -1) {
            path = getPath(word1);
            shortpath(p1, p2);
            result = word1 + "->" + word2 + ": " + minlen[p2];
            ShowDirectedGraph.show("b");
        } else if (p1 == -1 && p2 != -1) {
            result = "no " + word1 + " in this graph";
        } else if (p1 != -1 && p2 == -1) {
            result = "no " + word2 + " in this graph";
        } else {
            result = "no " + word1 + " and " + word2 + " in this graph";
        }

        return result;
    }

}
