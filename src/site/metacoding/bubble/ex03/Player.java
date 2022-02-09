package site.metacoding.bubble.ex03;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * @author ��Ÿ�ڵ�
 * �÷��̾�� �¿� �̵��� �����ϴ�.
 * ������ �����ϴ�
 * ��� �߻� (���߿� ��������)*/

public class Player extends JLabel {

	private ImageIcon playerR, playerL;
	private int x;
	private int y;

	public Player() {
		initObject();
		initSetting();

	}

	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}

	private void initSetting() {
		x = 70;
		y = 535;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y); // paintComponent ȣ������

	}

	public void left() {
		setIcon(playerL);
		System.out.println("���� �̵�");
		x = x - 10;
		setLocation(x, y);

	}

	public void right() {
		setIcon(playerR);
		System.out.println("������ �̵�");
		x = x + 10;
		setLocation(x, y);
	}

}