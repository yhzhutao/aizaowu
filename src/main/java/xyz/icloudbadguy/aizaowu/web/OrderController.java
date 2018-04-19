package xyz.icloudbadguy.aizaowu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.icloudbadguy.aizaowu.entity.Order;
import xyz.icloudbadguy.aizaowu.entity.Result;
import xyz.icloudbadguy.aizaowu.service.OrderService;
import xyz.icloudbadguy.aizaowu.util.JsonResult;

import java.util.List;

@CrossOrigin
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping(value = "/getOrderList")
    private Result getOrderList(String userId,String status){
        try{
            if(userId==null){
                throw new IllegalArgumentException("userId不允许为空");
            }
            if(status==null){
                throw new IllegalArgumentException("status不能为空");
            }
            List<Order> list = orderService.getOrder(userId,status);
            return JsonResult.success(list);
        }catch(Exception e){
            return JsonResult.error(e);
        }
    }

    @GetMapping(value = "/delOrder")
    private Result delOrder(String userId,String orderId){
        try{
            if(userId==null||userId.trim().isEmpty()){
                throw new IllegalArgumentException("userId不允许为空");
            }
            if(orderId==null||orderId.trim().isEmpty()){
                throw new IllegalArgumentException("orderId不允许为空");
            }
            orderService.delOrder(userId,orderId);
            return JsonResult.success();
        }catch(Exception e){
            return JsonResult.error(e);
        }
    }
}
