package Model.DataBase;

import java.io.Serializable;

public abstract class Toy implements Serializable, ToyInterface, Comparable<ToyInterface> {
    protected int id;
    protected String name;
    protected int quantity;
    protected int weight;

    public Toy(int id, String name, int quantity, int weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
