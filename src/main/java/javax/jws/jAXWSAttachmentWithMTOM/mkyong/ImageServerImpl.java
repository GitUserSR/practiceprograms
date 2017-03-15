package javax.jws.jAXWSAttachmentWithMTOM.mkyong;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.MTOM;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by srapolu on 3/9/17.
 */
@MTOM
//@WebService(name = "ImageServerImpl", targetNamespace = "http://ws.practiceprograms.com", endpointInterface = "ImageServer")
@WebService(name = "ImageServerImpl", endpointInterface = "javax.jws.jAXWSAttachmentWithMTOM.mkyong.ImageServer")
public class ImageServerImpl implements ImageServer{

    @Override
    public Image downloadImage(String name) {
        System.out.println("downloadImage");
        Image image;

        File file = new File("/Users/srapolu/Documents/Work/Documents/"+name);
        try {
            image =  ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new WebServiceException("Download Failed");
        }
        return image;
    }

    @Override
    public String uploadImage(Image data) {
        if(data != null) {
            System.out.println("uploaded image");
            return "Upload Successful";
        }
        throw new WebServiceException("Upload Failed");
    }
}
