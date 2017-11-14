package cn.sp.stati;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Created by 2YSP on 2017/10/23.
 */
public class MailSender {
    private static Properties prop = new Properties();
    private ConstantCacheCenter constantCacheCenter = ConstantCacheCenter.getInstance();
    String content;

    private static class MyAuthenticator extends Authenticator {
        private String username;
        private String password;

        public MyAuthenticator(String username, String password) {
            this.username = username;
            this.password = password;
        }

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }
    }

    public MailSender(String content) {
        this.content = content;
    }

    public void sendToAll() {
        List<String> receivers = constantCacheCenter.getReceivers();
        for (String receiver : receivers) {
            send(receiver);
        }
    }

    public void addReceiver(String receiver){
        List<String> receivers = constantCacheCenter.getReceivers();
        if (receivers == null){
            receivers = new ArrayList<>();
        }
        receivers.add(receiver);
        constantCacheCenter.setReceivers(receivers);
    }

    private void send(String receiver) {
        prop.setProperty("mail.transport.protocol", constantCacheCenter.getProtocol());
        prop.setProperty("mail.smtp.host", constantCacheCenter.getHost());
        prop.setProperty("mail.smtp.port", constantCacheCenter.getPort());
        prop.setProperty("mail.smtp.auth", "true");
        MailSSLSocketFactory mailSSLSocketFactory = null;
        try {
            mailSSLSocketFactory = new MailSSLSocketFactory();
            mailSSLSocketFactory.setTrustAllHosts(true);
        } catch (GeneralSecurityException e1) {
            e1.printStackTrace();
        }
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", mailSSLSocketFactory);
        //
        Session session = Session.getDefaultInstance(prop, new MyAuthenticator(constantCacheCenter.getUsername(), constantCacheCenter.getAuthorizationCode()));
        session.setDebug(true);
        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            mimeMessage.setFrom(new InternetAddress(constantCacheCenter.getSenderEmail(), constantCacheCenter.getSenderName()));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
            mimeMessage.setSubject("明日天气");
            mimeMessage.setSentDate(new Date());

            mimeMessage.setText("Hi, Dear: \n\n     上周到店次数统计数据如下：" + content);
            mimeMessage.saveChanges();
            Transport.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
