package com;

import java.awt.Color;

import javax.swing.JFrame;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Copyright @2021 by DJH");
		frame.setBounds(150,100,915,720);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new gamePanel());
		frame.setVisible(true);
		
	}

}
