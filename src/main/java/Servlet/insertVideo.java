package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Video;
import Service.VideoService;

/**
 * Servlet implementation class insertVideo
 */
@WebServlet("/insertVideo")
public class insertVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertVideo() {
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

		Video video =  new Video();

		video.setTitle(request.getParameter("title"));
		video.setDate(request.getParameter("date"));
		video.setDescription(request.getParameter("description"));
		video.setDuration(Integer.parseInt(request.getParameter("duration")));
		video.setCategory_id(Integer.parseInt(request.getParameter("category_id")));

		VideoService s = new VideoService();
		int res=s.addVideo(video);

		if(res==0) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addVideo.jsp");
			request.setAttribute("errors_success", 0);
			dispatcher.forward(request, response);
		}else if(res==1) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addVideo.jsp");
			request.setAttribute("errors_success", 1);
			dispatcher.forward(request, response);
		}
	}

}
