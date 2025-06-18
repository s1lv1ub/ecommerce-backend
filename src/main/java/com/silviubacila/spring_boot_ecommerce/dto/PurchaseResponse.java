package com.silviubacila.spring_boot_ecommerce.dto;

import lombok.*;



public class PurchaseResponse {
    private  final String orderTrackingNumber;

    public PurchaseResponse(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

    public String getOrderTrackingNumber() {
        return orderTrackingNumber;
    }
}
