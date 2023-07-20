package View.CommandMenu;

import View.Console;

public class Raffle implements Command{
    private Console console;
    public Raffle(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Розыгрыш игрушек";
    }

    @Override
    public void execute() {
        console.raffle();
    }
}
