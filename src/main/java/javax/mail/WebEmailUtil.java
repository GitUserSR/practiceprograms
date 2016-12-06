package javax.mail;

import javax.mail.search.SubjectTerm;
import java.util.Date;
import java.util.Properties;

/**
 * Created by swathirapolu on 4/17/14.
 */
public class WebEmailUtil {

    private static final String INBOX = "INBOX";
    private static final String appleEmailFrom = "Apple <appleid@id.apple.com>";

    public Message getMessage(Folder folder, String msgSubject, String msgTo, String msgFrom) throws MessagingException {

        folder.open(Folder.READ_ONLY);
        Message[] messages = folder.search(new SubjectTerm(msgSubject));
        Message message = null;

        for(Message msg : messages){
            if(msgTo.equalsIgnoreCase(msg.getRecipients(Message.RecipientType.TO)[0].toString())
                    && msgFrom.equalsIgnoreCase(msg.getFrom()[0].toString())
                    && new Date().compareTo(msg.getSentDate()) > 0){
                message = msg;
            }
        }
        folder.close(false);
        return message;
    }

    public Folder getFolder(String host, String user, String password, String folderName){
        Store store;
        Folder folder = null;
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");

        try {
            Session session = Session.getInstance(props, null);
            store = session.getStore();
            store.connect(host, user, password);
            folder = store.getFolder(folderName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return folder;
    }

    public void deleteMessages(Folder folder) throws MessagingException {
        folder.open(Folder.READ_WRITE);
        for(Message message : folder.getMessages()){
            message.setFlag(Flags.Flag.DELETED, true);
        }
        folder.close(true);
    }

    public static void main(String args[]) throws MessagingException {
        Folder folder;
        WebEmailUtil webEmailUtil = new WebEmailUtil();

        if( (folder = webEmailUtil.getFolder("mail.apple.com", "iForgotUnitTests@apple.com", "IU1397518144500", INBOX)) != null){
            Message message = webEmailUtil.getMessage(folder, "How to reset your Apple ID password.", "etsqasys+good1015@apple.com", appleEmailFrom);
        }

        webEmailUtil.deleteMessages(webEmailUtil.getFolder("mail.apple.com", "etsqasys@apple.com", "3mzyTxcyD%p", INBOX));
    }
}


//package com;
//
//import java.util.*;
//import javax.mail.*;
//
//public class ReadingEmail {
//   public static void main(String[] args) {
//       Properties props = new Properties();
//       props.setProperty("mail.store.protocol", "imaps");
//       try {
//           Session session = Session.getInstance(props, null);
//           Store store = session.getStore();
//           store.connect("mail.apple.com", "test_user@apple.com", "pass123");
//           Folder inbox = store.getFolder("INBOX");
//           inbox.open(Folder.READ_ONLY);
//           Message msg = inbox.getMessage(inbox.getMessageCount());
//           Address[] in = msg.getFrom();
//           for (Address address : in) {
//               System.out.println("FROM:" + address.toString());
//           }
//           Multipart mp = (Multipart) msg.getContent();
//           BodyPart bp = mp.getBodyPart(0);
//           System.out.println("SENT DATE:" + msg.getSentDate());
//           System.out.println("SUBJECT:" + msg.getSubject());
//           System.out.println("CONTENT:" + bp.getContent());
//       } catch (Exception mex) {
//           mex.printStackTrace();
//       }
//   }
//}