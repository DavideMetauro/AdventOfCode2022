package day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class day7_1 {

    private static Map<String,String> map=new HashMap<>();
    private static long b=70000000;
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("/Users/davidemetauro/Documents/Advent/day7/input_7.txt");
            BufferedReader reader = new BufferedReader(file);
            String line, command[], nodeName = null;
            // ImplementedTree tree = new ImplementedTree();
            StringTree tree = new StringTree();

            line = reader.readLine();
            while (line != null) {
                command = line.split(" ");
                if (command[0].equals("$")) {
                    switch (command[1]) {
                        case "cd":
                            if (command[2].equals("..")) {
                                try {
                                    nodeName = (String) tree.getParent(nodeName);
                                } catch (Exception e) {
                                    // TODO: handle exception
                                }

                            } else
                                nodeName = command[2];
                            line = reader.readLine();
                            break;
                        case "ls":
                            line = reader.readLine();
                            command = line.split(" ");
                            while (line != null && !(command[0].equals("$"))) {
                                try {
                                    tree.add(nodeName, command[1]);
                                    map.put(command[1],command[0]);
                                } catch (IllegalArgumentException e) {

                                }
                                line = reader.readLine();
                                if (line != null) {
                                    command = line.split(" ");
                                }
                            }
                            break;
                    }

                } else
                    break;
            }
            System.out.println("tree:\n" + tree.toString());
            List<String> l= tree.getChildren(null);
            System.out.println(l);
            long n=count(l, tree);
            System.out.println("final "+n);
                
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }
    
    public static long count(List<String> l, StringTree tree) {
        List<String> l1;
        long n=0;
        for (String string : l) {
            //System.out.println("string: "+string);
            l1=tree.getChildren(string);
            if(l1.size()==0){
                //System.out.println("map (child): "+string+" | "+map.get(string));
                String s=map.get(string);
                if (!s.equals("dir")) {
                    n+=Long.parseLong(s);
                }
            }else{
                //System.out.println("map (parent): "+string+" | "+map.get(string));
                n+=count(l1, tree);
                System.out.println(n);
            }
        }
        if (n>8381165&&n<b) b=n;
        return n;
    }
}
