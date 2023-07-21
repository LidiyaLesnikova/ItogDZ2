package Model.DataBase;

import java.io.Serializable;

public class Car extends Toy implements Serializable, ToyInterface {
    public Car(int id, String name, int weight) {
        super(id, name, weight);
    }

    public Car() {
        this(0, "",0);
    }

    @Override
    public String toString() {
        return "Машинка \""+this.name + "\" ("+ this.id + ") - вес "+this.weight+"%";
    }

    @Override
    public Car getNewToy(int id, String name, int weight) {
        return new Car(id, name, weight);
    }
}
