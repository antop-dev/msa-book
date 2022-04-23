package com.hoony.msa.springboot.repository.jpa;

import com.hoony.msa.domain.model.OrderEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class OrderEntityJPO extends OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * 주문번호
     */
    String orderNumber;
    /**
     * 커피종류
     */
    String coffeeName;
    /**
     * 커피개수
     */
    String coffeeCount;
    /**
     * 회원명
     */
    String customerName;
}
