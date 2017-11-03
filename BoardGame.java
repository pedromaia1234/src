
public class BoardGame {

	private int xmap;
	private int ymap;
	private int ybandeira1, xbandeira1;
	private int ybandeira2, xbandeira2;
	private String team1, team2;
	private Soldier knight1;
	private Soldier knight2;
	private Soldier swordman1;
	private Soldier swordman2;
	private Soldier lancer1;
	private Soldier lancer2;
	private boolean jogoacaba;
	private int COUNTERMENU;
	
	public int returncounter () {
		return COUNTERMENU;
		
	}
	
	public void incCOUNTER() {
		COUNTERMENU++;
	}
	
	public void setCounter(int counter) {
		
		COUNTERMENU=counter;
	}

	public BoardGame(int xmap, int ymap, String team1, String team2, int xbandeira1, int ybandeira1, int xbandeira2,int ybandeira2) {
		this.xmap = xmap;
		this.ymap = ymap;
		knight1 = new Soldier(xbandeira1, ybandeira1 + 1, 1, team1);
		swordman1 = new Soldier(xbandeira1 + 1, ybandeira1, 2, team1);
		lancer1 = new Soldier(xbandeira1, ybandeira1 - 1, 3, team1);
		knight2 = new Soldier(xbandeira2, ybandeira2 + 1, 1, team2);
		swordman2 = new Soldier(xbandeira2 + 1, ybandeira2, 2, team2);
		lancer2 = new Soldier(xbandeira2, ybandeira2 - 1, 3, team2);
		COUNTERMENU=1;
		this.team1 = team1;
		this.team2 = team2;
		setflag1(xbandeira1, ybandeira1);
		setflag2(xbandeira2, ybandeira2);
		jogoacaba = false;

	}
	
	public BoardGame() {
		COUNTERMENU=0;
	}

	private Soldier colidecomjogador(int x, int y) {
		Soldier possibleSoldier = null;
		if (knight1.getxSol() == x && knight1.getySol() == y) {
			possibleSoldier = knight1;
		} else if (knight2.getxSol() == x && knight2.getySol() == y) {
			possibleSoldier = knight2;
		} else if (swordman1.getxSol() == x && swordman1.getySol() == y) {
			possibleSoldier = swordman1;
		} else if (swordman2.getxSol() == x && swordman2.getySol() == y) {
			possibleSoldier = swordman2;
		} else if (lancer1.getxSol() == x && lancer1.getySol() == y) {
			possibleSoldier = lancer1;
		} else if (lancer2.getxSol() == x && lancer2.getySol() == y) {
			possibleSoldier = lancer2;
		}
		return possibleSoldier;
	}


