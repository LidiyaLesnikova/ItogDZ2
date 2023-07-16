package Presenter;

import Model.Model;

import java.util.List;

public class Presenter {
    private Model model;

    public Presenter(String listToyFile){
        model = new Model(listToyFile);
    }

    public List<String> getObjectList() {
        return model.getObjectList();
    }

    public String addToy(int typeToy, String name, int weight) {
        return model.addToy(typeToy, name, weight);
    }
}