package day6;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class day6_1 {
    public static void main(String[] args) {
        ArrayList<Character> l = new ArrayList<Character>();
        int i,count=0;
        char c;
        try {
            FileReader f = new FileReader("/Users/davidemetauro/Documents/Advent/input_6.txt");
            BufferedReader r = new BufferedReader(f);
            while (l.size() < 4) {
                c = (char) r.read();
                System.out.println(c);
                count++;
                if (l.contains(c)) {
                    System.out.println(l.toString()+" contains "+c+" in "+l.indexOf(c));
                    int limit=l.indexOf(c)+1;
                    for (i = 0; i < limit; i++) {
                        l.remove(0);
                        System.out.println("remove "+i);
                    }

                }
                l.add(l.size(), c);
                System.out.println(l.toString());
            }
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
