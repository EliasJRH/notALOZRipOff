/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworldtest;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Elias
 */
public class frameClass extends JFrame implements ActionListener {

    Timer t = new Timer(5,this);
    secondImageClass secondImage = new secondImageClass();
    
    public frameClass() throws InterruptedException {
        t.start();
        setLayout(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //gets the screen size of the monitor
        int width = (int) screenSize.getWidth(); //sets int width to the width of the screen
        int height = (int) screenSize.getHeight(); //sets int height to the height of the screen
        setSize(width, height); //sets the size of the frame  
        setResizable(false); //makes it so that the frame isnt resizable
        setVisible(true); //sets the frame to make it visible
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //sets the frame so the program stops when its closed 
        bobClass lol = new bobClass();       
        lol.setVisible(true);
        add(secondImage);        
        add(lol);
        validate();
        Thread.sleep(100);
        lol.requestFocus();
        validate();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        boolean test = bobClass.detectChange;
        if (test){
            bobClass.detectChange = false;
            this.remove(secondImage);
            if (bobClass.areaBooleans[2][1]){
                secondImage.setLocation(500,250);
            }else if (bobClass.areaBooleans[2][3]){
                secondImage.setLocation(700,250);
            }else if (bobClass.areaBooleans[2][2]){
                secondImage.setLocation(500,500);
            }
            this.add(secondImage);
            this.repaint();
            this.validate();
        }
    }

}
