package jp.co.agilegroup.sample;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@WebServlet("/HelloServlet")

public class HelloServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public HelloServlet()
	{
		super();
	}
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
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
			JFrame frame = new JFrame("message");
			frame.setVisible(true);
			frame.setBounds(180, 150, 1800, 200);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JPanel p = new JPanel();
			JLabel label = new JLabel("Windowsをシャットダウンします");
			p.add(label);
			Font f = new Font("Serif",Font.PLAIN,100);
			label.setFont(f);
			Container contentPane = frame.getContentPane();
		    contentPane.add(p, BorderLayout.CENTER);
		    class Shut extends TimerTask{
				public void run()
				{
				try
				{
					Robot rb;
					rb = new Robot();
					rb.keyPress(KeyEvent.VK_WINDOWS);
					rb.delay(30);
					rb.keyPress(KeyEvent.VK_X);
					rb.delay(10);
					rb.keyRelease(KeyEvent.VK_X);
					rb.keyRelease(KeyEvent.VK_WINDOWS);
					//
					rb.keyPress(KeyEvent.VK_U);
					rb.delay(10);
					rb.keyRelease(KeyEvent.VK_U);
					//
					rb.keyPress(KeyEvent.VK_U);
					rb.delay(10);
					rb.keyRelease(KeyEvent.VK_U);
				}
				catch (AWTException e)
				{
					e.printStackTrace();
				}
			}
			}
		    Shut task = new Shut();
			Timer timer = new Timer();
			timer.schedule(task,5000);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}
