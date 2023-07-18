package View.CommandMenu;

import View.Console;

public class ViewRecord implements Command{
    private Console console;
    public ViewRecord(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Показать список игрушек";
    }

    @Override
    public void execute() {
        console.viewRecord();
    }
}
