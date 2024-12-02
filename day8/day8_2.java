package day8;
import java.io.BufferedReader;
import java.io.FileReader;

public class day8_2 {
    private static final int DIM = 99;

    public static void main(String[] args) {
        // -----time-----
        long startTime = System.nanoTime();
        // -----time-----

        int max = 0;
        int a=0,b=0,c=0,d=0,tot=0,I=0,J=0;
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
            for (int i = 1; i < DIM-1; i++) {
                for (int j = 1; j < DIM-1; j++) {
                    // col verso sinistra
                    for (int k = j - 1; k >= 0 && visible; k--) {
                        if (m[i][k] >= m[i][j]) {
                            visible = false;
                            a=j-k;

                        }
                    }
                    if (visible) {
                        a=j;
                    }
                    visible = true;
                    // row verso l'alto
                    for (int k = i - 1; k >= 0 && visible; k--) {
                        if (m[k][j] >= m[i][j]) {
                            visible = false;
                            b=i-k;
                        }
                    }
                    if (visible) {
                        b=i;
                    }
                    visible = true;
                    // col verso destra
                    for (int k = j + 1; k < DIM && visible; k++) {
                        if (m[i][k] >= m[i][j]) {
                            visible = false;
                            c=k-j;
                        }
                    }
                    if (visible) {
                        c=DIM-j-1;
                    }
                    visible = true;
                    // row verso basso
                    for (int k = i + 1; k < DIM && visible; k++) {
                        if (m[k][j] >= m[i][j]) {
                            visible = false;
                            d=k-i;
                        }
                    }
                    if (visible) {
                        d=DIM-i-1;
                    }
                    visible = true;
                    tot=a*b*c*d;
                    if (tot>max){
                        max=tot;
                        I=i;
                        J=j;
                        System.out.println("a: " + a + " b: " + b + " c: " + c + " d: " + d + " tot: " + tot);
                    }
                    
                    
                }
            }
            System.out.println(max+";"+I+";"+J);
            reader.close();

            // -----time-----
            long stopTime = System.nanoTime();
            long elapsedTime = stopTime - startTime;
            double conv=elapsedTime/1000000.0;
            System.out.println(conv);
            // -----time-----

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
