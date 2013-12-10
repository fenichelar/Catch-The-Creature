import java.awt.event.*;
import java.lang.Math.*;
import java.util.Random;
import java.util.EventListener;
import java.awt.*;
import javax.swing.*;

/**
 * CatchTheCreaturePanel
 * @author Alec Fenichel
 * @version awesome
 * Collaboration Statement:
 * I worked on this homework alone.
 */

public class CatchTheCreaturePanel extends JPanel
{
    private Creature creature;
	
    private Timer timer;
	private int delay;
	
    private ActionListener taskPerformer;
	
    private static final Random RANDOM_GEN = new Random();
	
    private JLabel titleBar = new JLabel("Caught: " + Creature.caught + " Missed: " + Creature.missed + " Catch Percentage: 0%");
	
	public CatchTheCreaturePanel (int time, ImageIcon image)
	{
		creature = new Creature(image);
		
        this.add(titleBar);
		this.setPreferredSize(new Dimension(800, 500));
		this.setBackground(Color.black);
		this.addMouseListener(new CreatureListener());
		
        titleBar.setForeground(Color.white);
		
        delay = RANDOM_GEN.nextInt(1000)+time;
		timer = new Timer(delay, taskPerformer);
		timer.addActionListener(new taskPerformer());
		timer.start();
		
	}

	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		creature.draw(g);		
	}
	
	public void updateMissed(boolean condition)
	{
		if (condition == true)
		{
			Creature.missed++;
			timer.restart();
			creature.move();
			repaint();
		}
		else
		{
			Creature.caught++;
			timer.restart();
			creature.move();
			repaint();
		}
		Creature.updatePercent();
 		String updatetitleBar = ("Caught: " + Creature.caught + " Missed: " + Creature.missed + " Catch Percentage: " + Math.round(Creature.percent) +"%");
		titleBar.setText(updatetitleBar);
	}
		
	private class taskPerformer implements ActionListener	
	{
		public void actionPerformed(ActionEvent e)
		{
			updateMissed(true);
		}
	}
	
	private class CreatureListener implements MouseListener 
	{
		
		public void mousePressed(MouseEvent e) 
		{
				
				if(creature.isClickedOn(e.getPoint())) 
				{
					updateMissed(false);
				}
				
				else
				{
					updateMissed(true);
				}
			
		}
		
		public void mouseReleased(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
	}
	
	
}

