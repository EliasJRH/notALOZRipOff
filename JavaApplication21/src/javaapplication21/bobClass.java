/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworldtest;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Elias
 */
public class bobClass extends JPanel implements KeyListener {

    int x = 0, y = 0, velx = 0, vely = 0;
    boolean rotateLeft = false, rotateRight = false;

    public bobClass() {
        //Hola
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics g) {
        //Graphics2D g1 = (Graphics2D) g;
        super.paintComponent(g);
        ImageIcon BOB = new ImageIcon("images/HaroldR.png");
        ImageIcon BOBL = new ImageIcon("images/HaroldL.png");
        BOB.paintIcon(this, g, x, y);
        if (rotateLeft) {
            super.paintComponent(g);
            BOBL.paintIcon(this, g, x, y);
        }
    }

    public void registerMovement() {
        x += velx;
        y += vely;
        repaint();
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

}
