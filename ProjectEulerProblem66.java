import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class ProjectEulerProblem66 {


	public Map<Integer, Integer> XValueForD;
	
	public Map<Long, Boolean> isPerfectSquareMap;
	
	public ProjectEulerProblem66(){
		isPerfectSquareMap = new HashMap<Long, Boolean>();
		XValueForD = new TreeMap<Integer, Integer>();
	}
	
	public int getMinimalDForLargsetX(int D){
		
		Integer largestX = null;
		for(int i=2; i<=D; i++){
			if(!isPerfectSquare(i)){
				int xValue = getLargestXValueForD(i);
				
				System.out.println(i+"->"+xValue);
				
				if(largestX==null || largestX < xValue){
					largestX = xValue;
				}
				XValueForD.put(xValue, i);
			}
		}
		
		return XValueForD.get(largestX);
	}
	
	public int getLargestXValueForD(int D){
		boolean isXPerfectSquare = false;
		
		long y=0;
		while(!isXPerfectSquare){
			y++;
			isXPerfectSquare = isPerfectSquare(1+D*y*y);
		}
		
		return (int) Math.pow(1+D*y*y, 0.5);
	}
	
	public boolean isPerfectSquare(long num){
		double temp = Math.pow(num, 0.5);
		return !( (temp - (int)temp) > 0);
	}
	
	public static void main(String[] args) {
		Scanner br = new Scanner(System.in);
		int N = br.nextInt();
		
		ProjectEulerProblem66 obj = new ProjectEulerProblem66();
		
		System.out.println(obj.getMinimalDForLargsetX(N));
		
	}
	
	
}
