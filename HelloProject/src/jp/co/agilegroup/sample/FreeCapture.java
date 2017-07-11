package jp.co.agilegroup.sample;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class FreeCapture {

	public static void main(String[] args) {
		FreeCapture fc1 = new FreeCapture();
		fc1.doCapture();
	}

	public void doCapture() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		try {
			Robot r2d2 = new Robot();
			BufferedImage img = r2d2.createScreenCapture(new Rectangle(screenSize));

			CaptureFrame jf1 = new CaptureFrame(img);
			jf1.setTitle("Capture screen");
			jf1.setSize(HelloServlet.w,HelloServlet.h);
			jf1.setLocation(50, 50);
			jf1.setVisible(true);
			Toolkit.getDefaultToolkit().beep();
		} catch (Exception e) {
		}
	}

}