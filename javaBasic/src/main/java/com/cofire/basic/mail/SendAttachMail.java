package com.cofire.basic.mail;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendAttachMail {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        Properties prop = new Properties();
        prop.setProperty("mail.host", "smtp.163.com");
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
        // 使用JavaMail发送邮件的5个步骤
        // 1、创建session
        Session session = Session.getInstance(prop);
        // 开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);
        // 2、通过session得到transport对象
        Transport ts = session.getTransport();
        // 3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
        ts.connect("smtp.163.com", "yli_666@163.com", "pwd");
        // 4、创建邮件
        Message message = createAttachMail(session);
        // 5、发送邮件
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
    }

    /**
     * @Method: createAttachMail
     * @Description: 创建一封带附件的邮件
     * @Anthor:孤傲苍狼
     *
     * @param session
     * @return
     * @throws Exception
     */
    public static MimeMessage createAttachMail(Session session) throws Exception {
        // 创建邮件
        MimeMessage message = new MimeMessage(session);

        // 设置邮件的基本信息
        message.setFrom(new InternetAddress("yli_666@163.com"));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("yli_666@163.com"));
        message.setSubject("带附件和带图片的的邮件");

        // 正文
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("附件邮件", "text/html;charset=UTF-8");

        // 附件
        MimeBodyPart attach = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource("src\\source\\1.jpg"));
        attach.setDataHandler(dh);
        attach.setFileName(dh.getName());

        // 创建容器描述数据关系
        MimeMultipart mp = new MimeMultipart();
        mp.addBodyPart(text);
        mp.setSubType("related");

        // 描述关系:正文和附件
        MimeMultipart mp1 = new MimeMultipart();
        mp1.addBodyPart(attach);
        // mp2.addBodyPart(attach2);

        // 代表正文的bodypart
        MimeBodyPart content = new MimeBodyPart();
        content.setContent(mp);
        mp1.addBodyPart(content);
        mp1.setSubType("mixed");

        message.setContent(mp1);
        message.saveChanges();

        // message.writeTo(new FileOutputStream("E:\\MixedMail.eml"));
        // 返回创建好的的邮件
        return message;
    }
}