package com.esisa.os;

public class Examples {

	public Examples() {
		exp01();
	}
	
	void exp01() {
		Buffer buffer = new Buffer();
		Processus p1 = new Processus("Ali", buffer);
		Processus p2 = new Processus("Ismail", buffer);
		Processus p3 = new Processus("Wissal", buffer);

		p1.start();
		p2.start();
		p3.start();
/*
		int counter = 0;
		do {
			counter++;
			System.out.println(Thread.currentThread().getName()
					+ " : " + counter);
			Processus.pause(100);
		}
		while(true);*/
	}

	public static void main(String[] args) {
		new Examples();
	}

}
