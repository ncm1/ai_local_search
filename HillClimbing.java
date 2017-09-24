import java.util.Random;

public class HillClimbing
{
  int[][] newPuzzle;
  int[][] bestPuzzle;
  int[] visited;
  int n;


  
  HillClimbing(int[][] arr, int n){
    // initializes new puzzle and best puzzle with given array
    this.n = n;
    visited    = new int[n*n];
    bestPuzzle = new int[n][n];
    newPuzzle  = new int[n][n];
    for(int i = 0; i < arr.length; i++){
      for(int j = 0; j < arr[0].length; j++){
        newPuzzle[i][j]  = arr[i][j];
        bestPuzzle[i][j] = arr[i][j];
      }
    }
  }


  public void hillClimb(){
    /*
      This function takes a two dim array as input and chooses a random
      non-goal cell and changes the number to a different, random, legal
      move number.
    */
    int min = 0;          //Minimum non goal cell is the start cell
    int max = (n*n) - 2; //Maximum non goal cell is n^2 - 2, since n^2 - 1 is goal
    int randNonGoalCell;
    int randNonGoalCellValue;
    
    Random randy = new Random();
    randNonGoalCell = randy.nextInt(max - min + 1) + min;

    int x = getXCell(randNonGoalCell,n);
    int y = getYCell(randNonGoalCell,n);

    //set max equal to the max legal jump of the random non goal cell
    max = getMaxLegalJump(x,y,n-1);
    randNonGoalCellValue = bestPuzzle[x][y];
    min = 1; // the minimum MOVE should be at least 1
    int newLegalRandomMove = randy.nextInt(max - min + 1) + min;

    //Prevent the new random move from being the same
    while(newLegalRandomMove == randNonGoalCellValue)
    {
      newLegalRandomMove = randy.nextInt(max - min + 1) + min;
    }
    newPuzzle[x][y] = newLegalRandomMove; //set the new random legal move
  }

  public int[][] getNewPuzzle(){
    return newPuzzle;
  }

  public void setbestPuzzleToNew(int[][] newPuzzle){
    for(int i = 0; i < newPuzzle.length; i++){
      for(int j = 0; j < newPuzzle[0].length; j++){
        bestPuzzle[i][j] = newPuzzle[i][j];
      }
    }
  }

  public int[][] getbestPuzzle(){
    return bestPuzzle;
  }

  public void setVisited(int[] visited){
    this.visited = visited;
  }

  public int[] getVisited(){
    return visited;
  }

  //For finding the max of {rmax - r, r - rmin, cmax - c, c - cmin}
  public int getMaxLegalJump(int row, int col, int max)
  {

    int a = max - row;
    int b = row - 1;
    int c = max - col;
    int d = col - 1;

    int[] tempArray = {b, c, d};
    int tempMax = a;

    for(int i = 0; i < 3; i++){
      if(tempMax < tempArray[i])
        tempMax = tempArray[i];
    }
    return tempMax;
  }

  public int getXCell(int v, int n)
  {
    if(v < n)
      return 0;
    else
      return v % n;
  }

  public int getYCell(int v, int n)
  {
    if(v < n)
      return v;
    else
      return v % n;
  }



}
