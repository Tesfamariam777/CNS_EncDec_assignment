import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
 

  
  

public class AES_ED {

  private static SecretKeySpec secretKey;
  private static byte[] key;

  //set key
  public static void setKey(String myKey){
      try{
          key = myKey.getBytes("UTF-8");
          MessageDigest sha = MessageDigest.getInstance("SHa-1");
          key = sha.digest(key);
          key = Arrays.copyOf(key, 16);
          secretKey = new SecretKeySpec(key, "AES");
          
      }
      catch(NoSuchAlgorithmException exception){ }
      catch(UnsupportedEncodingException exception){}  
  }
   //Encryption function
   public static String encrypt(String messageToEncrypt, String userKey){
       try{
           setKey(userKey);
           Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
           cipher.init(Cipher.ENCRYPT_MODE, secretKey);
           return Base64.getEncoder().encodeToString(cipher.doFinal(messageToEncrypt.getBytes("UTF-8")));
       }
       catch(Exception e){}
       return null;
    }
    //Decrypt Function
    public static String decrypt(String messageToDecrypt, String userKey){
        try{
            setKey(userKey);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(messageToDecrypt)));
        }
        catch(Exception e){}
        return null;
     }

   }

        
