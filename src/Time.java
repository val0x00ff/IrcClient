import java.awt.Graphics;


public class Time {

	String time;
	
	public Time()
	{
		String time = new java.util.Date().toString();
	//	System.out.println(time.substring(0,13));
		String str;
		str = time.substring(0,3);
		if(str.equals("Fri"))
		{
			System.out.println("Hello het is vrijdag  " +time);
		}
	}

	public static void main(String[] args)
	{
		Time tm = new Time();
	
	}
}
