package View.Printable;

import java.util.List;

public class PrintObjectList implements PrintInterface {
    @Override
    public String output(List object) {
        return toPrint(object);
    }

    private String toPrint(List objectList) {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 1;
        for (Object list : objectList) {
            stringBuilder.append(index++ + ") ");
            stringBuilder.append(list);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
