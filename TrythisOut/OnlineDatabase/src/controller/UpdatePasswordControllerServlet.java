package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UpdatePasswordBean;
import model.DAO;

@WebServlet("/ChangePassword")
public class UpdatePasswordControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		HttpSession ses = request.getSession();
		
		String newPwd = request.getParameter("newPwd");
		String conNewPwd = request.getParameter("conNewPwd");
		String emailId = (String)ses.getAttribute("user1");
		if(newPwd.equals(conNewPwd)) {
			UpdatePasswordBean obj = new UpdatePasswordBean();
			obj.setNewPwd(newPwd);
			obj.setEmailId(emailId);
			
			DAO dao = new DAO();
			if(dao.changePassword(obj)) {
				response.sendRedirect("UpdatePasswordSuccess.jsp");
			}
			else {
				response.sendRedirect("UpdatePasswordFailure.jsp");
			}
		}
		else {
			request.setAttribute("errMsg", "New Password and Confirm New Password did not match");
			request.getRequestDispatcher("UpdatePassword.jsp").include(request, response);
		}
	}
}