	public String Walk(Soldier b, String direct) {
		String result = "";
		if  (COUNTERMENU>0) {
		int x = b.getxSol();
		int y = b.getySol();
		x = b.getxSol();
		y = b.getySol();
		switch (direct) {

		case Soldier.NORTE:
			y += 1;
			break;
		case Soldier.SUL:
			y -= 1;
			break;
		case Soldier.OESTE:
			x -= 1;
			break;
		case Soldier.ESTE:
			x += 1;
			break;
		}
        
		b.Walk(direct);

		
		boolean doesColideWithFlag2 = team1coolidecombandeira2(b);
		boolean doesColideWithFlag1 = team2coolidecombandeira1(b);
		boolean cavaleiro1ColideWithFlag1 = cavaleiro1coolidecombandeira1(b, direct);
		boolean cavaleiro2ColideWithFlag2 = cavaleiro2coolidecombandeira2(b, direct);
		boolean lancer1coolidecombandeira1=lancer1coolidecombandeira1(b,direct);
		boolean lancer2coolidecombandeira2=lancer2coolidecombandeira2(b,direct);
		boolean espadachim1coolidecombandeira1=espadachim1coolidecombandeira1(b,direct);
		boolean espadachim2coolidecombandeira2=espadachim2coolidecombandeira2(b,direct);
		boolean cavaleiro1morto = cavaleiro1Morto(b);
		boolean cavaleiro2morto = cavaleiro2Morto(b);
		boolean espadachim1Morto = espadachim1Morto(b);
		boolean espadachim2Morto = espadachim2Morto(b);
		boolean lancer1morto = lancer1Morto(b);
		boolean lancer2morto = lancer2Morto(b);
		boolean cavaleiro1colidecomlancer1=cavaleiro1colidecomlancer1(b,direct);
		boolean cavaleiro1colidecomespadachim1=cavaleiro1colidecomespadachim1(b,direct);
		boolean lancer1colidecomcavaleiro1=lancer1colidecomcavaleiro1(b,direct);
		boolean lancer1colidecomespadachim1=lancer1colidecomespadachim1(b,direct);
		boolean espadachim1colidecomcavaleiro1=espadachim1colidecomcavaleiro1(b,direct);
		boolean espadachim1colidecomlancer1=espadachim1colidecomlancer1(b,direct);
		boolean cavaleiro2colidecomlancer2=cavaleiro2colidecomlancer2(b,direct);
		boolean cavaleiro2colidecomespadachim2=cavaleiro2colidecomespadachim2(b,direct);
		boolean lancer2colidecomcavaleiro2=lancer2colidecomcavaleiro2(b,direct);
		boolean lancer2colidecomespadachim2=lancer2colidecomespadachim2(b,direct);
		boolean espadachim2colidecomcavaleiro2=espadachim2colidecomcavaleiro2(b,direct);
		boolean espadachim2colidecomlancer2=espadachim2colidecomlancer2(b,direct);
		boolean cavaleiro1vslancer2 = cavaleiro1vslancer2(b);
		boolean cavaleiro1vscavaleiro2 = cavaleiro1vscavaleiror2(b);
		boolean cavaleiro1vsespadachim2 = cavaleiro1vsespadachim2(b);
		boolean cavaleiro2vslancer1 = cavaleiro2vslancer1(b);
		boolean cavaleiro2vscavaleiror1 = cavaleiro2vscavaleiror1(b);
		boolean cavaleiro2vsespadachim1 = cavaleiro2vsespadachim1(b);
		boolean lanceiro1vslancer2 = lanceiro1vslancer2(b);
		boolean lanceiro1vscavaleiror2 = lanceiro1vscavaleiror2(b);
		boolean lanceiro1vsespadachim2 = lanceiro1vsespadachim2(b);
		boolean lanceiro2vslancer1 = lanceiro2vslancer1(b);
		boolean lanceiro2vscavaleiror1 = lanceiro2vscavaleiror1(b);
		boolean lanceiro2vsespadachim1 = lanceiro2vsespadachim1(b);
		boolean espadachim1vslancer2 = espadachim1vslancer2(b);
		boolean espadachim1vscavaleiror2 = espadachim1vscavaleiror2(b);
		boolean espadachim1vsespadachim2 = espadachim1vsespadachim2(b);
		boolean espadachim2vslancer1 = espadachim2vslancer1(b);
		boolean espadachim2vscavaleiror1 = espadachim2vscavaleiror1(b);
		boolean espadachim2vsespadachim1 = espadachim2vsespadachim1(b);
		boolean cavaleiro1passamapa = cavaleiro1passamapa(b, direct);
		boolean cavaleiro2passamapa = cavaleiro2passamapa(b, direct);
		boolean lanceiro1passamapa = lanceiro1passamapa(b, direct);
		boolean lanceiro2passamapa = lanceiro2passamapa(b, direct);
		boolean espadachim1passamapa = espadachim1passamapa(b, direct);
		boolean espadachim2passamapa = espadachim2passamapa(b, direct);
		boolean equipa1morta = equipa1morta(b);
		boolean equipa2morta = equipa2morta(b);

		
		if (cavaleiro1colidecomlancer1) {
			
			result = "O cavaleiro da ilustre casa de " + b.getTeam() + " devia tentar ir para outro sitio.";
		}
		
		if(cavaleiro1colidecomespadachim1) {
			
			result = "O cavaleiro da ilustre casa de " + b.getTeam() + " devia tentar ir para outro sitio.";
		}
		
		if (lancer1colidecomcavaleiro1) {
			
			result = "O lanceiro da ilustre casa de " + b.getTeam() + " devia tentar ir para outro sitio.";
		}
		
		if (lancer1colidecomespadachim1) {
			
			result = "O lanceiro da ilustre casa de " + b.getTeam() + " devia tentar ir para outro sitio.";
		}
		
		if (espadachim1colidecomcavaleiro1) {
			
			result = "O espadachim da ilustre casa de " + b.getTeam() + " devia tentar ir para outro sitio.";
		}
		
		if (espadachim1colidecomlancer1) {
			
			result = "O espadachim da ilustre casa de " + b.getTeam() + " devia tentar ir para outro sitio.";
		}
		
		if (cavaleiro2colidecomlancer2) {
			
			result = "O cavaleiro da ilustre casa de " + b.getTeam() + " devia tentar ir para outro sitio.";
		}
		
		if(cavaleiro2colidecomespadachim2) {
			
			result = "O cavaleiro da ilustre casa de " + b.getTeam() + " devia tentar ir para outro sitio.";
		}
		
		if (lancer2colidecomcavaleiro2) {
			
			result = "O lanceiro da ilustre casa de " + b.getTeam() + " devia tentar ir para outro sitio.";
		}
		
		if (lancer2colidecomespadachim2) {
			
			result = "O lanceiro da ilustre casa de " + b.getTeam() + " devia tentar ir para outro sitio.";
		}
		
		if (espadachim2colidecomcavaleiro2) {
			
			result = "O espadachim da ilustre casa de " + b.getTeam() + " devia tentar ir para outro sitio.";
		}
		
		if (espadachim2colidecomlancer2) {
			
			result = "O espadachim da ilustre casa de " + b.getTeam() + " devia tentar ir para outro sitio.";
		}
		
		if (cavaleiro1ColideWithFlag1) {
			result = "O cavaleiro da ilustre casa de " + b.getTeam() + " devia tentar ir para outro sitio.";
		}
		
		if (lancer1coolidecombandeira1) {
			result = "O lanceiro da ilustre casa de " + b.getTeam() + " devia tentar ir para outro sitio.";
		}
		
		if (lancer2coolidecombandeira2) {
			result = "O lanceiro da ilustre casa de " + b.getTeam() + " devia tentar ir para outro sitio.";
		}
		
		if (espadachim1coolidecombandeira1) {
			result = "O espadachim da ilustre casa de " + b.getTeam() + " devia tentar ir para outro sitio.";
		}
		if (espadachim2coolidecombandeira2) {
			result = "O espadachim da ilustre casa de " + b.getTeam() + " devia tentar ir para outro sitio.";
		}
		

		if (cavaleiro2ColideWithFlag2) {
			result = "O cavaleiro da ilustre casa de " + b.getTeam() + " devia tentar ir para outro sitio.";
		}

		if (cavaleiro1morto) {
			result = "O cavaleiro da ilustre casa de " + b.getTeam() + " ja nao esta entre nos.";
		}
		
		if (espadachim1Morto) {
			result = "O espadachim da ilustre casa de " + b.getTeam() + " ja nao esta entre nos.";
		}
		
		if (lancer1morto) {
			result = "O lanceiro da ilustre casa de " + b.getTeam() + " ja nao esta entre nos.";
		}
		
		if (cavaleiro2morto) {
			result = "O cavaleiro da ilustre casa de " + b.getTeam() + " ja nao esta entre nos.";
		}
		
		if (espadachim2Morto) {
			result = "O espadachim da ilustre casa de " + b.getTeam() + " ja nao esta entre nos.";
		}
		
		if (lancer2morto) {
			result = "O lanceiro da ilustre casa de " + b.getTeam() + " ja nao esta entre nos.";
		}
		
		
		if (cavaleiro1vslancer2) {

			result = "Argh! A dor! Maldito sejas, lanceiro " + getOtherTeam(b.getTeam()) + ".";
		}

		if (cavaleiro1vscavaleiro2) {

			result = "Muhahah, sou um " + b.getTeam() + "! Sou invencivel! Nenhum cavaleiro me faz frente!";
		}

		if (cavaleiro1vsespadachim2) {

			result = "Muhahah, sou um " + b.getTeam() + "! Sou invencivel! Nenhum espadachim me faz frente!";
		}

		if (cavaleiro2vslancer1) {

			result = "Argh! A dor! Maldito sejas, lanceiro " + getOtherTeam(b.getTeam()) + ".";
		}

		if (cavaleiro2vscavaleiror1) {

			result = "Muhahah, sou um " + b.getTeam() + "! Sou invencivel! Nenhum cavaleiro me faz frente!";
		}

		if (cavaleiro2vsespadachim1) {

			result = "Muhahah, sou um " + b.getTeam() + "! Sou invencivel! Nenhum espadachim me faz frente!";

		}

		if (lanceiro1vslancer2) {

			result = "Muhahah, sou um " + b.getTeam() + "! Sou invencivel! Nenhum lanceiro me faz frente!";
		}

		if (lanceiro1vscavaleiror2) {
			result = "Muhahah, sou um " + b.getTeam() + "! Sou invencivel! Nenhum cavaleiro me faz frente!";

		}

		if (lanceiro1vsespadachim2) {

			result = "Argh! A dor! Maldito sejas, espadachim " + getOtherTeam(b.getTeam()) + ".";
		}

		if (lanceiro2vslancer1) {

			result = "Muhahah, sou um " + b.getTeam() + "! Sou invencivel! Nenhum lanceiro me faz frente!";
		}

		if (lanceiro2vscavaleiror1) {
			result = "Muhahah, sou um " + b.getTeam() + "! Sou invencivel! Nenhum cavaleiro me faz frente!";

		}

		if (lanceiro2vsespadachim1) {

			result = "Argh! A dor! Maldito sejas, espadachim " + getOtherTeam(b.getTeam()) + ".";
		}

		if (espadachim1vslancer2) {

			result = "Muhahah, sou um " + b.getTeam() + "! Sou invencivel! Nenhum lanceiro me faz frente!";
		}

		if (espadachim1vscavaleiror2) {

			result = "Argh! A dor! Maldito sejas, cavaleiro " + getOtherTeam(b.getTeam()) + ".";
		}

		if (espadachim1vsespadachim2) {

			result = "Muhahah, sou um " + b.getTeam() + "! Sou invencivel! Nenhum espadachim me faz frente!";
		}

		if (espadachim2vslancer1) {

			result = "Muhahah, sou um " + b.getTeam() + "! Sou invencivel! Nenhum lanceiro me faz frente!";
		}

		if (espadachim2vscavaleiror1) {

			result = "Argh! A dor! Maldito sejas, cavaleiro " + getOtherTeam(b.getTeam()) + ".";
		}

		if (espadachim2vsespadachim1) {

			result = "Muhahah, sou um " + b.getTeam() + "! Sou invencivel! Nenhum espadachim me faz frente!";
		}

		if (cavaleiro1passamapa) {

			result = "O cavaleiro da ilustre casa de " + b.getTeam() + " e um cobardolas.";
		}

		if (cavaleiro2passamapa) {

			result = "O cavaleiro da ilustre casa de " + b.getTeam() + " e um cobardolas.";
		}

		if (lanceiro1passamapa) {

			result = "O lanceiro da ilustre casa de " + b.getTeam() + " e um cobardolas.";
		}

		if (lanceiro2passamapa) {

			result = "O lanceiro da ilustre casa de " + b.getTeam() + " e um cobardolas.";
		}

		if (espadachim1passamapa) {

			result = "O espadachim da ilustre casa de " + b.getTeam() + " e um cobardolas.";
		}

		if (espadachim2passamapa) {

			result = "O espadachim da ilustre casa de " + b.getTeam() + " e um cobardolas.";
		}

		if (doesColideWithFlag2) {

			result = "Sou um heroi " + b.getTeam() + "! A bandeira " + getOtherTeam(b.getTeam())
					+ " e nossa! Vitoria gloriosa!";
		}

		if (doesColideWithFlag1) {

			result = "Sou um heroi " + b.getTeam() + "! A bandeira " + getOtherTeam(b.getTeam())
					+ " e nossa! Vitoria gloriosa!";
		}

		if (equipa1morta) {

			result += "\nSou um heroi " + b.getTeam() + "! A bandeira " + getOtherTeam(b.getTeam()) +" e nossa! Vitoria gloriosa!";
			
		}
		
		if (equipa2morta) {

			result += "\nSou um heroi " + getOtherTeam(b.getTeam()) + "! A bandeira " + b.getTeam() +" e nossa! Vitoria gloriosa!";
			
		}

		else {}}

		return result;
	}

