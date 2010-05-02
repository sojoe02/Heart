/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Events;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.Timer;
import Logic.*;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author Soren V Jorgensen
 */
public class Pulse extends JComponent implements ActionListener, MouseListener, EventInterface {

    int amp = 1;
    double alpha = 1;
    long StartTime = System.currentTimeMillis() / 1000;
    long EndTime = System.currentTimeMillis() / 1000;
    Timer timer;
    ArrayList<Integer> y = new ArrayList<Integer>(800);
    ArrayList<Integer> x = new ArrayList<Integer>(800);
    int getY;
    int getX;
    int c;
    ExpSine expe = new ExpSine();
    boolean saveevent = false;
    int filename = 0;

    public Pulse() {
	timer = new Timer(10, this);
	addMouseListener(this);
	timer.stop();
	setOpaque(false);

    }

    public void dot(int a, int d) {
	x.add(d);
	y.add((int) (expe.pulseFunction(200, -0.007, a, x.get(d), 0.05)));
    }

    @Override
    public void paintComponent(Graphics g) {
	g.setColor(Color.black);
	g.fillRect(0, 0, getWidth(), getHeight());
	drawDot(g);
    }

    public void drawDot(Graphics g) {

	if (x.size() > 0 && c < x.size()) {
	    c++;
	    int code = 50;

	    if (saveevent == false) {
		for (int i = -1; i < 40; i++) {
		    g.setColor(new Color(0, code, 0));
		    if (x.size() > i + c) {
			g.fillOval(x.get(c + i) + getX, y.get(c + i), 4, 4);
		    }
		    code += 5;
		}
	    } else {
		int a = 1;
		while (x.size() > a) {
		    g.setColor(Color.green);
		    g.drawLine(x.get(a - 1) + getX, y.get(a - 1), x.get(a) + getX, y.get(a));
		    a++;
		}
	    }

	}


    }

    public void actionPerformed(ActionEvent ae) {
	if (saveevent == false) {
	    repaint();
	}
    }

    public void mouseClicked(MouseEvent me) {
    }

    public void mousePressed(MouseEvent me) {
	if (me.getButton() == 1) {
	    x.clear();
	    y.clear();
	    c = 1;
	    getY = me.getY();
	    getX = me.getX();
	    int a = 0;
	    while (getWidth() > a) {
		dot(getY, a);
		a++;
	    }
	    timer.start();
	    if (saveevent == true) {
		repaint();
	    }
	}
	if (me.getButton() == 3) {
	    if (saveevent == true) {
		saveevent = false;
		timer.stop();
	    } else {
		saveevent = true;
	    }
	}
	if(me.getButton() ==2){
	    saveEvent("pulse" + filename+ ".jpg");
	    filename ++;
	}
    }

    public void mouseReleased(MouseEvent me) {
	//saveEvent("something.jpg");
    }

    public void mouseEntered(MouseEvent me) {
	//throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseExited(MouseEvent me) {
	//throw new UnsupportedOperationException("Not supported yet.");
    }

    public void saveEvent(String filename) {
	Dimension size = this.getSize();
	BufferedImage myImage =
		new BufferedImage(size.width, size.height,
		BufferedImage.TYPE_INT_RGB);
	Graphics2D g2 = myImage.createGraphics();
	this.paint(g2);
	try {
	    OutputStream out = new FileOutputStream(filename);
	    JPEGImageEncoder encoder =
		    JPEGCodec.createJPEGEncoder(out);
	    encoder.encode(myImage);
	    out.close();
	} catch (Exception e) {
	    System.out.println(e);
	}
    }
}
