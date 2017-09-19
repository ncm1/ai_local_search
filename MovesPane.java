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

public class MovesPane extends JPanel{
  JButton   generate = new JButton("Generate");
    public MovesPane() {
        generate.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "You just clicked button");
            }
        });
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        g.setFont(new Font("Verdana",Font.BOLD,16));
    }
}

//References:https://stackoverflow.com/questions/13575456/jtabbedpane-using-multiple-classes
