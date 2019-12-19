
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
        placementTimer.start(); //Constructs default values for this objects
        setVisible(false);      //For timer, visibility, and size
        setSize(128, 128);

    }

    public void paintComponent(Graphics g1) { //Method used to set up the image of the fire staff
        super.paintComponent(g1);
        ImageIcon fireStaffI = new ImageIcon("C:\\Users\\s241556\\Documents\\NetBeansProjects\\notALOZRipOff\\areaImages\\fireStaff.png");
        fireStaffI.paintIcon(this, g1, 0, 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) { 
        if (classForTesting.areaBooleans[0][0]) { //When detecting that it is in tile 0:0, it will set 
            this.setVisible(true);                //its location and visibility true
            this.setLocation(50,50);
        } else {
            this.setVisible(false); //Otherwise it will remain not visible
        }
    }

}
