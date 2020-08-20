package com.fenxing;

import java.util.HashMap;

/**
 * ������﷨����������
 * @author zzk
 */
public abstract class AbstractGrammar {
	private char start;// ��ʼ��
	private char[] end;// �ս������
	private char[] notEnd;// ���ս������
	private HashMap<String, String[]> productMap;// ����ʽ����
	
	public AbstractGrammar() {
		super();
	}
	public AbstractGrammar(char start, char[] end, char[] notEnd, HashMap<String, String[]> productMap) {
		super();
		this.start = start;
		this.end = end;
		this.notEnd = notEnd;
		this.productMap = productMap;
	}
	public char getStart() {
		return start;
	}
	public void setStart(char start) {
		this.start = start;
	}
	public char[] getEnd() {
		return end;
	}
	public void setEnd(char[] end) {
		this.end = end;
	}
	public char[] getNotEnd() {
		return notEnd;
	}
	public void setNotEnd(char[] notEnd) {
		this.notEnd = notEnd;
	}
	public HashMap<String, String[]> getProductMap() {
		return productMap;
	}
	public void setProductMap(HashMap<String, String[]> productMap) {
		this.productMap = productMap;
	}
	/**
	 * �����Ƿ�Ϸ�
	 * @return
	 */
	public abstract boolean isLegal();
	/**
	 * ���ɵ���n��֮���ʽ��
	 */
	public abstract String product(int n);
}
