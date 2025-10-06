package com.example;

import com.example.model.Calculator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Calculator cal = new Calculator();
        int result = cal.subtract(5, 4);
        System.out.println(result);

    }
}
