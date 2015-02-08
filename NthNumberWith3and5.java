import java.util.Scanner;


class NthNumberWith3and5{
	
	public static int getNthNumber(int n){
		if(n==1)
			return 3;
		if(n==2)
			return 5;
		
		if(n%2==0){
			return getNthNumber((n-2)/2)*10+5;
		}else{
			return getNthNumber((n-1)/2)*10+3;
		}
	}
	
	public static void main(String[] args) {

		Scanner br = new Scanner(System.in);
		int nthNumber = br.nextInt();
		
		System.out.println(getNthNumber(nthNumber));
	}
	
}