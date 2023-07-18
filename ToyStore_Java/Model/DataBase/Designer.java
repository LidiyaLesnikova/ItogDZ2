package Model.DataBase;

import java.io.Serializable;

public class Designer extends Toy implements Serializable, ToyInterface {
    public Designer(int id, String name, int quantity, int weight) {
        super(id, name, quantity, weight);
    }

    public Designer() {
        this(0, "", 0, 0);
    }

    @Override
    public String toString() {
        return "Конструктор \"" + this.name + "\" (" + this.id + ") - "+this.quantity+"шт., "+this.weight+"%";
    }

    @Override
    public Designer getNewToy(int id, String name, int quantity, int weight) {
        return new Designer(id, name, quantity, weight);
    }
}
