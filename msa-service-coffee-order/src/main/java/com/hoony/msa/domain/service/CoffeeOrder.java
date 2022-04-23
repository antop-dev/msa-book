package com.hoony.msa.domain.service;

import com.hoony.msa.domain.model.CoffeeOrderCVO;
import com.hoony.msa.domain.model.OrderEntity;
import com.hoony.msa.domain.repository.ICoffeeOrderRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CoffeeOrder implements ICoffeeOrder {
    private final ICoffeeOrderRepository iCoffeeOrderRepository;

    @Override
    public long coffeeOrder(CoffeeOrderCVO coffeeOrderCVO) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderNumber(coffeeOrderCVO.getOrderNumber());
        orderEntity.setCoffeeName(coffeeOrderCVO.getCoffeeName());
        orderEntity.setCoffeeCount(coffeeOrderCVO.getCoffeeCount());
        orderEntity.setCustomerName(coffeeOrderCVO.getCustomerName());

        return iCoffeeOrderRepository.coffeeOrderSave(orderEntity);
    }
}
