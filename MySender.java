import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class MySender
{
	public static void main(String[] args)
	{
		try
		{
			DatagramSocket sender=new DatagramSocket(2222);
			String msg="";
			byte b[]=new byte[1024];
			DatagramPacket pack=null;
			Scanner scan=new Scanner(System.in);
			
			System.out.println("\n Enter string : ");
			msg=scan.nextLine();
			b=msg.getBytes();
			
			InetAddress ip=InetAddress.getByName("localhost");
			pack=new DatagramPacket(b,b.length,ip,3333);
			sender.send(pack);
			
			pack=new DatagramPacket(b,b.length);
			sender.receive(pack);
			b=pack.getData();
			msg=new String(b);
			System.out.print("\n Converted : "+msg);
			
			sender.close();
		}
		catch(Exception e)
		{
			System.out.println("\n Receiver error : "+e.getMessage());
		}
	}
}