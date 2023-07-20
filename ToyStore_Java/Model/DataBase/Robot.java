package Model.DataBase;

import java.io.Serializable;

public class Robot extends Toy implements Serializable, ToyInterface {
    public Robot(int id, String name, int weight) {
        super(id, name, weight);
    }

    public Robot() {
        this(0, "",0);
    }

    @Override
    public String toString() {
        return "Робот \""+this.name + "\" ("+ this.id + ") - вес "+this.weight+"%";
    }

    @Override
    public Robot getNewToy(int id, String name, int weight) {
        return new Robot(id, name, weight);
    }
}
