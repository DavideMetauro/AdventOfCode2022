package day8;
import java.io.BufferedReader;
import java.io.FileReader;

public class day8_1 {
    private static final int DIM = 99;

    public static void main(String[] args) {
        // -----time-----
        long startTime = System.nanoTime();
        // -----time-----

        try {
            FileReader fileReader = new FileReader("/Users/davidemetauro/Documents/Advent/input_8.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            int m[][] = new int[DIM][DIM];
            int count = 0;
            boolean visible = true;
            for (int i = 0; i < DIM; i++) {
                String line = reader.readLine();
                for (int j = 0; j < DIM; j++) {
                    m[i][j] = Character.getNumericValue(line.charAt(j));
                }
            }
            for (int i = 0; i < DIM; i++) {
                for (int j = 0; j < DIM; j++) {
                    // col verso sinistra
                    for (int k = j - 1; k >= 0 && visible; k--) {
                        if (m[i][k] >= m[i][j]) {
                            visible = false;
                        }
                    }
                    if (visible) {
                        count++;
                        continue;
                    }
                    visible = true;
                    // row verso l'alto
                    for (int k = i - 1; k >= 0 && visible; k--) {
                        if (m[k][j] >= m[i][j]) {
                            visible = false;
                        }
                    }
                    if (visible) {
                        count++;
                        continue;
                    }
                    visible = true;
                    // col verso destra
                    for (int k = j + 1; k < DIM && visible; k++) {
                        if (m[i][k] >= m[i][j]) {
                            visible = false;
                        }
                    }
                    if (visible) {
                        count++;
                        continue;
                    }
                    visible = true;
                    // row verso basso
                    for (int k = i + 1; k < DIM && visible; k++) {
                        if (m[k][j] >= m[i][j]) {
                            visible = false;
                        }
                    }
                    if (visible) {
                        count++;
                        continue;
                    }
                    visible = true;
                }
            }
            System.out.println(count);

            // -----time-----
            long stopTime = System.nanoTime();
            long elapsedTime = stopTime - startTime;
            double conv=elapsedTime/1000000.0;
            System.out.println(conv);
            // -----time-----

            reader.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
