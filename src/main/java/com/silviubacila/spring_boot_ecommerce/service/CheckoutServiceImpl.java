package com.silviubacila.spring_boot_ecommerce.service;

import com.silviubacila.spring_boot_ecommerce.dao.CustomerRepository;
import com.silviubacila.spring_boot_ecommerce.dto.Purchase;
import com.silviubacila.spring_boot_ecommerce.dto.PurchaseResponse;
import com.silviubacila.spring_boot_ecommerce.entity.Customer;
import com.silviubacila.spring_boot_ecommerce.entity.Order;
import com.silviubacila.spring_boot_ecommerce.entity.OrderItem;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private final CustomerRepository customerRepository;


    public CheckoutServiceImpl( CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }
    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        //retrieve the order info from dto
        Order order= purchase.getOrder();


        //generate tracking number
        String orderTrackingNumber= generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        //populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        //populate order with billingAddress and shippingAddress
        order.setShippingAddress(purchase.getShippingAddress());
        order.setBillingAddress(purchase.getBillingAddress());

        //populate customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);

        //save to the database
        customerRepository.save(customer);

        //return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        //generate a random UUID number
        return UUID.randomUUID().toString();
    }

}