	private String getOtherTeam(String team) {
		String result;
		if (team.equals(team1))
			result = team2;
		else
			result = team1;
		return result;

	}

	public boolean gameover() {

		return jogoacaba;
	}

	private boolean team1coolidecombandeira2(Soldier b) {
		boolean result = false;
		if (b.getTeam().equals(team1)) {
			if (b.getxSol() == xbandeira2 && b.getySol() == ybandeira2) {
				result = true;
			COUNTERMENU=-1;
			
			jogoacaba = true;}
			
			

		}

		return result;
	}

	private boolean team2coolidecombandeira1(Soldier b) {
		boolean result = false;

		if (b.getTeam().equals(team2)) {
			if (b.getxSol() == xbandeira1 && b.getySol() == ybandeira1) {
				result = true;
			jogoacaba = true;
			COUNTERMENU=-1;}

		}

		return result;

	}
	
	private boolean cavaleiro1coolidecombandeira1(Soldier b, String direct) {
		boolean result = false;
		if (b.getTeam().equals(team1) && (knight1.getxSol() == xbandeira1 && knight1.getySol() == ybandeira1) && b.getClassplayer() == Soldier.KNIGHT) {
			result = true;
			b.Walkback(direct);

		}

		return result;
	}
	
	private boolean cavaleiro2coolidecombandeira2(Soldier b, String direct) {
		boolean result = false;
		if (b.getTeam().equals(team2) && (knight2.getxSol() == xbandeira2 && knight2.getySol() == ybandeira2) && b.getClassplayer() == Soldier.KNIGHT) {
			result = true;
			b.Walkback(direct);

		}

		return result;
	}
	
