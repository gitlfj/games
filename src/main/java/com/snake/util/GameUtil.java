package com.snake.util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class GameUtil {

	/**
	 * ����ͼƬ�����·����ȡͼƬ
	 * 
	 * @param imagePath
	 * @return ͼƬ
	 */
	public static Image getImage(String imagePath) {
		URL url = GameUtil.class.getClassLoader().getResource(imagePath);
		BufferedImage img = null;
		try {
			img = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	/**
	 * ��ָ���Ƕ���תͼƬ
	 * @param bufferedimage
	 * @param degree
	 * @return ͼƬ
	 */
	public static Image rotateImage(final BufferedImage bufferedimage, final int degree) {
		int w = bufferedimage.getWidth();// �õ�ͼƬ��ȡ�
		int h = bufferedimage.getHeight();// �õ�ͼƬ�߶ȡ�
		int type = bufferedimage.getColorModel().getTransparency();// �õ�ͼƬ͸���ȡ�
		BufferedImage img;// �յ�ͼƬ��
		Graphics2D graphics2d;// �յĻ��ʡ�
		(graphics2d = (img = new BufferedImage(w, h, type)).createGraphics())
				.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		graphics2d.rotate(Math.toRadians(degree), w / 2, h / 2);// ��ת��degree�����ͣ����������紹ֱ90�ȡ�
		graphics2d.drawImage(bufferedimage, 0, 0, null);// ��bufferedimagecopyͼƬ��img��0,0��img�����ꡣ
		graphics2d.dispose();
		return img;// ���ظ��ƺõ�ͼƬ��ԭͼƬ��Ȼû�б䣬û����ת���´λ�����ʹ�á�
	}
}
