
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner in = new Scanner(System.in);
		BoardGame b = null;
		
		processmenu(b,in);
		in.close();
		//System.out.println(b.getxmap ());
		//System.out.println(b.getymap());
		
	}

	
	
	
	private static final String SAI="sai";
	private static final String NOVO="novo";
	private static final String AJUDA="ajuda";
	private static final String MAPA="mapa";
	private static final String CAVALEIRO="cavaleiro";
	private static final String NORTE="norte";
	private static final String SUL="sul";
	private static final String OESTE="oeste";
	private static final String ESTE="este";
	private static int COUNTERMENU=0;  // para saber qual a equipa, e qual o menu a mostar
	
	private static void showmenu(BoardGame b) {
		
		
		if (COUNTERMENU==0) {
		System.out.println("novo - Novo jogo");
		System.out.println("ajuda - Mostra a ajuda");
		System.out.println("sai – Termina a execucao do programa");}
		else if (COUNTERMENU>0) {
			System.out.println("novo - Novo jogo");
			System.out.println("mapa - Mostra o mapa");
			System.out.println("cavaleiro - Move o cavaleiro");
			System.out.println("espadachim - Move o espadachim");
			System.out.println("lanceiro - Move o lanceiro");
			System.out.println("ajuda - Mostra a ajuda");
			System.out.println("sai – Termina a execucao do programa");}
			

		}
		

	
	
	private static void processmenu (BoardGame b ,Scanner in) {
		String op = "";
		
		showmenu(b);
		
		String team="";
		while (!op.equals("sai")) {
		if (COUNTERMENU>0)
			if (COUNTERMENU %2==0)
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
			
			
			
			
			default: System.out.println("Opcao inexistente.");
				
			
			
			
			
		}
		
	}}
	
	private static BoardGame newgame(BoardGame b , Scanner in) {
		BoardGame result = null;
		int xmap;
		int ymap;
		String team1;
		String team2;
		int ybandeira1;
		int xbandeira1;
		int xbandeira2;
		int ybandeira2;
		xmap=in.nextInt();  // le o x do mapa
		ymap=in.nextInt(); // le o y do mapa
		in.nextLine();
		team1=in.next();   // le o nome da equipa1
		xbandeira1=in.nextInt();  //le o x da bandeira da equipa1
		ybandeira1=in.nextInt();  // leo o y da bandeira da equipa1	
		in.nextLine();
		team2=in.next();  // le o nome da equipa2
		xbandeira2=in.nextInt();  // le o x da bandeira da equipa2
		ybandeira2=in.nextInt();  // le o y da bandeira da equipa2 // 
		// o mapa de jogo tem de ser no minimo 10x10
		boolean success = true;
		if (xmap<10 || ymap<10) {
			System.out.println("Mapa pequeno demais para o jogo.");
			success = false;
		}
		// a bandeira nao pode ser colocada fora do mapa ou na fronteira
		else {
			if (xbandeira1>=xmap || xbandeira1<2 || ybandeira1>=ymap || ybandeira1<2) {
				System.out.println(team1 + " bandeira em posicao invalida " + xbandeira1 + " "+ ybandeira1+ ".");
				success=false;}

			if(xbandeira2>=xmap || xbandeira2<2 || ybandeira2>=ymap || ybandeira2<2) {
				System.out.println(team2 + " bandeira em posicao invalida " + xbandeira2 + " "+ ybandeira2+ ".");
				success=false;
			}
			else if (team1.equals(team2) && success) {
				System.out.println("As equipas nao podem ter o mesmo nome.");
				success=false;}
			// as bandeira tem de estar a uma distancia superior a 5
			else if ((Math.abs(xbandeira1-xbandeira2)+Math.abs(ybandeira1-ybandeira2))<=5 && success) {
				System.out.println(team2 + " bandeira em posicao invalida " + xbandeira2 + " "+ ybandeira2+ ".");
				success=false;}
			else {
				result = new BoardGame (xmap,ymap,team1,team2, xbandeira1, ybandeira1, xbandeira2, ybandeira2);
				COUNTERMENU ++;
				System.out.println ("Jogo iniciado, começa a equipa " + result.getnameteam1());

			}
		}
		return result;
			
			
		// as equipas nao podem ter o mesmo nome
		} 
		
			
		
	
	
	
	private static void processMap(BoardGame b) {
		if (COUNTERMENU==0) {
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
		if (COUNTERMENU>0) {
			if (COUNTERMENU %2 ==0) {
				
			
			direction = in.next();
			
			while (counter<3) {
				
				switch (direction) {
				
				case NORTE:
					
			
					
				case SUL:
					
				case OESTE:
					
				case ESTE:
				}
			}
			
			}
			else {
				
				while (counter<3) {
					
					switch (direction) {
					
					case NORTE:
				
						
					case SUL:
						
					case OESTE:
						
					case ESTE:
					}
				}
				
				
			}
		}
		else {System.out.println("Comando inactivo.");}
	}}
		
		
	
	
		
	


	

