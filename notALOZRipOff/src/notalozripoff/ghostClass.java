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
public class ghostClass extends JPanel implements ActionListener {

    Timer hitDetection = new Timer(1, this);
    static int damage = 5;
    static int health = 10;
    static boolean hitL = false, hitR = false, hitU = false, hitD = false;

    public ghostClass() {
        hitDetection.start();
        setSize(128, 128);
        setOpaque(false);

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
                health -= classForTesting.strength;
                this.setLocation(this.getLocation().x - 25, this.getLocation().y);
            }
        } else if (listenForHitL) {
            if (((classForTesting.xpos) <= (this.getLocation().x + this.getWidth())) && (classForTesting.xpos >= (this.getLocation().x + this.getWidth() - 75))) { //attack left to right
                health -= classForTesting.strength;
                this.setLocation(this.getLocation().x + 25, this.getLocation().y);
            }
        } else if (listenForHitU) {
            if (classForTesting.ypos <= (this.getLocation().y + this.getHeight()) && (classForTesting.ypos >= (this.getLocation().y + this.getHeight() - 75))) {
                health -= classForTesting.strength;
                this.setLocation(this.getLocation().x, this.getLocation().y - 25);
            }
        } else if (listenForHitD) {
            if ((classForTesting.ypos + 200) >= (this.getLocation().y) && (classForTesting.ypos + 192 <= (this.getLocation().y + 75))) {
                health -= classForTesting.strength;
                this.setLocation(this.getLocation().x, this.getLocation().y + 25);
            }
        } else {
            if ((classForTesting.xpos <= (this.getLocation().x + this.getWidth()))) { //Attack right to left
                classForTesting.health -= damage;
                hitL = true;
            } else if (((classForTesting.xpos + 100) == (this.getLocation().x))) { //attack left to right
                classForTesting.health -= damage;
                JOptionPane.showMessageDialog(null, classForTesting.xpos + " " + this.getLocation().x);
                hitR = true;
            } else if (classForTesting.ypos == (this.getLocation().y + this.getHeight())) {
                classForTesting.health -= damage;
                hitU = true;
                JOptionPane.showMessageDialog(null, classForTesting.ypos + " 1" + this.getLocation().y);
            } else if ((classForTesting.ypos + 192) == (this.getLocation().y)) {
                classForTesting.health -= damage;
                hitD = true;
                JOptionPane.showMessageDialog(null, classForTesting.ypos + " 2" + this.getLocation().y);
            }
        }
        listenForHitR = false;
        listenForHitL = false;
        listenForHitU = false;
        listenForHitD = false;
        if (health <= 0) {
            this.setVisible(false);
            this.setEnabled(false);
        } else {
            this.setVisible(true);
            this.setEnabled(true);
        }
        if (classForTesting.detectChange){
            int randomxpos = (int) (Math.random() * (1250 - 50) + 1) + 50;
            int randomypos = (int) (Math.random() * (750 - 50) + 1) + 50;
        if (classForTesting.areaBooleans[2][1]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[2][3]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[2][2]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[2][0]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[2][4]) {
                this.setLocation(randomxpos, randomypos);
            }
            //------------------------------------------- Row 0
            else if (classForTesting.areaBooleans[0][1]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[0][0]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[0][2]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[0][3]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[0][4]) {
                this.setLocation(randomxpos, randomypos);
            }
            //------------------------------------------- Row 1
            else if (classForTesting.areaBooleans[1][0]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[1][1]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[1][2]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[1][3]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[1][4]) {
                this.setLocation(randomxpos, randomypos);
            }
            //------------------------------------------- Row 3
            else if (classForTesting.areaBooleans[3][0]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[3][1]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[3][2]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[3][3]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[3][4]) {
                this.setLocation(randomxpos, randomypos);
            }
            //------------------------------------------- Row 4
            else if (classForTesting.areaBooleans[4][0]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[4][1]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[4][2]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[4][3]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[4][4]) {
                this.setLocation(randomxpos, randomypos);
            }
        }
    }
}
