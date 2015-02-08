import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class ProjectEulerProblem67 {

	public int[][] triangle;
	
	public int triangleSize;
	
	public Map<String, Integer> computedValues;
	
	public ProjectEulerProblem67(){}
	
	public ProjectEulerProblem67(int triangleSize){
		this.triangleSize = triangleSize;
		this.triangle = new int[this.triangleSize][this.triangleSize];
		this.computedValues = new HashMap<String, Integer>();
	}
	
	public static void main(String[] args) {
		Scanner br = new Scanner(System.in);
		int testCasesCount = br.nextInt();
		
		ProjectEulerProblem67 obj;
		
		while(testCasesCount>0){
			
			obj = new ProjectEulerProblem67(br.nextInt());
			for(int i=0; i<obj.triangleSize; i++){
				for(int j=0; j<=i; j++){
					obj.triangle[i][j]=br.nextInt();
				}
			}
			
			// pass triangle to function for computing max sumpath
			System.out.println(obj.getMaxSumPath(0, 0));
			testCasesCount--;
		}
	}
	
	public int getMaxSumPath(int rootRow, int rootColumn){
		
		int maxSumpath = triangle[rootRow][rootColumn];
		
		if(computedValues.containsKey(rootRow+","+rootColumn)){
			return computedValues.get(rootRow+","+rootColumn);
		}
		
		if(!isLeafNode(rootRow, rootColumn)){
			int leftMaxSumpath = getMaxSumPath(rootRow+1, rootColumn);
			int rightMaxSumpath = getMaxSumPath(rootRow+1, rootColumn+1);
			
			maxSumpath += (leftMaxSumpath>rightMaxSumpath?leftMaxSumpath:rightMaxSumpath);
		}
		
		computedValues.put(rootRow+","+rootColumn, maxSumpath);
		
		return maxSumpath;
	}
	
	public boolean isLeafNode(int row, int column){
		return !((row>column?row:column)<(triangleSize-1));
	}
}
