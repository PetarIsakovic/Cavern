import java.util.*;
import java.util.Scanner;

public class Map extends Thread{
  
public static final String ANSI_RESET = "\u001B[0m";
public static final String ANSI_BLACK = "\u001B[30m";
public static final String ANSI_RED = "\u001B[31m";
public static final String ANSI_GREEN = "\u001B[32m";
public static final String ANSI_YELLOW = "\u001B[33m";
public static final String ANSI_BLUE = "\u001B[34m";
public static final String ANSI_PURPLE = "\u001B[35m";
public static final String ANSI_CYAN = "\u001B[36m";


//z for zikorid
//b for brfnewia
//q for quartz

    	private String[][] map;
    	
    	private int playerYPosition;
    	private int playerXPosition;
    	
    	boolean count = true;
      int number = -1;
    	
    	private boolean hasCaveBeenGeneratedAlready = false;
    	private String[][] caveMap = new String[9][9];
    	private int playerXAxisInCave;
    	
    	private String tool1 = "  ";
    	private String tool2 = "  ";
    	private String tool3 = "  ";
    	
    	ArrayList<Integer> zombiesXAndY = new ArrayList<Integer>();
    	ArrayList<Integer> skeletonsXAndY = new ArrayList<Integer>();
    	ArrayList<Integer> arrowsXAndYAndDirection = new ArrayList<Integer>();
    	ArrayList<Integer> trashCollection = new ArrayList<Integer>();
    	
    	//These two variables are to prevent fasing through arrows
    	ArrayList<Integer> lastXAndYPosition = new ArrayList<Integer>();

    	
    	ArrayList<String> items = new ArrayList<String>();

    	
    	static int fleshCount = 0;
    	static int boneCount = 0;
    	static int lives = 3;


    
    	private static int isDirtPlacedOrNot;

