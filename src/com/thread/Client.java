package com.thread;
import java.io.IOException;
import java.net.*;
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket socket=new Socket("localhost", 9999);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
