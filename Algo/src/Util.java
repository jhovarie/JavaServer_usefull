import java.util.ArrayList;

public class Util {
	
	private static ArrayList <String> updown = new ArrayList<String>(); 
	private static ArrayList <String> leftright = new ArrayList<String>(); 
	
	public static void getPostion (String ss, int len){
		int x = Func.getNumFromCharPos(ss);
		int y = Func.getNumPos(ss);
		int counter = -1;
		char leter = 'a'-1;
		int number = 8;
	    for(int i = 0; i < len; i ++) {
	    	counter++;
	    	leter+=1;
	    	if(counter == 8){
	    		counter = 0;
	    		leter = 'a';
	    		number--;
	    		System.out.println();
	    		System.out.println();
	    		//System.out.println();
	    	}
	    	if(counter + 1 == x && y == number) {
	    		System.out.print("["+leter+":"+number+"]\t");
	    	} else {
	    		System.out.print(leter+":"+number+"\t");
	    	}
	    }
	}
	
	public static void getRookPostion (String ss, int len, String []chessboardpiece, String []chessboardletnum) {
		updown.clear();
		int x = Func.getNumFromCharPos(ss);
		int y = Func.getNumPos(ss);
		int counter = -1;
		char leter = 'a'-1;
		int number = 8;
	    for(int i = 0; i < len; i ++) {
	    	counter++;
	    	leter+=1;
	    	if(counter == 8){
	    		counter = 0;
	    		leter = 'a';
	    		number--;
	    		System.out.println();
	    		System.out.println();
	    		//System.out.println();
	    	}
	    	if(counter + 1 == x && y == number) {
	    		final String piececurrentlocation = ">"+leter+":"+number+"<\t";
	    		System.out.print(piececurrentlocation);
	    		updown.add(piececurrentlocation);
	    		leftright.add(piececurrentlocation);
	    	} else if(counter + 1 == x &&  y != number) { //up down
	    		final String piececanmoveat = "["+leter+":"+number+"]\t";
	    		System.out.print(piececanmoveat);
	    		updown.add(piececanmoveat);
	    	} else if(counter + 1 !=x && y == number) { //left right
	    		final String piececanmoveat = "["+leter+":"+number+"]\t";
	    		System.out.print(piececanmoveat);
	    		leftright.add(piececanmoveat);
	    	} else {
	    		System.out.print(""+leter+":"+number+"\t");
	    	}
	    }
	    
	    System.out.println("\n\nCan move Updown -----------------------------------------------\n");
	    for(int i = 0; i < updown.size();i++) {
	    	System.out.print(updown.get(i)+" ");
	    }
	    
	    System.out.println("\n\nCan move LeftRight -----------------------------------------------\n");
	    for(int i = 0; i < leftright.size();i++) {
	    	System.out.print(leftright.get(i)+" ");
	    }
    }	
	
	public static void getBishopPostion (String ss, int len) {
		int x = Func.getNumFromCharPos(ss);
		int y = Func.getNumPos(ss);
		int counter = -1;
		char leter = 'a'-1;
		int number = 8;
	    for(int i = 1; i <= len; i ++) {
	    	counter++;
	    	leter+=1;
	    	if(counter == 8){
	    		counter = 0;
	    		leter = 'a';
	    		number--;
	    		System.out.println();
	    		System.out.println();
	    		//System.out.println();
	    	}
	    	if(counter + 1 == x && y == number) {
	    		System.out.print("["+leter+":"+number+"]\t");
	    	} else if(counter + 1 != x && y != number) { //X move
	    		//int looptoleft = x;
	    		//int looptoright = 8 - x;
	    		boolean hasequal = false;
	    		for(int i2 = 0; i2 < 8; i2++) {
	    			if(counter + 1 == x + i2 && number == y + i2) {
	    				System.out.print(">"+leter+":"+number+"<\t");
	    				hasequal = true;
	    			}
	    			if(counter + 1 == x + i2 && number == y - i2) {
	    				System.out.print(">"+leter+":"+number+"<\t");
	    				hasequal = true;
	    			}
	    			if(counter + 1 == x - i2 && number == y - i2) {
	    				System.out.print(">"+leter+":"+number+"<\t");
	    				hasequal = true;
	    			}
	    			if(counter + 1 == x - i2 && number == y + i2) {
	    				System.out.print(">"+leter+":"+number+"<\t");
	    				hasequal = true;
	    			}
	    		}
	    		if(hasequal == false) {
	    			System.out.print(leter+":"+number+"\t");
	    		}
	    	} else {
	    		System.out.print(leter+":"+number+"\t");
	    	}
	    }
	}	
	
