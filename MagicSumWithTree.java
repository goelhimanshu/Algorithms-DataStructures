import java.util.Scanner;


public class MagicSumWithTree {
	
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
        	
        	TreeNode root = buildTreeFromArray(arr, caseArraySize, 0);
        	
        	getMaxSum(root);
        	
        	System.out.println(magicSum);
        }
	}
	
	public static int getMaxSum(TreeNode node){
		if(node==null)
			return 0;
		
		if(node.lChild==null){
			if(magicSum<node.val){
				magicSum = node.val;
			}
			return node.val;
		}
		
		int leftMax = getMaxSum(node.lChild);
		
		if(node.rChild!=null){
			int rightMax = getMaxSum(node.rChild);
			
			if(node.val+leftMax+rightMax>magicSum)
				magicSum = node.val+leftMax+rightMax;
			
			return (leftMax>rightMax)?node.val+leftMax:node.val+rightMax;
		}
		
		return node.val+leftMax;
	}
	
	public static TreeNode buildTreeFromArray(int[] arr, int size, int index){
		TreeNode root = null;
		
		if(index<size){
			root = new TreeNode(arr[index], null, null);
			root.lChild = buildTreeFromArray(arr, size, 2*index+1);
			root.rChild = buildTreeFromArray(arr, size, 2*index+2);
		}
		
		return root;
	}
}

class TreeNode {
	
	int val;
	TreeNode lChild;
	TreeNode rChild;
	
	public TreeNode(int val, TreeNode lChild, TreeNode rChild) {
		super();
		this.val=val;
		this.lChild=lChild;
		this.rChild=rChild;
	}
	
}
