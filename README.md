# Greedy-snake
java编写一个贪吃蛇小游戏(本示例参考了最后的视频链接)
### 效果展示
![](https://github.com/djh-sudo/Greedy-snake/blob/main/demo.gif)
[参考视频](https://www.bilibili.com/video/BV1HE41127CV?p=2&rt=V%2FymTlOu4ow%2Fy4xxNWPUZ9svl%2BOiBwHIWoOLY38q0NQ%3D)
### 思路
首先要明确一点，图像之所以能够不断移动，是因为屏幕在不断刷新，当频率达到一定程度时，我们由于视觉暂留，会认为图像是一个流畅的播放过程。
这里根据原作者思路，将整个页面划分为大小为`25 x 25`的网格，小蛇移动的范围在`(25,75)->(850,600)`
### 资源准备

1. 4张4个方向蛇头的图片(`25 x 25`)
2. 1张豆子图片(`25 x 25`)
3. 一张标题栏图片(可省略,`850 x 50`)

### 导入资源
添加一个`Data。class`类
1.在src文件夹中创建一个资源文件夹，用于存放图片，命名如`source`,将所有图片资源放入其中。
2.创建一个`Data`类，用于加载程序中的图片
```java
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

```
这里之所以要用static修饰，表明整个图片资源为整个类所有，可以通过类名直接访问，并不属于某个对象。
### 创建一个窗体
添加一个`Start.class`类

```java
package com;

import java.awt.Color;

import javax.swing.JFrame;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Copyright @2021 by DJH");    //create a new window and set title
		frame.setBounds(150,100,915,720);                       //(x,y,width,hight)
		frame.setResizable(false);                              //the size of window can't be modified
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // click the x to terminate the process
		frame.add(new gamePanel());                             //add a new panel on this window
		frame.setVisible(true);                                 //show window
		
	}

}

```
这里用到了`JFrame`类，创建了一个窗体，但是目前绘图面板还是空的，需要继续添加元素
### 核心代码
添加一个`gamePanel`类
其中变量有
```java
int length;
	int[] X = new int[600];			//存储小蛇X
	int[] Y = new int[500];			//存储小蛇Y
	int foodX;				//食物X坐标
	int foodY;				//食物Y坐标
	int score;				//当前得分
	String forward;				// 方向
	boolean isStart;			//游戏开始标志
	boolean isFail;				//游戏失败结束标志
	Random random = new Random();		//随机数用于模拟豆子
	Timer timer = new Timer(200,this);	//定时器，用于刷新页面，每200ms一次
```
# To be continue ...
