package day7;

import java.io.Serializable;

public class N implements Serializable{
    private String name;
    private int dim;

    public N() {
        name=new String();
    }

    public N(String name, int dim) {
        this.name=name;
        this.dim=dim;
    }

    public String getName() {
        return name;
    }

    public int getDim() {
        return dim;
    }
    
}
