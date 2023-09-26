package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import model.AttackPower;
import model.DeffencePower;
import model.Enemy;
import model.Hp;
import model.MaxHp;
import model.MaxMp;
import model.Mp;
import model.Recovery;
import model.Status;

public class EnemydataDAO extends DAO{
	public List<Enemy> findAll(){
		List<Enemy> list = new ArrayList<>();
		try {
			this.connect();
			stmt = con.prepareStatement("SELECT * FROM enemydata");
			rs = stmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int hp =rs.getInt("hp");
				int maxhp = rs.getInt("maxhp");
				int mp = rs.getInt("mp");
				int maxmp = rs.getInt("maxmp");
				int atk = rs.getInt("atk");
				int def = rs.getInt("def");
				String recoveryName = rs.getString("recoveryname");
				int recovery = rs.getInt("recovery");
				int recoveryCost = rs.getInt("recoverycost");
				Status enemyStatus = new Status(new Hp(hp), new MaxHp(maxhp), new Mp(mp), new MaxMp(maxmp), new AttackPower(atk), new DeffencePower(def), new Recovery(recoveryName,recovery,recoveryCost));
				Enemy enemy = new Enemy(name, id, enemyStatus);
				list.add(enemy);
			}
		}catch(NamingException | SQLException e) {
			System.out.println("Connection failed");
		}finally {
			super.disconnect();
		}
		return list;
	}
	
	public Enemy findOne(int id) {
		Enemy enemy = null;
		try {
			this.connect();
			stmt = con.prepareStatement("SELECT * FROM enemydata WHERE id=?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				String name = rs.getString("name");
				Recovery recovery = new Recovery(rs.getString("recoveryname"), rs.getInt("recovery"), rs.getInt("recoverycost"));
				Status enemyStatus = new Status(new Hp(rs.getInt("hp")), new MaxHp(rs.getInt("maxhp")), new Mp(rs.getInt("mp")), new MaxMp(rs.getInt("maxmp")),
						new AttackPower(rs.getInt("atk")), new DeffencePower(rs.getInt("def")), recovery);
				enemy = new Enemy(name, id, enemyStatus);
			}
		}catch(NamingException | SQLException e) {
			System.out.println("Connection failed");
		}finally {
			this.disconnect();
		}
		return	enemy;
	}
	
	public Enemy findOne(String name) {
		Enemy enemy = null;
		try {
			this.connect();
			stmt = con.prepareStatement("SELECT * FROM enemydata WHERE name=?");
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("id");
				Recovery recovery = new Recovery(rs.getString("recoveryname"), rs.getInt("recovery"), rs.getInt("recoverycost"));
				Status enemyStatus = new Status(new Hp(rs.getInt("hp")), new MaxHp(rs.getInt("maxhp")), new Mp(rs.getInt("mp")), new MaxMp(rs.getInt("maxmp")),
						new AttackPower(rs.getInt("atk")), new DeffencePower(rs.getInt("def")), recovery);
				enemy = new Enemy(name, id, enemyStatus);
			}
		}catch(NamingException | SQLException e) {
			System.out.println("Connection failed");
		}finally {
			this.disconnect();
		}
		return	enemy;
	}
	
	public void insertOne(Enemy enemy) {
		try {
			this.connect();
			stmt = con.prepareStatement("INSERT INTO userdadta(name, hp, maxhp, mp, maxmp, atk, def, recoveryname, recovery, recoverycost) "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, enemy.getName());
			stmt.setInt(2, enemy.getStatus().getHp().getHp());
			stmt.setInt(3, enemy.getStatus().getMaxHp().getHp());
			stmt.setInt(4, enemy.getStatus().getMp().getMp());
			stmt.setInt(5, enemy.getStatus().getMaxMp().getMp());
			stmt.setInt(6, enemy.getStatus().getAtk().getAtk());
			stmt.setInt(7, enemy.getStatus().getDef().getDef());
			stmt.setString(8, enemy.getStatus().getRecovery().getName());
			stmt.setInt(9, enemy.getStatus().getRecovery().getRecovery());
			stmt.setInt(10, enemy.getStatus().getRecovery().getRecoveryCost());
			stmt.execute();
		}catch(NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			super.disconnect();
		}
	}
	
	//Update要修正
	public void updateOne(Enemy enemy) {
		try {
			this.connect();
			stmt = con.prepareStatement("UPDATE userdata SET name=?, pass=?, pict=? WHERE id=?");
			stmt.setString(1, enemy.getName());
			stmt.setInt(2, enemy.getStatus().getHp().getHp());
			stmt.setInt(3, enemy.getStatus().getMaxHp().getHp());
			stmt.setInt(4, enemy.getId());
			stmt.execute();
		}catch(NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			super.disconnect();
		}
	}
}