  //This method generates the map by first filling it with green O and then placing the Player in the middle of the map and than picking a random spot to put the letter D
      public String[][] mapGeneration(String[][] map, int xPos, int yPos){
      Random randGen = new Random();
      for(int i = 0; i < this.map.length; i++){
        
        for(int j = 0; j < this.map[0].length; j++){
          
          map[i][j] = ANSI_GREEN + "O";
          
        }
        
      }
      
      
      
      int numberOfDirtBocks = (int) (Math.random() * 20) + 5;
      
      for(int i = 0; i < numberOfDirtBocks; i++){
      
      int dirtX = (int) (Math.random() * 9);
      int dirtY = (int) (Math.random() * 9);
      
      if(map[dirtY][dirtX].equals(ANSI_GREEN + "O")){
      map[dirtY][dirtX] = ANSI_YELLOW + "D";
      }
      
      }
      
      int numberOfWoodBlocks = (int) (Math.random() * 5);
      
      for(int i = 0; i < numberOfWoodBlocks; i++){
        
      int woodX = (int) (Math.random() * 9);
      int woodY = (int) (Math.random() * 9);
      
      if(map[woodY][woodX].equals(ANSI_GREEN + "O")){
        
        map[woodY][woodX] = ANSI_PURPLE + "W";
        
      }
        
      }
      
      int caveChance = (int) (Math.random() * 3);
      
      if(caveChance == 2){
        
      int caveX = (int) (Math.random() * 7) + 1;
      int caveY = (int) (Math.random() * 7) + 1;
      
      if(!(map[caveY][caveX].equals(ANSI_BLUE + "P"))){
      map[caveY][caveX] = ANSI_RED + "C";
      }
      
      }
    
    
    //skeleton spawn

if((yPos >= 18 && yPos <= 36) || (xPos >= 18 && xPos <= 36)){
   
     for(int i = 0; i < 3; i++){
       
       while(true){
      skeletonsXAndY.add((int) (Math.random() * 7) + 1);
      skeletonsXAndY.add((int) (Math.random() * 7) + 1);
      skeletonsXAndY.add(3);
       
       
       if(map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)].equals(ANSI_GREEN + "O")){
         
         break;
       }

       skeletonsXAndY.remove(skeletonsXAndY.size()-1);
       skeletonsXAndY.remove(skeletonsXAndY.size()-1);
       skeletonsXAndY.remove(skeletonsXAndY.size()-1);
       
       }
      
      map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_RED + "S";
      i += 2;
       
     }
     
    }
    if((yPos >= 37 && yPos <= 54) || (xPos >= 37 && xPos <= 54)){
   
     for(int i = 0; i < 6; i++){
       
       while(true){
      skeletonsXAndY.add((int) (Math.random() * 7) + 1);
      skeletonsXAndY.add((int) (Math.random() * 7) + 1);
      skeletonsXAndY.add(3);
       
       
       if(map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)].equals(ANSI_GREEN + "O")){
         
         break;
       }

       skeletonsXAndY.remove(skeletonsXAndY.size()-1);
       skeletonsXAndY.remove(skeletonsXAndY.size()-1);
       skeletonsXAndY.remove(skeletonsXAndY.size()-1);
       
       }
      
      map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_RED + "S";
      i += 2;
       
     }
     
    }
    if((yPos >= 55 && yPos <= 81) || (xPos >= 55 && xPos <= 81)){
   
     for(int i = 0; i < 9; i++){
       
       while(true){
      skeletonsXAndY.add((int) (Math.random() * 7) + 1);
      skeletonsXAndY.add((int) (Math.random() * 7) + 1);
      skeletonsXAndY.add(3);
       
       
       if(map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)].equals(ANSI_GREEN + "O")){
         
         break;
       }

       skeletonsXAndY.remove(skeletonsXAndY.size()-1);
       skeletonsXAndY.remove(skeletonsXAndY.size()-1);
       skeletonsXAndY.remove(skeletonsXAndY.size()-1);
       
       }
      
      map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_RED + "S";
      i += 2;
       
     }
     
    }

    if((yPos >= 82 && yPos <= 90) || (xPos >= 82 && xPos <= 90)){
   
     for(int i = 0; i < 12; i++){
       
       while(true){
      skeletonsXAndY.add((int) (Math.random() * 7) + 1);
      skeletonsXAndY.add((int) (Math.random() * 7) + 1);
      skeletonsXAndY.add(3);
       
       
       if(map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)].equals(ANSI_GREEN + "O")){
         
         break;
       }

       skeletonsXAndY.remove(skeletonsXAndY.size()-1);
       skeletonsXAndY.remove(skeletonsXAndY.size()-1);
       skeletonsXAndY.remove(skeletonsXAndY.size()-1);
       
       }
      
      map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_RED + "S";
      i += 2;
       
     }
     
    }

    if(yPos >= 91 || xPos >= 91){
   
     for(int i = 0; i < 15; i++){
       
       while(true){
      skeletonsXAndY.add((int) (Math.random() * 7) + 1);
      skeletonsXAndY.add((int) (Math.random() * 7) + 1);
      skeletonsXAndY.add(3);
       
       
       if(map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)].equals(ANSI_GREEN + "O")){
         
         break;
       }

       skeletonsXAndY.remove(skeletonsXAndY.size()-1);
       skeletonsXAndY.remove(skeletonsXAndY.size()-1);
       skeletonsXAndY.remove(skeletonsXAndY.size()-1);
       
       }
      
      map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_RED + "S";
      i += 2;
       
     }
     
    }
    if((yPos <= -18 && yPos >= -36) || (xPos <= -18 && xPos >= -36)){
   
     for(int i = 0; i < 3; i++){
       
       while(true){
      skeletonsXAndY.add((int) (Math.random() * 7) + 1);
      skeletonsXAndY.add((int) (Math.random() * 7) + 1);
      skeletonsXAndY.add(3);
       
       
       if(map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)].equals(ANSI_GREEN + "O")){
         
         break;
       }

       skeletonsXAndY.remove(skeletonsXAndY.size()-1);
       skeletonsXAndY.remove(skeletonsXAndY.size()-1);
       skeletonsXAndY.remove(skeletonsXAndY.size()-1);
       
       }
      
      map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_RED + "S";
      i += 2;
       
     }
     
    }
    if((yPos <= -37 && yPos >= -54) || (xPos <= -37 && xPos >= -54)){
   
     for(int i = 0; i < 6; i++){
       
       while(true){
      skeletonsXAndY.add((int) (Math.random() * 7) + 1);
      skeletonsXAndY.add((int) (Math.random() * 7) + 1);
      skeletonsXAndY.add(3);
       
       
       if(map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)].equals(ANSI_GREEN + "O")){
         
         break;
       }

       skeletonsXAndY.remove(skeletonsXAndY.size()-1);
       skeletonsXAndY.remove(skeletonsXAndY.size()-1);
       skeletonsXAndY.remove(skeletonsXAndY.size()-1);
       
       }
      
      map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_RED + "S";
      i += 2;
       
     }
     
    }
    if((yPos <= -55 && yPos >= -81) || (xPos <= -55 && xPos >= -81)){
   
     for(int i = 0; i < 9; i++){
       
       while(true){
      skeletonsXAndY.add((int) (Math.random() * 7) + 1);
      skeletonsXAndY.add((int) (Math.random() * 7) + 1);
      skeletonsXAndY.add(3);
       
       
       if(map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)].equals(ANSI_GREEN + "O")){
         
         break;
       }

       skeletonsXAndY.remove(skeletonsXAndY.size()-1);
       skeletonsXAndY.remove(skeletonsXAndY.size()-1);
       skeletonsXAndY.remove(skeletonsXAndY.size()-1);
       
       }
      
      map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_RED + "S";
      i += 2;
       
     }
     
    }

    if((yPos <= -82 && yPos >= -90) || (xPos <= -82 && xPos >= -90)){
   
     for(int i = 0; i < 12; i++){
       
       while(true){
      skeletonsXAndY.add((int) (Math.random() * 7) + 1);
      skeletonsXAndY.add((int) (Math.random() * 7) + 1);
      skeletonsXAndY.add(3);
       
       
       if(map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)].equals(ANSI_GREEN + "O")){
         
         break;
       }

       skeletonsXAndY.remove(skeletonsXAndY.size()-1);
       skeletonsXAndY.remove(skeletonsXAndY.size()-1);
       skeletonsXAndY.remove(skeletonsXAndY.size()-1);
       
       }
      
      map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_RED + "S";
      i += 2;
       
     }
     
    }

    if(yPos <= -91 || xPos <= -91){
   
     for(int i = 0; i < 15; i++){
       
       while(true){
      skeletonsXAndY.add((int) (Math.random() * 7) + 1);
      skeletonsXAndY.add((int) (Math.random() * 7) + 1);
      skeletonsXAndY.add(3);
       
       
       if(map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)].equals(ANSI_GREEN + "O")){
         
         break;
       }

       skeletonsXAndY.remove(skeletonsXAndY.size()-1);
       skeletonsXAndY.remove(skeletonsXAndY.size()-1);
       skeletonsXAndY.remove(skeletonsXAndY.size()-1);
       
       }
      
      map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_RED + "S";
      i += 2;
       
     }
     
    }
    

    
    

      
      //Zombie spawn
    if((yPos >= 18 && yPos <= 36) || (xPos >= 18 && xPos <= 36)){
   
     for(int i = 0; i < 2; i++){
       
       while(true){
       zombiesXAndY.add((int) (Math.random() * 7) + 1); //xPos
       zombiesXAndY.add((int) (Math.random() * 7) + 1); //yPos
       
       
       if(map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)].equals(ANSI_GREEN + "O")){
         
         break;
       }

       zombiesXAndY.remove(zombiesXAndY.size()-1);
       zombiesXAndY.remove(zombiesXAndY.size()-1);
       
       }
      
      map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)] = ANSI_RED + "Z";
      i++;
       
     }
     
    }
     
     if((yPos >= 37 && yPos <= 54) || (xPos >= 37 && xPos <= 54)){
   
     for(int i = 0; i < 4; i++){
       
       while(true){
       zombiesXAndY.add((int) (Math.random() * 7) + 1); //xPos
       zombiesXAndY.add((int) (Math.random() * 7) + 1); //yPos
       
       
       if(map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)].equals(ANSI_GREEN + "O")){
         
         break;
       }

       zombiesXAndY.remove(zombiesXAndY.size()-1);
       zombiesXAndY.remove(zombiesXAndY.size()-1);
       
       }
      
      map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)] = ANSI_RED + "Z";
      i++;
       
     }
     
    }
    if((yPos >= 55 && yPos <= 81) || (xPos >= 55 && xPos <= 81)){
   
     for(int i = 0; i < 6; i++){
       
       while(true){
       zombiesXAndY.add((int) (Math.random() * 7) + 1); //xPos
       zombiesXAndY.add((int) (Math.random() * 7) + 1); //yPos
       
       
       if(map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)].equals(ANSI_GREEN + "O")){
         
         break;
       }

       zombiesXAndY.remove(zombiesXAndY.size()-1);
       zombiesXAndY.remove(zombiesXAndY.size()-1);
       
       }
      
      map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)] = ANSI_RED + "Z";
      i++;
       
     }
     
    }
    
    if((yPos >= 82 && yPos <= 90) || (xPos >= 82 && xPos <= 90)){
   
     for(int i = 0; i < 8; i++){
       
       while(true){
       zombiesXAndY.add((int) (Math.random() * 7) + 1); //xPos
       zombiesXAndY.add((int) (Math.random() * 7) + 1); //yPos
       
       
       if(map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)].equals(ANSI_GREEN + "O")){
         
         break;
       }

       zombiesXAndY.remove(zombiesXAndY.size()-1);
       zombiesXAndY.remove(zombiesXAndY.size()-1);
       
       }
      
      map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)] = ANSI_RED + "Z";
      i++;
       
     }
     
    }
    
    if(yPos >= 91 || xPos >= 91){
   
     for(int i = 0; i < 10; i++){
       
       while(true){
       zombiesXAndY.add((int) (Math.random() * 7) + 1); //xPos
       zombiesXAndY.add((int) (Math.random() * 7) + 1); //yPos
       
       
       if(map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)].equals(ANSI_GREEN + "O")){
         
         break;
       }

       zombiesXAndY.remove(zombiesXAndY.size()-1);
       zombiesXAndY.remove(zombiesXAndY.size()-1);
       
       }
      
      map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)] = ANSI_RED + "Z";
      i++;
       
     }
     
    }
    
    if((yPos <= -18 && yPos >= -36) || (xPos <= -18 && xPos >= -36)){
   
     for(int i = 0; i < 2; i++){
       
       while(true){
       zombiesXAndY.add((int) (Math.random() * 7) + 1); //xPos
       zombiesXAndY.add((int) (Math.random() * 7) + 1); //yPos
       
       
       if(map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)].equals(ANSI_GREEN + "O")){
         
         break;
       }

       zombiesXAndY.remove(zombiesXAndY.size()-1);
       zombiesXAndY.remove(zombiesXAndY.size()-1);
       
       }
      
      map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)] = ANSI_RED + "Z";
      i++;
       
     }
     
    }
     
    if((yPos <= -37 && yPos >= -54) || (xPos <= -37 && xPos >= -54)){
   
     for(int i = 0; i < 4; i++){
       
       while(true){
       zombiesXAndY.add((int) (Math.random() * 7) + 1); //xPos
       zombiesXAndY.add((int) (Math.random() * 7) + 1); //yPos
       
       
       if(map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)].equals(ANSI_GREEN + "O")){
         
         break;
       }

       zombiesXAndY.remove(zombiesXAndY.size()-1);
       zombiesXAndY.remove(zombiesXAndY.size()-1);
       
       }
      
      map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)] = ANSI_RED + "Z";
      i++;
       
     }
     
    }
    if((yPos <= -55 && yPos >= -81) || (xPos <= -55 && xPos >= -81)){
   
     for(int i = 0; i < 6; i++){
       
    
       while(true){
       zombiesXAndY.add((int) (Math.random() * 7) + 1); //xPos
       zombiesXAndY.add((int) (Math.random() * 7) + 1); //yPos
       
       
       if(map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)].equals(ANSI_GREEN + "O")){
         
         break;
       }

       zombiesXAndY.remove(zombiesXAndY.size()-1);
       zombiesXAndY.remove(zombiesXAndY.size()-1);
       
       }
       
       
      
      
      map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)] = ANSI_RED + "Z";
      i++;
       
     }
     
    }
    
    if((yPos <= -82 && yPos >= -90) || (xPos <= -82 && xPos >= -90)){
   
     for(int i = 0; i < 8; i++){
       
       while(true){
       zombiesXAndY.add((int) (Math.random() * 7) + 1); //xPos
       zombiesXAndY.add((int) (Math.random() * 7) + 1); //yPos
       
       
       if(map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)].equals(ANSI_GREEN + "O")){
         
         break;
       }

       zombiesXAndY.remove(zombiesXAndY.size()-1);
       zombiesXAndY.remove(zombiesXAndY.size()-1);
       
       }
      
      map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)] = ANSI_RED + "Z";
      i++;
       
     }
     
    }
    
    if(yPos <= -91 || xPos <= -91){
   
     for(int i = 0; i < 10; i++){
       
       while(true){
       zombiesXAndY.add((int) (Math.random() * 7) + 1); //xPos
       zombiesXAndY.add((int) (Math.random() * 7) + 1); //yPos
       
       
       if(map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)].equals(ANSI_GREEN + "O")){
         
         break;
       }

       zombiesXAndY.remove(zombiesXAndY.size()-1);
       zombiesXAndY.remove(zombiesXAndY.size()-1);
       
       }
      
      map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)] = ANSI_RED + "Z";
      i++;
       
     }
     
    }
    
      
      
    map[map.length / 2][map[0].length / 2] = ANSI_BLUE + "P";
      
      
      return map;
    }
    
    
    //This method prints the map/chunk/2Dimensional grid through a simple nested for loop
        public void printingMap(String[][] map, int pXPos, int pYPos, int numOfDirtBlocks, int numOfWoodBlocks, int tool, int tooll, int numOfCobblestone, int numOfBismith, int numOfQuartz){
        
        String xPos = "";
        String yPos = "";
        String dirtBlocks = "";
        String woodBlocks = "";
        String cobblestoneBlocks = "";
        String bismithBlocks = "";
        String quartzBlocks = "";
        String fleshBlocks = "";
        String boneBlocks = "";
          
        String tool1 = "  ";
      	String tool2 = "  ";
      	String tool3 = "  ";
      
        
        
      if(tool == 1 && tool1.equals("  ")){ //This means a wood pic has been made
        
        tool1 = "L1:PIC";
        
        setTool1("L1:PIC");
        
      }
      else if(tool == 1 && tool2.equals("  ")){
        
        tool2 = "L1:PIC";
        
        setTool2("L1:PIC");
        
      }
      
      else if(tool == 1 && tool3.equals("  ")){
        
        tool3 = "L1:PIC";
        
        setTool3("L1:PIC");
        
      }
      else if(tool == 2 && tool1.equals("  ")){ //This means a stone pic has been made
        
        tool1 = "L2:PIC";
        
        setTool1("L2:PIC");
        
      }
      else if(tool == 2 && tool2.equals("  ")){
        
        tool2 = "L2:PIC";
        
        setTool2("L2:PIC");
        
      }
      
      else if(tool == 2 && tool3.equals("  ")){
        
        tool3 = "L2:PIC";
        
        setTool3("L2:PIC");
        
      }
      
      if(tooll == 1 && tool1.equals("  ")){ //This means a wood sword has been made
        
        tool1 = "L1:SWORD";
        
        setTool1("L1:SWORD");
        
      }
      else if(tooll == 1 && tool2.equals("  ")){
        
        tool2 = "L1:SWORD";
        
        setTool2("L1:SWORD");
        
      }
      
      else if(tooll == 1 && tool3.equals("  ")){
        
        tool3 = "L1:SWORD";
        
        setTool3("L1:SWORD");
        
      }
          
      if(pXPos < 10 && pXPos >= 0){
        
        xPos += "00" + pXPos;
        
      }
      
      else if(pXPos < 100 && pXPos >= 10){
        xPos += "0" + pXPos;
      }
      
      else if (pXPos >= 100 && pXPos >= 100){
        
        xPos += pXPos;
        
      }
      
      else if(pXPos < 0 && pXPos > -10){
        

        xPos += "-00" + (pXPos * -1);
        
      }
      
      else if(pXPos > -100 && pXPos <= -10){
        xPos += "-0" + pXPos * -1;
      }
      
      else if (pXPos <= -100){
        
        xPos += "-" + pXPos * -1;
        
      }
      
      
      
        if(pYPos < 10 && pYPos >= 0){
        
        yPos += "00" + pYPos;
        
      }
      
      else if(pYPos < 100 && pYPos >= 10){
        yPos += "0" + pYPos;
      }
      
      else if (pYPos >= 100){
        
        yPos += pYPos;
        
      }
      
      else if(pYPos < 0 && pYPos > -10){
        

        yPos += "-00" + (pYPos * -1);
        
      }
      
      else if(pYPos > -100 && pYPos <= -10){
        yPos += "-0" + (pYPos * -1);
      }
      
      else if (pYPos <= -100){
        
        yPos += "-" + (pYPos * -1);
        
      }
      
      if(numOfDirtBlocks == 0){
        
        dirtBlocks = "";
        
      }
      
      else if(numOfDirtBlocks > 0 && numOfDirtBlocks < 10){
        
        dirtBlocks += "[O" + numOfDirtBlocks + "D]";
        
      }
      
      else{
        
        dirtBlocks += "[" + numOfDirtBlocks + "D]";
        
      }
      
      if(numOfWoodBlocks == 0){
        
        woodBlocks = "";
        
      }
      
      else if(numOfWoodBlocks > 0 && numOfWoodBlocks < 10){
        
        woodBlocks += "[O" + numOfWoodBlocks + "W]";
        
      }
      
      else{
        
        woodBlocks += "[" + numOfWoodBlocks + "W]";
        
      }
      
      if(numOfCobblestone == 0){
        
        cobblestoneBlocks = "";
        
      }
      
      else if(numOfCobblestone > 0 && numOfCobblestone < 10){
        
        cobblestoneBlocks += "[O" + numOfCobblestone + "C]";
        
      }
      
      else{
        
        cobblestoneBlocks += "[" + numOfCobblestone + "C]";
        
      }
      
      if(numOfBismith == 0){
        
        bismithBlocks = "";
        
      }
      
      else if(numOfBismith > 0 && numOfBismith < 10){
        
        bismithBlocks += "[O" + numOfBismith + "B]";
        
      }
      
      else{
        
        bismithBlocks += "[" + numOfBismith + "B]";
        
      }
      
      if(numOfQuartz == 0){
        
        quartzBlocks = "";
        
      }
      
      else if(numOfQuartz > 0 && numOfQuartz < 10){
        
        quartzBlocks += "[O" + numOfQuartz + "Q]";
        
      }
      
      else{
        
        quartzBlocks += "[" + numOfQuartz + "Q]";
        
      }
      
      
      if(getFlesh() == 0){
        
        fleshBlocks = "";
        
      }
      
      else if(getFlesh() > 0 && getFlesh() < 10){
        
        fleshBlocks += "[O" + getFlesh() + "F]";
        
      }
      
      else{
        
        fleshBlocks += "[" + getFlesh() + "F]";
        
      }
      
      if(getBone() == 0){
        
        boneBlocks = "";
        
      }
      
      else if(getBone() > 0 && getBone() < 10){
        
        boneBlocks += "[O" + getBone() + "B]";
        
      }
      
      else{
        
        boneBlocks += "[" + getBone() + "B]";
        
      }
      
      if(!(woodBlocks.equals(""))){
        
        items.add(woodBlocks);
        
      }
      
      if(!(dirtBlocks.equals(""))){
        
        items.add(dirtBlocks);
        
      }
      
      if(!(cobblestoneBlocks.equals(""))){
        
        items.add(cobblestoneBlocks);
        
      }
      if(!(bismithBlocks.equals(""))){
        
        items.add(bismithBlocks);
        
      }
      if(!(quartzBlocks.equals(""))){
        
        items.add(quartzBlocks);
        
      }
      if(!(fleshBlocks.equals(""))){
        
        items.add(fleshBlocks);
        
      }
      if(!(boneBlocks.equals(""))){
        
        items.add(boneBlocks);
        
      }
      
      
      
      
      if(lives == 3){
      System.out.println(ANSI_PURPLE + "[HEA:][<3][<3][<3][LOC:][" + xPos +"]," + yPos + "]");
      }
      if(lives == 2){
      System.out.println(ANSI_PURPLE + "[HEA:][<3][<3][<>][LOC:][" + xPos +"]," + yPos + "]");
      }
      if(lives == 1){
      System.out.println(ANSI_PURPLE + "[HEA:][<3][<>][<>][LOC:][" + xPos +"]," + yPos + "]");
      }
      if(lives == 0){
      System.out.println(ANSI_PURPLE + "[HEA:][<>][<>][<>][LOC:][" + xPos +"]," + yPos + "]");
      }

      System.out.println(ANSI_PURPLE + "[+----- 1 2 3 4 5 6 7 8 9 -----+]");
      
      if(items.size() > 0){
      System.out.println("[|                             |] " + items.get(0));
      }
      else{
        System.out.println("[|                             |]");
      }
      for(int i = 0; i <= this.map.length - 1; i++){
        
        System.out.print(ANSI_PURPLE + "[" + (i + 1));
        
        System.out.print("      ");
        
        for(int j = 0; j <= this.map[0].length - 1; j++){
          
          System.out.print(this.map[i][j] + " ");
          
        }
        
        System.out.print("     "+ANSI_PURPLE + (i + 1) + "]");
        
        if(i == 0 && items.size() > 1){
          
          System.out.print(" " + items.get(1));
          
        }
        if(i == 1 && items.size() > 2){
          
          System.out.print(" " + items.get(2));
          
        }
        if(i == 2 && items.size() > 3){
          
          System.out.print(" " + items.get(3));
          
        }
        if(i == 3 && items.size() > 4){
          
          System.out.print(" " + items.get(4));
          
        }
        
        if(i == 4 && items.size() > 5){
          
          System.out.print(" " + items.get(5));
          
        }
        if(i == 5 && items.size() > 6){
          
          System.out.print(" " + items.get(6));
          
        }
       
        
        
    
        
        System.out.println();
        
      }
      
      System.out.print(ANSI_PURPLE +"[|                             |]");
      System.out.println(ANSI_PURPLE + "\n[+----- 1 2 3 4 5 6 7 8 9 -----+]");
      System.out.println(ANSI_PURPLE + "[TO:][" + tool1 + "][" + tool2 + "][" + tool3 + "]");
      
      items = new ArrayList<String>();
      
    }
  
  //This methoud simply just updates the players location (The players location is the letter p on the map). So it runs a nested for loop trhough the 2d array and once it finds the old letter P, it replaces it with a Green O and places the new P on the specified location
  public void updatingMap(String[][] map, int playerYPosition, int playerXPosition, String movment, boolean isCaveActive, int numOfDirtBlocks, int numOfWoodBlocks, int tool, int tooll, int numOfCobblestone, int numOfBismith, int numOfQuartz, int pXPos,  int pYPos){
    
      
    
    
      for(int i = 0; i < this.map.length; i++){
      
      for(int j = 0; j < this.map[0].length; j++){
   

   
        if(!(movment.equals("pd"))){
        if(map[i][j].equals(ANSI_BLUE + "P")){
          
          map[i][j] = ANSI_GREEN + "O";
          
          map[playerYPosition][playerXPosition] = ANSI_BLUE + "P";

        }
        
      }
      

      
      }
      
    }
      
      
      
      //Skeleton
      boolean isPlayerOnMap = false;
      
      for(int i = 0; i < map.length; i++){
        
        for(int j = 0; j < map[0].length; j++){
          
          if(map[i][j].equals(ANSI_BLUE + "P")){
            
            isPlayerOnMap = true;
            
          }
          
        }
        
      }
      
      if(isCaveActive == false){
        
        
        for(int i = 0; i < skeletonsXAndY.size(); i++){
          
          if(!(skeletonsXAndY.get(i + 2) == 0)){
          skeletonsXAndY.set(i + 2, skeletonsXAndY.get(i + 2) - 1);
          }
          
          if(Math.sqrt(((skeletonsXAndY.get(i) - playerXPosition) * (skeletonsXAndY.get(i) - playerXPosition)) + ((skeletonsXAndY.get(i + 1) - playerYPosition) * (skeletonsXAndY.get(i + 1) - playerYPosition))) < 5){
           
             
            
            
             if(playerYPosition == skeletonsXAndY.get(i + 1) && playerXPosition < skeletonsXAndY.get(i) && skeletonsXAndY.get(i) > 0 && skeletonsXAndY.get(i) < 8){
              
             if(map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i) + 1].equals(ANSI_GREEN + "O")){
              
              map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_GREEN + "O";
                
                skeletonsXAndY.set(i, (skeletonsXAndY.get(i) + 1));
              
                map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_RED + "S";
                
                if(skeletonsXAndY.get(i + 2) == 0){
                arrowsXAndYAndDirection.add(skeletonsXAndY.get(i));
                arrowsXAndYAndDirection.add(skeletonsXAndY.get(i + 1));
                arrowsXAndYAndDirection.add(2);
                
                skeletonsXAndY.set(i + 2, 2);
                
                }
                
             }
             
             else{
               if(skeletonsXAndY.get(i + 2) == 0 && map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i) - 1].equals(ANSI_GREEN + "O")){
                arrowsXAndYAndDirection.add(skeletonsXAndY.get(i));
                arrowsXAndYAndDirection.add(skeletonsXAndY.get(i + 1));
                arrowsXAndYAndDirection.add(2);
                
                skeletonsXAndY.set(i + 2, 2);
                
                }
             }
             
            }
            
          else if(playerYPosition == skeletonsXAndY.get(i + 1) && playerXPosition < skeletonsXAndY.get(i)){
              
             
                
                if(skeletonsXAndY.get(i + 2) == 0){
                arrowsXAndYAndDirection.add(skeletonsXAndY.get(i));
                arrowsXAndYAndDirection.add(skeletonsXAndY.get(i + 1));
                arrowsXAndYAndDirection.add(2);
                
                skeletonsXAndY.set(i + 2, 2);
                
                }
                
            }
            
            else if(playerYPosition == skeletonsXAndY.get(i + 1) && playerXPosition > skeletonsXAndY.get(i) && skeletonsXAndY.get(i) > 0 && skeletonsXAndY.get(i) < 8){
              
             if( map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i) - 1].equals(ANSI_GREEN + "O")){
              
              map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_GREEN + "O";
                
                skeletonsXAndY.set(i, (skeletonsXAndY.get(i) - 1));
              
                map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_RED + "S";
                
                if(skeletonsXAndY.get(i + 2) == 0){
                arrowsXAndYAndDirection.add(skeletonsXAndY.get(i));
                arrowsXAndYAndDirection.add(skeletonsXAndY.get(i + 1));
                arrowsXAndYAndDirection.add(3);
                
                skeletonsXAndY.set(i + 2, 2);
                
                }
                
             }
             
             else{
               if(skeletonsXAndY.get(i + 2) == 0){
                arrowsXAndYAndDirection.add(skeletonsXAndY.get(i));
                arrowsXAndYAndDirection.add(skeletonsXAndY.get(i + 1));
                arrowsXAndYAndDirection.add(3);
                
                skeletonsXAndY.set(i + 2, 2);
                
                }
             }
            }
            
            else if(playerYPosition == skeletonsXAndY.get(i + 1) && playerXPosition > skeletonsXAndY.get(i) && map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i) + 1].equals(ANSI_GREEN + "O")){
              
           
                
                if(skeletonsXAndY.get(i + 2) == 0){
                arrowsXAndYAndDirection.add(skeletonsXAndY.get(i));
                arrowsXAndYAndDirection.add(skeletonsXAndY.get(i + 1));
                arrowsXAndYAndDirection.add(3);
                
                skeletonsXAndY.set(i + 2, 2);
                
                }
                
             
            }
            
            else if(playerXPosition == skeletonsXAndY.get(i) && playerYPosition > skeletonsXAndY.get(i + 1) && skeletonsXAndY.get(i + 1) > 0 && skeletonsXAndY.get(i + 1) < 8){
              
             if( map[skeletonsXAndY.get(i + 1) - 1][skeletonsXAndY.get(i)].equals(ANSI_GREEN + "O")){
              
              map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_GREEN + "O";
                
                skeletonsXAndY.set(i + 1, (skeletonsXAndY.get(i + 1) - 1));
              
                map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_RED + "S";
                
                if(skeletonsXAndY.get(i + 2) == 0){
                arrowsXAndYAndDirection.add(skeletonsXAndY.get(i) );
                arrowsXAndYAndDirection.add(skeletonsXAndY.get(i + 1));
                arrowsXAndYAndDirection.add(1);
                
                skeletonsXAndY.set(i + 2, 2);
                
                
                }
                
             }
             
             else{
               if(skeletonsXAndY.get(i + 2) == 0){
                arrowsXAndYAndDirection.add(skeletonsXAndY.get(i) );
                arrowsXAndYAndDirection.add(skeletonsXAndY.get(i + 1));
                arrowsXAndYAndDirection.add(1);
                
                skeletonsXAndY.set(i + 2, 2);
                
                
                
                
                }
             }
            }
            
            else if(playerXPosition == skeletonsXAndY.get(i) && playerYPosition > skeletonsXAndY.get(i + 1) && map[skeletonsXAndY.get(i + 1) + 1][skeletonsXAndY.get(i)].equals(ANSI_GREEN + "O")){
              
             
                
                if(skeletonsXAndY.get(i + 2) == 0){
                arrowsXAndYAndDirection.add(skeletonsXAndY.get(i) );
                arrowsXAndYAndDirection.add(skeletonsXAndY.get(i + 1));
                arrowsXAndYAndDirection.add(1);
                
                skeletonsXAndY.set(i + 2, 2);
                
                }
                
             
            }
            
            else if(playerXPosition == skeletonsXAndY.get(i) && playerYPosition < skeletonsXAndY.get(i + 1) && skeletonsXAndY.get(i + 1) > 0 && skeletonsXAndY.get(i + 1) < 8){
              
             if( map[skeletonsXAndY.get(i + 1) + 1][skeletonsXAndY.get(i)].equals(ANSI_GREEN + "O")){
              
              map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_GREEN + "O";
                
                skeletonsXAndY.set(i + 1, (skeletonsXAndY.get(i + 1) + 1));
              
                map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_RED + "S";
                
                if(skeletonsXAndY.get(i + 2) == 0){
                arrowsXAndYAndDirection.add(skeletonsXAndY.get(i) );
                arrowsXAndYAndDirection.add(skeletonsXAndY.get(i + 1));
                arrowsXAndYAndDirection.add(0);
                
                skeletonsXAndY.set(i + 2, 2);
                
                }
                
             }
             
             else{
               
               if(skeletonsXAndY.get(i + 2) == 0){
                 
                 
                arrowsXAndYAndDirection.add(skeletonsXAndY.get(i) );
                arrowsXAndYAndDirection.add(skeletonsXAndY.get(i + 1));
                arrowsXAndYAndDirection.add(0);
                
                skeletonsXAndY.set(i + 2, 2);
                
                }
               
             }
            }
            
            else if(playerXPosition == skeletonsXAndY.get(i) && playerYPosition < skeletonsXAndY.get(i + 1) && map[skeletonsXAndY.get(i + 1) - 1][skeletonsXAndY.get(i)].equals(ANSI_GREEN + "O")){
              
            
              
              
                if(skeletonsXAndY.get(i + 2) == 0){
                arrowsXAndYAndDirection.add(skeletonsXAndY.get(i) );
                arrowsXAndYAndDirection.add(skeletonsXAndY.get(i + 1));
                arrowsXAndYAndDirection.add(0);
                
                skeletonsXAndY.set(i + 2, 2);
                
                }
                
             
            }
            
            
            
            else if(!(playerXPosition == skeletonsXAndY.get(i)) && playerYPosition < skeletonsXAndY.get(i + 1)){
              
              int upDown = (int) (Math.random() * 2);
              
              
            if(upDown == 1){
             if( map[skeletonsXAndY.get(i + 1) - 1][skeletonsXAndY.get(i)].equals(ANSI_GREEN + "O")){
              
              map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_GREEN + "O";
                
                skeletonsXAndY.set(i + 1, (skeletonsXAndY.get(i + 1) - 1));
              
                map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_RED + "S";
                
             }
            }
            else{
              
              if(playerXPosition < skeletonsXAndY.get(i)){
              
              if( map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i) - 1].equals(ANSI_GREEN + "O")){
              
              map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_GREEN + "O";
                
                skeletonsXAndY.set(i, (skeletonsXAndY.get(i) - 1));
              
                map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_RED + "S";
                
             }
              }
              
              else if(playerXPosition > skeletonsXAndY.get(i)){
              
              if( map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i) + 1].equals(ANSI_GREEN + "O")){
              
              map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_GREEN + "O";
                
                skeletonsXAndY.set(i, (skeletonsXAndY.get(i) + 1));
              
                map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_RED + "S";
                
             }
              }
              
            }
            }
            
            else if(!(playerXPosition == skeletonsXAndY.get(i)) && playerYPosition > skeletonsXAndY.get(i + 1)){
              
              int upDown = (int) (Math.random() * 2);
              
              
            if(upDown == 1){
              
             if( map[skeletonsXAndY.get(i + 1) + 1][skeletonsXAndY.get(i)].equals(ANSI_GREEN + "O")){
              
              map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_GREEN + "O";
                
                skeletonsXAndY.set(i + 1, (skeletonsXAndY.get(i + 1) + 1));
              
                map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_RED + "S";
                
             }
             
            }
            
            else{
              
              if(playerXPosition < skeletonsXAndY.get(i)){
              
              if( map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i) - 1].equals(ANSI_GREEN + "O")){
              
              map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_GREEN + "O";
                
                skeletonsXAndY.set(i, (skeletonsXAndY.get(i) - 1));
              
                map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_RED + "S";
                
             }
              }
              
              else if(playerXPosition > skeletonsXAndY.get(i)){
              
              if( map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i) + 1].equals(ANSI_GREEN + "O")){
              
              map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_GREEN + "O";
                
                skeletonsXAndY.set(i, (skeletonsXAndY.get(i) + 1));
              
                map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_RED + "S";
                
             }
              }
              
            }
             
            }
          
             
           
           
            
          }
          
          else if(Math.sqrt(((skeletonsXAndY.get(i) - playerXPosition) * (skeletonsXAndY.get(i) - playerXPosition)) + ((skeletonsXAndY.get(i + 1) - playerYPosition) * (skeletonsXAndY.get(i + 1) - playerYPosition))) >= 6){
            
            
            if(playerXPosition == skeletonsXAndY.get(i) && playerYPosition < skeletonsXAndY.get(i + 1)){
              
              if(map[skeletonsXAndY.get(i + 1) - 1][skeletonsXAndY.get(i)].equals(ANSI_GREEN + "O")){
              
              map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_GREEN + "O";
                
                skeletonsXAndY.set(i + 1, (skeletonsXAndY.get(i +1) - 1));
              
                map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_RED + "S";
                
              }
            }
            
            else if(playerXPosition == skeletonsXAndY.get(i) && playerYPosition > skeletonsXAndY.get(i + 1)){
              
             if( map[skeletonsXAndY.get(i + 1) + 1][skeletonsXAndY.get(i)].equals(ANSI_GREEN + "O")){
              
              map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_GREEN + "O";
                
                skeletonsXAndY.set(i + 1, (skeletonsXAndY.get(i +1) + 1));
              
                map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_RED + "S";
                
             }
            }
            
            else if(playerYPosition == skeletonsXAndY.get(i + 1) && playerXPosition > skeletonsXAndY.get(i)){
              
             if( map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i) + 1].equals(ANSI_GREEN + "O")){
              
              map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_GREEN + "O";
                
                skeletonsXAndY.set(i, (skeletonsXAndY.get(i) + 1));
              
                map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_RED + "S";
                
             }
            }
            
            else if(playerYPosition == skeletonsXAndY.get(i + 1) && playerXPosition < skeletonsXAndY.get(i)){
              
             if( map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i) - 1].equals(ANSI_GREEN + "O")){
              
              map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_GREEN + "O";
                
                skeletonsXAndY.set(i, (skeletonsXAndY.get(i) - 1));
              
                map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_RED + "S";
                
             }
            }
            
            else{
            int upOrDown = (int) (Math.random() * 2);
            
            if(upOrDown == 1){
            
            if(playerXPosition > skeletonsXAndY.get(i) && playerYPosition < skeletonsXAndY.get(i + 1)){ //above and to the right of zombie
              
              if(map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)+1].equals(ANSI_GREEN + "O")){
              
              map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_GREEN + "O";
                
                skeletonsXAndY.set(i, (skeletonsXAndY.get(i) + 1));
                
              
              
              
              
              map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_RED + "S";
              }
              
            
              
            }
            else if(playerXPosition < skeletonsXAndY.get(i) && playerYPosition < skeletonsXAndY.get(i + 1)){ //above and to the left of zombie
              
              if(map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)-1].equals(ANSI_GREEN + "O")){
              
              map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_GREEN + "O";
                
                skeletonsXAndY.set(i, (skeletonsXAndY.get(i) - 1));
                
              
              
              
              
              map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_RED + "S";
              
              }
              
             
              
              
            }
            
            else if(playerXPosition < skeletonsXAndY.get(i) && playerYPosition > skeletonsXAndY.get(i + 1)){ //below and to the left of zombie
              
              if(map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i) - 1].equals(ANSI_GREEN + "O")){
              
              map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_GREEN + "O";
                
                skeletonsXAndY.set(i, (skeletonsXAndY.get(i) - 1));
                
              
              
              
              
              map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_RED + "S";
              
              }
              
             
              
              
            }
            
            else if(playerXPosition > skeletonsXAndY.get(i) && playerYPosition > skeletonsXAndY.get(i + 1)){ //below and to the right of zombie
              
              if(map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)+1].equals(ANSI_GREEN + "O")){
              
              map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_GREEN + "O";
                
                skeletonsXAndY.set(i, (skeletonsXAndY.get(i) + 1));
                
              
              
              
              
              map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_RED + "S";
              
              }
              
            }
            
            }
            
            else{
            if(playerYPosition < skeletonsXAndY.get(i + 1)){ //above and to the right of zombie
              
              if(map[skeletonsXAndY.get(i + 1) - 1][skeletonsXAndY.get(i)].equals(ANSI_GREEN + "O")){
              
              map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_GREEN + "O";
                
                skeletonsXAndY.set(i + 1, (skeletonsXAndY.get(i + 1) - 1));
                
              
              
              
              
              map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_RED + "S";
              
              }
              
              
            }
            else if(playerYPosition > skeletonsXAndY.get(i + 1)){ //above and to the left of zombie
              
              if(map[skeletonsXAndY.get(i + 1) + 1][skeletonsXAndY.get(i)].equals(ANSI_GREEN + "O")){
              
              map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_GREEN + "O";
                
                skeletonsXAndY.set(i + 1, (skeletonsXAndY.get(i + 1) + 1));
                
              
              
              
              
              map[skeletonsXAndY.get(i + 1)][skeletonsXAndY.get(i)] = ANSI_RED + "S";
              
              }
              
              
              
            }
            
            
            
            }
          }
           
           //fwnfcs
           
           
           
           
            
          }
          
          if(skeletonsXAndY.get(i + 1) == playerYPosition && skeletonsXAndY.get(i) == playerXPosition && ((getTool1().equals("L1:SWORD") || getTool2().equals("L1:SWORD")) || getTool3().equals("L1:SWORD"))){
            
            skeletonsXAndY.remove(i);
            skeletonsXAndY.remove(i);
            skeletonsXAndY.remove(i);
            
            boneCount++;
            
            
          }
          
          else if (skeletonsXAndY.get(i + 1) == playerYPosition && skeletonsXAndY.get(i) == playerXPosition && (!(getTool1().equals("L1:SWORD")) || !(getTool2().equals("L1:SWORD")) || !(getTool3().equals("L1:SWORD")))){
            
            map[playerYPosition][playerXPosition] = ANSI_RED + "X";
            lives--;
            skeletonHitAnimation(map, playerXPosition, playerYPosition, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz, pXPos, pYPos);
            
            
          }
          
          i += 2;
          
        }
        
      
      
  //arrows of Skeleton
      
      for(int i = 0; i < arrowsXAndYAndDirection.size(); i++){
      
        
        //0 mean up
        //1 mean down
        //2 mean left
        //3 mean right
  
  //to the down from the up
  
  
  
       
        
        if(arrowsXAndYAndDirection.get(i + 2) == 0){
          if(arrowsXAndYAndDirection.get(i+1) >= 1){
          
          
          
          
          if(map[arrowsXAndYAndDirection.get(i+1) - 1][arrowsXAndYAndDirection.get(i)].equals(ANSI_GREEN + "O")){
            
            if(!(map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)].equals(ANSI_RED + "S"))){
            
            if(map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)].equals(ANSI_CYAN + "A")){
            map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)] = ANSI_GREEN + "O";
            
            }
            
            }
            
            
            
            arrowsXAndYAndDirection.set(i + 1, arrowsXAndYAndDirection.get(i + 1) - 1);
            
          
            map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)] = ANSI_CYAN + "A";
          
          }
          
          else if(map[arrowsXAndYAndDirection.get(i+1) - 1][arrowsXAndYAndDirection.get(i)].equals(ANSI_BLUE + "P") && (!(getTool1().equals("L1:Deflect")) && !(getTool2().equals("L1:Deflect")) && !(getTool3().equals("L1:Deflect")))){
            
           
            
            if(map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)].equals(ANSI_CYAN + "A")){
            
            map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)] = ANSI_GREEN + "O";
            
            }
            
            
            
            // arrowsXAndYAndDirection.remove(i);
            // arrowsXAndYAndDirection.remove(i);
            // arrowsXAndYAndDirection.remove(i);
            trashCollection.add(i);
            
            lives--;
            skeletonHitAnimation(map, playerXPosition, playerYPosition, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz, pXPos, pYPos);
            
            
          }
          
          else{
            
            if(map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)].equals(ANSI_CYAN + "A")){
            
            map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)] = ANSI_GREEN + "O";
            }
            
            // arrowsXAndYAndDirection.remove(i);
            // arrowsXAndYAndDirection.remove(i);
            // arrowsXAndYAndDirection.remove(i);
            
            trashCollection.add(i);
            
          }
          
          }
          
          else{
            
            if(map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)].equals(ANSI_CYAN + "A")){
            
            map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)] = ANSI_GREEN + "O";
            
            }
            // arrowsXAndYAndDirection.remove(i);
            // arrowsXAndYAndDirection.remove(i);
            // arrowsXAndYAndDirection.remove(i);
            trashCollection.add(i);
            
          }
          
        }
        
        
        
        else if(arrowsXAndYAndDirection.get(i + 2) == 1){
          
          if(arrowsXAndYAndDirection.get(i+1) <= 7){
          
          
          if(map[arrowsXAndYAndDirection.get(i+1) + 1][arrowsXAndYAndDirection.get(i)].equals(ANSI_GREEN + "O")){
            
            
            if(!(map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)].equals(ANSI_RED + "S"))){
            if(map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)].equals(ANSI_CYAN + "A")){
            map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)] = ANSI_GREEN + "O";
            
            }
            
            }
          
            arrowsXAndYAndDirection.set(i + 1, arrowsXAndYAndDirection.get(i + 1) + 1);
          
            map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)] = ANSI_CYAN + "A";
          
          }
          
          else if(map[arrowsXAndYAndDirection.get(i+1) + 1][arrowsXAndYAndDirection.get(i)].equals(ANSI_BLUE + "P") && (!(getTool1().equals("L1:Deflect")) && !(getTool2().equals("L1:Deflect")) && !(getTool3().equals("L1:Deflect")))){
            
            if(map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)].equals(ANSI_CYAN + "A")){
             map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)] = ANSI_GREEN + "O";
             
            }
            
            
            
            // arrowsXAndYAndDirection.remove(i);
            // arrowsXAndYAndDirection.remove(i);
            // arrowsXAndYAndDirection.remove(i);
            trashCollection.add(i);
            lives--;
            skeletonHitAnimation(map, playerXPosition, playerYPosition, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz, pXPos, pYPos);
          }
          
          else{
            
            if(map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)].equals(ANSI_CYAN + "A")){
            
            map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)] = ANSI_GREEN + "O";
            }
            // arrowsXAndYAndDirection.remove(i);
            // arrowsXAndYAndDirection.remove(i);
            // arrowsXAndYAndDirection.remove(i);
            
            trashCollection.add(i);
            
          }
          
          }
          
          else{
            
            if(map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)].equals(ANSI_CYAN + "A")){
            map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)] = ANSI_GREEN + "O";
            
            }
            // arrowsXAndYAndDirection.remove(i);
            // arrowsXAndYAndDirection.remove(i);
            // arrowsXAndYAndDirection.remove(i);
            trashCollection.add(i);

          }
          
        }
        
        else if(arrowsXAndYAndDirection.get(i + 2) == 2){
          
          if(arrowsXAndYAndDirection.get(i) >= 1){
          
          if(map[arrowsXAndYAndDirection.get(i+1)][arrowsXAndYAndDirection.get(i) - 1].equals(ANSI_GREEN + "O")){
            
            // Scanner scan = new Scanner(System.in);
            
            // System.out.println("yertew");
            
            // String qwdkjn = scan.nextLine();
            
            if(!(map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)].equals(ANSI_RED + "S"))){
            if(map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)].equals(ANSI_CYAN + "A")){
            map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)] = ANSI_GREEN + "O";
            }
            
            }
          
            arrowsXAndYAndDirection.set(i, arrowsXAndYAndDirection.get(i) - 1);
          
            map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)] = ANSI_CYAN + "A";
          
          }
          
          else if(map[arrowsXAndYAndDirection.get(i+1)][arrowsXAndYAndDirection.get(i) - 1].equals(ANSI_BLUE + "P") && (!(getTool1().equals("L1:Deflect")) && !(getTool2().equals("L1:Deflect")) && !(getTool3().equals("L1:Deflect")))){
            
            if(map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)].equals(ANSI_CYAN + "A")){
            map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)] = ANSI_GREEN + "O";
            }
            
            
            
            // arrowsXAndYAndDirection.remove(i);
            // arrowsXAndYAndDirection.remove(i);
            // arrowsXAndYAndDirection.remove(i);
            trashCollection.add(i);
