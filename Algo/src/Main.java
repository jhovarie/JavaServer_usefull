
public class Main {
	
	final int len = 8 * 8;
	public static void main(String[]args) {
	    Main m = new Main();
	    m.boardgame();
	}
 
	public void boardgame() {		
		String chessboardpiece[] = new String[len]; 
		String chessboardletnum[] = new String[len]; 
	    //System.out.println(chessboard.length);
		//System.out.println(ss.charAt(0));
		//System.out.println(ss.charAt(2));
		String ss = "b:4";
		String ss2 = "g:4";
		int x = Func.getNumFromCharPos(ss);
		int y = Func.getNumPos(ss);
		int x2 = Func.getNumFromCharPos(ss2);
		int y2 = Func.getNumPos(ss2);
		System.out.println("\nbarier.."+ss+"--------------------------------------------\n");
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
	    	}
	    	chessboardletnum[i] = leter+":"+number+"";
	    	if(counter + 1 == x && number == y) {
	    		chessboardpiece[i] = "x";
	    	}else if(counter + 1 == x2 && number == y2) {
	    		chessboardpiece[i] = "x";
	    	}
	    	else {
	    		chessboardpiece[i] = "0";
	    	}
	    	System.out.print(chessboardpiece[i] +" ");
	    }
	  
	    /*
	    int counter2 = -1;
	    char leter2 = 'a'-1;
		int number2 = 8;
	    for(int i = 0; i < chessboard.length; i++) {
	    	counter2++;
	    	leter2+=1;
	    	if(counter2 == 8){
	    		counter2 = 0;
	    		leter2 = 'a';
	    		number2--;
	    		System.out.println();
	    		//System.out.println();
	    		//System.out.println();
	    	}
	    	System.out.print(chessboard[i]+" ");
	    }
	    */
	  //  int x2 = Func.getNumFromCharPos(ss);
	  //  System.out.println("--> "+x2);;
	    
	   String piece = "e:4";
	   System.out.println("\n\npiece = "+piece+"--------------------------------------------\n");
		//Util.getPostion("d:7",len);
		Util.getRookPostion(piece,len,chessboardpiece,chessboardletnum);
		//Util.getBishopPostion("g:5",len);
		//Util.getQueenPostion("b:6",len);
		//Util.getKingPostion("e:3",len);
		//Util.getHorsePostion("e:2", len);
	    //Util.solver(ss, len, chessboard, chessboard2);
	}

}
