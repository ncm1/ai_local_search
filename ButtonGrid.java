import javax.swing.JFrame; //imports JFrame library
import javax.swing.JButton; //imports JButton library
import java.awt.GridLayout; //imports GridLayout library
import java.util.*;

public class ButtonGrid {

        JFrame frame=new JFrame(); //creates frame
        JButton[][] grid; //names the grid of buttons
        int[][] puzzleArr;

        public ButtonGrid(int width, int length){ //constructor
                Random randy = new Random();
                int max = width - 1;
                int min = 1;
                int holder = 0;
                int tempMax = 0;

                frame.setLayout(new GridLayout(width,length)); //set layout

                grid      = new JButton[width][length]; //allocate the size of grid
                puzzleArr = new int[width][length];

                for(int x = 0; x < length; x++)
                {
                  for(int y = 0; y < width; y++)
                  {
                    //Find the max legal jump
                    tempMax = getMaxLegalJump(x, y, max);
                    //get a random move that is valid in at least one direction
                    holder = randy.nextInt(tempMax - min + 1) + min;

                    //Check for the "Goal" condition
                    if(x == width - 1 && y == length - 1)
                    {
                        grid[x][y] = new JButton("G");       //Set goal to G
                        puzzleArr[x][y] = 1000;
                    }
                    //Else add the random number to the grid
                    else
                    {
                      grid[x][y] = new JButton(holder + ""); //creates new button
                      puzzleArr[x][y] = holder;              //Add move to puzzle
                    }
                    frame.add(grid[x][y]); //adds button to grid
                  }
                }

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack(); //sets appropriate size for frame
                frame.setVisible(true); //makes frame visible

                printArr(puzzleArr);
                //generateDigraph(puzzleArr, width);
        }

        //For finding the max of {rmax - r, r - rmin, cmax - c, c - cmin}
        public int getMaxLegalJump(int row, int col, int max){

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

        public void printArr(int[][] arr){
          for(int i = 0; i < arr[0].length; i++){
            for(int j = 0; j < arr[0].length; j++){
              System.out.print(arr[i][j] + ", ");
            }
            System.out.print("\n");
          }
          System.out.print("\n");
        }

        public static void main(String[] args) {
                new ButtonGrid(5,5);//makes new ButtonGrid with 2 parameters
        }
}

//Reference: http://www.wikihow.com/Make-a-GUI-Grid-in-Java
