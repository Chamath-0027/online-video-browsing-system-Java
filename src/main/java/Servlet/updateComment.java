package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Comment;
import Service.CommentService;

/**
 * Servlet implementation class updateComment
 */
@WebServlet("/updateComment")
public class updateComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateComment() {
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

		Comment comment =  new Comment();

		comment.setId(Integer.parseInt(request.getParameter("id")));
		comment.setText(request.getParameter("text"));
		comment.setDate(request.getParameter("date"));
		comment.setUser_id(Integer.parseInt(request.getParameter("user_id")));
		comment.setVideo_id(Integer.parseInt(request.getParameter("video_id")));

		CommentService s = new CommentService();
		int res=s.editComment(comment);

		if(res==0) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/viewComment.jsp");
			request.setAttribute("errors_success", 0);
			dispatcher.forward(request, response);
		}else if(res==1) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/viewComment.jsp");
			request.setAttribute("errors_success", 1);
			dispatcher.forward(request, response);
		}
	}

}
