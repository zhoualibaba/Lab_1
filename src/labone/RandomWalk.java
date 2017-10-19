package labone;

import java.io.FileWriter;
import java.io.IOException;

import labone.Digraph.VNode;
import labone.Digraph.ENode;

/**
 * This is a java doc comment.
 */
public final class RandomWalk {
    /**
     * This is a java doc comment.
     */
    private RandomWalk() {
    }

    /**
     * This is a java doc comment.
     *
     * @return a
     */
    public static String randomw() {
        Walk walk = new Walk();
        // �����߳���ʵ���û�ֹͣ
        System.out.println("���������'1'���ַ������������");
        walk.go.start();            // ��������߳�
        walk.stop.start();            // �û�ֹͣ�߳�
        // �ж��߳��Ƿ����
        try {
            walk.go.join();
            walk.stop.join();
        } catch (Exception e) {
            System.out.println("�߳�δ��������");
        }
        String result = Walk.randomresult;
        return result;
    }
}

/**
 * This is a java doc comment.
 */
class Walk implements Runnable {
    /**
     * This is a java doc comment.
     */
    int sleeptime = 1100, giveflag = 0;
    /**
     * This is a java doc comment.
     */
    int i, flag = 1, mVexslen, edgeslen, vexnum, edgenum, edgenumran;
    /**
     * This is a java doc comment.
     */
    static String randomresult = new String();
    /**
     * This is a java doc comment.
     */
    ENode vrandom;
    /**
     * This is a java doc comment.
     */
    Thread go, stop;

    /**
     * This is a java doc comment.
     */
    Walk() {
        go = new Thread(this);
        stop = new Thread(this);
    }

    /**
     * This is a java doc comment.
     */
    VNode[] mVexs = Digraph.mVexs;  // ����ͼ���ڽӱ�

    /**
     * This is a java doc comment.
     */
    public void run() {

        // �ж��߳�
        // ��������߳�
        final int length = 1000;
        int[][] visit = new int[length][length];
        if (Thread.currentThread() == go) {
            // ʵ���������
            // ��ʼ���ʵ��������
            mVexslen = mVexs.length;
            vexnum = (int) (Math.random() * mVexslen);          // ���һ����ʼ����
            System.out.print(mVexs[vexnum].data);
            randomresult += mVexs[vexnum].data;
            while (flag == 1) {
                // �������ʵ��������
                if (mVexs[vexnum].total == 0) {   // �ж��Ƿ�Ϊ��β����
                    flag = 0;
                } else {
                    edgeslen = mVexs[vexnum].total;
                    // ���һ���ߵĸ���
                    edgenumran = (int) (Math.random() * edgeslen);
                    vrandom = mVexs[vexnum].firstEdge;
                    if (visit[vexnum][vrandom.ivex] == 1) {
                        giveflag = 2;
                        System.out.print(" " + mVexs[vrandom.ivex].data);
                        randomresult += (" " + mVexs[vrandom.ivex].data);
                        flag = 0;
                        continue;
                    }
                    for (i = 1; i < edgenumran; i++) {
                        vrandom = vrandom.nextEdge;
                    }
                    visit[vexnum][vrandom.ivex] = 1;
                    System.out.print(" " + mVexs[vrandom.ivex].data);
                    randomresult += (" " + mVexs[vrandom.ivex].data);
                    vexnum = vrandom.ivex;
                }
                // ��������߳���Ϣ1.1��
                try {
                    Thread.sleep(sleeptime);
                } catch (Exception e) {
                    System.out.println("�ж��߳���Ϣʧ��");
                }
            }
            // �ļ�д��
            if (flag == 0) {
                FileWriter fw;
                try {
                    System.out.println("\n ��������������������ַ����ز˵�");
                    fw = new FileWriter("C:/Users/zhou/Desktop/out.txt", false);
                    fw.write(randomresult);
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // �û������߳�
        if (Thread.currentThread() == stop) {
            char stopnum = '1';
            try {
                stopnum = (char) System.in.read();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            if (stopnum != '1') {
                System.out.println("�����������");
                flag = 0;
            }
        }
    }
}
