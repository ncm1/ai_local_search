import javax.swing.JFrame; //imports JFrame library
import javax.swing.JPanel;
import javax.swing.JButton; //imports JButton library
import java.awt.GridLayout; //imports GridLayout library
import java.util.*;
import javax.swing.*;

public class ButtonGrid extends JFrame {

    JButton[][] grid; //names the grid of buttons
    int[][] puzzleArr;
    Graph g;

    public ButtonGrid(int width, int length){ //constructor
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel frame = new JPanel();
        frame.setLayout(null);

        Random randy = new Random();
        int max = width - 1;
        int min = 1;
        int holder = 0;
        int tempMax = 0;
        int vert;

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
                    puzzleArr[x][y] = 0;
                }
                //Else add the random number to the grid
                else
                {
                  vert = x*width + y;
                  grid[x][y] = new JButton(holder + "{" + vert + "}"); //creates new button
                  puzzleArr[x][y] = holder;              //Add move to puzzle
                }
                frame.add(grid[x][y]); //adds button to grid
              }
          }

          //frame.pack(); //sets appropriate size for frame
          getContentPane().add(frame);
          //setVisible(true); //makes frame visible
          setSize(800,600);

          printArr(puzzleArr);
          //Create the digraph where the goal is located at n^2 - 1
          generateDigraph(puzzleArr, width);
        }

        public ButtonGrid(int[] visited, int n)
        {
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          JPanel frame = new JPanel();
          frame.setLayout(null);

          int vert;
          int width  = n;
          int length = n;

          frame.setLayout(new GridLayout(width,length)); //set layout
          grid      = new JButton[width][length]; //allocate the size of grid

          for(int x = 0; x < length; x++)
          {
            for(int y = 0; y < width; y++)
            {
              if(x == 0 && y == 0)
              {
                  grid[x][y] = new JButton(0 + "");       //Set start to 0
              }
              //Else add the number of moves to the grid
              else
              {
                vert = x*width + y;
                if(visited[vert] != 0)
                  grid[x][y] = new JButton(visited[vert] + ""); //creates new button
                else
                  grid[x][y] = new JButton("X");  //The location is not reachable
              }
              frame.add(grid[x][y]); //adds button to grid
            }
          }
          getContentPane().add(frame);
          setSize(800,600);
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

        public void generateDigraph(int[][] arr, int n){
          g = new Graph(n*n);

          int currVertex;   //curr vertex stores the current vertex x*n + y
          int legalJump;    //integer for storing the legal jump of curr vert
          int rightChecker; //integer for checking the right side bounds
          int leftChecker;  //integer for checking the left side bounds

          //Declarations of integers for holding right,left,up, and down vertices
          int rightVertex;
          int leftVertex;
          int upVertex;
          int downVertex;

          for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++ ){

              currVertex = i * n + j;
              legalJump  = arr[i][j]; //the legal jump for curr vertex

              //Normalizing the the row to check if right/left are in bounds
              rightChecker = currVertex - n*i;
              leftChecker  = currVertex - n*i;

              //Check whether up, down, left, or right are valid jumps
              rightChecker += legalJump;
              leftChecker  -= legalJump;
              //setting rightvertex and left vertex to their positions if they
              //are valid
              rightVertex = currVertex + legalJump;
              leftVertex  = currVertex - legalJump;

              //Should fall within the bounds [0, n - 1] for the move to be valid
              if( (rightChecker >= 0) && (rightChecker < n) ){
                g.addEdge(currVertex, rightVertex, legalJump);
                System.out.println("Moving right..." + legalJump);
                System.out.println(currVertex + "->" + rightVertex);
              }
              if( (leftChecker >= 0) && (leftChecker < n) ) {
                g.addEdge(currVertex, leftVertex, legalJump);
                System.out.println("Moving left..." + legalJump);
                System.out.println(currVertex + "->" + leftVertex);
              }

              upVertex   = currVertex - n * legalJump;
              downVertex = currVertex + n * legalJump;
              //Checking the conditions the vertices above and below current
              //vertex are valid where the current vertexes can have values
              // [ 0, (n^2 - 1)] ex: n = 5, [0, 24]
              if( (upVertex >= 0) && (upVertex < n*n)) {
                g.addEdge(currVertex, upVertex, legalJump);
                System.out.println("Moving up..." + legalJump);
                System.out.println(currVertex + "->" + upVertex);
              }

              if( (downVertex >= 0) && (downVertex < n*n)) {
                g.addEdge(currVertex, downVertex, legalJump);
                System.out.println("Moving down..." + legalJump);
                System.out.println(currVertex + "->" + downVertex);
              }
          }
        }
      }

      public Graph getGraph(){
        return g;
      }
}

//Reference: http://www.wikihow.com/Make-a-GUI-Grid-in-Java
