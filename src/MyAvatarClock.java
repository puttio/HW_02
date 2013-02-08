import java.awt.*;
import java.util.Calendar;

public class MyAvatarClock extends MyAvatar implements Runnable {
	protected Thread mainThread;
	protected int delay;

	public void init(){
		mainThread = null;
		delay = 200;
		
	}
	
	public void start(){
		if(mainThread == null){
			mainThread = new Thread(this);
			mainThread.start();
		}
	}
	
	public void run(){
		while(Thread.currentThread() == mainThread){
			repaint();
			try{
				Thread.currentThread().sleep(delay);
			}catch(InterruptedException e){}
		}
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Dimension d = this.getSize();
		int s = Calendar.getInstance().get(Calendar.SECOND);
		
		// delete the original eyes 
		g.setColor(new Color(255,226,220));
		g.fillRoundRect(220,d.height/2-15,110,60,20,40);
		
		g.fillRoundRect(220+158,d.height/2-15,110,60,20,30);
		
		/* draw clock dial */

		int posX = 0;
		int posY = 0;
		double angle = Math.toRadians(-84);
		final double ANGLE_STEP = Math.toRadians(6.0);

		// 60 indicators
		for(int i = 1; i <= 60; i++){

			g.setColor(Color.BLACK);

			// update X,Y positions of the indicator
			posX = (int)(Math.cos(angle)*300+d.getWidth()/2);
			posY = (int)(Math.sin(angle)*300+d.getHeight()/2)+20;

			// a number indicator every 5 seconds
			if(i%5 == 0){
				if(i == s) g.setColor(Color.GREEN);

				// tweak position of "5" for aesthetic purpose 
				if(i == 5){
					g.drawString(""+(i%61), posX, posY);
				}
				else{
					g.drawString(""+(i%61), posX-10, posY);
				}

			}
			// dot indicator for the rest
			else{
				if(i == s) g.setColor(Color.GREEN);
				g.setFont(g.getFont().deriveFont(30f));
				g.fillOval(posX,posY-10,8,8);
			}

			// update angle for next indicator
			angle += ANGLE_STEP;
		}

		/* eyeball time-indicator */
		g.setColor(Color.WHITE);
		g.fillOval(d.width/2-95,d.height/2-20,55,55);
		g.fillOval(d.width/2+60,d.height/2-20,55,55);
		g.setColor(Color.BLACK);
		g.drawOval(d.width/2-95,d.height/2-20,55,55);
		g.drawOval(d.width/2+60,d.height/2-20,55,55);
		g.fillOval((int)(Math.cos(Math.toRadians(-84+s*6))*18+275),(int)(Math.sin(Math.toRadians(-84+s*6))*18+347),20,20);
		g.fillOval((int)(Math.cos(Math.toRadians(-84+s*6))*18+430),(int)(Math.sin(Math.toRadians(-84+s*6))*18+347),20,20);
	
	}
	
}
