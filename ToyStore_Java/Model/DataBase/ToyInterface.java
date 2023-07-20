package Model.DataBase;

public interface ToyInterface<T> {
    int getWeight();
    int getId();
    void setWeight(int weight);
    ToyInterface getNewToy(int id, String name, int weight);
}
