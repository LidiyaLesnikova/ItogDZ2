package View;

import Presenter.Presenter;
import View.CommandMenu.MainMenu;
import View.CommandMenu.MenuInterface;
import View.Printable.PrintInterface;
import View.Printable.PrintObjectList;
import java.util.*;

public class Console implements View {
    private Scanner scan;
    private Presenter presenter;
    private MenuInterface mainMenu;
    private PrintInterface printable;
    private boolean work;
    public int numberRecords;

    public Console(String listToyFile, String fileResult) {
        presenter = new Presenter(listToyFile, fileResult);
        scan = new Scanner(System.in);
        mainMenu = new MainMenu(this);
        printable = new PrintObjectList();
    }

    @Override
    public void menuAction() {
        int sizeList = presenter.getListToy().size();
        if (sizeList!=0) {
            numberRecords = presenter.getMaxId();
        }
        if (sizeList<3) {
            addRecord(sizeList);
        }
        work = true;
        while (work) {
            System.out.println("\nВыберите пункт меню: ");
            System.out.println(mainMenu.printMenu());
            int choice = inputNumMenu(1,mainMenu.size())-1;
            mainMenu.execute(choice);
        }
    }

    public void viewRecord() {
        System.out.println(printable.output(presenter.getListToy()));
        work = true;
    }

    public void addRecord(int sizeList) {
        work = true;
        List<String> objectList;
        int typeToy, quantity, weight;
        while (work) {
            numberRecords++;
            System.out.println("Выберите игрушку, которую необходимо добавить из списка: ");
            objectList = presenter.getListObject();
            System.out.println(printable.output(objectList));
            typeToy = inputNumMenu(1, objectList.size()) - 1;
            System.out.println("Введите название игрушки: ");
            String name = scan.nextLine();
            System.out.println("Введите количество игрушек для розыгрыша: ");
            quantity = inputNumMenu(1, 1000000);
            System.out.println("Введите частоту выпадения игрушки (в процентах): ");
            weight = inputNumMenu(1, 100);
            System.out.println(presenter.addToy(numberRecords, typeToy, name, quantity, weight));
            sizeList++;
            if (sizeList>=3) {
                work = false;
            }
            else {
                work = true;
            }
        }
        work = true;
    }

    public void modifyRecord() {
        if (presenter.getSumQuantity()>0) {
            int pos = selectPosition("Выберите какую позицию надо исправить: ");
            System.out.println("введите новую частоту выпадения игрушки (в процентах): ");
            int weight = inputNumMenu(1, 100);
            System.out.println(presenter.modifyRecord(pos, weight));
        } else {
            System.out.println("Набор игрушек для розыгрыша пуст");
        }
        work = true;
    }

    public void deleteRecord() {
        if (presenter.getSumQuantity()>0) {
            int delPos = selectPosition("Выберите позицию, которую надо удалить: ");
            System.out.println("в каком количестве: ");
            int quantity = presenter.getQuantity(delPos);
            int delCol = inputNumMenu(0, quantity);
            System.out.println(presenter.deleteRecord(delPos, delCol, quantity==delCol));
        } else {
            System.out.println("Набор игрушек для розыгрыша пуст");
        }
        work = true;
    }

    public void raffle() {
        int sumQuantity = presenter.getSumQuantity();
        if (sumQuantity>0) {
            System.out.println("Введите количество разыгрываемых игрушек (из "+sumQuantity+"): ");
            int numberDraws = inputNumMenu(1, sumQuantity);
            for (int i = 1; i <= numberDraws; i++) {
                System.out.println(presenter.raffle(i));
            }
        } else {
            System.out.println("Набор игрушек для розыгрыша пуст");
        }
        work = true;
    }

    public void quit() {
        System.out.println("До свидания)");
        work = false;
    }

    private int inputNumMenu(int from, int to) {
        work = true;
        String line = "";
        while (work) {
            line = scan.nextLine();
            if (!checkLine(line, from, to)) {
                System.out.println("Ошибка ввода, еще раз");
                continue;
            }
            work = false;
        }
        return Integer.parseInt(line);
    }

    private boolean checkLine(String line, int from, int to) {
        if (!line.matches("[0-9]+")){
            return false;
        }
        int choice = Integer.parseInt(line);
        return choice >= from && choice <= to;
    }

    private int selectPosition(String message) {
        List listToy = presenter.getListToy();
        System.out.println(message+"\n"+printable.output(listToy));
        return inputNumMenu(1,listToy.size())-1;
    }
}