// Main.java
import java.util.Scanner;
import java.util.ArrayList;

class Main {
  
    //This method checks if there is a chunk BELOW the 2d array/chunk that the player is currently on (This will be used to check if a new chunk should be made or if it should reuse the chunk that has been made)
    public static boolean isChunkThereOrNotOnTheDownSide(int chunkXPosition, int chunkYPostion, ArrayList<Integer> chunkXAndYDictonary){
      
      chunkYPostion++;
      
      for(int i = 0; i < chunkXAndYDictonary.size() - 1; i++){
        
        if(chunkXPosition == chunkXAndYDictonary.get(i) && chunkYPostion == chunkXAndYDictonary.get(i + 1)){
          
          return true; //there is a chunk above
          
        }
        
      }
      
      return false; // there is not a chunk above
      
    }
      //This method checks if there is a chunk ABOVE the 2d array/chunk that the player is currently on (This will be used to check if a new chunk should be made or if it should reuse the chunk that has been made)

    public static boolean isChunkThereOrNotOnTheUpSide(int chunkXPosition, int chunkYPostion, ArrayList<Integer> chunkXAndYDictonary){
      
      chunkYPostion--;
      
      for(int i = 0; i < chunkXAndYDictonary.size() - 1; i++){
        
        if(chunkXPosition == chunkXAndYDictonary.get(i) && chunkYPostion == chunkXAndYDictonary.get(i + 1)){
          
          return true; //there is a chunk above
          
        }
        
      }
      
      return false; // there is not a chunk above
      
    }
  
      //This method checks if there is a chunk ON THE RIGHT SIDE of  the 2d array/chunk that the player is currently on (This will be used to check if a new chunk should be made or if it should reuse the chunk that has been made)

    public static boolean isChunkThereOrNotOnTheRightSide(int chunkXPosition, int chunkYPostion, ArrayList<Integer> chunkXAndYDictonary){
      
      chunkXPosition++;
      
      for(int i = 0; i < chunkXAndYDictonary.size() - 1; i++){
        
        if(chunkXPosition == chunkXAndYDictonary.get(i) && chunkYPostion == chunkXAndYDictonary.get(i + 1)){
          
          return true; //there is a chunk to our right
          
        }
        
      }
      
      return false; // there is not a chunk to our right
      
    }
    
    
        //This method checks if there is a chunk ON THE LEFT SIDE of the 2d array/chunk that the player is currently on (This will be used to check if a new chunk should be made or if it should reuse the chunk that has been made)

    public static boolean isChunkThereOrNotOnTheLeftSide(int chunkXPosition, int chunkYPostion, ArrayList<Integer> chunkXAndYDictonary){
      
      chunkXPosition--;
      
      for(int i = 0; i < chunkXAndYDictonary.size() - 1; i++){
        
        if(chunkXPosition == chunkXAndYDictonary.get(i) && chunkYPostion == chunkXAndYDictonary.get(i + 1)){
          
          return true; //there is a chunk to our left
          
        }
        
      }
      
      return false; // there is not a chunk to our left
      
    }
  
  //Altough this method name tends to through people off (it made me mad, so it deserves this name). However, its perpouse is to find what chunk the Player is in, using the X and Y Coords of the Chunk. Note: The reason I devide by 2 is because there is an x and a y position for each indevedual chunk
    public static int whatfokingCunkAmIWithin(int chunkXPosition, int chunkYPostion, ArrayList<Integer> chunkXAndYDictonary){
      
      for(int i = 0; i < chunkXAndYDictonary.size() - 1; i++){
        
        if(chunkXAndYDictonary.get(i) ==  chunkXPosition && chunkXAndYDictonary.get(i + 1) == chunkYPostion){
          i++;
          return i / 2;
          
        }
        else if (i < chunkXAndYDictonary.size() - 2){
          i++;
        }
        
      }
      
      return 0;
      
    }
  
  //This is the main method/where everything begins
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	
    	String theKeyThatWasPressed = ""; //Need this for bugs
    	
