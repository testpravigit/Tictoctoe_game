package ticTocToe;


import java.util.Random;
import java.util.Scanner;

class TicTocToe{
	static char[][] board;
	public TicTocToe() {
	board=new char[3][3];
		initBoard();
	}
	
    public void initBoard() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				board[i][j]=' ';
			}
		}
	}
    
    
	public static void dispBoard() {
		System.out.println(" -------------");
		for(int i=0;i<3;i++) {
			System.out.print(" | ");
			for(int j=0;j<3;j++) {
				System.out.print(board[i][j]+" | ");
			}
			System.out.println();
			System.out.print(" -------------");
			System.out.println();
			
		}
	
}
	
	
	
	public static  void placeMark(int row,int col,char mark) {
		if(row>=0 && row<=2 && col>=0 && col<=2) {
			board[row][col]=mark;
		}
		else {
			System.out.println("Invalid input...");
		}
		
	}
	
	
	public  static boolean colWin() {
		for(int j=0;j<3;j++) {
			if( board[0][j]!=' ' && board[0][j]==board[1][j]&& board[1][j]==board[2][j]) {
				return true;
			}
		}
		return false;
	}
	
	
	
	public static  boolean rowWin() {
		for(int i=0;i<3;i++) {
			if( board[i][0]!=' ' && board[i][0]==board[i][1]&& board[i][1]==board[i][2]) {
				return true;
			}
		}
		return false;
	}
	
	
	
	public  static boolean diagWin() {
		
			if((board[0][0]!=' '  && board[0][0]==board[1][1]&& board[1][1]==board[2][2])||  board[0][2]!=' '&&(board[0][2]==board[1][1]&& board[1][1]==board[2][0])) {
				return true;
			}
		
		return false;
	}
	public static boolean checkDraw() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(board[i][j]==' ') {
					return false;
				}
				
			}
		}
		
		return true;
	}
}

abstract class Player{
	char mark;
	String name;
	public abstract void makeMove();
	
	public boolean isValid(int row,int col) {
		if(row>=0 && row<=2 && col>=0 && col<=2){
			if(TicTocToe.board[row][col]==' ') {
				return true;
			}
		}
		return false;
	}
	
}



class HumanPlayer extends Player{
	
	
	HumanPlayer(String name,char mark){
		this.name=name;
		this.mark=mark;
	}
	@Override
	public  void makeMove(){
		int row;
		int col;
		do {
			Scanner sc=new Scanner(System.in);
			row=sc.nextInt();
			col=sc.nextInt();
		}while(!(isValid(row,col)));
		TicTocToe.placeMark(row,col,mark);
		
		
		
		
		
		
	}
	
	
	

	
	
}
class AIplayer extends Player{
	
	
	AIplayer(String name,char mark){
		this.name=name;
		this.mark=mark;
	}
	public  void makeMove(){
		int row;
		int col;
		do {
			Scanner sc=new Scanner(System.in);
			Random r=new Random();
			row=r.nextInt(3);
			col=r.nextInt(3);
		}while(!(isValid(row,col)));
		TicTocToe.placeMark(row,col,mark);
		
		
		
		
		
		
	}
	
	
	
	public boolean isValid(int row,int col) {
		if(row>=0 && row<=2 && col>=0 && col<=2){
			if(TicTocToe.board[row][col]==' ') {
				return true;
			}
		}
		return false;
	}
	
	
}


public class LaunchGame {

	public static void main(String[] args) {
    TicTocToe game= new TicTocToe();
    game.dispBoard();
    System.out.println("game begins");
     
//    HumanPlayer p1=new HumanPlayer("praveen", 'o');
//    HumanPlayer p2=new HumanPlayer("ramesh", 'x');
    Player p1=new HumanPlayer("praveen", 'o');
    Player p2=new AIplayer("PAI", 'x');
    
    Player cp;
    cp=p1;
    
   while(true) {
	   System.out.println(cp.name+" "+" turn");
	    cp.makeMove();
	    TicTocToe.dispBoard();
	    if(TicTocToe.rowWin()||TicTocToe.colWin()||TicTocToe.diagWin()) {
	    	System.out.println(cp.name+" " +"won");
	    	break;
	    }
	    else if(TicTocToe.checkDraw()) {
	    	System.out.println("game drwan");
	    	break;
	    	
	    }
	    else {
	    	if(cp==p1) {
	    		cp=p2;
	    	}
	    	else {
	    		cp=p1;
	    	}
	    }
   }
    
    
    
     
     
     
		
		
	
	

	}
}


