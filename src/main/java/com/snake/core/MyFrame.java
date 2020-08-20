package com.snake.core;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.snake.constant.Constant;

public class MyFrame extends Frame{
	/**
	 * ���ش���
	 */
	public void loadFrame(){
		this.setTitle("̰����");//���ô������
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);//���ô����С
		this.setBackground(Color.BLACK);//���ñ���
		this.setLocationRelativeTo(null);//����
		//���ÿɹر�
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		//���ÿɼ�
		this.setVisible(true);
		//�����ػ��߳�
		new MyThread().start();
	}
	/**
	 * ��ֹͼƬ��˸��ʹ��˫�ػ���
	 * 
	 * @param g
	 */
	Image backImg = null;

	@Override
	public void update(Graphics g) {
		if (backImg == null) {
			backImg = createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		}
		Graphics backg = backImg.getGraphics();
		Color c = backg.getColor();
		backg.setColor(Color.BLACK);
		backg.fillRect(0, 0, Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		backg.setColor(c);
		paint(backg);		
		g.drawImage(backImg, 0, 0, null);
	}
	/**
	 * ���ﴴ��һ�������ػ���߳��ڲ���
	 * 
	 * @param args
	 */
	class MyThread extends Thread{
		@Override
		public void run() {
			while(true){
				repaint();
				try {
					sleep(30);//ÿ30�����ػ�һ��
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
