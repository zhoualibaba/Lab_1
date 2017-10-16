package lab_1;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import lab_1.digraph;
import lab_1.randomWalk;
import lab_1.queryBridgeWords;
import lab_1.generateNewText;
import lab_1.ShortestPath;
import lab_1.showDirectedGraph;

// C:/Users/zhou/Desktop/test.txt
// 12345
// 1
public class lab1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String txt_name;						// �ļ���			
		String txt_test = "";					// �ı��ĵ�����
		String []txt_word = new String[10000];	// �ı��ĵ�����
		char txt_char;							// �ı��ĵ��ַ�

		System.out.println("Please imput your txt name:");
		Scanner sc = new Scanner(System.in);
		txt_name = sc.nextLine();
		System.out.println(txt_name);			// ��ȡ�ļ���
		
		
		try
        {	 // �ı�����
             File inFile = new File(txt_name);
             FileReader reader = new FileReader(inFile);
             int character = reader.read();
             while(character != -1){
            	 //txt_test += (char)character;
            	 txt_char = (char)character;
            	 txt_char = Character.toLowerCase(txt_char);
            	 if(txt_char >= 'a' && txt_char <= 'z'){
            		 txt_test += txt_char; 
            	 }
            	 else{
            		 if( txt_test.charAt(txt_test.length()-1) != ' ')
            		 {
            			 txt_test += ' ';
            		 }
            	 }
            	 character = reader.read();
             }
             txt_word = txt_test.split(" ");
             System.out.println(txt_test);
             reader.close();
	    }catch(FileNotFoundException e) {
    	       System.out.println("FileStreamsTest: "+e);
	    }catch(IOException e) {
	       System.err.println("FileStreamsTest: "+e);
	    }
		
		digraph solutiondigraph = new digraph(txt_word);
		showDirectedGraph.showGraph(digraph.mVexs);
		catalog(); 						// ��ʾĿ¼
		int choose = sc.nextInt();		// ����ѡ��
		String blank = sc.nextLine();
		if(choose == 9) System.out.println("�������");
		while(choose != 9){
			switch(choose){
				case 1:		// չʾ����ͼ
					showDirectedGraph.show();
				//	solutiondigraph.print();
					break;
				case 2:		// ��ѯ�ŽӴ�
					System.out.println("������Ҫ��ѯ���ŽӴʣ�");
					String word1 = sc.nextLine();
					String word2 = sc.nextLine();					
					String word = queryBridgeWords.BridgeWords(word1, word2);
					System.out.println(word);
					break;
				case 3:		// �����ŽӴ��������ı�
					System.out.println("������Ҫ����ŽӴʵ��ı�");
					String inputText = sc.nextLine();
					String new_text = generateNewText.newtext(inputText);
					System.out.println(new_text);
					break;
				case 4:		// �������·��
					System.out.println("������Ҫ��ѯ�ĵ��ʣ�");
					System.out.print("star:");
					String w1 = sc.nextLine();
					System.out.print("stop:");
					String w2 = sc.nextLine();
					if(w2.equals("")){
						String w = ShortestPath.calcShortestPath(w1);
						 
						System.out.println(w);
					}else{
						String w = ShortestPath.calcShortestPath(w1,w2);
						
						System.out.println(w);
					}
					//System.out.println(w1+w2); 
					break;
				case 5:		// �������
					String randomwalk = randomWalk.randomw();
					System.out.println(randomwalk);
					break;
			}
			catalog();
			choose = sc.nextInt();
			blank = sc.nextLine();
			if(choose == 9) System.out.println("�������");
		}
		
	}
	// ����Ŀ¼
	private static void catalog(){
		System.out.println("����������ѡ���ܣ�");
		System.out.println("1��չʾ���ɵ�����ͼ");
		System.out.println("2����ѯ��������֮����ŽӴ�");
		System.out.println("3�������ŽӴʲ����ı�");
		System.out.println("4����ѯ����֮������·��");
		System.out.println("5���������");
		System.out.println("9����������");
	}
	
	
}
