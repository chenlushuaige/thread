package com.thread;
/*
 * ���������˲���ģʽ�������ģʽ��ThreadPool����ģʽ�еĻ�����ɫ;
 */
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ThreadPool implements IOStrategy {
	private List<MyThread> threads = new ArrayList<>();
	final int MIN_THREADS = 30;
	private IOStrategy ios = null;

	public ThreadPool(IOStrategy ios) {
		this.ios = ios;
		for (int i = 0; i < MIN_THREADS; i++) {
			MyThread t = new MyThread(ios);
			t.start();
			threads.add(t);
		}
		try {
			Thread.sleep(300);
		} catch (Exception e) {
			// TODO: handle exception
		} // �ȴ��̳߳ص��̶߳������С�
	}

	public void service(Socket socket) {
		MyThread t = null;
		boolean found = false;

		for (int i = 0; i < threads.size(); i++) {
			t = threads.get(i);
			if (t.isIdle()) {

				found = true;// �ҵ����е��߳�
				break;
			}
		}
		if (!found) {
			// ���û���ҵ������߳̾ʹ����µ��߳�
			t = new MyThread(ios);
			t.start();

			try {
				Thread.sleep(300);
			} catch (Exception e) {
				// TODO: handle exception
			}
			threads.add(t);// �����̳߳�
		}
		t.setSocket(socket);// �����߳�
	}

}