	private boolean lancer1coolidecombandeira1(Soldier b, String direct) {
		boolean result = false;
		if (b.getTeam().equals(team1) && (lancer1.getxSol() == xbandeira1 && lancer1.getySol() == ybandeira1) && b.getClassplayer() == Soldier.LANCER) {
			result = true;
			b.Walkback(direct);

		}

		return result;
	}
	
	private boolean lancer2coolidecombandeira2(Soldier b, String direct) {
		boolean result = false;
		if (b.getTeam().equals(team2) && (lancer2.getxSol() == xbandeira2 && lancer2.getySol() == ybandeira2) && b.getClassplayer() == Soldier.LANCER) {
			result = true;
			b.Walkback(direct);

		}

		return result;
	}
	
	private boolean espadachim1coolidecombandeira1(Soldier b, String direct) {
		boolean result = false;
		if (b.getTeam().equals(team1) && (swordman1.getxSol() == xbandeira1 && swordman1.getySol() == ybandeira1) && b.getClassplayer() == Soldier.SWORDMAN) {
			result = true;
			b.Walkback(direct);

		}

		return result;
	}
	
	private boolean espadachim2coolidecombandeira2(Soldier b, String direct) {
		boolean result = false;
		if (b.getTeam().equals(team2) && (swordman2.getxSol() == xbandeira2 && swordman2.getySol() == ybandeira2) && b.getClassplayer() == Soldier.SWORDMAN) {
			result = true;
			b.Walkback(direct);

		}

		return result;
	}
	


