/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notalozripoff;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author s241556
 */
public class tree extends JPanel implements ActionListener {

    int x = 0, y = 0;
    Timer placementTimer = new Timer(5, this);

    public tree() {
        placementTimer.start();
        setSize(227, 234);
        setLocation(500, 500);
        setOpaque(false);
    }

    public void paintComponent(Graphics g1) {
        super.paintComponent(g1);
        ImageIcon tree = new ImageIcon("C:\\Users\\s241556\\Documents\\NetBeansProjects\\notALOZRipOff\\areaImages\\tree.png");
        tree.paintIcon(this, g1, x, y);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean findChange = classForTesting.detectChange;
        if (findChange) {
            classForTesting.detectChange = false;
            if (classForTesting.areaBooleans[2][1]) {
                this.setLocation(500, 250);
            } else if (classForTesting.areaBooleans[2][3]) {
                this.setLocation(700, 250);
            } else if (classForTesting.areaBooleans[2][2]) {
                this.setLocation(500, 500);
            }

        }

    }
}
