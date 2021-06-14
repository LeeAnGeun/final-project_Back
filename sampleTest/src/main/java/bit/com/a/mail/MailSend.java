package bit.com.a.mail;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
 
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class MailSend {
    
    public static String mailSend(String email, int num, String newPwd, String sendType) {     
        Properties prop = System.getProperties();
        prop.put("mail.smtp.starttls.enable", "true"); 
        prop.put("mail.smtp.host", "smtp.gmail.com");  
        prop.put("mail.smtp.auth", "true");            
        prop.put("mail.smtp.port", "587");            
        
        Authenticator auth = new MailAuth();
        
        Session session = Session.getDefaultInstance(prop, auth);
        
        MimeMessage msg = new MimeMessage(session);
    
        try {
            msg.setSentDate(new Date());
            msg.setFrom(new InternetAddress("akkessun@gmail.com", "ACLAP"));
            InternetAddress to = new InternetAddress(email);   
            msg.setRecipient(Message.RecipientType.TO, to);            
            
            if(sendType == "code") {            
            	msg.setSubject("ACLAP 인증번호 입니다.", "UTF-8");            
            	msg.setText("홈페이지에 인증번호를 입력하세요. \n인증번호 : "+ num , "UTF-8"); 
            } 
            else if (sendType == "newPwd") {
            	msg.setSubject("ACLAP 임시 비밀번호 입니다.", "UTF-8");            
            	msg.setText("임시 비밀번호 보내드립니다. 마이페이지에서 비밀번호를 변경하세요. \n비밀번호 : "+ newPwd , "UTF-8"); 
            }
            
            Transport.send(msg);
            
        } catch(AddressException ae) {            
            System.out.println("AddressException : " + ae.getMessage());    
            return "Mail send fail";
        } catch(MessagingException me) {            
            System.out.println("MessagingException : " + me.getMessage());
            return "Mail send fail";
        } catch(UnsupportedEncodingException e) {
            System.out.println("UnsupportedEncodingException : " + e.getMessage());		
            return "Mail send fail";
        }        
        return "Mail send success";
    }
    
    public static boolean contactMail(String name, String email, String content) {
        Properties prop = System.getProperties();
        prop.put("mail.smtp.starttls.enable", "true"); 
        prop.put("mail.smtp.host", "smtp.gmail.com");  
        prop.put("mail.smtp.auth", "true");            
        prop.put("mail.smtp.port", "587");            
        
        Authenticator auth = new MailAuth();
        
        Session session = Session.getDefaultInstance(prop, auth);
        
        MimeMessage msg = new MimeMessage(session);
    
        try {
            msg.setSentDate(new Date());
            msg.setFrom(new InternetAddress(email, name));
            InternetAddress to = new InternetAddress("akkessun@gmail.com");   
            msg.setRecipient(Message.RecipientType.TO, to);            
            
            msg.setSubject("ACLAP 문의메일 입니다.", "UTF-8");            
            msg.setText("NAME : "+name+
            		   "\nEMAIL : "+email+
            		   "\nCONTENT : "+content , "UTF-8"); 

            Transport.send(msg);
            
        } catch(AddressException ae) {            
            System.out.println("AddressException : " + ae.getMessage());    
            return false;
        } catch(MessagingException me) {            
            System.out.println("MessagingException : " + me.getMessage());
            return false;
        } catch(UnsupportedEncodingException e) {
            System.out.println("UnsupportedEncodingException : " + e.getMessage());		
            return false;
        }        
        return true;

    }
}