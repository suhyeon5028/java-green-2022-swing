package site.metacoding.bubble.test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {

	// ���� : ����

	private JLabel backgroundMap;
	private Player player;

	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		setVisible(true);
	}

	// new �ϴ� ��
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
		add(backgroundMap);
		setContentPane(backgroundMap); // ��׶��� ȭ��

		player = new Player();
		add(player);
	}

	// ����
	private void initSetting() {
		setSize(1000, 640);
		getContentPane().setLayout(null); // JFrame�� �⺻ JPanel�� ���̾ƿ� ���� , setContentPane ���ϸ� add�Ҷ� ��ġ ������ �ؾ��Ѵ�
		setLocationRelativeTo(null); // ��� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ŭ���� �����ϱ�
	}

	private void initListener() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) { // Ű���� ������ ����
				System.out.println("Ű���� ������");
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					player.setRight(false);
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.setLeft(false);
				}

			}

			@Override
			public void keyPressed(KeyEvent e) { // Ű���� ������
				// ���� 37, �������� 39, ������ 38, �Ʒ����� 40
				// System.out.println("Ű���� ������ :" + e.getKeyCode());
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (player.isRight() == false) {
						player.right();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (player.isRight() == false) {
						player.left();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (player.isJump() == false) {
						player.jump();
					}

				}
			}
		});

	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}