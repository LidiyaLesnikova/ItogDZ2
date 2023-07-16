import View.Console;
import View.View;

public class Main {
    public static void main(String[] args) {
        String listToyFile = "./ToyStore_Java/Model/DataBase/ToyStore.txt";
        View start = new Console(listToyFile);
        start.welcome();
    }
}

