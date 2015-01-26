import java.util.Scanner;


public class InversionArray {

	public static void main(String args[] ) throws Exception {
        
		Scanner br = new Scanner(System.in);
        int arraySize = br.nextInt();
        
        int a[] = new int[arraySize];
        int b[] = new int[arraySize];
        
        for(int i=0; i<arraySize; i++){
        	a[i] = br.nextInt();        	
        }

        for(int i=0; i<arraySize; i++){
        	b[i] = br.nextInt();        	
        }
        
        int pairCount=0;
        
        for(int i=0; i<arraySize; i++){
        	for(int j=i+1; j<arraySize; j++){
        		if(a[i]>b[j]){
        			pairCount++;
        		}
        	}
        }
        
        System.out.println(pairCount);

	}
}
