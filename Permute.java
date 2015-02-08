import java.util.Scanner;



public class Permute {
	
	public static Long getSum(Long n){
		
		Long sum = n*(n+1L)/2L;

		if(sum>1){

		sum -= ((n-1L)/2L +2L);

		}

		return sum;
		
	}

	public static void main(String[] args) {
		Scanner br =new Scanner(System.in);
		int testCasesCount = br.nextInt();
		
		while(testCasesCount>0){
			System.out.println(getSum(br.nextLong()));
			testCasesCount--;
		}
		
	}

}
