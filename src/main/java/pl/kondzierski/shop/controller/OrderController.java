package pl.kondzierski.shop.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.kondzierski.shop.model.order.Order;
import pl.kondzierski.shop.model.security.LoginCredentials;
import pl.kondzierski.shop.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.stream.Collectors;

@RestController
public class OrderController {

    OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public ResponseEntity<String> takeOrder(@RequestBody Order order){
        Authentication principal = (Authentication) SecurityContextHolder.getContext().getAuthentication();


        return orderService.addOrder(order,principal);
    }
}
