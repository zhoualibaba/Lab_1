package labone;

/**
 * Java Doc.
 */
public class Digraph {

    //Graph<int> a = new Graph();
    // ��
    /**
     * Java Doc.
     */
    public class ENode {
        /**
         * Java Doc.
         */
        int ivex;    // ָ�򶥵�
        /**
         * Java Doc.
         */
        int weight;  // Ȩֵ
        /**
         * Java Doc.
         */
        ENode nextEdge;
    }

    // ����
    /**
     * Java Doc.
     */
    public class VNode {
        /**
         * Java Doc.
         */
        String data;
        /**
         * Java Doc.
         */
        int total;
        /**
         * Java Doc.
         */
        ENode firstEdge;
    }

    /**
     * Java Doc.
     */
    public static VNode[] mVexs; // �ڽӱ�

    // �����ڽӱ�
    /**
     * Java Doc.
     * @param s description
     */
    public Digraph(final String[] s) {
        final int length = 1000;
        String[] vexs = new String[length];
        String[][] edges = new String[length][2];

        int slen = s.length;
        int vlen = 0;
        int elen = 0;
        int flag = 0;
        for (int i = 0; i < slen - 1; i++) {
            edges[i][0] = s[i];
            edges[i][1] = s[i + 1];
            elen++;
        }
        for (int i = 0; i < slen; i++) {
            flag = 0;
            for (int j = 0; j < vlen; j++) {
                if (vexs[j].equals(s[i])) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                vexs[vlen] = s[i];
                vlen++;
            }
        }


        mVexs = new VNode[vlen];

        // ��ʼ�� ����
        for (int i = 0; i < mVexs.length; i++) {
            mVexs[i] = new VNode();
            mVexs[i].data = vexs[i];
            mVexs[i].total = 0;
            mVexs[i].firstEdge = null;
        }

        //��ʼ�� ��
        for (int i = 0; i < elen; i++) {

            // ��ȡ�ߵ���ʼ����ͽ�������
            String s1 = edges[i][0];
            String s2 = edges[i][1];

            // ��ȡ�ߵ���ʼ����ͽ�������
            int p1 = getPosition(s1);
            int p2 = getPosition(s2);

            //��ӱ�
            addEdge(p1, p2);
        }
    }

    // ���ض����λ��
    /**
     * Java Doc.
     * @return a
     * @param s d
     */
    public static int getPosition(final String s) {
        for (int i = 0; i < mVexs.length; i++) {
            if (mVexs[i].data.equals(s)) {
                return i;
            }
        }
        return -1;
    }

    // ��ӱ�

    /**
     * a.
     * @param p1 a
     * @param p2 a
     */
    private void addEdge(final int p1, final int p2) {

        // ��ʼ����
        ENode node2 = new ENode();
        node2.ivex = p2;
        node2.weight = 1;
        node2.nextEdge = null;

        // �жϸñ��Ƿ��Ѿ�����
        ENode node1 = mVexs[p1].firstEdge;
        if (node1 == null) {
            mVexs[p1].firstEdge = node2;
            mVexs[p1].total++;
        } else {
            while ((node1.nextEdge != null) && (node1.ivex != p2)) {
                node1 = node1.nextEdge;
            }
            if (node1.ivex == p2) {
                node1.weight++;
            } else {
                node1.nextEdge = node2;
                mVexs[p1].total++;
            }
        }
    }
}
