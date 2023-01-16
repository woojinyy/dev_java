package solo;
import javax.swing.*;
import java.awt.*;
public class BackTest extends JFrame {
   String imgPath = "C:\\VsCode-Java2022\\junit5-2022\\dev_java1\\app\\src\\main\\java\\dev_java1\\images\\banana\\";
   ImageIcon iicon = new ImageIcon(imgPath + "main.png");
   Container con = this.getContentPane();

   public BackTest() {
      // setUndecorated(true);
      // AWTUtilities.setWindowOpaque(this, false);
      // this.setContentPane(mp);
      final JTextPane textPane = new JTextPane();
      textPane.setOpaque(false);
      JScrollPane jsp = new JScrollPane();

      JViewport viewport = new JViewport() {
         @Override
         protected void paintComponent(Graphics g) {
            Image img = iicon.getImage(); //
            // Image grayImage = GrayFilter.createDisabledImage(img);
            setOpaque(false);
            Graphics2D gd = (Graphics2D) g;
            gd.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
            g.drawImage(img, 0, 0, this);
            super.paintComponent(g);
         }
      };
      // viewport.setOpaque(false);
      jsp.setOpaque(true);
      jsp.setViewport(viewport);
      jsp.setViewportView(textPane);

      // mp.add("Center",jsp);
      con.add(jsp);
      // frame.pack();
      this.setSize(350, 600);
      // con.setLocationRelativeTo(null);
      this.setVisible(true);
   }

   public static void main(String[] args) {
      new BackTest();
   }
}

