package View.CommandMenu;

import View.Console;

public class AddRecord implements Command{
    private Console console;
    public AddRecord(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Добавить в список новую игрушку";
    }

    @Override
    public void execute() {
        console.addRecord(console.numberRecords);
    }
}
