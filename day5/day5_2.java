

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class day5_2{
    public static void main(String[] args){
        String stack[]= new String[9];
        ArrayList array[]= new ArrayList[9];

        try{
            FileReader file = new FileReader("/Users/davidemetauro/Documents/Advent/input_5.txt");
            BufferedReader b= new BufferedReader(file);
            stack[0]="vcdrzgbw";
            stack[1]="gwfcbstv";
            stack[2]="cbsnw";
            stack[3]="qgmnjvcp";
            stack[4]="tslfdhb";
            stack[5]="jvtwmn";
            stack[6]="pflcstg";
            stack[7]="bdz";
            stack[8]="mnzw";
            
            for(int i=0; i<9;i++){
                String[] s= stack[i].split("");
                for(int j=0; j<s.length; j++){
                    System.out.print(s[j]);
                }
                array[i]= new ArrayList(Arrays.asList(s));
                System.out.println("\n"+array[i].get(array[i].size()-1));
            }
            String str=b.readLine();
            while (str!=null) {
                String[] s= str.split(" ");
                int n=Integer.parseInt(s[1]);
                int f=Integer.parseInt(s[3])-1;
                int t=Integer.parseInt(s[5])-1;
                for (int i = n; i >0; i--) {
                    int pos= array[f].size()-i;
                    array[t].add(array[f].get(pos));
                }
                for (int i = 0; i <n; i++) {
                    int pos= array[f].size()-1;
                    array[f].remove(pos);
                }
                /* for (int i=0;  i<9; i++) {
                    System.out.print(((String) array[i].get(array[i].size()-1).toString()).toUpperCase());
                }
                System.out.println(); */
                str=b.readLine();
            }
            for (int i=0;  i<9; i++) {
                System.out.print(((String) array[i].get(array[i].size()-1)).toUpperCase());
            }

        } catch (FileNotFoundException e) {
            System.out.println("non esiste");
            return;
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}