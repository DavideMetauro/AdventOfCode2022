package day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class day9_2 {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("/Users/davidemetauro/Documents/Advent/input_9.txt");
            BufferedReader reader = new BufferedReader(file);
            String line, direction, l[];
            int times;
            ArrayList<Point> rope = new ArrayList<>();
            for (int i = 0; i < 2; i++)
                rope.add(new Point(0, 0));
            Point head = rope.get(0);

            ArrayList<Point> array = new ArrayList<>();
            array.add(new Point(rope.get(rope.size() - 1)));

            while ((line = reader.readLine()) != null) {
                l = line.split(" ");
                direction = l[0];
                times = Integer.parseInt(l[1]);
                for (int i = 0; i < times; i++) {
                    switch (direction) {
                        case "U":
                            head.moveUp();
                            break;
                        case "L":
                            head.moveLeft();
                            break;
                        case "R":
                            head.moveRight();
                            break;
                        case "D":
                            head.moveDown();
                            break;
                    }
                    for (int j = 1; j < rope.size(); j++) {
                        rope.get(j).getCloser(rope.get(j - 1));
                    }
                    if (!array.contains(rope.get(rope.size() - 1))) {
                        array.add(new Point(rope.get(rope.size() - 1)));
                    }

                }
            }
            // array.sort(null);
            //System.out.println(array.toString());
            System.out.println(array.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
