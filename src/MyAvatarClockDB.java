import java.awt.*;

public class MyAvatarClockDB extends MyAvatarClock {

	public void paint(Graphics g){
		Image image = createImage(700,700);
		Graphics offscreen = image.getGraphics();
		super.paint(offscreen);
		g.drawImage(image,0,0,this);
	}
	
	public void update(Graphics g){
		paint(g);
	}
}
