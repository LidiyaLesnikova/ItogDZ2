package View.CommandMenu;

import View.Console;

public class DeleteRecord implements Command{
    private Console console;
    public DeleteRecord(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Удалить игрушку из списка";
    }

    @Override
    public void execute() {
        console.deleteRecord();
    }
}