lives--;
            skeletonHitAnimation(map, playerXPosition, playerYPosition, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz, pXPos, pYPos);
          }
          
          else{
            
            if(map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)].equals(ANSI_CYAN + "A")){
            map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)] = ANSI_GREEN + "O";
            }
            
            // arrowsXAndYAndDirection.remove(i);
            // arrowsXAndYAndDirection.remove(i);
            // arrowsXAndYAndDirection.remove(i);
            trashCollection.add(i);

          }
          
          }
          
          else{
            if(map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)].equals(ANSI_CYAN + "A")){
            map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)] = ANSI_GREEN + "O";
            }
            // arrowsXAndYAndDirection.remove(i);
            // arrowsXAndYAndDirection.remove(i);
            // arrowsXAndYAndDirection.remove(i);
            trashCollection.add(i);

          }
          
        }
        
        else if(arrowsXAndYAndDirection.get(i + 2) == 3){
          
          if(arrowsXAndYAndDirection.get(i) <= 7){
          
          if(map[arrowsXAndYAndDirection.get(i+1)][arrowsXAndYAndDirection.get(i) + 1].equals(ANSI_GREEN + "O")){
            
            if(!(map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)].equals(ANSI_RED + "S"))){
            
            if(map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)].equals(ANSI_CYAN + "A")){
            map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)] = ANSI_GREEN + "O";
            }
            
            }
          
            arrowsXAndYAndDirection.set(i, arrowsXAndYAndDirection.get(i) + 1);
          
            map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)] = ANSI_CYAN + "A";
          
          }
          
          else if(map[arrowsXAndYAndDirection.get(i+1)][arrowsXAndYAndDirection.get(i) + 1].equals(ANSI_BLUE + "P") && (!(getTool1().equals("L1:Deflect")) && !(getTool2().equals("L1:Deflect")) && !(getTool3().equals("L1:Deflect")))){
            
            if(map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)].equals(ANSI_CYAN + "A")){
            map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)] = ANSI_GREEN + "O";
            }
            
          
            
            
            
            // arrowsXAndYAndDirection.remove(i);
            // arrowsXAndYAndDirection.remove(i);
            // arrowsXAndYAndDirection.remove(i);
            trashCollection.add(i);
