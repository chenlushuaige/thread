package com.thread;

import java.net.*;

public class NwServer {
	public NwServer(IOStrategy ios) {
		try {
			ServerSocket ss = new ServerSocket(8888);
			while (true) {
				Socket socket = ss.accept();
				ios.service(socket);

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
