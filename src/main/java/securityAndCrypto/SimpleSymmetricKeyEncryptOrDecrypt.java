package securityAndCrypto;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import java.security.InvalidKeyException;
import java.security.Key;

/*
Shows how to encrypt and decrypt using symmetric key. 
-In the case of a symmetric key, the same key is used to encrypt and decrypt the data. 
-Because both parties have the same key, the decryption essentially is performed by reversing some part of the encryption process.
-To encrypt and decrypt a String using a symmetric key one should perform the following steps:
	1) Create a Key Object, using the KeyGenerator, for the DESede algorithm.
	2) Create a Cipher that implements the DESede transformation, with the getInstance(String algorithm) API method.
    3) Encrypt an initial input String. Initialize the cipher in encryption mode with the key, using the init(int opmode, Key key) API method. Then encrypt the byte array of the String and return the encrypted byte array, using the doFinal(byte[] input) API method of the Cipher. This step is described in the encryptedBytes(String inputToEncrypt, Key symmetricKey, Cipher cipher) method of the example.
	4) Decrypt the encrypted byte array. Initialize the key and the cipher in a decryption mode, using the same key, decrypt the byte array and return a new String representation from the decrypted byte array. This step is described in the decryptedBytes(byte[] encryptedBytes, Key symmetricKey, Cipher cipher) method of the example.
*/


public class SimpleSymmetricKeyEncryptOrDecrypt {
	
	static String ALGORITHM_DESEDE = "DESede";
	
	public static void main(String[] args) throws Exception {
		Key symmetricKey = KeyGenerator.getInstance(ALGORITHM_DESEDE).generateKey();
		Cipher cipher = Cipher.getInstance(ALGORITHM_DESEDE);
		String inputToEncrypt = "textToEncrypt";
		byte[] encryptedBytes = encryptedBytes(inputToEncrypt, symmetricKey, cipher);
		System.out.println("input:"+ inputToEncrypt + " output:"+ decryptedBytes(encryptedBytes, symmetricKey, cipher));
	}
	
	public static byte[] encryptedBytes(String inputToEncrypt, Key symmetricKey, Cipher cipher) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		cipher.init(Cipher.ENCRYPT_MODE, symmetricKey);
		byte[] inputBytes = inputToEncrypt.getBytes();
		return cipher.doFinal(inputBytes);
	}
	
	public static String decryptedBytes(byte[] encryptedBytes, Key symmetricKey, Cipher cipher) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		cipher.init(Cipher.DECRYPT_MODE, symmetricKey);
		byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
		return new String(decryptedBytes);
	}
}
