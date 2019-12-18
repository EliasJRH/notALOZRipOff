/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notalozripoff;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
public class classForTesting extends JPanel implements KeyListener, ActionListener {

    int x = 0, y = 0, velx = 0, vely = 0;
    boolean rotateLeft = false, rotateRight = false;
    public static boolean areaBooleans[][] = new boolean[5][5];
    public static boolean detectChange = false;
    static boolean attackR = false, attackL = false, attackU = false, attackD = false;
    boolean upListener = false, downListener = false;
    boolean standing = true;
    static int xpos = 500;
    static int ypos = 250;
    static int strength = 10;
    static int health = 100;
    Timer hitTimer = new Timer(5, this);

    public classForTesting() {
        hitTimer.start();
        addKeyListener(this);
        setSize(100, 192);
        setLocation(x, y);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        setOpaque(false);
        initiliazeBooleans();
        areaBooleans[2][2] = true;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon standingI = new ImageIcon("C:\\Users\\s241556\\Documents\\NetBeansProjects\\notALOZRipOff\\areaImages\\player.png");
        ImageIcon right = new ImageIcon("C:\\Users\\s241556\\Documents\\NetBeansProjects\\notALOZRipOff\\areaImages\\rightFacing.png");
        ImageIcon left = new ImageIcon("C:\\Users\\s241556\\Documents\\NetBeansProjects\\notALOZRipOff\\areaImages\\leftFacing.png");
        ImageIcon attackRImg = new ImageIcon("C:\\Users\\s241556\\Documents\\NetBeansProjects\\notALOZRipOff\\areaImages\\AttackRight.gif");
        ImageIcon attackLImg = new ImageIcon("C:\\Users\\s241556\\Documents\\NetBeansProjects\\notALOZRipOff\\areaImages\\AttackLeft.gif");
        ImageIcon upwards = new ImageIcon("C:\\Users\\s241556\\Documents\\NetBeansProjects\\notALOZRipOff\\areaImages\\up.png");
        ImageIcon attackUpImg = new ImageIcon("C:\\Users\\s241556\\Documents\\NetBeansProjects\\notALOZRipOff\\areaImages\\attackUp.gif");
        ImageIcon attackDownImg = new ImageIcon("C:\\Users\\s241556\\Documents\\NetBeansProjects\\notALOZRipOff\\areaImages\\attackDown.gif");
        if (standing) {
            standingI.paintIcon(this, g, x, y);
        }
        if (rotateRight) {
            right.paintIcon(this, g, x, y);
        }
        if (rotateLeft) {
            left.paintIcon(this, g, x, y);
        }
        if (attackR) {
            attackRImg.paintIcon(this, g, x, y);
        }
        if (attackL) {
            attackLImg.paintIcon(this, g, x, y);
        }
        if (downListener) {
            standingI.paintIcon(this, g, x, y);
        }
        if (upListener) {
            upwards.paintIcon(this, g, x, y);
        }
        if (attackU) {
            attackUpImg.paintIcon(this, g, x, y);
            setSize(100, 300);
            //setSize(100,192);
        }
        if (attackD){
            attackDownImg.paintIcon(this,g,x,y);
            setSize(100,300);
        }

    }

    public void registerMovement() {
        this.setLocation(this.getLocation().x += velx, this.getLocation().y += vely);
    }

    public void up() {
        vely = -10;
        velx = 0;
        ypos -= 10;
        rotateLeft = false;
        rotateRight = false;
        upListener = true;
        downListener = false;
        changeArea();
        registerMovement();

    }

    public void down() {
        vely = 10;
        velx = 0;
        ypos += 10;
        rotateLeft = false;
        rotateRight = false;
        upListener = false;
        downListener = true;
        changeArea();
        registerMovement();
    }

    public void left() {
        rotateLeft = true;
        rotateRight = false;
        upListener = false;
        downListener = false;
        standing = false;
        velx = -20;
        vely = 0;
        xpos -= 20;
        changeArea();
        registerMovement();
        repaint();
    }

