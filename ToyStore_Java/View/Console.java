package View;

import Presenter.Presenter;
import java.util.List;
import java.util.Scanner;

public class Console implements View {
    private Scanner scan;
    private Presenter presenter;
    private boolean work;

    public Console(String listToyFile) {
        presenter = new Presenter(listToyFile);
        scan = new Scanner(System.in);
    }

    @Override
    public void welcome() {
        work = true;
        List<String> objectList;
        int typeToy, weight, index = 1;
        while (work) {
            System.out.println("Выберите игрушку, которую необходимо добавить из списка: ");
            objectList = presenter.getObjectList();
            System.out.println(toPrint(objectList));
            typeToy = inputNumMenu(1, objectList.size()) - 1;
            System.out.println("Введите название игрушки: ");
            String name = scan.nextLine();
            System.out.println("Ввведите частоту выпадения игрушки (в процентах): ");
            weight = inputNumMenu(1, 100);
            String listToy = presenter.addToy(typeToy, name, weight);
            index++;
            work = true;
            if (index>3) {
                System.out.println("Продолжить ввод? (0 - нет, 1 - да): ");
                if (inputNumMenu(0, 1)==0) {
                    work = false;
                    System.out.println(listToy);
                }
                else {
                    work = true;
                }
            }
        }
    }

    /*private void menuAction() {
        work = true;
        while (work) {
            System.out.println("\nВыберите пункт меню: ");
            System.out.println(mainMenu.printMenu());
            int choice = inputNumMenu(1,mainMenu.size());
                mainMenu.execute(choice);
        }
    }*/

    private String toPrint(List<String> objectList) {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 1;
        for (String list : objectList) {
            stringBuilder.append(index++ + ": ");
            stringBuilder.append(list);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
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
}