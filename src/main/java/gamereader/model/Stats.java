package gamereader.model;

import gamereader.dao.StatsDao;

public class Stats {

	private int id;
	private String name;
	private String team;
	private String points;
	private String assists;
	private String rebounds;
	private String threes;
	private String steals;
	private String blocks;
	private String turnovers;
	
	
	public Stats(int id, String name, String team, String points, String assists, String rebounds, String threes,
			String steals, String blocks, String turnovers) {
		super();
		this.id = id;
		this.name = name;
		this.team = team;
		this.points = points;
		this.assists = assists;
		this.rebounds = rebounds;
		this.threes = threes;
		this.steals = steals;
		this.blocks = blocks;
		this.turnovers = turnovers;
	}
	
	
	public Stats() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getPoints() {
		return points;
	}
	public void setPoints(String points) {
		this.points = points;
	}
	public String getAssists() {
		return assists;
	}
	public void setAssists(String assists) {
		this.assists = assists;
	}
	public String getRebounds() {
		return rebounds;
	}
	public void setRebounds(String rebounds) {
		this.rebounds = rebounds;
	}
	public String getThrees() {
		return threes;
	}
	public void setThrees(String threes) {
		this.threes = threes;
	}
	public String getSteals() {
		return steals;
	}
	public void setSteals(String steals) {
		this.steals = steals;
	}
	public String getBlocks() {
		return blocks;
	}
	public void setBlocks(String blocks) {
		this.blocks = blocks;
	}
	public String getTurnovers() {
		return turnovers;
	}
	public void setTurnovers(String turnovers) {
		this.turnovers = turnovers;
	}
	
	public void salvar() {
		new StatsDao().cadastrarPlayer(this);
	}
}
