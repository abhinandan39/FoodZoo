package com.avizva.service;


import org.apache.log4j.Logger;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Parul.Sharma
 * service annotation for making that class as a service class
 * can be used anywhere directly
 *
 */
@Service
public class SendEmail {
	/**
	 * keeps track of all transactions
	 */
	Logger logger=Logger.getLogger(SendEmail.class);
	/**
	 * object of predefined mailsender class
	 */
	private MailSender mailSender;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
/**
 * sendmail method for sending the mail 
 * @param from
 * @param to
 * @param subject
 * @param msg
 * @return true or false
 */
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
			logger.error(e);
		}
		return false;

	}

}
