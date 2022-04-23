package com.hoony.msa.springboot.rest;

import com.hoony.msa.springboot.repository.ICoffeeStatusMapper;
import com.hoony.msa.springboot.repository.dvo.OrderStatusDVO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CoffeeOrderStatusRestController {
    private final ICoffeeStatusMapper iCoffeeStatusMapper;

    @CircuitBreaker(name = "coffeeOrderStatus")
    @PostMapping("/coffeeOrderStatus")
    public ResponseEntity<OrderStatusDVO> coffeeOrderStatus() {
        OrderStatusDVO orderStatusDVO = iCoffeeStatusMapper.selectCoffeeOrderStatus();
        return new ResponseEntity<>(orderStatusDVO, HttpStatus.OK);
    }

}
