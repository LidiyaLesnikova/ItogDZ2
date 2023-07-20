package Presenter;

import Model.Model;
import java.util.List;

public class Presenter {
    private Model model;

    public Presenter(String listToyFile, String fileResult){
        model = new Model(listToyFile, fileResult);
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

    public int getSumQuantity() {
        return model.getSumQuantity();
    }

    public int getQuantity(int delPos) {
        return model.getQuantity(delPos);
    }

    public String deleteRecord(int delPos, int delCol, boolean sign) {
        return model.deleteRecord(delPos, delCol, sign);
    }

    public String modifyRecord(int pos, int weight) {
        return model.modifyRecord(pos, weight);
    }

    public String raffle(int num) {
        return model.raffle(num);
    }

}