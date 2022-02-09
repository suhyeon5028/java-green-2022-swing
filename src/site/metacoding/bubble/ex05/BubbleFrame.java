package site.metacoding.bubble.ex05;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {
	/**
	 * 
	 * @ author ��Ÿ�ڵ� ����: ����
	 */

	private JLabel backgroundMap;
	private Player player;

	int count = 0;

	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
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
					// isRight�� false
					player.setRight(false);
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.setLeft(false);

				}

			}

			@Override
			public void keyPressed(KeyEvent e) { // Ű���带 ������
				// ���� 37, �������� 39, ������ 38, �Ʒ����� 40
				// System.out.println("Ű���� ������ :" +e.getKeyCode());

				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					// Ű���带 ������ �ִ� ���� right �޼��带 �ѹ��� �����ϰ� �ʹ�. -> ������ �ִ��� ������ ������������ ���� ���º��� �ʿ�
					if (player.isRight() == false) {
						player.right();
					}

				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (player.isRight() == false) {
						player.left();
					}

				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (player.isJump() == false) {
						player.jump(); // �޼��� ���ο��� if �б� ó���� �̺�Ʈ ������ ����� �Ǵµ� ������ �ȵǴ� ��
					}

				}
			}
		}); // ����� ���⶧����

	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}