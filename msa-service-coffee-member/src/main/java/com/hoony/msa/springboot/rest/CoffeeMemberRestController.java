package com.hoony.msa.springboot.rest;

import com.hoony.msa.springboot.repository.ICoffeeMemberMapper;
import com.hoony.msa.springboot.rest.rvo.MemberRVO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Slf4j
@RequiredArgsConstructor
@RefreshScope
@RestController
public class CoffeeMemberRestController {
    private final ICoffeeMemberMapper iCoffeeMemberMapper;

    @CircuitBreaker(name = "coffeeMember")
    @GetMapping("/coffeeMember/v1.0/{memberName}")
    public boolean coffeeMember(@PathVariable("memberName") String memberName) {
        log.debug("coffeeMember() v1.0 -> {}", memberName);
        return iCoffeeMemberMapper.existsByMemberName(memberName);
    }

    @CircuitBreaker(name = "coffeeMember")
    @PostMapping("/coffeeMember/v1.1")
    public boolean coffeeMember(@RequestBody MemberRVO memberRVO) {
        return iCoffeeMemberMapper.existsByMemberName(memberRVO.getMemberName());
    }

    @CircuitBreaker(name = "fallbackTest", fallbackMethod = "fallbackFunction")
    @GetMapping("/fallbackTest")
    public String fallbackTest() throws Throwable {
        Random random = new Random();
        if (random.nextInt() % 2 == 1) {
            return "success";
        } else {
            throw new Throwable("fallbackTest");
        }
    }

    public String fallbackFunction(Throwable e) {
        return "fallbackFunction()";
    }

}
