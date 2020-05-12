package com.cofire.basic.mail;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import org.apache.poi.util.IOUtils;
import org.springframework.util.ResourceUtils;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @ClassName: Sendmail
 * @Description: 发送Email
 * @author: 孤傲苍狼
 * @date: 2015-1-12 下午9:42:56
 *
 */
public class SendTemplateMail {

    private static final String ENCODING = "UTF-8";
    private static final String TEMPLATE_NAME = "MAIL_TEMPLATE";
    private static Template MAIL_TEMPLATE;

    static {
        System.out.println("加载静态");
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_21);
        cfg.setDefaultEncoding(ENCODING);
        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
        cfg.setTemplateLoader(stringTemplateLoader);
        InputStreamReader isr = null;
        try {
            // 这是一个springboot项目，我的模板文件放在resource文件夹下的templates文件夹下
            isr = new InputStreamReader(new FileInputStream(ResourceUtils.getFile("C:\\liying\\github\\javaBasic\\src\\template\\template.html")), ENCODING);
            MAIL_TEMPLATE = new Template(TEMPLATE_NAME, isr, cfg);
        } catch (Exception e) {
            System.out.println(e);
            MAIL_TEMPLATE = null;
        } finally {
            IOUtils.closeQuietly(isr);
        }
    }

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
        Message message = createSimpleMail(session);
        // 5、发送邮件
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
    }

    /**
     * @Method: createSimpleMail
     * @Description: 创建一封只包含文本的邮件
     * @Anthor:孤傲苍狼
     *
     * @param session
     * @return
     * @throws Exception
     */
    public static MimeMessage createSimpleMail(Session session) throws Exception {
        // 创建邮件对象
        MimeMessage message = new MimeMessage(session);
        // 指明邮件的发件人
        message.setFrom(new InternetAddress("yli_666@163.com"));
        // Address[] internetAddressTo = new InternetAddress().parse("yli_666@outlook.com,yli_666@163.com");
        // 指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("yli_666@outlook.com"));
        // message.setRecipient(Message.RecipientType.BCC, new InternetAddress("yli_666@163.com"));
        // 要被设置为 TO, CC 或者 BCC，这里 CC 代表抄送、BCC 代表秘密抄送。举例：Message.RecipientType.TO
        // message.setRecipients(Message.RecipientType.TO, internetAddressTo);
        // 邮件的标题
        message.setSubject("测试邮件");

        StringWriter out = new StringWriter();
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "liying");
        List<Map<String, String>> testList = new ArrayList<>();
        HashMap<String, String> mapTemp = new HashMap<>();
        mapTemp.put("name", "ying");
        mapTemp.put("no", "1234");
        testList.add(mapTemp);
        map.put("testList", testList);
        MAIL_TEMPLATE.process(map, out);
        out.flush();
        String context = out.toString();

        // 邮件的文本内容
        // message.setContent(context, "text/html;charset=UTF-8");

        // 正文
        MimeBodyPart text = new MimeBodyPart();
        text.setContent(context, "text/html;charset=UTF-8");

        // 创建容器描述数据关系
        MimeMultipart mp = new MimeMultipart();
        mp.addBodyPart(text);
        mp.setSubType("related");

        // 附件
        MimeBodyPart attach = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource("src\\source\\1.jpg"));
        attach.setDataHandler(dh);
        attach.setFileName(dh.getName());

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

        // 返回创建好的邮件对象
        return message;
    }

}
