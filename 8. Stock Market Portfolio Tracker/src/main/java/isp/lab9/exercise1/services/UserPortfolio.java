/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isp.lab9.exercise1.services;

import javax.swing.table.AbstractTableModel;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Uses Lombok to get rid of boilerplate code.
 *
 * @author mihai.hulea
 * @author radu.miron
 */
public class UserPortfolio extends AbstractTableModel {
    private static final String[] columns = new String[]{"Symbol", "Quantity", "Price per unit", "Total price"};

    private BigDecimal cash;

    private Map<String, Integer> shares; // a map of number of shares by stock symbol

    private final StockMarket stockMarket;

    public UserPortfolio(BigDecimal cash, Map<String, Integer> shares, StockMarket stockMarket) {
        this.cash = cash;
        this.shares = shares == null ? new TreeMap<>() : shares;
        this.stockMarket = stockMarket;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public Map<String, Integer> getShares() {
        return shares;
    }

    public void buy(String symbol, int quantity, BigDecimal unitPrice) {
        validateTransaction(symbol, quantity, unitPrice);
        BigDecimal totalCost = unitPrice.multiply(BigDecimal.valueOf(quantity));

        if (cash.compareTo(totalCost) < 0) {
            throw new IllegalArgumentException("Insufficient available funds.");
        }

        cash = cash.subtract(totalCost);
        shares.merge(symbol, quantity, Integer::sum);
        fireTableDataChanged();
    }

    public void sell(String symbol, int quantity, BigDecimal unitPrice) {
        validateTransaction(symbol, quantity, unitPrice);
        int ownedQuantity = getOwnedQuantity(symbol);

        if (ownedQuantity < quantity) {
            throw new IllegalArgumentException("Insufficient shares owned.");
        }

        cash = cash.add(unitPrice.multiply(BigDecimal.valueOf(quantity)));
        int remainingQuantity = ownedQuantity - quantity;

        if (remainingQuantity == 0) {
            shares.remove(symbol);
        } else {
            shares.put(symbol, remainingQuantity);
        }

        fireTableDataChanged();
    }

    public int getOwnedQuantity(String symbol) {
        return shares.getOrDefault(symbol, 0);
    }

    public String[] getOwnedSymbols() {
        return getSymbolsSnapshot().toArray(new String[0]);
    }

    @Override
    public int getRowCount() {
        return getSymbolsSnapshot().size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }


    @Override
    public String getColumnName(int index) {
        return columns[index];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        List<String> symbols = getSymbolsSnapshot();
        if (rowIndex < 0 || rowIndex >= symbols.size()) {
            return "N/A";
        }

        String symbol = symbols.get(rowIndex);
        int quantity = shares.get(symbol);
        BigDecimal price = getPrice(symbol);

        switch (columnIndex) {
            case 0:
                return symbol;
            case 1:
                return quantity;
            case 2:
                return price == null ? "N/A" : price.toPlainString();
            case 3:
                return price == null ? "N/A" : price.multiply(BigDecimal.valueOf(quantity)).toPlainString();
            default:
                return "N/A";
        }
    }

    private List<String> getSymbolsSnapshot() {
        List<String> symbols = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : shares.entrySet()) {
            if (entry.getValue() != null && entry.getValue() > 0) {
                symbols.add(entry.getKey());
            }
        }

        symbols.sort(String::compareTo);
        return symbols;
    }

    private BigDecimal getPrice(String symbol) {
        try {
            return stockMarket.getStockPrice(symbol);
        } catch (IOException e) {
            return null;
        }
    }

    private void validateTransaction(String symbol, int quantity, BigDecimal unitPrice) {
        if (symbol == null || symbol.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid stock symbol.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        if (unitPrice == null || unitPrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Invalid stock price.");
        }
    }
}
