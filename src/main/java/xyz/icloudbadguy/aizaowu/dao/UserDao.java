package xyz.icloudbadguy.aizaowu.dao;

import xyz.icloudbadguy.aizaowu.entity.Product;
import xyz.icloudbadguy.aizaowu.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    User findUserByEmail(String email);
    void saveUser(User user);
    void modifyPasswd(String email,String passwd);
    List<Product> findProduct();

    User findUserById(int userId);

    void alterUserById(int id, String nickName, int sex, String birthday, String email, String mobilePhone);

    void modifyPasswdByOldPasswd(String userId,String newPasswd);
}
