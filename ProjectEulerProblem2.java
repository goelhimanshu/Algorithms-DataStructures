import java.util.Scanner;


public class ProjectEulerProblem2 {
	
	public int sum;
	
	public ProjectEulerProblem2() {
		sum=0;
	}

	public static void main(String[] args) {
		Scanner br = new Scanner(System.in);
		int testCaseCount = br.nextInt();
		ProjectEulerProblem2 obj;
		while(testCaseCount>0){
			int n = br.nextInt();
			obj = new ProjectEulerProblem2();
			obj.getFibonacci(n);
			System.out.println(obj.sum);
			testCaseCount--;
		}
	}
	
	public int getFibonacci(int n){
		if(n==1){
			return 1;
		}else if(n==2){
			this.sum += 2; 
			return 2;
		}else{
			int value = getFibonacci(n-1)+getFibonacci(n-2);
			if(value%2==0){
				this.sum += value; 
			}
			return value;
		}
	}
}
