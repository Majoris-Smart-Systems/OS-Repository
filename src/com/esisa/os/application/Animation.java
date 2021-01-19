package com.esisa.os.application;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Animation extends JFrame implements MouseListener {
	private static final long serialVersionUID = 1L;
	
	private JPanel screen;

	public Animation() {
		init();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
	}
	
	void init() {
		screen = new JPanel();
		screen.setBackground(Color.black);
		screen.setLayout(null);
		screen.addMouseListener(this);
		setContentPane(screen);
	}

	public static void main(String[] args) {
		new Animation();
	}

	public void mouseClicked(MouseEvent e) {	
		Pingouin p1 = new Pingouin("Ismail", e.getX(), e.getY());
		screen.add(p1);
		p1.start();
	}

	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}

}
