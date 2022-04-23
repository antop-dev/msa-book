package com.hoony.msa.springboot.repository;

import com.hoony.msa.springboot.repository.dvo.OrderStatusDVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ICoffeeStatusMapper {
    void insertCoffeeOrderStatus(OrderStatusDVO orderStatusDVO);

    OrderStatusDVO selectCoffeeOrderStatus();

    void createStatusTable();
}
