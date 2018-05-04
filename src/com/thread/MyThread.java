package com.thread;

import java.net.*;

public class MyThread extends Thread {
	private Socket socket;
	private IOStrategy ios;

	public MyThread(IOStrategy ios) {
		super();
		this.ios = ios;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			wait();
			ios.service(socket);
			socket = null;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
		notify();
	}

	public boolean isIdle() {
		return socket == null;
	}
}
