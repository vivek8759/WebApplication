package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;

@WebServlet("/ViewEmpDtlsReport")
public class FetchEmpRecordsControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		DAO dao = new DAO();
		ResultSet rs = dao.getEmployeeDetails();
		
		
		if(rs!=null) {
			try {
	
				if(rs.next()) {
					System.out.println("Under");
					request.setAttribute("UserRecords",rs);
					request.getRequestDispatcher("ShowUserDetails.jsp").forward(request, response);
				} 
				else {
					request.setAttribute("msg", "No Records Found");
					request.getRequestDispatcher("FetchEmployeeRecords.jsp").include(request, response);
				}
			} catch(SQLException sqe) {
				sqe.printStackTrace();
			}
		}
		else {
			out.print("NO REPORT TO SHOW");
		}
	}
}
