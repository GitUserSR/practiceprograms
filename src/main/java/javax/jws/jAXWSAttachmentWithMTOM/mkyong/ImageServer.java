package javax.jws.jAXWSAttachmentWithMTOM.mkyong;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.awt.*;

/**
 * Created by srapolu on 3/9/17.
 *
 * Below is a RPC-style web service, published two methods, downloadImage(String name) and uploadImage(Image data),
 * to let user upload or download an image file
 */
//@WebService(name = "ImageServer", targetNamespace = "http://ws.practiceprograms.com")
@WebService
//@SOAPBinding(style = SOAPBinding.Style.RPC)
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface ImageServer {
    @WebMethod Image downloadImage(String image);
    @WebMethod String uploadImage(Image image);
}

