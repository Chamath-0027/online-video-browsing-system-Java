package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Category;
import Service.CategoryService;

/**
 * Servlet implementation class updateCategory
 */
@WebServlet("/updateCategory")
public class updateCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateCategory() {
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
		response.setContentType("text/html");

		Category category =  new Category();

		category.setId(Integer.parseInt(request.getParameter("id")));
		category.setName(request.getParameter("name"));
		category.setDescription(request.getParameter("description"));

		CategoryService s = new CategoryService();
		int res=s.editCategory(category);

		if(res==0) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/viewCategory.jsp");
			request.setAttribute("errors_success", 0);
			dispatcher.forward(request, response);
		}else if(res==1) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/viewCategory.jsp");
			request.setAttribute("errors_success", 1);
			dispatcher.forward(request, response);
		}
	}

}
