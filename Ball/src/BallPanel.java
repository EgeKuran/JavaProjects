import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.JPanel;

public class BallPanel extends JPanel {
int ballPosx=50;
int ballPosy=50;
int directionX=1;
int directionY=1;
int getClickPointX=0;
int getClickPointY =0;
private Thread t;

  	public BallPanel() {
	  
	  this.addMouseMotionListener(new MouseAdapter() {
		  @Override
		public void mouseDragged(MouseEvent e) {
			 
				ballPosx=e.getX()-20;
				ballPosy=e.getY()-20;
					repaint();
		}
	  });
	  this.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseReleased(MouseEvent e)  {
			
				
					directionX = (e.getX() - getClickPointX) / 40;
					directionY = (e.getY() - getClickPointY) / 40;
					t = new Thread(() -> {
						while (true) {
							ballPosx += directionX;
							ballPosy += directionY;

							if (ballPosx < 0) {
								directionX = -directionX;
							} else if (ballPosx > getWidth() - 40) {
								directionX = -directionX;
								ballPosx = getWidth() - 40;
							}

							if (ballPosy < 0) {
								directionY = -directionY;
							} else if (ballPosy > getHeight() - 40) {
								directionY = -directionY;
								ballPosy = getHeight() - 40;
							}

							repaint();

							try {
								Thread.sleep(10);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					t.start();
				}
			
	  
		});
	  
	  

	  this.addMouseListener(new MouseAdapter() {
		  
		  @Override
			public void mousePressed(MouseEvent e) {
			  
				getClickPointX =e.getX();
				getClickPointY=e.getY();
				ballPosx=getClickPointX-20;
				ballPosy=getClickPointY-20;
				repaint();
				t.stop();
				
			}
	  });
  	}
  		
  			
  			@Override
  			public void paint(Graphics g) {
			super.paint(g);
	
  			g.setColor(Color.BLUE);
  			g.fillArc(ballPosx, ballPosy, 40, 40, 0, 360);
  			}


}
