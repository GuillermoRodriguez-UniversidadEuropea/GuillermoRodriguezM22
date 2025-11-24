package com.example.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.model.Order;
import com.example.model.Searcher;
import com.example.View.OrderView;

public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    OrderView view;
    private final List<Order> orders;
    private Searcher searcher;

    public OrderController(OrderView view, List<Order> orders) {
        this.view = view;
        this.orders = orders;
        this.searcher = new Searcher();

        this.view.getSearchButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchOrder();
            }
        });
    }

    private void searchOrder() {
        String id = view.getSearchId();

        if (id == null || id.isEmpty()) {
            view.displayOrder(null);
            return;
        }

        Order foundOrder = null;
        for (Order order : orders) {
            if (order.getId() != null && order.getId().equalsIgnoreCase(id)) {
                foundOrder = order;
                break;
            }
        }

        view.displayOrder(foundOrder);
    }
}
