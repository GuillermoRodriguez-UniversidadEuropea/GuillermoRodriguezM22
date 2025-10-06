package Test_Model;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.model.Article;
import com.example.model.Calculator;
import com.example.model.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrderTest {
    
        private Order order;

    @BeforeEach
    void setup() {
        List<Article> lista_compra= new ArrayList<>();

        Article articulo_1 = new Article ( "Leche", 6, 7.99, 15);
        Article articulo_2 = new Article ( "Cereales", 2, 12.49, 20);

        lista_compra.add(articulo_1);
        lista_compra.add(articulo_2);
        

        order = new Order("abc" , lista_compra );
    }


    @Test
    void testGetGrossTotal() {
        assertEquals(72.92, order.getGrossTotal(), 0.01);
    }

    @Test
    void testGetDiscountedTotal() {
        assertEquals(60.73, order.getDiscountedTotal(), 0.01);
    }



}
