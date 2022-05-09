import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
	public static void main(String[] args) throws IOException {
		
		
		ServerSocket serverSocket = new ServerSocket(7411);
		Socket socket = serverSocket.accept();
		Scanner scanner = new Scanner(socket.getInputStream());
		int received = scanner.nextInt();
		System.out.println("RECEIVED NUMBER ON SERVER " + received);
		received *=2;
		PrintStream pStream = new PrintStream(socket.getOutputStream());
		
		pStream.println(received);
	}
}
