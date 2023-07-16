package Model.FileHandler;

import Model.DataBase.ToyStore;
import java.io.Serializable;

public interface FileProcessing {
    void save(Serializable object);
    ToyStore read();
}