    public void right() {
        rotateRight = true;
        rotateLeft = false;
        upListener = false;
        downListener = false;
        standing = false;
        velx = 20;
        vely = 0;
        xpos += 20;
        changeArea();
        registerMovement();
        repaint();
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
        if (code == KeyEvent.VK_M) {
            String mapOutput = "";
            for (int rowNum = 0; rowNum < areaBooleans.length; rowNum++) {
                for (int columnNum = 0; columnNum < areaBooleans[rowNum].length; columnNum++) {
                    if (areaBooleans[rowNum][columnNum] == true) {
                        mapOutput = mapOutput + "[X]" + "\t";
                        if (columnNum == 4) {
                            mapOutput += "\n";
                        }
                    } else {
                        mapOutput = mapOutput + "[ ]" + "\t";
                        if (columnNum == 4) {
                            mapOutput += "\n";
                        }
                    }
                }
            }
            JOptionPane.showMessageDialog(null, mapOutput);

        }
        if (code == KeyEvent.VK_Z) {
            xpos = this.getLocation().x;
            ypos = this.getLocation().y;
            this.setSize(345, 200);
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(classForTesting.class.getName()).log(Level.SEVERE, null, ex);
            }
            repaint();
            this.revalidate();
            Thread attackThread = new Thread() {
                public void run() {
                    try {
                        String temp = "";
                        if (rotateRight) {
                            temp = "right";
                            rotateLeft = false;
                            rotateRight = false;
                            upListener = false;
                            downListener = false;
                            attackR = true;
                        } else if (rotateLeft) {
                            temp = "left";
                            rotateLeft = false;
                            rotateRight = false;
                            upListener = false;
                            downListener = false;
                            attackL = true;
                        } else if (upListener) {
                            temp = "up";
                            standing = false;
                            rotateLeft = false;
                            rotateRight = false;
                            upListener = false;
                            downListener = false;
                            attackU = true;
                        } else if (downListener) {
                            temp = "down";
                            rotateLeft = false;
                            rotateRight = false;
                            upListener = false;
                            downListener = false;
                            attackD = true;
                        }
                        repaint();
                        sleep(500);
                        attackR = false;
                        attackL = false;
                        attackU = false;
                        attackD = false;
                        if (temp.equals("right")) {
                            rotateRight = true;
                        } else if (temp.equals("left")) {
                            rotateLeft = true;
                        } else if (temp.equals("up")) {
                            upListener = true;
                        } else {
                            downListener = true;
                        }
                        repaint();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(classForTesting.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            };
            attackThread.start();
            this.setSize(100, 192);
        }
        if (code == KeyEvent.VK_X){
            JOptionPane.showMessageDialog(null, xpos);
        }
    }

    public void keyTyped(KeyEvent arg0) {
        //ll
    }

    public void keyReleased(KeyEvent arg0) {

    }

    public void initiliazeBooleans() {
        for (int i = 0; i < areaBooleans.length; i++) {
            for (int columnNum = 0; columnNum < areaBooleans[i].length; columnNum++) {
                areaBooleans[i][columnNum] = false;
            }
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
                detectChange = true;
                reviveMonsters();
            } //This structure is the same for the 3 other directions, just changed some variable around, serves the same purpose
        } else if ((this.getLocation().x + velx) >= width - this.getWidth()) {//If the character is in the right most of the screen
            if (columnCoord == 4) { //going to the right
                velx = 0;
            } else {
                areaBooleans[rowCoord][columnCoord] = false;
                columnCoord++;
                areaBooleans[rowCoord][columnCoord] = true;
                this.setLocation(0, this.getLocation().y);
                detectChange = true;
                reviveMonsters();
            }
        } else if ((this.getLocation().y + vely) <= 0) {
            if (rowCoord == 0) { //going up
                vely = 0;
            } else {
                areaBooleans[rowCoord][columnCoord] = false;
                rowCoord--;
                areaBooleans[rowCoord][columnCoord] = true;
                this.setLocation(this.getLocation().x, height - this.getHeight());
                detectChange = true;
                reviveMonsters();
            }
        } else if ((this.getLocation().y + vely) >= height - this.getHeight()) {
            if (rowCoord == 4) { //going down
                vely = 0;
            } else {
                areaBooleans[rowCoord][columnCoord] = false;
                rowCoord++;
                areaBooleans[rowCoord][columnCoord] = true;
                this.setLocation(this.getLocation().x, 0);
                detectChange = true;
                reviveMonsters();
            }
        }
        //detectChange = false;
        
    }

    public void getHit() {

    }

    //Hello
    @Override
    public void actionPerformed(ActionEvent e) {
        if (ghostClass.hitL) {
            //JOptionPane.showMessageDialog(null, "hitL");
            this.setLocation(this.getLocation().x + 25, this.getLocation().y);
        } else if (ghostClass.hitR) {
            this.setLocation(this.getLocation().x - 25, this.getLocation().y);
        } else if (ghostClass.hitU) {
            this.setLocation(this.getLocation().x, this.getLocation().y + 25);
        } else if (ghostClass.hitD) {
            this.setLocation(this.getLocation().x, this.getLocation().y - 25);
        }
        ghostClass.hitL = false;
        ghostClass.hitR = false;
        ghostClass.hitU = false;
        ghostClass.hitD = false;
    }
    
    public static void reviveMonsters(){
        ghostClass.health = 5;
    }
}
