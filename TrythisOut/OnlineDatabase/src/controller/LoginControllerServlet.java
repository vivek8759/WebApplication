package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.LoginBean;
import model.DAO;

@WebServlet("/LCS")
public class LoginControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String emailId = request.getParameter("emailId");
		String pwd = request.getParameter("pwd");
		
		/*System.out.println(emailId);
		System.out.println(pwd);
	*/	
		LoginBean obj = new LoginBean();
		obj.setEmailId(emailId);
		obj.setPassword(pwd);

		//System.out.println(obj.getEmailId());
		//System.out.println(obj.getPassword());
		
		DAO dao = new DAO();
		
		if(dao.authenticateUser(obj)) {
			HttpSession ses = request.getSession();
			ses.setAttribute("user1", emailId);
			response.sendRedirect("Home.jsp");
		}
		else {
			request.setAttribute("user2", "Either username or password is incorrect");
			request.getRequestDispatcher("LoginForm.jsp").include(request, response);
		}
		Connection conn = dao.returnConnection();
		try {
			if(conn != null) { 
				conn.close();
				conn = null;
			}
		} catch(SQLException sqe) {
			sqe.printStackTrace();
		}
		System.out.println(conn);
	}

}
