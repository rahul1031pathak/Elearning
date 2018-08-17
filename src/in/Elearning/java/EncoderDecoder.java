package in.Elearning.java;

import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class EncoderDecoder {
   
	
	private static final String ALGO = "AES";
    //generate 128bit key
    private static final String keyStr = "rahul1031pathak@gmail.com";

    private static Key generateKey() throws Exception {
        byte[] keyValue = keyStr.getBytes("UTF-8");
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        keyValue = sha.digest(keyValue);
        keyValue = Arrays.copyOf(keyValue, 16); // use only first 128 bit       
        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
    }

    public static String encrypt(String Data) throws Exception {
            Key key = generateKey();
            Cipher c = Cipher.getInstance(ALGO);
            c.init(Cipher.ENCRYPT_MODE, key);
            byte[] encVal = c.doFinal(Data.getBytes());
            String encryptedValue = DatatypeConverter.printBase64Binary(encVal);
            return encryptedValue;
    }

    public static String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);       
        byte[] decordedValue = DatatypeConverter.parseBase64Binary(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }

}
	
	