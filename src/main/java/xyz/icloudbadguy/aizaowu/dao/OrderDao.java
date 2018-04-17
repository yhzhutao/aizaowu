package xyz.icloudbadguy.aizaowu.dao;

import xyz.icloudbadguy.aizaowu.entity.Order;

import java.util.List;

public interface OrderDao {

    List<Order> getOrderByuserId(int userId);

    void delOrder(int orderId);
}
