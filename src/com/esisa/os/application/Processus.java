package com.esisa.os.application;

/*
 * Comportement du processus
 */
public class Processus implements Runnable {
	private Thread runner;

	public Processus(String name) {
		runner = new Thread(this, name);
	}
	
	public void start() {
		runner.start();
	}

	public void run() {
		do {
			System.out.println(Thread.currentThread().getName());
			pause(100);
		}
		while(true);
	}
	
	public static void pause(int time) {
		try {
			Thread.sleep(time);
		}
		catch (Exception e) {}
	}
}
