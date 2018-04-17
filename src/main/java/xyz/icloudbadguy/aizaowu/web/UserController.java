package xyz.icloudbadguy.aizaowu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;
import xyz.icloudbadguy.aizaowu.entity.Product;
import xyz.icloudbadguy.aizaowu.entity.Result;
import xyz.icloudbadguy.aizaowu.entity.User;
import xyz.icloudbadguy.aizaowu.exception.CodeException;
import xyz.icloudbadguy.aizaowu.exception.NameOrPasswordException;
import xyz.icloudbadguy.aizaowu.exception.UserException;
import xyz.icloudbadguy.aizaowu.exception.UserIdException;
import xyz.icloudbadguy.aizaowu.service.UserService;
import xyz.icloudbadguy.aizaowu.util.JsonResult;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value="/user/login")
    private Result login(String email, String password){
        try{
            if(email==null||email.trim().isEmpty()){
                throw new NameOrPasswordException("用户名不能为空");
            }
            if(password==null|password.trim().isEmpty()){
                throw new NameOrPasswordException("密码不能为空");
            }
            User user= userService.login(email,password);
            return JsonResult.success(user);
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.error(e);
        }
    }

    @PostMapping(value = "/user/registe")
    private Result register(HttpServletRequest request, HttpServletResponse response){
        try {
            String email = request.getParameter("email");
            String verifyCode = request.getParameter("verifyCode");
            String passwd = request.getParameter("passwd");
//            HttpSession session = request.getSession();
//            String serviceCode = session.getAttribute(email).toString();
            Jedis jedis = new Jedis("localhost");
            String serviceCode = jedis.get(email);
            userService.register(email,verifyCode,passwd,serviceCode);
            return JsonResult.success();
        } catch (Exception e){
            return JsonResult.error(e);
        }
    }

    @PostMapping(value = "/user/modifyPassWd")
    private Result modifypasswd(HttpServletRequest request,HttpServletResponse response){

        try {
            String email = request.getParameter("email");
            String verifyCode = request.getParameter("verifyCode");
            String passwd  = request.getParameter("passwd");
            Jedis jedis = new Jedis("localhost");
            String serviceCode = jedis.get(email);
            userService.validate(verifyCode,serviceCode,email,passwd);
            return JsonResult.success();
        } catch (CodeException e) {
            return JsonResult.error(e);
        }

    }

    @PostMapping(value = "/getIndexPicture")
    private Result getIndexPicture(){
        return  JsonResult.success(userService.getIndexList());
    }

    @GetMapping(value = "/user/getUserInfo")
    private Result getPersonInformation(int userId){
        try {
            User user =userService.getUserInformation(userId);
            return JsonResult.success(user);
        } catch (UserException e) {
            return JsonResult.error(e);
        }

    }

    @PostMapping(value = "/user/modifyUserInfo")
    private Result modifyUserInformation(HttpServletRequest request,HttpServletResponse response){
        try{
            String userId = request.getParameter("userId");
            String nickName = request.getParameter("nickName");
            String sex = request.getParameter("sex");
            String birthday = request.getParameter("birthday");
            String email = request.getParameter("email");
            String mobilePhone = request.getParameter("mobile");
            if(userId==null){
                throw new UserIdException("userId不能为空");
            }
            User user = new User();
            user.setId(Integer.valueOf(userId));
            user.setNickName(nickName);
            user.setSex(Integer.valueOf(sex));
            user.setBirthday(birthday);
            user.setEmail(email);
            user.setMobile(mobilePhone);
            userService.modifyUserInformation(user);
            return JsonResult.success();
        }catch(Exception e){
            return JsonResult.error(e);
        }
    }
    @GetMapping(value = "/modifyUserPasswd")
    private Result modifyUserPasswd(HttpServletRequest request,HttpServletResponse response){
        try{
            String userId = request.getParameter("userId");
            String oldPasswd = request.getParameter("oldPasswd");
            String newPasswd = request.getParameter("newPasswd");
            if(userId==null||userId.trim().isEmpty()){
                throw new IllegalArgumentException("userId不允许为空");
            }
            if(oldPasswd==null||oldPasswd.trim().isEmpty()){
                throw new IllegalArgumentException("旧密码不允许为空");
            }
            if(newPasswd==null||newPasswd.trim().isEmpty()){
                throw new IllegalArgumentException("新密码不允许为空");
            }
            userService.modifyUserPasswd(userId,oldPasswd,newPasswd);
            return JsonResult.success();
        }catch(Exception e){
            return JsonResult.error(e);
        }

    }
}
