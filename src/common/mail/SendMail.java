package common.mail;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.activation.CommandMap;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.activation.MailcapCommandMap;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class SendMail {

	public static void main(String[] args) {
		sendMail();
	}

	public static void sendMail() {
		
		final String bodyEncoding = "UTF-8"; // 메일 인코딩

		String subject = "메일 발송 테스트";
		String fromEmail = "gown119@naver.com"; // 보낼 이메일 주소?? 구글로 해야 되나?
		String fromUsername = "SYSTEM MANAGER"; 
		String toEmail = "hae_z@kakao.com"; // 받을 이메일 주소 여러개면 "메일1, 메일2, 메일3..."
		
		// 구글계정 준비 
		// 1) 로그인 후 2단계 인증
		// 2) 앱 비밀번호 메모하기
		final String username = "haez119@gmail.com";  
		final String password = "notsqbaoyxsoyrff";
		
		// 메일에 출력할 테스트
		StringBuffer sb = new StringBuffer();
		sb.append("<h3>안녕하세요</h3>\n");
		sb.append("<h4>메일보내기</h4>\n");
		String html = sb.toString();
		
		// 메일 옵션 설정
		Properties props = new Properties();

		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.auth", "true");

		props.put("mail.smtp.quitwait", "false");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");

		try {
			// 메일 서버 인증 계정 설정
			Authenticator auth = new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			};

			// 메인 세션 설정
			Session session = Session.getInstance(props, auth);
			
			// 메일 송.수신 옵션 설정
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmail, fromUsername));
			message.setRecipients(RecipientType.TO, InternetAddress.parse(toEmail, false));
			message.setSubject(subject);
			message.setSentDate(new Date());
			
			// 메일 콘텐츠 설정
			Multipart mParts = new MimeMultipart();
		    MimeBodyPart mTextPart = new MimeBodyPart();
		    MimeBodyPart mFilePart = null;
		    //mFilePart.setDataHandler(new DataHandler(attachment,"text/xml"));
		    //mFilePart.setFileName("XBRL INSTANCE"); // 파일명
		    // mFilePart.setDataHandler(new DataHandler(new FileDataSource(new File("it_prog.xls"))));
	        
		    
		    
		    // 메일 콘턴츠 - 내용
		    mTextPart.setText(html, bodyEncoding, "html");
		    mParts.addBodyPart(mTextPart);
		    
		    // 메인 콘텐츠 설정
		    message.setContent(mParts);
		    
		    // mime 타입 설정
		    MailcapCommandMap MailcapCmdMap = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
		    MailcapCmdMap.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
		    MailcapCmdMap.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
		    MailcapCmdMap.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
		    MailcapCmdMap.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
		    MailcapCmdMap.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
		    CommandMap.setDefaultCommandMap(MailcapCmdMap);
		    
		    // 메일 발송하기
		    Transport.send(message);
		    
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		System.out.println("완료");
		
		

	}
	
	

}
