import java.util.HashSet;
import java.util.Set;


public class RabinKarp {
	
	public int q = 13;
	public String T = "HimanshuGoelIsWorkingInMinjarHimanshuGoelIsReadingAlgoDSUditBhatiaIsAccompanyingHim";
	public String P = "HimanshuGoel";
	
	public void MatchPattern(String Text, String Pattern, int radix, int modulusFactor){
		int n,m,h;
		int p=0;
		int t = 0;
		int ts2 = 0;
		if(Text!=null){
			n = Text.length();
			if(n>0){
				m = Pattern.length();
				if(m>0){
					h=((int) Math.pow(radix, m-1))%modulusFactor;
					
					for(int i=0; i<m; i++){
						p = (radix*p + Pattern.charAt(i))%modulusFactor;
						t = (radix*t + Text.charAt(i))%modulusFactor;
					}
					
					for(int i=0; i<n-m+1; i++){
						if(p==t){
							boolean isMatching = true;
							int j=0;
							while(isMatching && j<m){
								if(Pattern.charAt(j)!=Text.charAt(i+j)){
									isMatching=false;
								}
								j++;
							}
							if(isMatching){
								System.out.println("Shift "+(i)+" is a valid shift.");
							}
						}
						if(i<n-m){
							t = (radix*(t - (Text.charAt(i))*h) + (Text.charAt(i+m)))%modulusFactor;
							if(t<0){
								t+=q;
							}
						}
						
					}
					
				}else{
					System.out.println("Empty Pattern");
				}
			}else{
				System.out.println("Empty Text");
			}
		}
	}
	
	public static void main(String[] args) {
		RabinKarp obj = new RabinKarp();
		Set<Character> alphabets = new HashSet<Character>();
		for(int i=0; i<obj.T.length(); i++){
			alphabets.add(obj.T.charAt(i));
		}
		
		obj.MatchPattern(obj.T, obj.P, 256, obj.q);
	}
}
