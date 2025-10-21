package org.example.sceneriobasedquestions.dto;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order{

    private String orderId;

    private List<Product> products;

    private double totalValue;

    private LocalDateTime orderTime;
    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this,ToStringStyle.JSON_STYLE);
    }
}
