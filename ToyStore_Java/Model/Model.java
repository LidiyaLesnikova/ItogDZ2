package Model;

import Model.DataBase.ToyInterface;
import Model.DataBase.ToyList;
import Model.DataBase.ToyStore;
import Model.FileHandler.FileHandler;
import java.io.File;
import java.util.Random;
import java.util.List;
import java.util.PriorityQueue;

public class Model {
    private ToyList<ToyStore> toyList;
    private FileHandler fileHandler;

    public Model(String listToyFile, String fileResult) {
        fileHandler = new FileHandler(listToyFile, fileResult);
        toyList = new ToyList<ToyStore>();
        fileRead(listToyFile);
    }

    public List<ToyStore> getListToy() {
        return toyList.getToyList();
    }

    public int getMaxId() {
        return toyList.getMaxId();
    }

    public int getQuantity(int pos) {
        return toyList.getQuantity(pos);
    }

    public int getSumQuantity() {
        return toyList.getToyList().stream().mapToInt(x -> x.getQuantity()).sum();
    }

    /**
     * получить список классов-игрушек (классов, созданных для каждого типа игрушек)
     * @return список игрушек
     */
    public List<String> getListObject() {
        return toyList.getListObject();
    }

    /**
     * добавить игрушку в перечень
     * @param typeToy - номер типа игрушки, из списка игрушек
     * @param name - имя игрушки, введенное пользователем
     * @param weight - процент вывода
     * @return список всех добавленных игрушек
     */
    public String addToy(int id, int typeToy, String name, int quantity, int weight) {
        toyList.addToy(id, typeToy, name, quantity, weight);
        fileSave();
        return "позиция создана";
    }

    public String deleteRecord(int pos, int delCol, boolean sign) {
        if (sign) {
            toyList.deleteRecord(pos);
        } else {
            toyList.modifyQuantity(pos, delCol);
        }
        fileSave();
        return "позиция удалена";
    }

    public String modifyRecord(int pos, int weight) {
        toyList.modifyWeight(pos, weight);
        fileSave();
        return "позиция изменена";
    }

    public String raffle(int num) {
        String resultView = "розыгрыш "+num+" не состоялся";
        PriorityQueue<ToyInterface> raffleList = new PriorityQueue<>();
        for (ToyStore toy : getListToy()) {
            for (int i = 1; i <= toy.getQuantity(); i++) {
                raffleList.add(toy.getToy());
            }
        }
        int total = raffleList.stream().mapToInt(x -> x.getWeight()).sum();
        Random r = new Random();
        int randomNum = r.nextInt(total) + 1;
        int result = 0;
        for (ToyInterface toy : raffleList) {
            result += toy.getWeight();
            if (result >= randomNum) {
                resultView = "Выигрыш "+ num + " - " +toy;
                ToyStore findToy = getListToy().stream().filter(x -> x.getToy().equals(toy)).findFirst().get();
                deleteRecord(toyList.getToyList().indexOf(findToy),1,toyList.getQuantity(toyList.getToyList().indexOf(findToy))==1);
                fileSave();
                saveResult(toy, num);
                break;
            }
        }
        return resultView;
    }

    private void fileRead(String listToyFile) {
        File file = new File(listToyFile);
        if (file.exists()) {
            toyList = (ToyList<ToyStore>) fileHandler.read();
        }
    }

    private void fileSave(){
        if (!getListObject().isEmpty()) {
            fileHandler.save(toyList);
        }
    }

    private void saveResult(ToyInterface toy, int num) {
        fileHandler.saveResult(toy, num);
    }

}
