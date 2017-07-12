package main;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import whiteScreen.FullScreen;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static int w;
	private static int h;
	
    public HelloServlet() {
        super();
    }

    static {
    	 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	 setW(screenSize.width);
    	 setH(screenSize.height);

    }
 

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	Robot rb;

    	FullScreen fs = new FullScreen();
		response.getWriter().append("警告");
		response.setContentType("text/html; charset=Shift_JIS");
        PrintWriter out =  response.getWriter();
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
	    try{rb = new Robot();
	    rb.setAutoDelay(100);
    	rb.keyPress(KeyEvent.VK_WINDOWS);
	    rb.delay(500);
	    rb.keyPress(KeyEvent.VK_D);
	    rb.delay(1000);
	    rb.keyRelease(KeyEvent.VK_D);
	    rb.keyRelease(KeyEvent.VK_WINDOWS);}
	    catch(AWTException e) {e.printStackTrace();}



	    /*FreeCapture capture = new FreeCapture();
	    capture.doCapture();*/


	   fs.fullScreen();
	    
	   	/* JFrame frame=new JFrame("test");
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	     frame.setSize(w,h);
	     frame.setVisible(true); */

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public static int getH() {
		return h;
	}
	public static void setH(int h) {
		HelloServlet.h = h;
	}
	public static int getW() {
		return w;
	}
	public static void setW(int w) {
		HelloServlet.w = w;
	}

}
