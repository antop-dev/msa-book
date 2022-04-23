package com.hoony.msa.domain.service;

import com.hoony.msa.domain.model.CoffeeOrderCVO;

public interface ICoffeeOrder {
    long coffeeOrder(CoffeeOrderCVO coffeeOrderCVO);
}
