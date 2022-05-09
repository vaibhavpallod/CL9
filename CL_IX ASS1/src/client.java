import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class client {


	public static void main(String[] args) throws UnknownHostException, IOException {
		int Number ;
		Scanner sc =	new Scanner(System.in);
		Socket sktSocket = new Socket("127.0.0.1", 7411);
		System.out.println("Enter a number: ");
		Number = sc.nextInt();

		Scanner scannerFromServer =new Scanner(sktSocket.getInputStream());
		PrintStream pStream = new PrintStream(sktSocket.getOutputStream());
		pStream.println(Number);

		int result = scannerFromServer.nextInt();
		System.out.println("OUTPUT OF SERVER "+result);

	}

}
