import java.util.ArrayList;
import java.util.List;

public class SmartNotes {

    List<SmartNotePair> notes;
    private int numberOfNotes;

    public SmartNotes() {
        notes = new ArrayList<>();
        numberOfNotes = 0;
    }

    public void addNote(String text) {
        ++numberOfNotes;
        SmartNotePair smartNotePair = new SmartNotePair();
        smartNotePair.setText(text);
        notes.add(smartNotePair);
    }

    public SmartNotePair getNote(int index) {
        String readNoteText = notes.get(index).getText();
        int readNoteUsageCount = notes.get(index).getUsageCount();

        for (int i = index - 1; i >= 0; --i) {
            int frontNoteUsageCount = notes.get(i).getUsageCount();
            if (frontNoteUsageCount < readNoteUsageCount) {
                String frontNoteText = notes.get(i).getText();
                notes.get(i).setText(readNoteText);
                notes.get(i).setUsageCount(readNoteUsageCount);
                notes.get(i + 1).setText(frontNoteText);
                notes.get(i + 1).setUsageCount(frontNoteUsageCount);
            }
        }

        return notes.get(index);
    }

    public void displayAllNotes() {
        System.out.println(notes);
    }

    public int getNumberOfNotes() {
        return numberOfNotes;
    }
}
