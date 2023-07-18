package Presenter;

import Model.Model;
import java.util.List;

public class Presenter {
    private Model model;

    public Presenter(String listToyFile){
        model = new Model(listToyFile);
    }

    public List<String> getListObject() {
        return model.getListObject();
    }

    public String addToy(int id, int typeToy, String name, int quantity, int weight) {
        return model.addToy(id, typeToy, name, quantity, weight);
    }

    public List getListToy() {
        return model.getListToy();
    }

    public int getMaxId() {
        return model.getMaxId();
    }

    public int getQuantity(int delPos) {
        return model.getQuantity(delPos);
    }

    public String DeleteRecord(int delPos, int delCol, boolean sign) {
        return model.DeleteRecord(delPos, delCol, sign);
    }

    public String ModifyRecord(int pos, int weight) {
        return model.ModifyRecord(pos, weight);
    }
}