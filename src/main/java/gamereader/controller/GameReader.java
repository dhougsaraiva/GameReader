package gamereader.controller;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import gamereader.model.Player;

public class GameReader {
	
	
	public static void main (String[] args) throws IOException {
		String[]  urls = {															
				
				
				};
		
		for (int i = 0;i<urls.length;i++) {
			System.out.println(urls[i]);

			Document doc = Jsoup.connect(urls[i]).get();

			Element home = doc.getElementsByClass("table_container").first();

			Element tbody = home.getElementsByTag("tbody").first();

			List<Element> team = home.getElementsByTag("caption");

			String time = team.get(0).text();

			time = time.replace(" Basic and Advanced Stats Table", "");

			time = time.replaceAll(" ", "");

			String resultado = pickTeam(1, time);

			List<Element> players = tbody.getElementsByTag("tr");

			for (Element player : players) {

				if (!player.className().equals("thead")) {

					List<Element> attributes = player.getElementsByTag("td");

					if (!attributes.get(0).className().equals("center")) {
						Player dtPlayer = new Player();

						dtPlayer.setName(player.getElementsByTag("a").get(0).text());
						dtPlayer.setThrees(Integer.parseInt(attributes.get(4).text()));
						dtPlayer.setRebounds(Integer.parseInt(attributes.get(12).text()));
						dtPlayer.setAssists(Integer.parseInt(attributes.get(13).text()));
						dtPlayer.setSteals(Integer.parseInt(attributes.get(14).text()));
						dtPlayer.setBlocks(Integer.parseInt(attributes.get(15).text()));
						dtPlayer.setTurnovers(Integer.parseInt(attributes.get(16).text()));
						dtPlayer.setPoints(Integer.parseInt(attributes.get(18).text()));
						if (!resultado.equals("")) {
							dtPlayer.setTeam(resultado);
							dtPlayer.salvar();
						}

					}

				}

			}
			
			List<Element> teste2 = doc.getElementsByTag("h1");
			String visitante = teste2.get(0).text();
			visitante = visitante.replace(" ", "");
			visitante = visitante.replace(time + "at", "");
			String[] visitanteName = visitante.split("Box", 0);
			visitante = visitanteName[0].replaceAll(" ", "");

			String confronto = pickTeam(2, visitante);

			Element opponent = doc.getElementById("div_box-" + confronto + "-game-basic");

			List<Element> team2 = opponent.getElementsByTag("caption");

			String fora = team2.get(0).text();

			fora = fora.replace(" Basic and Advanced Stats Table", "");

			fora = fora.replaceAll(" ", "");

			String resultado2 = pickTeam(1, fora);

			Element tbodyO = opponent.getElementsByTag("tbody").first();

			List<Element> opponents = tbodyO.getElementsByTag("tr");
			
			for (Element player : opponents) {

				if (!player.className().equals("thead")) {

					List<Element> attributes = player.getElementsByTag("td");

					if (!attributes.get(0).className().equals("center")) {

						Player dtPlayer = new Player();

						dtPlayer.setName(player.getElementsByTag("a").get(0).text());
						dtPlayer.setThrees(Integer.parseInt(attributes.get(4).text()));
						dtPlayer.setRebounds(Integer.parseInt(attributes.get(12).text()));
						dtPlayer.setAssists(Integer.parseInt(attributes.get(13).text()));
						dtPlayer.setSteals(Integer.parseInt(attributes.get(14).text()));
						dtPlayer.setBlocks(Integer.parseInt(attributes.get(15).text()));
						dtPlayer.setTurnovers(Integer.parseInt(attributes.get(16).text()));
						dtPlayer.setPoints(Integer.parseInt(attributes.get(18).text()));
						if (!resultado2.equals("")) {
							dtPlayer.setTeam(resultado2);
							dtPlayer.salvar();
						}

					}

				}

			}
			
			System.out.println(resultado + " X " + resultado2 + " Adicionado");

	}
	
	}
	
