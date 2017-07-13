package crypto.SHA;

import org.apache.catalina.util.HexUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Created by srapolu on 7/10/17.
 */
public class LearnSHA {

    public static  void main(String args[]) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] salt ={2, 35, 0, 58, 70, 113, 59, 94};
        String encryptedPassword = encryptPassword("anonymous", "SHA-512", salt);
        System.out.println("encryptedPassword = " + encryptedPassword);

        String encryptedPasswordinCAPS = encryptPassword("ANONYMOUS", "SHA-512", salt);
        System.out.println("encryptedPasswordinCAPS = " + encryptedPasswordinCAPS);

    }

    public static String encryptPassword(String input, String algorithm, byte[] salt) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String encoding = "UTF-8";
        MessageDigest ex = null;
        ex = (MessageDigest) MessageDigest.getInstance(algorithm);
        if (salt != null && salt.length > 0) {
            ex.update(salt);
        }
        ex.update(input.getBytes(encoding));

        byte[] digest = ex.digest();
        String digestStr = HexUtils.convert(digest);

        String algorithmStr = algorithm + ":";

        String saltStr = "";
        if (salt != null && salt.length > 0) {
            String saltLenStr = HexUtils.convert(new byte[]{(byte) salt.length});  // one byte to indicate salt length
            saltStr = saltLenStr + HexUtils.convert(salt);
        }

        return algorithmStr + saltStr + digestStr;
       }

       public static String decryptPassword(){

       }
}
