


public class KMPStringMatching {
	
	public int[] getAuxillaryFunction(String pattern){
		int m = pattern.length();
		int[] aux = new int[m+1];
		
		//init
		aux[0] = 0;
		aux[1] = 0;
		
		int k=0;
		
		for(int q=1; q<m; q++){
			while(k>0 && pattern.charAt(k+1)!=pattern.charAt(q)){
				q = aux[q];
			}
			
			if(pattern.charAt(k+1)==pattern.charAt(q)){
				k++;
			}
			
			aux[q+1] = k;
		}
		
		return aux;
	}
	
	public void stringMatch(String text, String pattern){
		int n = text.length();
		int m = pattern.length();
		int[] auxFunc = getAuxillaryFunction(pattern);
		
		int q=0;
		
		for(int s=0; s<n; s++){
			while(q>0 && pattern.charAt(q)!=text.charAt(s)){
				q = auxFunc[q];
			}
			
			if(pattern.charAt(q)==text.charAt(s)){
				q++;
			}
			
			if(q==m){
				System.out.println("Pattern Found at position"+(s-m+1));
				q=auxFunc[q];
			}
		}
		
	}
	
	public static void main(String[] args) {
		String T = "HimanshuGoelIsWorkingInMinjarHimanshuGoelIsReadingAlgoDSUditBhatiaIsAccompanyingHim";
		String P = "HimanshuGoel";
		
		KMPStringMatching obj = new KMPStringMatching();
		obj.stringMatch(T, P);
		
	}
}
