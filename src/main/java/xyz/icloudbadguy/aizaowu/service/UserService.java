package xyz.icloudbadguy.aizaowu.service;

import xyz.icloudbadguy.aizaowu.entity.Product;
import xyz.icloudbadguy.aizaowu.entity.User;
import xyz.icloudbadguy.aizaowu.exception.CodeException;
import xyz.icloudbadguy.aizaowu.exception.NameOrPasswordException;
import xyz.icloudbadguy.aizaowu.exception.PasswdException;
import xyz.icloudbadguy.aizaowu.exception.UserException;

import javax.mail.MessagingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

public interface UserService {
    User login(String email, String password) throws NameOrPasswordException;
    void register(String email,String verifyCode,String passwd,String serviceCode) throws UserException, GeneralSecurityException, MessagingException;


    void validate(String verifyCode,String serviceCode,String email,String passwd) throws CodeException;

    Map<String,List<Product>> getIndexList();

    User getUserInformation(int userId) throws UserException;

    void modifyUserInformation(User user) throws UserException;

    void modifyUserPasswd(String userId,String oldPasswd,String newPasswd) throws UserException, PasswdException;

//    void getUserFollow(String userId);
}
