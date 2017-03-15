package javax.jws.jAXWSAttachmentWithMTOM.mkyong;

import javax.swing.*;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by srapolu on 3/9/17.
 *
 * A Java API for XML Web Services(JAX-WS) SOAP based example
 * to show how to use
 * MTOM(Message Transmission Optimization Mechanism) and
 * XOP(XML-Binary Optimizing Packaging)
 * technique to send a binary attachment (image) from server to client and vice verse.
 *
 * Below is a web service client, to access the published web service at "http://localhost:8080/ws/image"
 *
 */
public class ImageClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/ws/image?wsdl");
        //QName qName = new QName("http://ws.practiceprograms.com","ImageServerImplService");
        QName qName = new QName("http://mkyong.jAXWSAttachmentWithMTOM.mtom.javax/","ImageServerImplService");

        Service service = Service.create(url, qName);
        ImageServer imageServer = service.getPort(ImageServer.class);

        /* test download */

        Image image = imageServer.downloadImage("IMG_1773.JPG");
        //display in a frame
        JFrame frame = new JFrame();
        frame.setSize(1000,1000);
        JLabel label = new JLabel(new ImageIcon(image));
        frame.add(label);
        frame.setVisible(true);


        // imageServer.downloadImage("IMG_1773.JPG");

        System.out.println("ImageClient: imageServer.downloadImage() Download Successful!");


    }
}
