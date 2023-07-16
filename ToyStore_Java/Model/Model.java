package Model;

import Model.DataBase.ToyInterface;
import Model.DataBase.ToyStore;
import Model.FileHandler.FileHandler;
import java.util.List;

public class Model {
    private ToyStore<ToyInterface> toyStore = new ToyStore<>();
    private FileHandler fileHandler;

    public Model(String listToyFile) {
        fileHandler = new FileHandler(listToyFile);
    }

    public List<String> getObjectList() {
        return toyStore.getListObject();
    }

    public String addToy(int typeToy, String name, int weight) {
        return toyStore.addToy(typeToy, name, weight);
    }
}
