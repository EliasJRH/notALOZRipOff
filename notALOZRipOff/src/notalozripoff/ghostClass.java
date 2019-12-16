/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notalozripoff;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author s241556
 */
public class ghostClass extends JPanel implements ActionListener{
    
    Timer hitDetection = new Timer(1, this);

    public ghostClass(){
        hitDetection.start();
        setSize(128,128);
        setOpaque(false); 
        int damage = 5;
        int health = 1;
    }
        
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon GHOST = new ImageIcon("C:\\Users\\s241556\\Documents\\NetBeansProjects\\notALOZRipOff\\areaImages\\Ghost.gif");
        GHOST.paintIcon(this, g, 0, 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean listenForHit = classForTesting.attack;
        if (listenForHit){
            if (classForTesting.xpos <= (this.getWidth() + this.getLocation().x)){
                JOptionPane.showMessageDialog(null,"hit");
            }
        }
    }
/* else if (classForTesting.xpos >= (this.getLocation().x)) {
                JOptionPane.showMessageDialog(null, "hit");
            } else if (classForTesting.ypos <= (this.getLocation().y - this.getHeight())) {
                JOptionPane.showMessageDialog(null, "hit");
            } else if (classForTesting.ypos >= (this.getLocation().y + this.getHeight())) {
                JOptionPane.showMessageDialog(null, "hit");
            }
*/
}
