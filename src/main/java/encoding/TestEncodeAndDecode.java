package encoding;

import java.nio.charset.Charset;

/**
 * Created by srapolu on 12/5/16.
 */
public class TestEncodeAndDecode {

    /**
     * Some encodings will automatically emit byte order marks(BOM) on encode and read them on decode. Select the encoding scheme appropriate for your use case.
     * Example is, UTF-16. For example, "abcde" will be decoded as "97 98 99 100 101" in UTF-8 and
     * will be encoded  as "-2 -1 0 97 0 99 0 99 0 100 0 101"
     */
    public static void main(String[] args) {
        String inputStr = "abcde";

        Charset charset_utf8 = Charset.forName("UTF-8");
        //encode input string
        byte[] inputStrBytes_utf8 = inputStr.getBytes(charset_utf8);

        //decode input bytes
        String decodedInput_utf8 = new String(inputStrBytes_utf8,charset_utf8);
        System.out.println("decodedInput with utf-8 = " + decodedInput_utf8);

        Charset charset_utf16 = Charset.forName("UTF-16");
        //encode input string
        byte[] inputStrBytes_utf16 = inputStr.getBytes(charset_utf16);

        //decode input bytes
        String decodedInput_utf16 = new String(inputStrBytes_utf16,charset_utf16);
        System.out.println("decodedInput with utf-16 = " + decodedInput_utf16);
    }
}



