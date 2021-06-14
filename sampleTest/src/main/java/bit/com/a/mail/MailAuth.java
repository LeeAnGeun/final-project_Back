package bit.com.a.mail;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailAuth  extends Authenticator{
	  PasswordAuthentication pa;
	    
	  public MailAuth() {
	     String mail_id = "akkessun@gmail.com";   // 내 메일주소
	     String mail_pw = "tjdsid2ek+";           // 내 메일 비밀번호
	     pa = new PasswordAuthentication(mail_id, mail_pw);
	  }
	    
	  public PasswordAuthentication getPasswordAuthentication() {
	     return pa;
	 }
}