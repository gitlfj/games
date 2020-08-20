package com.fenxing.grammar;

import com.fenxing.AbstractGrammar;

import java.util.HashMap;
import java.util.Random;

/**
 * �﷨���������� ���Ҳ�ȫ�����ÿ�ε���ֻӦ��һ������ʽ����
 * 
 * @author zzk
 */
public class RandomKVGrammar extends AbstractGrammar {
	public RandomKVGrammar() {
		super();
	}

	public RandomKVGrammar(char start, char[] end, char[] notEnd, HashMap<String, String[]> productMap) {
		super(start, end, notEnd, productMap);
	}

	public boolean isLegal() {
		return false;
	}

	/**
	 * ���key�����value,���������ַ���
	 */
	@Override
	public String product(int n) {
		if (n < 0)
			return null;
		String result = new String(getStart() + "");
		Random r = new Random();
		HashMap<String, String[]> productMap = getProductMap();
		if (n == 0)
			return result;
		Object[] keys = productMap.keySet().toArray();// ������
		for (int i = 0; i < n; i++) {// ����
			String key = (String) keys[r.nextInt(keys.length)];// �����ȡһ����
			String[] values = productMap.get(key);// �õ�����ʽ����
			String value = values[r.nextInt(values.length)];
			result = result.replace(key, value);// ���Ӧ��һ������ʽ
		}
		System.out.println("result:"+result);
		return result;
	}

}
