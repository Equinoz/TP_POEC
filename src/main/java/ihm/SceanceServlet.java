package ihm;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bll.SceanceManager;


/**
 * Servlet implementation class SceanceServlet
 */
@WebServlet("/SceanceServlet")
public class SceanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SceanceServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SceanceModel model = new SceanceModel();

		if(request.getParameter("param")!=null) { 
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(SceanceManager.allSFJSON());
			response.getWriter().flush();
			}else {
			model.setList(SceanceManager.allSF());
			model.setjSonListAllSceance(SceanceManager.allSFJSON());
			System.out.println(model.getList());
			request.setAttribute("model", model);
			request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);			
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
