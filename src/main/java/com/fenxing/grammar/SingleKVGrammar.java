package com.fenxing.grammar;

import com.fenxing.AbstractGrammar;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

/**
 * �﷨����������
 * һ��key��Ӧһ��value��ÿ�ε���Ӧ��ÿ��key��value
 * @author zzk
 */
public class SingleKVGrammar extends AbstractGrammar {

	public SingleKVGrammar() {
		super();
	}

	public SingleKVGrammar(char start, char[] end, char[] notEnd, HashMap<String, String[]> productMap) {
		super(start, end, notEnd, productMap);
	}

	@Override
	public boolean isLegal() {
		HashMap<String, String[]> map = getProductMap();
		Set<Entry<String, String[]>> entrys = map.entrySet();
		Iterator<Entry<String, String[]>> iterator = entrys.iterator();
		Entry<String, String[]> entry=null;
		while(iterator.hasNext()){
			entry = iterator.next();
			String key = entry.getKey();
			String[] value = entry.getValue();
			if(!key.contains(getStart()+"")||value==null||value.length<1){//�������ʽ�󲿲�������ʼ�����Ҳ�����С��1
				return false;
			}
		}
		return false;
	}

	@Override
	public String product(int n) {
		if (n < 0)
			return null;
		String result = new String(getStart()+"");
		Random r = new Random();
		HashMap<String, String[]> productMap = getProductMap();
		if (n == 0)
			return result;
		Object[] keys = productMap.keySet().toArray();// key����
		for (int i = 0; i < n; i++) {// ����
			for (Object key : keys) {
				String[] values = productMap.get(key);// �õ�values�Ҳ�����
				result = result.replace((String) key, values[0]);//�滻
			}
		}
		System.out.println(result);
		return result;
	}
}
