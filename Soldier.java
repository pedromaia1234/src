
public class Soldier {
	
	
	private int xSol,ySol;
	
	private int classplayer;
	private boolean life;
	private String team;
	
	public static final int KNIGHT=1;
	public static final int SWORDMAN=2;
	public static final int LANCER=3;
	public static final String NORTE="norte";
	public static final String SUL="sul";
	public static final String OESTE="oeste";
	public static final String ESTE="este";
	
	public Soldier (int xSol, int ySol, int classplayer, String team) {
		
		this.xSol=xSol;
		this.ySol=ySol;
		this.classplayer=classplayer;
		this.team=team;
		life=true;
		}
	
	public String getClassName() {
		String name = "";
		switch(classplayer) {
			case LANCER:
				name = "lanceiro";
				break;
			case SWORDMAN:
				name = "espadachim";
				break;
			case KNIGHT:
				name = "cavaleiro";
				break;
		}
		return name;
	}
	
	public void Walk (String direction) {
		switch (direction) {
		
		case NORTE:
			ySol+=1;
			break;
		case SUL:
			ySol-=1;
			break;
		case OESTE:
			xSol-=1;
			break;
		case ESTE:
			xSol+=1;
			break;
		}
		
	
		
	}
	public void attack(Soldier b) {
		boolean morreu=false;
		
		if (isAlive()) {
			
			switch(classplayer) {
			
			case KNIGHT:
				morreu=cavaleiroMorreContraClass(b.classplayer);
				break;
				
			case LANCER:
				morreu = lancerMorreContraClass(b.classplayer);
				break;
				
			case SWORDMAN:
				morreu= espadachimMorreContraClass(b.classplayer);
				break;
			}
			if(morreu) {kill();}
			else {b.kill();}
			
		}
		
		
	}
	
	private boolean cavaleiroMorreContraClass(int classtype) {
		boolean morre=false;
		if (classtype==LANCER) {
			morre=true;
		}
		return morre;
	}
	
	
	private boolean lancerMorreContraClass (int classtype) {
		
		boolean morre=false;
		if (classtype==SWORDMAN) {
			morre=true;
		}
		return morre;
	}
	
	private boolean espadachimMorreContraClass(int classtype) {
		
		boolean morre=false;
		if (classtype==KNIGHT) {
			morre=true;
		}
		return morre;
	}
	
	

	
	public String isVivo() {
		String out = "";
		if(life)
			out = "vivo";
		else
			out = "morto";
		return out;
	}

	
	public boolean isAlive() {
		return life;
	}

	public void kill() {
		life = false;
	}

	public int getxSol() {
		return xSol;
	}



	public int getySol() {
		return ySol;
	}



	public int getClassplayer() {
		return classplayer;
	}
	
	
	





	public String getTeam() {
		return team;
	}
	
	
	
}
