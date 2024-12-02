package day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class day9_1 {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("/Users/davidemetauro/Documents/Advent/input_9.txt");
            BufferedReader reader = new BufferedReader(file);
            String line, direction, l[];
            int times;
            Point head= new Point(0,0);
            Point tail= new Point(0,0);
            

            ArrayList<Point> array=new ArrayList<>();
            array.add(new Point(tail));
            
            while ((line = reader.readLine()) != null) {
                l = line.split(" ");
                direction = l[0];
                times = Integer.parseInt(l[1]);
                for (int i = 0; i < times; i++) {
                    switch(direction){
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
                    tail.getCloser(head);
                    if(!array.contains(tail)){
                        array.add(new Point(tail));
                    }
                
                }
            }
            array.sort(null);
            System.out.println(array.toString());
            System.out.println(array.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


