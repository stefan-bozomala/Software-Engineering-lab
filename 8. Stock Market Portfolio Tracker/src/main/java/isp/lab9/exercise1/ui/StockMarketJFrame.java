/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package isp.lab9.exercise1.ui;

import isp.lab9.exercise1.services.UserPortfolio;
import isp.lab9.exercise1.services.StockMarket;

import javax.swing.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author mihai.hulea
 * @author radu.miron
 */
public class StockMarketJFrame extends JFrame {
    private StockMarket stockMarket;
    private UserPortfolio portfolio;
    private PortfolioJPanel portfolioPanel;
    private BuyJPanel buyPanel;
    private SellJPanel sellPanel;

    /**
     * Creates new form StockMarketJFrame
     */
    public StockMarketJFrame() {
        stockMarket = new StockMarket();
        try {
            stockMarket.refreshMarketData();
        } catch (IOException ex) {
            Logger.getLogger(StockMarketJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        portfolio = new UserPortfolio(new BigDecimal("1000"), new TreeMap<>(), stockMarket);

        initComponents();
        setVisible(true);
    }

    /**
     * Initializes the window with the tabs and main panels. Each panel is definied in its own class.
     */
    private void initComponents() {
        this.setSize(700, 400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // configure windows the tabs
        JTabbedPane tabs = new JTabbedPane();
        portfolioPanel = new PortfolioJPanel(this);
        buyPanel = new BuyJPanel(this);
        sellPanel = new SellJPanel(this);

        tabs.addTab("Market", new MarketJPanel(this));
        tabs.addTab("UserPortfolio", portfolioPanel);
        tabs.addTab("Buy", buyPanel);
        tabs.addTab("Sell", sellPanel);

        this.add(tabs);
    }

    public StockMarket getStockMarket() {
        return stockMarket;
    }

    public UserPortfolio getPortfolio() {
        return portfolio;
    }

    public void refreshPanels() {
        if (portfolioPanel != null) {
            portfolioPanel.refresh();
        }
        if (buyPanel != null) {
            buyPanel.refresh();
        }
        if (sellPanel != null) {
            sellPanel.refresh();
        }
    }
}
