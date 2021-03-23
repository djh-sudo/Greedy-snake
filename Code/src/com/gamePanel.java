package com;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.*;


public class gamePanel extends JPanel implements KeyListener, ActionListener{
	int length;
	int[] X = new int[600];
	int[] Y = new int[500];

	int foodX;
	int foodY;
	
	int score;
	// 方向
	String forward;
	//flag
	boolean isStart;
	boolean isFail;
	Random random = new Random();
	Timer timer = new Timer(200,this);


	public void inicial() {
		length = 3;
		score = 0;
		X[0] = 100; Y[0] = 100;
		X[1] = 75; Y[1] = 100;
		X[2] = 50; Y[2] = 100;
		forward = "right";
		isStart = false;
		isFail = false;
		foodX = 25 + 25*random.nextInt(34);
		foodY = 75+25*random.nextInt(24);
	}

	public gamePanel() {
		inicial();
		this.setFocusable(true);
		this.addKeyListener(this);
		timer.start();
	}


	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		this.setBackground(Color.gray);
		Data.headerImgIcon.paintIcon(this, g, 25, 10);
		g.fillRect(25, 75, 850, 600);
		if(forward.equals("right")) {
			Data.rightImgIcon.paintIcon(this, g, X[0], Y[0]);
		}
		else if(forward.equals("left")) {
			Data.leftImgIcon.paintIcon(this, g, X[0], Y[0]);

		}
		else if(forward.equals("up")) {
			Data.upImgIcon.paintIcon(this, g, X[0], Y[0]);
		}
		else if(forward.equals("down")) {
			Data.downImgIcon.paintIcon(this, g, X[0], Y[0]);
		}

		for(int i=1;i<length;i++) {
			Data.bodyImgIcon.paintIcon(this, g, X[i], Y[i]);
		}
		Data.foodImgIcon.paintIcon(this, g, foodX, foodY);

		if(isStart == false) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("SimHei",Font.BOLD,30));
			g.drawString("press Space to start the game!", 200, 300);
		}
		if (isFail == true) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("SimHei",Font.BOLD,30));
			g.drawString("Game Over!", 300, 300);
		}
		g.setColor(Color.GREEN);
		g.setFont(new Font("SimHei",Font.BOLD,18));
		g.drawString("length: "+ length, 750, 25);
		g.drawString("score: "+ score, 750, 50);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_SPACE) {
			if(isFail) {
				isFail = false;
				inicial();
			}
			else {
			isStart = !isStart;
			}
			repaint(); //刷新界面
		}
		else if(keyCode == KeyEvent.VK_LEFT && !(forward.equals("right"))) {
			forward = "left";
		}
		else if(keyCode == KeyEvent.VK_RIGHT && !(forward.equals("left"))) {
			forward = "right";
		}
		else if(keyCode == KeyEvent.VK_UP && !(forward.equals("down"))) {
			forward = "up";
		}
		else if(keyCode == KeyEvent.VK_DOWN && !(forward.equals("up"))) {
			forward = "down";
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(isStart && !isFail) {
			for(int i = length - 1; i > 0; i--) {
				X[i] = X[i-1];
				Y[i] = Y[i-1];
			}
			if(forward.equals("right")) {
				X[0] = X[0] + 25;
				if(X[0]>850) {
					X[0] = 25;
				}
			}
			else if(forward.equals("left")) {
				X[0] = X[0] - 25;
				if(X[0] < 25) {
					X[0] = 850;
				}
			}
			else if(forward.equals("up")) {
				Y[0] = Y[0] - 25;
				if(Y[0] < 75) {
					Y[0] = 650;
				}
			}
			else if(forward.equals("down")){
				Y[0] = Y[0] + 25;
				if(Y[0] > 650) {
					Y[0] = 75;
				}
			}
			if(X[0] == foodX && Y[0] ==foodY) {
				length = length + 1;
				score = score + (foodX)/100 + (foodY)/100 + length;
				foodX = 25 + 25*random.nextInt(34);
				foodY = 75+25*random.nextInt(24);
			}
			
			//check
			for(int i = 1;i<length;i++) {
				if(X[0] == X[i] && Y[0] == Y[i]) {
					isFail =true;
					break;
				}
			}
			repaint();
		}
		timer.start();
	}

}
