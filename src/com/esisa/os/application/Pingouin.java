package com.esisa.os.application;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Pingouin extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	
	private Thread runner;
	private int width = 30, height = 30;
	private int x, y;
	
	private String src[] = {
		"stop", "right1", "right2", "right3", "left1", "left2", "left3"
	};
	private Image images[];
	private String folder = "resources/os/";
	private String type = ".gif";
	
	private int current = 0;
	private int step = 3;
	

	public Pingouin(String name, int x, int y) {
		runner = new Thread(this, name);
		this.x = x;
		this.y = y;
		
		setToolTipText(name);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setLocation(x, y);
		setSize(width, height);
		loadImages();
	}
	
	private void loadImages() {
		images = new Image[src.length];
		for (int i = 0; i < images.length; i++) {
			ImageIcon icon = new ImageIcon(folder + src[i] + type);
			images[i] = icon.getImage();
		}
	}
	
	public void start() {
		runner.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(images[current], 0, 0, null);
	}

	public void run() {
		do {
			int decision = (int)(Math.random() * 100);
			if (decision < 40) {
				goRight(3);
			}
			else if (decision < 80) {
				goLeft(3);
			}
			else {
				stop();
			}
		}
		while(true);
	}
	
	public void goRight(int n) {
		for(int j = 0; j < n; j++) {
			for (int i = 1; i <= 3; i++) {
				current = i;
				x = x + step;
				setLocation(x, y);
				repaint();
				pause(100);
			}
		}
	}
	
	public void goLeft(int n) {
		for(int j = 0; j < n; j++) {
			for (int i = 4; i <= 6; i++) {
				current = i;
				x = x - step;
				setLocation(x, y);
				repaint();
				pause(100);
			}
		}
	}
	
	public void stop() {
		current = 0;
		repaint();
		pause(1000, 3000);
	}
	
	public static void pause(int time) {
		try {
			Thread.sleep(time);
		}
		catch (Exception e) {}
	}
	
	public static void pause(int min, int max) {
		int time = (int)(Math.random() * (max - min) + min);
		pause(time);
	}
}
