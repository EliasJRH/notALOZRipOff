
package notalozripoff;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class purpleStaff extends JPanel implements ActionListener {

    Timer placementTimer = new Timer(5, this);
    
    public purpleStaff() {
        placementTimer.start();
        setVisible(false);
        setSize(128, 128);
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon purpleStaffI = new ImageIcon("pathway for the Adrian's rock picture");
        purpleStaffI.paintIcon(this, g, 0, 0);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (classForTesting.areaBooleans[4][4]) {
            this.setVisible(true);
            this.setLocation(750, 750); //Location Right here needs to be changed
        } else {
            this.setVisible(false);
        }
    }
    
}
