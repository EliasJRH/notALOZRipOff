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
        changeArea();
    }

    public void up() {
        vely = -5;
        velx = 0;
        registerMovement();
    }

    public void down() {
        vely = 5;
        velx = 0;
        registerMovement();
    }

    public void left() {
        rotateLeft = true;
        rotateRight = false;
        velx = -5;
        vely = 0;
        registerMovement();
    }

    public void right() {
        rotateRight = true;
        rotateLeft = false;
        velx = 5;
        vely = 0;
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
if (areaBooleans[2][2] && this.getLocation().x <= 100) { //left
            areaBooleans[2][2] = false;
            areaBooleans[1][2] = true;
            this.setLocation(width - 520, this.getLocation().y);
        } else if (areaBooleans[2][2] && this.getLocation().x >= (width - 300)) { //right
            areaBooleans[3][2] = true;
            areaBooleans[2][2] = false;
            this.setLocation(150, this.getLocation().y);
        } else if (areaBooleans[2][2] && this.getLocation().y <= 100) { //up
            areaBooleans[2][1] = true;
            areaBooleans[2][2] = false;
            this.setLocation(this.getLocation().x, height - 520);
        } else if (areaBooleans[2][2] && this.getLocation().y >= (height - 300)) { //down
            areaBooleans[2][3] = true;
            areaBooleans[2][2] = false;
            this.setLocation(this.getLocation().x, 150);
        }
        if (areaBooleans[1][2] && this.getLocation().x <= 100) { //left
            areaBooleans[0][2] = true;
            areaBooleans[1][2] = false;
            this.setLocation(width - 520, this.getLocation().y);
        } else if (areaBooleans[1][2] && this.getLocation().x >= (width - 300)) { //right
            areaBooleans[2][2] = true;
            areaBooleans[1][2] = false;
            this.setLocation(150, this.getLocation().y);
        } else if (areaBooleans[1][2] && this.getLocation().y <= 100) { //up
            areaBooleans[1][1] = true;
            areaBooleans[1][2] = false;
            this.setLocation(this.getLocation().x, height - 520);
        } else if (areaBooleans[1][2] && this.getLocation().y >= (height - 300)) { //down
            areaBooleans[1][3] = true;
            areaBooleans[1][2] = false;
            this.setLocation(this.getLocation().x, 150);
        }
        if (areaBooleans[0][2] && this.getLocation().x <= 0) { //left
            this.setLocation(0, this.getLocation().y);
        } else if (areaBooleans[0][2] && this.getLocation().x >= (width - 300)) { //right
            areaBooleans[1][2] = true;
            areaBooleans[0][2] = false;
            this.setLocation(150, this.getLocation().y);
        } else if (areaBooleans[0][2] && this.getLocation().y <= 100) { //up
            areaBooleans[0][1] = true;
            areaBooleans[0][2] = false;
            this.setLocation(this.getLocation().x, height - 520);
        } else if (areaBooleans[0][2] && this.getLocation().y >= (height - 300)) { //down
            areaBooleans[0][3] = true;
            areaBooleans[0][2] = false;
            this.setLocation(this.getLocation().x, 150);
        }
        if (areaBooleans[3][2] && this.getLocation().x <= 0) { //left
            areaBooleans[2][2] = true;
            areaBooleans[3][2] = false;
            this.setLocation(width - 520, this.getLocation().y);
        } else if (areaBooleans[3][2] && this.getLocation().x >= (width - 300)) { //right
            areaBooleans[4][2] = true;
            areaBooleans[3][2] = false;
            this.setLocation(150, this.getLocation().y);
        } else if (areaBooleans[3][2] && this.getLocation().y <= 100) { //up
            areaBooleans[3][1] = true;
            areaBooleans[3][2] = false;
            this.setLocation(this.getLocation().x, height - 520);
        } else if (areaBooleans[3][2] && this.getLocation().y >= (height - 300)) { //down
            areaBooleans[3][3] = true;
            areaBooleans[3][2] = false;
            this.setLocation(this.getLocation().x, 150);
        }
        if (areaBooleans[4][2] && this.getLocation().x <= 0) { //left
            areaBooleans[3][2] = true;
            areaBooleans[4][2] = false;
            this.setLocation(width - 520, this.getLocation().y);
        } else if (areaBooleans[4][2] && this.getLocation().x >= (width - 300)) { //right
            this.setLocation(width - 300, this.getLocation().y);
        } else if (areaBooleans[4][2] && this.getLocation().y <= 100) { //up
            areaBooleans[4][1] = true;
            areaBooleans[4][2] = false;
            this.setLocation(this.getLocation().x, height - 520);
        } else if (areaBooleans[4][2] && this.getLocation().y >= (height - 300)) { //down
            areaBooleans[4][3] = true;
            areaBooleans[4][2] = false;
            this.setLocation(this.getLocation().x, 150);
        }
        if (areaBooleans[0][3] && this.getLocation().x <= 0) { //left
            this.setLocation(0, this.getLocation().y);
        } else if (areaBooleans[0][3] && this.getLocation().x >= (width)) { //right
            areaBooleans[1][3] = true;
            areaBooleans[0][3] = false;
            this.setLocation(150, this.getLocation().y);
        } else if (areaBooleans[0][3] && this.getLocation().y <= 100) { //up
            areaBooleans[0][2] = true;
            areaBooleans[0][3] = false;
            this.setLocation(this.getLocation().x, height - 520);
        } else if (areaBooleans[0][3] && this.getLocation().y >= (height - 300)) { //down
            areaBooleans[0][4] = true;
            areaBooleans[0][3] = false;
            this.setLocation(this.getLocation().x, 150);
        }
        if (areaBooleans[1][3] && this.getLocation().x <= 0) { //left
            areaBooleans[0][3] = true;
            areaBooleans[1][3] = false;
            this.setLocation(width - 520, this.getLocation().y);
        } else if (areaBooleans[1][3] && this.getLocation().x >= (width)) { //right
            areaBooleans[2][3] = true;
            areaBooleans[1][3] = false;
            this.setLocation(150, this.getLocation().y);
        } else if (areaBooleans[1][3] && this.getLocation().y <= 100) { //up
            areaBooleans[1][2] = true;
            areaBooleans[1][3] = false;
            this.setLocation(this.getLocation().x, height - 520);
        } else if (areaBooleans[1][3] && this.getLocation().y >= (height - 300)) { //down
            areaBooleans[1][4] = true;
            areaBooleans[1][3] = false;
            this.setLocation(this.getLocation().x, 150);
        }
        if (areaBooleans[2][3] && this.getLocation().x <= 0) { //left
            areaBooleans[1][3] = true;
            areaBooleans[2][3] = false;
            this.setLocation(width - 520, this.getLocation().y);
        } else if (areaBooleans[2][3] && this.getLocation().x >= (width)) { //right
            areaBooleans[3][3] = true;
            areaBooleans[2][3] = false;
            this.setLocation(150, this.getLocation().y);
        } else if (areaBooleans[2][3] && this.getLocation().y <= 100) { //up
            areaBooleans[2][2] = true;
            areaBooleans[2][3] = false;
            this.setLocation(this.getLocation().x, height - 520);
        } else if (areaBooleans[2][3] && this.getLocation().y >= (height - 300)) { //down
            areaBooleans[2][4] = true;
            areaBooleans[2][3] = false;
            this.setLocation(this.getLocation().x, 150);
        }
        if (areaBooleans[3][3] && this.getLocation().x <= 0) { //left
            areaBooleans[2][3] = true;
            areaBooleans[3][3] = false;
            this.setLocation(width - 520, this.getLocation().y);
        } else if (areaBooleans[3][3] && this.getLocation().x >= (width)) { //right
            areaBooleans[4][3] = true;
            areaBooleans[3][3] = false;
            this.setLocation(150, this.getLocation().y);
        } else if (areaBooleans[3][3] && this.getLocation().y <= 100) { //up
            areaBooleans[3][2] = true;
            areaBooleans[3][3] = false;
            this.setLocation(this.getLocation().x, height - 520);
        } else if (areaBooleans[3][3] && this.getLocation().y >= (height - 300)) { //down
            areaBooleans[3][4] = true;
            areaBooleans[3][3] = false;
            this.setLocation(this.getLocation().x, 150);
        }
        if (areaBooleans[4][3] && this.getLocation().x <= 0) { //left
            areaBooleans[3][3] = true;
            areaBooleans[3][3] = false;
            this.setLocation(width - 520, this.getLocation().y);
        } else if (areaBooleans[4][3] && this.getLocation().x >= (width - 300)) { //right
            this.setLocation(width - 300, this.getLocation().y);
        } else if (areaBooleans[4][3] && this.getLocation().y <= 100) { //up
            areaBooleans[4][2] = true;
            areaBooleans[4][3] = false;
            this.setLocation(this.getLocation().x, height - 520);
        } else if (areaBooleans[4][3] && this.getLocation().y >= (height - 300)) { //down
            areaBooleans[4][4] = true;
            areaBooleans[4][3] = false;
            this.setLocation(this.getLocation().x, 150);
        }
        
        ////////////////
        
        if (areaBooleans[0][4] && this.getLocation().x <= 0) { //left
            this.setLocation(0, this.getLocation().y);
        } else if (areaBooleans[0][4] && this.getLocation().x >= (width)) { //right
            areaBooleans[1][3] = true;
            areaBooleans[1][4] = false;
            this.setLocation(150, this.getLocation().y);
        } else if (areaBooleans[0][4] && this.getLocation().y <= 100) { //up
            areaBooleans[0][3] = true;
            areaBooleans[0][4] = false;
            this.setLocation(this.getLocation().x, height - 520);
        } else if (areaBooleans[0][4] && this.getLocation().y >= (height - 300)) { //down
            this.setLocation(this.getLocation().x, height);
        }
        if (areaBooleans[1][4] && this.getLocation().x <= 0) { //left
            areaBooleans[0][4] = true;
            areaBooleans[1][4] = false;
            this.setLocation(width - 520, this.getLocation().y);
        } else if (areaBooleans[1][4] && this.getLocation().x >= (width)) { //right
            areaBooleans[2][4] = true;
            areaBooleans[1][4] = false;
            this.setLocation(150, this.getLocation().y);
        } else if (areaBooleans[1][4] && this.getLocation().y <= 100) { //up
            areaBooleans[1][3] = true;
            areaBooleans[1][4] = false;
            this.setLocation(this.getLocation().x, height - 520);
        } else if (areaBooleans[1][4] && this.getLocation().y >= (height - 300)) { //down
            this.setLocation(this.getLocation().x, height);
        }
        if (areaBooleans[2][4] && this.getLocation().x <= 0) { //left
            areaBooleans[1][4] = true;
            areaBooleans[2][4] = false;
            this.setLocation(width - 520, this.getLocation().y);
        } else if (areaBooleans[2][4] && this.getLocation().x >= (width)) { //right
            areaBooleans[3][4] = true;
            areaBooleans[2][4] = false;
            this.setLocation(150, this.getLocation().y);
        } else if (areaBooleans[2][4] && this.getLocation().y <= 100) { //up
            areaBooleans[2][3] = true;
            areaBooleans[2][4] = false;
            this.setLocation(this.getLocation().x, height - 520);
        } else if (areaBooleans[2][4] && this.getLocation().y >= (height - 300)) { //down
            this.setLocation(this.getLocation().x, height);
        }
        if (areaBooleans[3][4] && this.getLocation().x <= 0) { //left
            areaBooleans[2][4] = true;
            areaBooleans[3][4] = false;
            this.setLocation(width - 520, this.getLocation().y);
        } else if (areaBooleans[3][4] && this.getLocation().x >= (width)) { //right
            areaBooleans[4][4] = true;
            areaBooleans[3][4] = false;
            this.setLocation(150, this.getLocation().y);
        } else if (areaBooleans[3][4] && this.getLocation().y <= 100) { //up
            areaBooleans[3][3] = true;
            areaBooleans[3][4] = false;
            this.setLocation(this.getLocation().x, height - 520);
        } else if (areaBooleans[3][4] && this.getLocation().y >= (height - 300)) { //down
            this.setLocation(this.getLocation().x, height);
        }
        if (areaBooleans[4][4] && this.getLocation().x <= 0) { //left
            areaBooleans[3][4] = true;
            areaBooleans[4][4] = false;
            this.setLocation(width - 520, this.getLocation().y);
        } else if (areaBooleans[4][4] && this.getLocation().x >= (width - 300)) { //right
            this.setLocation(width - 300, this.getLocation().y);
        } else if (areaBooleans[4][4] && this.getLocation().y <= 100) { //up
            areaBooleans[4][3] = true;
            areaBooleans[4][4] = false;
            this.setLocation(this.getLocation().x, height - 520);
        } else if (areaBooleans[4][4] && this.getLocation().y >= (height - 300)) { //down
            this.setLocation(this.getLocation().x, height);
        }
        if (areaBooleans[0][0] && this.getLocation().x <= 100) { //Left Area 0:0
            this.setLocation(0, this.getLocation().y);
        } else if (areaBooleans[0][0] && this.getLocation().x >= (width - 300)) {//Right
            areaBooleans[0][1] = true;
            areaBooleans[0][0] = false;
            this.setLocation(150, this.getLocation().y);
        } else if (areaBooleans[0][0] && this.getLocation().y == 0) {//Up
            this.setLocation(this.getLocation().x, 0);
        } else if (areaBooleans[0][0] && this.getLocation().y >= (height - 300)) {//Down
            areaBooleans[0][1] = true;
            areaBooleans[0][0] = false;
            this.setLocation(this.getLocation().x, 150);
        }
        if (areaBooleans[0][1] && this.getLocation().x <= 100) { //Left Area 0:1
            this.setLocation(0, this.getLocation().y);
        } else if (areaBooleans[0][1] && this.getLocation().x >= (width - 300)) {//Right
            areaBooleans[1][1] = true;
            areaBooleans[0][1] = false;
            this.setLocation(150, this.getLocation().y);
        } else if (areaBooleans[0][1] && this.getLocation().y <= 100) {//Up
            areaBooleans[0][0] = true;
            areaBooleans[0][1] = false;
            this.setLocation(this.getLocation().x, 0);
        } else if (areaBooleans[0][0] && this.getLocation().y >= (height - 300)) {//Down
            areaBooleans[0][2] = true;
            areaBooleans[0][1] = false;
            this.setLocation(this.getLocation().x, 150);
        }

        if (areaBooleans[1][0] && this.getLocation().x <= 100) { //Left Area 1:0
            areaBooleans[0][0] = true;
            areaBooleans[1][0] = false;
            this.setLocation(0, this.getLocation().y);
        } else if (areaBooleans[1][0] && this.getLocation().x >= (width - 300)) {//Right
            areaBooleans[1][1] = true;
            areaBooleans[1][0] = false;
            this.setLocation(150, this.getLocation().y);
        } else if (areaBooleans[1][0] && this.getLocation().y <= 100) {//Up

            this.setLocation(this.getLocation().x, 0);
        } else if (areaBooleans[1][0] && this.getLocation().y >= (height - 300)) {//Down
            areaBooleans[1][0] = true;
            areaBooleans[1][1] = false;
            this.setLocation(this.getLocation().x, 150);
        }

        if (areaBooleans[1][1] && this.getLocation().x <= 100) {//Left Area 1:1
            areaBooleans[0][1] = true;
            areaBooleans[1][1] = false;
            this.setLocation(width - 520, this.getLocation().y);
        } else if (areaBooleans[1][1] && this.getLocation().x >= (width - 300)) {//Right
            areaBooleans[0][2] = true;
            areaBooleans[1][1] = false;
            this.setLocation(150, this.getLocation().y);
        } else if (areaBooleans[1][1] && this.getLocation().y <= 100) {//Up
            areaBooleans[1][0] = true;
            areaBooleans[1][1] = false;
            this.setLocation(this.getLocation().x, height - 520);
        } else if (areaBooleans[1][1] && this.getLocation().y >= (height - 300)) {//Down
            areaBooleans[1][2] = true;
            areaBooleans[1][1] = false;
            this.setLocation(this.getLocation().x, 150);
        }

        if (areaBooleans[2][0] && this.getLocation().x <= 100) { //Left Area 2:0
            areaBooleans[1][0] = true;
            areaBooleans[2][0] = false;
            this.setLocation(0, this.getLocation().y);
        } else if (areaBooleans[2][0] && this.getLocation().x >= (width - 300)) {//Right
            areaBooleans[3][0] = true;
            areaBooleans[2][0] = false;
            this.setLocation(150, this.getLocation().y);
        } else if (areaBooleans[2][0] && this.getLocation().y <= 100) {//Up

            this.setLocation(this.getLocation().x, 0);
        } else if (areaBooleans[2][0] && this.getLocation().y >= (height - 300)) {//Down
            areaBooleans[2][1] = true;
            areaBooleans[2][0] = false;
            this.setLocation(this.getLocation().x, 150);
        }

        if (areaBooleans[2][1] && this.getLocation().x <= 100) {//Left Area 2:1
            areaBooleans[1][1] = true;
            areaBooleans[2][1] = false;
            this.setLocation(width - 520, this.getLocation().y);
        } else if (areaBooleans[2][1] && this.getLocation().x >= (width - 300)) {//Right
            areaBooleans[3][1] = true;
            areaBooleans[2][1] = false;
            this.setLocation(150, this.getLocation().y);
        } else if (areaBooleans[2][1] && this.getLocation().y <= 100) {//Up
            areaBooleans[2][0] = true;
            areaBooleans[2][1] = false;
            this.setLocation(this.getLocation().x, height - 520);
        } else if (areaBooleans[2][1] && this.getLocation().y >= (height - 300)) {//Down
            areaBooleans[2][2] = true;
            areaBooleans[2][1] = false;
            this.setLocation(this.getLocation().x, 150);
        }

        if (areaBooleans[3][0] && this.getLocation().x <= 100) {//Left Area 3:0
            areaBooleans[2][0] = true;
            areaBooleans[3][0] = false;
            this.setLocation(width - 520, this.getLocation().y);
        } else if (areaBooleans[3][0] && this.getLocation().x >= (width - 300)) {//Right
            areaBooleans[4][0] = true;
            areaBooleans[3][0] = false;
            this.setLocation(150, this.getLocation().y);
        } else if (areaBooleans[3][0] && this.getLocation().y <= 100) {//Up

            this.setLocation(this.getLocation().x, height - 520);
        } else if (areaBooleans[3][0] && this.getLocation().y >= (height - 300)) {//Down
            areaBooleans[3][1] = true;
            areaBooleans[3][0] = false;
            this.setLocation(this.getLocation().x, 150);
        }

        if (areaBooleans[3][1] && this.getLocation().x <= 100) {//Left Area 3:1
            areaBooleans[2][1] = true;
            areaBooleans[3][1] = false;
            this.setLocation(width - 520, this.getLocation().y);
        } else if (areaBooleans[3][1] && this.getLocation().x >= (width - 300)) {//Right
            areaBooleans[4][1] = true;
            areaBooleans[3][1] = false;
            this.setLocation(150, this.getLocation().y);
        } else if (areaBooleans[3][1] && this.getLocation().y <= 100) {//Up
            areaBooleans[3][0] = true;
            areaBooleans[3][1] = false;
            this.setLocation(this.getLocation().x, height - 520);
        } else if (areaBooleans[3][1] && this.getLocation().y >= (height - 300)) {//Down
            areaBooleans[3][2] = true;
            areaBooleans[3][1] = false;
            this.setLocation(this.getLocation().x, 150);
        }

        if (areaBooleans[4][0] && this.getLocation().x <= 100) {//Left Area 4:0
            areaBooleans[3][0] = true;
            areaBooleans[4][0] = false;
            this.setLocation(width - 520, this.getLocation().y);
        } else if (areaBooleans[4][0] && this.getLocation().x >= (width - 300)) {//Right

            this.setLocation(width - 300, this.getLocation().y);
        } else if (areaBooleans[4][0] && this.getLocation().y <= 100) {//Up

            this.setLocation(this.getLocation().x, height - 520);
        } else if (areaBooleans[4][0] && this.getLocation().y >= (height - 300)) {//Down
            areaBooleans[4][1] = true;
            areaBooleans[4][0] = false;
            this.setLocation(this.getLocation().x, 150);
        }

        if (areaBooleans[4][1] && this.getLocation().x <= 100) {//Left Area 4:1
            areaBooleans[3][1] = true;
            areaBooleans[4][1] = false;
            this.setLocation(width - 520, this.getLocation().y);
        } else if (areaBooleans[4][1] && this.getLocation().x >= (width - 300)) {//Right
            this.setLocation(width - 300, this.getLocation().y);
        } else if (areaBooleans[4][1] && this.getLocation().y <= 100) {//Up
            areaBooleans[4][0] = true;
            areaBooleans[4][1] = false;
            this.setLocation(this.getLocation().x, height - 520);
        } else if (areaBooleans[4][1] && this.getLocation().y >= (height - 300)) {//Down
            areaBooleans[4][2] = true;
            areaBooleans[4][1] = false;
            this.setLocation(this.getLocation().x, 150);
        }
    }

    //Hello
}
