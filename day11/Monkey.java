package day11;

import java.util.ArrayList;

import javax.script.ScriptEngine;

public class Monkey{
    private ArrayList<Integer> items;
   
    public ArrayList<Integer> getItems() {
        return items;
    }

    private String operation;
    private int operator;
    private int where[];
    private int div;

    
    public int getDiv() {
        return div;
    }

    public void setDiv(int div) {
        this.div = div;
    }

    public Monkey() {
        items=new ArrayList<Integer>();
        where=new int[2];
    }
    public int getSize(){
        return items.size();
    }
    
    public void startingItems(ArrayList<Integer> items){
        this.items.addAll(0, items);
    }
    
    public void receive(int i){
        this.items.add(i);
    }
    
    public int launch(){
        int i=this.items.get(0);
        this.items.remove(0);
        return i;
    }
    
    public void execute(){
        switch(operation){
            case "*":
                if (operator==100) {
                    long l=(long) Math.pow(items.get(0),2);
                    l=l%9699690;
                    items.set(0, (int) l );
                } else {
                    items.set(0, items.get(0)*operator);
                }
                break;
            case "+":
                items.set(0, items.get(0)+operator);
                break;
        }
    }

    public int test(){
        items.set(0, items.get(0)/3);
        if(items.get(0)%div==0){
            return 0;
        }else{
            return 1;
        }
    }

    public int test2(){
        items.set(0, items.get(0)%9699690);
        if(items.get(0)%div==0){
            return 0;
        }else{
            return 1;
        }
    }
    
    public String getOperation() {
        return operation;
    }
    
    public void setOperation(String operation) {
        this.operation = operation;
    }
    
    public int getOperator() {
        return operator;
    }
    
    public void setOperator(int operator) {
        this.operator = operator;
    }
    
    public int getWhere(int i) {
        return where[i];
    }
    
    public void setWhere(int[] where) {
        this.where = where;
    }
    
    
}