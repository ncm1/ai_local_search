import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MainMenu extends JFrame implements ActionListener {

  JComboBox puzzleBox = new JComboBox();
  JButton confirm;

  public MainMenu() {

    super("Puzzle Evaluation Main Menu");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel pane = new JPanel();
    pane.setLayout(null);

    //Setting the Title and location
    JLabel title = new JLabel("Puzzle Evaluation Main Menu");
    title.setBounds(175,50,600,100);

    Font font = new Font("Cambria", Font.BOLD, 30);
    title.setFont(font);

    //Setting the default text to display
    puzzleBox.setPrototypeDisplayValue("Choose a type of puzzle evaluation");
    //Populate the combobox with the possible options
    puzzleBox.addItem("Basic Puzzle Evaluation");
    puzzleBox.addItem("User Generated Puzzle Evaluation");
    puzzleBox.addItem("Basic Hill Climbing");
    puzzleBox.addItem("Hill Climbing with Random Restarts");
    puzzleBox.addItem("Hill Climbing with Random Walk");
    puzzleBox.addItem("Simulated Annealing");
    puzzleBox.addItem("Population Based Approach");

    //Add confirm icon as a button on the gui
    ImageIcon confirm_Icon  = new ImageIcon("icons/confirm.png");
    confirm = new JButton(confirm_Icon);

    confirm.setBounds(520,400,150,44);
    puzzleBox.setBounds(235, 150, 350, 200);
    confirm.addActionListener(this);

    //Add the title, puzzleBox, and confirm icon to the interface
    pane.add(title);
    pane.add(puzzleBox);
    pane.add(confirm);

    getContentPane().add(pane);
    setSize(800,600);
    setVisible(true);
}

  //*******************   Action Listener     **********************
  @Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

    if(source == confirm){
      	String selected = (String)puzzleBox.getSelectedItem();
        setVisible(false);
        System.out.println("selected: " + selected);
        TabbedPane tp = new TabbedPane(selected);
        //ButtonGrid bg = new ButtonGrid(n,n);
    }
  }

public static void main(String[] args){
  //Call the MainMenu to initialize program
  MainMenu menu = new MainMenu();
}

} //end class MainMenu
