package gamereader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import gamereader.model.Stats;

public class StatsDao {
	
public void cadastrarPlayer(Stats player) {
		
		String sql = "INSERT INTO STATS VALUES (null,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pStatement = null;
		Connection conn = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, player.getName());
			pStatement.setString(2, player.getTeam());
			pStatement.setString(3, player.getPoints());
			pStatement.setString(4, player.getAssists());
			pStatement.setString(5, player.getRebounds());
			pStatement.setString(6, player.getThrees());
			pStatement.setString(7, player.getSteals());
			pStatement.setString(8, player.getBlocks());
			pStatement.setString(9, player.getTurnovers());

			
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

}