lives--;
            skeletonHitAnimation(map, playerXPosition, playerYPosition, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz, pXPos, pYPos);
          }
          
          else{
            
          if(map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)].equals(ANSI_CYAN + "A")){
            map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)] = ANSI_GREEN + "O";
          }
            // arrowsXAndYAndDirection.remove(i);
            // arrowsXAndYAndDirection.remove(i);
            // arrowsXAndYAndDirection.remove(i);
            trashCollection.add(i);

          }
          
          
          }
          
          else{
            
            if(map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)].equals(ANSI_CYAN + "A")){
            map[arrowsXAndYAndDirection.get(i + 1)][arrowsXAndYAndDirection.get(i)] = ANSI_GREEN + "O";
            }
            // arrowsXAndYAndDirection.remove(i);
            // arrowsXAndYAndDirection.remove(i);
            // arrowsXAndYAndDirection.remove(i);
            trashCollection.add(i);

          }
          
        }
      
        // for(int k = 0; k < lastXAndYPosition.size(); k++){
            
        //     lastXAndYPosition.remove(k);
            
        //   }
        
        
        //----------------------------------------------
        
        
        
        if(arrowsXAndYAndDirection.size() >= 2 && i < arrowsXAndYAndDirection.size() - 1){
        
        
        if(arrowsXAndYAndDirection.get(i) == playerXPosition && arrowsXAndYAndDirection.get(i + 1) == playerYPosition - 1 && arrowsXAndYAndDirection.get(i + 2) == 1){
          

          
            lastXAndYPosition.add(playerXPosition);
            lastXAndYPosition.add(playerYPosition);
            lastXAndYPosition.add(1);
          
         
          count = true;
          number = 1;
        }
        
  }
  
  // if(lastXAndYPosition.size() >= 2){

    
  // }
  
  // for(int k = 0; k < lastXAndYPosition.size(); k++){
            
  //           lastXAndYPosition.remove(k);
            
  //         }
  
  if(arrowsXAndYAndDirection.size() > 0 && i < arrowsXAndYAndDirection.size() - 1){
        if(arrowsXAndYAndDirection.get(i) == playerXPosition && arrowsXAndYAndDirection.get(i + 1) == playerYPosition + 1 && arrowsXAndYAndDirection.get(i + 2) == 0){
          

          
            lastXAndYPosition.add(playerXPosition);
            lastXAndYPosition.add(playerYPosition);
            lastXAndYPosition.add(0);
          
          count = true;
          number = 1;
        }
        
  }
  
  // if(lastXAndYPosition.size() > 0){
        
        
  // }
        // for(int k = 0; k < lastXAndYPosition.size(); k++){
            
        //     lastXAndYPosition.remove(k);
            
        //   }
        
        
        if(arrowsXAndYAndDirection.size() > 0 && i < arrowsXAndYAndDirection.size() - 1){
        if(arrowsXAndYAndDirection.get(i) == playerXPosition + 1 && arrowsXAndYAndDirection.get(i + 1) == playerYPosition && arrowsXAndYAndDirection.get(i + 2) == 2){
          

          
            lastXAndYPosition.add(playerXPosition);
            lastXAndYPosition.add(playerYPosition);
            lastXAndYPosition.add(2);
          
          count = true;
          number = 1;
        }
        
        }
        
  //       if(lastXAndYPosition.size() > 0){
        
        
  // }
        
        // for(int k = 0; k < lastXAndYPosition.size(); k++){
            
        //     lastXAndYPosition.remove(k);
            
        //   }
        
        
        if(arrowsXAndYAndDirection.size() > 0 && i < arrowsXAndYAndDirection.size() - 1){
        
        if(arrowsXAndYAndDirection.get(i) == playerXPosition - 1 && arrowsXAndYAndDirection.get(i + 1) == playerYPosition && arrowsXAndYAndDirection.get(i + 2) == 3){
          

          
            lastXAndYPosition.add(playerXPosition);
            lastXAndYPosition.add(playerYPosition);
            lastXAndYPosition.add(3);
          
         count = true;
          number = 1;
        }
        
        }



