package isp.lab9.exercise1.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Displays the user's owned stocks and available cash.
 */
public class PortfolioJPanel extends JPanel {
    private final StockMarketJFrame mainFrame;
    private JTextField availableFundsTextField;

    public PortfolioJPanel(StockMarketJFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        JPanel cashPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel availableFundsLabel = new JLabel("Available funds:");
        availableFundsTextField = new JTextField(15);
        availableFundsTextField.setEditable(false);
        cashPanel.add(availableFundsLabel);
        cashPanel.add(availableFundsTextField);

        JTable portfolioTable = new JTable();
        portfolioTable.setModel(mainFrame.getPortfolio());
        JScrollPane portfolioScrollablePane = new JScrollPane(portfolioTable);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> refresh());

        add(cashPanel, BorderLayout.NORTH);
        add(portfolioScrollablePane, BorderLayout.CENTER);
        add(refreshButton, BorderLayout.SOUTH);

        refresh();
    }

    public void refresh() {
        availableFundsTextField.setText(mainFrame.getPortfolio().getCash().toPlainString() + " $");
        mainFrame.getPortfolio().fireTableDataChanged();
    }
}
