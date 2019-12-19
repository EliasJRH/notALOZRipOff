

package notalozripoff;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class bushClass extends JPanel implements ActionListener {

    int x = 0, y = 0;
    Timer placementTimer = new Timer(5, (ActionListener) this);

    public bushClass() {
        placementTimer.start();     //Timer set to start so that it knows when to change
        setSize(227, 234);          //As well as initializing size, location, and opacity
        setLocation(500, 500);
        setOpaque(false);
    }

    public void paintComponent(Graphics g) {    //Method to set up the image
        super.paintComponent(g);
        ImageIcon BUSH = new ImageIcon("pathway for the bush picture");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Events that occur for the bush component to change location when changing tile on the map
        //The locations for the bush are set up randomly
        boolean findChange = classForTesting.detectChange;
        int randomxpos = (int) (Math.random() * (1250 - 50) + 1) + 50;
        int randomypos = (int) (Math.random() * (750 - 50) + 1) + 50;

        if (findChange) {
            classForTesting.detectChange = false;
            if (classForTesting.areaBooleans[2][1]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[2][3]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[2][2]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[2][1]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[2][3]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[2][2]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[2][0]) {
                this.setLocation(randomxpos, randomypos);;
            } else if (classForTesting.areaBooleans[2][4]) {
                this.setLocation(randomxpos, randomypos);
            } //------------------------------------------- Row 0
            else if (classForTesting.areaBooleans[0][1]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[0][0]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[0][2]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[0][3]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[0][4]) {
                this.setLocation(randomxpos, randomypos);
            } //------------------------------------------- Row 1
            else if (classForTesting.areaBooleans[1][0]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[1][1]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[1][2]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[1][3]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[1][4]) {
                this.setLocation(randomxpos, randomypos);
            } //------------------------------------------- Row 3
            else if (classForTesting.areaBooleans[3][0]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[3][1]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[3][2]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[3][3]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[3][4]) {
                this.setLocation(randomxpos, randomypos);
            } //------------------------------------------- Row 4
            else if (classForTesting.areaBooleans[4][0]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[4][1]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[4][2]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[4][3]) {
                this.setLocation(randomxpos, randomypos);
            } else if (classForTesting.areaBooleans[4][4]) {
                this.setLocation(randomxpos, randomypos);
            }

        }

    }
}
