package com.fenxing;

import com.fenxing.grammar.RandomKVGrammar;
import com.fenxing.grammar.SingleKVGrammar;
import com.fenxing.interpreter.GrammarInterpreterAB;
import com.fenxing.interpreter.GrammarInterpreterF;
import com.fenxing.util.DrawUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

/**
 * �ͻ��ˣ����Ʒ�����
 * @author zzk
 */
public class Client extends Frame {
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
	private double rotateAngle = 30;// ��ת��
	private int length = 5;// �߶γ���
	private int n = 5;// ��������
	private AbstractGrammarInterpreter interpreter = null;// ������
	{
		interpreter = new GrammarInterpreterF(length, grammarString, startPoint, startAngle, rotateAngle);
	}
	/**
	 * ������AB
	 */
	public void initTreeAB() {
		char start = 'B';
		char[] notEnd = { 'A', 'B' };
		char[] end = { '(', ')', '[', ']' };
		String[] productA = { "AA" };
		String[] productB = { "A[B]AA(B)" };
		HashMap<String, String[]> map = new HashMap<>();
		map.put("A", productA);
		map.put("B", productB);
		grammar = new SingleKVGrammar(start, end, notEnd, map);//ʹ��SingleKV�﷨����
		grammarString = grammar.product(n);
	}

	/**
	 * ���������
	 */
	public void initRandomTree() {
		char start = 'F';
		char[] notEnd = { 'F' };
		char[] end = { '+', '-', '[', ']' };
		String[] product = { "F-F++F-F", "F[+F]F[-F[+F]]", "FF+[+F+F]-[+F]", "F[+F][-F]", "F" };// ��

		HashMap<String, String[]> map = new HashMap<>();
		map.put("F", product);
		grammar = new RandomKVGrammar(start, end, notEnd, map);
		grammarString = grammar.product(n);
	}

	/**
	 * ��������״
	 */
	public void initPine() {
		char start = 'F';
		char[] notEnd = { 'F' };
		char[] end = { '+', '-', '[', ']' };
		String[] product = { "F[+F]F[-F[+F]]" };// �൹����
		HashMap<String, String[]> map = new HashMap<>();
		map.put("F", product);
		grammar = new RandomKVGrammar(start, end, notEnd, map);
		grammarString = grammar.product(n);
	}

	/**
	 * ѩ����״
	 */
	public void initSnowflake() {
		char start = 'F';
		char[] notEnd = { 'F' };
		char[] end = { '+', '-', '[', ']' };
		String[] product = { "F-F++F-F" };// ѩ��
		HashMap<String, String[]> map = new HashMap<>();
		map.put("F", product);
		grammar = new RandomKVGrammar(start, end, notEnd, map);
		grammarString = grammar.product(n);
	}

	/**
	 * ���ƶԳƷ�������ʹ��ʱ����lengthΪ100���Զ�����length�Լ�����
	 */
	public void initSymmetricalTree() {
		char start = 'F';
		char[] notEnd = { 'F' };
		char[] end = { '+', '-', '[', ']' };
		String[] product = { "F[+F][-F]" };// �ԳƷ�������ʹ��ʱ����lengthΪ100
		HashMap<String, String[]> map = new HashMap<>();
		map.put("F", product);
		grammar = new RandomKVGrammar(start, end, notEnd, map);
		grammarString = grammar.product(n);
	}

	public void loadFrame() {
		initRandomTree();
		this.setTitle("����");
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
		Panel pNorth = new Panel(new FlowLayout());// ��ť�������
		pNorth.setBounds(100, 50, 800, 50);
		Button btnRandomTree = new Button("���������");
		btnRandomTree.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				initRandomTree();
				length = 5;
				startAngle = 90;
				rotateAngle = 25;
				startPoint.x = 500;
				startPoint.y = 900;
				interpreter = new GrammarInterpreterF(length, grammarString, startPoint, startAngle, rotateAngle);
				repaint();
			}
		});
		Button btnSymmetricalTree = new Button("�ԳƷ�����");
		btnSymmetricalTree.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				initSymmetricalTree();
				length = 100;
				startAngle = 90;
				rotateAngle = 25;
				startPoint.x = 500;
				startPoint.y = 900;
				interpreter = new GrammarInterpreterF(length, grammarString, startPoint, startAngle, rotateAngle);
				repaint();
			}
		});
		Button btnSnowflake = new Button("ѩ��");
		btnSnowflake.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				initSnowflake();
				length = 100 / n;
				startAngle = 30;
				rotateAngle = 60;
				startPoint.x = 1000;
				startPoint.y = 500;
				interpreter = new GrammarInterpreterF(length, grammarString, startPoint, startAngle, rotateAngle);
				repaint();
			}
		});
		Button btnSpecialTree = new Button("AB��");
		btnSpecialTree.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				initTreeAB();
				length = 100/(n*n);
				startAngle = 90;
				rotateAngle = 45;
				startPoint.x = 500;
				startPoint.y = 900;
				interpreter = new GrammarInterpreterAB(length, grammarString, startPoint, startAngle, rotateAngle);
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
		pNorth.add(label);
		pNorth.add(box);
		pNorth.add(btnRandomTree);
		pNorth.add(btnSnowflake);
		pNorth.add(btnSymmetricalTree);
		pNorth.add(btnSpecialTree);
		this.add(pNorth);
		//��ɫ��
		Panel pMiddle = new Panel();
		Label labelColor = new Label("������ɫ");
		pMiddle.setBounds(100, 100, 800, 50);
		Button btnRed = new Button("  ");
		Button btnGreen = new Button("  ");
		Button btnBlue = new Button("  ");
		Button btnBlack = new Button("  ");
		
		btnRed.setBackground(Color.RED);
		btnGreen.setBackground(Color.GREEN);
		btnBlue.setBackground(Color.BLUE);
		btnBlack.setBackground(Color.BLACK);
		
		MyListener listener = new MyListener();
		
		btnRed.addActionListener(listener);
		btnGreen.addActionListener(listener);
		btnBlue.addActionListener(listener);
		btnBlack.addActionListener(listener);

		pMiddle.add(labelColor);
		pMiddle.add(btnRed);
		pMiddle.add(btnGreen);
		pMiddle.add(btnBlue);
		pMiddle.add(btnBlack);
		this.add(pMiddle);
	}

	@Override
	public void paint(Graphics g) {
		interpreter.interpret(g);
	}
	public static void main(String[] args) {
		new Client().loadFrame();
	}
}

class MyListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		Button btn =null;
		if(e.getSource() instanceof Button){
			btn=(Button) e.getSource();
		}
		DrawUtil.color=btn.getBackground();
	}
	
}
