package KMeans;

import java.util.Random;
import javax.swing.JOptionPane;

/*
 *@author Martin
 */
public class KMeans {

    public static kluster[] KlusterSet;
    public Maths maths;
    static final ReadFile readFile = new ReadFile();

    static int[] colourArray;

    //constructor
    public KMeans() {
    }

    //this makes the klusters
    private static void klusterMake(int klusters) {

        Random random = new Random();
        //create an 1-D array for the kluster objects
        KlusterSet = new kluster[klusters];

        //With the array, size klusters, we fill each index with a new kluster class and give that some random co-ords
        for (int i = 0; i < klusters; i++) {

            KlusterSet[i] = new kluster((random.nextInt(19) + 1), random.nextInt(19) + 1, i);
        }

    }

    //this is the kluster class
    public static class kluster {

        private double x = this.x;
        private double y = this.y;
        private int n = 0;
        private double dis = 0;

        public int OID = this.OID;

        //constructor
        kluster(double x, double y, int OID) {

            this.x = x;
            this.y = y;
            this.OID = OID;

            System.out.println("The X coord is " + this.x + ", the Y coord is " + this.y + " and the Object ID is " + this.OID);
        }

        void calculateNewMean(double eX, double eY) {

            double tempx = (eX + (n * x));
            double tempy = (eY + (n * y));

            tempx /= n + 1;
            tempy /= n + 1;

            n += 1;

            setX(tempx);
            setY(tempy);

        }

        public int returnC() {

            return this.OID;
        }

        private void setX(double x) {

            this.x = x;

        }

        private void setY(double y) {

            this.y = y;
        }

        public double returnX() {

            return this.x;
        }

        public double returnY() {

            return this.y;
        }
    }

    public static void main(String args[]) {

        String temp = JOptionPane.showInputDialog("How many clusters?");
        int klusters = Integer.parseInt(temp);
        klusterMake(klusters);
        colourArray = new int[readFile.tempE.length];
        Maths maths = new Maths(KlusterSet, readFile.tempE, colourArray);
        GUI.guiSetup(KlusterSet, readFile.tempE, colourArray);

    }
}
