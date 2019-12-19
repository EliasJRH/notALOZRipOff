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
public class fireStaff extends JPanel implements ActionListener {

    Timer placementTimer = new Timer(5, this);

    public fireStaff() {
        placementTimer.start();
        setVisible(false);
        setSize(128, 128);

    }

    public void paintComponent(Graphics g1) {
        super.paintComponent(g1);
        ImageIcon fireStaffI = new ImageIcon("C:\\Users\\s241556\\Documents\\NetBeansProjects\\notALOZRipOff\\areaImages\\fireStaff.png");
        fireStaffI.paintIcon(this, g1, 0, 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (classForTesting.areaBooleans[0][0]) {
            this.setVisible(true);
            this.setLocation(50,50);
        } else {
            this.setVisible(false);
        }
    }

}
