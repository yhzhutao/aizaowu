package xyz.icloudbadguy.aizaowu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.icloudbadguy.aizaowu.entity.Result;
import xyz.icloudbadguy.aizaowu.service.EmailService;
import xyz.icloudbadguy.aizaowu.util.JsonResult;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;

    @GetMapping(value = "/sendEmailCode")
    private Result sendEmailCode(HttpServletRequest request, HttpServletResponse response) {

        try {
            String email = request.getParameter("email");
            String type = request.getParameter("type"); //type="0" 代表注册 type=1 代表修改密码
            String code = emailService.sendEmailCode(email,type);
            Jedis jedis = new Jedis("localhost");
            jedis.set(email,code);
//            HttpSession session = request.getSession();
//            session.setAttribute(email,code);
            return JsonResult.success();
        } catch (Exception e){
            return JsonResult.error(e);
        }
    }
}
