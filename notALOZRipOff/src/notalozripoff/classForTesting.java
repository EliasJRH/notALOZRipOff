/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notalozripoff;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Long.rotateLeft;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author s241556
 */
public class classForTesting extends JPanel implements KeyListener {

    int x = 0, y = 0, velx = 0, vely = 0;
    boolean rotateLeft = false, rotateRight = false;
    boolean areaBooleans[] = new boolean[3];

    public classForTesting() {
        addKeyListener(this);
        setSize(300, 470);
        setLocation(500, 0);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        initiliazeBooleans();
        registerMovement();
        areaBooleans[1] = true;
        areaBooleans[0] = false;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon right = new ImageIcon("C:\\Users\\s241556\\Documents\\NetBeansProjects\\notALOZRipOff\\areaImages\\dude1.png");
        ImageIcon left = new ImageIcon("C:\\Users\\s241556\\Documents\\NetBeansProjects\\notALOZRipOff\\areaImages\\dude2.png");
        right.paintIcon(this, g, x, y);
        if (rotateLeft) {
            super.paintComponent(g);
            left.paintIcon(this, g, x, y);
        }
    }

    public void registerMovement() {
        this.setLocation(this.getLocation().x += velx, this.getLocation().y += vely);
        //JOptionPane.showMessageDialog(null, this.getLocation().x + this.getLocation().y);
        
    }

    public void up() {
        vely = -5;
        velx = 0;
        changeArea();
        registerMovement();
    }

    public void down() {
        vely = 5;
        velx = 0;
        changeArea();
        registerMovement();
    }

    public void left() {
        rotateLeft = true;
        rotateRight = false;
        velx = -5;
        vely = 0;
        changeArea();
        registerMovement();
    }

    public void right() {
        rotateRight = true;
        rotateLeft = false;
        velx = 5;
        vely = 0;
        changeArea();
        registerMovement();
    }

    public void keyPressed(KeyEvent arg0) {
        int code = arg0.getKeyCode();
        if (code == KeyEvent.VK_RIGHT) {
            right();
        }
        if (code == KeyEvent.VK_UP) {
            up();
        }
        if (code == KeyEvent.VK_DOWN) {
            down();
        }
        if (code == KeyEvent.VK_LEFT) {
            left();
        }
        if (code == KeyEvent.VK_Z) {
            Thread attackThread = new Thread() {
                public void run() {
                    try {
                        String temp = "";
                        if (rotateRight) {
                            temp = "right";
                        } else if (rotateLeft) {
                            temp = "left";
                        }
                        rotateLeft = false;
                        rotateRight = false;
                        attack = true;
                        repaint();
                        sleep(500);
                        attack = false;
                        if (temp.equals("right")) {
                            rotateRight = true;
                            rotateLeft = false;
                        } else {
                            rotateLeft = true;
                            rotateRight = false;
                        }
                        repaint();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(bobClass.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            };
            attackThread.start();

        }
    }

    public void keyTyped(KeyEvent arg0) {
        //ll
    }

    public void keyReleased(KeyEvent arg0) {

    }

    public void initiliazeBooleans() {
        for (int i = 0; i < areaBooleans.length; i++) {
            areaBooleans[i] = false;
        }
        //JOptionPane.showMessageDialog(null, String.valueOf(areaBooleans[0]) + areaBooleans[1] + areaBooleans[2]);
    }

    public void changeArea() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth(); //sets int width to the width of the screen
        int height = (int) screenSize.getHeight(); //sets int height to the height of the screen
        int rowCoord = 0, columnCoord = 0; //Creates integers to get the coordinates of the map
        for (int rowNum = 0; rowNum < areaBooleans.length; rowNum++) { //For loop that runs trhough the 2d array
            for (int columnNum = 0; columnNum < areaBooleans[rowNum].length; columnNum++) {
                if (areaBooleans[rowNum][columnNum]) { //Checks which boolean is true
                    rowCoord = rowNum; //once it finds the boolean, gets it coordinates
                    columnCoord = columnNum;
                    break; //breaks out of the loop because there is no need to check since only one variable will always be true
                }
            }
        } //The next for block tells the jpanel how to position itself based on it's position on the screen and in the array
        if ((this.getLocation().x + velx) <= 0) { //If the character is on the left most of the screen
            if (columnCoord == 0) { //If the area the character is in is the left most area of the map
                velx = 0; //set his x velocity to zero so we wont move
                //The register movmenet method is called after this so the charcter ends up not moving
            } else { //Other wise
                areaBooleans[rowCoord][columnCoord] = false; //sets the current position boolean to false
                columnCoord--; //changes the column coordinate count
                areaBooleans[rowCoord][columnCoord] = true; //makes that position boolean true
                this.setLocation(width - this.getWidth(), this.getLocation().y); //changes the position of the charcter to make it seem like he came from the right
            } //This structure is the same for the 3 other directions, just changed some variable around, serves the same purpose
        } else if ((this.getLocation().x + velx) >= width - this.getWidth()) {//If the character is in the right most of the screen
            if (columnCoord == 4) { //going to the right
                velx = 0;
            } else {
                areaBooleans[rowCoord][columnCoord] = false;
                columnCoord++;
                areaBooleans[rowCoord][columnCoord] = true;
                this.setLocation(0, this.getLocation().y);
            }
        } else if ((this.getLocation().y + vely) <= 0) {
            if (rowCoord == 0) { //going up
                vely = 0;
            } else {
                areaBooleans[rowCoord][columnCoord] = false;
                rowCoord--;
                areaBooleans[rowCoord][columnCoord] = true;
                this.setLocation(this.getLocation().x, height - this.getHeight());
            }
        } else if ((this.getLocation().y + vely) >= height - this.getHeight()) {
            if (rowCoord == 4) { //going down
                vely = 0;
            } else {
                areaBooleans[rowCoord][columnCoord] = false;
                rowCoord++;
                areaBooleans[rowCoord][columnCoord] = true;
                this.setLocation(this.getLocation().x, 0);
            }
        }
       
    }

    //Hello
}
