import javax.swing.JFrame; //imports JFrame library
import javax.swing.JPanel;
import javax.swing.JButton; //imports JButton library
import java.awt.GridLayout; //imports GridLayout library
import java.util.*;
import javax.swing.*;
import java.io.*;

public class ButtonGrid extends JFrame {

    JButton[][] grid; //names the grid of buttons
    int[][] puzzleArr;
    private Graph g;
    private int evaluationOutput;

    /*
    PRECONDITION: parameters width and length are INTEGERS and are of
    the same size
    POSTCONDITION: creates a ButtonGrid with a legal puzzle that will be able
    to be displayed
    */

    public ButtonGrid(int width, int length){
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
                //grid[x][y] = new JButton(holder + "{" + vert + "}");
                grid[x][y] = new JButton(holder +""); //creates new button
                puzzleArr[x][y] = holder;              //Add move to puzzle
              }
              frame.add(grid[x][y]); //adds button to grid
            }
        }
        getContentPane().add(frame);
        //setVisible(true); //makes frame visible
        setSize(800,600);
        //printArr(puzzleArr);
        //Create the digraph where the goal is located at n^2 - 1
        generateDigraph(puzzleArr, width);
    }
        /*
        PRECONDITION:
        POSTCONDITION:
        */

    public ButtonGrid(int[] puzzleArr){
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JPanel frame = new JPanel();
      frame.setLayout(null);

      Random randy = new Random();
      int width = (int)Math.sqrt(puzzleArr.length);
      int length = width;
      int max = width - 1;
      int min = 1;
      int vert;

      int compatabilityArr[][];//consequence of not generalizing things

      frame.setLayout(new GridLayout(width,length)); //set layout

      grid      = new JButton[width][length]; //allocate the size of grid
      compatabilityArr = new int[width][length]; //consequence of not generalizing things

      for(int x = 0; x < length; x++)
      {
          for(int y = 0; y < width; y++)
          {
              //Check for the "Goal" condition
              if(x == width - 1 && y == length - 1)
              {
                  grid[x][y] = new JButton("G");       //Set goal to G
                  compatabilityArr[x][y] = 0;//consequence of not generalizing things
              }
              //Else add the random number to the grid
              else
              {
                vert = x*width + y;
                grid[x][y] = new JButton(puzzleArr[vert] +""); //creates new button
                compatabilityArr[x][y] = puzzleArr[vert];      //consequence of not generalizing things
              }

              frame.add(grid[x][y]); //adds button to grid
            }
        }
        getContentPane().add(frame);
        //setVisible(true); //makes frame visible
        setSize(800,600);
        //printArr(puzzleArr);
        //Create the digraph where the goal is located at n^2 - 1
        generateDigraph(compatabilityArr, width);
    }

        /*
        PRECONDITION: INTEGER array visited is of size n, the constructor
        ButtonGrid(int,int) should be called first.
        POSTCONDITION: creates a Button Grid that corresponds to
        the number of moves needed to reach each vertex. Will also run the
        evaluationFunction and set the corresponding value
        */
    public ButtonGrid(int[] visited, int n){
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
            {
              grid[x][y] = new JButton(visited[vert] + ""); //creates new button
            }
            else
              grid[x][y] = new JButton("X");  //The location is not reachable
          }
          frame.add(grid[x][y]); //adds button to grid
        }
      }
      getContentPane().add(frame);
      setSize(800,600);
      evaluationFunction(visited,n);
    }
        /*
        PRECONDITION:
        POSTCONDITION:
        */
    public ButtonGrid(int[][] puzzleArr, int n){
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JPanel frame = new JPanel();
      frame.setLayout(null);

      Random randy = new Random();
      int width = n;
      int length = width;
      int max = width - 1;
      int min = 1;
      int holder = 0;
      int tempMax = 0;
      int vert;

      frame.setLayout(new GridLayout(width,length)); //set layout

      grid      = new JButton[width][length]; //allocate the size of grid

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
              }
              //Else add the random number to the grid
              else
              {
                grid[x][y] = new JButton(puzzleArr[x][y] +""); //creates new button
              }
              frame.add(grid[x][y]); //adds button to grid
            }
        }
        getContentPane().add(frame);
        //setVisible(true); //makes frame visible
        setSize(800,600);
        //printArr(puzzleArr);
    }
        /*
        PRECONDITION: generateDigraph() is called
        POSTCONDITION: returns the most recently graph generated
        */
        public Graph getGraph(){
          return g;
        }
        public int[][] getPuzzleArr(){
          return puzzleArr;
        }
        /*
        PRECONDITION: evaluationFunction() is called
        POSTCONDITION: returns the evaluation output  of the most recently
        generated puzzle
        */
        public int getEvaluationOutput(){
          return evaluationOutput;
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

        /*
        PRECONDITION:
        POSTCONDITION:
        */
        public void evaluationFunction(int[] visited, int n)
        {

          int goalValue = visited[visited.length - 1];

          //The case where the goal is reachable should set the evaluation
          //functions value to the minimum number of moves
          if( goalValue > 0)
          {
            this.evaluationOutput = goalValue;
            return;
          }
          //Set/Reset unreachable to -1 corresponding to the unreachable
          //status of the goal cell
          this.evaluationOutput = -1;
          for(int i = 1; i < visited.length -1; i++)
          {
            if(visited[i] == 0)
              this.evaluationOutput -= 1;
          }
        }//end evaluationFunction

        //*For Debugging can be removed
        public void printArr(int[][] arr){
          for(int i = 0; i < arr[0].length; i++){
            for(int j = 0; j < arr[0].length; j++){
              System.out.print(arr[i][j] + ", ");
            }
            System.out.print("\n");
          }
          System.out.print("\n");
        }

        public void writeArr(PrintWriter file, int[][] arr){
          for(int i = 0; i < arr[0].length; i++)
          {
            for(int j = 0; j < arr[0].length; j++)
            {
                file.write(arr[i][j] + " ");
              }
              file.write("\n");
            }
            file.write("\n");
        }

        /*
        PRECONDITION: arr is a TWO DIMENSINAL INTEGER array of size n*n
        POSTCONDITION: upon completion the digraph of the puzzle corresponding to
        the two dimensional array arr is created.
        */
        public void generateDigraph(int[][] arr, int n)
        {
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

          for(int i = 0; i < n; i++)
          {
            for(int j = 0; j < n; j++ )
            {
                //The current vertex location
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
                if( (rightChecker >= 0) && (rightChecker < n) )
                {
                  g.addEdge(currVertex, rightVertex, legalJump);
                  //System.out.println("Moving right..." + legalJump);
                  //System.out.println(currVertex + "->" + rightVertex);
                }
                if( (leftChecker >= 0) && (leftChecker < n) )
                {
                  g.addEdge(currVertex, leftVertex, legalJump);
                  //System.out.println("Moving left..." + legalJump);
                  //System.out.println(currVertex + "->" + leftVertex);
                }
                upVertex   = currVertex - n * legalJump;
                downVertex = currVertex + n * legalJump;
                //Checking the conditions the vertices above and below current
                //vertex are valid where the current vertexes can have values
                // [ 0, (n^2 - 1)] ex: n = 5, [0, 24]
                if( (upVertex >= 0) && (upVertex < n*n))
                {
                  g.addEdge(currVertex, upVertex, legalJump);
                  //System.out.println("Moving up..." + legalJump);
                  //System.out.println(currVertex + "->" + upVertex);
                }
                if( (downVertex >= 0) && (downVertex < n*n))
                {
                  g.addEdge(currVertex, downVertex, legalJump);
                  //System.out.println("Moving down..." + legalJump);
                  //System.out.println(currVertex + "->" + downVertex);
                }
          }//end inner for loop
        }//end outer for loop
      }//end generateDigraph()

}//end ButtonGrid Class

//Reference: http://www.wikihow.com/Make-a-GUI-Grid-in-Java
