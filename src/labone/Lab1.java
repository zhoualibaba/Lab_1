

/**
 * This is a package-info.java
 *
 * @author somebody
 */

package labone;

import java.io.*;
import java.util.Scanner;

/**
 * This is a java doc comment.
 */
@SuppressWarnings("CheckStyle")
public final class Lab1 {
    /**
     * This is a java doc comment.
     */
    private Lab1() {
    }

    /**
     * COMMENT.
     *
     * @param args a
     * @throws Exception a
     */
    public static void main(final String[] args) throws Exception {
        // TODO Auto-generated method stub
        String txtName; // 文件名
        String txtTest = ""; // 文本文档数据
        final int length = 10000;
        String[] txtWord = new String[length]; // 文本文档单词
        char txtChar; // 文本文档字符
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Please input your txt name:");
        Scanner sc = new Scanner(System.in);
        txtName = in.readLine();
        out.println(txtName);		// 获取文件名

        try { // 文本处理
            File inFile = new File(txtName);
            FileReader reader = new FileReader(inFile);
            int character = reader.read();
            while (character != -1) {
                //txt_test += (char)character;
                txtChar = (char) character;
                txtChar = Character.toLowerCase(txtChar);
                if (txtChar >= 'a' && txtChar <= 'z') {
                    txtTest += txtChar;
                } else {
                    if (txtTest.charAt(txtTest.length() - 1) != ' ') {
                        txtTest += ' ';
                    }
                }
                character = reader.read();
            }
            txtWord = txtTest.split(" ");
            out.println(txtTest);
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileStreamsTest: " + e);
        } catch (IOException e) {
            System.err.println("FileStreamsTest: " + e);
        }

        Digraph solutiondigraph = new Digraph(txtWord);
        ShowDirectedGraph.showGraph(Digraph.mVexs);
        catalog(); // 显示目录
        int choose = in.read() - '0'; // 功能选择
        in.read();
        final int overFlag = 9;
        if (choose == overFlag) {
            out.println("程序结束");
        }
        while (choose != overFlag) {
            switch (choose) {
                case 1: // 展示有向图
                    ShowDirectedGraph.show();
                    // solutiondigraph.print();
                    break;
                case 2: // 查询桥接词
                    System.out.println("请输入要查询的桥接词：");
                    String word1 = in.readLine();
                    String word2 = in.readLine();
                    String word = QueryBridgeWords.bridgeWords(word1, word2);
                    out.println(word);
                    break;
                case 3: // 根据桥接词生成新文本
                    System.out.println("请输入要添加桥接词的文本");
                    String inputText = in.readLine();
                    String newText = GenerateNewText.newtext(inputText);
                    out.println(newText);
                    break;
                case 4: // 计算最短路径
                    System.out.println("请输入要查询的单词：");
                    System.out.print("start:");
                    String w1 = in.readLine();
                    System.out.print("star:");
                    String w2 = in.readLine();
                    if (w2.equals("")) {
                        String w = ShortestPath.calcShortestPath(w1);

                        out.println(w);
                    } else {
                        String w = ShortestPath.calcShortestPath(w1, w2);

                        out.println(w);
                    }
                    break;
                case 5: // 随机遍历
                    String randomwalk = RandomWalk.randomw();
                    out.println(randomwalk);
                    break;
                default:
                    break;
            }
            catalog();
            choose = in.read() - '0';
            if (choose == overFlag) {
                out.println("程序结束");
            }
        }

    }

    // 生成目录

    /**
     * This is a java doc comment.
     */
    private static void catalog() {
        System.out.println("请输入数字选择功能：");
        System.out.println("1：展示生成的有向图");
        System.out.println("2：查询两个单词之间的桥接词");
        System.out.println("3：根据桥接词补充文本");
        System.out.println("4：查询单词之间的最短路径");
        System.out.println("5：随机遍历");
        System.out.println("9：结束程序");
    }


}
