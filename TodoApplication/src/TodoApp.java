import javax.swing.*;
import java.awt.event.*;

public class TodoApp {
    private JPanel jPanel;
    private JLabel label1;
    private JTextField inputField;
    private JList<String> taskList;
    private JLabel infoLabel;
    private JLabel counterLabel;
    private JButton deleteButton;
    private JButton addButton;

    private DefaultListModel<String> listModel;
    private JPanel rootPanel;

    public TodoApp() {
        rootPanel.setSize(300, 300);
        listModel = new DefaultListModel<>();
        taskList.setModel(listModel);


        addButton.addActionListener(e -> addTask());
        inputField.addActionListener(e -> addTask()); // ENTER

        deleteButton.addActionListener(e -> {
            int index = taskList.getSelectedIndex();
            if (index != -1) {
                listModel.remove(index);
                updateCounter();
            }
        });

        taskList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = taskList.locationToIndex(e.getPoint());
                    if (index != -1) {
                        listModel.remove(index);
                        updateCounter();
                    }
                }
            }
        });
    }

    private void addTask() {
        String text = inputField.getText().trim();

        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(jPanel, "Nie możesz dodać pustego zadania!");
            return;
        }

        listModel.addElement(text);
        inputField.setText("");
        updateCounter();
    }

    private void updateCounter() {
        counterLabel.setText(String.valueOf(listModel.getSize()));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ToDo");
        frame.setContentPane(new TodoApp().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
