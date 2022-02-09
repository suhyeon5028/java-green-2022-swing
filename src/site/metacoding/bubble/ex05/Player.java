package site.metacoding.bubble.ex05;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * @author ��Ÿ�ڵ�
 * �÷��̾�� �¿� �̵��� �����ϴ�.
 * ������ �����ϴ�
 * ��� �߻� (���߿� ��������)*/

public class Player extends JLabel {

	private int x;
	private int y;
	private ImageIcon playerR, playerL;

	private boolean isRight; // ���������� �����ִ�?
	private boolean isLeft;
	private boolean isJump; // ���� ���� (up, down)

	private static final int JUMPSPEED = 2;
	private static final int SPEED = 2;

	public boolean isJump() {
		return isJump;
	}

	public void setJump(boolean isJump) {
		this.isJump = isJump;
	}

	public boolean isRight() { // is�� get�� �ȶ�!
		return isRight;
	}

	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}

	public boolean isLeft() {
		return isLeft;
	}

	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

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

		isRight = false; // ���������� �����̴� ���µ� �������� �����̴� ���µ� �ƴϱ� ������ false
		isLeft = false;
		isJump = false;
	}

	public void left() {
		setIcon(playerL);
		isLeft = true;
		System.out.println("���� �̵�");

		new Thread(() -> {
			while (isLeft) {
				x = x - SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}).start();
	}

	public void right() {
		isRight = true;
		setIcon(playerR);
		System.out.println("������ �̵�");

		new Thread(() -> {
			while (isRight) {
				x = x + SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}).start();

	}

	// Ű���� ������Ű
	public void jump() {
		isJump = true;
		setIcon(playerR);
		System.out.println("����");

		// ������ for���� ������ �ǿ�. -> �������� 0~130
		// up �϶��� sleep(5)

		new Thread(() -> {
			for (int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y - JUMPSPEED;
				setLocation(x, y);
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// down �϶��� sleep(3)
			for (int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y + JUMPSPEED;
				setLocation(x, y);
				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			isJump = false;
		}).start();
	}
}