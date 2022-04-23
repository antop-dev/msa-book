package com.hoony.msa.springboot.messageq;

import com.hoony.msa.domain.model.CoffeeOrderCVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class RabbitProducer {
    private final RabbitTemplate rabbitTemplate;

    public void send(String topic, CoffeeOrderCVO coffeeOrder) {
        rabbitTemplate.convertAndSend(topic, coffeeOrder);
        log.debug("send data from msa-service-coffee-order: {}", coffeeOrder);
    }
}
