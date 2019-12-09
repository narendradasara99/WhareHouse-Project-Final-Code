package com.app.util;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class EmailUtil {
	@Autowired
	private JavaMailSender sender;
	
	/**
	 * Send Email with all possible Inputs
	 * @param to
	 * @param subject
	 * @param text
	 * @param cc
	 * @param bcc
	 * @param file
	 * @return
	 */
	public boolean send(
			String to,
			String subject,
			String text,
			String cc,
			String bcc,
			MultipartFile file
			)
	{
		boolean isSent=false;
		try {
			//1. Create Message
			MimeMessage msg=sender.createMimeMessage();
			//2. Create Helper class object
			MimeMessageHelper helper=new MimeMessageHelper(msg, file!=null?true:false);
			//3. set data to message
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text);
			
			if(cc!=null) 
				helper.setCc(cc);
			if(bcc!=null)
				helper.setBcc(bcc);
			if(file!=null)
				helper.addAttachment(file.getOriginalFilename(), file);

			//4. send message
			sender.send(msg);
			isSent = true;
		} catch (Exception e) {
			isSent = false;
			e.printStackTrace();
		}
		return isSent;
	}
	
	/***
	 * Send Email without attachment
	 * @param to
	 * @param subject
	 * @param text
	 * @param cc
	 * @param bcc
	 * @return
	 */
	public boolean send(
			String to,
			String subject,
			String text,
			String cc,
			String bcc
			)
	{
		return send(to, subject, text, cc, bcc,null);  
	}
	
	/***
	 * Send Simple email using text,
	 * subject and to address
	 * @param to
	 * @param subject
	 * @param text
	 * @return
	 */
	public boolean send(
			String to,
			String subject,
			String text	
			)
	{
		return send(to, subject, text, null, null,null);  
	}
	
	/***
	 * Email with Basic inputs + Attachment
	 * @param to
	 * @param subject
	 * @param text
	 * @param file
	 * @return
	 */
	public boolean send(
			String to,
			String subject,
			String text,
			MultipartFile file
			)
	{
		return send(to, subject, text, null, null,file);  
	}
}
