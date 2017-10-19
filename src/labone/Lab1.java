

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
        String txtName; // �ļ���
        String txtTest = ""; // �ı��ĵ�����
        final int length = 10000;
        String[] txtWord = new String[length]; // �ı��ĵ�����
        char txtChar; // �ı��ĵ��ַ�
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Please input your txt name:");
        Scanner sc = new Scanner(System.in);
        txtName = in.readLine();
        out.println(txtName);		// ��ȡ�ļ���

        try { // �ı�����
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
        catalog(); // ��ʾĿ¼
        int choose = in.read() - '0'; // ����ѡ��
        in.read();
        final int overFlag = 9;
        if (choose == overFlag) {
            out.println("�������");
        }
        while (choose != overFlag) {
            switch (choose) {
                case 1: // չʾ����ͼ
                    ShowDirectedGraph.show();
                    // solutiondigraph.print();
                    break;
                case 2: // ��ѯ�ŽӴ�
                    System.out.println("������Ҫ��ѯ���ŽӴʣ�");
                    String word1 = in.readLine();
                    String word2 = in.readLine();
                    String word = QueryBridgeWords.bridgeWords(word1, word2);
                    out.println(word);
                    break;
                case 3: // �����ŽӴ��������ı�
                    System.out.println("������Ҫ����ŽӴʵ��ı�");
                    String inputText = in.readLine();
                    String newText = GenerateNewText.newtext(inputText);
                    out.println(newText);
                    break;
                case 4: // �������·��
                    System.out.println("������Ҫ��ѯ�ĵ��ʣ�");
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
                case 5: // �������
                    String randomwalk = RandomWalk.randomw();
                    out.println(randomwalk);
                    break;
                default:
                    break;
            }
            catalog();
            choose = in.read() - '0';
            if (choose == overFlag) {
                out.println("�������");
            }
        }

    }

    // ����Ŀ¼

    /**
     * This is a java doc comment.
     */
    private static void catalog() {
        System.out.println("����������ѡ���ܣ�");
        System.out.println("1��չʾ���ɵ�����ͼ");
        System.out.println("2����ѯ��������֮����ŽӴ�");
        System.out.println("3�������ŽӴʲ����ı�");
        System.out.println("4����ѯ����֮������·��");
        System.out.println("5���������");
        System.out.println("9����������");
    }


}
