package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegisterLogic;
import model.User;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String forwardPath = null;
		String action = request.getParameter("action");
		
		if(action == null) {
			forwardPath = "WEB-INF/view/regosterForm.jsp";
		}else if(action.equals("done")){
			HttpSession session = request.getSession();
			User registerUser = (User)session.getAttribute("registerUser");
			
			RegisterLogic logic = new RegisterLogic();
			logic.execute(registerUser);
			
			session.removeAttribute("registerUser");
			forwardPath = "WEB-INF/view/registerDone.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		request.setCharacterEncoding("#UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String pict = request.getParameter("pict");
		
		//念のためint化不要？
		int idActual = Integer.parseInt(id);
		
		User registerUser = new User(idActual, name, pass, pict);
		
		HttpSession session = request.getSession();
		session.setAttribute("registerUser", registerUser);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/registerConfirm.jsp");
		rd.forward(request, response);
	}

}
