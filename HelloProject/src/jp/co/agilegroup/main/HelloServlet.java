package main;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manyerror.ManyError;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static int w;
	private static int h;
	
	public HelloServlet() {
		super();
	}
	
	//ウィンドウサイズを取得
	static {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setW(screenSize.width);
		setH(screenSize.height);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

		ManyError.shutdown();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public static int getW() {
		return w;
	}

	public static void setW(int w) {
		HelloServlet.w = w;
	}

	public static int getH() {
		return h;
	}

	public static void setH(int h) {
		HelloServlet.h = h;
	}

}