	private boolean cavaleiro1passamapa(Soldier b, String direct) {
		boolean result = false;
		if (b.getTeam().equals(team1)
				&& ((knight1.getxSol() > xmap || knight1.getxSol() < 1 || knight1.getySol() > ymap)
						|| knight1.getySol() < 1) && b.getClassplayer() == Soldier.KNIGHT) {
			result = true;
			b.Walkback(direct);

		}
		return result;
	}

	private boolean cavaleiro2passamapa(Soldier b, String direct) {
		boolean result = false;
		if (b.getTeam().equals(team2)
				&& ((knight2.getxSol() > xmap || knight2.getxSol() < 1 || knight2.getySol() > ymap)
						|| knight2.getySol() < 1) && b.getClassplayer() == Soldier.KNIGHT) {
			result = true;
			b.Walkback(direct);

		}
		return result;
	}

	private boolean lanceiro1passamapa(Soldier b, String direct) {
		boolean result = false;
		if (b.getTeam().equals(team1)
				&& ((lancer1.getxSol() > xmap || lancer1.getxSol() < 1 || lancer1.getySol() > ymap)
						|| lancer1.getySol() < 1) && b.getClassplayer() == Soldier.LANCER) {
			result = true;
			b.Walkback(direct);

		}
		return result;
	}

	private boolean lanceiro2passamapa(Soldier b, String direct) {
		boolean result = false;
		if (b.getTeam().equals(team2)
				&& ((lancer2.getxSol() > xmap || lancer2.getxSol() < 1 || lancer2.getySol() > ymap)
						|| lancer2.getySol() < 1) && b.getClassplayer() == Soldier.LANCER) {
			result = true;
			b.Walkback(direct);

		}
		return result;
	}

	private boolean espadachim1passamapa(Soldier b, String direct) {
		boolean result = false;
		if (b.getTeam().equals(team1)
				&& ((swordman1.getxSol() > xmap || swordman1.getxSol() < 1 || swordman1.getySol() > ymap)
						|| swordman1.getySol() < 1) && b.getClassplayer() == Soldier.SWORDMAN) {
			result = true;
			b.Walkback(direct);

		}
		return result;
	}

	
	public boolean isfinish() {
		return jogoacaba;
		
	}
	
	
	
	
	private boolean espadachim2passamapa(Soldier b, String direct) {
		boolean result = false;
		if (b.getTeam().equals(team2)
				&& ((swordman2.getxSol() > xmap || swordman2.getxSol() < 1 || swordman2.getySol() > ymap)
						|| swordman2.getySol() < 1) && b.getClassplayer() == Soldier.SWORDMAN) {
			result = true;
			b.Walkback(direct);

		}
		return result;
	}

	private boolean cavaleiro1Morto(Soldier b) {
		boolean result = false;
		if (b.getTeam().equals(team1)
				&& knight1.isAlive()==false && b.getClassplayer() == Soldier.KNIGHT) {
			result = true;

		}
		return result;
	}
	
	private boolean cavaleiro2Morto(Soldier b) {
		boolean result = false;
		if (b.getTeam().equals(team2)
				&& knight2.isAlive()==false  && b.getClassplayer() == Soldier.KNIGHT) {
			result = true;

		}
		return result;
	}
	
	private boolean espadachim1Morto(Soldier b) {
		boolean result = false;
		if (b.getTeam().equals(team1)
				&& swordman1.isAlive()==false  && b.getClassplayer() == Soldier.SWORDMAN) {
			result = true;

		}
		return result;
	}
	
	private boolean espadachim2Morto(Soldier b) {
		boolean result = false;
		if (b.getTeam().equals(team2)
				&& swordman2.isAlive()==false && b.getClassplayer() == Soldier.SWORDMAN) {
			result = true;

		}
		return result;
	}
	
	private boolean lancer1Morto(Soldier b) {
		boolean result = false;
		if (b.getTeam().equals(team1)
				&& lancer1.isAlive()==false && b.getClassplayer() == Soldier.LANCER) {
			result = true;

		}
		return result;
	}
	
	private boolean lancer2Morto(Soldier b) {
		boolean result = false;
		if (b.getTeam().equals(team2)
				&& lancer2.isAlive()==false && b.getClassplayer() == Soldier.LANCER) {
			result = true;

		}
		return result;
	}

