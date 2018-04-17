package xyz.icloudbadguy.aizaowu.service.impl;

import org.springframework.stereotype.Service;
import xyz.icloudbadguy.aizaowu.service.EmailService;
import xyz.icloudbadguy.aizaowu.util.MailUtil;

import javax.mail.MessagingException;
import java.security.GeneralSecurityException;

@Service
public class EmailServiceImpl implements EmailService {
    @Override
    public String sendEmailCode(String email, String type) throws GeneralSecurityException, MessagingException {
        String emailMsg = null;
        String intFlag = (100000+(int)(Math.random() * 1000000))+"";
        if("0".equals(type)){
            emailMsg = "注册"+ intFlag;
        }
        if("1".equals(type)){
            emailMsg = "修改密码"+intFlag;
        }
        MailUtil.send_mail(email,emailMsg);
        return intFlag;
    }
}