	public static String pickTeam (int value, String team) {
		String retorno = "";
		if (team != null) {
			if(value == 1) {
				if (team.equals("AtlantaHawks")) {
					retorno = "hawks";
				} else if (team.equals("BostonCeltics")){
					retorno = "celtics";
				} else if (team.equals("BrooklynNets")){
					retorno = "nets";
				} else if (team.equals("NewYorkKnicks")){
					retorno = "knicks";
				} else if (team.equals("Philadelphia76ers")){
					retorno = "76ers";
				} else if (team.equals("TorontoRaptors")){
					retorno = "raptors";
				} else if (team.equals("ChicagoBulls")){
					retorno = "bulls";
				} else if (team.equals("ClevelandCavaliers")){
					retorno = "cavaliers";
				} else if (team.equals("DetroitPistons")){
					retorno = "pistons";
				} else if (team.equals("IndianaPacers")){
					retorno = "pacers";
				} else if (team.equals("MilwaukeeBucks")){
					retorno = "bucks";
				} else if (team.equals("CharlotteHornets")){
					retorno = "hornets";
				} else if (team.equals("MiamiHeat")){
					retorno = "heat";
				} else if (team.equals("OrlandoMagic")){
					retorno = "magic";
				} else if (team.equals("WashingtonWizards")){
					retorno = "wizards";
				} else if (team.equals("DenverNuggets")){
					retorno = "nuggets";
				} else if (team.equals("MinnesotaTimberwolves")){
					retorno = "timberwolves";
				} else if (team.equals("OklahomaCityThunder")){
					retorno = "thunder";
				} else if (team.equals("PortlandTrailBlazers")){
					retorno = "trailblazers";
				} else if (team.equals("UtahJazz")){
					retorno = "jazz";
				} else if (team.equals("GoldenStateWarriors")){
					retorno = "warriors";
				} else if (team.equals("LosAngelesClippers")){
					retorno = "clippers";
				} else if (team.equals("LosAngelesLakers")){
					retorno = "lakers";
				} else if (team.equals("PhoenixSuns")){
					retorno = "suns";
				} else if (team.equals("SacramentoKings")){
					retorno = "kings";
				} else if (team.equals("DallasMavericks")){
					retorno = "mavericks";
				} else if (team.equals("HoustonRockets")){
					retorno = "rockets";
				} else if (team.equals("MemphisGrizzlies")){
					retorno = "grizzlies";
				} else if (team.equals("NewOrleansPelicans")){
					retorno = "pelicans";
				} else if (team.equals("SanAntonioSpurs")){
					retorno = "spurs";
				}				
			} else if (value == 2) {
				if (team.equals("AtlantaHawks")) {
					retorno = "ATL";
				} else if (team.equals("BostonCeltics")){
					retorno = "BOS";
				} else if (team.equals("BrooklynNets")){
					retorno = "BRK";
				} else if (team.equals("NewYorkKnicks")){
					retorno = "NYK";
				} else if (team.equals("Philadelphia76ers")){
					retorno = "PHI";
				} else if (team.equals("TorontoRaptors")){
					retorno = "TOR";
				} else if (team.equals("ChicagoBulls")){
					retorno = "CHI";
				} else if (team.equals("ClevelandCavaliers")){
					retorno = "CLE";
				} else if (team.equals("DetroitPistons")){
					retorno = "DET";
				} else if (team.equals("IndianaPacers")){
					retorno = "IND";
				} else if (team.equals("MilwaukeeBucks")){
					retorno = "MIL";
				} else if (team.equals("CharlotteHornets")){
					retorno = "CHO";
				} else if (team.equals("MiamiHeat")){
					retorno = "MIA";
				} else if (team.equals("OrlandoMagic")){
					retorno = "ORL";
				} else if (team.equals("WashingtonWizards")){
					retorno = "WAS";
				} else if (team.equals("DenverNuggets")){
					retorno = "DEN";
				} else if (team.equals("MinnesotaTimberwolves")){
					retorno = "MIN";
				} else if (team.equals("OklahomaCityThunder")){
					retorno = "OKC";
				} else if (team.equals("PortlandTrailBlazers")){
					retorno = "POR";
				} else if (team.equals("UtahJazz")){
					retorno = "UTA";
				} else if (team.equals("GoldenStateWarriors")){
					retorno = "GSW";
				} else if (team.equals("LosAngelesClippers")){
					retorno = "LAC";
				} else if (team.equals("LosAngelesLakers")){
					retorno = "LAL";
				} else if (team.equals("PhoenixSuns")){
					retorno = "PHO";
				} else if (team.equals("SacramentoKings")){
					retorno = "SAC";
				} else if (team.equals("DallasMavericks")){
					retorno = "DAL";
				} else if (team.equals("HoustonRockets")){
					retorno = "HOU";
				} else if (team.equals("MemphisGrizzlies")){
					retorno = "MEM";
				} else if (team.equals("NewOrleansPelicans")){
					retorno = "NOP";
				} else if (team.equals("SanAntonioSpurs")){
					retorno = "SAS";
				}
				
			}
		}	
		
		return retorno;
		
	}
	
	


}


