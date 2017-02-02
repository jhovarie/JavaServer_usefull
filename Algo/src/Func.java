
public class Func {
	
	public static int getNumPos(String pschs){
		return Integer.parseInt(""+pschs.charAt(2));
	}
	
	public static int getNumFromCharPos(String pschs){
		char c = pschs.charAt(0);
		int result = 1;
		if(c == 'b'){
			result = 2;
		}
		if(c == 'c'){
			result = 3;
		}
		if(c == 'd'){
			result = 4;
		}
		if(c == 'e'){
			result = 5;
		}
		if(c == 'f'){
			result = 6;
		}
		if(c == 'g'){
			result = 7;
		}
		if(c == 'h'){
			result = 8;
		}
		return result;
	}
	
}
