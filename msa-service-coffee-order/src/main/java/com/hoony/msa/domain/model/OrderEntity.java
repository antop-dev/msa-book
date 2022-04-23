package com.hoony.msa.domain.model;

import lombok.Data;

@Data
public class OrderEntity {
    private Long id;
    /**
     * 주문번호
     */
    private String orderNumber;
    /**
     * 커피종류
     */
    private String coffeeName;
    /**
     * 커피개수
     */
    private String coffeeCount;
    /**
     * 회원명
     */
    private String customerName;
}
