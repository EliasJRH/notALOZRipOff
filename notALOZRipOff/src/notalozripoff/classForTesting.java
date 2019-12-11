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
            areaBooleans[1][2] = true;
            areaBooleans[2][2] = false;
            this.setLocation(width - 520, this.getLocation().y);
        } else if (areaBooleans[2][2] && this.getLocation().x >= (width - 300)) { //right
            areaBooleans[3][2] = true;
            areaBooleans[2][2] = false;
            this.setLocation(150, this.getLocation().y);
        }else if (areaBooleans[2][2] && this.getLocation().y <= 100){ //up
            areaBooleans[2][1] = true;
            areaBooleans[2][2] = false;
            this.setLocation(this.getLocation().x, height - 520);
        }else if (areaBooleans[2][2] && this.getLocation().y >= (height - 300)){ //down
            areaBooleans[2][3] = true;
            areaBooleans[2][2] = false;
            this.setLocation(this.getLocation().x, 150);
        }
        if (areaBooleans[0] && this.getLocation().x >= (width - 300)) {
            areaBooleans[1] = true;
            areaBooleans[0] = false;
            this.setLocation(150, this.getLocation().y);
        }
        if (areaBooleans[2] && this.getLocation().x <= 100) {
            areaBooleans[1] = true;
            areaBooleans[2] = false;
            this.setLocation(width - 520, this.getLocation().y);
        }
    }

    //Hello
}
