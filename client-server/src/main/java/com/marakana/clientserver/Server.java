package com.marakana.clientserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket socket = new ServerSocket(3333);
			try {
				Socket client = socket.accept();
				try {
					BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
					try {
						String message = in.readLine();
						System.out.println(message);
					} finally {
						in.close();
					}
				} finally {
					client.close();
				}
			} finally {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
