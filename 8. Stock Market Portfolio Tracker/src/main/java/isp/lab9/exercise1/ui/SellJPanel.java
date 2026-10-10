package isp.lab9.exercise1.ui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Allows the user to sell owned stocks.
 */
public class SellJPanel extends JPanel {
    private final StockMarketJFrame mainFrame;
    private JTextField availableFundsTextField;
    private JComboBox<String> symbolComboBox;
    private JTextField quantityTextField;
    private JTextField valueTextField;

    public SellJPanel(StockMarketJFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridLayout(2, 2));

        JPanel sellPanel = new JPanel();
        sellPanel.setLayout(new GridLayout(10, 2));

        JLabel availableFundsLabel = new JLabel("Available funds:");
        availableFundsTextField = new JTextField(mainFrame.getPortfolio().getCash().toPlainString() + " $");
        availableFundsTextField.setEditable(false);

        JLabel symbolLabel = new JLabel("Symbol:");
        symbolComboBox = new JComboBox<>();
        symbolComboBox.setModel(new DefaultComboBoxModel<>(mainFrame.getPortfolio().getOwnedSymbols()));

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityTextField = new JTextField();

        JLabel valueLabel = new JLabel("Total value:");
        valueTextField = new JTextField();
        valueTextField.setEditable(false);

        JButton valueButton = new JButton("Get value");
        valueButton.addActionListener(e -> calculateTotalValueActionPerformed());

        JButton sellButton = new JButton("Sell");
        sellButton.addActionListener(e -> sellActionPerformed());

        sellPanel.add(availableFundsLabel);
        sellPanel.add(availableFundsTextField);
        sellPanel.add(new JPanel());
        sellPanel.add(new JPanel());
        sellPanel.add(symbolLabel);
        sellPanel.add(symbolComboBox);
        sellPanel.add(new JPanel());
        sellPanel.add(new JPanel());
        sellPanel.add(quantityLabel);
        sellPanel.add(quantityTextField);
        sellPanel.add(new JPanel());
        sellPanel.add(new JPanel());
        sellPanel.add(valueLabel);
        sellPanel.add(valueTextField);
        sellPanel.add(new JPanel());
        sellPanel.add(new JPanel());
        sellPanel.add(valueButton);
        sellPanel.add(sellButton);

        add(sellPanel);
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
    }

    public void refresh() {
        String selectedSymbol = (String) symbolComboBox.getSelectedItem();
        availableFundsTextField.setText(mainFrame.getPortfolio().getCash().toPlainString() + " $");
        symbolComboBox.setModel(new DefaultComboBoxModel<>(mainFrame.getPortfolio().getOwnedSymbols()));

        if (selectedSymbol != null && mainFrame.getPortfolio().getOwnedQuantity(selectedSymbol) > 0) {
            symbolComboBox.setSelectedItem(selectedSymbol);
        }
    }

    private void calculateTotalValueActionPerformed() {
        try {
            String symbol = getSelectedSymbol();
            int quantity = parseQuantity(quantityTextField);

            if (mainFrame.getPortfolio().getOwnedQuantity(symbol) < quantity) {
                valueTextField.setText("Insufficient shares owned!");
                return;
            }

            BigDecimal stockPrice = mainFrame.getStockMarket().getStockPrice(symbol);
            DecimalFormat formatter = new DecimalFormat("#,##0.##");
            valueTextField.setText(formatter.format(stockPrice.multiply(BigDecimal.valueOf(quantity))));
        } catch (IllegalArgumentException e) {
            valueTextField.setText(e.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(StockMarketJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sellActionPerformed() {
        try {
            String symbol = getSelectedSymbol();
            int quantity = parseQuantity(quantityTextField);
            BigDecimal stockPrice = mainFrame.getStockMarket().getStockPrice(symbol);

            mainFrame.getPortfolio().sell(symbol, quantity, stockPrice);
            quantityTextField.setText("");
            valueTextField.setText("");
            mainFrame.refreshPanels();

            JOptionPane.showMessageDialog(this,
                    "The stock was sold successfully.",
                    "Sell completed",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this,
                    e.getMessage(),
                    "Invalid transaction",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(StockMarketJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String getSelectedSymbol() {
        String symbol = (String) symbolComboBox.getSelectedItem();
        if (symbol == null) {
            throw new IllegalArgumentException("There are no owned stocks to sell.");
        }

        return symbol;
    }

    private int parseQuantity(JTextField quantityTextField) {
        try {
            int quantity = Integer.parseInt(quantityTextField.getText().trim());
            if (quantity <= 0) {
                throw new NumberFormatException();
            }

            return quantity;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Quantity must be a positive integer.");
        }
    }

}
