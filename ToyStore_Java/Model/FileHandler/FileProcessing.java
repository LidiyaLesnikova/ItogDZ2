package Model.FileHandler;

import Model.DataBase.ToyInterface;
import Model.DataBase.ToyList;
import Model.DataBase.ToyStore;
import java.io.Serializable;

public interface FileProcessing {
    void save(Serializable object);
    void saveResult(ToyInterface toy, int num);
    ToyList<ToyStore> read();
}
