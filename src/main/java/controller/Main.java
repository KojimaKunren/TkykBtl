package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AttackPower;
import model.BattleLogic;
import model.DeffencePower;
import model.Enemy;
import model.Hp;
import model.MaxHp;
import model.MaxMp;
import model.Mp;
import model.Player;
import model.Recovery;
import model.Status;
import model.User;

@WebServlet("/Main")
public class Main extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		HttpSession session = request.getSession();
		User loginUser= (User)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			response.sendRedirect("login.jsp");
		}else {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/main.jsp");
		rd.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		Status playerStatus = new Status(new Hp(30), new MaxHp(30), new Mp(20), new MaxMp(20), new AttackPower(10), new DeffencePower(10), new Recovery("Rec",10,5));
		Status enemyStatus = new Status(new Hp(30),  new MaxHp(30), new Mp(0), new MaxMp(0), new AttackPower(7), new DeffencePower(5), new Recovery("Rec",0,0));
		
		Player player = new Player("aaa", playerStatus);
		Enemy enemy = new Enemy("bbb", enemyStatus);
		
		int select = Integer.parseInt(request.getParameter("select"));
		
		BattleLogic battle = new BattleLogic();
		battle.battle(player, enemy, select);
		}
	
}
