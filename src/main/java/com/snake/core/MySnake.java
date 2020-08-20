package com.snake.core;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

import com.snake.constant.Constant;
import com.snake.util.GameUtil;
import com.snake.util.ImageUtil;

public class MySnake extends SnakeObject implements Moveable {
	//��ͷͼƬ��δ��ת��
	private static final BufferedImage IMG_SNAKE_HEAD = (BufferedImage) ImageUtil.images.get("snake_head");

	private int speed;//�ƶ��ٶ�
	private int length;//����
	private int num;//
	public static List<Point> bodyPoints = new LinkedList<>();
	public int score = 0;//����
	private static BufferedImage newImgSnakeHead;//��ת�����ͷͼƬ
	boolean up, down, left, right = true;//��ʼ̬����
	public MySnake(int x, int y) {
		this.live = true;
		this.x = x;
		this.y = y;
		this.img = ImageUtil.images.get("snake_body");
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		this.speed = 5;
		this.length = 1;
		this.num = width / speed;
		newImgSnakeHead = IMG_SNAKE_HEAD;
	}

	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length=length;
	}
	/**
	 * ���ռ��̰����¼�
	 * @param e
	 */
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			if (!down) {// �������ʼ����ķ������ƶ�
				up = true;
				down = false;
				left = false;
				right = false;
				newImgSnakeHead = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD, -90);//��תͼƬ
			}
			break;
		case KeyEvent.VK_DOWN:
			if (!up) {
				up = false;
				down = true;
				left = false;
				right = false;
				newImgSnakeHead = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD, 90);
			}
			break;
		case KeyEvent.VK_LEFT:
			if (!right) {
				up = false;
				down = false;
				left = true;
				right = false;
				newImgSnakeHead = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD, -180);
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (!left) {
				up = false;
				down = false;
				left = false;
				right = true;
				newImgSnakeHead = IMG_SNAKE_HEAD;
			}
			break;
		}
	}
	/**
	 * �ƶ�
	 */
	@Override
	public void move() {
		if (up)
			y -= speed;
		else if (down)
			y += speed;
		else if (left)
			x -= speed;
		else if (right)
			x += speed;
	}
	/**
	 * ����
	 */
	@Override
	public void draw(Graphics g) {
		outOfBounds();//�����������
		eatBody();//�����Ƿ�Ե���������
		bodyPoints.add(new Point(x, y));//����켣
		if (bodyPoints.size() == (this.length+1) * num) {//������Ĺ켣��ĸ���Ϊ�ߵĳ���+1��num��ʱ
			bodyPoints.remove(0);//�Ƴ���һ��
		}
		g.drawImage(newImgSnakeHead, x, y, null);//������ͷ
		drawBody(g);//��������
		move();//�ƶ�
	}
	/**
	 * �����Ƿ�Ե�����������
	 */
	public void eatBody(){
		for (Point point : bodyPoints) {
			for (Point point2 : bodyPoints) {
				if(point.equals(point2)&&point!=point2){
					this.live=false;//ʳ������
				}
			}
		}
	}
	/**
	 * ��������
	 * @param g
	 */
	public void drawBody(Graphics g) {
		int length = bodyPoints.size() - 1-num;//ǰnum���洢������ͷ�ĵ�ǰ�켣����
		for (int i = length; i >= num; i -= num) {//��β�����
			Point p = bodyPoints.get(i);
			g.drawImage(img, p.x, p.y, null);
		}
	}

	/**
	 * �����������
	 */
	private void outOfBounds() {
		boolean xOut = (x <= 0 || x >= (Constant.GAME_WIDTH - width));
		boolean yOut = (y <= 40 || y >= (Constant.GAME_HEIGHT - height));
		if (xOut || yOut) {
			live = false;
		}
	}
}
