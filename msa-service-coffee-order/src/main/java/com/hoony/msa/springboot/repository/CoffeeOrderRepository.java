package com.hoony.msa.springboot.repository;

import com.hoony.msa.domain.model.OrderEntity;
import com.hoony.msa.domain.repository.ICoffeeOrderRepository;
import com.hoony.msa.springboot.repository.jpa.ICoffeeOrderJpaRepository;
import com.hoony.msa.springboot.repository.jpa.OrderEntityJPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CoffeeOrderRepository implements ICoffeeOrderRepository {
    private final ICoffeeOrderJpaRepository iCoffeeOrderJpaRepository;

    @Override
    public long coffeeOrderSave(OrderEntity orderEntity) {

        OrderEntityJPO orderEntityJPO = new OrderEntityJPO();
        orderEntityJPO.setOrderNumber(orderEntity.getOrderNumber());
        orderEntityJPO.setCoffeeName(orderEntity.getCoffeeName());
        orderEntityJPO.setCoffeeCount(orderEntity.getCoffeeCount());
        orderEntityJPO.setCustomerName(orderEntity.getCustomerName());

        iCoffeeOrderJpaRepository.save(orderEntityJPO);

        return orderEntityJPO.getId();
    }
}
