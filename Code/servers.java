import java.io.*;
import java.net.*;
public class servers extends Thread
{
	ServerSocket server;
	PrintStream stoc;
	DataInputStream fromc;
	Socket client;

	public servers()
	{
		try
		{
			server =new ServerSocket(1001);
			System.out.println("Server Start........");
		}
		catch(Exception e)
		{
			System.out.println("fail to create socket");
		}
       start();
}
public void run()
{	try
	{	while(true)
		{
			client=server.accept();
			fromc=new DataInputStream(client.getInputStream());

			String str=fromc.readLine();
			System.out.println("Client Says:"+str);
			stoc=new PrintStream(client.getOutputStream());
			DataInputStream x=new DataInputStream(System.in);
			System.out.print("Server :");
			String msg=x.readLine();
			stoc.println(msg);
		}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}

	try
	{
		client.close();
	}
	catch(Exception e)
	{
		System.out.println("fail to close client connection...");
	}

}
	public static void main(String arg[])
	{
		new servers();
	}
}