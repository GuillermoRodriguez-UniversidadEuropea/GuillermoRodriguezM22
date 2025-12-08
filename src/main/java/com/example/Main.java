package com.example;

import com.example.Controller.OrderController;
import com.example.View.OrderView;
import com.example.model.Order;
import com.example.model.Intercambio;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException {

        System.out.println("Iniciando sistema de gestion de pedidos...");
        System.out.println();

        log.info("Starting Order Management System...");
        System.out.println();

        InputStream file = Main.class.getClassLoader().getResourceAsStream("orders.json");
        if (file == null) {
            log.error("...Error. file:\"orders.json\" not found...");
            return;
        }

        ObjectMapper mapper = new ObjectMapper();
        List<Order> orders = mapper.readValue(
                file,
                mapper.getTypeFactory().constructCollectionType(List.class, Order.class)
        );

        for (Order order : orders) {
            log.debug("Loaded order: {}", order.getId());
        }

        log.info("All orders cargados: {}", orders.size());

        OrderView view = new OrderView();
        Intercambio intercambio = new Intercambio();
        new OrderController(view, orders, intercambio);


        System.out.println("Aplicacion iniciada correctamente.");
    }
}
