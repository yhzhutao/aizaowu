package xyz.icloudbadguy.aizaowu.service;

import xyz.icloudbadguy.aizaowu.entity.Order;
import xyz.icloudbadguy.aizaowu.exception.OrderException;

import java.util.List;

public interface OrderService {

    List<Order> getOrder(String userId,String status) throws OrderException;

    void delOrder(String userId,String orderId);
}
