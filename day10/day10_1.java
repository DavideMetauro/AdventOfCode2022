package day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;

public class day10_1 {

    public static void main(String[] args) {
        try {
            int cycle=0,stop=20,X=1,sum=0;
            String line,op[];
            FileReader file=new FileReader("/Users/davidemetauro/Documents/Advent/input_10.txt");
            BufferedReader reader=new BufferedReader(file);
            while (( line = reader.readLine())!=null && stop<221) {
                op=line.split(" ");
                switch(op[0]) {
                    case "noop":
                        cycle++;
                        if(cycle==stop){
                            sum+=(X*stop);
                            System.out.println(line+"\n"+"[ x: "+X+" cycle: "+cycle+ " sum: "+sum+" ]");
                            stop+=40;
                        }
                        break;
                    case "addx":
                        cycle++;
                        if(cycle==stop){
                            sum+=(X*stop);
                            System.out.println(line+"\n"+"[ x: "+X+" cycle: "+cycle+ " sum: "+sum+" ]");
                            stop+=40;
                        }
                        cycle++;
                        if(cycle==stop){
                            sum+=(X*stop);
                            System.out.println(line+"\n"+"[ x: "+X+" cycle: "+cycle+ " sum: "+sum+" ]");
                            stop+=40;
                        }
                        X+=Integer.parseInt(op[1]);
                }
            }
            System.out.println(sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
