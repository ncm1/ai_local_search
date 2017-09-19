import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MainMenu extends JFrame implements ActionListener {

  JComboBox sizeBox = new JComboBox();
  JFormattedTextField hcTextBox = new JFormattedTextField(createFormatter("#######"));
  JButton next;

  public MainMenu() {

    super("Puzzle Generator");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel pane = new JPanel();
    pane.setLayout(null);

    //Setting the Title and location
    JLabel title = new JLabel("Puzzle Generator Main Menu");
    JLabel prompt = new JLabel("Please select the size of n:");
    JLabel hillClimbingPrompt = new JLabel("Please select the number of iterations for hill-climbing approach:");
    title.setBounds(150,50,600,100);

    Font font = new Font("Cambria", Font.BOLD, 30);
    title.setFont(font);
    Font font1 = new Font("Cambria", Font.BOLD, 20);
    prompt.setFont(font1);

    //Populate the sizebox with the possible puzzle sizes
    sizeBox.addItem(5);
    sizeBox.addItem(7);
    sizeBox.addItem(9);
    sizeBox.addItem(11);

    //Add next icon as a button on the gui
    ImageIcon next_Icon  = new ImageIcon("icons/next.gif");
    next = new JButton(next_Icon);

    next.setBounds(520,400,180,70);
    sizeBox.setBounds(500, 180, 50, 30);
    prompt.setBounds(180, 95, 350, 200);
    hillClimbingPrompt.setBounds(180,180,450,200);
    hcTextBox.setBounds(600, 250, 100, 30);

    next.addActionListener(this);

    //Add the title, prompt, sizebox, and next icon to the interface
    pane.add(title);
    pane.add(prompt);
    pane.add(sizeBox);
    pane.add(next);
    pane.add(hillClimbingPrompt);
    pane.add(hcTextBox);

    getContentPane().add(pane);
    setSize(800,800);
    setVisible(true);
}

  //*******************   Action Listener     **********************
  @Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

    if(source == next){
      	int n = (int)sizeBox.getSelectedItem();
        // need option for hill climbing
        int hcNumIter = Integer.parseInt(hcTextBox.getText());
        setVisible(false);
        ButtonGrid bg = new ButtonGrid(n,n);
        HillClimbing(bg, hcNumIter);
    }
  }
  public static void main(String[] args){
  //Call the MainMenu to initialize program
  MainMenu menu = new MainMenu();
  }

} //end class MainMenu
