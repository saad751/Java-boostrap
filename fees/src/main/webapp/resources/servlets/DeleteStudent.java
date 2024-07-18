import java.io.IOException;

import java.io.PrintWriter;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.javatpoint.dao.StudentDao;
@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String srollno=request.getParameter("rollno");
		int rollno=Integer.parseInt(srollno);
		StudentDao.delete(rollno);
		response.sendRedirect("ViewStudent");
	}
}
