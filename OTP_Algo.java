//import java.security.MessageDigest;
import java.security.SecureRandom;
//import java.util.Arrays;

import javax.print.DocFlavor.STRING;

//import javax.crypto.spec.SecretKeySpec;

public class OTP_Algo{

	    private static String dataTxt;
	    //private static String key;
	    private static SecureRandom secure_key;
	    private static String secure_key_in_bits;

	    // public OTP_Algo(String data,String userKey) {
	    // 	OTP_Algo.dataTxt = data;
	    // 	OTP_Algo.key = userKey;
	    // }
	    
	   public static void generate_key(String data) throws Exception{
			   
		      secure_key_in_bits="";
		      int randomValues= 0;
			   try {
				      secure_key=new SecureRandom();
				      int index=0;
				      while(index<data.length()) {
				    	  randomValues=secure_key.nextInt(256);
				    	  secure_key_in_bits+=decToBin(randomValues,8);
                          
				    	  index++;
				      }
		        }
				   
			
	        catch(Exception e) {
				
				e.printStackTrace();
			}
		    
			 
		 }
	   public static void generate_message_in_bits(String data) {
		   try {
			    dataTxt=charToBinary(data);
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }
	   }
		public static String decToBin(int value,int numberBits) {
		    	int updating_value=value;
		    	int index=0;
		    	String bits="";
		    	while(updating_value!=0 || index<numberBits) {
		    		int remainder=updating_value%2;
		    		updating_value/=2;
		    		bits+=remainder;
		    		index++;
		    	}
		    	return reverse(bits);
		    }
		 public static String reverse(String data) {
			 int index=data.length()-1;
			 String value="";
			 while(index>=0) {
				 value+=data.charAt(index);
				 index--;
			 }
			 return value;
		 }
		 public static String pad(String text) {
			 while(text.length()%8!=0) {
				 text+=' ';
			 }
			 return text;
		 }
		 public static String charToBinary(String data) {
			 String value="";
			 int index=0;
			 while(index<data.length()) {
				 int dataInAscii=(int)data.charAt(index);
				 value+=decToBin(dataInAscii,8);
				 index++;
			 }
			return value;
		 }
		 public static int not(int string) {
		 	int x=0;
		 	if(string==0) {
		 		x=1;
		 	}
		 	else if(string==1) {
		 		x=0;
		 	}
		 	return x;
		 }
			
		 public static String xor_operation(String data,String key) {
		 	
		 	String xor_value="";
		 	for(int i=0;i<data.length();i++) {
		 		int x=Integer.parseInt(String.valueOf(data.charAt(i)));
		 		int y=Integer.parseInt(String.valueOf(key.charAt(i)));
		 		int res=(not(x)*y)+(not(y)*x);
		 		xor_value+=Integer.toString(res);
		 	}
		 	return xor_value;
		 }
		 public static int binaryToDec(String value) {
		 	int x=0;
		 	for(int i=0;i<value.length();i++) {
		 		int length=value.length()-1;
		 		x+=Integer.parseInt(String.valueOf(value.charAt(i)))*Math.pow(2,length-i);
		 	}
		 	return x;
		 }
		 
        public static String binaryToCharacters(String data) {
		 	
		 	int index=0;
		 	String value = "";
		 	while(index<data.length()) {
		 		String indexValue="";
		 		for(int j=index;j<index+8;j++) {	
		 			indexValue+=data.charAt(j);
		 		}
		 		int index_value=binaryToDec(indexValue);
		 		value+=(char)index_value;
		 		index+=8;
		 	}
		 	
		 	return value;
		 }
 
        public static String encrypt(String data , String key) {
        	try {

				generate_message_in_bits(data);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
        	return binaryToCharacters(xor_operation(dataTxt,key));
        }
        
        public static String decrypt(String data,String key) {
        	try {
				generate_message_in_bits(data);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
        	return  binaryToCharacters(xor_operation(dataTxt,key));
        
        }
        public static String returnKey(String data) throws Exception {
	   	generate_key(data);
	   	return secure_key_in_bits;
        }
}


















// public class OTP_Algo{

// // Method 1
//     // Returning encrypted text
//     public static String stringEncryption(String text, String key)
//     {
//          text = text.toUpperCase();
//          key = key.toUpperCase();
//         // Initializing cipherText
//         String cipherText = "";
 
//         // Initialize cipher array of key length
//         // which stores the sum of corresponding no.'s
//         // of plainText and key.
//         int cipher[] = new int[key.length()];
 
//         for (int i = 0; i < key.length(); i++) {
//             cipher[i] = text.charAt(i) - 'A'
//                         + key.charAt(i)
//                         - 'A';
//         }
 
//         // If the sum is greater than 25
//         // subtract 26 from it
//         // and store that resulting value
//         for (int i = 0; i < key.length(); i++) {
//             if (cipher[i] > 25) {
//                 cipher[i] = cipher[i] - 26;
//             }
//         }
 
//         // Converting the no.'s into integers
 
//         // Convert these integers to corresponding
//         // characters and add them up to cipherText
//         for (int i = 0; i < key.length(); i++) {
//             int x = cipher[i] + 'A';
//             cipherText += (char)x;
//         }
 
//         // Returning the cipherText
//         return cipherText;
//     }
 
//     // Method 2
//     // Returning plain text
//     public static String stringDecryption(String s, String key)
//     {
//         key = key.toUpperCase();
//         // Initializing plain text
//         String plainText = "";
 
//         // Initializing integer array of key length
//         // which stores difference
//         // of corresponding no.'s of
//         // each character of cipherText and key
//         int plain[] = new int[key.length()];
 
//         // Running for loop for each character
//         // subtracting and storing in the array
//         for (int i = 0; i < key.length(); i++) {
//             plain[i]
//                 = s.charAt(i) - 'A'
//                   - (key.charAt(i) - 'A');
//         }
 
//         // If the difference is less than 0
//         // add 26 and store it in the array.
//         for (int i = 0; i < key.length(); i++) {
//             if (plain[i] < 0) {
//                 plain[i] = plain[i] + 26;
//             }
//         }
 
//         // Converting int to corresponding char
//         // add them up to plainText
//         for (int i = 0; i < key.length(); i++) {
//             int x = plain[i] + 'A';
//             plainText += (char)x;
//         }
 
//         // Returning plainText
//         return plainText;
//     }
// }
 
// //     // Method 3
// //     // Main driver method
// //     public static void main(String[] args)
// //     {
// //         // Declaring plain text
// //         String plainText = "Hello";
 
// //         // Declaring key
// //         String key = "MONEY";
 
// //         // Converting plain text to toUpperCase
// //         // function call to stringEncryption
// //         // with plainText and key as parameters
// //         String encryptedText = stringEncryption(
// //             plainText.toUpperCase(), key.toUpperCase());
 
// //         // Printing cipher Text
// //         System.out.println("Cipher Text - "
// //                            + encryptedText);
 
// //         // Calling above method to stringDecryption
// //         // with encryptedText and key as parameters
// //         System.out.println(
// //             "Message - "
// //             + stringDecryption(encryptedText,
// //                                key.toUpperCase()));
// //     }
// // }