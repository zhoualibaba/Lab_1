/**
 * This is a package-info.java
 *
 * @author somebody
 */

package labone;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * This is a java doc comment.
 */
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

        System.out.println("Please imput your txt name:");
        Scanner sc = new Scanner(System.in);
        txtName = sc.nextLine();
        System.out.println(txtName); // ��ȡ�ļ���

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
            System.out.println(txtTest);
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileStreamsTest: " + e);
        } catch (IOException e) {
            System.err.println("FileStreamsTest: " + e);
        }

        Digraph solutiondigraph = new Digraph(txtWord);
        ShowDirectedGraph.showGraph(Digraph.mVexs);
        catalog(); // ��ʾĿ¼
        int choose = sc.nextInt(); // ����ѡ��
        String blank = sc.nextLine();
        final int overFlag = 9;
        if (choose == overFlag) {
            System.out.println("�������");
        }
        while (choose != overFlag) {
            switch (choose) {
                case 1: // չʾ����ͼ
                    ShowDirectedGraph.show();
                    // solutiondigraph.print();
                    break;
                case 2: // ��ѯ�ŽӴ�
                    System.out.println("������Ҫ��ѯ���ŽӴʣ�");
                    String word1 = sc.nextLine();
                    String word2 = sc.nextLine();
                    String word = QueryBridgeWords.bridgeWords(word1, word2);
                    System.out.println(word);
                    break;
                case 3: // �����ŽӴ��������ı�
                    System.out.println("������Ҫ����ŽӴʵ��ı�");
                    String inputText = sc.nextLine();
                    String newText = GenerateNewText.newtext(inputText);
                    System.out.println(newText);
                    break;
                case 4: // �������·��
                    System.out.println("������Ҫ��ѯ�ĵ��ʣ�");
                    System.out.print("star:");
                    String w1 = sc.nextLine();
                    System.out.print("stop:");
                    String w2 = sc.nextLine();
                    if (w2.equals("")) {
                        String w = ShortestPath.calcShortestPath(w1);

                        System.out.println(w);
                    } else {
                        String w = ShortestPath.calcShortestPath(w1, w2);

                        System.out.println(w);
                    }
                    //System.out.println(w1+w2);
                    break;
                case 5: // �������
                    String randomwalk = RandomWalk.randomw();
                    System.out.println(randomwalk);
                    break;
                default:
                    break;
            }
            catalog();
            choose = sc.nextInt();
            blank = sc.nextLine();
            if (choose == overFlag) {
                System.out.println("�������");
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
