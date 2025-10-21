package org.example.sceneriobasedquestions.repository;

import org.example.sceneriobasedquestions.dto.Order;
import org.example.sceneriobasedquestions.dto.Product;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class OrderUtils{

    public static List<Order> getOrders() {
        Order order1 = new Order(String.valueOf(new Random().nextInt()), electronicProducts(), Double.valueOf(1500) , LocalDateTime.now().minusHours(2));
        Order order2 = new Order(String.valueOf(new Random().nextInt()), clothingProducts(), Double.valueOf(2500) , LocalDateTime.now().minusHours(4));
        Order order3 = new Order(String.valueOf(new Random().nextInt()), footWearProducts(), Double.valueOf(5500) , LocalDateTime.now().minusHours(26));
        Order order4 = new Order(String.valueOf(new Random().nextInt()), homeAndKitchen(), Double.valueOf(200) , LocalDateTime.now().minusHours(20));
        Order order5 = new Order(String.valueOf(new Random().nextInt()), commonItems(), Double.valueOf(4000) , LocalDateTime.now().minusHours(12));
        return  Arrays.asList(order1,order5,order2,order3,order4);
    }

    private  static List<Product> electronicProducts() {
        return Arrays.asList( new Product("101" , "Iphone" , "Electronics", 2, true),
                              new Product("111" , "USB Cable" , "Electronics", 12, true),
                              new Product("121" , "Head Phones" , "Electronics", 10, false));
    }

    private  static List<Product> clothingProducts() {
        return Arrays.asList( new Product("1011" , "T-Shirt" , "Clothing", 3, true),
                              new Product("1131" , "Jeans" , "Clothing", 2, true));
    }

    private  static List<Product> footWearProducts() {
        return Arrays.asList( new Product("4511" , "Shoes" , "Footwear", 5, true),
                              new Product("8745" , "Sandle" , "Footwear", 7, false));
    }

    private  static List<Product> homeAndKitchen() {
        return Arrays.asList( new Product("9898" , "Cookware-set" , "Home & Kitchen", 10, true),
                              new Product("9856" , "Knife" , "Home & Kitchen", 5, false));
    }

    private  static List<Product> commonItems() {
        return Arrays.asList(
                new Product("101" , "Iphone" , "Electronics", 1, true),
                new Product("1011" , "T-Shirt" , "Clothing", 1, false));
    }
}
