
import java.io.UnsupportedEncodingException;
//import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
//import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
//import javax.crypto.IllegalBlockSizeException;
//import javax.crypto.NoSuchPaddingException;
//import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;;


public class TripleDES {

    private static SecretKeySpec secretKey;
    private static byte[] key;
  
    //set key
    public static void setKey(String myKey){
        try{
            key = myKey.getBytes("UTF-8");
          
            /// hashing the key to get fixed length 128bit then get key with 24 byte length  
    	
    	//get instance of message digest from the preferred provider of md5 algorithm 
    	//md5 algorith produce 128 bit hash value of any string
    	MessageDigest md = MessageDigest.getInstance("md5");
    	md.update(key);
    	
    	// get the hashing result which will be 16 byte = 128 bit 
        key = md.digest();
        
        
        
        // because we need 3 keys and each key is 8byte(64bit) so we need 24 byte for the keys 
        key = Arrays.copyOf(key, 24);
        //System.out.println(keyBytes[18]); // == 0
        
        // assign value for the last 8 bytes 
        
        int i = 0 ;
        for (int j = 16; j < 24;j++) {
            key[j] = key[i++];
        }
        
        
        
        //Constructs a secret key from the given byte array of amy length
        secretKey = new SecretKeySpec(key, "DESede");
        
        }
        catch(NoSuchAlgorithmException exception){ }
        catch(UnsupportedEncodingException exception){}  
    }

    /** method that encrypt a string **/ 

    public static String encrypt(String messageToEncrypt, String userKey){
        try{
            setKey(userKey);
            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(messageToEncrypt.getBytes("UTF-8")));
        }
        catch(Exception e){}
        return null;
     }
 
    
    /**Method To Decrypt An Ecrypted String*/
     //Decrypt Function
     public static String decrypt(String messageToDecrypt, String userKey){
        try{
            setKey(userKey);
            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(messageToDecrypt)));
        }
        catch(Exception e){}
        return null;
     }
    
}