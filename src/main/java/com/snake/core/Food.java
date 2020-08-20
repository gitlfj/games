package com.snake.core;

import java.awt.Graphics;

import com.snake.constant.Constant;
import com.snake.util.ImageUtil;

public class Food extends SnakeObject{

	public Food(){
		this.live=true;
		this.img=ImageUtil.images.get("food");
		this.width=img.getWidth(null);
		this.height=img.getHeight(null);
		this.x=(int) (Math.random()*(Constant.GAME_WIDTH-width+10));
		this.y=(int) (Math.random()*(Constant.GAME_HEIGHT-40-height)+40);

	}
	/**
	 * ʳ�ﱻ�Եķ���
	 * @param mySnake
	 */
	public void eaten(MySnake mySnake){
		if(mySnake.getRectangle().intersects(this.getRectangle())&&live&&mySnake.live){
			this.live=false;//ʳ������
			mySnake.setLength(mySnake.getLength()+1);//���ȼ�һ
			mySnake.score+=10*mySnake.getLength();//�ӷ�
		}
	}
	/**
	 * ����ʳ��
	 */
	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
	}
	
}
