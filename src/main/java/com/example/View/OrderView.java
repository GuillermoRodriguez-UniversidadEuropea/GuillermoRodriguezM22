package com.example.View;

import javax.swing.*;
import com.example.model.Order;
import java.awt.*;

public class OrderView extends JFrame {
    private JTextField searchField = new JTextField(10);
    private JButton searchButton = new JButton("Search");
    private JTextArea resultArea = new JTextArea(10, 40);

    public OrderView() {
        setTitle("Order Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Order ID:"));
        add(searchField);
        add(searchButton);
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea));

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public String getSearchId() {
        return searchField.getText().trim();
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void displayOrder(Order order) {
        if (order == null) {
            resultArea.setText("Order not found...");
            return;
        }
        resultArea.setText(order.toString());
    }

    public void displayOrder(Order order, double tipoCambio) {
        if (order == null) {
            resultArea.setText("Order not found...");
            return;
        }

        double totalEur = order.getGrossTotal();
        double totalUsd = totalEur * tipoCambio;

        StringBuilder sb = new StringBuilder();
        sb.append(order.toString()).append("\n\n");
        sb.append("Total EUR: ").append(String.format("%.2f €", totalEur)).append("\n");
        sb.append("Total USD: ").append(String.format("%.2f $", totalUsd)).append("\n");
        sb.append("1 EUR = ").append(String.format("%.4f USD", tipoCambio));

        resultArea.setText(sb.toString());
    }
}
