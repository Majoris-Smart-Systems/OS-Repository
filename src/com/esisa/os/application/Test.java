package com.esisa.os.application;

public class Test {

	public Test() {
		exp01();
	}
	
	void exp01() {
		Processus p1 = new Processus("Ali");
		Processus p2 = new Processus("Ismail");
		Processus p3 = new Processus("Wissal");
		
		p1.start();
		p2.start();
		p3.start();
	}

	public static void main(String[] args) {
		new Test();
	}

}
