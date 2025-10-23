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
     // 1.  For all orders placed in the last 24 hours with a total value greater than $500, generate a report that summarizes the total quantity of products sold per category, considering only products that are in stock. The report should provide the category name along with the total quantity sold, as well as statistics such as average, minimum, maximum, and count of products sold in each category.
        final Map<String, IntSummaryStatistics> collect = orders.stream().filter(order -> order.getOrderTime().isAfter(LocalDateTime.now().minusHours(24)))
                .filter(order -> order.getTotalValue() > 500)
                .flatMap(order -> order.getProducts().stream())
                .filter(order -> BooleanUtils.isTrue(order.isStocks()))
                .collect(Collectors.groupingBy(Product::getCategory,Collectors.summarizingInt(Product::getQuantity)));
        System.out.println(collect);

        //2. For all orders placed in the last 24 hours with a total value greater than $500, generate a report that summarizes the total quantity of products sold per category, considering only products that are in stock. The report should provide the category name along with the total quantity sold.
        final Map<String, Integer> collect1 = orders.stream().filter(order -> order.getOrderTime().isAfter(LocalDateTime.now().minusHours(24)))
                .filter(order -> order.getTotalValue() > 500)
                .flatMap(order -> order.getProducts().stream())
                .filter(order -> BooleanUtils.isTrue(order.isStocks()))
                .collect(Collectors.groupingBy(Product::getCategory,Collectors.summingInt(Product::getQuantity)));
        System.out.println(collect1);


        //3. For all orders placed in the last 24 hours with a total value greater than $500, generate a report that summarizes the total quantity of products sold per category, considering only products that are in stock. The report should provide the category name along with the total quantity sold, sorted in descending order of quantity.

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
        // 4. For all orders placed in the last 24 hours with a total value greater than $500, generate a report that summarizes the total quantity of products sold per category, considering only products that are in stock. The report should provide the category name along with the total quantity sold, sorted in descending order of quantity.
        final List<Product> collect3 = orders.stream().flatMap(order -> order.getProducts().stream())
                .filter(product -> BooleanUtils.isFalse(product.isStocks())).collect(Collectors.toList());
        System.out.println(collect3);
    }
}
