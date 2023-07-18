package Model.DataBase;

public interface ToyInterface<T>{
    int getWeight();
    int getId();
    int getQuantity();
    void setQuantity(int quantity);
    void setWeight(int weight);
    T getNewToy(int id, String name, int quantity, int weight);
}
