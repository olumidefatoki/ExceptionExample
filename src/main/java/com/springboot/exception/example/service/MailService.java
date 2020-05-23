package com.springboot.exception.example.service;

import com.springboot.exception.example.model.Student;
import com.springboot.exception.example.util.MailContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring5.SpringTemplateEngine;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class MailService {
    private final SpringTemplateEngine springTemplateEngine;

    @Value("${escrow.sender.email}")
    private String escrowSenderEmail;

    @Autowired
    public JavaMailSender javaMailSender;

    @Autowired
    public MailService(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    /**
     * This is used to resolve the html template with thymeleaf variables
     *
     * @param template
     * @param context
     * @return
     */
    private String getTemplateString(String template, MailContextUtil context) {
        return springTemplateEngine.process(template, context);
    }

    /**
     * @param subject   The subject of the mail
     * @param variables The variables to be resolved in html
     * @param template  the html template
     * @param to        the address to be mailed to
     * @return
     */
    @Async
    public void sendEmail(String subject, Map<String, Object> variables, String template, String to) {
        String resolvedHtmlString = getTemplateString(template, MailContextUtil.toThymeLeafContext(variables));
        log.info("Email Content : " + resolvedHtmlString);

    }


    @Async
    public void sendEmailNotification(Student student, String subject) {
        Map<String, Object> escrowMap = new HashMap<>();
        escrowMap.put("student", student);
        log.info("{} " + student);
        sendEmail(subject, escrowMap, "student-registration", student.getEmail());
    }
}
