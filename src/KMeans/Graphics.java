//package KMeans;
//
//import KMeans.KMeans.kluster;
//import java.awt.Color;
//import java.awt.Dimension;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
///**
// *
// * @author Martin
// */
//public class Graphics {
//
//    int temp;
//    private DrawingBase canvas;
//    ReadFile readFile = new ReadFile();
//
//    public Graphics(kluster[] klusterSet, int[][] tempE) {
//
//    }
//
//    public void displayGUI(kluster[] klusterSet, int[][] tempE) {
//
//        JFrame frame = new JFrame("KMeans");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        canvas = new DrawingBase();
//
//        canvas.setValues(klusterSet, tempE);
//
//        frame.setContentPane(canvas);
//        frame.pack();
//        frame.setLocationByPlatform(true);
//        frame.setVisible(true);
//
//    }
//
//    class DrawingBase extends JPanel {
//
//        private int x = 0;
//        private int y = 0;
//        public double temp1X;
//        public double temp1Y;
//        public double temp2X;
//        public double temp2Y;
//        public double temp3X;
//        public double temp3Y;
//        public int scale = 10;
//
//        DrawingBase() {
//
//        }
//
//        public void setValues(kluster[] klusterSet, int[][] tempE) {
//
//            this.temp1X = klusterSet[0].returnX();//blue
//            this.temp1Y = klusterSet[0].returnY();
//            //this.temp2X = klusterSet[1].returnX();//orange
//            //this.temp2Y = klusterSet[1].returnY();
//            //this.temp3X = klusterSet[2].returnX();//green
//            //this.temp3Y = klusterSet[2].returnY();
//
//        }
//
//        @Override
//        public Dimension getPreferredSize() {
//            return (new Dimension(500, 400));
//        }
//
//        @Override
//        public void paintComponent(java.awt.Graphics g) {
//            super.paintComponent(g);
//
//            for (int i = 0; i < readFile.tempE.length; i++) {//readFile.tempE.length
//
//                g.setColor(Color.red);
//                g.drawOval((readFile.tempE[i][0] * 10 + 50), (-readFile.tempE[0][i] * 5 + 200), 5, 5);
//
//            }
//
//            g.setColor(Color.blue);
//            g.drawOval((int) (temp1X * 10 + 50), (int) (-temp1Y * 5 + 200), 3, 3);
//            //g.setColor(Color.ORANGE);
//            //g.drawOval((int) (temp2X * 10 + 50), (int) (-temp2Y * 5 + 200), 3, 3);
//            //g.setColor(Color.green);
//            //g.drawOval((int) (temp3X * 10 + 50), (int) (-temp3Y * 5 + 200), 3, 3);
//        }
//    }
//}
