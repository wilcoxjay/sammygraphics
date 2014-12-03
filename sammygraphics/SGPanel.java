package sammygraphics;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;

public class SGPanel extends JPanel {
    protected int width;
    protected int height;
    protected BufferedImage image;
    protected Graphics2D g2d;

    public SGPanel(int width, int height) {
        this.width = width;
        this.height = height;
        this.setPreferredSize(new Dimension(width, height));

        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2d = this.image.createGraphics();
        g2d.setColor(Color.RED);
        g2d.fill(new Rectangle(0,0,width,height));

        this.addMouseListener(new Adapter());
        
        new Timer(60, new Animator(this)).start();
    }

    public void increment() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int c = image.getRGB(i, j);
                image.setRGB(i, j, c+10);
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawImage(image, 0, 0, null);
        g.drawString("Hello, world!", 10, 20);
    }

    protected static class Adapter extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            Component c = e.getComponent();
            if (c instanceof SGPanel) {
                SGPanel p = (SGPanel) c;
                p.g2d.fill(new Rectangle(0,0,p.width,p.height));
                p.repaint();
            }
        }
    }

    protected static class Animator implements ActionListener {
        protected SGPanel sgp;
        
        protected SGScene scene;
        protected SGImage2d image;
        protected SGPoint3 eye;
        protected SGViewPort vp;


        public Animator(SGPanel sgp) {
            this.sgp = sgp;

            scene = new SGCornellBox();
            image = new SGImage2d(sgp.width, sgp.height);
            eye = new SGPoint3(0, 0, -1);

            vp = new SGViewPort(sgp.width, sgp.height, 
                                new SGPoint3(-0.5, 0.5, 0), new SGPoint3(0.5, -0.5, 0));
        }

        public void actionPerformed(ActionEvent e) {
            long startTime = System.currentTimeMillis();
            // for (int i = 0; i < vp.width(); i++) {
            //     for (int j = 0; j < vp.height(); j++) {
            //         SGRay r = new SGRay(eye, vp.pos(i,j));
            //         SGSurface s = scene.intersect(r);
            //         if (s != null) {
            //             SGColor c = s.shade(r.direction().negate());
            //             image.add(i,j,c);
            //         }
            //     }
            // }
            long endTime = System.currentTimeMillis();
            System.out.println("rendering frame took " + (endTime - startTime) + "ms");

            sgp.increment();

            sgp.repaint();
        }
    }

        
}
