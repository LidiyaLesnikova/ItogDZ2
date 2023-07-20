import View.Console;
import View.View;

public class Main {
    public static void main(String[] args) {
        String listToyFile = "./Model/DataBase/ToyStore.txt";
        String fileResult = "ResultRaffle.txt";
        View start = new Console(listToyFile, fileResult);
        start.menuAction();
    }
}

