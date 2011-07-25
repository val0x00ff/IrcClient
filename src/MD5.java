import java.security.*;
import java.math.*;
     

    public class MD5 {
       public static void main(String args[]) throws Exception{
          
    	   MD5 md = new MD5();
    	   String store1 = String.format("test");
    	   md.encrytMD5(store1);
    	   
       }
       
       public String encrytMD5(String txt) throws Exception
       {
    	   String s = txt;
           MessageDigest m=MessageDigest.getInstance("MD5");
           m.update(s.getBytes(),0,s.length());
           System.out.println("MD5: "+new BigInteger(1,m.digest()).toString(16));
		return s;
       }
    }
