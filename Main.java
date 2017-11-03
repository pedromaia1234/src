
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner in = new Scanner(System.in);
		BoardGame b = new BoardGame();
		
		processmenu(b,in);
		in.close();
		
	}

	
	
	
	private static final String SAI="sai";
	private static final String NOVO="novo";
	private static final String AJUDA="ajuda";
	private static final String MAPA="mapa";
	private static final String CAVALEIRO="cavaleiro";
	private static final String LANCEIRO="lanceiro";
	private static final String SWORDMAN="espadachim";
	private static final String NORTE="norte";
	private static final String SUL="sul";
	private static final String OESTE="oeste";
	private static final String ESTE="este";
	
	

	
	
	private static void showmenu(BoardGame b) {
		
		
		if (b.returncounter()==0) {
		System.out.println("novo - Novo jogo");
		System.out.println("ajuda - Mostra a ajuda");
		System.out.println("sai - Termina a execucao do programa");}
		else if (b.returncounter()>0) {
			System.out.println("novo - Novo jogo");
			System.out.println("mapa - Mostra o mapa do jogo");
			System.out.println("cavaleiro - Move o cavaleiro");
			System.out.println("espadachim - Move o espadachim");
			System.out.println("lanceiro - Move o lanceiro");
			System.out.println("ajuda - Mostra a ajuda");
			System.out.println("sai - Termina a execucao do programa");}
			

		}
		

	
	
	private static void processmenu (BoardGame b ,Scanner in) {
		String op = "";
		
		showmenu(b);
		
		String team;
		while (!op.equals("sai")) {
			team = "";
		if (b.returncounter()>0)
			
			if (b.returncounter() %2==0 )
				team=b.getnameteam2()+" ";
			else {
				team=b.getnameteam1()+ " ";
			}
	

			System.out.print(team +"> ");
			
			op=in.next().toLowerCase();
		switch (op) {
		
		case SAI:
			System.out.println("Obrigado por jogar. Ate a proxima."); 
			break;
		case NOVO:
			b=newgame(b,in); 
			
			break;
			
		case AJUDA:
			showmenu(b);
			break;
			
		case MAPA:
		processMap(b);
			break;
			
		case CAVALEIRO:
			moveKnightMAP(b,in);
			break;
			
		case SWORDMAN:
			moveSwordMANMAP(b,in);
			break;
			
		case LANCEIRO:
			moveLancerMAP(b,in);
			break;
			
			
			
			
			default: System.out.println("Opcao inexistente.");
				
			
			
			
			
		}
		
	}}
	
	private static BoardGame newgame(BoardGame b , Scanner in) {
		BoardGame result = b;
		
		int xmap;
		int ymap;
		String team1;
		String team2;
		int ybandeira1;
		int xbandeira1;
		int xbandeira2;
		int ybandeira2;
		b.setCounter(0);
		xmap=in.nextInt();
		ymap=in.nextInt();
		in.nextLine();
		team1=in.next();
		xbandeira1=in.nextInt();
		ybandeira1=in.nextInt();
		in.nextLine();
		team2=in.next();
		xbandeira2=in.nextInt(); 
		ybandeira2=in.nextInt(); 
		boolean success = true;
		if (xmap<10 || ymap<10) {
			System.out.println("Mapa pequeno demais para o jogo.");
			success = false;
		}
		else {
			if (xbandeira1>=xmap || xbandeira1<2 || ybandeira1>=ymap || ybandeira1<2) {
				System.out.println(team1 + " bandeira em posicao invalida " + xbandeira1 + " "+ ybandeira1+ ".");
				success=false;
				if(xbandeira2>=xmap || xbandeira2<2 || ybandeira2>=ymap || ybandeira2<2) {
					System.out.println(team2 + " bandeira em posicao invalida " + xbandeira2 + " "+ ybandeira2+ ".");
					success=false;
				}}

			
			else if (team1.equals(team2) && success) {
				System.out.println("As equipas nao podem ter o mesmo nome.");
				success=false;}
			
			else if ((Math.abs(xbandeira1-xbandeira2)+Math.abs(ybandeira1-ybandeira2))<=5 && success) {
				System.out.println(team2 + " bandeira em posicao invalida " + xbandeira2 + " "+ ybandeira2+ ".");
				success=false;}
			else {
				result = new BoardGame (xmap,ymap,team1,team2, xbandeira1, ybandeira1, xbandeira2, ybandeira2);
				System.out.println ("Jogo iniciado, comeca a equipa " + result.getnameteam1()+".");

			}
		}
		return result;}
			
			
		
			
		
	
	
	
	private static void processMap(BoardGame b) {
		if (b.returncounter()==0) {
			System.out.println("Comando inactivo.");}
			else {
			System.out.println(b.getxmap()+" " + b.getymap());
			System.out.print(b.getnameteam1()+" " + b.getXFlag1()+" " + b.getyFlag1() + " ");
			System.out.print("cavaleiro(" + b.getKnight1().isVivo() +") " + b.getKnight1().getxSol() + " " + b.getKnight1().getySol() + " ");
			System.out.print("espadachim(" + b.getSwordman1().isVivo() +") " + b.getSwordman1().getxSol()+ " " + b.getSwordman1().getySol() + " ");
			System.out.println("lanceiro(" + b.getLancer1().isVivo() +") " + b.getLancer1().getxSol() + " " + b.getLancer1().getySol() );
			System.out.print(b.getnameteam2()+" " + b.getXFlag2()+" " + b.getyFlag2()+ " ");
			System.out.print("cavaleiro(" + b.getKnight2().isVivo() +") " + b.getKnight2().getxSol() + " " + b.getKnight2().getySol()+" " );
			System.out.print("espadachim(" + b.getSwordman2().isVivo() +") " + b.getSwordman2().getxSol() + " " + b.getSwordman2().getySol()+ " " );
			System.out.println("lanceiro(" + b.getLancer2().isVivo() +") " + b.getLancer2().getxSol() + " " + b.getLancer2().getySol() );
			
			
		}
		
		}
	
	private static void moveKnightMAP(BoardGame b, Scanner in) {
		String direction="";
		int counter=0;
		if (b.returncounter()>0) {
			if (b.returncounter() %2 ==0) {
			while (counter<3) {
				
				direction = in.next();
				
				if (!b.isfinish()) {
				switch (direction) {
				
				case NORTE:
					String output= b.Walk(b.getKnight2(), Soldier.NORTE);
					if(!output.equals(""))
						System.out.println(output);
					System.out.println(b.getnameteam2()+" " +"cavaleiro(" + b.getKnight2().isVivo() +") " + b.getKnight2().getxSol() + " " + b.getKnight2().getySol());
					
					break;
			
					
				case SUL:
					String output1=b.Walk(b.getKnight2(), Soldier.SUL);
					if(!output1.equals(""))
						System.out.println(output1);
					System.out.println(b.getnameteam2()+" " +"cavaleiro(" + b.getKnight2().isVivo() +") " + b.getKnight2().getxSol() + " " + b.getKnight2().getySol());
					
					break;
					
				case OESTE:
					String output2=b.Walk(b.getKnight2(), Soldier.OESTE);
					if(!output2.equals(""))
						System.out.println(output2);
					System.out.println(b.getnameteam2()+" " +"cavaleiro(" + b.getKnight2().isVivo() +") " + b.getKnight2().getxSol() + " " + b.getKnight2().getySol());
					
					break;
					
				case ESTE:
					String output3=b.Walk(b.getKnight2(), Soldier.ESTE);
					if(!output3.equals(""))
						System.out.println(output3);
					System.out.println(b.getnameteam2()+" " +"cavaleiro(" + b.getKnight2().isVivo() +") " + b.getKnight2().getxSol() + " " + b.getKnight2().getySol());
					
					break;
					
				}}
			
				
			counter++;
			}b.incCOUNTER();
			
			}
			else {
				
				while (counter<3) {

					direction = in.next();
					if (!b.isfinish()) {
					switch (direction) {
					
					case NORTE:
						String output = b.Walk(b.getKnight1(), Soldier.NORTE);
						if(!output.equals(""))
							System.out.println(output);
						System.out.println(b.getnameteam1()+" " +"cavaleiro(" + b.getKnight1().isVivo() +") " + b.getKnight1().getxSol() + " " + b.getKnight1().getySol());
						
						break;
						
					case SUL:
						String output1 = b.Walk(b.getKnight1(), Soldier.SUL);
						if(!output1.equals(""))
							System.out.println(output1);
						System.out.println(b.getnameteam1()+" " +"cavaleiro(" + b.getKnight1().isVivo() +") " + b.getKnight1().getxSol() + " " + b.getKnight1().getySol());
						
						break;
					case OESTE:
						String output2 = b.Walk(b.getKnight1(), Soldier.OESTE);
						if(!output2.equals(""))
							System.out.println(output2);
						System.out.println(b.getnameteam1()+" " +"cavaleiro(" + b.getKnight1().isVivo() +") " + b.getKnight1().getxSol() + " " + b.getKnight1().getySol());
						
						break;
					case ESTE:
						String output3 = b.Walk(b.getKnight1(), Soldier.ESTE);
						if(!output3.equals(""))
							System.out.println(output3);
						System.out.println(b.getnameteam1()+" " +"cavaleiro(" + b.getKnight1().isVivo() +") " + b.getKnight1().getxSol() + " " + b.getKnight1().getySol());
						
						break;
					}}
				
				counter++;
				}b.incCOUNTER();	
				
			}
		}
		else {
			System.out.println("Comando inactivo.");}
	}
	
	
	
	private static void moveSwordMANMAP(BoardGame b, Scanner in) {
		String direction="";
		if (b.returncounter()>0) {
			if (b.returncounter() %2 ==0) {
			
				
				direction = in.next();
				
				switch (direction) {
				
				case NORTE:
					String output =b.Walk(b.getSwordman2(), Soldier.NORTE);
					if(!output.equals(""))
						System.out.println(output);
					System.out.println(b.getnameteam2()+" " +"espadachim(" + b.getSwordman2().isVivo() +") " + b.getSwordman2().getxSol() + " " + b.getSwordman2().getySol());
					break;
			
					
				case SUL:
					String output1= b.Walk(b.getSwordman2(), Soldier.SUL);
					if(!output1.equals(""))
						System.out.println(output1);
					System.out.println(b.getnameteam2()+" " +"espadachim(" + b.getSwordman2().isVivo() +") " + b.getSwordman2().getxSol() + " " + b.getSwordman2().getySol());
					break;
					
				case OESTE:
					String output2=b.Walk(b.getSwordman2(), Soldier.OESTE);
					if(!output2.equals(""))
						System.out.println(output2);
					System.out.println(b.getnameteam2()+" " +"espadachim(" + b.getSwordman2().isVivo() +") " + b.getSwordman2().getxSol() + " " + b.getSwordman2().getySol());
					break;
					
				case ESTE:
					String output3=b.Walk(b.getSwordman2(), Soldier.ESTE);
					if(!output3.equals(""))
						System.out.println(output3);
					System.out.println(b.getnameteam2()+" " +"espadachim(" + b.getSwordman2().isVivo() +") " + b.getSwordman2().getxSol() + " " + b.getSwordman2().getySol());
					break;
				}
			
				b.incCOUNTER();
			
			
			}
			else {
				
			
					direction = in.next();
					
					switch (direction) {
					
					case NORTE:
						String output = b.Walk(b.getSwordman1(), Soldier.NORTE);
						if(!output.equals(""))
							System.out.println(output);
						System.out.println(b.getnameteam1()+" " +"espadachim(" + b.getSwordman1().isVivo() +") " + b.getSwordman1().getxSol() + " " + b.getSwordman1().getySol());
						
						break;
						
					case SUL:
						String output1 =	b.Walk(b.getSwordman1(), Soldier.SUL);
						if(!output1.equals(""))
							System.out.println(output1);
						System.out.println(b.getnameteam1()+" " +"espadachim(" + b.getSwordman1().isVivo() +") " + b.getSwordman1().getxSol() + " " + b.getSwordman1().getySol());
						
						break;
					case OESTE:
						String output2=	b.Walk(b.getSwordman1(), Soldier.OESTE);
						if(!output2.equals(""))
							System.out.println(output2);
						System.out.println(b.getnameteam1()+" " +"espadachim(" + b.getSwordman1().isVivo() +") " + b.getSwordman1().getxSol() + " " + b.getSwordman1().getySol());
						
						break;
					case ESTE:
						String output3 =b.Walk(b.getSwordman1(), Soldier.ESTE);
						if(!output3.equals(""))
							System.out.println(output3);
						System.out.println(b.getnameteam1()+" " +"espadachim(" + b.getSwordman1().isVivo() +") " + b.getSwordman1().getxSol() + " " + b.getSwordman1().getySol());
						
						break;
					}
					b.incCOUNTER();
					
				
			}
		}
		else {System.out.println("Comando inactivo.");}
	}
	
	
	
	private static void moveLancerMAP(BoardGame b, Scanner in) {
		String direction="";
		if (b.returncounter()>0) {
			if (b.returncounter() %2 ==0) {
			
				
				direction = in.next();
				
				switch (direction) {
				
				case NORTE:
					String output =b.Walk(b.getLancer2(), Soldier.NORTE);
					if(!output.equals(""))
						System.out.println(output);
					System.out.println(b.getnameteam2()+" " +"lanceiro(" + b.getLancer2().isVivo() +") " + b.getLancer2().getxSol() + " " + b.getLancer2().getySol());
					break;
			
					
				case SUL:
					String output1 =b.Walk(b.getLancer2(), Soldier.SUL);
					if(!output1.equals(""))
						System.out.println(output1);
					System.out.println(b.getnameteam2()+" " +"lanceiro(" + b.getLancer2().isVivo() +") " + b.getLancer2().getxSol() + " " + b.getLancer2().getySol());
					break;
					
				case OESTE:
					String output2 =b.Walk(b.getLancer2(), Soldier.OESTE);
					if(!output2.equals(""))
						System.out.println(output2);
					System.out.println(b.getnameteam2()+" " +"lanceiro(" + b.getLancer2().isVivo() +") " + b.getLancer2().getxSol() + " " + b.getLancer2().getySol());
					break;
					
				case ESTE:
					String output3 =b.Walk(b.getLancer2(), Soldier.ESTE);
					if(!output3.equals(""))
						System.out.println(output3);
					System.out.println(b.getnameteam2()+" " +"lanceiro(" + b.getLancer2().isVivo() +") " + b.getLancer2().getxSol() + " " + b.getLancer2().getySol());
					break;
				}
			
				b.incCOUNTER();
			
			
			}
			else {
				
				

					direction = in.next();
					
					switch (direction) {
					
					case NORTE:
						String output = b.Walk(b.getLancer1(), Soldier.NORTE);
						if(!output.equals(""))
							System.out.println(output);
						System.out.println(b.getnameteam1()+" " +"lanceiro(" + b.getLancer1().isVivo() +") " + b.getLancer1().getxSol() + " " + b.getLancer1().getySol());
						
						break;
						
					case SUL:
						String output1 =b.Walk(b.getLancer1(), Soldier.SUL);
						if(!output1.equals(""))
							System.out.println(output1);
						System.out.println(b.getnameteam1()+" " +"lanceiro(" + b.getLancer1().isVivo() +") " + b.getLancer1().getxSol() + " " + b.getLancer1().getySol());
						
						break;
					case OESTE:
						String output2 =b.Walk(b.getLancer1(), Soldier.OESTE);
						if(!output2.equals(""))
								System.out.println(output2);
							System.out.println(b.getnameteam1()+" " +"lanceiro(" + b.getLancer1().isVivo() +") " + b.getLancer1().getxSol() + " " + b.getLancer1().getySol());
						
						break;
					case ESTE:
						String output3 =b.Walk(b.getLancer1(), Soldier.ESTE);
						if(!output3.equals(""))
							System.out.println(output3);
						System.out.println(b.getnameteam1()+" " +"lanceiro(" + b.getLancer1().isVivo() +") " + b.getLancer1().getxSol() + " " + b.getLancer1().getySol());
						
						break;
					}
					b.incCOUNTER();
					
				
			}
		}
		else {System.out.println("Comando inactivo.");}
	}
}
		
		
	
	
		
	


	

