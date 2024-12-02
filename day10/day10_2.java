package day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;

public class day10_2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            int cycle = 0, stop = 40, X = 1;
            String line, op[];
            FileReader file = new FileReader("/Users/davidemetauro/Documents/Advent/input_10.txt");
            BufferedReader reader = new BufferedReader(file);
            while ( cycle<(40*6)) {
                line = reader.readLine();
                op = line.split(" ");
                switch (op[0]) {
                    case "noop":
                        if ((X - 1) <= (cycle-stop+40) && (cycle-stop+40) <= (X + 1)) {
                            System.out.print('#');
                        } else {
                            System.out.print(' ');
                        }
                        cycle++;
                        if (cycle == stop) {
                            System.out.print('\n');
                            stop += 40;
                        }
                        break;
                    case "addx":
                        if ((X - 1) <= (cycle-stop+40) && (cycle-stop+40) <= (X + 1)) {
                            System.out.print('#');
                        } else {
                            System.out.print(' ');
                        }
                        cycle++;
                        if (cycle == stop) {
                            System.out.print('\n');
                            stop += 40;
                        }
                        if ((X - 1) <= (cycle-stop+40) && (cycle-stop+40) <= (X + 1)) {
                            System.out.print('#');
                        } else {
                            System.out.print(' ');
                        }
                        cycle++;
                        if (cycle == stop) {
                            System.out.print('\n');
                            stop += 40;
                        }
                        X += Integer.parseInt(op[1]);
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
