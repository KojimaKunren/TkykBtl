package dao;

import java.sql.SQLException;

import javax.naming.NamingException;

import model.AttackPower;
import model.DeffencePower;
import model.Hp;
import model.MaxHp;
import model.MaxMp;
import model.Mp;
import model.Player;
import model.Recovery;
import model.Status;

public class SavedataDAO extends DAO{
	
	public Status findOne(int id) {
		Status status = null;
		Recovery recovery = null;
		try {
			this.connect();
			stmt = con.prepareStatement("SELECT * FROM savedata WHERE id=?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			recovery = new Recovery(rs.getString("recoveryname"), rs.getInt("recovery"), rs.getInt("recoverycost"));
			status = new Status(new Hp(rs.getInt("hp")), new MaxHp(rs.getInt("maxhp")), new Mp(rs.getInt("mp")), new MaxMp(rs.getInt("maxmp")),
					new AttackPower(rs.getInt("atk")), new DeffencePower(rs.getInt("def")), recovery);
		}catch(NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return status;
	}
	
	public void insertOne(Player player) {
	try {
	this.connect();
	stmt=con.prepareStatement("INSERT INTO savedata (id,hp,maxhp,mp,maxmp,atk,def,recoveryname,recovery,recoverycost) "
			+ "VALUES(?,?,?,?,?,?,?,?,?,?)" );
	stmt.setInt(1, player.getId());
	stmt.setInt(2, player.getStatus().getHp().getHp());
	stmt.setInt(3, player.getStatus().getMaxHp().getHp());
	stmt.setInt(4, player.getStatus().getMp().getMp());
	stmt.setInt(5, player.getStatus().getMaxMp().getMp());
	stmt.setInt(6, player.getStatus().getAtk().getAtk());
	stmt.setInt(7, player.getStatus().getDef().getDef());
	stmt.setString(8, player.getStatus().getRecovery().getName());
	stmt.setInt(9, player.getStatus().getRecovery().getRecovery());
	stmt.setInt(10, player.getStatus().getRecovery().getRecoveryCost());
	stmt.execute();
	}catch(NamingException | SQLException e) {
		e.printStackTrace();
	}finally {
		this.disconnect();
	}
	}
}