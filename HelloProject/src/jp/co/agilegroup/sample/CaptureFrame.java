package jp.co.agilegroup.sample;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class CaptureFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private CapturePanel jp1;
	private JScrollPane js1;

	public CaptureFrame(BufferedImage img) {
		super();
		jp1 = new CapturePanel(img);
		this.getContentPane().setLayout(new BorderLayout());
		js1 = new JScrollPane(jp1);
		this.getContentPane().add(js1, BorderLayout.CENTER);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				jp1.saveJPEG();
				System.exit(0);
			}
		});
	}

}