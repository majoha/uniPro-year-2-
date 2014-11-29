package KMeans;

import KMeans.KMeans.kluster;

/**
 *
 * @author Martin
 */
public final class Maths {

    private double distance = 0;
    private double xSq = 0;
    private double xSq1 = 0;
    private double ySq = 0;
    private double ySq1 = 0;
    private double averageX = 0;
    private double averageY = 0;
    private double newKXPos = 0;
    private double newKYPos = 0;
    private int temp = 0;

    double[][] tempE;
    int[] colourArray;

    public Maths(kluster[] klusterSet, double[][] tempE, int[] colourArray) {

        this.tempE = tempE;
        findDist(klusterSet, colourArray);
    }

    //find the closest neighbour for each kluster
    public void findDist(kluster[] klusterSet, int[] colourArray) {

        for (int j = 0; j < tempE.length; j++) {

            dis(klusterSet, j);
            colourArray[j] = temp;
            klusterSet[temp].calculateNewMean(tempE[j][0], tempE[0][j]);
        }

        for (int i = 0; i < klusterSet.length; i++) {

            System.out.println("The location of kluster " + i + " is " + klusterSet[i].returnX() + " " + klusterSet[i].returnY());
        }

    }//findDistance method

    public double dis(kluster[] klusterSet, int j) {

        double tempDistance = Double.MAX_VALUE;

        temp = 0;

        for (int i = 0; i < klusterSet.length; i++) {

            xSq = ((klusterSet[i].returnX() - tempE[j][0]) * (klusterSet[i].returnX() - tempE[j][0]));
            //this is y^2
            ySq = ((klusterSet[i].returnY() - tempE[0][j]) * (klusterSet[i].returnY() - tempE[0][j]));

            distance = Math.sqrt(xSq + ySq);

            //System.out.println("The distance to " + i + " is " + distance);
            if (distance < tempDistance) {

                tempDistance = distance;
                temp = klusterSet[i].OID;
            }
        }
        return distance;
    }
}//KMeans
