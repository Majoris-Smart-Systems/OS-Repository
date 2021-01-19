package com.esisa.os;

public class Buffer {
	private int counter = 0;
	
	public Buffer() {
	}

	public void next() {
		counter++;
	}

	public String toString() {
		return "[" + counter + "]";
	}
}
