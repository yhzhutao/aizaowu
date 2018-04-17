package xyz.icloudbadguy.aizaowu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.icloudbadguy.aizaowu.dao.OrderDao;
import xyz.icloudbadguy.aizaowu.entity.Order;
import xyz.icloudbadguy.aizaowu.exception.OrderException;
import xyz.icloudbadguy.aizaowu.service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public List<Order> getOrder(String userId) throws OrderException {
        List<Order> list = orderDao.getOrderByuserId(Integer.parseInt(userId));
        if(list == null){
            throw new OrderException("该userId对应的订单不存在");
        }
        return list;
    }

    @Override
    public void delOrder(String userId, String orderId) {
        orderDao.delOrder(Integer.parseInt(orderId));
    }
}
