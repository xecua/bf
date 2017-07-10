package jp.co.agilegroup.sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HelloServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Hello World.");
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
	    FreeCapture capture = new FreeCapture();
	    capture.doCapture();

	    JFrame frame=new JFrame("test");
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     frame.setSize(2310,1100);
	     frame.setVisible(true);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
