package teamproject;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class earthStaff extends JPanel implements ActionListener {

    Timer placementTimer = new Timer(5, this);

    public earthStaff() {
        placementTimer.start();
        setVisible(false);
        setSize(128, 128);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon earthStaffI = new ImageIcon("pathway for the Adrian's rock picture");
        earthStaffI.paintIcon(this, g, 0, 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (classForTesting.areaBooleans[4][0]) {
            this.setVisible(true);
            this.setLocation(750, 50);
        } else {
            this.setVisible(false);
        }
    }
}
