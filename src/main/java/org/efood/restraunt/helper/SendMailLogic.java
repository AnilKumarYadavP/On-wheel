package org.efood.restraunt.helper;

import org.efood.restraunt.dto.Customer;
import org.efood.restraunt.dto.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.validation.Valid;

@Service
public class SendMailLogic {

	@Autowired
	JavaMailSender mailSender;
	
	public void send(@Valid Customer customer ) {
		MimeMessage mm=mailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(mm);
		try {
			helper.setTo(customer.getEmail());
			helper.setSubject("verify Your otp");
			helper.setText("Hello "+customer.getName()+"<h1>"+"Otp is"+customer.getOtp()+"</h1>",true);
			mailSender.send(mm);
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		
	}

	public void send(@Valid Hotel hotel) {
		MimeMessage mm=mailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(mm);
		try {
			helper.setTo(hotel.getEmail());
			helper.setSubject("verify Your otp");
			helper.setText("Hello "+hotel.getName()+"<h1>"+"Otp is"+hotel.getOtp()+"</h1>",true);
			mailSender.send(mm);
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		
	}

}
