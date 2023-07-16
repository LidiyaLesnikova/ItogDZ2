package Model.DataBase;

public interface ToyInterface<T>{
    int getWeight();
    T getNewToy(int id, String name, int weight);
}
