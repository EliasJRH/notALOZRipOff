/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notalozripoff;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

//public static boolean[][] = 
public class mapClass extends JFrame implements ActionListener {

    Timer changeDetector = new Timer(5, this);
    boolean areaBooleans[] = new boolean[3];
    classForTesting dude = new classForTesting();
    backGround background = new backGround();
    tree tree1 = new tree();
    ghostClass ghost1 = new ghostClass();
    bushClass bush = new bushClass();
    slimeClass slime = new slimeClass();
    rockClass rock = new rockClass();
    fireStaff staff1 = new fireStaff();
    waterStaff staff2 = new waterStaff();
    earthStaff staff3 = new earthStaff();
    purpClass staff4 = new purpClass();

    public mapClass() throws InterruptedException {
        changeDetector.start();
        setLayout(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth(); //sets int width to the width of the screen
        int height = (int) screenSize.getHeight(); //sets int height to the height of the screen
        setSize(width, height); //sets the size of the frame  
        setSize(width, height); //sets the size of the frame  
        setResizable(false); //makes it so that the frame isnt resizable
        setVisible(true); //sets the frame to make it visible
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //sets the frame so the program stops when its close
        add(dude);
        add(ghost1);
        add(bush);
        add(tree1);  
        add (slime);
        add(rock);
        add(staff1);
        add(staff2);
        add(staff3);
        add(staff4);
        add(background);
        validate();
        Thread.sleep(50);
        dude.setLocation(500, 250);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean test = classForTesting.detectChange;
        if (test) {
            this.remove(tree1);
            this.add(tree1);
            this.repaint();
            this.validate();
        }
    }

}
