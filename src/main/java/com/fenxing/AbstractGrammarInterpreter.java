package com.fenxing;

import java.awt.*;
import java.util.Stack;

/**
 * ���������
 * @author zzk
 */
public abstract class AbstractGrammarInterpreter implements Cloneable{
	protected Point startPoint;// ��ʼλ��
	protected double startAngle;// ��ʼ�Ƕ�
	protected double rotateAngle;// ��ת��
	protected int length;// �߶γ���
	protected String grammarString;// �﷨ʽ
	protected Stack<AbstractGrammarInterpreter> stack = new Stack<>();// ״̬ջ

	public AbstractGrammarInterpreter() {
		super();
	}

	public AbstractGrammarInterpreter(int length, String grammarString, Point startPoint, double startAngle, double rotateAngle) {
		super();
		this.length = length;
		this.grammarString = grammarString;
		this.startPoint = startPoint;
		this.startAngle = startAngle;
		this.rotateAngle = rotateAngle;
	}

	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public double getStartAngle() {
		return startAngle;
	}

	public void setStartAngle(double startAngle) {
		this.startAngle = startAngle;
	}

	public double getRotateAngle() {
		return rotateAngle;
	}

	public void setRotateAngle(double rotateAngle) {
		this.rotateAngle = rotateAngle;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getGrammarString() {
		return grammarString;
	}

	public void setGrammarString(String grammarString) {
		this.grammarString = grammarString;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	@Override
	public String toString() {
		return "AbstractGrammarInterpreter [startPoint=" + startPoint + ", startAngle=" + startAngle + ", rotateAngle="
				+ rotateAngle + ", length=" + length +", stack=" + stack + "]";
	}
	/**
	 * ����
	 * @param g
	 */
	public abstract void interpret(Graphics g);
}
