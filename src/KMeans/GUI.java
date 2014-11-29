package KMeans;

import KMeans.KMeans.kluster;
import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

/**
 *
 * @author Martin
 */
public class GUI extends Canvas implements Runnable {

    public int width = 300;
    public int height = 150;
    public int scale = 2;

    private Thread thread;
    private JFrame frame;
    private boolean running = false;

    kluster[] klusterSet;
    double[][] tempE;

    int[] colourArray;

    public GUI(kluster[] klusterSet, double[][] tempE, int[] colourArray) {

        this.klusterSet = klusterSet;
        this.tempE = tempE;
        this.colourArray = colourArray;

        Dimension size = new Dimension(width * scale, height * scale);
        setPreferredSize(size);

        frame = new JFrame();
    }

    public synchronized void start() {

        running = true;
        thread = new Thread(this, "Display");
        thread.start();
    }

    public synchronized void stop() {

        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
        }
    }

    @Override
    public void run() {

        long lastTime = System.nanoTime();
        final double ns = 1000000000.0 / 30.0;
        double delta = 0;

        while (running) {

            long now = System.nanoTime();

            delta += (now - lastTime) / ns;
            lastTime = now;

            while (delta >= 1) {

                update();
                delta--;
            }
            render();
        }
        stop();
    }

    public void update() {

    }

    public void render() {

        BufferStrategy bs = getBufferStrategy();

        if (bs == null) {

            createBufferStrategy(2);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.lightGray);
        g.fillRect(0, 0, getWidth(), getHeight());

        //drawing is done here
        ////////
        for (int i = 0; i < klusterSet.length; i++) {

            if (klusterSet[i].returnC() == 0) {
                g.setColor(Color.BLUE);
            }
            if (klusterSet[i].returnC() == 1) {
                g.setColor(Color.RED);
            }
            if (klusterSet[i].returnC() == 2) {
                g.setColor(Color.WHITE);
            }

            g.drawOval((int) (klusterSet[i].returnX() * 10 + 50), (int) (-klusterSet[i].returnY() * 5 + 200), 5, 5);

            g.drawString("The position of k-mean " + i + " is X: " + klusterSet[i].returnX() + " and Y: " + klusterSet[i].returnY(), 10, 20 + i * 15);

        }

        for (int j = 0; j < tempE.length; j++) {//readFile.tempE.length

            if (colourArray[j] == 0) {
                g.setColor(Color.BLUE);
            }
            if (colourArray[j] == 1) {
                g.setColor(Color.RED);
            }
            if (colourArray[j] == 2) {
                g.setColor(Color.WHITE);
            }
            g.drawOval((int) (tempE[j][0] * 10 + 50), ((int) -tempE[0][j] * 5 + 200), 5, 5);

        }

        ///////
        g.dispose();
        bs.show();
    }

    public static void guiSetup(kluster[] klusterSet, double[][] tempE, int[] colourArray) {

        GUI gui = new GUI(klusterSet, tempE, colourArray);
        gui.frame.setResizable(false);
        gui.frame.setTitle("K-Means");
        gui.frame.add(gui);
        gui.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.frame.setLocationRelativeTo(null);
        gui.frame.setVisible(true);
        gui.frame.pack();
        gui.start();

    }

}
