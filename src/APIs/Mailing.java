package APIs;

import Modules.Espritien;
import Modules.Extern;
import Modules.User;

import javax.mail.*;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailing {
    public static void sendMail(String email,String text,String subject) throws Exception{
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.ssl.enable", "true");
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("khedhribairem@gmail.com","esprin123.");
            }
        });
        Message message=new MimeMessage(session);
        message.setFrom(new InternetAddress("bairemkh@gmail.com"));
        message.setRecipient(RecipientType.TO,new InternetAddress(email));
        message.setSubject(subject);
        message.setContent(text,"text/html");
        message.setSentDate(new Date());
        Transport.send(message);
        System.out.println("sent!!");
    }

    public static String generateText(Espritien user){
        String text="<style>\n" +
                "\n" +
                "#outlook a {\n" +
                "    padding: 0;\n" +
                "}\n" +
                "\n" +
                ".ExternalClass {\n" +
                "    width: 100%;\n" +
                "}\n" +
                "\n" +
                ".ExternalClass,\n" +
                ".ExternalClass p,\n" +
                ".ExternalClass span,\n" +
                ".ExternalClass font,\n" +
                ".ExternalClass td,\n" +
                ".ExternalClass div {\n" +
                "    line-height: 100%;\n" +
                "}\n" +
                "\n" +
                ".es-button {\n" +
                "    mso-style-priority: 100 !important;\n" +
                "    text-decoration: none !important;\n" +
                "}\n" +
                "\n" +
                "a[x-apple-data-detectors] {\n" +
                "    color: inherit !important;\n" +
                "    text-decoration: none !important;\n" +
                "    font-size: inherit !important;\n" +
                "    font-family: inherit !important;\n" +
                "    font-weight: inherit !important;\n" +
                "    line-height: inherit !important;\n" +
                "}\n" +
                "\n" +
                ".es-desk-hidden {\n" +
                "    display: none;\n" +
                "    float: left;\n" +
                "    overflow: hidden;\n" +
                "    width: 0;\n" +
                "    max-height: 0;\n" +
                "    line-height: 0;\n" +
                "    mso-hide: all;\n" +
                "}\n" +
                "\n" +
                "[data-ogsb] .es-button {\n" +
                "    border-width: 0 !important;\n" +
                "    padding: 10px 20px 10px 20px !important;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "/*\n" +
                "END OF IMPORTANT\n" +
                "*/\n" +
                "\n" +
                "s {\n" +
                "    text-decoration: line-through;\n" +
                "}\n" +
                "\n" +
                "html,\n" +
                "body {\n" +
                "    width: 100%;\n" +
                "    font-family: helvetica, 'helvetica neue', arial, verdana, sans-serif;\n" +
                "    -webkit-text-size-adjust: 100%;\n" +
                "    -ms-text-size-adjust: 100%;\n" +
                "}\n" +
                "\n" +
                "table {\n" +
                "    mso-table-lspace: 0pt;\n" +
                "    mso-table-rspace: 0pt;\n" +
                "    border-collapse: collapse;\n" +
                "    border-spacing: 0px;\n" +
                "}\n" +
                "\n" +
                "table td,\n" +
                "html,\n" +
                "body,\n" +
                ".es-wrapper {\n" +
                "    padding: 0;\n" +
                "    Margin: 0;\n" +
                "}\n" +
                "\n" +
                ".es-content,\n" +
                ".es-header,\n" +
                ".es-footer {\n" +
                "    table-layout: fixed !important;\n" +
                "    width: 100%;\n" +
                "}\n" +
                "\n" +
                "img {\n" +
                "    display: block;\n" +
                "    border: 0;\n" +
                "    outline: none;\n" +
                "    text-decoration: none;\n" +
                "    -ms-interpolation-mode: bicubic;\n" +
                "}\n" +
                "\n" +
                "table tr {\n" +
                "    border-collapse: collapse;\n" +
                "}\n" +
                "\n" +
                "p,\n" +
                "hr {\n" +
                "    Margin: 0;\n" +
                "}\n" +
                "\n" +
                "h1,\n" +
                "h2,\n" +
                "h3,\n" +
                "h4,\n" +
                "h5 {\n" +
                "    Margin: 0;\n" +
                "    line-height: 120%;\n" +
                "    mso-line-height-rule: exactly;\n" +
                "    font-family: roboto, 'helvetica neue', helvetica, arial, sans-serif;\n" +
                "}\n" +
                "\n" +
                "p,\n" +
                "ul li,\n" +
                "ol li,\n" +
                "a {\n" +
                "    -webkit-text-size-adjust: none;\n" +
                "    -ms-text-size-adjust: none;\n" +
                "    mso-line-height-rule: exactly;\n" +
                "}\n" +
                "\n" +
                ".es-left {\n" +
                "    float: left;\n" +
                "}\n" +
                "\n" +
                ".es-right {\n" +
                "    float: right;\n" +
                "}\n" +
                "\n" +
                ".es-p5 {\n" +
                "    padding: 5px;\n" +
                "}\n" +
                "\n" +
                ".es-p5t {\n" +
                "    padding-top: 5px;\n" +
                "}\n" +
                "\n" +
                ".es-p5b {\n" +
                "    padding-bottom: 5px;\n" +
                "}\n" +
                "\n" +
                ".es-p5l {\n" +
                "    padding-left: 5px;\n" +
                "}\n" +
                "\n" +
                ".es-p5r {\n" +
                "    padding-right: 5px;\n" +
                "}\n" +
                "\n" +
                ".es-p10 {\n" +
                "    padding: 10px;\n" +
                "}\n" +
                "\n" +
                ".es-p10t {\n" +
                "    padding-top: 10px;\n" +
                "}\n" +
                "\n" +
                ".es-p10b {\n" +
                "    padding-bottom: 10px;\n" +
                "}\n" +
                "\n" +
                ".es-p10l {\n" +
                "    padding-left: 10px;\n" +
                "}\n" +
                "\n" +
                ".es-p10r {\n" +
                "    padding-right: 10px;\n" +
                "}\n" +
                "\n" +
                ".es-p15 {\n" +
                "    padding: 15px;\n" +
                "}\n" +
                "\n" +
                ".es-p15t {\n" +
                "    padding-top: 15px;\n" +
                "}\n" +
                "\n" +
                ".es-p15b {\n" +
                "    padding-bottom: 15px;\n" +
                "}\n" +
                "\n" +
                ".es-p15l {\n" +
                "    padding-left: 15px;\n" +
                "}\n" +
                "\n" +
                ".es-p15r {\n" +
                "    padding-right: 15px;\n" +
                "}\n" +
                "\n" +
                ".es-p20 {\n" +
                "    padding: 20px;\n" +
                "}\n" +
                "\n" +
                ".es-p20t {\n" +
                "    padding-top: 20px;\n" +
                "}\n" +
                "\n" +
                ".es-p20b {\n" +
                "    padding-bottom: 20px;\n" +
                "}\n" +
                "\n" +
                ".es-p20l {\n" +
                "    padding-left: 20px;\n" +
                "}\n" +
                "\n" +
                ".es-p20r {\n" +
                "    padding-right: 20px;\n" +
                "}\n" +
                "\n" +
                ".es-p25 {\n" +
                "    padding: 25px;\n" +
                "}\n" +
                "\n" +
                ".es-p25t {\n" +
                "    padding-top: 25px;\n" +
                "}\n" +
                "\n" +
                ".es-p25b {\n" +
                "    padding-bottom: 25px;\n" +
                "}\n" +
                "\n" +
                ".es-p25l {\n" +
                "    padding-left: 25px;\n" +
                "}\n" +
                "\n" +
                ".es-p25r {\n" +
                "    padding-right: 25px;\n" +
                "}\n" +
                "\n" +
                ".es-p30 {\n" +
                "    padding: 30px;\n" +
                "}\n" +
                "\n" +
                ".es-p30t {\n" +
                "    padding-top: 30px;\n" +
                "}\n" +
                "\n" +
                ".es-p30b {\n" +
                "    padding-bottom: 30px;\n" +
                "}\n" +
                "\n" +
                ".es-p30l {\n" +
                "    padding-left: 30px;\n" +
                "}\n" +
                "\n" +
                ".es-p30r {\n" +
                "    padding-right: 30px;\n" +
                "}\n" +
                "\n" +
                ".es-p35 {\n" +
                "    padding: 35px;\n" +
                "}\n" +
                "\n" +
                ".es-p35t {\n" +
                "    padding-top: 35px;\n" +
                "}\n" +
                "\n" +
                ".es-p35b {\n" +
                "    padding-bottom: 35px;\n" +
                "}\n" +
                "\n" +
                ".es-p35l {\n" +
                "    padding-left: 35px;\n" +
                "}\n" +
                "\n" +
                ".es-p35r {\n" +
                "    padding-right: 35px;\n" +
                "}\n" +
                "\n" +
                ".es-p40 {\n" +
                "    padding: 40px;\n" +
                "}\n" +
                "\n" +
                ".es-p40t {\n" +
                "    padding-top: 40px;\n" +
                "}\n" +
                "\n" +
                ".es-p40b {\n" +
                "    padding-bottom: 40px;\n" +
                "}\n" +
                "\n" +
                ".es-p40l {\n" +
                "    padding-left: 40px;\n" +
                "}\n" +
                "\n" +
                ".es-p40r {\n" +
                "    padding-right: 40px;\n" +
                "}\n" +
                "\n" +
                ".es-menu td {\n" +
                "    border: 0;\n" +
                "}\n" +
                "\n" +
                ".es-menu td a img {\n" +
                "    display: inline-block !important;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "/*\n" +
                "END CONFIG STYLES\n" +
                "*/\n" +
                "\n" +
                "a {\n" +
                "    text-decoration: none;\n" +
                "}\n" +
                "\n" +
                "p,\n" +
                "ul li,\n" +
                "ol li {\n" +
                "    font-family: helvetica, 'helvetica neue', arial, verdana, sans-serif;\n" +
                "    line-height: 150%;\n" +
                "}\n" +
                "\n" +
                "ul li,\n" +
                "ol li {\n" +
                "    Margin-bottom: 15px;\n" +
                "    margin-left: 0;\n" +
                "}\n" +
                "\n" +
                ".es-menu td a {\n" +
                "    text-decoration: none;\n" +
                "    display: block;\n" +
                "    font-family: helvetica, 'helvetica neue', arial, verdana, sans-serif;\n" +
                "}\n" +
                "\n" +
                ".es-wrapper {\n" +
                "    width: 100%;\n" +
                "    height: 100%;\n" +
                "    background-repeat: repeat;\n" +
                "    background-position: center top;\n" +
                "}\n" +
                "\n" +
                ".es-wrapper-color {\n" +
                "    background-color: #ffffff;\n" +
                "}\n" +
                "\n" +
                ".es-header {\n" +
                "    background-color: transparent;\n" +
                "    background-image: ;\n" +
                "    background-repeat: repeat;\n" +
                "    background-position: center top;\n" +
                "}\n" +
                "\n" +
                ".es-header-body {\n" +
                "    background-color: transparent;\n" +
                "}\n" +
                "\n" +
                ".es-header-body p,\n" +
                ".es-header-body ul li,\n" +
                ".es-header-body ol li {\n" +
                "    color: #333333;\n" +
                "    font-size: 14px;\n" +
                "}\n" +
                "\n" +
                ".es-header-body a {\n" +
                "    color: #f6a1b4;\n" +
                "    font-size: 14px;\n" +
                "}\n" +
                "\n" +
                ".es-content-body {\n" +
                "    background-color: #ffffff;\n" +
                "}\n" +
                "\n" +
                ".es-content-body p,\n" +
                ".es-content-body ul li,\n" +
                ".es-content-body ol li {\n" +
                "    color: #333333;\n" +
                "    font-size: 14px;\n" +
                "}\n" +
                "\n" +
                ".es-content-body a {\n" +
                "    color: #f6a1b4;\n" +
                "    font-size: 14px;\n" +
                "}\n" +
                "\n" +
                ".es-footer {\n" +
                "    background-color: transparent;\n" +
                "    background-image: ;\n" +
                "    background-repeat: repeat;\n" +
                "    background-position: center top;\n" +
                "}\n" +
                "\n" +
                ".es-footer-body {\n" +
                "    background-color: #666666;\n" +
                "}\n" +
                "\n" +
                ".es-footer-body p,\n" +
                ".es-footer-body ul li,\n" +
                ".es-footer-body ol li {\n" +
                "    color: #ffffff;\n" +
                "    font-size: 14px;\n" +
                "}\n" +
                "\n" +
                ".es-footer-body a {\n" +
                "    color: #f6a1b4;\n" +
                "    font-size: 14px;\n" +
                "}\n" +
                "\n" +
                ".es-infoblock,\n" +
                ".es-infoblock p,\n" +
                ".es-infoblock ul li,\n" +
                ".es-infoblock ol li {\n" +
                "    line-height: 120%;\n" +
                "    font-size: 12px;\n" +
                "    color: #cccccc;\n" +
                "}\n" +
                "\n" +
                ".es-infoblock a {\n" +
                "    font-size: 12px;\n" +
                "    color: #cccccc;\n" +
                "}\n" +
                "\n" +
                "h1 {\n" +
                "    font-size: 30px;\n" +
                "    font-style: normal;\n" +
                "    font-weight: normal;\n" +
                "    color: #333333;\n" +
                "}\n" +
                "\n" +
                "h2 {\n" +
                "    font-size: 26px;\n" +
                "    font-style: normal;\n" +
                "    font-weight: normal;\n" +
                "    color: #333333;\n" +
                "}\n" +
                "\n" +
                "h3 {\n" +
                "    font-size: 18px;\n" +
                "    font-style: normal;\n" +
                "    font-weight: normal;\n" +
                "    color: #333333;\n" +
                "}\n" +
                "\n" +
                ".es-header-body h1 a,\n" +
                ".es-content-body h1 a,\n" +
                ".es-footer-body h1 a {\n" +
                "    font-size: 30px;\n" +
                "}\n" +
                "\n" +
                ".es-header-body h2 a,\n" +
                ".es-content-body h2 a,\n" +
                ".es-footer-body h2 a {\n" +
                "    font-size: 26px;\n" +
                "}\n" +
                "\n" +
                ".es-header-body h3 a,\n" +
                ".es-content-body h3 a,\n" +
                ".es-footer-body h3 a {\n" +
                "    font-size: 18px;\n" +
                "}\n" +
                "\n" +
                "a.es-button,\n" +
                "button.es-button {\n" +
                "    border-style: solid;\n" +
                "    border-color: #f8f3ef;\n" +
                "    border-width: 10px 20px 10px 20px;\n" +
                "    display: inline-block;\n" +
                "    background: #f8f3ef;\n" +
                "    border-radius: 3px;\n" +
                "    font-size: 17px;\n" +
                "    font-family: roboto, 'helvetica neue', helvetica, arial, sans-serif;\n" +
                "    font-weight: normal;\n" +
                "    font-style: normal;\n" +
                "    line-height: 120%;\n" +
                "    color: #64434a;\n" +
                "    text-decoration: none;\n" +
                "    width: auto;\n" +
                "    text-align: center;\n" +
                "}\n" +
                "\n" +
                ".es-button-border {\n" +
                "    border-style: solid solid solid solid;\n" +
                "    border-color: transparent transparent transparent transparent;\n" +
                "    background: #f8f3ef;\n" +
                "    border-width: 0px 0px 0px 0px;\n" +
                "    display: inline-block;\n" +
                "    border-radius: 3px;\n" +
                "    width: auto;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "/*\n" +
                "RESPONSIVE STYLES\n" +
                "Please do not delete and edit CSS styles below.\n" +
                " \n" +
                "If you don't need responsive layout, please delete this section.\n" +
                "*/\n" +
                "\n" +
                "@media only screen and (max-width: 600px) {\n" +
                "    p,\n" +
                "    ul li,\n" +
                "    ol li,\n" +
                "    a {\n" +
                "        line-height: 150% !important;\n" +
                "    }\n" +
                "    h1,\n" +
                "    h2,\n" +
                "    h3,\n" +
                "    h1 a,\n" +
                "    h2 a,\n" +
                "    h3 a {\n" +
                "        line-height: 120% !important;\n" +
                "    }\n" +
                "    h1 {\n" +
                "        font-size: 30px !important;\n" +
                "        text-align: center;\n" +
                "    }\n" +
                "    h2 {\n" +
                "        font-size: 26px !important;\n" +
                "        text-align: center;\n" +
                "    }\n" +
                "    h3 {\n" +
                "        font-size: 20px !important;\n" +
                "        text-align: center;\n" +
                "    }\n" +
                "    .es-header-body h1 a,\n" +
                "    .es-content-body h1 a,\n" +
                "    .es-footer-body h1 a {\n" +
                "        font-size: 30px !important;\n" +
                "    }\n" +
                "    .es-header-body h2 a,\n" +
                "    .es-content-body h2 a,\n" +
                "    .es-footer-body h2 a {\n" +
                "        font-size: 26px !important;\n" +
                "    }\n" +
                "    .es-header-body h3 a,\n" +
                "    .es-content-body h3 a,\n" +
                "    .es-footer-body h3 a {\n" +
                "        font-size: 20px !important;\n" +
                "    }\n" +
                "    .es-menu td a {\n" +
                "        font-size: 14px !important;\n" +
                "    }\n" +
                "    .es-header-body p,\n" +
                "    .es-header-body ul li,\n" +
                "    .es-header-body ol li,\n" +
                "    .es-header-body a {\n" +
                "        font-size: 14px !important;\n" +
                "    }\n" +
                "    .es-content-body p,\n" +
                "    .es-content-body ul li,\n" +
                "    .es-content-body ol li,\n" +
                "    .es-content-body a {\n" +
                "        font-size: 16px !important;\n" +
                "    }\n" +
                "    .es-footer-body p,\n" +
                "    .es-footer-body ul li,\n" +
                "    .es-footer-body ol li,\n" +
                "    .es-footer-body a {\n" +
                "        font-size: 14px !important;\n" +
                "    }\n" +
                "    .es-infoblock p,\n" +
                "    .es-infoblock ul li,\n" +
                "    .es-infoblock ol li,\n" +
                "    .es-infoblock a {\n" +
                "        font-size: 12px !important;\n" +
                "    }\n" +
                "    *[class=\"gmail-fix\"] {\n" +
                "        display: none !important;\n" +
                "    }\n" +
                "    .es-m-txt-c,\n" +
                "    .es-m-txt-c h1,\n" +
                "    .es-m-txt-c h2,\n" +
                "    .es-m-txt-c h3 {\n" +
                "        text-align: center !important;\n" +
                "    }\n" +
                "    .es-m-txt-r,\n" +
                "    .es-m-txt-r h1,\n" +
                "    .es-m-txt-r h2,\n" +
                "    .es-m-txt-r h3 {\n" +
                "        text-align: right !important;\n" +
                "    }\n" +
                "    .es-m-txt-l,\n" +
                "    .es-m-txt-l h1,\n" +
                "    .es-m-txt-l h2,\n" +
                "    .es-m-txt-l h3 {\n" +
                "        text-align: left !important;\n" +
                "    }\n" +
                "    .es-m-txt-r img,\n" +
                "    .es-m-txt-c img,\n" +
                "    .es-m-txt-l img {\n" +
                "        display: inline !important;\n" +
                "    }\n" +
                "    .es-button-border {\n" +
                "        display: inline-block !important;\n" +
                "    }\n" +
                "    a.es-button,\n" +
                "    button.es-button {\n" +
                "        font-size: 20px !important;\n" +
                "        display: inline-block !important;\n" +
                "    }\n" +
                "    .es-btn-fw {\n" +
                "        border-width: 10px 0px !important;\n" +
                "        text-align: center !important;\n" +
                "    }\n" +
                "    .es-adaptive table,\n" +
                "    .es-btn-fw,\n" +
                "    .es-btn-fw-brdr,\n" +
                "    .es-left,\n" +
                "    .es-right {\n" +
                "        width: 100% !important;\n" +
                "    }\n" +
                "    .es-content table,\n" +
                "    .es-header table,\n" +
                "    .es-footer table,\n" +
                "    .es-content,\n" +
                "    .es-footer,\n" +
                "    .es-header {\n" +
                "        width: 100% !important;\n" +
                "        max-width: 600px !important;\n" +
                "    }\n" +
                "    .es-adapt-td {\n" +
                "        display: block !important;\n" +
                "        width: 100% !important;\n" +
                "    }\n" +
                "    .adapt-img {\n" +
                "        width: 100% !important;\n" +
                "        height: auto !important;\n" +
                "    }\n" +
                "    .es-m-p0 {\n" +
                "        padding: 0px !important;\n" +
                "    }\n" +
                "    .es-m-p0r {\n" +
                "        padding-right: 0px !important;\n" +
                "    }\n" +
                "    .es-m-p0l {\n" +
                "        padding-left: 0px !important;\n" +
                "    }\n" +
                "    .es-m-p0t {\n" +
                "        padding-top: 0px !important;\n" +
                "    }\n" +
                "    .es-m-p0b {\n" +
                "        padding-bottom: 0 !important;\n" +
                "    }\n" +
                "    .es-m-p20b {\n" +
                "        padding-bottom: 20px !important;\n" +
                "    }\n" +
                "    .es-mobile-hidden,\n" +
                "    .es-hidden {\n" +
                "        display: none !important;\n" +
                "    }\n" +
                "    tr.es-desk-hidden,\n" +
                "    td.es-desk-hidden,\n" +
                "    table.es-desk-hidden {\n" +
                "        width: auto!important;\n" +
                "        overflow: visible!important;\n" +
                "        float: none!important;\n" +
                "        max-height: inherit!important;\n" +
                "        line-height: inherit!important;\n" +
                "    }\n" +
                "    tr.es-desk-hidden {\n" +
                "        display: table-row !important;\n" +
                "    }\n" +
                "    table.es-desk-hidden {\n" +
                "        display: table !important;\n" +
                "    }\n" +
                "    td.es-desk-menu-hidden {\n" +
                "        display: table-cell!important;\n" +
                "    }\n" +
                "    .es-menu td {\n" +
                "        width: 1% !important;\n" +
                "    }\n" +
                "    table.es-table-not-adapt,\n" +
                "    .esd-block-html table {\n" +
                "        width: auto !important;\n" +
                "    }\n" +
                "    table.es-social {\n" +
                "        display: inline-block !important;\n" +
                "    }\n" +
                "    table.es-social td {\n" +
                "        display: inline-block !important;\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "\n" +
                "/*\n" +
                "END RESPONSIVE STYLES\n" +
                "*/\n" +
                "    </style>\n" +
                "    <div class=\"es-wrapper-color\">\n" +
                "        <table class=\"es-wrapper\" style=\"background-position: center top;\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "            <tbody>\n" +
                "                <tr>\n" +
                "                    <td class=\"esd-email-paddings\" valign=\"top\">\n" +
                "                        <table class=\"es-header esd-header-popover\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td class=\"esd-stripe\" esd-custom-block-id=\"15610\" align=\"center\">\n" +
                "                                        <table class=\"es-header-body\" style=\"background-color: transparent;\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
                "                                            <tbody>\n" +
                "                                                <tr>\n" +
                "                                                    <td class=\"esd-structure\" align=\"left\">\n" +
                "                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                                            <tbody>\n" +
                "                                                                <tr>\n" +
                "                                                                    <td class=\"esd-container-frame\" width=\"600\" valign=\"top\" align=\"center\">\n" +
                "                                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td align=\"center\" class=\"esd-block-image\" style=\"font-size: 0px;\">\n" +
                "                                                                                        <a target=\"_blank\"><img class=\"adapt-img\" src=\"https://demo.stripocdn.email/content/guids/044e6da1-7cab-4976-8d32-6b98124ab427/images/logo_app.png\" alt style=\"display: block;\" width=\"150\"></a>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </td>\n" +
                "                                                                </tr>\n" +
                "                                                            </tbody>\n" +
                "                                                        </table>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                            </tbody>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                        <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td class=\"esd-stripe\" align=\"center\">\n" +
                "                                        <table class=\"es-content-body\" style=\"background-color: transparent;\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
                "                                            <tbody>\n" +
                "                                                <tr>\n" +
                "                                                    <td class=\"esd-structure\" align=\"left\">\n" +
                "                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                                            <tbody>\n" +
                "                                                                <tr>\n" +
                "                                                                    <td class=\"esd-container-frame\" width=\"600\" valign=\"top\" align=\"center\">\n" +
                "                                                                        <table style=\"border-radius: 3px; border-collapse: separate; background-color: #fcfcfc;\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#fcfcfc\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td class=\"esd-block-text es-m-txt-l es-p30t es-p20r es-p20l\" align=\"left\">\n" +
                "                                                                                        <h2 style=\"color: #333333;\">Welcome!</h2>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td class=\"esd-block-text es-p10t es-p20r es-p20l\" bgcolor=\"#fcfcfc\" align=\"left\">\n" +
                "                                                                                        <p>Hi "+user.getFirstName()+" "+user.getLastName()+", we're glad you're here! <br>&nbsp;now you have access to the EsprIN application, what are you waiting for? <br>GO! GO! GO !!!&nbsp; use the information below to log in to your account</p>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </td>\n" +
                "                                                                </tr>\n" +
                "                                                            </tbody>\n" +
                "                                                        </table>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                                <tr>\n" +
                "                                                    <td class=\"esd-structure es-p30t es-p20r es-p20l\" style=\"background-color: #fcfcfc;\" esd-custom-block-id=\"15791\" bgcolor=\"#fcfcfc\" align=\"left\">\n" +
                "                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                                            <tbody>\n" +
                "                                                                <tr>\n" +
                "                                                                    <td class=\"esd-container-frame\" width=\"560\" valign=\"top\" align=\"center\">\n" +
                "                                                                        <table style=\"border-color: #efefef; border-style: solid; border-width: 1px; border-radius: 3px; border-collapse: separate; background-color: #ffffff;\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td class=\"esd-block-text es-p20t es-p15b\" align=\"center\">\n" +
                "                                                                                        <h3 style=\"color: #333333;\">Your account information:</h3>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td class=\"esd-block-text\" align=\"center\">\n" +
                "                                                                                        <p style=\"color: #64434a; font-size: 16px; line-height: 150%;\">Login: "+user.getEmail()+"</p>\n" +
                "                                                                                        <p style=\"color: #64434a; font-size: 16px; line-height: 150%;\">Password: "+user.getPasswd()+"</p>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </td>\n" +
                "                                                                </tr>\n" +
                "                                                            </tbody>\n" +
                "                                                        </table>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                            </tbody>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                        <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td class=\"esd-stripe\" style=\"background-color: #666666;\" esd-custom-block-id=\"15624\" bgcolor=\"#666666\" align=\"center\">\n" +
                "                                        <table class=\"es-content-body\" style=\"background-color: transparent;\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\">\n" +
                "                                            <tbody>\n" +
                "                                                <tr>\n" +
                "                                                    <td class=\"esd-structure\" align=\"left\">\n" +
                "                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                                            <tbody>\n" +
                "                                                                <tr>\n" +
                "                                                                    <td class=\"esd-container-frame\" width=\"600\" valign=\"top\" align=\"center\">\n" +
                "                                                                        <table style=\"background-color: #fff4f7; border-radius: 3px; border-collapse: separate;\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#fff4f7\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td class=\"esd-block-spacer es-p5t es-p5b es-p20r es-p20l\" bgcolor=\"#fff4f7\" align=\"center\" style=\"font-size:0\">\n" +
                "                                                                                        <table width=\"100%\" height=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n" +
                "                                                                                            <tbody>\n" +
                "                                                                                                <tr>\n" +
                "                                                                                                    <td style=\"border-bottom: 1px solid #fff4f7; background: rgba(0, 0, 0, 0) none repeat scroll 0% 0%; height: 1px; width: 100%; margin: 0px;\"></td>\n" +
                "                                                                                                </tr>\n" +
                "                                                                                            </tbody>\n" +
                "                                                                                        </table>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </td>\n" +
                "                                                                </tr>\n" +
                "                                                            </tbody>\n" +
                "                                                        </table>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                            </tbody>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                        <table class=\"esd-footer-popover es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td class=\"esd-stripe\" style=\"background-color: #d0cdcd;\" bgcolor=\"#d0cdcd\" align=\"center\">\n" +
                "                                        <table class=\"es-content-body\" style=\"background-color: #fef5f5;\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#fef5f5\" align=\"center\">\n" +
                "                                            <tbody>\n" +
                "                                                <tr>\n" +
                "                                                    <td class=\"esd-structure es-p30t es-p30b es-p20r es-p20l\" align=\"left\">\n" +
                "                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                                            <tbody>\n" +
                "                                                                <tr>\n" +
                "                                                                    <td class=\"esd-container-frame\" width=\"560\" valign=\"top\" align=\"center\">\n" +
                "                                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td align=\"center\" class=\"esd-block-image\" style=\"font-size: 0px;\">\n" +
                "                                                                                        <a target=\"_blank\"><img class=\"adapt-img\" src=\"https://demo.stripocdn.email/content/guids/044e6da1-7cab-4976-8d32-6b98124ab427/images/vikings.png\" alt style=\"display: block;\" width=\"100\"></a>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </td>\n" +
                "                                                                </tr>\n" +
                "                                                            </tbody>\n" +
                "                                                        </table>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                            </tbody>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "    </div>";

        return text;
    }
    public static String generateText(Extern user){
        String text="<style>\n" +
                "\n" +
                "#outlook a {\n" +
                "    padding: 0;\n" +
                "}\n" +
                "\n" +
                ".ExternalClass {\n" +
                "    width: 100%;\n" +
                "}\n" +
                "\n" +
                ".ExternalClass,\n" +
                ".ExternalClass p,\n" +
                ".ExternalClass span,\n" +
                ".ExternalClass font,\n" +
                ".ExternalClass td,\n" +
                ".ExternalClass div {\n" +
                "    line-height: 100%;\n" +
                "}\n" +
                "\n" +
                ".es-button {\n" +
                "    mso-style-priority: 100 !important;\n" +
                "    text-decoration: none !important;\n" +
                "}\n" +
                "\n" +
                "a[x-apple-data-detectors] {\n" +
                "    color: inherit !important;\n" +
                "    text-decoration: none !important;\n" +
                "    font-size: inherit !important;\n" +
                "    font-family: inherit !important;\n" +
                "    font-weight: inherit !important;\n" +
                "    line-height: inherit !important;\n" +
                "}\n" +
                "\n" +
                ".es-desk-hidden {\n" +
                "    display: none;\n" +
                "    float: left;\n" +
                "    overflow: hidden;\n" +
                "    width: 0;\n" +
                "    max-height: 0;\n" +
                "    line-height: 0;\n" +
                "    mso-hide: all;\n" +
                "}\n" +
                "\n" +
                "[data-ogsb] .es-button {\n" +
                "    border-width: 0 !important;\n" +
                "    padding: 10px 20px 10px 20px !important;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "/*\n" +
                "END OF IMPORTANT\n" +
                "*/\n" +
                "\n" +
                "s {\n" +
                "    text-decoration: line-through;\n" +
                "}\n" +
                "\n" +
                "html,\n" +
                "body {\n" +
                "    width: 100%;\n" +
                "    font-family: helvetica, 'helvetica neue', arial, verdana, sans-serif;\n" +
                "    -webkit-text-size-adjust: 100%;\n" +
                "    -ms-text-size-adjust: 100%;\n" +
                "}\n" +
                "\n" +
                "table {\n" +
                "    mso-table-lspace: 0pt;\n" +
                "    mso-table-rspace: 0pt;\n" +
                "    border-collapse: collapse;\n" +
                "    border-spacing: 0px;\n" +
                "}\n" +
                "\n" +
                "table td,\n" +
                "html,\n" +
                "body,\n" +
                ".es-wrapper {\n" +
                "    padding: 0;\n" +
                "    Margin: 0;\n" +
                "}\n" +
                "\n" +
                ".es-content,\n" +
                ".es-header,\n" +
                ".es-footer {\n" +
                "    table-layout: fixed !important;\n" +
                "    width: 100%;\n" +
                "}\n" +
                "\n" +
                "img {\n" +
                "    display: block;\n" +
                "    border: 0;\n" +
                "    outline: none;\n" +
                "    text-decoration: none;\n" +
                "    -ms-interpolation-mode: bicubic;\n" +
                "}\n" +
                "\n" +
                "table tr {\n" +
                "    border-collapse: collapse;\n" +
                "}\n" +
                "\n" +
                "p,\n" +
                "hr {\n" +
                "    Margin: 0;\n" +
                "}\n" +
                "\n" +
                "h1,\n" +
                "h2,\n" +
                "h3,\n" +
                "h4,\n" +
                "h5 {\n" +
                "    Margin: 0;\n" +
                "    line-height: 120%;\n" +
                "    mso-line-height-rule: exactly;\n" +
                "    font-family: roboto, 'helvetica neue', helvetica, arial, sans-serif;\n" +
                "}\n" +
                "\n" +
                "p,\n" +
                "ul li,\n" +
                "ol li,\n" +
                "a {\n" +
                "    -webkit-text-size-adjust: none;\n" +
                "    -ms-text-size-adjust: none;\n" +
                "    mso-line-height-rule: exactly;\n" +
                "}\n" +
                "\n" +
                ".es-left {\n" +
                "    float: left;\n" +
                "}\n" +
                "\n" +
                ".es-right {\n" +
                "    float: right;\n" +
                "}\n" +
                "\n" +
                ".es-p5 {\n" +
                "    padding: 5px;\n" +
                "}\n" +
                "\n" +
                ".es-p5t {\n" +
                "    padding-top: 5px;\n" +
                "}\n" +
                "\n" +
                ".es-p5b {\n" +
                "    padding-bottom: 5px;\n" +
                "}\n" +
                "\n" +
                ".es-p5l {\n" +
                "    padding-left: 5px;\n" +
                "}\n" +
                "\n" +
                ".es-p5r {\n" +
                "    padding-right: 5px;\n" +
                "}\n" +
                "\n" +
                ".es-p10 {\n" +
                "    padding: 10px;\n" +
                "}\n" +
                "\n" +
                ".es-p10t {\n" +
                "    padding-top: 10px;\n" +
                "}\n" +
                "\n" +
                ".es-p10b {\n" +
                "    padding-bottom: 10px;\n" +
                "}\n" +
                "\n" +
                ".es-p10l {\n" +
                "    padding-left: 10px;\n" +
                "}\n" +
                "\n" +
                ".es-p10r {\n" +
                "    padding-right: 10px;\n" +
                "}\n" +
                "\n" +
                ".es-p15 {\n" +
                "    padding: 15px;\n" +
                "}\n" +
                "\n" +
                ".es-p15t {\n" +
                "    padding-top: 15px;\n" +
                "}\n" +
                "\n" +
                ".es-p15b {\n" +
                "    padding-bottom: 15px;\n" +
                "}\n" +
                "\n" +
                ".es-p15l {\n" +
                "    padding-left: 15px;\n" +
                "}\n" +
                "\n" +
                ".es-p15r {\n" +
                "    padding-right: 15px;\n" +
                "}\n" +
                "\n" +
                ".es-p20 {\n" +
                "    padding: 20px;\n" +
                "}\n" +
                "\n" +
                ".es-p20t {\n" +
                "    padding-top: 20px;\n" +
                "}\n" +
                "\n" +
                ".es-p20b {\n" +
                "    padding-bottom: 20px;\n" +
                "}\n" +
                "\n" +
                ".es-p20l {\n" +
                "    padding-left: 20px;\n" +
                "}\n" +
                "\n" +
                ".es-p20r {\n" +
                "    padding-right: 20px;\n" +
                "}\n" +
                "\n" +
                ".es-p25 {\n" +
                "    padding: 25px;\n" +
                "}\n" +
                "\n" +
                ".es-p25t {\n" +
                "    padding-top: 25px;\n" +
                "}\n" +
                "\n" +
                ".es-p25b {\n" +
                "    padding-bottom: 25px;\n" +
                "}\n" +
                "\n" +
                ".es-p25l {\n" +
                "    padding-left: 25px;\n" +
                "}\n" +
                "\n" +
                ".es-p25r {\n" +
                "    padding-right: 25px;\n" +
                "}\n" +
                "\n" +
                ".es-p30 {\n" +
                "    padding: 30px;\n" +
                "}\n" +
                "\n" +
                ".es-p30t {\n" +
                "    padding-top: 30px;\n" +
                "}\n" +
                "\n" +
                ".es-p30b {\n" +
                "    padding-bottom: 30px;\n" +
                "}\n" +
                "\n" +
                ".es-p30l {\n" +
                "    padding-left: 30px;\n" +
                "}\n" +
                "\n" +
                ".es-p30r {\n" +
                "    padding-right: 30px;\n" +
                "}\n" +
                "\n" +
                ".es-p35 {\n" +
                "    padding: 35px;\n" +
                "}\n" +
                "\n" +
                ".es-p35t {\n" +
                "    padding-top: 35px;\n" +
                "}\n" +
                "\n" +
                ".es-p35b {\n" +
                "    padding-bottom: 35px;\n" +
                "}\n" +
                "\n" +
                ".es-p35l {\n" +
                "    padding-left: 35px;\n" +
                "}\n" +
                "\n" +
                ".es-p35r {\n" +
                "    padding-right: 35px;\n" +
                "}\n" +
                "\n" +
                ".es-p40 {\n" +
                "    padding: 40px;\n" +
                "}\n" +
                "\n" +
                ".es-p40t {\n" +
                "    padding-top: 40px;\n" +
                "}\n" +
                "\n" +
                ".es-p40b {\n" +
                "    padding-bottom: 40px;\n" +
                "}\n" +
                "\n" +
                ".es-p40l {\n" +
                "    padding-left: 40px;\n" +
                "}\n" +
                "\n" +
                ".es-p40r {\n" +
                "    padding-right: 40px;\n" +
                "}\n" +
                "\n" +
                ".es-menu td {\n" +
                "    border: 0;\n" +
                "}\n" +
                "\n" +
                ".es-menu td a img {\n" +
                "    display: inline-block !important;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "/*\n" +
                "END CONFIG STYLES\n" +
                "*/\n" +
                "\n" +
                "a {\n" +
                "    text-decoration: none;\n" +
                "}\n" +
                "\n" +
                "p,\n" +
                "ul li,\n" +
                "ol li {\n" +
                "    font-family: helvetica, 'helvetica neue', arial, verdana, sans-serif;\n" +
                "    line-height: 150%;\n" +
                "}\n" +
                "\n" +
                "ul li,\n" +
                "ol li {\n" +
                "    Margin-bottom: 15px;\n" +
                "    margin-left: 0;\n" +
                "}\n" +
                "\n" +
                ".es-menu td a {\n" +
                "    text-decoration: none;\n" +
                "    display: block;\n" +
                "    font-family: helvetica, 'helvetica neue', arial, verdana, sans-serif;\n" +
                "}\n" +
                "\n" +
                ".es-wrapper {\n" +
                "    width: 100%;\n" +
                "    height: 100%;\n" +
                "    background-repeat: repeat;\n" +
                "    background-position: center top;\n" +
                "}\n" +
                "\n" +
                ".es-wrapper-color {\n" +
                "    background-color: #ffffff;\n" +
                "}\n" +
                "\n" +
                ".es-header {\n" +
                "    background-color: transparent;\n" +
                "    background-image: ;\n" +
                "    background-repeat: repeat;\n" +
                "    background-position: center top;\n" +
                "}\n" +
                "\n" +
                ".es-header-body {\n" +
                "    background-color: transparent;\n" +
                "}\n" +
                "\n" +
                ".es-header-body p,\n" +
                ".es-header-body ul li,\n" +
                ".es-header-body ol li {\n" +
                "    color: #333333;\n" +
                "    font-size: 14px;\n" +
                "}\n" +
                "\n" +
                ".es-header-body a {\n" +
                "    color: #f6a1b4;\n" +
                "    font-size: 14px;\n" +
                "}\n" +
                "\n" +
                ".es-content-body {\n" +
                "    background-color: #ffffff;\n" +
                "}\n" +
                "\n" +
                ".es-content-body p,\n" +
                ".es-content-body ul li,\n" +
                ".es-content-body ol li {\n" +
                "    color: #333333;\n" +
                "    font-size: 14px;\n" +
                "}\n" +
                "\n" +
                ".es-content-body a {\n" +
                "    color: #f6a1b4;\n" +
                "    font-size: 14px;\n" +
                "}\n" +
                "\n" +
                ".es-footer {\n" +
                "    background-color: transparent;\n" +
                "    background-image: ;\n" +
                "    background-repeat: repeat;\n" +
                "    background-position: center top;\n" +
                "}\n" +
                "\n" +
                ".es-footer-body {\n" +
                "    background-color: #666666;\n" +
                "}\n" +
                "\n" +
                ".es-footer-body p,\n" +
                ".es-footer-body ul li,\n" +
                ".es-footer-body ol li {\n" +
                "    color: #ffffff;\n" +
                "    font-size: 14px;\n" +
                "}\n" +
                "\n" +
                ".es-footer-body a {\n" +
                "    color: #f6a1b4;\n" +
                "    font-size: 14px;\n" +
                "}\n" +
                "\n" +
                ".es-infoblock,\n" +
                ".es-infoblock p,\n" +
                ".es-infoblock ul li,\n" +
                ".es-infoblock ol li {\n" +
                "    line-height: 120%;\n" +
                "    font-size: 12px;\n" +
                "    color: #cccccc;\n" +
                "}\n" +
                "\n" +
                ".es-infoblock a {\n" +
                "    font-size: 12px;\n" +
                "    color: #cccccc;\n" +
                "}\n" +
                "\n" +
                "h1 {\n" +
                "    font-size: 30px;\n" +
                "    font-style: normal;\n" +
                "    font-weight: normal;\n" +
                "    color: #333333;\n" +
                "}\n" +
                "\n" +
                "h2 {\n" +
                "    font-size: 26px;\n" +
                "    font-style: normal;\n" +
                "    font-weight: normal;\n" +
                "    color: #333333;\n" +
                "}\n" +
                "\n" +
                "h3 {\n" +
                "    font-size: 18px;\n" +
                "    font-style: normal;\n" +
                "    font-weight: normal;\n" +
                "    color: #333333;\n" +
                "}\n" +
                "\n" +
                ".es-header-body h1 a,\n" +
                ".es-content-body h1 a,\n" +
                ".es-footer-body h1 a {\n" +
                "    font-size: 30px;\n" +
                "}\n" +
                "\n" +
                ".es-header-body h2 a,\n" +
                ".es-content-body h2 a,\n" +
                ".es-footer-body h2 a {\n" +
                "    font-size: 26px;\n" +
                "}\n" +
                "\n" +
                ".es-header-body h3 a,\n" +
                ".es-content-body h3 a,\n" +
                ".es-footer-body h3 a {\n" +
                "    font-size: 18px;\n" +
                "}\n" +
                "\n" +
                "a.es-button,\n" +
                "button.es-button {\n" +
                "    border-style: solid;\n" +
                "    border-color: #f8f3ef;\n" +
                "    border-width: 10px 20px 10px 20px;\n" +
                "    display: inline-block;\n" +
                "    background: #f8f3ef;\n" +
                "    border-radius: 3px;\n" +
                "    font-size: 17px;\n" +
                "    font-family: roboto, 'helvetica neue', helvetica, arial, sans-serif;\n" +
                "    font-weight: normal;\n" +
                "    font-style: normal;\n" +
                "    line-height: 120%;\n" +
                "    color: #64434a;\n" +
                "    text-decoration: none;\n" +
                "    width: auto;\n" +
                "    text-align: center;\n" +
                "}\n" +
                "\n" +
                ".es-button-border {\n" +
                "    border-style: solid solid solid solid;\n" +
                "    border-color: transparent transparent transparent transparent;\n" +
                "    background: #f8f3ef;\n" +
                "    border-width: 0px 0px 0px 0px;\n" +
                "    display: inline-block;\n" +
                "    border-radius: 3px;\n" +
                "    width: auto;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "/*\n" +
                "RESPONSIVE STYLES\n" +
                "Please do not delete and edit CSS styles below.\n" +
                " \n" +
                "If you don't need responsive layout, please delete this section.\n" +
                "*/\n" +
                "\n" +
                "@media only screen and (max-width: 600px) {\n" +
                "    p,\n" +
                "    ul li,\n" +
                "    ol li,\n" +
                "    a {\n" +
                "        line-height: 150% !important;\n" +
                "    }\n" +
                "    h1,\n" +
                "    h2,\n" +
                "    h3,\n" +
                "    h1 a,\n" +
                "    h2 a,\n" +
                "    h3 a {\n" +
                "        line-height: 120% !important;\n" +
                "    }\n" +
                "    h1 {\n" +
                "        font-size: 30px !important;\n" +
                "        text-align: center;\n" +
                "    }\n" +
                "    h2 {\n" +
                "        font-size: 26px !important;\n" +
                "        text-align: center;\n" +
                "    }\n" +
                "    h3 {\n" +
                "        font-size: 20px !important;\n" +
                "        text-align: center;\n" +
                "    }\n" +
                "    .es-header-body h1 a,\n" +
                "    .es-content-body h1 a,\n" +
                "    .es-footer-body h1 a {\n" +
                "        font-size: 30px !important;\n" +
                "    }\n" +
                "    .es-header-body h2 a,\n" +
                "    .es-content-body h2 a,\n" +
                "    .es-footer-body h2 a {\n" +
                "        font-size: 26px !important;\n" +
                "    }\n" +
                "    .es-header-body h3 a,\n" +
                "    .es-content-body h3 a,\n" +
                "    .es-footer-body h3 a {\n" +
                "        font-size: 20px !important;\n" +
                "    }\n" +
                "    .es-menu td a {\n" +
                "        font-size: 14px !important;\n" +
                "    }\n" +
                "    .es-header-body p,\n" +
                "    .es-header-body ul li,\n" +
                "    .es-header-body ol li,\n" +
                "    .es-header-body a {\n" +
                "        font-size: 14px !important;\n" +
                "    }\n" +
                "    .es-content-body p,\n" +
                "    .es-content-body ul li,\n" +
                "    .es-content-body ol li,\n" +
                "    .es-content-body a {\n" +
                "        font-size: 16px !important;\n" +
                "    }\n" +
                "    .es-footer-body p,\n" +
                "    .es-footer-body ul li,\n" +
                "    .es-footer-body ol li,\n" +
                "    .es-footer-body a {\n" +
                "        font-size: 14px !important;\n" +
                "    }\n" +
                "    .es-infoblock p,\n" +
                "    .es-infoblock ul li,\n" +
                "    .es-infoblock ol li,\n" +
                "    .es-infoblock a {\n" +
                "        font-size: 12px !important;\n" +
                "    }\n" +
                "    *[class=\"gmail-fix\"] {\n" +
                "        display: none !important;\n" +
                "    }\n" +
                "    .es-m-txt-c,\n" +
                "    .es-m-txt-c h1,\n" +
                "    .es-m-txt-c h2,\n" +
                "    .es-m-txt-c h3 {\n" +
                "        text-align: center !important;\n" +
                "    }\n" +
                "    .es-m-txt-r,\n" +
                "    .es-m-txt-r h1,\n" +
                "    .es-m-txt-r h2,\n" +
                "    .es-m-txt-r h3 {\n" +
                "        text-align: right !important;\n" +
                "    }\n" +
                "    .es-m-txt-l,\n" +
                "    .es-m-txt-l h1,\n" +
                "    .es-m-txt-l h2,\n" +
                "    .es-m-txt-l h3 {\n" +
                "        text-align: left !important;\n" +
                "    }\n" +
                "    .es-m-txt-r img,\n" +
                "    .es-m-txt-c img,\n" +
                "    .es-m-txt-l img {\n" +
                "        display: inline !important;\n" +
                "    }\n" +
                "    .es-button-border {\n" +
                "        display: inline-block !important;\n" +
                "    }\n" +
                "    a.es-button,\n" +
                "    button.es-button {\n" +
                "        font-size: 20px !important;\n" +
                "        display: inline-block !important;\n" +
                "    }\n" +
                "    .es-btn-fw {\n" +
                "        border-width: 10px 0px !important;\n" +
                "        text-align: center !important;\n" +
                "    }\n" +
                "    .es-adaptive table,\n" +
                "    .es-btn-fw,\n" +
                "    .es-btn-fw-brdr,\n" +
                "    .es-left,\n" +
                "    .es-right {\n" +
                "        width: 100% !important;\n" +
                "    }\n" +
                "    .es-content table,\n" +
                "    .es-header table,\n" +
                "    .es-footer table,\n" +
                "    .es-content,\n" +
                "    .es-footer,\n" +
                "    .es-header {\n" +
                "        width: 100% !important;\n" +
                "        max-width: 600px !important;\n" +
                "    }\n" +
                "    .es-adapt-td {\n" +
                "        display: block !important;\n" +
                "        width: 100% !important;\n" +
                "    }\n" +
                "    .adapt-img {\n" +
                "        width: 100% !important;\n" +
                "        height: auto !important;\n" +
                "    }\n" +
                "    .es-m-p0 {\n" +
                "        padding: 0px !important;\n" +
                "    }\n" +
                "    .es-m-p0r {\n" +
                "        padding-right: 0px !important;\n" +
                "    }\n" +
                "    .es-m-p0l {\n" +
                "        padding-left: 0px !important;\n" +
                "    }\n" +
                "    .es-m-p0t {\n" +
                "        padding-top: 0px !important;\n" +
                "    }\n" +
                "    .es-m-p0b {\n" +
                "        padding-bottom: 0 !important;\n" +
                "    }\n" +
                "    .es-m-p20b {\n" +
                "        padding-bottom: 20px !important;\n" +
                "    }\n" +
                "    .es-mobile-hidden,\n" +
                "    .es-hidden {\n" +
                "        display: none !important;\n" +
                "    }\n" +
                "    tr.es-desk-hidden,\n" +
                "    td.es-desk-hidden,\n" +
                "    table.es-desk-hidden {\n" +
                "        width: auto!important;\n" +
                "        overflow: visible!important;\n" +
                "        float: none!important;\n" +
                "        max-height: inherit!important;\n" +
                "        line-height: inherit!important;\n" +
                "    }\n" +
                "    tr.es-desk-hidden {\n" +
                "        display: table-row !important;\n" +
                "    }\n" +
                "    table.es-desk-hidden {\n" +
                "        display: table !important;\n" +
                "    }\n" +
                "    td.es-desk-menu-hidden {\n" +
                "        display: table-cell!important;\n" +
                "    }\n" +
                "    .es-menu td {\n" +
                "        width: 1% !important;\n" +
                "    }\n" +
                "    table.es-table-not-adapt,\n" +
                "    .esd-block-html table {\n" +
                "        width: auto !important;\n" +
                "    }\n" +
                "    table.es-social {\n" +
                "        display: inline-block !important;\n" +
                "    }\n" +
                "    table.es-social td {\n" +
                "        display: inline-block !important;\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "\n" +
                "/*\n" +
                "END RESPONSIVE STYLES\n" +
                "*/\n" +
                "    </style>\n" +
                "    <div class=\"es-wrapper-color\">\n" +
                "        <table class=\"es-wrapper\" style=\"background-position: center top;\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "            <tbody>\n" +
                "                <tr>\n" +
                "                    <td class=\"esd-email-paddings\" valign=\"top\">\n" +
                "                        <table class=\"es-header esd-header-popover\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td class=\"esd-stripe\" esd-custom-block-id=\"15610\" align=\"center\">\n" +
                "                                        <table class=\"es-header-body\" style=\"background-color: transparent;\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
                "                                            <tbody>\n" +
                "                                                <tr>\n" +
                "                                                    <td class=\"esd-structure\" align=\"left\">\n" +
                "                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                                            <tbody>\n" +
                "                                                                <tr>\n" +
                "                                                                    <td class=\"esd-container-frame\" width=\"600\" valign=\"top\" align=\"center\">\n" +
                "                                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td align=\"center\" class=\"esd-block-image\" style=\"font-size: 0px;\">\n" +
                "                                                                                        <a target=\"_blank\"><img class=\"adapt-img\" src=\"https://demo.stripocdn.email/content/guids/044e6da1-7cab-4976-8d32-6b98124ab427/images/logo_app.png\" alt style=\"display: block;\" width=\"150\"></a>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </td>\n" +
                "                                                                </tr>\n" +
                "                                                            </tbody>\n" +
                "                                                        </table>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                            </tbody>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                        <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td class=\"esd-stripe\" align=\"center\">\n" +
                "                                        <table class=\"es-content-body\" style=\"background-color: transparent;\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
                "                                            <tbody>\n" +
                "                                                <tr>\n" +
                "                                                    <td class=\"esd-structure\" align=\"left\">\n" +
                "                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                                            <tbody>\n" +
                "                                                                <tr>\n" +
                "                                                                    <td class=\"esd-container-frame\" width=\"600\" valign=\"top\" align=\"center\">\n" +
                "                                                                        <table style=\"border-radius: 3px; border-collapse: separate; background-color: #fcfcfc;\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#fcfcfc\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td class=\"esd-block-text es-m-txt-l es-p30t es-p20r es-p20l\" align=\"left\">\n" +
                "                                                                                        <h2 style=\"color: #333333;\">Welcome!</h2>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td class=\"esd-block-text es-p10t es-p20r es-p20l\" bgcolor=\"#fcfcfc\" align=\"left\">\n" +
                "                                                                                        <p>Hi "+user.getEntrepriseName()+", we're glad you're here! <br>&nbsp;now you have access to the EsprIN application, what are you waiting for? <br>GO! GO! GO !!!&nbsp; use the information below to log in to your account</p>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </td>\n" +
                "                                                                </tr>\n" +
                "                                                            </tbody>\n" +
                "                                                        </table>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                                <tr>\n" +
                "                                                    <td class=\"esd-structure es-p30t es-p20r es-p20l\" style=\"background-color: #fcfcfc;\" esd-custom-block-id=\"15791\" bgcolor=\"#fcfcfc\" align=\"left\">\n" +
                "                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                                            <tbody>\n" +
                "                                                                <tr>\n" +
                "                                                                    <td class=\"esd-container-frame\" width=\"560\" valign=\"top\" align=\"center\">\n" +
                "                                                                        <table style=\"border-color: #efefef; border-style: solid; border-width: 1px; border-radius: 3px; border-collapse: separate; background-color: #ffffff;\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td class=\"esd-block-text es-p20t es-p15b\" align=\"center\">\n" +
                "                                                                                        <h3 style=\"color: #333333;\">Your account information:</h3>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td class=\"esd-block-text\" align=\"center\">\n" +
                "                                                                                        <p style=\"color: #64434a; font-size: 16px; line-height: 150%;\">Login: "+user.getEmail()+"</p>\n" +
                "                                                                                        <p style=\"color: #64434a; font-size: 16px; line-height: 150%;\">Password: "+user.getPasswd()+"</p>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </td>\n" +
                "                                                                </tr>\n" +
                "                                                            </tbody>\n" +
                "                                                        </table>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                            </tbody>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                        <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td class=\"esd-stripe\" style=\"background-color: #666666;\" esd-custom-block-id=\"15624\" bgcolor=\"#666666\" align=\"center\">\n" +
                "                                        <table class=\"es-content-body\" style=\"background-color: transparent;\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\">\n" +
                "                                            <tbody>\n" +
                "                                                <tr>\n" +
                "                                                    <td class=\"esd-structure\" align=\"left\">\n" +
                "                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                                            <tbody>\n" +
                "                                                                <tr>\n" +
                "                                                                    <td class=\"esd-container-frame\" width=\"600\" valign=\"top\" align=\"center\">\n" +
                "                                                                        <table style=\"background-color: #fff4f7; border-radius: 3px; border-collapse: separate;\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#fff4f7\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td class=\"esd-block-spacer es-p5t es-p5b es-p20r es-p20l\" bgcolor=\"#fff4f7\" align=\"center\" style=\"font-size:0\">\n" +
                "                                                                                        <table width=\"100%\" height=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n" +
                "                                                                                            <tbody>\n" +
                "                                                                                                <tr>\n" +
                "                                                                                                    <td style=\"border-bottom: 1px solid #fff4f7; background: rgba(0, 0, 0, 0) none repeat scroll 0% 0%; height: 1px; width: 100%; margin: 0px;\"></td>\n" +
                "                                                                                                </tr>\n" +
                "                                                                                            </tbody>\n" +
                "                                                                                        </table>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </td>\n" +
                "                                                                </tr>\n" +
                "                                                            </tbody>\n" +
                "                                                        </table>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                            </tbody>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                        <table class=\"esd-footer-popover es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td class=\"esd-stripe\" style=\"background-color: #d0cdcd;\" bgcolor=\"#d0cdcd\" align=\"center\">\n" +
                "                                        <table class=\"es-content-body\" style=\"background-color: #fef5f5;\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#fef5f5\" align=\"center\">\n" +
                "                                            <tbody>\n" +
                "                                                <tr>\n" +
                "                                                    <td class=\"esd-structure es-p30t es-p30b es-p20r es-p20l\" align=\"left\">\n" +
                "                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                                            <tbody>\n" +
                "                                                                <tr>\n" +
                "                                                                    <td class=\"esd-container-frame\" width=\"560\" valign=\"top\" align=\"center\">\n" +
                "                                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td align=\"center\" class=\"esd-block-image\" style=\"font-size: 0px;\">\n" +
                "                                                                                        <a target=\"_blank\"><img class=\"adapt-img\" src=\"https://demo.stripocdn.email/content/guids/044e6da1-7cab-4976-8d32-6b98124ab427/images/vikings.png\" alt style=\"display: block;\" width=\"100\"></a>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </td>\n" +
                "                                                                </tr>\n" +
                "                                                            </tbody>\n" +
                "                                                        </table>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                            </tbody>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "    </div>";

        return text;
    }


}
