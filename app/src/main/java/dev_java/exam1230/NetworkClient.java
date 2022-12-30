package dev_java.exam1230;


import java.net.InetAddress;
import java.net.Socket;

public class NetworkClient {
	public void client() {
		int port = 3000;
		String serverIP = null;
		try {
			serverIP = InetAddress.getLocalHost().getHostAddress();
			System.out.println(serverIP);
			System.err.println("=========");
			Socket socket = new Socket(serverIP, port);
			// Socket socket = new Socket("192.168.10.78", 3000);
			System.out.println("NetworkClient socket : " + socket);
		} catch (Exception e) {
			System.out.println("NetworkClient client : " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		NetworkClient nc = new NetworkClient();
		nc.client();
	}

}