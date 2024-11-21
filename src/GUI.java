import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private SortedList sortedList;
    private JTextArea textArea;
    private JTextField inputField;

    public GUI() {
        sortedList = new SortedList();
        JFrame frame = new JFrame("Sorted List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        textArea = new JTextArea(15, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        inputField = new JTextField(20);
        JButton addButton = new JButton("Add");
        JButton searchButton = new JButton("Search");

        // Action listener for adding elements
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                if (!input.isEmpty()) {
                    sortedList.add(input);
                    textArea.append("New List: " + sortedList + "\n\n");
                    inputField.setText("");
                }
            }
        });

        // Action listener for searching elements
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                if (!input.isEmpty()) {
                    String result = sortedList.search(input);
                    textArea.append("'" + result + "'" + "\n\n");
                    inputField.setText("");
                }
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter String:"));
        inputPanel.add(inputField);
        inputPanel.add(addButton);
        inputPanel.add(searchButton);

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(inputPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }
}