if(lastXAndYPosition.size() >= 6 && count == true){
                          
          
            
            lastXAndYPosition.remove(0);
            lastXAndYPosition.remove(0);
            lastXAndYPosition.remove(0);
            
          
         
          //count = false;
          
        

        }

        
        if(arrowsXAndYAndDirection.size() > 0 && lastXAndYPosition.size() == 3){
        //to the left from the right
        
        
       
        
        if(arrowsXAndYAndDirection.size() > 0 && i < arrowsXAndYAndDirection.size() && lastXAndYPosition.size() == 3){

          
        for(int j = 0; j < lastXAndYPosition.size(); j++){
                           
          
        if(lastXAndYPosition.get(j) == playerXPosition + 1 && lastXAndYPosition.get(j + 1) == playerYPosition && lastXAndYPosition.get(j+2) == 3 && movment.equals("a")){
          
          map[lastXAndYPosition.get(i+1)][lastXAndYPosition.get(i)] = ANSI_GREEN + "O";
          lives--;
          skeletonHitAnimation(map, playerXPosition, playerYPosition, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz, pXPos, pYPos);
          
          for(int k = 0; k < lastXAndYPosition.size(); k++){
            
            lastXAndYPosition.remove(0);
            
          }
          lastXAndYPosition.remove(0);
          
         
          
          
        }
        else if(lastXAndYPosition.get(j) == playerXPosition && lastXAndYPosition.get(j + 1) == playerYPosition && lastXAndYPosition.get(j+2) == 3 && movment.equals("a") && map[playerYPosition][playerXPosition + 1].equals(ANSI_CYAN + "A")){
          
          map[playerYPosition][playerXPosition + 1] = ANSI_GREEN + "O";
          map[playerYPosition][playerXPosition - 1] = ANSI_GREEN + "O";
         lives--;
          skeletonHitAnimation(map, playerXPosition, playerYPosition, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz, pXPos, pYPos);
          
          for(int k = 0; k < lastXAndYPosition.size(); k++){
            
            lastXAndYPosition.remove(0);
            
          }
          lastXAndYPosition.remove(0);
          
        }
        j += 2;
        }
        }
        

        if(arrowsXAndYAndDirection.size() > 0 && i < arrowsXAndYAndDirection.size() && lastXAndYPosition.size() == 3){
        for(int j = 0; j < lastXAndYPosition.size(); j++){
        if(lastXAndYPosition.get(j) == playerXPosition - 1 && lastXAndYPosition.get(j + 1) == playerYPosition && lastXAndYPosition.get(j+2) == 2 && movment.equals("d")){
          
          map[lastXAndYPosition.get(i+1)][lastXAndYPosition.get(i)] = ANSI_GREEN + "O";
          lives--;
          skeletonHitAnimation(map, playerXPosition, playerYPosition, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz, pXPos, pYPos);
          
          for(int k = 0; k < lastXAndYPosition.size(); k++){
            
            lastXAndYPosition.remove(0);
            
          }
          lastXAndYPosition.remove(0);
          
        
          
          
        }
        else if(lastXAndYPosition.get(j) == playerXPosition && lastXAndYPosition.get(j + 1) == playerYPosition && lastXAndYPosition.get(j+2) == 2 && movment.equals("d") && map[playerYPosition][playerXPosition - 1].equals(ANSI_CYAN + "A")){
          
          map[playerYPosition][playerXPosition + 1] = ANSI_GREEN + "O";
          map[playerYPosition][playerXPosition - 1] = ANSI_GREEN + "O";
         lives--;
          skeletonHitAnimation(map, playerXPosition, playerYPosition, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz, pXPos, pYPos);
          
          for(int k = 0; k < lastXAndYPosition.size(); k++){
            
            lastXAndYPosition.remove(0);
            
          }
          lastXAndYPosition.remove(0);
          
        }
        j += 2;
        }
        }
        
        
        if(arrowsXAndYAndDirection.size() > 0 && i < arrowsXAndYAndDirection.size() && lastXAndYPosition.size() == 3){
        for(int j = 0; j < lastXAndYPosition.size(); j++){
        if(lastXAndYPosition.get(j) == playerXPosition && lastXAndYPosition.get(j + 1) == playerYPosition - 1 && lastXAndYPosition.get(j+2) == 0 && movment.equals("s")){
          
          
          
          
          map[lastXAndYPosition.get(i+1)][lastXAndYPosition.get(i)] = ANSI_GREEN + "O";
         lives--;
          skeletonHitAnimation(map, playerXPosition, playerYPosition, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz, pXPos, pYPos);
          
          for(int k = 0; k < lastXAndYPosition.size(); k++){
            
            lastXAndYPosition.remove(0);
            
          }
          lastXAndYPosition.remove(0);
          
        
         
          
        }
        
        else if(lastXAndYPosition.get(j) == playerXPosition && lastXAndYPosition.get(j + 1) == playerYPosition && lastXAndYPosition.get(j+2) == 0 && movment.equals("s") && map[playerYPosition - 1][playerXPosition].equals(ANSI_CYAN + "A")){
          
          map[playerYPosition + 1][playerXPosition] = ANSI_GREEN + "O";
          map[playerYPosition - 1][playerXPosition] = ANSI_GREEN + "O";
         lives--;
          skeletonHitAnimation(map, playerXPosition, playerYPosition, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz, pXPos, pYPos);
          
          for(int k = 0; k < lastXAndYPosition.size(); k++){
            
            lastXAndYPosition.remove(0);
            
          }
          lastXAndYPosition.remove(0);
          
        }
        
        j += 2;
        }
        }
        
        
        if(arrowsXAndYAndDirection.size() > 0 && i < arrowsXAndYAndDirection.size() && lastXAndYPosition.size() == 3){
        for(int j = 0; j < lastXAndYPosition.size(); j++){
        if(lastXAndYPosition.get(j) == playerXPosition && lastXAndYPosition.get(j + 1) == playerYPosition + 1 && lastXAndYPosition.get(j+2) == 1 && movment.equals("w")){
          
          
          
          map[lastXAndYPosition.get(i+1)][lastXAndYPosition.get(i)] = ANSI_GREEN + "O";
          lives--;
          skeletonHitAnimation(map, playerXPosition, playerYPosition, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz, pXPos, pYPos);
          
         
          
          for(int k = 0; k < lastXAndYPosition.size(); k++){
            
            lastXAndYPosition.remove(0);
            
          }
          lastXAndYPosition.remove(0);
          
        
          
          
        }
        
        else if(lastXAndYPosition.get(j) == playerXPosition && lastXAndYPosition.get(j + 1) == playerYPosition && lastXAndYPosition.get(j+2) == 1 && movment.equals("w") && map[playerYPosition + 1][playerXPosition].equals(ANSI_CYAN + "A")){
          
          map[playerYPosition + 1][playerXPosition] = ANSI_GREEN + "O";
          map[playerYPosition - 1][playerXPosition] = ANSI_GREEN + "O";
         lives--;
          skeletonHitAnimation(map, playerXPosition, playerYPosition, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz, pXPos, pYPos);
          
          for(int k = 0; k < lastXAndYPosition.size(); k++){
            
            lastXAndYPosition.remove(0);
            
          }
          lastXAndYPosition.remove(0);
          
        }
        j += 2;
        }
        }
        
        
        }
        

        
        if(lastXAndYPosition.size() == 3 && number == 0){
                           
          for(int k = 0; k < lastXAndYPosition.size(); k++){
                      

            lastXAndYPosition.remove(0);
            
          }
          lastXAndYPosition.remove(0);
          
         
          count = false;
          
        }
        
        number--;
        
          
          
          
        
          
        
        i += 2;
        
      }
      // System.out.println(trashCollection);
      //   System.out.println(arrowsXAndYAndDirection);
      if(trashCollection.size() > 0 && arrowsXAndYAndDirection.size() > 0){
      
      for(int i = trashCollection.size() - 1; i >= 0; i--){
        
        
        
        arrowsXAndYAndDirection.remove(arrowsXAndYAndDirection.get(trashCollection.get(i)));
        arrowsXAndYAndDirection.remove(arrowsXAndYAndDirection.get(trashCollection.get(i)));
        arrowsXAndYAndDirection.remove(arrowsXAndYAndDirection.get(trashCollection.get(i)));

        
        
      }
      
      trashCollection = new ArrayList<Integer>();
      
      }
        // System.out.println(trashCollection);
        // System.out.println(arrowsXAndYAndDirection);
  }
      
      
  //zombie    
  if(isCaveActive == false){
      
      isPlayerOnMap = false;
      
      for(int i = 0; i < map.length; i++){
        
        for(int j = 0; j < map[0].length; j++){
          
          if(map[i][j].equals(ANSI_BLUE + "P")){
            
            isPlayerOnMap = true;
            
          }
          
        }
        
      }
      

      if(isPlayerOnMap){
        
        for(int i = 0; i < zombiesXAndY.size(); i++){
          
          if(Math.sqrt(((zombiesXAndY.get(i) - playerXPosition) * (zombiesXAndY.get(i) - playerXPosition)) + ((zombiesXAndY.get(i + 1) - playerYPosition) * (zombiesXAndY.get(i + 1) - playerYPosition))) < 5){
            
            
            if(playerXPosition == zombiesXAndY.get(i) && playerYPosition < zombiesXAndY.get(i + 1)){
              
              if(map[zombiesXAndY.get(i + 1) - 1][zombiesXAndY.get(i)].equals(ANSI_GREEN + "O")){
              
              map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)] = ANSI_GREEN + "O";
                
                zombiesXAndY.set(i + 1, (zombiesXAndY.get(i +1) - 1));
              
                map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)] = ANSI_RED + "Z";
                
              }
            }
            
            else if(playerXPosition == zombiesXAndY.get(i) && playerYPosition > zombiesXAndY.get(i + 1)){
              
             if( map[zombiesXAndY.get(i + 1) + 1][zombiesXAndY.get(i)].equals(ANSI_GREEN + "O")){
              
              map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)] = ANSI_GREEN + "O";
                
                zombiesXAndY.set(i + 1, (zombiesXAndY.get(i +1) + 1));
              
                map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)] = ANSI_RED + "Z";
                
             }
            }
            
            else if(playerYPosition == zombiesXAndY.get(i + 1) && playerXPosition > zombiesXAndY.get(i)){
              
             if( map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i) + 1].equals(ANSI_GREEN + "O")){
              
              map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)] = ANSI_GREEN + "O";
                
                zombiesXAndY.set(i, (zombiesXAndY.get(i) + 1));
              
                map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)] = ANSI_RED + "Z";
                
             }
            }
            
            else if(playerYPosition == zombiesXAndY.get(i + 1) && playerXPosition < zombiesXAndY.get(i)){
              
             if( map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i) - 1].equals(ANSI_GREEN + "O")){
              
              map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)] = ANSI_GREEN + "O";
                
                zombiesXAndY.set(i, (zombiesXAndY.get(i) - 1));
              
                map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)] = ANSI_RED + "Z";
                
             }
            }
            
            else{
            int upOrDown = (int) (Math.random() * 2);
            
            if(upOrDown == 1){
            
            if(playerXPosition > zombiesXAndY.get(i) && playerYPosition < zombiesXAndY.get(i + 1)){ //above and to the right of zombie
              
              if(map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)+1].equals(ANSI_GREEN + "O")){
              
              map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)] = ANSI_GREEN + "O";
                
                zombiesXAndY.set(i, (zombiesXAndY.get(i) + 1));
                
              
              
              
              
              map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)] = ANSI_RED + "Z";
              }
              
            
              
            }
            else if(playerXPosition < zombiesXAndY.get(i) && playerYPosition < zombiesXAndY.get(i + 1)){ //above and to the left of zombie
              
              if(map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)-1].equals(ANSI_GREEN + "O")){
              
              map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)] = ANSI_GREEN + "O";
                
                zombiesXAndY.set(i, (zombiesXAndY.get(i) - 1));
                
              
              
              
              
              map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)] = ANSI_RED + "Z";
              
              }
              
             
              
              
            }
            
            else if(playerXPosition < zombiesXAndY.get(i) && playerYPosition > zombiesXAndY.get(i + 1)){ //below and to the left of zombie
              
              if(map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i) - 1].equals(ANSI_GREEN + "O")){
              
              map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)] = ANSI_GREEN + "O";
                
                zombiesXAndY.set(i, (zombiesXAndY.get(i) - 1));
                
              
              
              
              
              map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)] = ANSI_RED + "Z";
              
              }
              
             
              
              
            }
            
            else if(playerXPosition > zombiesXAndY.get(i) && playerYPosition > zombiesXAndY.get(i + 1)){ //below and to the right of zombie
              
              if(map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)+1].equals(ANSI_GREEN + "O")){
              
              map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)] = ANSI_GREEN + "O";
                
                zombiesXAndY.set(i, (zombiesXAndY.get(i) + 1));
                
              
              
              
              
              map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)] = ANSI_RED + "Z";
              
              }
              
            }
            
            }
            
            else{
            if(playerYPosition < zombiesXAndY.get(i + 1)){ //above and to the right of zombie
              
              if(map[zombiesXAndY.get(i + 1) - 1][zombiesXAndY.get(i)].equals(ANSI_GREEN + "O")){
              
              map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)] = ANSI_GREEN + "O";
                
                zombiesXAndY.set(i + 1, (zombiesXAndY.get(i + 1) - 1));
                
              
              
              
              
              map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)] = ANSI_RED + "Z";
              
              }
              
              
            }
            else if(playerYPosition > zombiesXAndY.get(i + 1)){ //above and to the left of zombie
              
              if(map[zombiesXAndY.get(i + 1) + 1][zombiesXAndY.get(i)].equals(ANSI_GREEN + "O")){
              
              map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)] = ANSI_GREEN + "O";
                
                zombiesXAndY.set(i + 1, (zombiesXAndY.get(i + 1) + 1));
                
              
              
              
              
              map[zombiesXAndY.get(i + 1)][zombiesXAndY.get(i)] = ANSI_RED + "Z";
              
              }
              
              
              
            }
            
            
            
            }
          }
           
           //fwnfcs
            
          }
          
          if(playerXPosition == zombiesXAndY.get(i) && playerYPosition == zombiesXAndY.get(i+1) && (!(getTool1().equals("L1:SWORD")) && !(getTool2().equals("L1:SWORD")) && !(getTool3().equals("L1:SWORD")))){
            
            lives--;
            zombieHitAnimation(map, playerXPosition, playerYPosition, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz, pXPos, pYPos);
            
            

            
          }
          
          else if(playerXPosition == zombiesXAndY.get(i) && playerYPosition == zombiesXAndY.get(i+1) && (getTool1().equals("L1:SWORD") || getTool2().equals("L1:SWORD") || getTool3().equals("L1:SWORD"))){
            
              fleshCount++;
              
              zombiesXAndY.remove(i);
              zombiesXAndY.remove(i);

          }
          
          i++;
          
        }
        
      }
      
   
  }
  
    
    if(isDirtPlacedOrNot == 1){
          
            map[playerYPosition][playerXPosition] = ANSI_BLUE + "P";
            isDirtPlacedOrNot = 0;
          
        }
        
    else if(movment.equals("pd")){
        placeDirtBlock(map, playerXPosition, playerYPosition);
        isDirtPlacedOrNot++;
        
        
      }
  
  
    
  }
  
  //This is a constructor that runs when the object is called
  public Map(String[][] map, int playerYPosition, int playerXPosition, int pXPos, int pYPos){
    
      this.map = map;
      this.playerXPosition = playerXPosition;
      this.playerYPosition = playerYPosition;

    	this.map = mapGeneration(map, pXPos, pYPos);
    
  }
  
  //Returns player x axis pos (Note I did not use this method at all)
  public int getXPos(){
    
    return playerXPosition;
    
  }
  
  //Returns player y axis pos (Note I did not use this method at all)
  public int getYPos(){
    
    return playerYPosition;
    
  }
  
  //Updates player x axis pos (Note I did not use this method at all)
  public void setXPos(int x){
    
    playerXPosition = x;
    
  }
  
  //Updates player y axis pos (Note I did not use this method at all)
  public void setYPos(int y){
    
    playerYPosition = y;
    
  }

  public String[][] getMap(){

    return map;

  }
  
  public String[][] getCaveMap(){
    
    return caveMap;
    
  }
  
  public void setCaveMap(String[][] map){
    
    this.caveMap = map;
    
  }
  
  public int getPlayerXAxisInCave(){
    
    return playerXAxisInCave;
    
  }
  
  public void setPlayerXAxisInCave(int x){
    
    playerXAxisInCave = x;
    
  }
  
  public void setHasCaveBeenGeneratedAlready(boolean yesOrNo){
    
    hasCaveBeenGeneratedAlready = yesOrNo;
    
  }
  
  public boolean getHasCaveBeenGeneratedAlready(){
    
    return hasCaveBeenGeneratedAlready;
    
  }
  
  //Checks if we are standing on dirt
  public boolean isThereDirt(String[][] map, int playersNextX, int playersNextY){
    
    if(map[playersNextY][playersNextX].equals(ANSI_YELLOW + "D")){
      return true;
    }
    
      return false;
  
    
  }
  
  //Places the dirt block
  public void placeDirtBlock(String[][] map, int playerXPosition, int playerYPosition){

    
    map[playerYPosition][playerXPosition] = ANSI_YELLOW + "D";
    


  }
  
  //Checks if we are standing on wood
  public boolean isThereWood(String[][] map, int playersNextX, int playersNextY){
    
    if(map[playersNextY][playersNextX].equals(ANSI_PURPLE + "W")){
      return true;
    }
    
    else{
      
      return false;
      
    }
    
  }
  
  //Checks to see if we are standing on the cave
    public boolean isThereCave(String[][] map, int playersNextX, int playersNextY){
    
    if(map[playersNextY][playersNextX].equals(ANSI_RED + "C")){
      return true;
    }
    
    else{
      
      return false;
      
    }
    
  }
  
    public String[][] caveGeneration(){
      
      String map[][] = new String[9][9];
      
      for(int i = 0; i < map.length; i++){
        
        for(int j = 0; j < map[0].length; j++){
          
          map[i][j] = ANSI_GREEN + "O";
          
        }
        
      }
      
      setPlayerXAxisInCave((int) (Math.random() * 9));
      
      //type here
      map[0][getPlayerXAxisInCave()] = ANSI_BLUE + "P";
      
      for(int i = 1; i < map.length; i++){
        
        for(int j = 0; j < map[0].length; j++){
          
          map[i][j] = ANSI_CYAN + "C"; 
          
        }
        
      }
      
      int randomStartingPosOfMaze = (int) (Math.random() * 9);
      
      int yPos = 1;
      
      int direction = 0;
      
      map[yPos][randomStartingPosOfMaze] = "X";
      
      while(true){
        

        if(yPos == 8){ //end
          
          map[yPos][randomStartingPosOfMaze] = ANSI_RED + "C";
          
          break;
          
        }
        
        else if(randomStartingPosOfMaze == 0 && yPos == 1){
          
            yPos++; //down
          
          map[yPos][randomStartingPosOfMaze] = "X";
          
          
        }
        
        else if(randomStartingPosOfMaze == 8 && yPos == 1){
          
          yPos++; //down
          
          map[yPos][randomStartingPosOfMaze] = "X";
          
        }
        
        else if(randomStartingPosOfMaze == 0 && !(yPos == 1)){
          
          direction = (int) (Math.random() * 2);
          
          if(direction == 1 && !(map[yPos + 1][randomStartingPosOfMaze].equals("X"))){
            
            yPos++; //down
            
          }
          
          else if (direction == 0 && !(map[yPos][randomStartingPosOfMaze+1].equals("X"))){
            
            randomStartingPosOfMaze++; //right
            
          }
          
          map[yPos][randomStartingPosOfMaze] = "X";
          
        }
        
        else if(randomStartingPosOfMaze == 8 && !(yPos == 1)){
          
            direction = (int) (Math.random() * 2);
            
            if(direction == 1 && !(map[yPos + 1][randomStartingPosOfMaze].equals("X"))){
            
            yPos++; //down
            
          }
          
          else if(direction == 0 && !(map[yPos][randomStartingPosOfMaze-1].equals("X"))){
            
            randomStartingPosOfMaze--; //Left
            
          }
          
            map[yPos][randomStartingPosOfMaze] = "X";

        }
        
        else if (yPos == 1 && !(randomStartingPosOfMaze == 0) && !(randomStartingPosOfMaze == 8)){
          
            direction = (int) (Math.random() * 3);
            
            if(direction == 1 && !(map[yPos + 1][randomStartingPosOfMaze].equals("X"))){
            
            yPos++; //down
            
          }
          
          else if(direction == 0 && !(map[yPos][randomStartingPosOfMaze-1].equals("X"))){
            
            randomStartingPosOfMaze--; //Left
            
          }
          
          else if(direction == 2 && !(map[yPos][randomStartingPosOfMaze+1].equals("X"))){
            
            randomStartingPosOfMaze++; //Right
            
          }
          
            map[yPos][randomStartingPosOfMaze] = "X";
          
          
        }
        
        else{
          
           direction = (int) (Math.random() * 3);
            
            if(direction == 1 && !(map[yPos + 1][randomStartingPosOfMaze].equals("X"))){
            
            yPos++; //down
            
          }
          
          else if(direction == 0 && !(map[yPos][randomStartingPosOfMaze-1].equals("X"))){
            
            randomStartingPosOfMaze--; //Left
            
          }
          
          else if(direction == 2 && !(map[yPos][randomStartingPosOfMaze+1].equals("X"))){
            

            randomStartingPosOfMaze++; //Right
            
          }
          
    
          
          map[yPos][randomStartingPosOfMaze] = "X";
          
        }
        

      }
      
      for(int i = 0; i < map.length; i++){
        
        for(int j = 0; j < map[0].length; j++){
          
          if(map[i][j].equals("X")){
            
            map[i][j] = ANSI_GREEN + "O";
            
          }
          
        }
        
      }
      
      setHasCaveBeenGeneratedAlready(true);
     
     
     //Placing ores
     
      int quartzOreChance = (int) (Math.random() * 15) + 10;
      
      for(int i = 0; i < quartzOreChance; i++){
        
      int quartzX = (int) (Math.random() * 9);
      int quartzY = (int) (Math.random() * 9);
      
        if(map[quartzY][quartzX].equals(ANSI_CYAN + "C")){
          
          map[quartzY][quartzX] = ANSI_BLUE + "Q";
          
        }
        
      }
     
      int bismithOreChance = (int) (Math.random() * 10);
      
      if(bismithOreChance == 3){
        
      int bizX = (int) (Math.random() * 9);
      int bizY = (int) (Math.random() * 9);
      
      int bismithOreColorChance = (int) (Math.random() * 9);
      
      String bismithColor = "";
      
      if(bismithOreColorChance == 1){
        
        bismithColor = ANSI_BLACK;
        
      }
      
      else if(bismithOreColorChance == 2){
        
        bismithColor = ANSI_RED;
        
      }
      
      else if(bismithOreColorChance == 3){
        
        bismithColor = ANSI_GREEN;
        
      }
      else if(bismithOreColorChance == 4){
        
        bismithColor = ANSI_YELLOW;
        
      }
      else if(bismithOreColorChance == 5){
        
        bismithColor = ANSI_BLUE;
        
      }
      
      else if(bismithOreColorChance == 6){
        
        bismithColor = ANSI_PURPLE;
      }
      
      else {
        
        bismithColor = ANSI_CYAN;
        
      }
      

      if(map[bizX][bizY].equals(ANSI_CYAN + "C")){
      map[bizX][bizY] = bismithColor + "B";
      }
        
      }
      
          setCaveMap(map);

     return map; 
      
    }
    
    //Prints cave
    public void print(String[][] array, int numOfWoodBlocks, int numOfDirtBlocks, int tool, int tooll, int numOfCobblestone, int numOfBismith, int numOfQuartz){
      
      String dirtBlocks = "";
      String woodBlocks = "";
      String cobblestoneBlocks = "";
      String bismithBlocks = "";
      String quartzBlocks = "";
      String tool1 = "  ";
      String tool2 = "  ";
      String tool3 = "  ";
      String fleshBlocks = "";
      String boneBlocks = "";

      if(numOfDirtBlocks == 0){
        
        dirtBlocks = "";
        
      }
      
      else if(numOfDirtBlocks > 0 && numOfDirtBlocks < 10){
        
        dirtBlocks += "[O" + numOfDirtBlocks + "D]";
        
      }
      
      else{
        
        dirtBlocks += "[" + numOfDirtBlocks + "D]";
        
      }
      
      if(numOfWoodBlocks == 0){
        
        woodBlocks = "";
        
      }
      
      else if(numOfWoodBlocks > 0 && numOfWoodBlocks < 10){
        
        woodBlocks += "[O" + numOfWoodBlocks + "W]";
        
      }
      
      else{
        
        woodBlocks += "[" + numOfWoodBlocks + "W]";
        
      }
      
      if(numOfCobblestone == 0){
        
        cobblestoneBlocks = "";
        
      }
      
      else if(numOfCobblestone > 0 && numOfCobblestone < 10){
        
        cobblestoneBlocks += "[O" + numOfCobblestone + "C]";
        
      }
      
      else{
        
        cobblestoneBlocks += "[" + numOfCobblestone + "C]";
        
      }
      
      if(numOfBismith == 0){
        
        bismithBlocks = "";
        
      }
      
      else if(numOfBismith > 0 && numOfBismith < 10){
        
        bismithBlocks += "[O" + numOfBismith + "B]";
        
      }
      
      else{
        
        bismithBlocks += "[" + numOfBismith + "B]";
        
      }
      
      if(numOfQuartz == 0){
        
        quartzBlocks = "";
        
      }
      
      else if(numOfQuartz > 0 && numOfQuartz < 10){
        
        quartzBlocks += "[O" + numOfQuartz + "Q]";
        
      }
      
      else{
        
        quartzBlocks += "[" + numOfQuartz + "Q]";
      }
      
      if(getFlesh() == 0){
        
        fleshBlocks = "";
        
      }
      
      else if(getFlesh() > 0 && getFlesh() < 10){
        
        fleshBlocks += "[O" + getFlesh() + "F]";
        
      }
      
      else{
        
        fleshBlocks += "[" + getFlesh() + "F]";
        
      }
      if(getBone() == 0){
        
        boneBlocks = "";
        
      }
      
      else if(getBone() > 0 && getBone() < 10){
        
        boneBlocks += "[O" + getBone() + "B]";
        
      }
      
      else{
        
        boneBlocks += "[" + getBone() + "B]";
        
      }
      
      if(!(woodBlocks.equals(""))){
        
        items.add(woodBlocks);
        
      }
      
      if(!(dirtBlocks.equals(""))){
        
        items.add(dirtBlocks);
        
      }
      
      if(!(cobblestoneBlocks.equals(""))){
        
        items.add(cobblestoneBlocks);
        
      }
      if(!(bismithBlocks.equals(""))){
        
        items.add(bismithBlocks);
        
      }
      if(!(quartzBlocks.equals(""))){
        
        items.add(quartzBlocks);
        
      }
      if(!(fleshBlocks.equals(""))){
        
        items.add(fleshBlocks);
        
      }
      if(!(boneBlocks.equals(""))){
        
        items.add(boneBlocks);
        
      }
      
      
      
      
      
      if(tool == 1 && tool1.equals("  ")){ //This means a wood pic has been made
        
        tool1 = "L1:PIC";
        setTool1("L1:PIC");
      }
      else if(tool == 1 && tool2.equals("  ")){
        
        tool2 = "L1:PIC";
        setTool2("L1:PIC");
      }
      
      else if(tool == 1 && tool3.equals("  ")){
        
        tool3 = "L1:PIC";
        setTool3("L1:PIC");
      }
      
      else if(tool == 2 && tool1.equals("  ")){ //This means a wood pic has been made
        
        tool1 = "L2:PIC";
        
        setTool1("L2:PIC");
        
      }
      else if(tool == 2 && tool2.equals("  ")){
        
        tool2 = "L2:PIC";
        
        setTool2("L2:PIC");
        
      }
      
      else if(tool == 2 && tool3.equals("  ")){
        
        tool3 = "L2:PIC";
        
        setTool3("L2:PIC");
        
      }
      
      if(tooll == 1 && tool1.equals("  ")){ //This means a wood sword has been made
        
        tool1 = "L1:SWORD";
        
        setTool1("L1:SWORD");
        
      }
      else if(tooll == 1 && tool2.equals("  ")){
        
        tool2 = "L1:SWORD";
        
        setTool2("L1:SWORD");
        
      }
      
      else if(tooll == 1 && tool3.equals("  ")){
        
        tool3 = "L1:SWORD";
        
        setTool3("L1:SWORD");
        
      }
      
      if(lives == 3){
      System.out.println(ANSI_PURPLE + "[HEA:][<3][<3][<3][LOC:][???,???]");
      }
      if(lives == 2){
      System.out.println(ANSI_PURPLE + "[HEA:][<3][<3][<>][LOC:][???,???]");
      }
      if(lives == 1){
      System.out.println(ANSI_PURPLE + "[HEA:][<3][<>][<>][LOC:][???,???]");
      }
      if(lives == 0){
      System.out.println(ANSI_PURPLE + "[HEA:][<>][<>][<>][LOC:][???,???]");
      }

      System.out.println(ANSI_PURPLE + "[+----- 1 2 3 4 5 6 7 8 9 -----+]");
      
if(items.size() > 0){
      System.out.println("[|                             |] " + items.get(0));
      }
      else{
        System.out.println("[|                             |]");
      }

      for(int i = 0; i <= this.map.length - 1; i++){
        
        System.out.print(ANSI_PURPLE + "[" + (i + 1));
        
        System.out.print("      ");
        
        for(int j = 0; j <= this.map[0].length - 1; j++){
          
          System.out.print(array[i][j] + " ");
          
        }
        
        System.out.print("     "+ ANSI_PURPLE + (i + 1) + "]");
        
        if(i == 0 && items.size() > 1){
          
          System.out.print(" " + items.get(1));
          
        }
        if(i == 1 && items.size() > 2){
          
          System.out.print(" " + items.get(2));
          
        }
        if(i == 2 && items.size() > 3){
          
          System.out.print(" " + items.get(3));
          
        }
        if(i == 3 && items.size() > 4){
          
          System.out.print(" " + items.get(4));
          
        }
        if(i == 4 && items.size() > 5){
          
          System.out.print(" " + items.get(5));
          
        }
        if(i == 5 && items.size() > 6){
          
          System.out.print(" " + items.get(6));
          
        }
        
        System.out.println();
        
      }
      
      System.out.print(ANSI_PURPLE +"[|                             |]");
      System.out.println(ANSI_PURPLE + "\n[+----- 1 2 3 4 5 6 7 8 9 -----+]");
      System.out.println(ANSI_PURPLE + "[TO:][" + tool1 + "][" + tool2 + "][" + tool3 + "]");
        
        System.out.println();
                items = new ArrayList<String>();

      }
      
      public String[][] resetCaveMap(String[][] map, int x, int y, String movment, int startX){
        
        
        if(movment.equals("a")){
          
          x++;
          
        }
        
        else if(movment.equals("d")){
          
          x--;
          
        }
        
        else if(movment.equals("s")){
          
          y--;
          
        }
        
        else{
          
          y++;
          
        }
        
        map[y][x] = ANSI_GREEN + "O";
        map[0][startX] = ANSI_BLUE + "P";
        
        return map;
        
      }
      
      
      public String[][] removePlayer(String[][] map){
        
        for(int i = 0; i < map.length; i++){
          
          for(int j = 0; j < map[0].length; j++){
            
            if(map[i][j].equals(ANSI_BLUE + "P")){
              
              
              map[i][j] = ANSI_GREEN + "O";
              
            }
            
          }
          
        }
        return map;
        
      }
      
      public String[][] placePlayerBackOnMap(String[][] map, int x, int y, String movment){
        
                if(movment.equals("w")){
          
          y++;
          
        }
        
        else if(movment.equals("s")){
          
          y--;
          
        }
        
        else if(movment.equals("a")){
          
          x++;
          
        }
        
        else{
          
          x--;
          
        }

        
        map[y][x] = ANSI_BLUE + "P";
        
        return map;
      }
      
      
      public int goBackAMovmentY(int y, String movment){
        
        if(movment.equals("w")){
          
          y++;
          
        }
        
        else if(movment.equals("s")){
          
          y--;
          
        }
        
        return y;
        
      }
      
      public int goBackAMovmentX(int x, String movment){
        
        
          if(movment.equals("a")){
          
          x++;
          
        }
        
        else if(movment.equals("d")){
          
          x--;
          
        }
        
        return x;
        
      }
      
      
      public String[][] putCaveBack(String[][] map, int x, int y){
        
        map[y][x] = ANSI_RED + "C";
        
        return map;
      }
      
      public void setTool1(String tool){
        
        tool1 = tool;
        
      }
      
      public void setTool2(String tool){
        
        tool2 = tool;
        
      }
      
      public void setTool3(String tool){
        
        tool3 = tool;
        
      }
      
      public String getTool1(){
        
        return tool1;
        
      }
      
      public String getTool2(){
        
        return tool2;
        
      }
      
      public String getTool3(){
        
        return tool3;
        
      }
      
      public boolean isThereCobbleStone(String[][] map, int x, int y){
        
        if(map[y][x].equals(ANSI_CYAN + "C")){
          
          return true;
          
        }
        
        return false;
        
      }
      
      public boolean isThereQuartz(String[][] map, int x, int y){
        
        if(map[y][x].equals(ANSI_BLUE + "Q")){
          return true;
          
        }  

        return false;
        
      }
      
      
      
      public boolean isThereBismith(String[][] map, int x, int y){
        
        if(map[y][x].equals(ANSI_CYAN + "B")){
          
          return true;
          
        }
        
        else if(map[y][x].equals(ANSI_BLACK + "B")){
          
          return true;
          
        }
        else if(map[y][x].equals(ANSI_RED + "B")){
          
          return true;
          
        }
        else if(map[y][x].equals(ANSI_GREEN + "B")){
          
          return true;
          
        }
        else if(map[y][x].equals(ANSI_YELLOW + "B")){
          
          return true;
          
        }
        else if(map[y][x].equals(ANSI_BLUE + "B")){
          
          return true;
          
        }
        else if(map[y][x].equals(ANSI_PURPLE + "B")){
          
          return true;
          
        }
        
        return false;
        
      }
      
      public void skeletonHitAnimation(String[][] map, int pXPos, int pYPos, int numOfDirtBlocks, int numOfWoodBlocks, int tool, int tooll, int numOfCobblestone, int numOfBismith, int numOfQuartz, int realPXPos, int realPYPos){
        
        
        
        for(int i = 0; i < map.length; i++){
          
          for(int j = 0; j < map[0].length; j++){
            
              if(map[i][j].equals(ANSI_BLUE + "P")){
                
                map[i][j] = ANSI_RED + "X";
              }
            
          }
          
        }
        
        
        String[][] animationMap = map;
        

       
       
        
        for(int i = 0; i < animationMap.length; i++){
          
          for(int j = 0; j < animationMap[0].length; j++){
            
            animationMap[j][i] = ANSI_PURPLE + "X";
            

            printingMap(animationMap, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);
            System.out.println("\nYou Lost 1 Life To A Skeleton! Respawning...");
            
            try{
        Thread.sleep(20);
        }
        catch(Exception e){}
        System.out.println("\033[H\033[2J");
            
          }
        }

        if(lives > 0){
        
        for(int i = 0; i < animationMap.length; i++){
            
            animationMap[i][i] = ANSI_RED + "X";
            

            printingMap(animationMap, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);
            System.out.println("\nYou Lost 1 Life To A Skeleton! Respawning...");
            
            try{
        Thread.sleep(20);
        }
        catch(Exception e){}
        System.out.println("\033[H\033[2J");
            
          
        }
        
        int sides = 0;
        
        for(int i = 8; i >= 0; i--){
            
            animationMap[sides][i] = ANSI_RED + "X";
            

            printingMap(animationMap, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);
            System.out.println("\nYou Lost 1 Life To A Skeleton! Respawning...");
            try{
        Thread.sleep(100);
        }
        catch(Exception e){}
        System.out.println("\033[H\033[2J");
            
          sides++;
        }
        
        try{
        Thread.sleep(100);
        }
        
        catch(Exception e){}
        
        for(int i = 0; i < 5; i++){
        
        for(int j = 0; j < map.length; j++){
          
          for(int k = 0; k < map[0].length; k++){
            
            if(map[j][k].equals(ANSI_RED + "X")){
              
              map[j][k] = ANSI_PURPLE + "X";
              
            }
            else if(map[j][k].equals(ANSI_PURPLE + "X")){
              
              map[j][k] = ANSI_RED + "X";
              
            }
            
            
            
          }
          
        }
        
        printingMap(map, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);
        
        System.out.println("\nYou Lost 1 Life To A Skeleton! Respawning...");
        
        try{Thread.sleep(500);}
        catch(Exception e){}
        System.out.println("\033[H\033[2J");
        
        }
        
        for(int i = 0 ; i < map.length; i++){
          
          for(int j = 0; j < map[0].length; j++){
            
            map[i][j] = ANSI_GREEN + "O";
            
          }
          
        }
      }
      else if (lives == 0){

        System.out.println("\033[H\033[2J");


          map[1][3] = ANSI_RED + "X";
          printingMap(map, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);
          try{
            Thread.sleep(100);
          }
        catch(Exception e){}
        System.out.println("\033[H\033[2J");
          map[2][3] = ANSI_RED + "X";
          printingMap(map, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);
          try{
            Thread.sleep(100);
          }
        catch(Exception e){}
        System.out.println("\033[H\033[2J");
          map[3][3] = ANSI_RED + "X";
          printingMap(map, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);
          try{
            Thread.sleep(100);
          }
        catch(Exception e){}
        System.out.println("\033[H\033[2J");
          map[4][3] = ANSI_RED + "X";
          printingMap(map, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);
          try{
            Thread.sleep(100);
          }
        catch(Exception e){}
        System.out.println("\033[H\033[2J");
          map[5][3] = ANSI_RED + "X";
          printingMap(map, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);
          try{
            Thread.sleep(100);
          }
        catch(Exception e){}
        System.out.println("\033[H\033[2J");
          map[6][3] = ANSI_RED + "X";
          printingMap(map, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);
          try{
            Thread.sleep(100);
          }
        catch(Exception e){}
        System.out.println("\033[H\033[2J");
          map[7][3] = ANSI_RED + "X";
          printingMap(map, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);
          try{
            Thread.sleep(100);
          }
        catch(Exception e){}
        System.out.println("\033[H\033[2J");
          map[7][4] = ANSI_RED + "X";
          printingMap(map, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);
          try{
            Thread.sleep(100);
          }
        catch(Exception e){}
        System.out.println("\033[H\033[2J");
          map[7][5] = ANSI_RED + "X";
          printingMap(map, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);
          try{
            Thread.sleep(100);
          }
        catch(Exception e){}
        System.out.println("\033[H\033[2J");
          map[7][6] = ANSI_RED + "X";
          printingMap(map, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);
          try{
            Thread.sleep(100);
          }
          
          catch(Exception e){}
          System.out.println("\033[H\033[2J");
          map[7][7] = ANSI_RED + "X";
          
          printingMap(map, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);

try{
            Thread.sleep(100);
          }
          
          catch(Exception e){}

System.out.println("\033[H\033[2J");

          for(int i = 0; i < 5; i++){

            for(int j = 0; j < map.length; j++){

              for(int k = 0; k < map[0].length; k++){

                if(map[j][k].equals(ANSI_PURPLE + "X")){

                  map[j][k] = ANSI_RED + "X";

                }
                
                else if(map[j][k].equals(ANSI_RED + "X")){

                  map[j][k] = ANSI_PURPLE + "X";

                }

              }
             

            }
            
        printingMap(map, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);

             try{
               Thread.sleep(500);
             }
        catch(Exception e){}
                System.out.println("\033[H\033[2J");

        }



        Scanner scan = new Scanner(System.in);
                System.out.println("\033[H\033[2J");

        System.out.print("\nGAME OVER\n\nTYPE ANYTHING TO PLAY AGAIN:");
        String word = scan.nextLine();

      }
        
        
        map[pYPos][pXPos] = ANSI_BLUE + "P";
        
        skeletonsXAndY = new ArrayList<Integer>();
        arrowsXAndYAndDirection = new ArrayList<Integer>();
        zombiesXAndY = new ArrayList<Integer>();

          
          System.out.println("We have cleared the chunk to help you against those mobs \n:D\n");      
  
      }
      
      public void zombieHitAnimation(String[][] map, int pXPos, int pYPos, int numOfDirtBlocks, int numOfWoodBlocks, int tool, int tooll, int numOfCobblestone, int numOfBismith, int numOfQuartz, int realPXPos, int realPYPos){
        
        
        
        for(int i = 0; i < map.length; i++){
          
          for(int j = 0; j < map[0].length; j++){
            
              if(map[i][j].equals(ANSI_BLUE + "P")){
                
                map[i][j] = ANSI_RED + "X";
              }
            
          }
          
        }
        
        
        String[][] animationMap = map;
        
       

        
        for(int i = 0; i < animationMap.length; i++){
          
          for(int j = 0; j < animationMap[0].length; j++){
            
            animationMap[i][j] = ANSI_PURPLE + "X";
            

            printingMap(animationMap, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);
            System.out.println("\nYou Lost 1 Life To A Zombie! Respawning...");
            
            try{
        Thread.sleep(20);
        }
        catch(Exception e){}
        System.out.println("\033[H\033[2J");
            
          }
        }
        
        if(lives > 0){
        
        for(int i = 0; i < animationMap.length; i++){
            
            animationMap[i][i] = ANSI_RED + "X";
            

            printingMap(animationMap, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);
            System.out.println("\nYou Lost 1 Life To A Zombie! Respawning...");
            
            try{
        Thread.sleep(20);
        }
        catch(Exception e){}
        System.out.println("\033[H\033[2J");
            
          
        }
        
        int sides = 0;
        
        for(int i = 8; i >= 0; i--){
            
            animationMap[sides][i] = ANSI_RED + "X";
            

            printingMap(animationMap, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);
            System.out.println("\nYou Lost 1 Life To A Zombie! Respawning...");
            try{
        Thread.sleep(100);
        }
        catch(Exception e){}
        System.out.println("\033[H\033[2J");
            
          sides++;
        }
        
        try{
        Thread.sleep(100);
        }
        
        catch(Exception e){}
        
        for(int i = 0; i < 5; i++){
        
        for(int j = 0; j < map.length; j++){
          
          for(int k = 0; k < map[0].length; k++){
            
            if(map[j][k].equals(ANSI_RED + "X")){
              
              map[j][k] = ANSI_PURPLE + "X";
              
            }
            else if(map[j][k].equals(ANSI_PURPLE + "X")){
              
              map[j][k] = ANSI_RED + "X";
              
            }
            
            
            
          }
          
        }
        
        printingMap(map, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);
        
        System.out.println("\nYou Lost 1 Life To A Zombie! Respawning...");
        
        try{
        Thread.sleep(500);
        }
        
        catch(Exception e){
          
        }
        System.out.println("\033[H\033[2J");
        
        }
        
        for(int i = 0 ; i < map.length; i++){
          
          for(int j = 0; j < map[0].length; j++){
            
            map[i][j] = ANSI_GREEN + "O";
            
          }
          
        }

      }

      else if (lives == 0){

        System.out.println("\033[H\033[2J");


          map[1][3] = ANSI_RED + "X";
          printingMap(map, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);
          try{
            Thread.sleep(100);
          }
        catch(Exception e){}
        System.out.println("\033[H\033[2J");
          map[2][3] = ANSI_RED + "X";
          printingMap(map, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);
          try{
            Thread.sleep(100);
          }
        catch(Exception e){}
        System.out.println("\033[H\033[2J");
          map[3][3] = ANSI_RED + "X";
          printingMap(map, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);
          try{
            Thread.sleep(100);
          }
        catch(Exception e){}
        System.out.println("\033[H\033[2J");
          map[4][3] = ANSI_RED + "X";
          printingMap(map, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);
          try{
            Thread.sleep(100);
          }
        catch(Exception e){}
        System.out.println("\033[H\033[2J");
          map[5][3] = ANSI_RED + "X";
          printingMap(map, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);
          try{
            Thread.sleep(100);
          }
        catch(Exception e){}
        System.out.println("\033[H\033[2J");
          map[6][3] = ANSI_RED + "X";
          printingMap(map, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);
          try{
            Thread.sleep(100);
          }
        catch(Exception e){}
        System.out.println("\033[H\033[2J");
          map[7][3] = ANSI_RED + "X";
          printingMap(map, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);
          try{
            Thread.sleep(100);
          }
        catch(Exception e){}
        System.out.println("\033[H\033[2J");
          map[7][4] = ANSI_RED + "X";
          printingMap(map, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);
          try{
            Thread.sleep(100);
          }
        catch(Exception e){}
        System.out.println("\033[H\033[2J");
          map[7][5] = ANSI_RED + "X";
          printingMap(map, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);
          try{
            Thread.sleep(100);
          }
        catch(Exception e){}
        System.out.println("\033[H\033[2J");
          map[7][6] = ANSI_RED + "X";
          printingMap(map, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);
          try{
            Thread.sleep(100);
          }
          
          catch(Exception e){}
          System.out.println("\033[H\033[2J");
          map[7][7] = ANSI_RED + "X";
          
          printingMap(map, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);

try{
            Thread.sleep(100);
          }
          
          catch(Exception e){}

System.out.println("\033[H\033[2J");

          for(int i = 0; i < 5; i++){

            for(int j = 0; j < map.length; j++){

              for(int k = 0; k < map[0].length; k++){

                if(map[j][k].equals(ANSI_PURPLE + "X")){

                  map[j][k] = ANSI_RED + "X";

                }
                
                else if(map[j][k].equals(ANSI_RED + "X")){

                  map[j][k] = ANSI_PURPLE + "X";

                }

              }
             

            }
            
        printingMap(map, realPXPos, realPYPos, numOfDirtBlocks, numOfWoodBlocks, tool, tooll, numOfCobblestone, numOfBismith, numOfQuartz);

             try{
               Thread.sleep(500);
             }
        catch(Exception e){}
                System.out.println("\033[H\033[2J");

        }



        Scanner scan = new Scanner(System.in);
                System.out.println("\033[H\033[2J");

        System.out.print("\nGAME OVER\n\nTYPE ANYTHING TO PLAY AGAIN:");
        String word = scan.nextLine();

      }
        
        
        
        map[pYPos][pXPos] = ANSI_BLUE + "P";
      

        skeletonsXAndY = new ArrayList<Integer>();
        arrowsXAndYAndDirection = new ArrayList<Integer>();
        zombiesXAndY = new ArrayList<Integer>();

          
          System.out.println("We have cleared the chunk to help you against those mobs \n:D\n");      
  
      }
      
      public int getFlesh(){
        
        return fleshCount;
        
      }
      
      public int getBone(){
        
        return boneCount;
        
      }

      public int getLives(){

        return lives;

      }

      public void setLives(int lives){

        this.lives = lives;

      }
      public void setBoneCount(int boneCount){

        this.boneCount = boneCount;

      }
      public void setFleshCount(int fleshCount){

        this.fleshCount = fleshCount;

      }
      
     
      
    }