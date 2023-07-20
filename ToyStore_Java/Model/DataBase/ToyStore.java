package Model.DataBase;

import java.io.Serializable;
import java.util.Iterator;

public class ToyStore <T extends ToyInterface> implements Serializable, ToyInterface {
    private ToyInterface toy;
    private int quantity;

    public ToyStore(ToyInterface toy, int quantity) {
        this.toy = toy;
        this.quantity = quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public ToyInterface getToy() {
        return this.toy;
    }

    @Override
    public int getWeight() {
        return 0;
    }

    @Override
    public int getId() {
        return toy.getId();
    }

    @Override
    public void setWeight(int weight) {
        toy.setWeight(weight);
    }

    @Override
    public ToyInterface getNewToy(int id, String name, int weight) {
        return (ToyInterface) toy.getNewToy(id, name, weight);
    }

    @Override
    public String toString() {
        return toy +", " + quantity +"шт.";
    }
}
