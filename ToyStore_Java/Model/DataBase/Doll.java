package Model.DataBase;

import java.io.Serializable;

public class Doll extends Toy implements Serializable, ToyInterface {
    public Doll(int id, String name, int weight) {
        super(id, name, weight);
    }

    public Doll() {
        this(0, "",0);
    }

    @Override
    public String toString() {
        return "Кукла \""+this.name + "\" ("+ this.id + ") - "+this.weight+"%";
    }

    @Override
    public Doll getNewToy(int id, String name, int weight) {
        return new Doll(id, name, weight);
    }
}
