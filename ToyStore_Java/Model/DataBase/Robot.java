package Model.DataBase;

import java.io.Serializable;

public class Robot extends Toy implements Serializable {
    public Robot(int id, String name, int quantity, int weight) {
        super(id, name, quantity, weight);
    }

    public Robot() {
        this(0, "",0, 0);
    }

    @Override
    public String toString() {
        return "Робот \""+this.name + "\" ("+ this.id + ") - "+this.quantity+"шт., "+this.weight+"%";
    }

    @Override
    public Robot getNewToy(int id, String name, int quantity, int weight) {
        return new Robot(id, name, quantity, weight);
    }
}
