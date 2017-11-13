package lab1.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;
import lab_1.queryBridgeWords;
import lab_1.showDirectedGraph;
import lab_1.digraph;
import lab_1.lab1;
import lab_1.digraph;
import lab_1.randomWalk;
import lab_1.queryBridgeWords;
import lab_1.generateNewText;
import lab_1.ShortestPath;
import lab_1.showDirectedGraph;


public class newtexttest3 {

	@Test
	public void test() {
		//fail("Not yet implemented");
		String txt_name;						// 文件名			
		String txt_test = "";					// 文本文档数据
		String []txt_word = new String[10000];	// 文本文档单词
		char txt_char;							// 文本文档字符

		System.out.println("Please imput your txt name:");
		Scanner sc = new Scanner(System.in);
		txt_name = sc.nextLine();
		System.out.println(txt_name);			// 获取文件名
		
		
		try
        {	 // 文本处理
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
             reader.close();
	    }catch(FileNotFoundException e) {
    	       System.out.println("FileStreamsTest: "+e);
	    }catch(IOException e) {
	       System.err.println("FileStreamsTest: "+e);
	    }
		
		digraph solutiondigraph = new digraph(txt_word);
		try {
			showDirectedGraph.showGraph(digraph.mVexs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		generateNewText texttest = new generateNewText();
		String textresult = texttest.newtext("to a strange to is a thing i think");
		System.out.println(textresult);
		assertEquals("to is a strange to is a good thing i think",textresult);
		
	}
	
}
