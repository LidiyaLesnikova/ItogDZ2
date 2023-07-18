package View.CommandMenu;

import View.Console;

import java.util.ArrayList;
import java.util.List;

public class MainMenu implements MenuInterface {
    private List<Command> commandList;

    public MainMenu(Console console) {
        commandList = new ArrayList<>();
        commandList.add(new ViewRecord(console));
        commandList.add(new AddRecord(console));
        commandList.add(new ModifyRecord(console));
        commandList.add(new DeleteRecord(console));
        commandList.add(new Raffle(console));
        commandList.add(new Quit(console));
    }

    @Override
    public String printMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public void execute(int choice) {
        Command command = commandList.get(choice);
        command.execute();
    }

    @Override
    public int size() {
        return commandList.size();
    }
}
