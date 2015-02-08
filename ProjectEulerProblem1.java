import java.util.Scanner;


public class ProjectEulerProblem1 {
	
	public static void main(String[] args) {
		Scanner br = new Scanner(System.in);
		int testCasesCount = br.nextInt();
		while(testCasesCount>0){
			long n = br.nextInt();
			System.out.println(getMultiplesSum(n-1, 3)+getMultiplesSum(n-1, 5)-getMultiplesSum(n-1, 15));
			testCasesCount--;
		}
	}
	
	public static long getMultiplesSum(long n, int factor){
		long multipleCount = n/factor;
		return factor*(multipleCount*(multipleCount+1)/2);
	}

}
