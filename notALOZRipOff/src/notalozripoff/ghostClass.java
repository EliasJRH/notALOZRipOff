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
        boolean listenForHitR = classForTesting.attackR;
        boolean listenForHitL = classForTesting.attackL;
        boolean listenForHitU = classForTesting.attackU;
        boolean listenForHitD = classForTesting.attackD;
        if (listenForHitR) {
            if ((classForTesting.xpos + 100 >= (this.getLocation().x)) && ((classForTesting.xpos + 100 < (this.getLocation().x + 75)))) { //Attack right to left
                JOptionPane.showMessageDialog(null, "hit 1");
            }
        } else if (listenForHitL) {
            if (((classForTesting.xpos) <= (this.getLocation().x + this.getWidth())) && (classForTesting.xpos >= (this.getLocation().x + this.getWidth() - 75))) { //attack left to right
                JOptionPane.showMessageDialog(null, "hit 2");
            }
        } else if (listenForHitU) {
            if (classForTesting.ypos <= (this.getLocation().y + this.getHeight()) && (classForTesting.ypos >= (this.getLocation().y + this.getHeight() - 75))) {
                JOptionPane.showMessageDialog(null, "hit 3");
            }
        } else if (listenForHitD) {
            if ((classForTesting.ypos + 200) >= (this.getLocation().y) && (classForTesting.ypos + 192 <= (this.getLocation().y + 75))) {
                JOptionPane.showMessageDialog(null, "hit 4");
            }
        }
        listenForHitR = false;
        listenForHitL = false;
        listenForHitU = false;
        listenForHitD = false;
}