	private boolean equipa1morta(Soldier b) {
		boolean result = false;
		if (knight1.isAlive() == false && lancer1.isAlive() == false && swordman1.isAlive() == false) {

			COUNTERMENU=-1;
			result = true;
			jogoacaba=true;
		}
		return result;
	}
	
	private boolean equipa2morta(Soldier b) {
		boolean result = false;
		if (knight2.isAlive() == false && lancer2.isAlive() == false && swordman2.isAlive() == false) {
			COUNTERMENU=-1;
			result = true;
			jogoacaba=true;
		}
		return result;
	}

	private boolean cavaleiro1colidecomlancer1(Soldier b,String direct) {
		boolean result = false;
		if ((b.getTeam().equals(team1)) && knight1.getxSol() == lancer1.getxSol()
				&& knight1.getySol() == lancer1.getySol() && lancer1.isAlive() && knight1.isAlive() &&  b.getClassplayer() == Soldier.KNIGHT)  {
			result=true;
			b.Walkback(direct);
			
		}
		return result;
	}
	
	private boolean cavaleiro1colidecomespadachim1(Soldier b,String direct) {
		boolean result = false;
		if ((b.getTeam().equals(team1)) && knight1.getxSol() == swordman1.getxSol()
				&& knight1.getySol() == swordman1.getySol() && swordman1.isAlive() && knight1.isAlive() && b.getClassplayer() == Soldier.KNIGHT) {
			result=true;
			b.Walkback(direct);
			
		}
		return result;
	}
	
	private boolean lancer1colidecomcavaleiro1(Soldier b,String direct) {
		boolean result = false;
		if ((b.getTeam().equals(team1)) && lancer1.getxSol() == knight1.getxSol()
				&& lancer1.getySol() == knight1.getySol() && knight1.isAlive() && lancer1.isAlive() && b.getClassplayer() == Soldier.LANCER) {
			result=true;
			b.Walkback(direct);
			
		}
		return result;
	}
	
	private boolean lancer1colidecomespadachim1(Soldier b,String direct) {
		boolean result = false;
		if ((b.getTeam().equals(team1)) && lancer1.getxSol() == swordman1.getxSol()
				&& lancer1.getySol() == swordman1.getySol() && swordman1.isAlive() && lancer1.isAlive() && b.getClassplayer() == Soldier.LANCER) {
			result=true;
			b.Walkback(direct);
			
		}
		return result;
	}
	
	private boolean espadachim1colidecomcavaleiro1(Soldier b,String direct) {
		boolean result = false;
		if ((b.getTeam().equals(team1)) && swordman1.getxSol() == knight1.getxSol()
				&& swordman1.getySol() == knight1.getySol() && knight1.isAlive() && swordman1.isAlive() && b.getClassplayer() == Soldier.SWORDMAN){
			result=true;
			b.Walkback(direct);
			
		}
		return result;
	}
	
	private boolean espadachim1colidecomlancer1(Soldier b,String direct) {
		boolean result = false;
		if ((b.getTeam().equals(team1)) && swordman1.getxSol() == lancer1.getxSol()
				&& swordman1.getySol() == lancer1.getySol() && lancer1.isAlive()&& swordman1.isAlive() && b.getClassplayer() == Soldier.SWORDMAN) {
			result=true;
			b.Walkback(direct);
			
		}
		return result;
	}
	
	private boolean cavaleiro2colidecomlancer2(Soldier b,String direct) {
		boolean result = false;
		if ((b.getTeam().equals(team2)) && knight2.getxSol() == lancer2.getxSol()
				&& knight2.getySol() == lancer2.getySol() && lancer2.isAlive() && knight2.isAlive() && b.getClassplayer() == Soldier.KNIGHT) {
			result=true;
			b.Walkback(direct);
			
		}
		return result;
	}
	
	private boolean cavaleiro2colidecomespadachim2(Soldier b,String direct) {
		boolean result = false;
		if ((b.getTeam().equals(team2)) && knight2.getxSol() == swordman2.getxSol()
				&& knight2.getySol() == swordman2.getySol() && swordman2.isAlive() && knight2.isAlive() && b.getClassplayer() == Soldier.KNIGHT) {
			result=true;
			b.Walkback(direct);
			
		}
		return result;
	}
	
	private boolean lancer2colidecomcavaleiro2(Soldier b,String direct) {
		boolean result = false;
		if ((b.getTeam().equals(team2)) && lancer2.getxSol() == knight2.getxSol()
				&& lancer2.getySol() == knight2.getySol() && knight2.isAlive() && lancer2.isAlive() && b.getClassplayer() == Soldier.LANCER) {
			result=true;
			b.Walkback(direct);
			
		}
		return result;
	}
	
