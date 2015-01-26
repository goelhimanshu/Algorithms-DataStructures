import java.util.Scanner;


public class MagicSumWithoutTree {

    public static int magicSum;
	
	public static void main(String args[] ) throws Exception {
        
		Scanner br = new Scanner(System.in);
        int testCasesCount = br.nextInt();
        
        for(int i=0; i<testCasesCount; i++){
        	int caseArraySize = br.nextInt();
        	int[] arr= new int[caseArraySize];
        	
        	int tempCount =0;
        	
        	while(tempCount<caseArraySize){
        		arr[tempCount]=br.nextInt();
        		tempCount++;
        	}
        	
        	magicSum=arr[caseArraySize-1];
        	        	
        	if(caseArraySize>0)
	        	getMaxSum(arr, caseArraySize, 0);
        	
        	System.out.println(magicSum);
        }
	}
	
	public static int getMaxSum(int[] arr, int size, int index){
		if(index>=size)
			return 0;
		
		if(2*index+1>=size){
			if(magicSum<arr[index]){
				magicSum = arr[index];
			}
			return arr[index];
		}
		
		int leftMax = getMaxSum(arr,size, 2*index+1);
		
		if(2*index+2<size){
			int rightMax = getMaxSum(arr,size, 2*index+2);
			
			if(arr[index]+leftMax+rightMax>magicSum)
				magicSum = arr[index]+leftMax+rightMax;
			
			return (leftMax>rightMax)?arr[index]+leftMax:arr[index]+rightMax;
		}
		
		return arr[index]+leftMax;
	}
	
}
