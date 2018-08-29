package com.tonmedia.tickets.service;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tonmedia.tickets.domain.User;


@Service
public class LoginService {

	@Autowired
	com.tonmedia.tickets.mapper.UserMapper UserMapper;
	
	@Autowired
	com.tonmedia.tickets.mapper.TimeCheckMapper TimeCheckMapper;
	
	// ���� �α���
	public int loginProc(User user, HttpServletRequest request ){
		
		// �Է��� email�� db���� select. 1�� ��� ���̵� �ߺ�
		int loginuser = this.UserMapper.loginUser(user);
		
		String email = user.getEmail();
		if( loginuser == 1 ){
			// �ش� �̸��� session�� ����
			request.getSession().setAttribute("email", email);
		}
		
		return loginuser;
	}
	
	
	// ȸ������ �� id üũ
	public int checkId( User user) {
		
		// ���� id �ִ��� üũ
		int data = this.UserMapper.checkId(user);
		
		String email = user.getEmail();
		String regex = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
		
		Boolean b = email.matches(regex);
		if( b== false){
			//���ԽĿ� ���� ���� ��� 1 return
			data = 1;
		}
		return data;
	}
	
	
	// ȸ������ ���� db�� insert
	public int signupProc( HttpServletRequest request, User user) {
		String basicaddress = request.getParameter("address");
		String dtaddress = request.getParameter("dt-address");
		String address = basicaddress + " " + dtaddress;
		user.setAddress(address);
		
		this.UserMapper.join(user);
		
		
		int abc = 1000;
		return abc;
	}
	
	// ��й�ȣ ã�� �̸��� ����
	public int emailcert( Model model, User user, HttpServletRequest request ) throws AddressException, MessagingException{
		
		// ���̹��� ��� smtp.naver.com �� �Է��մϴ�./
		// Google�� ��� smtp.gmail.com �� �Է��մϴ�.
		String findemail = request.getParameter("findemail");
		user.setEmail(findemail);
		int mailcheck = this.UserMapper.checkId(user);
		
		if (mailcheck == 0) {
			int a = 1;
			return a; 
		} else {
		
		String host = "smtp.naver.com";

		final String username = "thjtw0735"; //���̹� ���̵� �Է����ּ���. @nave.com�� �Է����� ���ñ���.
		final String password = "gura8587t6758!"; //���̹� �̸��� ��й�ȣ�� �Է����ּ���.
		int port=465; //��Ʈ��ȣ

		//��й�ȣ ã�� db
		user.setEmail(findemail);
		String passwd = this.UserMapper.findpw(user);
		
		
		// ���� ����
		String recipient = findemail; //�޴� ����� �����ּҸ� �Է����ּ���.
		String subject = "Ticket Store ���ο� ��й�ȣ�� �˷��帳�ϴ�."; //���� ���� �Է����ּ���.
		String body = findemail + "���� ��й�ȣ�� " + passwd + "�Դϴ�."; //���� ���� �Է����ּ���.
		Properties props = System.getProperties(); // ������ ��� ���� ��ü ����

		// SMTP ���� ���� ����
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", host);

		//Session ����
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			String un=username;
			String pw=password;
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(un, pw);
				} 
			});
			session.setDebug(true); //for debug

			Message mimeMessage = new MimeMessage(session); //MimeMessage ����
			mimeMessage.setFrom(new InternetAddress("thjtw0735@naver.com")); //�߽��� ���� , ������ ����� �̸����ּҸ� �ѹ� �� �Է��մϴ�. �̶��� �̸��� Ǯ �ּҸ� �� �ۼ����ּ���.
			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); //�����ڼ��� //.TO �ܿ� .CC(����) .BCC(��������) �� ����

			mimeMessage.setSubject(subject); //�������
			mimeMessage.setText(body); //�������
			Transport.send(mimeMessage); //javax.mail.Transport.send() �̿�
		
		int a=0;
		
		return a;
		}
	}
}






