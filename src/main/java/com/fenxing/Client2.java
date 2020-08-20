package com.fenxing;

import com.fenxing.grammar.RandomKVGrammar;
import com.fenxing.interpreter.GrammarInterpreterF;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

/**
 * �ͻ��ˣ������Զ��������
 * 
 * @author zzk
 */
public class Client2 extends Frame {
	/**
	 * ���к�
	 */
	private static final int FRAME_WIDTH = 1000;// ���ڿ��
	private static final int FRAME_HEIGHT = 1000;// ���ڸ߶�
	private static final long serialVersionUID = -1503870997066468394L;
	private String grammarString;// �ķ��ַ���
	private AbstractGrammar grammar;// �﷨������
	private Point startPoint = new Point(500, 900);// ��ʼλ��
	private double startAngle = 90;// ��ʼ�Ƕ�
	private double rotateAngle = 25;// ��ת��
	private int length = 5;// �߶γ���
	private int n = 5;// ��������
	private AbstractGrammarInterpreter interpreter = null;// ������
	{
		interpreter = new GrammarInterpreterF(length, grammarString, startPoint, startAngle, rotateAngle);
	}

	public void loadFrame() {
		this.setTitle("�Զ������");
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setBackground(Color.WHITE);
		this.setLocationRelativeTo(null);// ����
		this.setResizable(false);
		this.setFont(new Font("��Բ", Font.BOLD, 20));
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setLayout(null);
		this.initComponent();// ��ʼ�����
		this.setVisible(true);
	}

	// ��ʼ�����
	public void initComponent() {
		Label tips = new Label("�Զ������ʽ:(�󲿱����а���'F',�����ַ�ֻ��Ϊ\n'+', '-', '[', ']','F'�е�һ��)");
		tips.setBounds(200, 50, 1000, 50);
		this.add(tips);
		Panel pRight = new Panel();// ��ť�������
		pRight.setLocation(250, 100);
		pRight.setSize(500, 150);
		Label product1 = new Label("����ʽ1:");
		TextField left1 = new TextField(5);// ��1
		Label labelP1 = new Label("->");
		TextField right1 = new TextField(15);// �Ҳ�1

		Label product2 = new Label("����ʽ2:");
		TextField left2 = new TextField(5);// ��2
		Label labelP2 = new Label("->");
		labelP2.setSize(20, 20);
		TextField right2 = new TextField(15);// �Ҳ�2

		Button btnDraw = new Button("����");
		char start = 'F';
		char[] notEnd = { 'F' };
		char[] end = { '+', '-', '[', ']' };
		String[] product = {};// ��
		btnDraw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HashMap<String, String[]> map = new HashMap<>();
				String l1 = left1.getText();
				String r1 = right1.getText();
				String l2 = left2.getText();
				String r2 = right2.getText();
				if(l1!=null&&!"".equals(l1)&&(r1!=null&&!"".equals(r1))){
					map.put(l1, new String[] { r1 });
				}
				
				if(l2!=null&&!"".equals(l2)&&(r2!=null&&!"".equals(r2))){
					if(l2.equals(l1)){
						map.put(l1, new String[]{r1,r2});
					}
					else{
						map.put(l2, new String[] { r2 });
					}
				}
				grammar = new RandomKVGrammar(start, end, notEnd, map);
				grammarString = grammar.product(n);
				interpreter = new GrammarInterpreterF(length, grammarString, startPoint, startAngle, rotateAngle);
				repaint();
			}
		});
		Label label = new Label("��������");
		Integer[] ints = { 1, 2, 3, 4, 5, 6, 7, 8 };
		JComboBox<Integer> box = new JComboBox<>(ints);
		box.setSelectedItem(n);
		box.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					n = (int) e.getItem();
				}
			}
		});
		pRight.add(product1);
		pRight.add(left1);
		pRight.add(labelP1);
		pRight.add(right1);

		pRight.add(product2);
		pRight.add(left2);
		pRight.add(labelP2);
		pRight.add(right2);

		pRight.add(label);
		pRight.add(box);
		pRight.add(btnDraw);

		this.add(pRight);
	}

	@Override
	public void paint(Graphics g) {
		interpreter.interpret(g);
	}

	public static void main(String[] args) {
		new Client2().loadFrame();
	}
}
