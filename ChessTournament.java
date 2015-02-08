import java.util.Scanner;



public class ChessTournament {

	public static int playerRecord[][];
	
	public static int getWinner(int[] players){
		int matches = players.length/2;
		
		int[] winningPlayers = new int[matches];
		
		for(int i=1; i<= matches; i++){
			int player1 = players[2*(i-1)];
			int player2 = players[2*(i-1)+1];
			
			int winningPlayer = player1;
			if(player1<player2){
				winningPlayer = playerRecord[player2-1][player1-1]==0?player1:player2;
			}else{
				winningPlayer = playerRecord[player1-1][player2-1]==1?player1:player2;
			}
				
			winningPlayers[i-1] = winningPlayer;
		}
		
		if(matches!=1){
			return getWinner(winningPlayers);
		}
		
		return winningPlayers[0];
	}
	
	public static void main(String[] args) {

		Scanner br = new Scanner(System.in);
		int n = br.nextInt();
		
		int playersCount = 1;
		
		for(int i=0; i<n; i++){
			playersCount *= 2;
		}
		
		int[] players = new int[playersCount];
		for(int i=1; i<=playersCount; i++){
			players[i-1] = i;
		}
		
		playerRecord = new int[playersCount][playersCount];
		
		for (int i = 1; i <= playersCount-1; i++) {
			for(int j=0; j<i; j++){
				playerRecord[i][j]=br.nextInt();
			}
		}
		
		System.out.println(getWinner(players));
		
	}
}
