package KMeans;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Martin
 */
public final class ReadFile {

    public double[][] tempE;
    int lines = 0;

    //constructor
    public ReadFile() {

        this.tempE = new double[lines][lines];

        try {
            readFile();
        } catch (FileNotFoundException ex) {
        }
    }

    private void readFile() throws FileNotFoundException {

        //modulation FTW!! Here the length of the text file is checked
        String fileName = "test.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader("test.txt"))) {

            while (reader.readLine() != null) {

                lines++;
            }
            reader.close();

            tempE = new double[lines][lines];

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(null, "ERROR! The File, " + fileName
                    + ", could not be found! Please hang up and try again.", "Warning", JOptionPane.WARNING_MESSAGE);

            JOptionPane.showMessageDialog(null, "Application will now terminate", "Warning", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }

        //The buffered reader has to be recreated because there isn't a clear 
        //method of moving back to the top of the file :/
        try {
            String line;
            int temp = 0;
            String[] x;
            String[] y;

            try (BufferedReader reader = new BufferedReader(new FileReader("test.txt"))) {

                x = new String[lines]; //for the x array
                y = new String[lines]; //for the y array
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(", ");

                    x[temp] = parts[0];
                    y[temp] = parts[1];
                    temp++;

                }
                reader.close();
            }

            //now converting the String array contents to an int array. This makes it easier in findDistance
            for (int i = 0; i < x.length; i++) {

                tempE[i][0] = Integer.parseInt(x[i].trim());

            }//for x in i

            for (int j = 0; j < y.length; j++) {

                tempE[0][j] = Integer.parseInt(y[j].trim());

                //System.out.println("At index " + (j) + " the value of x and y is " + tempE[j][0] + " and " + tempE[0][j]);
            }//for j in y

        } catch (IOException ex) {

            System.out.println("ERROR! The File could not be found! Please hang up and try again.");
        }
    }

    //encapsulation. This is used as the only way of accessing the array full of entries
    public double[][] returnEXY() {

        return this.tempE;
    }
}//graphEntries
