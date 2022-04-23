package com.hoony.msa.springboot.rest;

import com.hoony.msa.domain.model.CoffeeOrderCVO;
import com.hoony.msa.springboot.messageq.RabbitProducer;
import com.hoony.msa.springboot.service.CoffeeOrderServiceImpl;
import com.hoony.msa.springboot.service.IMsaServiceCoffeeMember;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CoffeeOrderRestController {
    private final CoffeeOrderServiceImpl coffeeOrderServiceImpl;
    private final RabbitProducer rabbitProducer;
    private final IMsaServiceCoffeeMember iMsaServiceCoffeeMember;

    @CircuitBreaker(name = "coffeeOrder")
    @PostMapping("/coffeeOrder")
    public ResponseEntity<CoffeeOrderCVO> coffeeOrder(@RequestBody CoffeeOrderCVO coffeeOrderCVO) {
        // is member
        if (iMsaServiceCoffeeMember.coffeeMember(coffeeOrderCVO.getCustomerName())) {
            log.debug("{} is a member!", coffeeOrderCVO.getCustomerName());
        }
        //coffee order
        long id = coffeeOrderServiceImpl.coffeeOrder(coffeeOrderCVO);
        coffeeOrderCVO.setId(id);
        // rabbit
        rabbitProducer.send("hoony-rabbit-test", coffeeOrderCVO);
        return new ResponseEntity<>(coffeeOrderCVO, HttpStatus.OK);
    }
}