	private boolean lancer2colidecomespadachim2(Soldier b,String direct) {
		boolean result = false;
		if ((b.getTeam().equals(team2)) && lancer2.getxSol() == swordman2.getxSol()
				&& lancer2.getySol() == swordman2.getySol() && swordman2.isAlive() && lancer2.isAlive() && b.getClassplayer() == Soldier.LANCER) {
			result=true;
			b.Walkback(direct);
			
		}
		return result;
	}
	
	private boolean espadachim2colidecomcavaleiro2(Soldier b,String direct) {
		boolean result = false;
		if ((b.getTeam().equals(team2)) && swordman2.getxSol() == knight2.getxSol()
				&& swordman2.getySol() == knight2.getySol() && knight2.isAlive() && swordman2.isAlive() && b.getClassplayer() == Soldier.SWORDMAN) {
			result=true;
			b.Walkback(direct);
			
		}
		return result;
	}
	
	private boolean espadachim2colidecomlancer2(Soldier b,String direct) {
		boolean result = false;
		if ((b.getTeam().equals(team2)) && swordman2.getxSol() == lancer2.getxSol()
				&& swordman2.getySol() == lancer2.getySol() && lancer2.isAlive() && swordman2.isAlive() && b.getClassplayer() == Soldier.SWORDMAN) {
			result=true;
			b.Walkback(direct);
			
		}
		return result;
	}
	
	
	
	
	
	
	
	private boolean cavaleiro1vslancer2(Soldier b) {
		boolean result = false;
		if ((b.getTeam().equals(team1)) && knight1.getxSol() == lancer2.getxSol()
				&& knight1.getySol() == lancer2.getySol() && knight1.isAlive() && b.getClassplayer() == Soldier.KNIGHT) {
			result = true;
			knight1.kill();

		}
		return result;
	}

	private boolean cavaleiro1vscavaleiror2(Soldier b) {
		boolean result = false;
		if (b.getTeam().equals(team1) && knight1.getxSol() == knight2.getxSol()
				&& knight1.getySol() == knight2.getySol() && knight1.isAlive() && b.getClassplayer() == Soldier.KNIGHT) {
			result = true;
			knight2.kill();

		}
		return result;
	}

	private boolean cavaleiro1vsespadachim2(Soldier b) {
		boolean result = false;
		if (b.getTeam().equals(team1) && knight1.getxSol() == swordman2.getxSol()
				&& knight1.getySol() == swordman2.getySol() && knight1.isAlive() && b.getClassplayer() == Soldier.KNIGHT) {
			result = true;
			swordman2.kill();

		}
		return result;
	}

	private boolean cavaleiro2vslancer1(Soldier b) {
		boolean result = false;
		if (b.getTeam().equals(team2) && knight2.getxSol() == lancer1.getxSol()
				&& knight2.getySol() == lancer1.getySol() && knight2.isAlive() && b.getClassplayer() == Soldier.KNIGHT) {
			result = true;
			knight2.kill();

		}
		return result;
	}

	private boolean cavaleiro2vscavaleiror1(Soldier b) {
		boolean result = false;
		if (b.getTeam().equals(team2) && knight2.getxSol() == knight1.getxSol()
				&& knight2.getySol() == knight1.getySol() && knight2.isAlive() && b.getClassplayer() == Soldier.KNIGHT) {
			result = true;
			knight1.kill();

		}
		return result;
	}

	private boolean cavaleiro2vsespadachim1(Soldier b) {
		boolean result = false;
		if (b.getTeam().equals(team2) && knight2.getxSol() == swordman1.getxSol()
				&& knight2.getySol() == swordman1.getySol() && knight2.isAlive() && b.getClassplayer() == Soldier.KNIGHT) {
			result = true;
			swordman1.kill();

		}
		return result;
	}

	private boolean lanceiro1vslancer2(Soldier b) {
		boolean result = false;
		if (b.getTeam().equals(team1) && lancer1.getxSol() == lancer2.getxSol()
				&& lancer1.getySol() == lancer2.getySol() && lancer1.isAlive() && b.getClassplayer() == Soldier.LANCER) {
			result = true;
			lancer2.kill();
		}
		return result;
	}

	private boolean lanceiro1vscavaleiror2(Soldier b) {
		boolean result = false;
		if (b.getTeam().equals(team1) && lancer1.getxSol() == knight2.getxSol()
				&& lancer1.getySol() == knight2.getySol() && lancer1.isAlive() && b.getClassplayer() == Soldier.LANCER) {
			result = true;
			knight2.kill();
		}
		return result;
	}

	private boolean lanceiro1vsespadachim2(Soldier b) {
		boolean result = false;
		if (b.getTeam().equals(team1) && lancer1.getxSol() == swordman2.getxSol()
				&& lancer1.getySol() == swordman2.getySol() && lancer1.isAlive() && b.getClassplayer() == Soldier.LANCER) {
			result = true;
			lancer1.kill();

		}
		return result;
	}

