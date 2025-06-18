package com.silviubacila.spring_boot_ecommerce.controller;

import com.silviubacila.spring_boot_ecommerce.dto.Purchase;
import com.silviubacila.spring_boot_ecommerce.dto.PurchaseResponse;
import com.silviubacila.spring_boot_ecommerce.service.CheckoutService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }
    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
        return checkoutService.placeOrder(purchase);
    }
}
