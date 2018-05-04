package com.thread;

import java.net.Socket;
/**
 * �������(Strategy)��ɫ������һ�������ɫ��ͨ����һ���ӿڻ������ʵ�֡�
 * �˽�ɫ�������еľ������������Ľӿڡ�
 */
public interface IOStrategy {
	void service(Socket socket);
}
