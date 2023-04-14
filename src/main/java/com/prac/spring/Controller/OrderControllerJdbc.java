package com.prac.spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.prac.spring.Model.TacoOrder;
import com.prac.spring.Repository.OrderRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/ordersjdbc")
@SessionAttributes("tacoOrder")
public class OrderControllerJdbc {

    private OrderRepository orderRepo;

    public OrderControllerJdbc(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping("/currentjdbc")
    public String orderForm() {
        return "orderFormjdbc";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "orderFormjdbc";
        }

        orderRepo.save(order);
        sessionStatus.setComplete();

        return "redirect:/";
    }

}
