import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class DataPane extends JPanel
{
  JLabel title = new JLabel("Puzzle Data");
  JLabel evaluationFunc;
  JLabel evaluationTimeLabel;
  JLabel prompt = new JLabel("Please select the size of n:");

    public DataPane()
    {
        /*generate.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "You just clicked button");
            }
        });*/


        Font font = new Font("Cambria", Font.BOLD, 30);
        title.setFont(font);
        Font font1 = new Font("Cambria", Font.BOLD, 20);
        prompt.setFont(font1);

        prompt.setBounds(180, 95, 350, 200);
        setSize(800,600);

        add(title);
        add(prompt);
    }

    public DataPane(int evaluation)
    {
      Font font = new Font("Cambria", Font.BOLD, 30);
      evaluationFunc = new JLabel("Evaluation function output: " + evaluation);
      evaluationFunc.setFont(font);
      evaluationFunc.setBounds(520,400,180,70);


      add(evaluationFunc);

    }

    public DataPane(int evaluation, long evaluationTime)
    {
      Font font = new Font("Cambria", Font.BOLD, 30);
      evaluationFunc = new JLabel("Evaluation function output: " + evaluation);
      evaluationTimeLabel = new JLabel("Total Evaluation Time: " + evaluationTime + "ms");
      evaluationFunc.setFont(font);
      evaluationTimeLabel.setFont(font);

      evaluationFunc.setBounds(520,400,180,70);
      evaluationTimeLabel.setBounds(520, 700, 180, 70);

      add(evaluationFunc);
      add(evaluationTimeLabel);
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        g.setFont(new Font("Verdana",Font.BOLD,16));
    }
}

//References:https://stackoverflow.com/questions/13575456/jtabbedpane-using-multiple-classes
