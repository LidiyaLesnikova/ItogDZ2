package View.CommandMenu;

import View.Console;

public class Quit implements Command{
    private Console console;
    public Quit(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Конец работы";
    }

    @Override
    public void execute() {
        console.Quit();
    }
}