	private boolean lanceiro2vslancer1(Soldier b) {
		boolean result = false;
		if (b.getTeam().equals(team2) && lancer2.getxSol() == lancer1.getxSol()
				&& lancer2.getySol() == lancer1.getySol() && lancer2.isAlive() && b.getClassplayer() == Soldier.LANCER) {
			result = true;
			lancer1.kill();
		}
		return result;
	}

	private boolean lanceiro2vscavaleiror1(Soldier b) {
		boolean result = false;
		if (b.getTeam().equals(team2) && lancer2.getxSol() == knight1.getxSol()
				&& lancer2.getySol() == knight1.getySol() && lancer2.isAlive() && b.getClassplayer() == Soldier.LANCER) {
			result = true;
			knight1.kill();
		}
		return result;
	}

	private boolean lanceiro2vsespadachim1(Soldier b) {
		boolean result = false;
		if (b.getTeam().equals(team2) && lancer2.getxSol() == swordman1.getxSol()
				&& lancer2.getySol() == swordman1.getySol() && lancer2.isAlive() && b.getClassplayer() == Soldier.LANCER) {
			result = true;
			lancer2.kill();

		}
		return result;
	}

	private boolean espadachim1vslancer2(Soldier b) {
		boolean result = false;
		if (b.getTeam().equals(team1) && swordman1.getxSol() == lancer2.getxSol()
				&& swordman1.getySol() == lancer2.getySol() && swordman1.isAlive() && b.getClassplayer() == Soldier.SWORDMAN) {
			result = true;
			lancer2.kill();
		}
		return result;
	}

	private boolean espadachim1vscavaleiror2(Soldier b) {
		boolean result = false;
		if (b.getTeam().equals(team1) && swordman1.getxSol() == knight2.getxSol()
				&& swordman1.getySol() == knight2.getySol() && swordman1.isAlive() && b.getClassplayer() == Soldier.SWORDMAN) {
			result = true;
			swordman1.kill();
		}
		return result;
	}

	private boolean espadachim1vsespadachim2(Soldier b) {
		boolean result = false;
		if (b.getTeam().equals(team1) && swordman1.getxSol() == swordman2.getxSol()
				&& swordman1.getySol() == swordman2.getySol() && swordman1.isAlive() && b.getClassplayer() == Soldier.SWORDMAN) {
			result = true;
			swordman2.kill();

		}
		return result;
	}

	private boolean espadachim2vslancer1(Soldier b) {
		boolean result = false;
		if (b.getTeam().equals(team2) && swordman2.getxSol() == lancer1.getxSol()
				&& swordman2.getySol() == lancer1.getySol() && swordman2.isAlive() && b.getClassplayer() == Soldier.SWORDMAN) {
			result = true;
			lancer1.kill();
		}
		return result;
	}

	private boolean espadachim2vscavaleiror1(Soldier b) {
		boolean result = false;
		if (b.getTeam().equals(team2) && swordman2.getxSol() == knight1.getxSol()
				&& swordman2.getySol() == knight1.getySol() && swordman2.isAlive() && b.getClassplayer() == Soldier.SWORDMAN) {
			result = true;
			swordman2.kill();
		}
		return result;
	}

	private boolean espadachim2vsespadachim1(Soldier b) {
		boolean result = false;
		if (b.getTeam().equals(team2) && swordman2.getxSol() == swordman1.getxSol()
				&& swordman2.getySol() == swordman1.getySol() && swordman2.isAlive() && b.getClassplayer() == Soldier.SWORDMAN) {
			result = true;
			swordman1.kill();

		}
		return result;
	}

	public String getnameteam1() {

		return team1;
	}

	public String getnameteam2() {

		return team2;
	}

	public void setflag1(int x, int y) {

		ybandeira1 = y;
		xbandeira1 = x;

	}

	public void setflag2(int x, int y) {
		ybandeira2 = y;
		xbandeira2 = x;

	}

	public int getxmap() {

		return xmap;

	}

	public int getymap() {

		return ymap;

	}

	public int getXFlag1() {

		return xbandeira1;
	}

	public int getyFlag1() {

		return ybandeira1;
	}

	public int getXFlag2() {

		return xbandeira2;
	}

	public int getyFlag2() {

		return ybandeira2;
	}

	public int getXmap() {
		return xmap;
	}

	public int getYmap() {
		return ymap;
	}

	public int getYbandeira1() {
		return ybandeira1;
	}

	public int getXbandeira1() {
		return xbandeira1;
	}

	public int getYbandeira2() {
		return ybandeira2;
	}

	public int getXbandeira2() {
		return xbandeira2;
	}

	public Soldier getKnight1() {
		return knight1;
	}

	public Soldier getKnight2() {
		return knight2;
	}

	public Soldier getSwordman1() {
		return swordman1;
	}

	public Soldier getSwordman2() {
		return swordman2;
	}

	public Soldier getLancer1() {
		return lancer1;
	}

	public Soldier getLancer2() {
		return lancer2;
	}

}
