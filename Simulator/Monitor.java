package Simulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import Events.Pulse;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Soren V. Jorgensen
 */
public class Monitor extends JFrame implements MouseListener{

  /*  Timer timer;
    Pulse pulse;
    int getY;
    Random random;

    public Monitor() {
	timer = new Timer(10000, this);
	pulse = new Pulse();
	//initial delay while window gets set up
	timer.setInitialDelay(100);
	timer.start();
	addMouseListener(this);
	
    }

    @Override
    public void paintComponent(Graphics g) {
	
	pulse.drawDot(g);
    }

    public void actionPerformed(ActionEvent ae) {
	
    }

    public void mouseClicked(MouseEvent me) {

	

    }

    public void mousePressed(MouseEvent me) {

	getY = me.getY();
	int c = 0;
	while (getWidth() > c) {
	    pulse.Dot(getY, c);
	    c++;
	}
	repaint();
	
	
	//throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseReleased(MouseEvent me) {
	//throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseEntered(MouseEvent me) {
	//throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseExited(MouseEvent me) {
	//throw new UnsupportedOperationException("Not supported yet.");
    }*/
    private static void createAndShowGUI() {
	JFrame f = new JFrame("Animated Graphics");
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setPreferredSize(new Dimension(800,600));
	//f.setPreferredSize(200, 200);
	Pulse mp = new Pulse();
	mp.setBackground(Color.yellow);
	f.add(mp);
	f.setVisible(true);
	f.pack();
	f.addMouseListener(mp);
    }

    public static void main(String args[]) {

	Runnable doCreateAndShowGUI = new Runnable() {

	    public void run() {

		createAndShowGUI();
	    }
	};
	SwingUtilities.invokeLater(doCreateAndShowGUI);
	try {
	    Thread.sleep(2);
	} catch (Exception e) {
	}
    }

    public void mouseClicked(MouseEvent me) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mousePressed(MouseEvent me) {

	repaint();
    }

    public void mouseReleased(MouseEvent me) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseEntered(MouseEvent me) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseExited(MouseEvent me) {
	throw new UnsupportedOperationException("Not supported yet.");
    }
}
