import java.util.Random;

public class HillClimbing
{
  int[][] newPuzzle;
  int[][] currPuzzle;
  int n;
  /*
    This function takes a two dim array as input and chooses a random
    non-goal cell and changes the number to a different, random, legal
    move number.
  */
  HillClimbing(int[][] arr, int n)
  {
    this.n = n;
    this.currPuzzle = new int[n][n];
    this.newPuzzle  = new int[n][n];
    this.currPuzzle = arr.clone();
    this.newPuzzle  = arr.clone();
  }

  public void hillClimb()
  {
    Random randy = new Random();
    int min = 0;          //Minimum non goal cell is the start cell
    int max = (n*n) - 2; //Maximum non goal cell is n^2 - 2, since n^2 - 1 is goal
    int randNonGoalCell;
    int randNonGoalCellValue;
    randNonGoalCell = randy.nextInt(max - min + 1) + min;

    int x = getXCell(randNonGoalCell,n);
    int y = getYCell(randNonGoalCell,n);

    //set max equal to the max legal jump of the random non goal cell
    max = getMaxLegalJump(x,y,n-1);
    randNonGoalCellValue = currPuzzle[x][y];
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
      return v / n;
  }

  public int getYCell(int v, int n)
  {
    if(v < n)
      return v;
    else
      return v % n;
  }



}
