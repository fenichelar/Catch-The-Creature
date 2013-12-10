import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
 * Creature
 * @author Alec Fenichel
 * @version awesome
 * Collaboration Statement:
 * I worked on this homework alone.
 */

public class Creature
{

	private static final Random RANDOM_GEN = new Random();
	private ImageIcon image;
	private int xLocation, yLocation;
	private int xMax = 800;
	private int yMax = 500;
	private int width, height;
	private Point location;
	protected static double percent;
	protected static int caught = 0;
	protected static int missed = 0;
	private static ImageIcon CREATURE_IMAGE;

	public Creature(ImageIcon image)
	{
		this.image = image;
		width = image.getIconWidth();
		height = image.getIconHeight();
		xLocation = RANDOM_GEN.nextInt(xMax-width);
		yLocation = RANDOM_GEN.nextInt(yMax-height);
	}
		
	public void draw(Graphics g)
	{
		image.paintIcon(null, g, xLocation, yLocation);
	}
	
	public void move()
	{
		xLocation = RANDOM_GEN.nextInt(xMax-width);
		yLocation = RANDOM_GEN.nextInt(yMax-height);
	}
	
	public boolean isClickedOn(Point p) 
	{
	Rectangle rect = new Rectangle(xLocation, yLocation, width, height);		
	return rect.contains(p);
	}
	
	public static void updatePercent()
	{
		if (caught + missed != 0)
		{
			 percent = caught/(double)(caught+missed)*100;
		}
		else
		{
			percent = 0;
		}
		
	}
}