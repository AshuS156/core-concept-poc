package org.example.sceneriobasedquestions.test;

import org.apache.commons.lang3.BooleanUtils;
import org.example.sceneriobasedquestions.dto.Order;
import org.example.sceneriobasedquestions.dto.Product;
import org.example.sceneriobasedquestions.repository.OrderUtils;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class ReportGeneration{
    public static void main(String[] args){
        final List<Order> orders = OrderUtils.getOrders();
//1.
        final Map<String, IntSummaryStatistics> collect = orders.stream().filter(order -> order.getOrderTime().isAfter(LocalDateTime.now().minusHours(24)))
                .filter(order -> order.getTotalValue() > 500)
                .flatMap(order -> order.getProducts().stream())
                .filter(order -> BooleanUtils.isTrue(order.isStocks()))
                .collect(Collectors.groupingBy(Product::getCategory,Collectors.summarizingInt(Product::getQuantity)));
        System.out.println(collect);

        //2.
        final Map<String, Integer> collect1 = orders.stream().filter(order -> order.getOrderTime().isAfter(LocalDateTime.now().minusHours(24)))
                .filter(order -> order.getTotalValue() > 500)
                .flatMap(order -> order.getProducts().stream())
                .filter(order -> BooleanUtils.isTrue(order.isStocks()))
                .collect(Collectors.groupingBy(Product::getCategory,Collectors.summingInt(Product::getQuantity)));
        System.out.println(collect1);


        //3.

        final LinkedHashMap<String, Integer> collect2 = orders.stream().filter(order -> order.getOrderTime().isAfter(LocalDateTime.now().minusHours(24)))
                .filter(order -> order.getTotalValue() > 500)
                .flatMap(order -> order.getProducts().stream())
                .filter(order -> BooleanUtils.isTrue(order.isStocks()))
                .collect(Collectors.groupingBy(Product::getCategory,Collectors.summingInt(Product::getQuantity)))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2) -> e1,LinkedHashMap::new));
        System.out.println(collect2);


        // populate all Products which are out of stocks
        final List<Product> collect3 = orders.stream().flatMap(order -> order.getProducts().stream())
                .filter(product -> BooleanUtils.isFalse(product.isStocks())).collect(Collectors.toList());
        System.out.println(collect3);
    }
}
