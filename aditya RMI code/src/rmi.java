
public class rmi {

}


•	AddServerIntf.java

import java.rmi.*;  

public interface AddServerIntf extends Remote{  

	public String echo(String clientMessage) throws RemoteException;

}

•	AddServerImpl.java

import java.rmi.*;  

import java.rmi.server.*;

public class AddServerImpl extends UnicastRemoteObject implements AddServerIntf{

	AddServerImpl() throws RemoteException{  

		super();  

	}

	public String echo(String clientMessage) {

		return clientMessage + "hello";

	}

}

•	AddServer.java

import java.rmi.Naming;

import java.rmi.RemoteException;

public class AddServer extends AddServerImpl {



	public AddServer() throws RemoteException {}



	 public static void main(String[] args) {

		try{

			AddServerIntf stub=new AddServerImpl();  

			Naming.rebind("echo",stub);  

			System.err.println("Server ready");

			}

			catch(Exception e){

				System.out.println(e);

			}

	}

}

•	AddClient.java

import java.rmi.Naming;

import java.rmi.RemoteException;

import java.util.Scanner;



public class AddClient{

	

	private static String clientMessage = "";

	

	private AddClient()throws RemoteException {}

	

	public static void main(String[] args) {

		try{

			AddServerIntf stub=(AddServerIntf)Naming.lookup("rmi://"+args[0]+"/echo");  

			Scanner scanner = new Scanner(System.in);

			System.out.print("Enter your message: ");

			clientMessage = scanner.nextLine();

			System.out.println(stub.echo(clientMessage));			

		}

		catch(Exception e){

			e.printStackTrace();

		}

	}

}