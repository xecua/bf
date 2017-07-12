package jp.co.agilegroup.sample;

import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class FreeCapture {


	public void doCapture() {
		
		int w = HelloServlet.w - 3;
		int h = HelloServlet.h - 3;
		
		try {
			Robot r2d2 = new Robot();
			BufferedImage img = r2d2.createScreenCapture(new Rectangle(w,h));

			final CaptureFrame jf1 = new CaptureFrame(img);
			jf1.setTitle("Capture screen");

			
			/* ウィンドウ装飾を無効にする */
			jf1.setUndecorated(true);
			
			/* Aキーを押すとウィンドウが閉じるようにする */
			jf1.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent event) {
					switch (event.getKeyCode()) {
					case KeyEvent.VK_A:
						jf1.dispose();
						break;
					}
				}
			});
			
			/* フルスクリーンにするウィンドウを登録する */
			GraphicsEnvironment.getLocalGraphicsEnvironment()
			.getDefaultScreenDevice().setFullScreenWindow(jf1);
			
			/*jf1.setSize(HelloServlet.w,HelloServlet.h);
			jf1.setLocation(0, 0);*/
			

			jf1.setVisible(true);
			Toolkit.getDefaultToolkit().beep();
		} catch (Exception e) {
		}
	}

}