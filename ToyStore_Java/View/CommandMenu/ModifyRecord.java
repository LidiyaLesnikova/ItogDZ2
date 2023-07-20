package View.CommandMenu;

import View.Console;

public class ModifyRecord implements Command{
    private Console console;
    public ModifyRecord(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Изменить частоту выпадения игрушки";
    }

    @Override
    public void execute() {
        console.modifyRecord();
    }
}
