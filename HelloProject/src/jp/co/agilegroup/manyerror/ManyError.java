package manyerror;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Robot;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.HelloServlet;

public class ManyError {

	public static void shutdown() {

	try {
		Robot rb = new Robot();
		rb.setAutoDelay(100);
		rb.keyPress(KeyEvent.VK_WINDOWS);
		rb.delay(500);
		rb.keyPress(KeyEvent.VK_D);
		rb.delay(1000);
		rb.keyRelease(KeyEvent.VK_D);
		rb.keyRelease(KeyEvent.VK_WINDOWS);
	} catch (AWTException e) {
		e.printStackTrace();
	}
	int n = 0;
	while (n < 2) {
		
		try {
			JFrame frame = new JFrame("Microsoft Windows");
			int y, u;
			y = (int) (Math.random() * HelloServlet.getH());
			u = (int) (Math.random() * HelloServlet.getW());
			JPanel p = new JPanel();
			p.setBackground(Color.RED);
			p.setLayout(null);
			//
			JButton button = new JButton("閉じる");
			button.setBounds(420, 250, 80, 30);
			p.add(button);
			//
			JLabel label = new JLabel("システムはシャットダウンされます。進行中の作業をすべて保存し、");
			label.setBounds(45, 100, 460, 20);
			p.add(label);
			Font g = new Font("Serif", Font.PLAIN, 14);
			label.setFont(g);
			//
			JLabel label2 = new JLabel("ログオフしてください。保存されていないデータは失われます。");
			label2.setBounds(45, 120, 460, 20);
			p.add(label2);
			Font h = new Font("Serif", Font.PLAIN, 14);
			label2.setFont(h);
			//
			JLabel label3 = new JLabel("シャットダウンは、NTAUTHORITY￥SYSTEMによって開始されました");
			label3.setBounds(45, 140, 460, 20);
			p.add(label3);
			Font i = new Font("Serif", Font.PLAIN, 14);
			label3.setFont(i);
			//
			JLabel label4 = new JLabel("=============警告==============");
			label4.setBounds(10, 10, 550, 30);
			Font f = new Font("Serif", Font.PLAIN, 30);
			label4.setFont(f);
			p.add(label4);
			Container contentPane = frame.getContentPane();
			contentPane.add(p, BorderLayout.CENTER);
			java.awt.Toolkit.getDefaultToolkit().beep();

			frame.getContentPane().add(p, BorderLayout.CENTER);
			frame.setSize(550, 350);
			frame.setVisible(true);
			frame.setBounds(u, y, 550, 350);


			/* Escキーを押すとウィンドウが閉じるようにする */
			frame.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent event) {
					switch (event.getKeyCode()) {
					case KeyEvent.VK_ESCAPE:
						frame.dispose();
						frame.setEnabled(true);
						break;
					}
				}
			});

			
			TimeUnit.MILLISECONDS.sleep(130);
		} catch (Exception e) {
		}
		continue;


		}
	}
}
