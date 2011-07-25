public class MyBotMain {
    
    private static final Exception UnknownHostException = null;

	public static void main(String[] args) throws Exception {
        
        // Maan een nieuwe instantie van de bot en start de bot
        IrcBot bot = new IrcBot();
        
        // Debugging mode aanzetten
        bot.setVerbose(true);
        try{
        // Maak verbinding met een IRC server.
        bot.connect("irc.bujanoci.net");
        }
        catch (Exception e)
        {
        // Channel(room) die je in wil komen.
        System.out.println("Nuk mund te kyqet: " +e + ". Shkaqet mund te jen keto: ");
        System.out.println("Server-i nuk ekziston ose...");
        System.out.println("Server-i eshte offline (joaktiv) ose...");
        System.out.println("Kontrolloni DNS'in e juaj i cili nuk ben konvertimin e FQDN ne IP adres.");
        }
        bot.joinChannel("#flossk");
        
    }
    
}