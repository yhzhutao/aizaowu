package xyz.icloudbadguy.aizaowu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import xyz.icloudbadguy.aizaowu.dao.UserDao;
import xyz.icloudbadguy.aizaowu.entity.Product;
import xyz.icloudbadguy.aizaowu.entity.User;
import xyz.icloudbadguy.aizaowu.exception.CodeException;
import xyz.icloudbadguy.aizaowu.exception.NameOrPasswordException;
import xyz.icloudbadguy.aizaowu.exception.PasswdException;
import xyz.icloudbadguy.aizaowu.exception.UserException;
import xyz.icloudbadguy.aizaowu.service.UserService;
import xyz.icloudbadguy.aizaowu.util.MailUtil;
import xyz.icloudbadguy.aizaowu.util.Md5Utils;

import javax.mail.MessagingException;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserServiceImpl implements UserService{

    private static final String KEY = "abc123"; // KEY为自定义秘钥

    @Autowired
    private UserDao userDao;
    @Override
    public User login(String email, String password) throws NameOrPasswordException{
        User user = userDao.findUserByEmail(email);
        if(user==null){
            throw new NameOrPasswordException("该用户不存在");
        }
        if(password.equals(user.getPasswd())){
            return user;
        }else{
            throw new NameOrPasswordException("用户名或密码错误");
        }

    }

    @Override
    public void register(String email,String verifyCode,String passwd,String serviceCode) throws UserException, GeneralSecurityException, MessagingException {

        if(serviceCode.equals(verifyCode)){
            User user = userDao.findUserByEmail(email);
            if(user==null){
                user = new User();
                user.setEmail(email);
                user.setPasswd(passwd);
                userDao.saveUser(user);
            }else{
                throw new UserException("该用户已存在");
            }
        }else{
            throw new UserException("验证码不正确");
        }
    }

    @Override
    public void validate(String verifyCode, String serviceCode,String email,String passwd) throws CodeException {
        if(serviceCode.equals(verifyCode)){
            userDao.modifyPasswd(email,passwd);
        }else{
            throw new CodeException("验证码错误");
        }
    }

    @Override
    public Map<String,List<Product>> getIndexList() {
        List<Product> list = userDao.findProduct();
        List<Product> list1 = new ArrayList<Product>();
        List<Product> list2 = new ArrayList<Product>();
        List<Product> list3 = new ArrayList<Product>();
        List<Product> list4 = new ArrayList<Product>();
        for(Product p : list){
            switch (p.getCategoryId()){
                case 0 :
                    list1.add(p);
                    break;
                case 1 :
                    list2.add(p);
                    break;
                case 2 :
                    list3.add(p);
                    break;
                case 3 :
                    list4.add(p);
                    break;
            }
        }
        Map<String,List<Product>> map = new HashMap<String,List<Product>>();
        map.put("0",list1);
        map.put("1",list2);
        map.put("2",list3);
        map.put("3",list4);
        return map;
    }

    @Override
    public User getUserInformation(int userId) throws UserException {
        User user = userDao.findUserById(userId);
        if(user != null){
            return user;
        }else{
            throw new UserException("该用户不存在");
        }

    }

    @Override
    public void modifyUserInformation(User user) throws UserException {
        int id = user.getId();
        String nickName = user.getNickName();
        int sex = user.getSex();
        String birthday = user.getBirthday();
        String email = user.getEmail();
        String mobilePhone = user.getMobile();
        User user1 = userDao.findUserById(id);
        if(user1==null){
            throw new UserException("需要修改的目标用户不存在");
        }else{
            userDao.alterUserById(id,nickName,sex,birthday,email,mobilePhone);
        }
    }

    @Override
    public void modifyUserPasswd(String userId, String oldPasswd, String newPasswd) throws UserException, PasswdException {
        User user = userDao.findUserById(Integer.parseInt(userId));
        if(user==null){
            throw new UserException("该用户不存在");
        }
        if(oldPasswd.equals(user.getPasswd())){
            userDao.modifyPasswdByOldPasswd(userId,newPasswd);
        }else{
            throw new PasswdException("密码验证出错");
        }
    }

//    @Override
//    public void getUserFollow(String userId) {
//        User user = userDao.findUserById(Integer.parseInt(userId));
//
//    }

}
