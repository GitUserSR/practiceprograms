package encoding;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Created by srapolu on 12/5/16.
 */
public class CharacterEncodingExample {

    public static void main(String[] args) {
        System.out.println("System default encoding by property :" + System.getProperty("file.encoding"));
        System.out.println("System default encoding by code:" + getDefaultCharacterEncoding());
        System.out.println("System default encoding by charset:" + Charset.defaultCharset());
        System.setProperty("file.encoding", "UTF-16");
        System.out.println("System encoding by property after setting encode :" + System.getProperty("file.encoding"));
        System.out.println("System encoding by code after setting encode :" + getDefaultCharacterEncoding());
        System.out.println("System encoding by charset after setting encode :" + Charset.defaultCharset());
        System.out.format("%8s",System.getProperty("file.encoding"));
    }


    private static String getDefaultCharacterEncoding(){
        byte[] byteArray = {'a'};
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
        InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream);
        return inputStreamReader.getEncoding();
    }
}
