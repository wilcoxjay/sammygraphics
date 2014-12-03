package sammygraphics;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SGApp {
    public void init(int width, int height) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Example GUI");
        frame.setLocationRelativeTo(null);

        SGPanel p = new SGPanel(width, height);
        frame.setContentPane(p);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

    }
    
    public static void start(final int width, final int height) {
        EventQueue.invokeLater(new Runnable() {
                public void run() {
                    (new SGApp()).init(width, height);
                }
            });
    }

    public static void main(String[] args) {
        start(600, 400);
    }
}
