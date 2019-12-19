package notalozripoff;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class earthStaff extends JPanel implements ActionListener {

    Timer placementTimer = new Timer(5, this);

    public earthStaff() {
        placementTimer.start();   //Constructor sets up the picture to have the timer start
        setVisible(false);        //As well as initializing size and visibility
        setSize(128, 128);
    }

    public void paintComponent(Graphics g) { //Method to set up the picture
        super.paintComponent(g);
        ImageIcon earthStaffI = new ImageIcon("pathway for the Adrian's rock picture");
        earthStaffI.paintIcon(this, g, 0, 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) { //Events that causes it to change
        if (classForTesting.areaBooleans[4][0]) { //If the map layout is detected to be in tile 4:0, then it will be set visible 
            this.setVisible(true);                //With the location set for it
            this.setLocation(50, 750);
        } else {
            this.setVisible(false);               //Otherwise it will not show up at all
        }
    }
}
