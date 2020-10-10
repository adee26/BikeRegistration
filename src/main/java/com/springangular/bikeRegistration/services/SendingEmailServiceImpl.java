package com.springangular.bikeRegistration.services;

import com.springangular.bikeRegistration.model.MailModel;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class SendingEmailServiceImpl implements SendingEmailService{
    private final JavaMailSender emailSender;
    private final Configuration configuration;

    public SendingEmailServiceImpl(JavaMailSender emailSender, @Qualifier(value = "emailConfigBean") Configuration configuration) {
        this.emailSender = emailSender;
        this.configuration = configuration;
    }

    @Override
    public void sendEmails(MailModel mailModel) throws MessagingException, IOException, TemplateException {

    }

    @Override
    public void sendEmail(MailModel mailModel, String name, String email) throws MessagingException, IOException, TemplateException {
        Map model = new HashMap<>();
        model.put("name", name);

        mailModel.setModel(model);

        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

        Template template = configuration.getTemplate("email.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, mailModel.getModel());
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setText(html, true);
        mimeMessageHelper.setSubject("Registration Successful");
        mimeMessageHelper.setFrom("apetreiadelina@gmail.com");
        emailSender.send(mimeMessage);

    }

}
