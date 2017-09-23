import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.math.*;
import java.text.NumberFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.*;
import javax.swing.text.NumberFormatter;

import java.io.*;

public class TabbedPane extends JFrame implements ActionListener


{
  //Create main tabePane object where each of the tabs will be placed
  JTabbedPane tabPane;

  DataPane dataPane     = new DataPane();
  PuzzlePane puzzlePane = new PuzzlePane();
  MovesPane movesPane   = new MovesPane();
  ButtonGrid bg;
  ButtonGrid puzzleMoves;

  JButton confirm;

  public TabbedPane(String initializer)
  {
    super("Artificial Intelligence");

    tabPane  = new JTabbedPane();

    //Create new jpanels for food, drink, appetizers, desserts, and bill
    JPanel initPane   =  getPuzzleMenu(initializer);

    //Adding the tabs to the JTabbedPane
    tabPane.add("Puzzle Initialization", initPane);
    tabPane.add("Puzzle", puzzlePane);
    tabPane.add("Puzzle Moves", movesPane);
    tabPane.add("Puzzle Data", dataPane);

    //Adding all the components together to create the JFrame
    this.add(tabPane);
    setSize(800,600);
    setVisible(true);
}
//References: http://stackoverflow.com/questions/21636895/how-to-add-a-scroll-bar-to-a-jtabbedpane-basically-i-have-an-admin-panel-which

//This will be used for basic puzzle menu, basic hill climbing,
JComboBox sizeBox = new JComboBox();
JButton   cancel;
//Basic user menu will contain a combobox as well as a generate button
JButton   basicGenerate;
//User generated menu will contain a confirm button as well as a text field
// for inputting a file
JButton    userConfirm;
JTextField userField;
//Basic Hill Climbing needs a JButton for the number of iterations
JComboBox iterBox = new JComboBox();
JButton basicHillGenerate;
JButton simulatedAnnealingGenerate;
JButton populationApproachGenerate;

//JTextField initTempField = new JTextField();
//JTextField tempDecayRateField = new JTextField();
JComboBox initTempField = new JComboBox();
JComboBox tempDecayRateField = new JComboBox();

JComboBox iterEndTimeBox = new JComboBox();
/*
public JPanel PopulationPuzzleMenu(){

}
*/

public JPanel SimulatedAnnealingPuzzleMenu() {
  JPanel pane = new JPanel();

  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  pane.setLayout(null);

  //Setting the Title and location
  JLabel title  = new JLabel("Simulated Annealing Puzzle Menu");
  title.setBounds(150,50,600,100);
  Font font = new Font("Cambria", Font.BOLD, 30);
  title.setFont(font);

  
  JLabel iterPrompt = new JLabel("Please select the number of iterations:");
  JLabel initTempPrompt = new JLabel("Please select the initial temperature: ");
  JLabel tempDecayRatePrompt = new JLabel("Please select the decay rate: ");
  JLabel sizePrompt = new JLabel("Size:");

  //Setting the default text to display
  sizeBox.setPrototypeDisplayValue("Size");
  //Populate the sizebox with the possible puzzle sizes
  sizeBox.addItem(5);
  sizeBox.addItem(7);
  sizeBox.addItem(9);
  sizeBox.addItem(11);

  for(int i = 50; i <= 1000; i++){
    iterBox.addItem(i);

  }

  for (float i = 0; i <= 1000; i=i+1){
	initTempField.addItem(i);
    tempDecayRateField.addItem((Float) (i/1000));
  }

  //Add generate icon as a button on the gui
  ImageIcon generate_Icon  = new ImageIcon("icons/generate.png");
  simulatedAnnealingGenerate = new JButton(generate_Icon);
  ImageIcon cancel_Icon = new ImageIcon("icons/back.png");
  cancel = new JButton(cancel_Icon);

  simulatedAnnealingGenerate.setBounds(600,480,150,44);
  cancel.setBounds(100,480,120,44);
  sizePrompt.setBounds(120, 40, 200, 200);
  sizeBox.setBounds(120, 150, 200, 100);
  iterPrompt.setBounds(120, 190, 250,200);
  iterBox.setBounds(120, 300, 200, 100);
  initTempPrompt.setBounds(450,40,250,200);
  initTempField.setBounds(450,150,200,100);
  tempDecayRatePrompt.setBounds(450,190,250,200);
  tempDecayRateField.setBounds(450,300,200,100);

  simulatedAnnealingGenerate.addActionListener(this);
  cancel.addActionListener(this);
  sizeBox.addActionListener(this);
  iterBox.addActionListener(this);
  initTempField.addActionListener(this);
  tempDecayRateField.addActionListener(this);
  //System.out.println("I'm here at least");

  //Add the title, prompt, sizebox, and generate icon to the interface
  pane.add(title);
  pane.add(sizePrompt);
  pane.add(sizeBox);
  pane.add(iterBox);
  pane.add(iterPrompt);
  pane.add(iterBox);
  pane.add(initTempPrompt);
  pane.add(initTempField);
  pane.add(tempDecayRatePrompt);
  pane.add(tempDecayRateField);
  pane.add(simulatedAnnealingGenerate);
  pane.add(cancel);

  getContentPane().add(pane);
  setSize(800,600);
  setVisible(true);

  return pane;
}

public JPanel BasicPuzzleMenu() {
  JPanel pane = new JPanel();

  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  pane.setLayout(null);

  //Setting the Title and location
  JLabel title = new JLabel("Basic Puzzle Generator Main Menu");
  JLabel prompt = new JLabel("Please select the size of n:");
  title.setBounds(110,50,600,100);

  Font font = new Font("Cambria", Font.BOLD, 30);
  title.setFont(font);
  Font font1 = new Font("Cambria", Font.BOLD, 20);
  prompt.setFont(font1);

  //Setting the default text to display
  sizeBox.setPrototypeDisplayValue("Size");
  //Populate the sizebox with the possible puzzle sizes
  sizeBox.addItem(5);
  sizeBox.addItem(7);
  sizeBox.addItem(9);
  sizeBox.addItem(11);

  //Add generate icon as a button on the gui
  ImageIcon generate_Icon  = new ImageIcon("icons/generate.png");
  basicGenerate = new JButton(generate_Icon);
  ImageIcon cancel_Icon = new ImageIcon("icons/back.png");
  cancel = new JButton(cancel_Icon);

  basicGenerate.setBounds(520,400,150,44);
  cancel.setBounds(150,395,150,44);
  sizeBox.setBounds(190, 95, 150, 200);
  basicGenerate.addActionListener(this);
  cancel.addActionListener(this);

  //Add the title, prompt, sizebox, and generate icon to the interface
  pane.add(title);
  pane.add(prompt);
  pane.add(sizeBox);
  pane.add(basicGenerate);
  pane.add(cancel);

  getContentPane().add(pane);
  setSize(800,600);
  setVisible(true);

  return pane;
}

public JPanel UserPuzzleMenu() {
  JPanel pane = new JPanel();

  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  pane.setLayout(null);

  //Setting the Title and location
  JLabel title = new JLabel("User Generated Puzzle Main Menu");
  title.setBounds(110,50,600,100);
  Font font = new Font("Cambria", Font.BOLD, 30);
  title.setFont(font);

  //Add generate icon as a button on the gui
  ImageIcon confirm_Icon  = new ImageIcon("icons/confirm.png");
  userConfirm = new JButton(confirm_Icon);
  ImageIcon cancel_Icon = new ImageIcon("icons/back.png");
  cancel = new JButton(cancel_Icon);
  userField = new JTextField("./userPuzzles/assignmentPuzzle.txt");

  userConfirm.setBounds(520,400,150,44);
  cancel.setBounds(150,395,150,44);
  userField.setBounds(270, 150, 250, 50);
  userConfirm.addActionListener(this);
  cancel.addActionListener(this);
  //userField.addActionListener(this);

  //Add the title, prompt, sizebox, and generate icon to the interface
  pane.add(title);
  pane.add(userField);
  pane.add(userConfirm);
  pane.add(cancel);

  getContentPane().add(pane);
  setSize(800,600);
  setVisible(true);

  return pane;
}

public JPanel BasicHillClimbingPuzzleMenu() {
  JPanel pane = new JPanel();

  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  pane.setLayout(null);

  //Setting the Title and location
  JLabel title  = new JLabel("Basic Hill Climbing Main Menu");
  title.setBounds(150,50,600,100);
  Font font = new Font("Cambria", Font.BOLD, 30);
  title.setFont(font);

  JLabel sizePrompt = new JLabel("Please select a size n");
  JLabel iterPrompt = new JLabel("Please select the number of iterations:");

  //Setting the default text to display
  sizeBox.setPrototypeDisplayValue("Size");
  //Populate the sizebox with the possible puzzle sizes
  sizeBox.addItem(5);
  sizeBox.addItem(7);
  sizeBox.addItem(9);
  sizeBox.addItem(11);

  for(int i = 10; i <= 100000; i+= 250)
    iterBox.addItem(i);

  //Add generate icon as a button on the gui
  ImageIcon generate_Icon  = new ImageIcon("icons/generate.png");
  basicHillGenerate = new JButton(generate_Icon);
  ImageIcon cancel_Icon = new ImageIcon("icons/back.png");
  cancel = new JButton(cancel_Icon);

  basicHillGenerate.setBounds(520,400,150,44);
  cancel.setBounds(150,390,150,44);
  sizePrompt.setBounds(300, 70, 200, 200);
  sizeBox.setBounds(270, 150, 200, 100);

  iterPrompt.setBounds(260, 190, 250,200);
  iterBox.setBounds(280, 300, 200, 100);
  basicHillGenerate.addActionListener(this);
  cancel.addActionListener(this);
  sizeBox.addActionListener(this);
  iterBox.addActionListener(this);
  //System.out.println("I'm here at least");

  //Add the title, prompt, sizebox, and generate icon to the interface
  pane.add(title);
  pane.add(sizePrompt);
  pane.add(sizeBox);
  pane.add(iterBox);
  pane.add(iterPrompt);
  pane.add(basicHillGenerate);
  pane.add(cancel);

  getContentPane().add(pane);
  setSize(800,600);
  setVisible(true);

  return pane;
}

public JPanel getPuzzleMenu(String selected) {
  JPanel puzzleMenuPanel = new JPanel();
  //Basic Puzzle Evaluation is for generating random puzzles, generally
  //puzzles are not very "difficult"
  if(selected == "Basic Puzzle Evaluation"){
    puzzleMenuPanel = BasicPuzzleMenu();
    return puzzleMenuPanel;
  }
  //User Generated puzzles are those pre made by the user that have been
  //saved in a text file
  else if(selected == "User Generated Puzzle Evaluation"){
    puzzleMenuPanel = UserPuzzleMenu();
    return puzzleMenuPanel;
  }
  //TODO: IMPLEMENT!
  else if(selected == "Basic Hill Climbing"){
    puzzleMenuPanel = BasicHillClimbingPuzzleMenu();
    return puzzleMenuPanel;
  }
  //TODO: IMPLEMENT!
  else if(selected == "Hill Climbing with Random Restarts"){
    //puzzleMenuPanel = BasicPuzzleMenu();
    //return puzzleMenuPanel;
  }
  //TODO: IMPLEMENT!
  else if(selected == "Hill Climbing with Random Walk"){
    //puzzleMenuPanel = BasicPuzzleMenu();
    //return puzzleMenuPanel;
  }

  //TODO: IMPLEMENT!
  else if(selected == "Simulated Annealing"){
    puzzleMenuPanel = SimulatedAnnealingPuzzleMenu();
    return puzzleMenuPanel;
  }
  //TODO: IMPLEMENT!
  else if(selected == "Population Based Approach"){
    //puzzleMenuPanel = PopulationPuzzleMenu();
    //return puzzleMenuPanel;
  }
  return puzzleMenuPanel;
}


/*
*       OVERRIDING THE ACTION LISTENER
*       TO ACCOUNT FOR ALL OF THE POSSIBLE
*       BUTTON CLICKS ACCORDINGLY
*/
  @Override
  public void actionPerformed(ActionEvent e)
  {
    Object source = e.getSource();

    if(source == basicGenerate)
    {
        int n = (int)sizeBox.getSelectedItem();

        bg = new ButtonGrid(n,n);
        tabPane.setComponentAt(1, bg.getContentPane());
        //Getting the corresponding graph to create movesPane
        Graph g = bg.getGraph();
        int sqr = n*n;
        int[] visited = new int[sqr];
        visited = g.bfs(0);
        //Call ButtonGrid constructor to create the puzzle moves pane
        puzzleMoves = new ButtonGrid(visited, n);
        tabPane.setComponentAt(2,puzzleMoves.getContentPane());

        dataPane = new DataPane(puzzleMoves.getEvaluationOutput());
        tabPane.setComponentAt(3,dataPane);
    }//end basic user generated action listener


    if(source == userConfirm)
    {
      String fileName = (String)userField.getText();
      if(fileName != null)
      {
        System.out.println(fileName);
        FileToMatrix ftm = new FileToMatrix(fileName);
        //Get the length of the puzzle
        int puzzleArrLen = ftm.getPuzzleArr().length;
        bg = new ButtonGrid(ftm.getPuzzleArr());
        tabPane.setComponentAt(1, bg.getContentPane());

        //Getting the corresponding graph to create movesPane
        Graph g = bg.getGraph();
        int[] visited = new int[puzzleArrLen];
        visited = g.bfs(0);

        int sqrRoot = (int)Math.sqrt(puzzleArrLen);
        //Call ButtonGrid constructor to create the puzzle moves pane
        puzzleMoves = new ButtonGrid(visited, sqrRoot);
        tabPane.setComponentAt(2,puzzleMoves.getContentPane());

        dataPane = new DataPane(puzzleMoves.getEvaluationOutput());
        tabPane.setComponentAt(3,dataPane);
      }
    }//end user generated puzzle action listener

      //Handles the Basic Hill Climbing evaluation methods
    if(source == basicHillGenerate)
    {

        /*PrintWriter maxEvalFile = null;
        try{
          maxEvalFile = new PrintWriter(new FileWriter("./basicHillClimbingPuzzles/maxEval.txt", true));
        }catch (IOException i) {
        // TODO Auto-generated catch block
        i.printStackTrace();
      }*/

        

        int n    = (int)sizeBox.getSelectedItem();
        int iter = (int)iterBox.getSelectedItem();

        long startTime = System.currentTimeMillis();
        bg = new ButtonGrid(n,n);
        //tabPane.setComponentAt(1, bg.getContentPane());

        //Getting the corresponding graph to create movesPane
        Graph g = bg.getGraph();
        int sqr = n*n;
        int[] visited = new int[sqr];
        int[][] currBestPuzzle = new int[n][n];
        int[][] tempPuzzle     = new int[n][n];
        currBestPuzzle = bg.getPuzzleArr();

        visited = g.bfs(0);
        //Call ButtonGrid constructor to create the puzzle moves pane
        puzzleMoves = new ButtonGrid(visited, n);
        //tabPane.setComponentAt(2,puzzleMoves.getContentPane());

        //dataPane = new DataPane(puzzleMoves.getEvaluationOutput());
        //tabPane.setComponentAt(3,dataPane);

        //get the evalOutput for the first puzzle
        int maxEvalOutput = puzzleMoves.getEvaluationOutput();
        //create a currEvalOutput variable to compare to the maxEvalOutput
        int currEvalOutput = 0;

        HillClimbing hClimb = new HillClimbing(currBestPuzzle, n);
        hClimb.setVisited(visited);

        for(int iterations = 0; iterations < iter; iterations++)
        {
          //Method hillClimb chooses a random non goal cell and then replaces
          //it with a new legal random move
          hClimb.hillClimb();
          //Generate the new directed graph and perform bfs
          bg.generateDigraph(hClimb.getNewPuzzle(), n);
          g = bg.getGraph();
         
          //set visited to the set of puzzle moves and finally compare
          //the evaluation output
          visited = g.bfs(0);
          //We need to get the new evaluation function output now, we can use
          //the method avaliable in the ButtonGrid class
          bg.evaluationFunction(visited,n);
          currEvalOutput = bg.getEvaluationOutput();

          /*
              FOR DEBUGGING CAN BE REMOVED TO IMPROVE PERFORMANCE
          */

          System.out.println("maxEvalOutput: " + maxEvalOutput);
          bg.printArr(hClimb.getbestPuzzle());

          System.out.println("currEvalOutput: " + currEvalOutput);
          bg.printArr(hClimb.getNewPuzzle());
          //System.out.println("Curr")

          if(currEvalOutput >= maxEvalOutput)
          {
            //Set the new evaluation output
            maxEvalOutput = currEvalOutput;
            hClimb.setbestPuzzleToNew(hClimb.getNewPuzzle());
            currBestPuzzle = hClimb.getNewPuzzle();
            hClimb.setVisited(visited);
            //bestPuzzleFile.createNewFile();
          }
          //maxEvalFile.println(maxEvalOutput);
        }//end for loop
        //Calculate the end time and the total time by subtracting end from start

        bg = new ButtonGrid(hClimb.getbestPuzzle(), n);
        tabPane.setComponentAt(1, bg.getContentPane());

        visited = hClimb.getVisited();
        puzzleMoves = new ButtonGrid(visited,n);
        tabPane.setComponentAt(2,puzzleMoves.getContentPane());
        dataPane = new DataPane(puzzleMoves.getEvaluationOutput(), evaluationTime);
        tabPane.setComponentAt(3,dataPane);
        //maxEvalFile.close();

      }//end basic Hill Climbing action listener

    if(source == simulatedAnnealingGenerate)
    {
        int n = (int)sizeBox.getSelectedItem();
        int iter = (int)iterBox.getSelectedItem();
        float initTemp = (Float) initTempField.getSelectedItem();
        float decayRate = (Float) tempDecayRateField.getSelectedItem();
        float temp = initTemp;
        
        //tabPane.setComponentAt(1, bg.getContentPane());
        long startTime = System.currentTimeMillis();

        Random randy = new Random();
        
        int val;
        bg = new ButtonGrid(n,n);
    	  bg.evaluationFunction(bg.getGraph().bfs(0), n);
    	  
        int prevVal = bg.getEvaluationOutput();
        
        ButtonGrid puzzleBG = bg; 
        //iteration loop
        for (int i = 0; i < iter; ++i){
        	temp = temp * decayRate;
        	bg = new ButtonGrid(n,n);
        	bg.evaluationFunction(bg.getGraph().bfs(0), n);
        	val = bg.getEvaluationOutput(); // val is evaluation value
	        	 if ( val > prevVal){ // if evaluation value of current puzzle config is greater than ev. value of previous puzzle config
		        	 prevVal = val;
		        	 puzzleBG = bg;
	        	 }
	        	 else if ( val <= prevVal){ // if evaluation value of current puzzle config is lte than ev. value of previous puzzle config
	        		 if (randy.nextFloat() < Math.exp((double)(val - prevVal )/temp)){ //  probability condition met
		        		  prevVal = val;
		        		  puzzleBG = bg;
	        		 }
		        	 else {// probability failed // taking higher value
		        		  prevVal = prevVal;
		        	 }
	        	 }
        	 temp = temp*decayRate; //apply decay to temp
           //System.out.println(temp);
       }
        long endTime = System.currentTimeMillis();
        long evaluationTime = endTime - startTime;
        tabPane.setComponentAt(1, puzzleBG.getContentPane());
        puzzleMoves = new ButtonGrid(puzzleBG.getGraph().bfs(0), n);
        tabPane.setComponentAt(2,puzzleMoves.getContentPane());
        dataPane = new DataPane(puzzleMoves.getEvaluationOutput(), evaluationTime);
        tabPane.setComponentAt(3,dataPane);


    }
    if(source == populationApproachGenerate)
    {
        int n = (int)sizeBox.getSelectedItem();
        long iterEndTime = (int)iterEndTimeBox.getSelectedItem();
        
        //tabPane.setComponentAt(1, bg.getContentPane());
        long startTime = System.currentTimeMillis();
        long endTime;
        long evaluationTime;

        Random randy = new Random();
        
        int val;
        bg = new ButtonGrid(n,n);
        bg.evaluationFunction(bg.getGraph().bfs(0), n);
        
        int prevVal = bg.getEvaluationOutput();
        
        ButtonGrid puzzleBG = bg; 
        //iteration loop
        long elapsedTime = 0;
        for (int i = 0; i < 10000000; ++i){
          
           //System.out.println(temp);
          endTime = System.currentTimeMillis();
          evaluationTime = endTime - startTime;
          elapsedTime += evaluationTime;
          if (elapsedTime >= iterEndTime){
        	  break;
          }
       }
         
        tabPane.setComponentAt(1, puzzleBG.getContentPane());
        puzzleMoves = new ButtonGrid(puzzleBG.getGraph().bfs(0), n);
        tabPane.setComponentAt(2,puzzleMoves.getContentPane());
        //dataPane = new DataPane(puzzleMoves.getEvaluationOutput(), evaluationTime);
        tabPane.setComponentAt(3,dataPane);


    }

      if(source == cancel)
      {
        setVisible(false);
        MainMenu mainMenu = new MainMenu();
        
      }

  }//end action listener here

}
