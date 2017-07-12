package whiteScreen;

import java.awt.GraphicsEnvironment;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import main.HelloServlet;
import screenShot.FreeCapture;

public class FullScreen {

	/**
	08:  * フルスクリーンウィンドウを表示するクラス．
	09:  * @author moware
	10:  * @version 1.0
	11:  */
	
	private static JFrame frame;
	
	   public void fullScreen() {
		/**
		 *全画面表示用メソッド
	    * @param args 実行引数
	    */
		
		frame = new JFrame();
			
		/* サイズの設定 */
		frame.setSize(HelloServlet.getW(),HelloServlet.getH());
			
		/* ウィンドウ装飾を無効にする */
		frame.setUndecorated(true);
		
		/* 閉じたときの挙動を設定 */
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* Escキーを押すとウィンドウが閉じるようにする */
		frame.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent event) {
				switch (event.getKeyCode()) {
				case KeyEvent.VK_ESCAPE:
					frame.dispose();
					
					FreeCapture fc = new FreeCapture();
					fc.doCapture();
					break;
				}
			}
		});
		
		/* フルスクリーンにするウィンドウを登録する */
		GraphicsEnvironment.getLocalGraphicsEnvironment()
		.getDefaultScreenDevice().setFullScreenWindow(frame);
		
		/* ウィンドウを表示 */
		frame.setVisible(true);

		}

	
}
