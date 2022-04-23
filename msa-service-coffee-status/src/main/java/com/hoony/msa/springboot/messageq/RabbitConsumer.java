package com.hoony.msa.springboot.messageq;

import com.hoony.msa.springboot.repository.ICoffeeStatusMapper;
import com.hoony.msa.springboot.repository.dvo.OrderStatusDVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class RabbitConsumer {
    private final ICoffeeStatusMapper iCoffeeStatusMapper;

    @RabbitListener(queues = "hoony-rabbit-test")
    public void processMessage(String message) {
        log.debug("rabbitmq message -> {}", message);

        OrderStatusDVO orderStatusDVO = new OrderStatusDVO();
        orderStatusDVO.setOrderHistory(message);

        iCoffeeStatusMapper.insertCoffeeOrderStatus(orderStatusDVO);
    }
}
