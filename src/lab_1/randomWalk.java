package lab_1;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.Runnable;
import java.lang.Thread;
import lab_1.digraph;
import lab_1.digraph.VNode;
import lab_1.digraph.ENode;

<<<<<<< HEAD
// 2
=======
// 1
>>>>>>> C4
public class randomWalk {
	public static String randomw() {
		Walk walk = new Walk();
		// �����߳���ʵ���û�ֹͣ
		System.out.println("���������'1'���ַ������������");
		walk.go.start();			// ��������߳�
		walk.stop.start();			// �û�ֹͣ�߳�
		// �ж��߳��Ƿ����
		try{
			walk.go.join();
			walk.stop.join();
		}catch(Exception e){
			System.out.println("�߳�δ��������");
		}
		String result = Walk.randomresult;
		return result;
		}
}
class Walk implements Runnable {
	int sleeptime = 1100,giveflag = 0;
	int i,flag = 1,mVexslen,edgeslen,vexnum,edgenum,edgenumran;
	static String randomresult = new String();
	
	ENode vrandom;
	Thread go,stop;
	
	Walk() {
		go = new Thread(this);
		stop = new Thread(this);
	}

	VNode[] mVexs = digraph.mVexs;  // ����ͼ���ڽӱ�
	public void run() {
		
		// �ж��߳�
		// ��������߳�
		int visit[][] = new int[1000][1000];
		if (Thread.currentThread() == go){
			// ʵ���������
			// ��ʼ���ʵ��������
			mVexslen = mVexs.length;
			vexnum = (int) (Math.random() * mVexslen); 			// ���һ����ʼ����
			System.out.print(mVexs[vexnum].data);
			randomresult += mVexs[vexnum].data;
			while(flag == 1){
			// �������ʵ��������
				if(mVexs[vexnum].total == 0){   // �ж��Ƿ�Ϊ��β����
					flag = 0;
				}else{
					edgeslen = mVexs[vexnum].total;
					edgenumran = (int) (Math.random() * edgeslen); // ���һ���ߵĸ���
					vrandom = mVexs[vexnum].firstEdge;
					if(visit[vexnum][vrandom.ivex] == 1){
						giveflag = 2;
						System.out.print(" " + mVexs[vrandom.ivex].data);
						randomresult += (" " + mVexs[vrandom.ivex].data);
						flag = 0;
						continue;
					}
					for(i = 1;i < edgenumran;i++){
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
			if(flag == 0){
				FileWriter fw;
				try {
					System.out.println("\n ��������������������ַ����ز˵�");
					fw = new FileWriter ("C:/Users/zhou/Desktop/out.txt",false);
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
				stopnum = (char)System.in.read();
			} catch (IOException e1) {
				e1.printStackTrace();
			}	
			if(stopnum != '1'){
				System.out.println("�����������");
				flag = 0;
			}
		}
	}
}
