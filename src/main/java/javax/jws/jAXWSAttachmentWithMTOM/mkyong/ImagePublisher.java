package javax.jws.jAXWSAttachmentWithMTOM.mkyong;

import javax.xml.ws.Endpoint;

/**
 * Created by srapolu on 3/9/17.
 *
 * End point publisher
 */
public class ImagePublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/ws/image", new ImageServerImpl());
        System.out.println("Server is published");
    }
}

