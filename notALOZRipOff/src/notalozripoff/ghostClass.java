/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notalozripoff;

import java.awt.Graphics;           //All the imports needed to be used, except for logger
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

    Timer hitDetection = new Timer(5, this);   //Variables to be used in this class and when referencing
    static int damage = 5;                      //In other classes
    static int health = 30;
    int xpos = 100;
    int ypos = 500;
    static boolean hitL = false, hitR = false, hitU = false, hitD = false;

    public ghostClass() {       //Constructor that sets up the default values of the ghost object
        hitDetection.start();   //Such as the timer to detect being hit, location, opacity, and visibility
        setSize(128, 128);
        setLocation(100, 500);
        setOpaque(false);
        if (health <= 0) {
            this.setVisible(false);
            this.setEnabled(false);
            classForTesting.enemiesKilled++;
        }
    }

    public void paintComponent(Graphics g) { //Method used to set up the image of the ghost
        super.paintComponent(g);
        ImageIcon GHOST = new ImageIcon("C:\\Users\\s241556\\Documents\\NetBeansProjects\\notALOZRipOff\\areaImages\\Ghost.gif");
        GHOST.paintIcon(this, g, 0, 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean listenForHitR = classForTesting.attackR;//Booleans that receive the value of where the user is hitting it from
        boolean listenForHitL = classForTesting.attackL;  
        boolean listenForHitU = classForTesting.attackU; //Ex. User hitting ghost from left to right = ghost receiving hit
        boolean listenForHitD = classForTesting.attackD;    //On the left side
        if (listenForHitR) {    //When hitting it from the the left to right, it moves 25 units to the right
                                //Second if statement checks if it's in bound 
            if ((classForTesting.xpos + 100 >= (this.getLocation().x)) && ((classForTesting.xpos + 100 < (this.getLocation().x + 75)))) { //Attack right to left
                health -= classForTesting.strength;//loses health based on how much damage it received from the player
                this.setLocation(this.getLocation().x + 25, this.getLocation().y);
            }
        } else if (listenForHitL) {     //When hitting it on the ghost from right to left, it moves 25 units to the left
            //Second if statement checks if it's in bound 
            if (((classForTesting.xpos) <= (this.getLocation().x + this.getWidth())) && (classForTesting.xpos >= (this.getLocation().x + this.getWidth() - 75))) { //attack left to right
                health -= classForTesting.strength;     //loses health based on how much damage it received from the player
                this.setLocation(this.getLocation().x - 25, this.getLocation().y);
            }
        } else if (listenForHitU) {   //When hitting the ghost from bottom to up, it moves 25 units to the up
            //Second if statement checks if it's in bound
            if (classForTesting.ypos <= (this.getLocation().y + this.getHeight()) && (classForTesting.ypos >= (this.getLocation().y + this.getHeight() - 75))) {
                health -= classForTesting.strength;     //loses health based on how much damage it received from the player
                this.setLocation(this.getLocation().x, this.getLocation().y - 25);
            }
        } else if (listenForHitD) {//When hitting the ghost from top to down, it moves 25 units to the down
            //Second if statement checks if it's in bound
            if ((classForTesting.ypos + 200) >= (this.getLocation().y) && (classForTesting.ypos + 192 <= (this.getLocation().y + 75))) {
                health -= classForTesting.strength;     //loses health based on how much damage it received from the player
                this.setLocation(this.getLocation().x, this.getLocation().y + 25);
            }
        }
        listenForHitR = false;  //Sets all of the booleans mentioned above false
        listenForHitL = false;
        listenForHitU = false;
        listenForHitD = false;
        if (health <= 0) {          //When detected that the ghost's health is gone, it will set it not visible
            this.setVisible(false); //And disable  from being enabled
            this.setEnabled(false); //Else it will be left visible
        } else {
            this.setVisible(true);
            this.setEnabled(true);
        }
        if (classForTesting.detectChange) {     //Checks the position of where it is
            classForTesting.detectChange = false;   //First if statement detects if it changed tiles on the map
            int randomxpos = (int) (Math.random() * (1250 - 50) + 1) + 50;  
            int randomypos = (int) (Math.random() * (750 - 50) + 1) + 50;
            if (classForTesting.areaBooleans[2][1]) {       //Then second if statement changes the location of the ghost object randomly
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[2][3]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[2][2]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[2][1]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[2][3]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[2][2]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[2][0]) {
                this.setLocation(randomxpos, randomypos);;
            } else if (classForTesting.areaBooleans[2][4]) {
                this.setLocation(randomxpos, randomypos);
            } //------------------------------------------- Row 0
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
            } //------------------------------------------- Row 1
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
            } //------------------------------------------- Row 3
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
            } //------------------------------------------- Row 4
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