    	int playerYPosition = new String[9][9].length/2;
    	int playerXPosition = new String[9][9][0].length/2;
    	
    	int realPlayerXPostiion = new String[9][9][0].length/2;
    	int realPlayerYPostiion = new String[9][9][0].length/2;
    	
    	int playerXPositionHolderForCave = 0;
    	int playerYPositionHolderForCave = 0;
    	
    	int chunkXPosition = 0;
    	int chunkYPostion = 0;
    	
    	int dirtCount = 0;
    	int woodCount = 0;
    	//int picaxaeCount = 0;
    	int cooblestoneCount = 0;
    	int bismithCount = 0;
    	int quartzCount = 0;
    	
    	
    	String oldMovement = "";
    	
    	boolean isCaveActive = false;
    	
    	int tool = 0;
    	int tooll = 0;

    	Map chunk1 = new Map(new String[9][9], playerYPosition, playerXPosition, realPlayerXPostiion, realPlayerYPostiion);

    	
    	ArrayList<Map> chunkDictonary = new ArrayList<Map>();
    	ArrayList<Integer> chunkXAndYDictonary = new ArrayList<Integer>();
    	
    	chunkDictonary.add(chunk1);
    	
    	chunkXAndYDictonary.add(chunkXPosition);
    	chunkXAndYDictonary.add(chunkYPostion);
    	
