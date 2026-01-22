package gamereader.model;

import java.util.ArrayList;

import gamereader.dao.PlayerDao;

public class Player {
	
	private int idPlayer;
	private String name;
	private int points;
	private int assists;
	private int rebounds;
	private int minutes;
	private int threes;
	private int steals;
	private int blocks;
	private int turnovers;
	private int pointsAssistsRebounds;
	private int pointsAssists;
	private int pointsRebounds;
	private int assistsRebounds;
	private int stealsBlocks;
	private boolean doubledouble;
	private boolean tripledouble;
	private String team;
	
	public Player(int idPlayer, String name, int points, int assists, int rebounds, int minutes, int threes, int steals,
			int blocks, int turnovers, int pointsAssistsRebounds, int pointsAssists, int pointsRebounds,
			int assistsRebounds, int stealsBlocks, boolean doubledouble, boolean tripledouble, String team) {
		super();
		this.idPlayer = idPlayer;
		this.name = name;
		this.points = points;
		this.assists = assists;
		this.rebounds = rebounds;
		this.minutes = minutes;
		this.threes = threes;
		this.steals = steals;
		this.blocks = blocks;
		this.turnovers = turnovers;
		this.pointsAssistsRebounds = pointsAssistsRebounds;
		this.pointsAssists = pointsAssists;
		this.pointsRebounds = pointsRebounds;
		this.assistsRebounds = assistsRebounds;
		this.stealsBlocks = stealsBlocks;
		this.doubledouble = doubledouble;
		this.tripledouble = tripledouble;
		this.team = team;
	}

	public Player() {
		
	}

	public int getIdPlayer() {
		return idPlayer;
	}

	public void setIdPlayer(int idPlayer) {
		this.idPlayer = idPlayer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getRebounds() {
		return rebounds;
	}

	public void setRebounds(int rebounds) {
		this.rebounds = rebounds;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getThrees() {
		return threes;
	}

	public void setThrees(int threes) {
		this.threes = threes;
	}

	public int getSteals() {
		return steals;
	}

	public void setSteals(int steals) {
		this.steals = steals;
	}

	public int getBlocks() {
		return blocks;
	}

	public void setBlocks(int blocks) {
		this.blocks = blocks;
	}

	public int getTurnovers() {
		return turnovers;
	}

	public void setTurnovers(int turnovers) {
		this.turnovers = turnovers;
	}

	public int getPointsAssistsRebounds() {
		return pointsAssistsRebounds;
	}

	public void setPointsAssistsRebounds(int pointsAssistsRebounds) {
		this.pointsAssistsRebounds = pointsAssistsRebounds;
	}

	public int getPointsAssists() {
		return pointsAssists;
	}

	public void setPointsAssists(int pointsAssists) {
		this.pointsAssists = pointsAssists;
	}

	public int getPointsRebounds() {
		return pointsRebounds;
	}

	public void setPointsRebounds(int pointsRebounds) {
		this.pointsRebounds = pointsRebounds;
	}

	public int getAssistsRebounds() {
		return assistsRebounds;
	}

	public void setAssistsRebounds(int assistsRebounds) {
		this.assistsRebounds = assistsRebounds;
	}

	public int getStealsBlocks() {
		return stealsBlocks;
	}

	public void setStealsBlocks(int stealsBlocks) {
		this.stealsBlocks = stealsBlocks;
	}

	public boolean isDoubledouble() {
		return doubledouble;
	}

	public void setDoubledouble(boolean doubledouble) {
		this.doubledouble = doubledouble;
	}

	public boolean isTripledouble() {
		return tripledouble;
	}

	public void setTripledouble(boolean tripledouble) {
		this.tripledouble = tripledouble;
	}
	
	public void salvar() {
		new PlayerDao().cadastrarPlayer(this);
	}
	
	public ArrayList<Player> findPlayer(String team){
		return new PlayerDao().findPlayer(team);
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
}