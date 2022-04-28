import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class GUI {

    private JButton copyButton;
    private JButton addButton;
    private JTextField textField;
    private JLabel label;
    private JScrollPane scrollPane;
    private JPanel panel;
    private JList list;

    public GUI(SmartNotes smartNotes) {
        panel.setPreferredSize(new Dimension(1200, 400));

        panel.setLayout(new GridLayout(5, 1));

        label.setText("Smart Notes");
        label.setHorizontalAlignment(0);
        panel.add(label);

        panel.add(scrollPane);

        copyButton.setText("Copy!");
        copyButton.addActionListener(e -> {
            int index = list.getSelectedIndex();
            if (index == -1) {
                return;
            }
            String selectedElement = smartNotes.getNote(index).getText()/*.toString().split(" / ")[0]*/;
            StringSelection stringSelection = new StringSelection(selectedElement);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
            list.setListData(smartNotes.notes.toArray());
        });
        panel.add(copyButton);

        panel.add(textField);

        addButton.setText("Add!");
        addButton.addActionListener(e -> {
            String text = textField.getText();
            if (!text.equals("")) {
                smartNotes.addNote(text);
                list.setListData(smartNotes.notes.toArray());
            }
            textField.setText("");
        });
        panel.add(addButton);

        JFrame frame = new JFrame();
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Smart Notes");
        frame.pack();
        frame.setVisible(true);
    }
}
