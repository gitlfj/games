package com.fenxing.grammar;

import com.fenxing.AbstractGrammar;

import java.util.HashMap;
import java.util.Random;

/**
 * �﷨����������
 * ����Ҳ���һ�ε�������Ϊkey�ĸ���
 * @author zzk
 */
public class RandomValueGrammar extends AbstractGrammar{
	public RandomValueGrammar() {
		super();
	}
	public RandomValueGrammar(char start, char[] end, char[] notEnd, HashMap<String, String[]> productMap) {
		super(start, end, notEnd, productMap);
	}
	public boolean isLegal(){
		return false;
	}
	/**
	 * ÿ��key���Ӧ��һ��value�����������ַ���
	 */
	@Override
	public String product(int n) {
		if (n < 0)
			return null;
		String result = new String(getStart()+"");
		Random r = new Random();
		HashMap<String, String[]> productMap = getProductMap();
		if (n == 0)
			return result;
		Object[] keys = productMap.keySet().toArray();//������
		for (int i = 0; i < n; i++) {//����
			for (int j = 0,len=keys.length; j <len; j++) {//��������ʽmap��ÿ��key���Ӧ��һ��value
				String key = (String) keys[j];//key
				String[] values = productMap.get(key);//�õ�values����
				result = result.replace(key, values[r.nextInt(values.length)]);//���Ӧ��һ������ʽ
			}
		}
		System.out.println(result);
		return result;
	}

}
