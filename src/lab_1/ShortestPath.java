package lab_1;

import lab_1.digraph;
import lab_1.digraph.ENode;
import lab_1.digraph.VNode;


import lab_1.GraphViz;
import lab_1.showDirectedGraph;
<<<<<<< HEAD
// 3
=======
<<<<<<< HEAD
// 2
=======
// 1
>>>>>>> C4
>>>>>>> B1
public class ShortestPath {
	static VNode mVexs[] = digraph.mVexs;
	static int vlen = mVexs.length;
	static int minlen[] = new int[vlen];
	static int visited[] = new int[vlen];
	static int Max_weight = 1000;
	static int path[][];
	private static GraphViz gv = showDirectedGraph.gv;
	
	public static int[][] Path(String word){
		int path[][] = new int[vlen][vlen];
		int p = digraph.getPosition(word);
		
		for(int i = 0; i < vlen; i++){
			minlen[i] = Max_weight; 
			visited[i] = 0;
		}
		
		minlen[p] = 0;
		visited[p] = 1;
		
		dijkstra(p,path);
		
		return path;
	}
	
	private static void dijkstra(int p , int path[][]){

		ENode node = mVexs[p].firstEdge;
		while(node != null){

			int p1 = node.ivex;
			int w = node.weight;
			if(minlen[p] + w < minlen[p1]){
				minlen[p1] = minlen[p] + w;
				for(int i = 0; i < vlen; i++){
					if(i == p){
						path[p1][i] = 1;
					}
					else path[p1][i] = 0;
				}
			}
			node = node.nextEdge;
		}
		
		int visit_will = vlen;
		int min = Max_weight;
		for(int i = 0; i < vlen; i++){
			if(visited[i] != 1 && minlen[i] < min){
				min = minlen[i];
				visit_will = i;
			}
		}
		
		if(visit_will != vlen){
			visited[visit_will] = 1;
			dijkstra(visit_will, path);
		}
		
	}
	
	public static String calcShortestPath(String word){
		String result = null;
		int p1 = digraph.getPosition(word);
		if(p1 != -1){
			path = Path(word);
			for(int i = 0; i < vlen; i++){
				if(i != p1){
					result = result + word + "->" + mVexs[i].data + ": " + minlen[i] + "\n";
					shortpath( p1, i);
				}
			}
			showDirectedGraph.show("b");

		}else{
			result = "no " + word + " in this graph";
		}
		
		return result;
	}
	
	public static void shortpath(int p1, int p2){
		String color = "[color = red]";
		while( p2 != p1 ){
			//p2 = p1;
			for(int i = 0; i < vlen ; i++){
				if(path[p2][i] == 1){
					gv.changeAll(mVexs[i].data + "->" + mVexs[p2].data, mVexs[i].data + "->" + mVexs[p2].data + color);
					p2 = i;
					//shortpath = shortpath + " " + mVexs[p2].data;
					break;
				}
			}
		}
	}
	
	public static String calcShortestPath(String word1, String word2){

		
		int p1 = digraph.getPosition(word1);
		int p2 = digraph.getPosition(word2);
		
		String result = ""; 
		
		if(p1 != -1 && p2 != -1){
			path = Path(word1);
			shortpath(p1, p2);
			result = word1 + "->" + word2 + ": " + minlen[p2];
			showDirectedGraph.show("b");
		}else if(p1 == -1 && p2 != -1){
			result = "no " + word1 + " in this graph";
		}else if(p1 != -1 && p2 == -1){
			result = "no " + word2 + " in this graph";
		}else{
			result = "no " + word1 + " and " + word2 + " in this graph"; 
		}
	
		return result;
	}
	
}
