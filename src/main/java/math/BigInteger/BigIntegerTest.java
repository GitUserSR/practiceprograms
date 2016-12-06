package math.BigInteger;

import java.math.BigInteger;

/**
 * Created by srapolu on 11/9/16.
 */
public class BigIntegerTest {

    public static void main(String args[]) {
        String input = "abcde";
        BigInteger inputBigIntegerSigNum1  = new BigInteger(1, input.getBytes());
        BigInteger inputBigIntegerSigNumMinus1  = new BigInteger(-1, input.getBytes());

        System.out.println("Add a break point here");

        BigIntegerTest bigIntegerTest = new BigIntegerTest();
        bigIntegerTest.BigIntegerConstructorWithSignumAndbyteArrayInput();
    }

    /**
     * To learn BigInteger(int, byte[]) constructor
     Translates the sign-magnitude representation of an integer into a BigInteger.
     */
    void BigIntegerConstructorWithSignumAndbyteArrayInput(){
        byte[] emptyByteArray = new byte[0];
        BigInteger bigIntegerSigNum1 = new BigInteger(1, emptyByteArray);
        BigInteger bigIntegerSigNum0 = new BigInteger(0, emptyByteArray);
        BigInteger bigIntegerSigNumMinus1 = new BigInteger(-1, emptyByteArray);

        byte[] nonEmptyByteArray = "some value".getBytes();
        BigInteger bigInteger1SigNum1 = new BigInteger(1, nonEmptyByteArray);
        BigInteger bigInteger1SigNum0 = new BigInteger(0, nonEmptyByteArray);//Throws an java.lang.NumberFormatException: signum-magnitude mismatch
        BigInteger bigInteger1SigNumMinus1 = new BigInteger(-1, nonEmptyByteArray);
    }
}

