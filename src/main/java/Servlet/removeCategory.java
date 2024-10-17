package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.CategoryService;

/**
 * Servlet implementation class removeCategory
 */
@WebServlet("/removeCategory")
public class removeCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public removeCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryService service = new CategoryService();
		int res=service.deleteCategory(Integer.parseInt(request.getParameter("deleteId")));

		if(res==1) {
			request.setAttribute("errors_success", 1);
		}else {
			request.setAttribute("errors_success", 0);
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/viewCategory.jsp");
		dispatcher.forward(request, response);
	}

}
