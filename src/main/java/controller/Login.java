package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EnemydataDAO;
import dao.SavedataDAO;
import dao.UserdataDAO;
import model.Enemy;
import model.Player;
import model.Status;
import model.User;

@WebServlet("/Login")
@MultipartConfig
public class Login extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/loginResult.jsp");
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
		
		//レスポンス指示
		int id= 0;
		
		//ユーザーの呼び出し
		UserdataDAO userDao = new UserdataDAO();
		List<User> userlist = userDao.findAll();
		
		for(User user : userlist){
			if(user.getName().equals(name) && user.getPass().equals(pass)){
				id = user.getId();
			}
		}
		
		SavedataDAO savedataDao = new SavedataDAO();
		Status status = savedataDao.findOne(id);
		Player player = new Player(id, name, status);
		
		//セッションスコープ
		HttpSession session = request.getSession();
		session.setAttribute("player", player);
		
		//敵の生成
		Enemy enemy = new Enemy();
		EnemydataDAO enemydataDao = new EnemydataDAO();
		enemy = enemydataDao.findOne(1);
		session.setAttribute("enemy", enemy);
		
		//送信
		RequestDispatcher rd = request.getRequestDispatcher("/loginResult.jsp");
		rd.forward(request, response);
	}
}
