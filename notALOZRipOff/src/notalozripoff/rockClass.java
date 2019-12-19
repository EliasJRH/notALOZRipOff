package notalozripoff;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class rockClass extends JPanel implements ActionListener {

    int x = 0, y = 0;
    Timer placementTimer = new Timer(5, (ActionListener) this);

    public rockClass() {
        placementTimer.start();
        setSize(227, 234);      //Will change size later
        setLocation(500, 500);
        setOpaque(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon ROCK = new ImageIcon("pathway for the Adrian's rock picture");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int randomxpos = (int) (Math.random() * (1250 - 50) + 1) + 50;
        int randomypos = (int) (Math.random() * (750 - 50) + 1) + 50;
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
