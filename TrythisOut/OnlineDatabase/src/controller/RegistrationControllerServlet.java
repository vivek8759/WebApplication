package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.EmployeeBean;
import model.DAO;


@WebServlet("/RCS")
public class RegistrationControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		DAO dao = new DAO();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		double sal = Double.parseDouble(request.getParameter("sal"));
		
		EmployeeBean obj = new EmployeeBean();
		obj.setEmpNo(id);
		obj.setEmpName(name);
		obj.setEmpSal(sal);
		
		if(dao.registerEmployee(obj)) {
			request.setAttribute("user3", "Success . Record has successfully been added .");
			request.getRequestDispatcher("Home.jsp").include(request, response);
			}
		else {
			response.sendRedirect("RegFailure.jsp");
		}
		Connection conn = dao.returnConnection();
		if(conn != null) {
			try {
				conn.close();
			} catch(SQLException sqe) {
				sqe.printStackTrace();
			}
		}
	}

}
