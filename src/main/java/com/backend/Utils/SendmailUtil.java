package com.backend.Utils;

import org.springframework.stereotype.Component;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @Author: 李飞飞
 * @Description:
 * @Date: Created in 14:11 2021/4/7
 */
@Component
public class SendmailUtil {

    public void sendMail(com.backend.pojo.Message messager) throws MessagingException {
        // 创建Properties 类用于记录邮箱的一些属性
        Properties props = new Properties();
        // 表示SMTP发送邮件，必须进行身份验证
        props.put("mail.smtp.auth", "true");
        //此处填写SMTP服务器
        props.put("mail.smtp.host", "smtp.qq.com");
        //端口号，QQ邮箱给出了两个端口，但是另一个我一直使用不了，所以就给出这一个587
        props.put("mail.smtp.port", "587");
        // 此处填写你的账号
        props.put("mail.user", "2238154327@qq.com");
        // 此处的密码就是前面说的16位STMP口令
        props.put("mail.password", "csvreyfytqywebhi");

        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        InternetAddress form = new InternetAddress(
                props.getProperty("mail.user"));
        message.setFrom(form);

        // 设置收件人的邮箱
        InternetAddress to = new InternetAddress(messager.getPhone());
        message.setRecipient(Message.RecipientType.TO, to);

        // 设置邮件标题
        message.setSubject("注册成功邮件");

        // 设置邮件的内容体
        message.setContent("恭喜"+messager.getName()+"，你在本平台注册成功！你所在的省份有疫情变化我们会及时发邮件提醒你的！请保持你的手机邮箱畅通！", "text/html;charset=UTF-8");
        // 最后当然就是发送邮件啦
        Transport.send(message);

    }
    public void sendMailRemind(com.backend.pojo.Message messager) throws MessagingException {
        // 创建Properties 类用于记录邮箱的一些属性
        Properties props = new Properties();
        // 表示SMTP发送邮件，必须进行身份验证
        props.put("mail.smtp.auth", "true");
        //此处填写SMTP服务器
        props.put("mail.smtp.host", "smtp.qq.com");
        //端口号，QQ邮箱给出了两个端口，但是另一个我一直使用不了，所以就给出这一个587
        props.put("mail.smtp.port", "587");
        // 此处填写你的账号
        props.put("mail.user", "2238154327@qq.com");
        // 此处的密码就是前面说的16位STMP口令
        props.put("mail.password", "csvreyfytqywebhi");

        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        InternetAddress form = new InternetAddress(
                props.getProperty("mail.user"));
        message.setFrom(form);

        // 设置收件人的邮箱
        InternetAddress to = new InternetAddress(messager.getPhone());
        message.setRecipient(Message.RecipientType.TO, to);

        // 设置邮件标题
        message.setSubject("疫情通知");

        // 设置邮件的内容体
        message.setContent("尊敬的"+messager.getName()+"，你的省份有新的疫情，请及时登陆相关网站进行查看！", "text/html;charset=UTF-8");
        // 最后当然就是发送邮件啦
        Transport.send(message);

    }

}
