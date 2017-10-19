package lab_1;

public class digraph {
    //Graph<int> a = new Graph();
    // ��
    public class ENode {
        int ivex;    // ָ�򶥵�
        int weight;  // Ȩֵ
        ENode nextEdge;
    }

    // ����
    public class VNode {
        String data;
        int total;
        ENode firstEdge;
    }


    public static VNode[] mVexs; // �ڽӱ�

    // �����ڽӱ�
    public digraph(String S[]) {

        String vexs[] = new String[1000];
        String edges[][] = new String[1000][2];

        int slen = S.length;
        int vlen = 0;
        int elen = 0;
        int flag = 0;
        for (int i = 0; i < slen - 1; i++) {
            edges[i][0] = S[i];
            edges[i][1] = S[i + 1];
            elen++;
        }
        for (int i = 0; i < slen; i++) {
            flag = 0;
            for (int j = 0; j < vlen; j++) {
                if (vexs[j].equals(S[i])) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                vexs[vlen] = S[i];
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
    public static int getPosition(String s) {
        for (int i = 0; i < mVexs.length; i++) {
            if (mVexs[i].data.equals(s)) {
                return i;
            }
        }
        return -1;
    }

    // ��ӱ�
    private void addEdge(int p1, int p2) {

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
