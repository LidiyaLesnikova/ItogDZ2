package Model.FileHandler;

import Model.DataBase.ToyStore;
import java.io.*;

public class FileHandler implements FileProcessing {
    String path;

    public FileHandler(String listToyFile) {
        this.path = listToyFile;
    }

    @Override
    public void save(Serializable object) {
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
            out.writeObject(object);
            out.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    @Override
    public ToyStore read() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
            ToyStore ft = (ToyStore) in.readObject();
            in.close();
            return ft;
        } catch (Exception e) {
            System.err.println(e);
            return new ToyStore();
        }
    }
}
