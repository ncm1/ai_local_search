import java.util.Random;

public class GenerateLegalPuzzle{

int[][] puzzleArr;

public void generateLegalPuzzle(int n){
  Random randy = new Random();
  int max = n - 1;
  int min = 1;
  int holder = 0;
  int tempMax = 0;
  int vert;

  int width = n;
  int length = n;

  for(int x = 0; x < length; x++)
  {
    for(int y = 0; y < width; y++)
    {
      //Find the max legal jump
      tempMax = getMaxLegalJump(n, max);
      //get a random move that is valid in at least one direction
      holder = randy.nextInt(tempMax - min + 1) + min;

      //Check for the "Goal" condition
      if(x == width - 1 && y == length - 1)
      {
          puzzleArr[x][y] = 1000;
      }
      //Else add the random number to the grid
      else
      {
        vert = x*width + y;
        puzzleArr[x][y] = holder;              //Add move to puzzle
      }
    }
  }

}

//For finding the max of {rmax - r, r - rmin, cmax - c, c - cmin}
public int getMaxLegalJump(int n, int max){
  int a = max - n;
  int b = n - 1;
  int c = max - n;
  int d = n - 1;

  int[] tempArray = {b, c, d};
  int tempMax = a;

  for(int i = 0; i < 3; i++){
    if(tempMax < tempArray[i])
      tempMax = tempArray[i];
  }
  return tempMax;
}

public int[][] getPuzzleArr(){
  return puzzleArr;
}

}
