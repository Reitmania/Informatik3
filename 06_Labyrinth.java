class Labyrinth {

    public static final String ANSI_RESET = "\u001B[0m"; 
    public static final String ANSI_RED = "\u001B[31m"; 

    public static boolean navigate(int [][] lab, int i, int j){
		boolean way = true;

		int right = j+1;
		int left  = j-1;     
		int down = i+1;
		int up = i-1;

		if(i == lab.length-1 && j == lab[0].length-1){
			return way;
		}

		else{
		if (lab[i][right]==1){
			lab[i][right]=2;
			if(navigate(lab,i,right)) return true;
		}
		if (lab[down][j]==1){
			lab[down][j]=2;
			if(navigate(lab,down,j)) return true;
		}
		if (lab[i][left]==1){
			lab[i][left]=2;
			if(navigate(lab,i,left)) return true;
		}
		if (lab[up][j]==1){
			lab[up][j]=2;
			if(navigate(lab,up,j)) return true;
		}
		}

		return false;
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        long finish = 0; 

        int[][] lab = {{0,0,1,0,1,1,1,1,1,1},{1,0,1,0,1,0,0,0,0,1},{1,0,1,1,1,0,1,1,0,1},{1,0,0,0,0,0,1,1,0,1},{1,1,1,1,1,1,1,1,0,1},{1,0,0,0,0,0,0,1,0,1},
          {1,1,1,1,1,1,0,1,0,1}, {1,0,0,1,1,1,0,1,0,1},{1,0,0,1,0,0,0,1,0,1},{1,0,0,1,1,0,0,1,0,1},{1,0,0,0,0,0,0,0,0,1},{1,0,0,1,1,1,1,1,1,1},{1,0,0,1,0,1,1,1,1,1},
          {1,0,0,1,0,0,0,0,0,1},{1,0,0,1,0,0,1,1,0,1},{1,0,0,1,0,0,0,1,0,1},{1,0,0,1,0,1,0,1,0,1},{1,0,0,1,0,1,0,1,0,1},{1,0,0,1,1,1,0,1,0,1},{1,0,0,0,0,0,0,1,0,1},
          {1,1,1,1,1,1,1,1,0,1},{1,0,0,0,0,0,0,0,0,1},{1,0,1,1,0,1,1,1,1,1},{1,0,1,0,0,1,0,0,0,1},{1,0,1,0,1,1,0,1,0,1},{1,1,1,0,0,0,0,1,0,1},{1,0,0,0,1,1,1,1,0,1},
          {1,0,1,0,0,0,0,1,0,1},{1,1,1,1,1,1,0,1,0,0}};

		// habe hier nur Kanten und Weg invertiert
          for(int i = 0; i < lab.length; i++){
            for(int j = 0; j < lab[i].length; j++){
                if(lab[i][j] == 0){
                    lab[i][j] = 1;
                } else {
                    lab[i][j] = 0;
                }
            }            
        }     
        
        
        // Einstiegspunkt
        int i = 0;
        int j = 0;
        lab[i][j]=2;
        
        // Hier startet das Backtracking
        boolean end = navigate(lab , i, j);
        
        if(end){
            System.out.println("Es wurde ein Ausweg gefunden!");
            finish = System.currentTimeMillis();
        }
        else{
            System.out.println("Es wurde kein Ausweg gefunden!");
        }
        
        // Ausgabe mit ANSI_RED, wo ein Weg ist
        for(int k = 0; k < lab.length; k++){
            for(int l = 0; l < lab[k].length; l++){
                if(lab[k][l] == 2){
                    System.out.print(ANSI_RED + "o  " + ANSI_RESET); 
                } else {
                    System.out.print(lab[k][l] + "  ");
                }
            }
            System.out.println();
        }
        System.out.println("Dauer: " + String.valueOf(finish-start) + "ms");
      }
      
}
