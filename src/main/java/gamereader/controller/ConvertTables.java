package gamereader.controller;

import java.util.ArrayList;

import gamereader.model.Player;
import gamereader.model.Stats;


public class ConvertTables {
	
	public static void main (String[] args) {
		
		ArrayList<Player> players = new Player().findPlayer("wizards");
		
		ArrayList<Player> squad = new ArrayList<Player>();
		
		for (int contador = 0; contador <= (players.size() - 1); contador++) {
			 if (players.get(contador).getTeam().equals("wizards")) {
			 boolean existsName = false;
			 existsName = verifyName(players.get(contador).getName(), squad, existsName);
			 if (existsName == true) {
				   
			   } else {
				   Player playerStats = new Player();
				   playerStats.setPoints(players.get(contador).getPoints());
				   playerStats.setName(players.get(contador).getName());
				   playerStats.setAssists(players.get(contador).getAssists());
				   playerStats.setRebounds(players.get(contador).getRebounds());
				   playerStats.setThrees(players.get(contador).getThrees());
				   playerStats.setSteals(players.get(contador).getSteals());
				   playerStats.setBlocks(players.get(contador).getBlocks());
				   playerStats.setTurnovers(players.get(contador).getTurnovers());
				   playerStats.setTeam(players.get(contador).getTeam());
				   squad.add(playerStats);
			   }
			 }
		 }
		
		
		
		for (int contador = 0; contador <= (squad.size() - 1); contador++) {
			String points = "";
			String assists = "";
			String rebounds = "";
			String threes = "";
			String steals = "";
			String blocks = "";
			String turnovers = "";
			Stats stats = new Stats();
			stats.setName(squad.get(contador).getName());
			stats.setTeam(squad.get(contador).getTeam());
			for (int count = 0; count <= (players.size() - 1); count++) {
				if (squad.get(contador).getName().equals(players.get(count).getName())) {
					points = points + String.valueOf(players.get(count).getPoints() + ";");
					assists = assists + String.valueOf(players.get(count).getAssists() + ";");
					rebounds = rebounds + String.valueOf(players.get(count).getRebounds() + ";");
					threes = threes + String.valueOf(players.get(count).getThrees() + ";");
					steals = steals + String.valueOf(players.get(count).getSteals() + ";");
					blocks = blocks + String.valueOf(players.get(count).getBlocks() + ";");
					turnovers = turnovers + String.valueOf(players.get(count).getTurnovers() + ";");
				}				
			}
			stats.setPoints(points);
			stats.setAssists(assists);
			stats.setRebounds(rebounds);
			stats.setThrees(threes);
			stats.setSteals(steals);
			stats.setBlocks(blocks);
			stats.setTurnovers(turnovers);
			
			stats.salvar();
		}
		
		System.out.println(".");
		
		
	}
	
	public static boolean verifyName(String name, ArrayList<Player> players, boolean result) {
		 
		for (int contador = 0; contador <= (players.size() - 1); contador++) {
			if(players.get(contador).getName().equals(name)) {
				result = true;
			}			
		}
		return result;
		
	}

}
