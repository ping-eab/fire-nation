/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maglasang
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DinerApp extends JFrame {
    // Prices
    private static final int CHICKENPrice = 100;
    private static final int TUNAPrice = 150;
    private static final int VEGGIEPrice = 200;
    private static final int SODAPrice = 50;
    private static final int JUICEPrice = 150;
    private static final int MILKTEAPrice = 100;

    private JComboBox<String> saladComboBox;
    private JCheckBox waterCheckBox;
    private JTextField specialRequestField;
    private JRadioButton sodaRButton;
    private JRadioButton juiceRButton;
    private JRadioButton milkTeaRButton;
    private JTextArea orderDisplay;

    private String selectedSalad = "";
    private String selectedDrink = "";
    private String specialRequest = "";
    private boolean water = false;

    public DinerApp() {
        setTitle("Diner Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem placeOrderItem = new JMenuItem("Place the Order");
        JMenuItem clearOrderItem = new JMenuItem("Clear the Order");
        JMenuItem displayOrderItem = new JMenuItem("Display the Order");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(placeOrderItem);
        fileMenu.add(clearOrderItem);
        fileMenu.add(displayOrderItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        JMenu editMenu = new JMenu("Edit");
        JMenuItem clearMenuSelectionItem = new JMenuItem("Menu Selection");
        JMenuItem clearDrinkSelectionItem = new JMenuItem("Drink");
        JMenuItem clearSpecialRequestItem = new JMenuItem("Special Request");
        editMenu.add(clearMenuSelectionItem);
        editMenu.add(clearDrinkSelectionItem);
        editMenu.add(clearSpecialRequestItem);
        menuBar.add(editMenu);

        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        helpMenu.add(aboutItem);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        // Left panel
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        String[] salads = {"Select Salad", "Chicken", "Tuna Salad", "Vegetable Salad"};
        saladComboBox = new JComboBox<>(salads);
        leftPanel.add(saladComboBox);

        
        leftPanel.add(new JLabel("Special Request"));
        specialRequestField = new JTextField("Less Salt for the Salad");
        leftPanel.add(specialRequestField);

        waterCheckBox = new JCheckBox("Water");
        leftPanel.add(waterCheckBox);

        add(leftPanel, BorderLayout.WEST);

        // Right panel
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        sodaRButton = new JRadioButton("Soda");
        juiceRButton = new JRadioButton("Juice");
        milkTeaRButton = new JRadioButton("Milk Tea");

        ButtonGroup drinkGroup = new ButtonGroup();
        drinkGroup.add(sodaRButton);
        drinkGroup.add(juiceRButton);
        drinkGroup.add(milkTeaRButton);

        rightPanel.add(sodaRButton);
        rightPanel.add(juiceRButton);
        rightPanel.add(milkTeaRButton);

        add(rightPanel, BorderLayout.EAST);

        // Center panel for order display
        orderDisplay = new JTextArea();
        orderDisplay.setEditable(false);
        add(new JScrollPane(orderDisplay), BorderLayout.CENTER);

        // Action listeners
        placeOrderItem.addActionListener(e -> placeOrder());
        clearOrderItem.addActionListener(e -> clearOrder());
        displayOrderItem.addActionListener(e -> displayOrder());
        exitItem.addActionListener(e -> System.exit(0));

        clearMenuSelectionItem.addActionListener(e -> clearMenuSelection());
        clearDrinkSelectionItem.addActionListener(e -> clearDrinkSelection());
        clearSpecialRequestItem.addActionListener(e -> clearSpecialRequest());

        aboutItem.addActionListener(e -> showAbout());
    }

    private void placeOrder() {
        updateOrder();
        int totalPrice = calculatePrice();
        String orderDetails = String.format("Salad: %s\nDrink: %s\nSpecial Request: %s\nWater: %s\nTotal Price: %d",
                selectedSalad, selectedDrink, specialRequest, water ? "Yes" : "No", totalPrice);
        JOptionPane.showMessageDialog(this, orderDetails, "Order Placed", JOptionPane.INFORMATION_MESSAGE);
    }

    private void clearOrder() {
        saladComboBox.setSelectedIndex(0);
        sodaRButton.setSelected(false);
        juiceRButton.setSelected(false);
        milkTeaRButton.setSelected(false);
        specialRequestField.setText("");
        waterCheckBox.setSelected(false);
        orderDisplay.setText("");
    }

    private void displayOrder() {
        updateOrder();
        String orderDetails = String.format("Salad: %s\nDrink: %s\nSpecial Request: %s\nWater: %s",
                selectedSalad, selectedDrink, specialRequest, water ? "Yes" : "No");
        orderDisplay.setText(orderDetails);
    }

    private void clearMenuSelection() {
        saladComboBox.setSelectedIndex(0);
        JOptionPane.showMessageDialog(this, "The salad menu selection has been cleared.", "Menu Selection", JOptionPane.INFORMATION_MESSAGE);
    }

    private void clearDrinkSelection() {
        sodaRButton.setSelected(false);
        juiceRButton.setSelected(false);
        milkTeaRButton.setSelected(false);
        JOptionPane.showMessageDialog(this, "The drink selection has been cleared.", "Drink Selection", JOptionPane.INFORMATION_MESSAGE);
    }

    private void clearSpecialRequest() {
        specialRequestField.setText("");
        JOptionPane.showMessageDialog(this, "The special request has been cleared.", "Special Request", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showAbout() {
        JOptionPane.showMessageDialog(this, "Diner Application\nVersion 1.0", "About", JOptionPane.INFORMATION_MESSAGE);
    }

    private void updateOrder() {
        selectedSalad = saladComboBox.getSelectedItem().toString();
        selectedDrink = sodaRButton.isSelected() ? "Soda" : juiceRButton.isSelected() ? "Juice" : milkTeaRButton.isSelected() ? "Milk Tea" : "";
        specialRequest = specialRequestField.getText();
        water = waterCheckBox.isSelected();
    }

    private int calculatePrice() {
        int total = 0;
        switch (selectedSalad) {
            case "Chicken":
                total += CHICKENPrice;
                break;
            case "Tuna Salad":
                total += TUNAPrice;
                break;
            case "Vegetable Salad":
                total += VEGGIEPrice;
                break;
        }
        switch (selectedDrink) {
            case "Soda":
                total += SODAPrice;
                break;
            case "Juice":
                total += JUICEPrice;
                break;
            case "Milk Tea":
                total += MILKTEAPrice;
                break;
        }
        return total;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DinerApp app = new DinerApp();
            app.setVisible(true);
        });
    }
}