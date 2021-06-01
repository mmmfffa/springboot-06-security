package com.mf;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot09TaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
        //一个简单的邮件
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件的标题
        message.setSubject("欢迎注册！");
        message.setText("祝您消费愉快！");
        message.setTo("1106486773@qq.com");
        message.setFrom("3460942872@qq.com");
        mailSender.send(message);
    }
    @Test
    void contextLoads02() throws MessagingException {
        //一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装复杂邮件
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setSubject("复杂的邮件");
        helper.setText("<h2 style='color:green'>消费愉快</h2>",true);
        //附件
        helper.addAttachment("1.jpg",new File("C:\\Users\\Administrator\\Pictures\\壁纸\\315653.jpg"));
        helper.addAttachment("2.jpg",new File("C:\\Users\\Administrator\\Pictures\\壁纸\\314101.jpg"));
        helper.setTo("1106486773@qq.com");
        helper.setFrom("3460942872@qq.com");
        mailSender.send(mimeMessage);
    }

}
