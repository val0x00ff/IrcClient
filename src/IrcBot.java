import org.jibble.pircbot.*;
import sun.security.util.BigInt;
import java.lang.String;
import java.security.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.*;
public class IrcBot extends PircBot {
    

    // Defineer een methode die een tal parameters heeft. 
    public void onMessage(String channel, String sender,
                       String login, String hostname, String message) {
    	if (message.equalsIgnoreCase("!help"))
    	{
    		sendMessage(channel,"Komandat e implementuara jan: !koha, !author, tung, !md5 your_tekst, !sites" );
    	}
        if (message.equalsIgnoreCase("!koha")) {
            String time = new java.util.Date().toString();
            sendMessage(channel, sender + Colors.RED +": Koha eshte " + time);
        }
        else if(message.equalsIgnoreCase("!autori"))
        {
        	sendMessage(channel, sender + Colors.GREEN+ Colors.BOLD+ ": autori eshte _val_");
        }
        else if(message.equalsIgnoreCase("tung") || message.equalsIgnoreCase("tungi"))
        {
        	
        	sendMessage(channel, "Tung " + sender + " si ja kalove sot?");
        	
        }
        else if(message.equalsIgnoreCase("K|nG") || message.equalsIgnoreCase("KinG"))
        {
        	
        	sendMessage(channel, "King in the Castle King in the Castle " + sender + " Borat?");
        	
        }
        else if(message.endsWith("ti?") || message.equalsIgnoreCase("je?"))
        {
        	setMessageDelay(4000);
        	sendMessage(channel, "As un kurgjo qetu tu nejt. Qfar ka t're nga ti ?" + sender);
        }
        else if(message.startsWith("!md5"))
        {
        	try {
        		System.out.println(message.substring(5));
        			String hash = md5(message.substring(5).trim()); 
        			sendMessage(channel, " MD5 hash eshte:  " + Colors.GREEN +hash);   
        	} 
        	catch (NoSuchAlgorithmException e) {
    
        			// TODO Auto-generated catch block
        	
        		e.printStackTrace();
        	}
        }
        else if(message.equals("!sites"))
        {
            try
            {
            	  BufferedReader in = new BufferedReader(new FileReader("sites"));
                  String lexo;
                  while ((lexo = in.readLine()) != null) {
                      lexon_fajlen(lexo);
                      String lexo_tmp = lexo;
                  	  sendMessage(channel, lexo_tmp);
                  }
                  in.close();
            }

            catch (Exception e) {
            }
            
        }
        else if(message.equals("!shkruaj"))
    	{
			try
			{
			
			BufferedWriter sh = new BufferedWriter(new FileWriter("myfile", true ));
			String shkruaj = "";
			writetofile("\n"+shkruaj);
			sh.close();
			}
			catch (IOException e)
			{
			
			}
		}
    }  
    
    	/**
    	 * 
    	 * @param hash
    	 * @return
    	 * @throws NoSuchAlgorithmException
    	 */
        public String md5(String hash) throws NoSuchAlgorithmException
        {
        String storehash = hash;
        MessageDigest md = MessageDigest.getInstance("MD5"); 
        md.update(storehash.getBytes(),0,storehash.length());
        String ret = new BigInteger(1,md.digest()).toString(16); 
        return ret;
        }

        /**
         *  Metod e cila ben hyrje automatike ne kanal(dhome) pas  perjashtimint (kick)
         */
        public void onKick(String channel, String kickerNick, 
        		String login, String hostname, String recipientNick, String reason)
        {
        	if(recipientNick.equalsIgnoreCase(getNick()))
        	{
        		joinChannel(channel);
        	}
        }
        
        /**
         * Metod e clia ben re-kyqjen e bot-it ne server.
         
        public void onDisconnect()
        {
        	while (!isConnected())
        	{
        		try{
        			reconnect();
        		}
        		catch(Exception e)
        		{
        			
        		}
        	}
        	
        }
        */

        public void lexon_fajlen(String lexo) {
        	
        }
    	public void writetofile(String shkruaj)
    	{
    		
    	}
        
        
        
}