package com.silviubacila.spring_boot_ecommerce.service;

import com.silviubacila.spring_boot_ecommerce.dto.Purchase;
import com.silviubacila.spring_boot_ecommerce.dto.PurchaseResponse;

public interface CheckoutService {
    public PurchaseResponse placeOrder(Purchase purchase);
}
