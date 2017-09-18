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

public class StatsPane extends JPanel{
  JComboBox sizeBox  = new JComboBox();
  JButton   generate = new JButton("Generate");
  JLabel title = new JLabel("Statistics");
  JLabel prompt = new JLabel("Please select the size of n:");

    public StatsPane() {
        generate.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "You just clicked button");
            }
        });
        add(generate);


        Font font = new Font("Cambria", Font.BOLD, 30);
        title.setFont(font);
        Font font1 = new Font("Cambria", Font.BOLD, 20);
        prompt.setFont(font1);

        //Populate the sizebox with the possible puzzle sizes
        sizeBox.addItem(5);
        sizeBox.addItem(7);
        sizeBox.addItem(9);
        sizeBox.addItem(11);

        generate.setBounds(520,400,180,70);
        sizeBox.setBounds(500, 180, 50, 30);
        prompt.setBounds(180, 95, 350, 200);
        setSize(800,600);

        add(title);
        add(prompt);
        add(sizeBox);
        add(generate);
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        g.setFont(new Font("Verdana",Font.BOLD,16));
    }
}

//References:https://stackoverflow.com/questions/13575456/jtabbedpane-using-multiple-classes