    	chunk1.printingMap((chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary))).getMap(), realPlayerXPostiion, realPlayerYPostiion, dirtCount, woodCount, tool, tooll, cooblestoneCount, bismithCount, quartzCount);
    	
    	while(true){//Game has begun
    	  
    	  
    	  while(true){ //Checks if person can type a basic keyboard button
    
    	  System.out.print("\nInput: ");

    	  theKeyThatWasPressed = scan.nextLine();
    	  
    	  if(theKeyThatWasPressed.equals("w") || theKeyThatWasPressed.equals("a") || theKeyThatWasPressed.equals("d") || theKeyThatWasPressed.equals("s") || (theKeyThatWasPressed.equals("pd") && dirtCount > 0) || theKeyThatWasPressed.equals("c")){
    	    
    	    break;
    	    
    	  }
    	  
    	  else{
    	    
    	    System.out.println("Dumb");
    	  }
    	  
    	  }//End of checking if user is dumb
    	  
    	  
    	  //Checking where to move player
    	  if(theKeyThatWasPressed.equals("w") && isCaveActive == false){
    	    
    	    playerYPosition--;
    	    realPlayerYPostiion++;
    	    
    	  }
    	  
    	  else if(theKeyThatWasPressed.equals("w") && isCaveActive == true && playerYPosition > 0){
    	    
    	    if(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).isThereCobbleStone(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getCaveMap(), playerXPosition, playerYPosition - 1) == false && chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).isThereBismith(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getCaveMap(), playerXPosition, playerYPosition - 1) == false && chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).isThereQuartz(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getCaveMap(), playerXPosition, playerYPosition - 1) == false){
    	      
    	          	    playerYPosition--;
    	          	    
    	    }
    	    
    	    else if(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).isThereCobbleStone(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getCaveMap(), playerXPosition, playerYPosition - 1) && (chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool1().equals("L1:PIC") || chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool2().equals("L1:PIC") || chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool3().equals("L1:PIC") || chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool1().equals("L2:PIC")|| chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool2().equals("L2:PIC")|| chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool3().equals("L2:PIC"))){
    	      
    	       playerYPosition--;
    	       cooblestoneCount++;
    	       
    	    }
    	   
    	    else if(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).isThereBismith(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getCaveMap(), playerXPosition, playerYPosition - 1) && (chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool1().equals("L2:PIC") || chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool2().equals("L2:PIC") || chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool3().equals("L2:PIC"))){
    	      
    	       playerYPosition--;
    	       bismithCount++;
    	       
    	    }
    	    else if(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).isThereQuartz(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getCaveMap(), playerXPosition, playerYPosition - 1) && (chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool1().equals("L2:PIC") || chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool2().equals("L2:PIC") || chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool3().equals("L2:PIC"))){
    	      
    	       playerYPosition--;
    	       quartzCount++;

    	    }
    	    

    	  }
    	  
    	  else if(theKeyThatWasPressed.equals("s") && isCaveActive == false){
    	    
    	    playerYPosition++;
    	    realPlayerYPostiion--;
    	    
    	  }
    	  
    	  else if(theKeyThatWasPressed.equals("s") && isCaveActive == true && playerYPosition < 8){
    	    
    	    if(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).isThereCobbleStone(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getCaveMap(), playerXPosition, playerYPosition + 1) == false && chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).isThereBismith(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getCaveMap(), playerXPosition, playerYPosition + 1) == false && chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).isThereQuartz(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getCaveMap(), playerXPosition, playerYPosition + 1) == false){
    	      
    	          	    playerYPosition++;

    	    }
    	    
    	    else if(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).isThereCobbleStone(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getCaveMap(), playerXPosition, playerYPosition + 1) && (chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool1().equals("L1:PIC") || chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool2().equals("L1:PIC") || chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool3().equals("L1:PIC") || chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool1().equals("L2:PIC")|| chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool2().equals("L2:PIC")|| chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool3().equals("L2:PIC"))){
    	      
    	       playerYPosition++;
    	       cooblestoneCount++;
    	      
    	    }
    	    
    	    else if(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).isThereBismith(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getCaveMap(), playerXPosition, playerYPosition + 1) && (chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool1().equals("L2:PIC") || chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool2().equals("L2:PIC") || chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool3().equals("L2:PIC"))){
    	      
    	       playerYPosition++;
    	       bismithCount++;
    	       
    	    }
    	    else if(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).isThereQuartz(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getCaveMap(), playerXPosition, playerYPosition + 1) && (chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool1().equals("L2:PIC") || chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool2().equals("L2:PIC") || chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool3().equals("L2:PIC"))){
    	      
    	       playerYPosition++;
    	       quartzCount++;

    	    }
    	  }
    	  
    	  else if(theKeyThatWasPressed.equals("d") && isCaveActive == false){
    	    
    	    playerXPosition++;
    	    realPlayerXPostiion++;
    	    
    	  }
    	  
    	  else if(theKeyThatWasPressed.equals("d") && isCaveActive == true && playerXPosition < 8){
    	    
    	    if(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).isThereCobbleStone(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getCaveMap(), playerXPosition + 1, playerYPosition) == false && chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).isThereBismith(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getCaveMap(), playerXPosition + 1, playerYPosition) == false && chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).isThereQuartz(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getCaveMap(), playerXPosition + 1, playerYPosition) == false){
    	      
    	          	    playerXPosition++;
    	      
    	    }
    	    
    	    else if(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).isThereCobbleStone(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getCaveMap(), playerXPosition + 1, playerYPosition) && (chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool1().equals("L1:PIC") || chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool2().equals("L1:PIC") || chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool3().equals("L1:PIC") || chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool1().equals("L2:PIC")|| chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool2().equals("L2:PIC")|| chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool3().equals("L2:PIC"))){
    	      
    	       playerXPosition++;
    	       cooblestoneCount++;
    	      
    	    }
    	    
    	    else if(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).isThereBismith(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getCaveMap(), playerXPosition + 1, playerYPosition) && (chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool1().equals("L2:PIC") || chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool2().equals("L2:PIC") || chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool3().equals("L2:PIC"))){
    	      
    	       playerXPosition++;
    	       bismithCount++;
    	       
    	    }
    	    
    	    else if(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).isThereQuartz(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getCaveMap(), playerXPosition + 1, playerYPosition) && (chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool1().equals("L2:PIC") || chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool2().equals("L2:PIC") || chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool3().equals("L2:PIC"))){
    	      
    	       playerXPosition++;
    	       quartzCount++;

    	       
    	    }

    	  }
    	  
    	  else if(theKeyThatWasPressed.equals("a") && isCaveActive == false){
    	    
    	    playerXPosition--;
    	    realPlayerXPostiion--;
    	    
    	  }
    	  
    	  else if(theKeyThatWasPressed.equals("a") && isCaveActive == true && playerXPosition > 0){
    	    
    	    if(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).isThereCobbleStone(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getCaveMap(), playerXPosition - 1, playerYPosition) == false && chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).isThereBismith(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getCaveMap(), playerXPosition - 1, playerYPosition) == false && chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).isThereQuartz(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getCaveMap(), playerXPosition - 1, playerYPosition) == false ){
    	      
    	       playerXPosition--;

    	    }
    	    
    	   else if(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).isThereCobbleStone(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getCaveMap(), playerXPosition - 1, playerYPosition) && (chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool1().equals("L1:PIC") || chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool2().equals("L1:PIC") || chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool3().equals("L1:PIC") || chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool1().equals("L2:PIC")|| chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool2().equals("L2:PIC")|| chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool3().equals("L2:PIC"))){
    	      
    	       playerXPosition--;
    	       cooblestoneCount++;
    	      
    	    }
    	    
    	    else if(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).isThereBismith(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getCaveMap(), playerXPosition - 1, playerYPosition) && (chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool1().equals("L2:PIC") || chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool2().equals("L2:PIC") || chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool3().equals("L2:PIC"))){
    	      
    	       playerXPosition--;
    	       bismithCount++;
    	       
    	    }
    	    
    	    else if(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).isThereQuartz(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getCaveMap(), playerXPosition - 1, playerYPosition) && (chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool1().equals("L2:PIC") || chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool2().equals("L2:PIC") || chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getTool3().equals("L2:PIC"))){
    	      
    	       playerXPosition--;
    	       quartzCount++;

    	       
    	    }

    	  }
    	  
    	  else if(theKeyThatWasPressed.equals("pd")){
    	    
    	   
    	    if(isCaveActive == false){
    	    chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).placeDirtBlock(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getMap(), playerXPosition, playerYPosition);
    	    
    	    }
    	    
    	    else{
    	      
    	      chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).placeDirtBlock(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getCaveMap(), playerXPosition, playerYPosition);

    	      
    	    }
    	    
    	    dirtCount -= 2;
    	    
    	    

    	  }
    	  
    	  else if(theKeyThatWasPressed.equals("c")){
    	  System.out.println("\033[H\033[2J");
    	  
    	  System.out.println("\t\tCrafting Table");
    	  
    	  System.out.println("\n0.Exit = Free");
    	  System.out.println("\n1.Level1: Picaxae = 3 Wood");
    	  System.out.println("\n2.Level2: Picaxe = 3 Cobblestone");
    	  System.out.println("\n3.Level1: Sword = 3 Wood");
    	  System.out.println("\n4.Unkown = ???");
    	  System.out.println("\n5.Unkown = ???");

    	  
    	  
    	  while(true){
    	    
    	  int answer = 0;
    	  
    	  System.out.print("\nInput: ");
    	  
    	 while(true){
    	 
    	 try{
    	 answer = scan.nextInt();
    	 break;
    	 }
    	 catch(Exception e){
    	   
    	   System.out.println("Dumb");
    	   
    	 }
    	 
    	 scan.nextLine();
    	 
    	  
    	 }
    	  
    	  if(answer == 1 && woodCount >= 3){
    	    
    	    //picaxaeCount++;
    	    
    	    System.out.println("Level 1: Pickaxe has been made!");
    	    
    	    tool = 1;
    	    
    	    woodCount -= 3;
    	    
    	     //chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).updatingMap((chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary))).getMap(), playerYPosition, playerXPosition, theKeyThatWasPressed);
    	     
    	     
    	  }
    	  else if(answer == 2 && cooblestoneCount >= 3){
    	    
    	    //picaxaeCount++;
    	    
    	    System.out.println("Level2: Pickaxe has been made!");
    	    
    	    tool = 2;
    	    
    	    cooblestoneCount -= 3;
    	    
    	     //chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).updatingMap((chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary))).getMap(), playerYPosition, playerXPosition, theKeyThatWasPressed);
    	     
    	     
    	  }
    	  
    	  else if(answer == 3 && woodCount >= 3){
    	    
    	    //picaxaeCount++;
    	    
    	    System.out.println("Level1: Sword has been made!");
    	    
    	    tooll = 1;
    	    
    	    woodCount -= 3;
    	    
    	     //chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).updatingMap((chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary))).getMap(), playerYPosition, playerXPosition, theKeyThatWasPressed);
    	     
    	     
    	  }
    	  
    	  else if (answer == 0){
    	    
    	    break;
    	    
    	  }
    	  
    	  else{
    	    
    	    System.out.println("Broke");
    	    
    	  }
    	    
    	    
    	  }
    	  }
    	  
    	  //Checking if player has gone out of bounds
    	  if(playerXPosition == 9 && isCaveActive == false){
    	    
    	    if(isChunkThereOrNotOnTheRightSide(chunkXPosition, chunkYPostion, chunkXAndYDictonary)){
    	      
    	      //Load Chunk
    	      chunkXPosition++;
    	      playerXPosition = 0;
    	      
    	    }
    	    
    	    else{
    	      
    	      playerXPosition = 0;
    	      chunkXPosition++;

    	      chunkDictonary.add(new Map(new String[9][9], playerYPosition, playerXPosition, realPlayerXPostiion, realPlayerYPostiion));
    	      chunkXAndYDictonary.add(chunkXPosition);
    	      chunkXAndYDictonary.add(chunkYPostion);
    	      //Create new Chunk
    	      
    	    }
    	    
    	  }
    	  else if(playerXPosition == -1 && isCaveActive == false){
    	    
    	    if(isChunkThereOrNotOnTheLeftSide(chunkXPosition, chunkYPostion, chunkXAndYDictonary)){
    	      
    	      chunkXPosition--;
    	      playerXPosition = 8;
    	      
    	    }
    	    
    	    else{
    	          	      chunkXPosition--;
    	      playerXPosition = 8;
    	      chunkDictonary.add(new Map(new String[9][9], playerYPosition, playerXPosition, realPlayerXPostiion, realPlayerYPostiion));
    	      chunkXAndYDictonary.add(chunkXPosition);
    	      chunkXAndYDictonary.add(chunkYPostion);
    	      
    	    }
    	    
    	  }
    	  
    	  else if(playerYPosition == -1 && isCaveActive == false){
    	    
    	     if(isChunkThereOrNotOnTheUpSide(chunkXPosition, chunkYPostion, chunkXAndYDictonary)){
    	      
    	      chunkYPostion--;
    	      playerYPosition = 8;
    	      
    	    }
    	    
    	    else{
    	      chunkYPostion--;
    	      playerYPosition = 8;
    	      chunkDictonary.add(new Map(new String[9][9], playerYPosition, playerXPosition, realPlayerXPostiion, realPlayerYPostiion));
    	      chunkXAndYDictonary.add(chunkXPosition);
    	      chunkXAndYDictonary.add(chunkYPostion);
    	      
    	    }
    	    
    	  }
    	  
    	  else if(playerYPosition == 9 && isCaveActive == false){
    	    
    	    if(isChunkThereOrNotOnTheDownSide(chunkXPosition, chunkYPostion, chunkXAndYDictonary)){
    	      

    	      chunkYPostion++;
    	      System.out.println(chunkYPostion);
    	      playerYPosition = 0;
    	      
    	    }
    	    
    	    else{
    	      chunkYPostion++;
    	      playerYPosition = 0;
    	      chunkDictonary.add(new Map(new String[9][9], playerYPosition, playerXPosition, realPlayerXPostiion ,realPlayerYPostiion));
    	      chunkXAndYDictonary.add(chunkXPosition);
    	      chunkXAndYDictonary.add(chunkYPostion);
    	      
    	    }
    	  }

    	  System.out.println("\033[H\033[2J");
    	  
    	 // System.out.println(chunkDictonary);
    	 // System.out.println(chunkXAndYDictonary);

      //   System.out.println(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary));


    	  //if you are are trying to understand this and the next line (I am praying for you), but this is where the magic happens
    	  
    	  if(isCaveActive == true){
    	    
    	    
    	   if(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).isThereDirt(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getCaveMap(), playerXPosition, playerYPosition)){
    	    
    	   
    	        	      


    	   // chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).updatingMap((chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary))).getCaveMap(), playerYPosition, playerXPosition, theKeyThatWasPressed);
    	    
    	        	      


    	    dirtCount++;
    	   
    	     }

    	   if(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).isThereCave(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getCaveMap(), playerXPosition, playerYPosition)){
    	     

    	        isCaveActive = false;
    	        
    	        
    	        chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).resetCaveMap(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getCaveMap(), playerXPosition, playerYPosition, theKeyThatWasPressed, chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getPlayerXAxisInCave());
    	        
    	        chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).putCaveBack(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getCaveMap(), playerXPosition, playerYPosition);
    	        
    	        playerXPosition = playerXPositionHolderForCave;
    	        playerYPosition = playerYPositionHolderForCave;
    	            	  System.out.println("\033[H\033[2J");
    	            	  
              
    	    }

    	    else{
          chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).updatingMap((chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary))).getCaveMap(), playerYPosition, playerXPosition, theKeyThatWasPressed, isCaveActive, dirtCount, woodCount, tool, tooll, cooblestoneCount, bismithCount, quartzCount, realPlayerXPostiion, realPlayerYPostiion);


    	          	      


    	      chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).print(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getCaveMap(), woodCount, dirtCount, tool, tooll, cooblestoneCount, bismithCount, quartzCount);
    	      
    	    }
    	    
            
    	  }
    	  
    	  else if(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).isThereCave(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getMap(), playerXPosition, playerYPosition)){
    	    
    	    
    	    
    	    
    	   oldMovement = theKeyThatWasPressed;
    	    
    	   //chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).removePlayer(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getMap());
    	    
    	    isCaveActive = true;
    	    
    	    if(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getHasCaveBeenGeneratedAlready() == false){
    	    
    	    chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).print(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).caveGeneration(), woodCount, dirtCount, tool, tooll, cooblestoneCount, bismithCount, quartzCount);
    	    

    	    }
    	    
    	    else{
    	      
    	      
    	      
    	     chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).print(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getCaveMap(), woodCount, dirtCount, tool, tooll, cooblestoneCount, bismithCount, quartzCount);

    	    }
    	    
    	      playerXPosition = chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).goBackAMovmentX(playerXPosition, theKeyThatWasPressed);
    	      
    	      playerYPosition = chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).goBackAMovmentY(playerYPosition, theKeyThatWasPressed);
    	      
    	     playerXPositionHolderForCave = playerXPosition;
    	     
    	     playerYPositionHolderForCave = playerYPosition;
    	     
    	     //chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).placePlayerBackOnMap(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getMap(), playerXPosition, playerYPosition, oldMovement);

    	     
    	     
    	     playerXPosition = (chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getPlayerXAxisInCave());
    	     playerYPosition = 0;
    	     
    	     chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).updatingMap((chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary))).getCaveMap(), playerYPosition, playerXPosition, theKeyThatWasPressed, isCaveActive, dirtCount, woodCount, tool, tooll, cooblestoneCount, bismithCount, quartzCount, realPlayerXPostiion, realPlayerYPostiion);
    	    
    	    

    	    
    	  }
    	  
    	  else if(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).isThereDirt(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getMap(), playerXPosition, playerYPosition)){
    	    
    	   
    	    

    	    chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).updatingMap((chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary))).getMap(), playerYPosition, playerXPosition, theKeyThatWasPressed, isCaveActive, dirtCount, woodCount, tool, tooll, cooblestoneCount, bismithCount, quartzCount, realPlayerXPostiion, realPlayerYPostiion);
    	    
    	    dirtCount++;
    	   
    	     }
    	 
    	     
    	     
    	  else if(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).isThereWood(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getMap(), playerXPosition, playerYPosition)){
    	    
    	    
    	    chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).updatingMap((chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary))).getMap(), playerYPosition, playerXPosition, theKeyThatWasPressed, isCaveActive, dirtCount, woodCount, tool, tooll, cooblestoneCount, bismithCount, quartzCount, realPlayerXPostiion, realPlayerYPostiion);
    	    
    	    woodCount++;

    	  }
    	     
    	   
    	  
    	  else{
    	  chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).updatingMap((chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary))).getMap(), playerYPosition, playerXPosition, theKeyThatWasPressed, isCaveActive, dirtCount, woodCount, tool, tooll, cooblestoneCount, bismithCount, quartzCount, realPlayerXPostiion, realPlayerYPostiion);
    	  
    	  }
    	  
    	  if(isCaveActive == false){
    	  chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).printingMap((chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary))).getMap(), realPlayerXPostiion, realPlayerYPostiion, dirtCount, woodCount, tool, tooll, cooblestoneCount, bismithCount, quartzCount);
    	  
    	  }
  
    	  if(chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).getLives() == 0){
          System.out.println("\033[H\033[2J");
          System.out.println("GAME RESET");

           theKeyThatWasPressed = ""; //Need this for bugs
    	
    	 playerYPosition = new String[9][9].length/2;
    	 playerXPosition = new String[9][9][0].length/2;
    	
    	 realPlayerXPostiion = new String[9][9][0].length/2;
    	 realPlayerYPostiion = new String[9][9][0].length/2;
    	
    	 playerXPositionHolderForCave = 0;
    	 playerYPositionHolderForCave = 0;
    	
    	 chunkXPosition = 0;
    	 chunkYPostion = 0;
    	
    	 dirtCount = 0;
    	 woodCount = 0;
    	//int picaxaeCount = 0;
    	 cooblestoneCount = 0;
    	 bismithCount = 0;
    	 quartzCount = 0;
    	
    	
    	 oldMovement = "";
    	
    	 isCaveActive = false;
    	
    	 tool = 0;
    	 tooll = 0;

    	chunk1 = new Map(new String[9][9], playerYPosition, playerXPosition, realPlayerXPostiion, realPlayerYPostiion);

    	
    	chunkDictonary = new ArrayList<Map>();
    	chunkXAndYDictonary = new ArrayList<Integer>();
    	
    	chunkDictonary.add(chunk1);
    	
    	chunkXAndYDictonary.add(chunkXPosition);
    	chunkXAndYDictonary.add(chunkYPostion);

      chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).setLives(3);
      chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).setBoneCount(0);
      chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary)).setFleshCount(0);
      
    	
    	chunk1.printingMap((chunkDictonary.get(whatfokingCunkAmIWithin(chunkXPosition, chunkYPostion, chunkXAndYDictonary))).getMap(), realPlayerXPostiion, realPlayerYPostiion, dirtCount, woodCount, tool, tooll, cooblestoneCount, bismithCount, quartzCount);

      
      

        }
    	}//End of the game
    	
    }
}