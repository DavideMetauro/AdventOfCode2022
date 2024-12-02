package day11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import Advent.Stopwatch;

public class day11_2 {

    public static void main(String[] args) {
        try {
            Stopwatch stop = new Stopwatch().start();
            ArrayList<Monkey> monkeys=new ArrayList<Monkey>();
            Integer inspections[]=new Integer[8];
            FileReader file = new FileReader("/Users/davidemetauro/Documents/Advent/day11/input_11.txt");
            BufferedReader reader = new BufferedReader(file);
            String line;
            for (int i = 0; i < 8; i++) {
                inspections[i]=0;
                Monkey m=new Monkey() ;
                line=reader.readLine();
                //Starting items:
                line=reader.readLine();
                String str[]=line.split(": ")[1].split(", ");
                ArrayList<Integer>  initItems=new ArrayList<>();
                int j=0;
                for (String string : str) {
                    initItems.add(j,Integer.parseInt(string));
                    j++;
                }
                m.startingItems(initItems);
                //Operation:
                line=reader.readLine();
                String operation=line.split(":")[1].split("= ")[1].split(" ")[1];
                m.setOperation(operation);
                String operator=line.split(":")[1].split("= ")[1].split(" ")[2];
                if(!operator.equals("old"))
                    m.setOperator(Integer.parseInt(operator));
                else m.setOperator(100);
                //Test:
                line=reader.readLine();
                int div=Integer.parseInt(line.split(" ")[3]);
                m.setDiv(div);
                int where[]={Integer.parseInt(reader.readLine().split(" ")[5]),Integer.parseInt(reader.readLine().split(" ")[5])};
                m.setWhere(where);

                monkeys.add(i,m);

            }
            for (int i = 0; i < 10000; i++) {
                int n=0;
                for (Monkey monkey : monkeys) {
                    int x=monkey.getSize();
                    inspections[n]+=x;
                    n++;
                    for (int j = x; j >0 ; j--) {
                        monkey.execute();
                        int w=monkey.test2();
                        monkeys.get(monkey.getWhere(w)).receive(monkey.launch());

                    }
                }
            }
            Arrays.sort(inspections,Comparator.reverseOrder());
            System.out.println(Arrays.asList(inspections));
            System.out.println(inspections[0]*inspections[1]);


            stop.stop();
            stop.printParsedTime();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
