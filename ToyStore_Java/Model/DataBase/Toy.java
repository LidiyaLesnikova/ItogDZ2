package Model.DataBase;

import java.io.Serializable;

public abstract class Toy implements Serializable, ToyInterface, Comparable<ToyInterface> {
    protected int id;
    protected String name;
    protected int weight;

    public Toy(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return this.name + "("+ this.id + ")";
    }

    @Override
    public int compareTo(ToyInterface obj) {
        return this.weight;// = obj.getWeight();
    }
}
