package com.esisa.os;

public class Processus extends Thread {
	private int counter = 0;
	private Buffer buffer;

	public Processus(String name, Buffer buffer) {
		super(name);
		this.buffer = buffer;
	}
	
	public void run() {
		do {
			counter++;
			buffer.next();
			System.out.println(Thread.currentThread().getName()
					+ " : " + counter + " => " + buffer);
			pause(100);
		}
		while(true);
	}
	
	public static void pause(int time) {
		try {
			sleep(time);
		}
		catch (Exception e) {}
	}

}
