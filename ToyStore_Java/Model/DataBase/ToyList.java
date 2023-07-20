package Model.DataBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ToyList<T extends ToyStore> implements Serializable, Iterable<ToyStore> {
    static final long serialVersionUID = 1L;
    private List<ToyInterface> object;
    private List<ToyStore> toyList;

    public ToyList() {
        toyList = new ArrayList<>();
        object = new ArrayList<>();
        object.add(new Doll());
        object.add(new Robot());
        object.add(new Designer());
    }

    public List<String> getListObject() {
        return object.stream().map(o -> o.getClass().getSimpleName()).toList();
    }

    public List<ToyStore> getToyList() {
        return this.toyList;
    }

    public void addToy(int id, int typeToy, String name, int quantity, int weight) {
        ToyInterface toy = object.get(typeToy);
        ToyStore<ToyInterface> newToy = new ToyStore<ToyInterface>((ToyInterface) toy.getNewToy(id, name, weight), quantity);
        toyList.add(newToy);
    }

    public void modifyQuantity(int pos, int delCol) {
        toyList.get(pos).setQuantity(toyList.get(pos).getQuantity() - delCol);
    }

    public void modifyWeight(int pos, int weight) {
        toyList.get(pos).getToy().setWeight(weight);
    }

    public void deleteRecord(int pos) {
        toyList.remove(pos);
    }

    public int getQuantity(int pos) {
        return toyList.get(pos).getQuantity();
    }

    public int getMaxId() {
        return toyList.stream().max(Comparator.comparingInt(x -> x.getToy().getId())).get().getToy().getId();
    }

    @Override
    public Iterator<ToyStore> iterator() {
        return toyList.iterator();
    }
}

