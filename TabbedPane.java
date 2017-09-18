import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import javax.swing.table.*;
import javax.swing.JTable;

public class TabbedPane extends JFrame implements ActionListener
{
  //Create main tabePane object where each of the tabs will be placed
  JTabbedPane tabPane;

  StatsPane statsPane   = new StatsPane();
  PuzzlePane puzzlePane = new PuzzlePane();
  MovesPane movesPane   = new MovesPane();
  ButtonGrid bg;

  JButton cancel;
  JButton confirm;

  public TabbedPane(String initializer)
  {
    super("Artificial Intelligence");

    tabPane  = new JTabbedPane();

    //Create new jpanels for food, drink, appetizers, desserts, and bill
    JPanel initPane   =  getPuzzleMenu(initializer);
    //JPanel puzzle =
    //JPanel moves  =
    //JPanel stats  =

    //JPanel foodPane      = foodPane();
    //JPanel drinkPane     = drinkPane();
    //JPanel appetizerPane = appetizerPane();
    //JPanel dessertPane   = dessertPane();
    //JPanel billPane      = billPane(total);


    //Set up JScrollPane for scrolling ability in the food Pane
    /*JScrollPane scrollFrame = new JScrollPane(foodPane,
    ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    foodPane.setAutoscrolls(true);
    scrollFrame.setPreferredSize(new Dimension( 800,600));
    */
    /*
    //Set up JScrollPane for scrolling ability in the drink Pane
    JScrollPane scrollFrame2 = new JScrollPane(drinkPane,
    ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    drinkPane.setAutoscrolls(true);
    scrollFrame2.setPreferredSize(new Dimension(800,600));

    //Set up JScrollPane for scrolling ability in the drink Pane
    JScrollPane scrollFrame3 = new JScrollPane(appetizerPane,
    ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    appetizerPane.setAutoscrolls(true);
    scrollFrame3.setPreferredSize(new Dimension(800,600));
    */

    //Add all the scrollFrames to the JPanel
    //this.add(scrollFrame);
    //this.add(scrollFrame2);
    //this.add(scrollFrame3);

    //Adding the tabs to the JPanel
    //tabPane.add("Pane",  scrollFrame);
    //tabPane.add("Pane Name", scrollFrame2);
    //tabPane.add("Pane Name", scrollFrame3);
    //tabPane.add("Pane Name", scrollFrame4);
    //tabPane.add("Pane Name",  billPane);
    tabPane.add("Puzzle Initialization", initPane);
    tabPane.add("Puzzle", puzzlePane);
    tabPane.add("Puzzle Moves", movesPane);
    tabPane.add("Statistics", statsPane);


    //Adding all the components together to create the JFrame
    this.add(tabPane);
    setSize(800,600);
    setVisible(true);
}
//References: http://stackoverflow.com/questions/21636895/how-to-add-a-scroll-bar-to-a-jtabbedpane-basically-i-have-an-admin-panel-which

JComboBox sizeBox = new JComboBox();
JButton   generate;

public JPanel BasicPuzzleMenu() {
  //super("Basic Puzzle Generator");
  JPanel pane = new JPanel();

  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  pane.setLayout(null);

  //Setting the Title and location
  JLabel title = new JLabel("Basic Puzzle Generator Main Menu");
  JLabel prompt = new JLabel("Please select the size of n:");
  title.setBounds(150,50,600,100);

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
  generate = new JButton(generate_Icon);

  generate.setBounds(520,400,150,44);
  sizeBox.setBounds(500, 180, 50, 30);
  //prompt.setBounds(180, 95, 350, 200);
  sizeBox.setBounds(180, 95, 350, 200);
  generate.addActionListener(this);

  //Add the title, prompt, sizebox, and generate icon to the interface
  pane.add(title);
  pane.add(prompt);
  pane.add(sizeBox);
  pane.add(generate);

  getContentPane().add(pane);
  setSize(800,600);
  setVisible(true);

  return pane;
}

public JPanel getPuzzleMenu(String selected)
{
  JPanel puzzleMenuPanel = new JPanel();
  //TODO: IMPLEMENT!
  if(selected == "Basic Puzzle Evaluation"){
    puzzleMenuPanel = BasicPuzzleMenu();
    return puzzleMenuPanel;
  }
  //TODO: IMPLEMENT!
  else if(selected == "User Generated Puzzle Evaluation"){
    //puzzleMenuPanel = BasicPuzzleMenu();
    //return puzzleMenuPanel;
  }
  //TODO: IMPLEMENT!
  else if(selected == "Basic Hill Climbing"){
    //puzzleMenuPanel = BasicPuzzleMenu();
    //return puzzleMenuPanel;
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
    //puzzleMenuPanel = BasicPuzzleMenu();
    //return puzzleMenuPanel;
  }
  //TODO: IMPLEMENT!
  else if(selected == "Population Based Approach"){
    //puzzleMenuPanel = BasicPuzzleMenu();
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

    if(source == generate){
        int n = (int)sizeBox.getSelectedItem();
        //setVisible(false);
        //JFrame bg = new  JFrame();
        bg = new ButtonGrid(n,n);
        tabPane.setComponentAt(1, bg.getContentPane());
        //tabPane.setComponentAt(2,bg.getContentPane());
    }


    //Update each of the tabs here...
    //JPanel newBillPane = billPane(total);
    //tabPane.setComponentAt(4,newBillPane);

  }

}
