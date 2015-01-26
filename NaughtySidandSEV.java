import java.util.Scanner;


public class NaughtySidandSEV {

	public static final double degreeToRadianFactor = 3.141593/180;
	
	public static void main(String args[] ) throws Exception {
        
		Scanner br = new Scanner(System.in);
        int testCasesCount = br.nextInt();
        
        for(int i=0; i<testCasesCount; i++){
        	int edgeSize = br.nextInt();
        	int HSize = br.nextInt();
        	int angle = br.nextInt();
        	
            int result = HSize - (int)(edgeSize*Math.tan(angle*degreeToRadianFactor)/2);

            System.out.println(result);
        }
        
	}
}
