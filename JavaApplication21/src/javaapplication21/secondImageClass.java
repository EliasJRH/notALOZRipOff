/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworldtest;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Elias
 */
public class secondImageClass extends JPanel implements ActionListener  {

    Timer placementTimer = new Timer(5,this);
    
    public secondImageClass() {
        placementTimer.start();
        setSize(100, 100); //size of the panel holding the image

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon BOB = new ImageIcon("images/BOB.jpg");
        BOB.paintIcon(this, g, 50, 50); //Size of the imafge
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
                boolean test = bobClass.detectChange;
        if (test) {
            bobClass.detectChange = false;
            if (bobClass.areaBooleans[2][1]) {
                this.setLocation(500, 250);
            } else if (bobClass.areaBooleans[2][3]) {
                this.setLocation(700, 250);
            } else if (bobClass.areaBooleans[2][2]) {
                this.setLocation(500, 500);
            }

        }
    }


}
