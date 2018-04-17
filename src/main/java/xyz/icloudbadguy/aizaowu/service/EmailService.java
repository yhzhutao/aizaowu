package xyz.icloudbadguy.aizaowu.service;

import javax.mail.MessagingException;
import java.security.GeneralSecurityException;

public interface EmailService {
    String sendEmailCode(String email,String type) throws GeneralSecurityException, MessagingException;
}
