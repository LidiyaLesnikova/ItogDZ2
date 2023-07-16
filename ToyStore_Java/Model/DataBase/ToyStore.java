package Model.DataBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class ToyStore <T extends ToyInterface> implements Serializable, Iterable<ToyInterface> {
    static final long serialVersionUID = 1L;
    private List<ToyInterface> object;
    private PriorityQueue<ToyInterface> listToy;
    private static int globalId;

    public ToyStore() {
        listToy = new PriorityQueue<>();
        object = new ArrayList<>();
        object.add(new Doll());
        object.add(new Robot());
        object.add(new Designer());
        globalId = 1;
    }

    public List<String> getListObject() {
        return object.stream().map(o -> o.getClass().getSimpleName()).toList();
    }

    public String addToy(int typeToy, String name, int weight) {
        ToyInterface toy = object.get(typeToy);
        listToy.add((ToyInterface) toy.getNewToy(globalId++,name, weight));
        return listToy.toString();
    }

    @Override
    public Iterator<ToyInterface> iterator() {
        return listToy.iterator();
    }
}
