
package notalozripoff;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class purpleStaff extends JPanel implements ActionListener {

    Timer placementTimer = new Timer(5, this);
    
    public purpleStaff() {          //Constructor with default values of the object
        placementTimer.start();
        setVisible(false);
        setSize(128, 128);
        setOpaque(false);
    }
    
    public void paintComponent(Graphics g) { //Method used to set up the image of the purple staff
        super.paintComponent(g);
        ImageIcon purpleStaffI = new ImageIcon("pathway for the Adrian's rock picture");
        purpleStaffI.paintIcon(this, g, 0, 0);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (classForTesting.areaBooleans[4][4]) { //When the user is at tile 4:4, then it will set 
            this.setVisible(true);                //the purple staff's location and visibility to false
            this.setLocation(750, 750);
        } else {
            this.setVisible(false); //If the user is detected elsewhere, then it will remain not visible
        }
    }
    
}
