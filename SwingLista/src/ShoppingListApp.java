import javax.swing.*;

public class ShoppingListApp {
    private JPanel rootPanel;
    private JTextField itemInput;
    private JButton addButton;
    private JButton deleteButton;
    private JList<String> itemsList;

    private DefaultListModel<String> listModel;

    public ShoppingListApp() {
        // 1. MODEL
        listModel = new DefaultListModel<>();
        itemsList.setModel(listModel);

        // 2. DODAWANIE
        addButton.addActionListener(e -> {
            String text = itemInput.getText().trim();

            if (!text.isEmpty()) {
                listModel.addElement(text);
                itemInput.setText("");
            }
        });

        // 3. USUWANIE
        deleteButton.addActionListener(e -> {
            int selectedIndex = itemsList.getSelectedIndex();

            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ShoppingListApp");
        frame.setContentPane(new ShoppingListApp().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}