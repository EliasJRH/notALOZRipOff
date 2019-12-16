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
/*
if (classForTesting.areaBooleans[2][1]) {
                this.setLocation(500, 250);
            } else if (classForTesting.areaBooleans[2][3]) {
                this.setLocation(700, 250);
            } else if (classForTesting.areaBooleans[2][2]) {
                this.setLocation(500, 500);
            } else if (classForTesting.areaBooleans[2][0]) {
            	this.setLocation(895, 23);
            } else if (classForTesting.areaBooleans[2][4]) {
            	this.setLocation(1377, 459);
            }
            //------------------------------------------- Row 0
            else if (classForTesting.areaBooleans[0][1]) {
            	this.setLocation(1072, 679);
            } else if (classForTesting.areaBooleans[0][0]) {
            	this.setLocation(616, 614);
            } else if (classForTesting.areaBooleans[0][2]) {
            	this.setLocation(443, 259);
            } else if (classForTesting.areaBooleans[0][3]) {
            	this.setLocation(101, 63);
            } else if (classForTesting.areaBooleans[0][4]) {
            	this.setLocation(858, 207);
            }
            //------------------------------------------- Row 1
            else if (classForTesting.areaBooleans[1][0]) {
            	this.setLocation(872, 721);
            } else if (classForTesting.areaBooleans[1][1]) {
            	this.setLocation(1006, 287);
            } else if (classForTesting.areaBooleans[1][2]) {
            	this.setLocation(773, 444);
            } else if (classForTesting.areaBooleans[1][3]) {
            	this.setLocation(260, 332);
            } else if (classForTesting.areaBooleans[1][4]) {
            	this.setLocation(665, 464);
            }
            //------------------------------------------- Row 3
            else if (classForTesting.areaBooleans[3][0]) {
            	this.setLocation(1022, 251);
            } else if (classForTesting.areaBooleans[3][1]) {
            	this.setLocation(765, 100);
            } else if (classForTesting.areaBooleans[3][2]) {
            	this.setLocation(1050, 500);
            } else if (classForTesting.areaBooleans[3][3]) {
            	this.setLocation(800, 655);
            } else if (classForTesting.areaBooleans[3][4]) {
            	this.setLocation(365, 463);
            }
            //------------------------------------------- Row 4
            else if (classForTesting.areaBooleans[4][0]) {
            	this.setLocation(605, 698);
            } else if (classForTesting.areaBooleans[4][1]) {
            	this.setLocation(752, 652);
            } else if (classForTesting.areaBooleans[4][2]) {
            	this.setLocation(156, 340);
            } else if (classForTesting.areaBooleans[4][3]) {
            	this.setLocation(750, 478);
            } else if (classForTesting.areaBooleans[4][4]) {
            	this.setLocation(354, 247);
            }
*/
    }
}
