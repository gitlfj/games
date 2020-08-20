package com.snake.core;

import com.zzk.snake.core.Drawable;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public abstract class SnakeObject implements Drawable {

	int x;//������
	int y;//������
	Image img;//ͼƬ
	int width;//ͼƬ���
	int height;//ͼƬ�߶�
	public boolean live;//����/���
	
	@Override
	public abstract void draw(Graphics g);
	/**
	 * ��ȡͼƬ��Ӧ�ľ���
	 * 
	 * @return
	 */
	public Rectangle getRectangle() {
		return new Rectangle(x, y, width, height);
	}
}
