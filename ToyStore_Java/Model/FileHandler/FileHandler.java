package Model.FileHandler;

import Model.DataBase.ToyInterface;
import Model.DataBase.ToyList;
import Model.DataBase.ToyStore;
import java.io.*;
import java.time.format.FormatStyle;
import static java.time.format.DateTimeFormatter.ofLocalizedDateTime;

public class FileHandler implements FileProcessing {
    String path;
    String fileResult;
    FileWriter fw;

    public FileHandler(String listToyFile, String fileResult) {
        this.path = listToyFile;
        this.fileResult = fileResult;
    }

    /***
     * записать передаваемый список игрушек в файл
     * @param object - список игрушек
     */
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

    /***
     * читать список игрушек из файла
     * @return
     */
    @Override
    public ToyList<ToyStore> read() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
            ToyList<ToyStore> ft = (ToyList<ToyStore>) in.readObject();
            in.close();
            return ft;
        } catch (Exception e) {
            System.err.println(e);
            return new ToyList<ToyStore>();
        }
    }

    /***
     * записать в файл результат розыгрыша
     * @param toy - выпавшая в розыгрыше игрушка
     * @param num - порядковый номер приза
     */
    @Override
    public void saveResult(ToyInterface toy, int num) {
        try {
            FileWriter fw = new FileWriter(fileResult, true);
            fw.write("Приз "+num+": ");
            fw.append(toy.toString());
            fw.append("\n");
            fw.close();
        } catch (IOException ex) {
            System.out.println("Ошибка записи результата розыгрыша в файл");
        }
    }

    /***
     * отбивка каждого розыгрыша для файла с результатами розыгрышей
     */
    public void saveResultHead() {
        try {
            fw = new FileWriter(fileResult, true);
            fw.write("\nРозыгрыш за " + java.time.LocalDateTime.now().format(ofLocalizedDateTime(FormatStyle.SHORT)) + ": \n");
            fw.close();
        } catch (IOException ex) {
            System.out.println("Ошибка создания файла с результами розыгрыша");
        }
    }
}
