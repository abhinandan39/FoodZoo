package com.avizva.service;


import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class SendEmail {
	
	private MailSender mailSender;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public boolean sendMail(String from, String to, String subject, String msg) {
		int flag = 0;
		// creating message
		try {

			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(from);
			message.setTo(to);
			message.setSubject(subject);
			message.setText(msg);

			// sending messgae
			System.out.println("before mail sender");
			mailSender.send(message);
			System.out.println("after mail sender");
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception");
		}
		return false;

	}

}
