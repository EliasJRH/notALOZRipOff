/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notalozripoff;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author s241556
 */
public class slimeClass extends JPanel implements ActionListener {

    Timer placementTimer = new Timer(1, this);
    static int health = 50;
    boolean upgradeGiven = false;

    public slimeClass() {       //Constructor method used to set up the default values of the slime object
        placementTimer.start(); //Such as placement timer, location, size and opacity
        setSize(227, 234);      
        setLocation(500, 500);
        setOpaque(false);
    }

    public void paintComponent(Graphics g) {   //Method used to set up the image of the slime object
        super.paintComponent(g);
        ImageIcon SLIME = new ImageIcon("C:\\Users\\s241556\\Documents\\NetBeansProjects\\notALOZRipOff\\areaImages\\Slime.png");
        SLIME.paintIcon(this, g, 0, 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean listenForHitR = classForTesting.attackR;//Booleans that receive the value of where the user is hitting it from
        boolean listenForHitL = classForTesting.attackL;  
        boolean listenForHitU = classForTesting.attackU; //Ex. User hitting ghost from left to right = ghost receiving hit
        boolean listenForHitD = classForTesting.attackD;    //On the left side
        if (listenForHitR) {            //When hitting it from the the left to right, it moves 25 units to the right
                                //Second if statement checks if it's in bound 
            if ((classForTesting.xpos + 100 >= (this.getLocation().x)) && ((classForTesting.xpos + 100 < (this.getLocation().x + 75)))) { //Attack right to left
                health -= classForTesting.strength;
                this.setLocation(this.getLocation().x + 25, this.getLocation().y);
            }
        } else if (listenForHitL) {     //When hitting it on the ghost from right to left, it moves 25 units to the left
            //Second if statement checks if it's in bound
            if (((classForTesting.xpos) <= (this.getLocation().x + this.getWidth())) && (classForTesting.xpos >= (this.getLocation().x + this.getWidth() - 75))) { //attack left to right
                health -= classForTesting.strength;
                this.setLocation(this.getLocation().x - 25, this.getLocation().y);
            }
        } else if (listenForHitU) {     //When hitting the ghost from bottom to up, it moves 25 units to the up
            //Second if statement checks if it's in bound
            if (classForTesting.ypos <= (this.getLocation().y + this.getHeight()) && (classForTesting.ypos >= (this.getLocation().y + this.getHeight() - 75))) {
                health -= classForTesting.strength;
                this.setLocation(this.getLocation().x, this.getLocation().y - 25);
            }
        } else if (listenForHitD) {     //When hitting the ghost from top to down, it moves 25 units to the down
            //Second if statement checks if it's in bound
            if ((classForTesting.ypos + 200) >= (this.getLocation().y) && (classForTesting.ypos + 192 <= (this.getLocation().y + 75))) {
                health -= classForTesting.strength;
                this.setLocation(this.getLocation().x, this.getLocation().y + 25);
            }
        }
        listenForHitR = false;      //Sets all of the booleans mentioned above false
        listenForHitL = false;
        listenForHitU = false;
        listenForHitD = false;
        
        if (health <= 0) {
            upgradeGiven = true;    
            this.setVisible(false); //When detecting that it's health is gone, then it will be set not visible
            this.setEnabled(false);
            classForTesting.enemiesKilled++;
        } else {
            this.setVisible(true);  //Else it will be left visible 
            this.setEnabled(true);
        }
        if (classForTesting.detectChange3) {        //Checks the position of where it is
            classForTesting.detectChange3 = false;      //First if statement detects if it changed tiles on the map
            int randomxpos = (int) (Math.random() * (1250 - 50) + 1) + 50;
            int randomypos = (int) (Math.random() * (750 - 50) + 1) + 50; //Then second if statement changes the location of the ghost object randomly
            if (classForTesting.areaBooleans[2][1]) {       // Row 2
                this.setLocation(randomxpos, randomypos);       
            } else if (classForTesting.areaBooleans[2][3]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[2][2]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[2][0]) {
                this.setLocation(randomxpos, randomypos);
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
