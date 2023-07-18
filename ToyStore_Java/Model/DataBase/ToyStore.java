package Model.DataBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class ToyStore <T extends ToyInterface> implements Serializable, Iterable<ToyInterface> {
    static final long serialVersionUID = 1L;
    private List<ToyInterface> object;
    private List<ToyInterface> listToy;

    public ToyStore() {
        listToy = new ArrayList<>();
        object = new ArrayList<>();
        object.add(new Doll());
        object.add(new Robot());
        object.add(new Designer());
    }

    public List<String> getListObject() {
        return object.stream().map(o -> o.getClass().getSimpleName()).toList();
    }

    public List<ToyInterface> getListToy() {
        return listToy;
    }

    public void addToy(int id, int typeToy, String name, int quantity, int weight) {
        ToyInterface toy = object.get(typeToy);
        listToy.add((ToyInterface) toy.getNewToy(id, name, quantity, weight));
    }

    public void ModifyQuantity(int pos, int delCol) {
        listToy.get(pos).setQuantity(listToy.get(pos).getQuantity()-delCol);
    }

    public void ModifyWeight(int pos, int weight) {
        listToy.get(pos).setWeight(weight);
    }

    public void DeleteRecord(int pos) {
        listToy.remove(pos);
    }

    @Override
    public Iterator<ToyInterface> iterator() {
        return listToy.iterator();
    }

}
