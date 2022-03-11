import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SmartNotes smartNotes = new SmartNotes();
//        while (getInput(smartNotes)) {
//
//        }
        new GUI(smartNotes);
    }

    public static boolean getInput(SmartNotes smartNotes) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        char operation = inputLine.charAt(0);

        if (operation == 'a') {
            smartNotes.addNote(inputLine.substring(2));
            return true;
        } else if (operation == 'r') {
            SmartNotePair smartNotePair = smartNotes.getNote(Integer.parseInt(inputLine.substring(2)));
            System.out.println(smartNotePair.toString());
            return true;
        } else if (operation == 'x') {
            return false;
        }

        return false;
    }
}
