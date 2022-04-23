package com.hoony.msa.springboot.repository.dvo;

import lombok.Data;

@Data
public class OrderStatusDVO {
    private Long id;
    private String orderHistory; //주문내역
}
