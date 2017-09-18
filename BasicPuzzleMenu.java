import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class BasicPuzzleMenu extends JPanel implements ActionListener{

  JComboBox sizeBox  = new JComboBox();
  JButton   generate = new JButton("Generate");

  public BasicPuzzleMenu() {
    //super("Basic Puzzle Generator");
    JPanel pane = new JPanel();
    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pane.setLayout(null);

    //Setting the Title and location
    JLabel title = new JLabel("Basic Puzzle Generator Main Menu");
    JLabel prompt = new JLabel("Please select the size of n:");
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

    //Add generate icon as a button on the gui
    //ImageIcon generate_Icon  = new ImageIcon("icons/generate.gif");
    generate = new JButton("Generate");

    generate.setBounds(520,400,180,70);
    sizeBox.setBounds(500, 180, 50, 30);
    prompt.setBounds(180, 95, 350, 200);

    generate.addActionListener(this);

    //Add the title, prompt, sizebox, and generate icon to the interface
    pane.add(title);
    pane.add(prompt);
    pane.add(sizeBox);
    pane.add(generate);

    //getContentPane().add(pane);
    setSize(800,600);
    setVisible(true);
}

  //*******************   Action Listener     **********************
  @Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

    if(source == generate){
      	int n = (int)sizeBox.getSelectedItem();
        setVisible(false);
        ButtonGrid bg = new ButtonGrid(n,n);
    }
  }

/*public static void main(String[] args){
  //Call the MainMenu to initialize program
  BasicPuzzleMenu menu = new BasicPuzzleMenu();
}*/

} //end class BasicPuzzleMenu
