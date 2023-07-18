package Model;

import Model.DataBase.ToyInterface;
import Model.DataBase.ToyStore;
import Model.FileHandler.FileHandler;
import java.io.File;
import java.util.Comparator;
import java.util.List;

public class Model {
    private ToyStore<ToyInterface> toyStore;
    private FileHandler fileHandler;

    public Model(String listToyFile) {
        fileHandler = new FileHandler(listToyFile);
        toyStore = new ToyStore<>();
        fileRead(listToyFile);
    }

    public List<ToyInterface> getListToy() {
        return toyStore.getListToy();
    }

    public int getMaxId() {
        return toyStore.getListToy().stream().max(Comparator.comparingInt(x -> x.getId())).get().getId();
    }

    public int getQuantity(int delPos) {
        return getListToy().get(delPos).getQuantity();
    }

    /**
     * получить список классов-игрушек (классов, созданных для каждого типа игрушек)
     * @return список игрушек
     */
    public List<String> getListObject() {
        return toyStore.getListObject();
    }

    /**
     * добавить игрушку в перечень
     * @param typeToy - номер типа игрушки, из списка игрушек
     * @param name - имя игрушки, введенное пользователем
     * @param weight - процент вывода
     * @return список всех добавленных игрушек
     */
    public String addToy(int id, int typeToy, String name, int quantity, int weight) {
        toyStore.addToy(id, typeToy, name, quantity, weight);
        fileSave();
        return "позиция создана";
    }

    public String DeleteRecord(int pos, int delCol, boolean sign) {
        if (sign) {
            toyStore.DeleteRecord(pos);
        } else {
            toyStore.ModifyQuantity(pos, delCol);
        }
        fileSave();
        return "позиция удалена";
    }

    public String ModifyRecord(int pos, int weight) {
        toyStore.ModifyWeight(pos, weight);
        fileSave();
        return "позиция изменена";
    }

    public void fileRead(String listToyFile) {
        File file = new File(listToyFile);
        if (file.exists()) {
            toyStore = (ToyStore<ToyInterface>) fileHandler.read();
            //int lastId = toyStore.getListToy().get() .size()
        }
    }

    private void fileSave(){
        if (!getListObject().isEmpty()) {
            fileHandler.save(toyStore);
        }
    }

}
