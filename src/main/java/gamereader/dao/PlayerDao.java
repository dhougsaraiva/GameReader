package gamereader.dao;

import java.sql.*;
import java.util.ArrayList;

import gamereader.model.Player;


public class PlayerDao {
	
	public void cadastrarPlayer(Player player) {
		
		String sql = "INSERT INTO SEASON2425 VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pStatement = null;
		Connection conn = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, player.getName());
			pStatement.setInt(2, player.getMinutes());
			pStatement.setInt(3, player.getPoints());
			pStatement.setInt(4, player.getAssists());
			pStatement.setInt(5, player.getRebounds());
			pStatement.setInt(6, player.getThrees());
			pStatement.setInt(7, player.getSteals());
			pStatement.setInt(8, player.getBlocks());
			pStatement.setInt(9, player.getTurnovers());
			pStatement.setInt(10, player.getPointsAssistsRebounds());
			pStatement.setInt(11, player.getPointsAssists());
			pStatement.setInt(12, player.getPointsRebounds());
			pStatement.setInt(13, player.getAssistsRebounds());
			pStatement.setInt(14, player.getStealsBlocks());
			pStatement.setBoolean(15, player.isDoubledouble());
			pStatement.setBoolean(16, player.isTripledouble());
			pStatement.setString(17, player.getTeam());
			
			pStatement.execute();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStatement!= null)
					pStatement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				if(conn!=null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public ArrayList<Player> findPlayer(String team){
		String sql = "SELECT * FROM SEASON2425 WHERE team LIKE '%" + team + "%'";
		PreparedStatement pStatement = null;
		Connection conn = null;
		ResultSet rs = null;
		Player player = null;
		ArrayList<Player> players = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();
			if (rs != null) {
				players = new ArrayList<Player>();
				while(rs.next()) {
					player = new Player();
					player.setName(rs.getString("name"));
					player.setPoints(rs.getInt("points"));
					player.setAssists(rs.getInt("assists"));
					player.setRebounds(rs.getInt("rebounds"));
					player.setThrees(rs.getInt("threes"));
					player.setSteals(rs.getInt("steals"));
					player.setBlocks(rs.getInt("blocks"));
					player.setTurnovers(rs.getInt("turnovers"));
					player.setTeam(rs.getString("team"));
					
					
					players.add(player);
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStatement!= null)
					pStatement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				if(conn!=null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}	
		
		
		
		return players;
	}

}
