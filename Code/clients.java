import java.io.*;
import java.net.*;
public class clients
{
	PrintStream ctos;
	DataInputStream froms;
	Socket toserver;
	public clients()
	{
	    connectToserver();
	}
	private void  connectToserver()
	{
		try
		{
			while(true)
			{
				toserver= new Socket ("127.0.0.1", 1001);
				froms= new DataInputStream(toserver.getInputStream());
				DataInputStream x=new DataInputStream(System.in);
				System.out.print("Client:");
				String msg= x.readLine();
				ctos= new PrintStream(toserver.getOutputStream());
				ctos.println(msg);
				String str= froms.readLine();
				System.out.println("Server Says:"+str);
			}
		}
		catch(Exception e)
		{System.out.println(e);
		}
	}
	public static void main(String arg[])
	{
		new clients();
		}
	}