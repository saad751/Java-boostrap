import java.io.IOException;


import java.io.PrintWriter;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.javatpoint.beans.AccountantBean;
import com.javatpoint.beans.StudentBean;
import com.javatpoint.dao.AccountantDao;
import com.javatpoint.dao.StudentDao;

@WebServlet("/AddAccountant")
public class AddAccountant extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Accountant Added</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		

		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navadmin.html").include(request, response);
		out.println("<div class='container'>");
		
		String name=request.getParameter("name");
	 	String email=request.getParameter("email");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		String contact=request.getParameter("contact");
		
		AccountantBean bean=new AccountantBean(name, email, password, address, contact);
		int status=AccountantDao.save(bean);
		out.println("<body>");
		out.println("<div class='container'>");
        out.println("<div class='row justify-content-center'>");
        out.println("<div class='col-md-6'>");
        out.println("<div class='card'>");
        out.println("<div class='card-body'>");
        out.println("<h5 class='card-title text-center mb-4' style='font-size: 2rem;'>Accountant Added Successfully</h5>");
        out.println("<div class='text-center'>");
        out.println("<p class='text-success' style='font-size: 1.5rem;'>The accountant has been added successfully.</p>");
        out.println("<a href='/fees/AddAccountantForm.html' class='btn btn-primary'>Add Another Accountant</a>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
		out.println("</div>");
		out.println("</body>");
	
        // Include the footer file
        request.getRequestDispatcher("footer.html").include(request, response);
        
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

}
