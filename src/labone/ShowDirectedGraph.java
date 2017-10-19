package labone;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import labone.Digraph.ENode;
import labone.Digraph.VNode;

/**
 * Adds a newline to the graph's source.
 */
public class ShowDirectedGraph {
    /**
     * Adds a newline to the graph's source.
     */
    static GraphViz gv = new GraphViz();

    /**
     * 1.
     * @param mVexs 1
     * @throws IOException 1
     */
    public static void showGraph(final VNode[] mVexs) throws IOException {
        if (gv.empty() == 0) {
            gv.addln(gv.start_graph());
            int vlen = mVexs.length;
            for (int i = 0; i < vlen; i++) {
                ENode node = mVexs[i].firstEdge;
                while (node != null) {
                    String edge = mVexs[i].data + "->" + mVexs[node.ivex].data + " [label = " + node.weight + "]";
                    gv.addln(edge);
                    node = node.nextEdge;
                }

            }
            gv.addln(gv.end_graph());
        }
        //	System.out.println(gv.getDotSource());
    }

    public static void show() {
        gv.increaseDpi();   // 106 dpi
        String type = "jpg";
        //      String type = "dot";
        //      String type = "fig";    // open with xfig
        //      String type = "pdf";
        //      String type = "ps";
        //      String type = "svg";    // open with inkscape
        //      String type = "png";
        //      String type = "plain";

        String repesentationType = "dot";
        //		String repesentationType= "neato";
        //		String repesentationType= "fdp";
        //		String repesentationType= "sfdp";
        // 		String repesentationType= "twopi";
        // 		String repesentationType= "circo";

        //File out = new File("/tmp/out"+gv.getImageDpi()+"."+ type);   // Linux
        File out = new File("C:/Users/zhou/Desktop/a." + type);    // Windows
        gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), type, repesentationType), out);
        displayPic("C:/Users/zhou/Desktop/a." + type);
    }

    public static void show(String dizhi) {
        gv.increaseDpi();   // 106 dpi
        String type = "jpg";
        //      String type = "dot";
        //      String type = "fig";    // open with xfig
        //      String type = "pdf";
        //      String type = "ps";
        //      String type = "svg";    // open with inkscape
        //      String type = "png";
        //      String type = "plain";

        String repesentationType = "dot";
        //		String repesentationType= "neato";
        //		String repesentationType= "fdp";
        //		String repesentationType= "sfdp";
        // 		String repesentationType= "twopi";
        // 		String repesentationType= "circo";

        //File out = new File("/tmp/out"+gv.getImageDpi()+"."+ type);   // Linux
        File out = new File("C:/Users/zhou/Desktop/" + dizhi + "." + type);    // Windows
        gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), type, repesentationType), out);
        displayPic("C:/Users/zhou/Desktop/" + dizhi + "." + type);
//		Image array = ImageIO.read(out);
//		ImageIO.createImageOutputStream(array);
    }

    private static void displayPic(String fileName) {
        try {
            final JFrame showPictureFrame = new JFrame(fileName);
            JLabel pictureLabel = new JLabel();

            java.net.URL url = new File(fileName).toURI().toURL();
            BufferedImage img = ImageIO.read(url);

            pictureLabel.setIcon(new ImageIcon(img));
            showPictureFrame.add(pictureLabel);
            showPictureFrame.pack();

            JScrollPane scroll = new JScrollPane(pictureLabel);
            scroll.setHorizontalScrollBarPolicy(
                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // 添加竖滚动条
            scroll.setVerticalScrollBarPolicy(
                    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);  // 添加横滚动条
            showPictureFrame.add(scroll);

            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    showPictureFrame.setVisible(true);
                }
            });
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
