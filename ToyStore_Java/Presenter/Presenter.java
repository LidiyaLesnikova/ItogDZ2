package ToyStore_Java.Presenter;

import ToyStore_Java.Model.Model;

public class Presenter {
    private Model model;

    public Presenter(){
        model = new Model();
    }

    public String objectSelection() {
        return model.objectSelection();
    }
}