package crypto.md5;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by srapolu on 11/1/16.
 */
public class MD5 {
    public static String getMD5(String input) {
        byte[] emptyByteArray = new byte[0];
        BigInteger bigIntegerSigNum1 = new BigInteger(1, emptyByteArray);
        BigInteger bigIntegerSigNum0 = new BigInteger(0, emptyByteArray);
        BigInteger bigIntegerSigNumMinus1 = new BigInteger(-1, emptyByteArray);

        byte[] nonEmptyByteArray = "some value".getBytes();
        BigInteger bigInteger1SigNum1 = new BigInteger(1, nonEmptyByteArray);
        BigInteger bigInteger1SigNum0 = new BigInteger(0, nonEmptyByteArray);//Throws an java.lang.NumberFormatException: signum-magnitude mismatch
        BigInteger bigInteger1SigNumMinus1 = new BigInteger(-1, nonEmptyByteArray);

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(-1, messageDigest);
            String hashtext = number.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param args
     * @throws NoSuchAlgorithmException
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(getMD5("Javarmi.com"));
    }
}
