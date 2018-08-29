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
	
	// 유저 로그인
	public int loginProc(User user, HttpServletRequest request ){
		
		// 입력한 email로 db에서 select. 1일 경우 아이디 중복
		int loginuser = this.UserMapper.loginUser(user);
		
		String email = user.getEmail();
		if( loginuser == 1 ){
			// 해당 이메일 session에 저장
			request.getSession().setAttribute("email", email);
		}
		
		return loginuser;
	}
	
	
	// 회원가입 시 id 체크
	public int checkId( User user) {
		
		// 같은 id 있는지 체크
		int data = this.UserMapper.checkId(user);
		
		String email = user.getEmail();
		String regex = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
		
		Boolean b = email.matches(regex);
		if( b== false){
			//정규식에 맞지 않을 경우 1 return
			data = 1;
		}
		return data;
	}
	
	
	// 회원가입 정보 db에 insert
	public int signupProc( HttpServletRequest request, User user) {
		String basicaddress = request.getParameter("address");
		String dtaddress = request.getParameter("dt-address");
		String address = basicaddress + " " + dtaddress;
		user.setAddress(address);
		
		this.UserMapper.join(user);
		
		
		int abc = 1000;
		return abc;
	}
	
	// 비밀번호 찾기 이메일 인증
	public int emailcert( Model model, User user, HttpServletRequest request ) throws AddressException, MessagingException{
		
		// 네이버일 경우 smtp.naver.com 을 입력합니다./
		// Google일 경우 smtp.gmail.com 을 입력합니다.
		String findemail = request.getParameter("findemail");
		user.setEmail(findemail);
		int mailcheck = this.UserMapper.checkId(user);
		
		if (mailcheck == 0) {
			int a = 1;
			return a; 
		} else {
		
		String host = "smtp.naver.com";

		final String username = "thjtw0735"; //네이버 아이디를 입력해주세요. @nave.com은 입력하지 마시구요.
		final String password = "gura8587t6758!"; //네이버 이메일 비밀번호를 입력해주세요.
		int port=465; //포트번호

		//비밀번호 찾기 db
		user.setEmail(findemail);
		String passwd = this.UserMapper.findpw(user);
		
		
		// 메일 내용
		String recipient = findemail; //받는 사람의 메일주소를 입력해주세요.
		String subject = "Ticket Store 새로운 비밀번호를 알려드립니다."; //메일 제목 입력해주세요.
		String body = findemail + "님의 비밀번호는 " + passwd + "입니다."; //메일 내용 입력해주세요.
		Properties props = System.getProperties(); // 정보를 담기 위한 객체 생성

		// SMTP 서버 정보 설정
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", host);

		//Session 생성
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			String un=username;
			String pw=password;
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(un, pw);
				} 
			});
			session.setDebug(true); //for debug

			Message mimeMessage = new MimeMessage(session); //MimeMessage 생성
			mimeMessage.setFrom(new InternetAddress("thjtw0735@naver.com")); //발신자 셋팅 , 보내는 사람의 이메일주소를 한번 더 입력합니다. 이때는 이메일 풀 주소를 다 작성해주세요.
			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); //수신자셋팅 //.TO 외에 .CC(참조) .BCC(숨은참조) 도 있음

			mimeMessage.setSubject(subject); //제목셋팅
			mimeMessage.setText(body); //내용셋팅
			Transport.send(mimeMessage); //javax.mail.Transport.send() 이용
		
		int a=0;
		
		return a;
		}
	}
}






