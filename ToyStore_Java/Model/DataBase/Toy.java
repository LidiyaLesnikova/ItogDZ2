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
    public int getId() {
        return this.id;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(ToyInterface obj) {
        return this.getWeight() - obj.getWeight();
    }
}
