import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class Md5Cracker
{
	public void writetofile(String shkruaj)
		{
			try
			{
			String test;
			BufferedWriter sh = new BufferedWriter(new FileWriter("patrick", true ));
			test = shkruaj;
			sh.write(test);
			sh.close();
			}
			catch (IOException e)
			{
			
			}
		}
	public static void main(String[] args)
	{
		String whatever;
		Md5Cracker a = new Md5Cracker();	
		Scanner scan = new Scanner(System.in);
		whatever = scan.nextLine();
		a.writetofile("\n"+whatever);
	}
}