package com.fenxing.interpreter;

import com.fenxing.AbstractGrammarInterpreter;
import com.fenxing.util.DrawUtil;

import java.awt.*;

/**
 * ������AB
 * @author zzk
 */
public class GrammarInterpreterAB extends AbstractGrammarInterpreter implements Cloneable{
	public GrammarInterpreterAB() {
		super();
	}

	public GrammarInterpreterAB(int length, String grammarString, Point startPoint, double startAngle, double rotateAngle) {
		super(length, grammarString, startPoint, startAngle, rotateAngle);
	}
	/**
	 * ����ʽ�ӽ��н��ͣ���ͼ
	 * @param g
	 */
	@Override
	public void interpret(Graphics g) {
		if(grammarString==null) return;
		for (char ch : grammarString.toCharArray()) {
			switch (ch) {
			case 'A':// ����
				startPoint = DrawUtil.drawLine(g, startPoint, startAngle, length);
				break;
			case 'B':
				startPoint = DrawUtil.drawLine(g, startPoint, startAngle, length);
				break;
			case '[':// ����״̬����תrotateAngle��
				try {
					stack.push((GrammarInterpreterAB) this.clone());
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
				startAngle -= rotateAngle;
				break;
			case '('://����״̬����תrotateAngle��
				try {
					stack.push((GrammarInterpreterAB) this.clone());
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
				startAngle += rotateAngle;
				break;
			case ']'://�ص���һ��
			case ')':
				GrammarInterpreterAB d = (GrammarInterpreterAB) stack.pop();
				this.startPoint = d.startPoint;
				this.startAngle = d.startAngle;
				this.length = d.length;
				break;
			}
		}
	}
}
