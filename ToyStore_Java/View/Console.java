package ToyStore_Java.View;

import ToyStore_Java.Presenter.Presenter;

//import java.util.*;


public class Console implements View {
    //private Scanner scan;
    private Presenter presenter;
    //private boolean work;
    //private int objectSelection;

    public Console() {
        presenter = new Presenter();
        //scan = new Scanner(System.in);
        //work = true;
    }

    @Override
    public void objectSelection() {
        System.out.println(presenter.objectSelection());
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

}