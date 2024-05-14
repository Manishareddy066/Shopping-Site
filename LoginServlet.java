
package mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	ShoppingDAO sd;

	public void init() {
		sd = new ServiceDAL();
	}
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("user");
        String password = req.getParameter("pwd");
        String isValid = sd.validateUser(username, password);
        res.setContentType("text/plain");
        PrintWriter pw = res.getWriter();
        pw.print(isValid);
    }
}
