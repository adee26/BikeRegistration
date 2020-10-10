package com.springangular.bikeRegistration.services;

import com.springangular.bikeRegistration.model.MailModel;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;

@Service
public interface SendingEmailService {
    void sendEmails(MailModel mailModel) throws MessagingException, IOException, TemplateException;
    void sendEmail(MailModel mailModel,String name, String email) throws MessagingException, IOException, TemplateException;
}
