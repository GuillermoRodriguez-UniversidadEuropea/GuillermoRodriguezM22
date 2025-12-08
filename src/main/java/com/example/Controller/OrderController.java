package com.example.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.model.Order;
import com.example.model.Searcher;
import com.example.model.Intercambio;
import com.example.View.OrderView;

public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);
    
    private OrderView view;
    private List<Order> orders;
    private Searcher searcher;
    private Intercambio intercambio;

    public OrderController(OrderView view, List<Order> orders, Intercambio intercambio) {
        this.view = view;
        this.orders = orders;
        this.intercambio = intercambio;
        this.searcher = new Searcher();

        view.getSearchButton().addActionListener(e -> searchOrder());
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

        if (foundOrder == null) {
            view.displayOrder(null);
        } else {
            double tipoCambio = intercambio.obtenerEurUsd();
            view.displayOrder(foundOrder, tipoCambio);
        }
    }
}
