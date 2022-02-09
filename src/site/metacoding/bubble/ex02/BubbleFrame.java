package site.metacoding.bubble.ex02;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {
	/**
	 * 
	 * @ author ��Ÿ�ڵ� ����: ���ȭ�鼳��, ĳ�����߰�
	 */

	private JLabel backgroundMap;
	private Player player;

	public BubbleFrame() {
		initObject();
		initSetting();
		setVisible(true); // ���ο� paintComponent()ȣ�� �ڵ尡 �ִ�.
	}

//new �ϴ� ��
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
		add(backgroundMap);
		setContentPane(backgroundMap); // ��׶��� ȭ��

		player = new Player();
		add(player);
	}

	// ���� ��� ����
	private void initSetting() {
		setSize(1000, 640);
		getContentPane().setLayout(null); // JFrame�� �⺻ JPanel�� ���̾ƿ� ���� , setContentPane �ּ�ó�� ���ϸ� add�Ҷ���� ���� ��ġ ������
											// �ؾ��Ѵ�
		setLocationRelativeTo(null); // ��� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ŭ���� JVM ���� �����ϱ�
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}