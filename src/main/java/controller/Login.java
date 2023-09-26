package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SavedataDAO;
import dao.UserdataDAO;
import model.Player;
import model.User;

@WebServlet("/Login")
@MultipartConfig
public class Login extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/login.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");

		//名前、パスワードの受け取り
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		//リクエストスコープ
		request.setAttribute("name", name);
		request.setAttribute("pass", pass);
		HttpSession session = request.getSession();
		
		//ユーザーの呼び出し
		UserdataDAO userDao = new UserdataDAO();
//		List<User> userlist = userDao.findAll();
//		
//		for(User u : userlist){
//			if(u.getName().equals(name) && user.getPass().equals(pass)){
//				int id = u.getId();
//			}
//		}
				
		User user = userDao.findOne(name);
		int id = user.getId();
		
		SavedataDAO savedataDao = new SavedataDAO();
		Player player = new Player();
		player = savedataDao.findOne(id);
//		Player player = new Player(id, name, status);
		
		//セッションスコープ
		session.setAttribute("loginUser", user);
		session.setAttribute("player", player);

		//敵の生成
//		Enemy enemy = new Enemy();
//		EnemydataDAO enemydataDao = new EnemydataDAO();
//		enemy = enemydataDao.findOne("ENEMY1");
//		session.setAttribute("enemy", enemy);
		
		//送信
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/loginResult.jsp");
		rd.forward(request, response);
	}
}
