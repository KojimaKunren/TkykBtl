package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.EnemydataDAO;
import dao.SavedataDAO;
import dao.UserdataDAO;
import model.AttackPower;
import model.DeffencePower;
import model.Enemy;
import model.Hp;
import model.MaxHp;
import model.MaxMp;
import model.Mp;
import model.Player;
import model.Recovery;
import model.RegisterLogic;
import model.Status;
import model.User;

@WebServlet("/Register")
@MultipartConfig
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardPath = null;
		String action = request.getParameter("action");
		if(action == null) {
			forwardPath = "WEB-INF/view/userRegister.jsp";
		}else if(action.equals("done")) {
			HttpSession session = request.getSession();
			User registerUser = (User)session.getAttribute("registerUser");
			
			RegisterLogic logic = new RegisterLogic();
			logic.execute(registerUser);
			session.removeAttribute("registerUser");
			forwardPath = "WEB-INF/view/loginResult.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(forwardPath);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		final String name = request.getParameter("name");
		final String pass = request.getParameter("pass");
		
		//画像の登録
		Part part= request.getPart("pict");
		String pict=Paths.get(part.getSubmittedFileName()).getFileName().toString();
		String path=getServletContext().getRealPath("/upload");
		part.write(path+File.separator+pict);
		request.setAttribute("name", name);
		request.setAttribute("pass", pass);
		request.setAttribute("pict", pict);
		
		//プレイヤーの作成（基礎情報）
		final Hp hp = new Hp(30);
		final MaxHp MAXHP = new MaxHp(30);
		final Mp mp = new Mp(20);
		final MaxMp MAXMP = new MaxMp(20);
		final AttackPower atk = new AttackPower(15);
		final DeffencePower def = new DeffencePower(10);
		final Recovery recovery = new Recovery("Healing", 10, 10);
		
		User user = new User(name, pass, path);
		Status status = new Status(hp, MAXHP, mp, MAXMP, atk, def, recovery);
		UserdataDAO userdataDao = new UserdataDAO();
		SavedataDAO savedataDao = new SavedataDAO();
		
		//セッションスコープ
		HttpSession session = request.getSession();
		userdataDao.insertOne(user);
		session.setAttribute("loginUser", user);
		
		//ユーザーIDの取得
		userdataDao.findOne(1);
		User userId = userdataDao.findOne(name);
		int playerId = userId.getId();
		
		//プレイヤーの生成
		Player player = new Player(playerId, name, status);
		savedataDao.insertOne(player);
		session.setAttribute("player", player);
		
		//敵の生成
		Enemy enemy = new Enemy();
		EnemydataDAO enemydataDao = new EnemydataDAO();
		enemy = enemydataDao.findOne(1);
		session.setAttribute("enemy", enemy);
		
		//送信
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/loginResult.jsp");
		rd.forward(request, response);
	}

}
