
public class BoardGame {
	
	//variaveis
	private int xmap;
	private int ymap;
	private int ybandeira1,xbandeira1;
	private int ybandeira2,xbandeira2;
    private String team1,team2;
	private Soldier knight1;
	private Soldier knight2;
	private Soldier swordman1;
	private Soldier swordman2;
	private Soldier lancer1;
	private Soldier lancer2;
	
	
	
	
	public BoardGame (int xmap,int ymap , String team1,String team2, int xbandeira1, int ybandeira1,int xbandeira2, int ybandeira2 ) {
		this.xmap=xmap;
		this.ymap=ymap;
		knight1= new Soldier (xbandeira1,ybandeira1+1,1,team1);
		swordman1= new Soldier (xbandeira1+1,ybandeira1,2,team1);
		lancer1= new Soldier (xbandeira1,ybandeira1-1,3,team1);
		knight2= new Soldier (xbandeira2,ybandeira2+1,1,team2);
		swordman2= new Soldier (xbandeira2+1,ybandeira2,2,team2);
		lancer2= new Soldier (xbandeira2,ybandeira2-1,3,team2);
		this.team1=team1;
		this.team2=team2;		
		setflag1(xbandeira1,ybandeira1);
		setflag2(xbandeira2,ybandeira2);
		
		
		}
		
	private Soldier colidecomjogador(int x, int y) {
		Soldier possibleSoldier = null;
		if(knight1.getxSol() == x && knight1.getySol() == y) {
				possibleSoldier = knight1;
		}
		else if(knight2.getxSol() == x && knight2.getySol() == y) {
				possibleSoldier = knight2;			
		}
		else if(swordman1.getxSol() == x && swordman1.getySol() == y) {
				possibleSoldier = swordman1;
		}
		else if(swordman2.getxSol() == x && swordman2.getySol() == y) {
				possibleSoldier = swordman2;
		}
		else if(lancer1.getxSol() == x && lancer1.getySol() == y) {
				possibleSoldier = lancer1;
		}
		else if(lancer2.getxSol() == x && lancer2.getySol() == y) {
				possibleSoldier = lancer2;
		}
		return possibleSoldier;
	}
	   
	private String possoMover(Soldier b,int x, int y) {
		String move="";
		if (x>xmap || y>ymap || x<1 || y<1) {
			
			move = "O %s da iluste casa %s e um cobardolas." ;
			}
		else {
			Soldier soldier = colidecomjogador(x, y);
			if (soldier == null) {
				int xFlag = 0;
				int yFlag = 0;
				if(b.getTeam().equals(team1)) {
					xFlag = xbandeira1;
					yFlag = ybandeira1;
				}
				else {
					xFlag = xbandeira2;
					yFlag = ybandeira2;
				}
				if(x == xFlag && y == yFlag)
					move = "O %s da ilustre casa %s devia tentar ir para outro sitio.";
				else {
		
				}
			}
			else {
				if(soldier.getTeam().equals(b.getTeam())){
					if(soldier.isAlive())
						move = "O %s da ilustre casa %s devia tentar ir para outro sitio.";}
				else {move="fight";}
				
		}
			
				
			} return move;
	} 
		
	public String Walk(Soldier b, String direct) {
		int x ,y ;
		x=b.getxSol();
		y=b.getySol();
		switch (direct) {
		
		case Soldier.NORTE:
			y+=1;
			
		case Soldier.SUL:
			y-=1;
			
		case Soldier.OESTE:
			x-=1;
			
		case Soldier.ESTE:
			x+=1;
		}
		String result=possoMover(b,x,y);
		if (!result.equals("O %s da iluste casa %s e um cobardolas.") || !result.equals("O %s da ilustre casa %s devia tentar ir para outro sitio.")){
			b.Walk(direct);}
		if (result.equals("figth")) {
			Soldier defender=colidecomjogador(x,y);
			b.attack(defender);
			boolean isAlive=b.isAlive();
			boolean isTeamAlive=true;
			if (isAlive) {
				if (b.getTeam().equals(team1)) {
					if (!knight2.isAlive() && !swordman2.isAlive() && !lancer2.isAlive()) {
						
						result = "Sou um heroi %s! A bandeira %s e nossa! Vitoria gloriosa!";
					}
					else {
						
						result ="Muhahah, sou um %s! Sou invencivel! Nenhum %s me faz frente!";
					}
				}
				else {
					if (!knight1.isAlive() && !swordman1.isAlive() && !lancer1.isAlive()) {
						
						result = "Sou um heroi %s! A bandeira %s e nossa! Vitoria gloriosa!";
					}
					else {
						
						result ="Muhahah, sou um %s! Sou invencivel! Nenhum %s me faz frente!";
				}
				
				
			}}
			else {
				if (b.getTeam().equals(team2)) {
				if (!knight2.isAlive() && !swordman2.isAlive() && !lancer2.isAlive()) {
					isTeamAlive=false;
					result = "Sou um heroi %s! A bandeira %s e nossa! Vitoria gloriosa!";
				}
				else {
					
					result ="Argh! A dor! Maldito sejas, %s %s.";
				}
			}
			else {
				if (!knight1.isAlive() && !swordman1.isAlive() && !lancer1.isAlive()) {
					isTeamAlive=false;
					result = "Sou um heroi %s! A bandeira %s e nossa! Vitoria gloriosa!";
				}
				else {
					
					result ="Argh! A dor! Maldito sejas, %s %s.";
			}
			
			
		}

			}
		}
		
			switch (result) {

			case "Argh! A dor! Maldito sejas, %s %s.":
				result = String.format(result,b.getClassName(),b.getTeam());
				break;
			case "Sou um heroi %s! A bandeira %s e nossa! Vitoria gloriosa!":
				
			case "Muhahah, sou um %s! Sou invencivel! Nenhum %s me faz frente!":
				result = String.format(result,b.getTeam(),b.getClassName());
				break;
				
			
			}
				
	}
	
	// metodos publicos
		public  String getnameteam1() {
		
		return team1;}
	

		public  String getnameteam2() {
		
		return team2;}
		
		public void setflag1(int x , int y) {
		
		ybandeira1=y;
		xbandeira1=x;
		
		
		}
	
		public void setflag2(int x , int y) {
		ybandeira2=y;
		xbandeira2=x;
		
		
		}
		
		
		
		public int getxmap () {
		
		return xmap;
		
	}
	

		public int getymap () {
		
		return ymap;
		
	}
	//metodos para returnar as cordenadas da equipa 1
		
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
