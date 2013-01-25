import java.awt.*;
import java.applet.Applet;

/* Apparently, my ears are so small that I couldn't get
 * both of them to be visible at the same time. 
 * I hope I won't get point deductions because my ears are small! 
 */

public class MyAvatar extends Applet{
	public void paint(Graphics g){

		
		// set canvas size to 700x700 for debugging purpose
		this.setSize(700,700);
		Dimension d = this.getSize();
		
		// name in the bottom-right corner
		g.drawString("Putti Orungrochkul",d.width-140,d.height-10);
		
		// face
		// 6.6 width 11.5 height
		// define a polygon resembling my face 
		//Polygon polygonFace = new Polygon();
		
		
		/* 0	1	2	3
		 * 1		b	c	
		 * 2		a	d
		 * 3
		 * 
		 */
		/*
		polygonFace.addPoint(200,200);
		polygonFace.addPoint(200,100);
		polygonFace.addPoint(300,100);
		polygonFace.addPoint(300,200);
		

		
		g.setColor(Color.BLACK);
		g.fillPolygon(polygonFace);
		*/
		
	
		//g.drawOval(100, 100, 264, 460);
		
		// hair
		
		// define a polygon resembling my face 
		Polygon polygonHair = new Polygon();
				
		polygonHair.addPoint(200,200);
		polygonHair.addPoint(200,100);
		polygonHair.addPoint(300,100);
		polygonHair.addPoint(300,200);
		
		g.setColor(Color.BLACK);
		g.fillPolygon(polygonHair);

		
		// eyes
		
		
		// eyebrows
		
		
		// eyeglasses 
		
		
		// ears
		
		// mouth
		
		// teeth
		
		// braces
		
		// lips
		
		// nose
		
		// nostrils
		
		// blemishes
		
		// neck
		
		// torso
	}
}