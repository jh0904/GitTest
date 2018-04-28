package cn.collection.test;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//邮件发送工具类
public class MailTest {


    public static void sendMail(String to) throws Exception{//那谁发邮件 ，邮件激活码

        //1、创建连接对象，连接邮件服务器
        Properties props = new Properties();

        props.setProperty("mail.smtp.host", "smtp.163.com");//主机名
        props.setProperty("mail.smtp.post", "25");//端口
        props.setProperty("mail.smtp.auth", "true");//开启权限控制


        Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {//通过密码认证
                return new PasswordAuthentication("jh19970904@163.com", "password");
            }
        });

        //创建邮件对象
        Message message = new MimeMessage(session);
        //设置发件人
        message.setFrom(new InternetAddress("jh19970904@163.com"));//自已的email

        //设置收件人
        message.setRecipient(RecipientType.TO, new InternetAddress(to));

        //设置邮箱的主题
        message.setSubject("来自<font color='red'>蒋浩</font>网站");

        //设置正文
        message.setContent("<h1>来自<font color='red'>jh</font>的网站</h1><h3>" +
                "<a href='http://39.105.25.52:8080/jh/'>点击查看网站</a></h3>", "text/html;charset=UTF-8");

        //设置发送时间
        message.setSentDate(new Date());

        //发送
        Transport.send(message);
    }

    public static void main(String[] args) throws Exception {
        MailTest.sendMail("464062919@qq.com");
    }
}
