package com.cofire.utils.mail;

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
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.NoSuchProviderException;
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

public class SendTemplateMailUtil {

    private static final String ENCODING = "UTF-8";
    private static final String TEMPLATE_NAME = "MAIL_TEMPLATE";

    private static String mailHost = "smtp.163.com";
    private static String mailProtocol = "smtp";
    private static String mailAuth = "true";
    private static String mailAccount = "yli_666@163.com";
    private static String mailPwd = "pwd";

    /**
     * 
     * @Title: getMailTemplate
     * @author ly
     * @Description: 加载邮件模板
     * @param pathName 模板路径
     * @return
     * @return Template 返回类型
     */
    public static Template getMailTemplate(String pathName) {
        System.out.println("加载静态");
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_21);
        cfg.setDefaultEncoding(ENCODING);
        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
        cfg.setTemplateLoader(stringTemplateLoader);
        InputStreamReader isr = null;
        Template mailTemplate = null;
        try {
            // 这是一个springboot项目，我的模板文件放在resource文件夹下的templates文件夹下
            isr = new InputStreamReader(new FileInputStream(ResourceUtils.getFile(pathName)), ENCODING);
            mailTemplate = new Template(TEMPLATE_NAME, isr, cfg);
        } catch (Exception e) {
            System.out.println(e);
            mailTemplate = null;
        } finally {
            IOUtils.closeQuietly(isr);
        }
        return mailTemplate;
    }

    // 创建邮件主题
    public static MimeMessage createMail(Session session, String title, Map<String, Object> map, String pathName, String toes, String ccs, String bccs,
            String[] files) throws Exception {
        // 创建邮件对象
        MimeMessage message = new MimeMessage(session);
        // 指明邮件的发件人
        message.setFrom(new InternetAddress(mailAccount));
        Address[] internetAddress = null;
        new InternetAddress();
        // 指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
        if (toes != null && toes.trim().length() > 0) {
            internetAddress = InternetAddress.parse(toes);
            message.setRecipients(Message.RecipientType.TO, internetAddress);
        }
        if (ccs != null && ccs.trim().length() > 0) {
            internetAddress = InternetAddress.parse(ccs);
            message.setRecipients(Message.RecipientType.CC, internetAddress);
        }
        if (bccs != null && bccs.trim().length() > 0) {
            internetAddress = InternetAddress.parse(bccs);
            message.setRecipients(Message.RecipientType.BCC, internetAddress);
        }

        if (title == null || title.trim().length() == 0) {
            title = "无主题";
        }
        // 邮件的标题
        message.setSubject(title);

        StringWriter out = new StringWriter();
        Template mailTemplete = getMailTemplate(pathName);
        mailTemplete.process(map, out);
        out.flush();
        String context = out.toString();

        if (files == null || files.length == 0) {
            // 邮件的文本内容
            message.setContent(context, "text/html;charset=UTF-8");
        } else {
            // 正文
            MimeBodyPart text = new MimeBodyPart();
            text.setContent(context, "text/html;charset=UTF-8");
            // 创建容器描述数据关系
            MimeMultipart mp = new MimeMultipart();
            mp.addBodyPart(text);
            // mp.setSubType("related");
            for (String file : files) {
                // 附件
                MimeBodyPart attach = new MimeBodyPart();
                DataHandler dh = new DataHandler(new FileDataSource(file));
                attach.setDataHandler(dh);
                attach.setFileName(dh.getName());

                mp.addBodyPart(attach);
            }
            mp.setSubType("mixed");
            message.setContent(mp);
            message.saveChanges();
        }
        // 返回创建好的邮件对象
        return message;
    }

    /**
     * 
     * @Title: send
     * @author ly
     * @Description:
     * @param map 模板对应数据
     * @param title 邮件主题
     * @param pathName 模板路径
     * @param toes 收件人，多个收件人地址以逗号隔开
     * @param ccs 抄送人，多个抄送人以逗号隔开
     * @param bccs 秘密抄送人 多个秘密抄送人以逗号隔开
     * @param filePathes 附件文件路径
     * @return void 返回类型
     */
    public static Boolean send(String title, Map<String, Object> map, String pathName, String toes, String ccs, String bccs, String[] files) {
        if (pathName == null || pathName.trim().length() <= 0) {
            System.out.println("邮件模板不存在");
            return false;
        }
        if ((toes == null || toes.trim().length() <= 0) && (ccs == null || ccs.trim().length() <= 0) && (bccs == null || bccs.trim().length() <= 0)) {
            System.out.println("收件人，抄送人，秘密抄送人不能全部为空！");
            return false;
        }
        Properties prop = new Properties();
        prop.setProperty("mail.host", mailHost);
        prop.setProperty("mail.transport.protocol", mailProtocol);
        prop.setProperty("mail.smtp.auth", mailAuth);
        // 使用JavaMail发送邮件的5个步骤
        // 1、创建session
        Session session = Session.getInstance(prop);
        // 开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);
        // 2、通过session得到transport对象
        Transport ts;
        try {
            ts = session.getTransport();
            // 3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
            ts.connect(mailHost, mailAccount, mailPwd);
            // 4、创建邮件
            Message message = createMail(session, title, map, pathName, toes, ccs, bccs, files);
            // 5、发送邮件
            ts.sendMessage(message, message.getAllRecipients());
            ts.close();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "liying");
        List<Map<String, String>> testList = new ArrayList<>();
        HashMap<String, String> mapTemp = new HashMap<>();
        mapTemp.put("name", "ying");
        mapTemp.put("no", "1234");
        testList.add(mapTemp);
        map.put("testList", testList);
        String pathName = "src\\template\\template.html";
        String title = "测试邮件主题";
        String toes = "yli_666@outlook.com";
        String ccs = "yli_666@outlook.com";
        String bccs = "yli_666@163.com";
        String[] files = { "src\\source\\1.jpg", "src\\source\\4.rar" };
        send(title, map, pathName, toes, ccs, bccs, files);
    }
}
