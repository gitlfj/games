package com.fenxing.util;

import java.awt.*;
import java.util.Random;

/**
 * ��ͼ������
 * 
 * @author zzk
 */
public class DrawUtil {
	private static Random r = new Random();
	public static Color color = Color.BLACK;
	public static boolean isRandomColor = false;
	/**
	 * ����
	 */
	public static Point drawLine(Graphics g, Point start, double angle, int length) {
		g.setColor(color);
		if(isRandomColor){
			color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		}
		Point end = new Point((int) (start.x - length * Math.cos(Math.toRadians(angle))),
				(int) (start.y - length * Math.sin(Math.toRadians(angle))));
		g.drawLine(start.x, start.y, end.x, end.y);
		return end;
	}
}
