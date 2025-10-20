package com.example;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.model.Order;

import java.io.InputStream;
import java.util.List;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        try {
            // Creamos el objeto ObjectMapper de Jackson
            ObjectMapper mapper = new ObjectMapper();

            // Leemos el archivo desde la carpeta resources
            InputStream inputStream = Main.class.getResourceAsStream("/orders.json");

            // Parseamos el contenido JSON a una lista de objetos Order
            List<Order> orders = mapper.readValue(inputStream, new TypeReference<List<Order>>() {});

            // Recorremos y mostramos cada pedido cargado
            for (Order order : orders) {
                log.debug("Loaded order: {}", order.getId());
            }

            // Confirmación final
            log.info("Se han cargado {} pedidos correctamente.", orders.size());

        } catch (Exception e) {
            log.error("Error al cargar los pedidos: {}", e.getMessage());
        }
    }
}