	public static void getQueenPostion (String ss, int len) {
		int x = Func.getNumFromCharPos(ss);
		int y = Func.getNumPos(ss);
		int counter = -1;
		char leter = 'a'-1;
		int number = 8;
	    for(int i = 1; i <= len; i ++) {
	    	counter++;
	    	leter+=1;
	    	if(counter == 8){
	    		counter = 0;
	    		leter = 'a';
	    		number--;
	    		System.out.println();
	    		System.out.println();
	    	}
	    	if(counter + 1 == x && y == number) {
	    		System.out.print("["+leter+":"+number+"]\t");
	    	}  else if(counter + 1 == x) { //Cross move
	    		if( y != number) {
	    		    System.out.print(">"+leter+":"+number+"<\t");
	    		} else {
	    			System.out.print(leter+":"+number+"\t");
	    		}
	    	} else if(counter + 1 !=x && y == number) {
	    		System.out.print(">"+leter+":"+number+"<\t");
	    	} else if(counter + 1 != x && y != number) { //X move
	    		boolean hasequal = false;
	    		for(int i2 = 0; i2 < 8; i2++) {
	    			if(counter + 1 == x + i2 && number == y + i2) {
	    				System.out.print(">"+leter+":"+number+"<\t");
	    				hasequal = true;
	    			}
	    			if(counter + 1 == x + i2 && number == y - i2) {
	    				System.out.print(">"+leter+":"+number+"<\t");
	    				hasequal = true;
	    			}
	    			if(counter + 1 == x - i2 && number == y - i2) {
	    				System.out.print(">"+leter+":"+number+"<\t");
	    				hasequal = true;
	    			}
	    			if(counter + 1 == x - i2 && number == y + i2) {
	    				System.out.print(">"+leter+":"+number+"<\t");
	    				hasequal = true;
	    			}
	    		}
	    		if(hasequal == false) {
	    			System.out.print(leter+":"+number+"\t");
	    		}
	    	} else {
	    		System.out.print(leter+":"+number+"\t");
	    	}
	    }
	}	
	
	public static void getKingPostion (String ss, int len) {
		int x = Func.getNumFromCharPos(ss);
		int y = Func.getNumPos(ss);
		int counter = -1;
		char leter = 'a'-1;
		int number = 8;
	    for(int i = 1; i <= len; i ++) {
	    	counter++;
	    	leter+=1;
	    	if(counter == 8){
	    		counter = 0;
	    		leter = 'a';
	    		number--;
	    		System.out.println();
	    		System.out.println();
	    	}
	    	if(counter + 1 == x && y == number) {
	    		System.out.print("["+leter+":"+number+"]\t");
	    	}  else if(counter + 1 == x && y != number) { //Cross move
	    		if(y == number + 1) {
	    			System.out.print(">"+leter+":"+number+"<\t");
	    		} else if(y == number - 1) {
	    			System.out.print(">"+leter+":"+number+"<\t");
	    		} else {
	    			System.out.print(leter+":"+number+"\t");
	    		}
	    	} else if(counter + 1 !=x && y == number) {
	    		if(counter + 1 == x + 1) {
	    			System.out.print(">"+leter+":"+number+"<\t");
	    		}else if(counter + 1 == x - 1) {
	    			System.out.print(">"+leter+":"+number+"<\t");
	    		} else {
	    			System.out.print(leter+":"+number+"\t");
	    		}
	    	} else if(counter + 1 != x && y != number) { //X move
	    		boolean hasequal = false;
	    		int i2 = 1;
	    		if(counter + 1 == x + i2 && number == y + i2) {
    				System.out.print(">"+leter+":"+number+"<\t");
    				hasequal = true;
    			}
    			if(counter + 1 == x + i2 && number == y - i2) {
    				System.out.print(">"+leter+":"+number+"<\t");
    				hasequal = true;
    			}
    			if(counter + 1 == x - i2 && number == y - i2) {
    				System.out.print(">"+leter+":"+number+"<\t");
    				hasequal = true;
    			}
    			if(counter + 1 == x - i2 && number == y + i2) {
    				System.out.print(">"+leter+":"+number+"<\t");
    				hasequal = true;
    			}
	    		if(hasequal == false) {
	    			System.out.print(leter+":"+number+"\t");
	    		}
	    	} else {
	    		System.out.print(leter+":"+number+"\t");
	    	}
	    }
	}
	
	public static void getHorsePostion (String ss, int len) {
		int x = Func.getNumFromCharPos(ss);
		int y = Func.getNumPos(ss);
		int counter = -1;
		char leter = 'a'-1;
		int number = 8;
	    for(int i = 1; i <= len; i ++) {
	    	counter++;
	    	leter+=1;
	    	if(counter == 8){
	    		counter = 0;
	    		leter = 'a';
	    		number--;
	    		System.out.println();
	    		System.out.println();
	    	}
	    	if(counter + 1 == x && y == number) {
	    		System.out.print("["+leter+":"+number+"]\t");
	    	}else if(counter + 1 == x + 1 && y == number - 2) {
	    		System.out.print(">"+leter+":"+number+"<\t");
	    	}else if(counter + 1 == x + 2 && y == number - 1) {
	    		System.out.print(">"+leter+":"+number+"<\t");
	    	}else if(counter + 1 == x + 2 && y == number + 1) {
	    		System.out.print(">"+leter+":"+number+"<\t");
	    	}else if(counter + 1 == x + 1 && y == number + 2) {
	    		System.out.print(">"+leter+":"+number+"<\t");
	    	}
	    	else if(counter + 1 == x - 1 && y == number + 2) {
	    		System.out.print(">"+leter+":"+number+"<\t");
	    	}else if(counter + 1 == x - 2 && y == number + 1) {
	    		System.out.print(">"+leter+":"+number+"<\t");
	    	}else if(counter + 1 == x - 2 && y == number - 1) {
	    		System.out.print(">"+leter+":"+number+"<\t");
	    	}else if(counter + 1 == x - 1 && y == number - 2) {
	    		System.out.print(">"+leter+":"+number+"<\t");
	    	}
	    	else {
	    		System.out.print(leter+":"+number+"\t");
	    	}
	    }
	}	
	
	public static void solver(String ss, int len, String []chessboard,
			String []chessboard2){
		System.out.println("solver ");
		for(int i2=0;i2< chessboard2.length;i2++){
			if(chessboard[i2].equals("x")) {
				System.out.println(" "+chessboard2[i2]);
			}
		}
	}
}
