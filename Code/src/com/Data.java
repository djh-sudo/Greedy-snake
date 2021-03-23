package com;

import java.net.URL;

import javax.swing.ImageIcon;

public class Data {
	public static URL header = Data.class.getResource("/source/header.png");
	public static ImageIcon headerImgIcon = new ImageIcon(header);
	
	public static URL body = Data.class.getResource("/source/body.png");
	public static ImageIcon bodyImgIcon = new ImageIcon(body);
	
	public static URL food = Data.class.getResource("/source/food.png");
	public static ImageIcon foodImgIcon = new ImageIcon(food);
	
	public static URL up = Data.class.getResource("/source/up.png");
	public static ImageIcon upImgIcon = new ImageIcon(up);
	
	public static URL down = Data.class.getResource("/source/down.png");
	public static ImageIcon downImgIcon = new ImageIcon(down);
	
	public static URL left = Data.class.getResource("/source/left.png");
	public static ImageIcon leftImgIcon = new ImageIcon(left);
	
	public static URL right = Data.class.getResource("/source/right.png");
	public static ImageIcon rightImgIcon = new ImageIcon(right);
	
}
