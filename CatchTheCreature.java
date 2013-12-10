import javax.swing.*;

/**
 * CatchTheCreature
 * @author Alec Fenichel
 * @version awesome
 * Collaboration Statement:
 * I worked on this homework alone.
 */
 

public class CatchTheCreature
{
    
    public static void main(String[] args)
	{
		JFrame frame = new JFrame("Catch the Creature");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Object[] possibilities = {"Alex", "Taylor"};
        String monster = "Alex";
        monster = (String)JOptionPane.showInputDialog(frame, "Who would you like the monster to be?", "Monster", JOptionPane.PLAIN_MESSAGE, null, possibilities, "Alex");
        String difficulty = "Easy";
        Object[] diff = {"Easy", "Medium", "Hard"};
        difficulty = (String)JOptionPane.showInputDialog(frame, "What difficulty would you like?", "Difficulty", JOptionPane.PLAIN_MESSAGE, null, diff, "Easy");
         
        ImageIcon image;
        int time;
        
        if ("Alex".equals(monster))
            image = new ImageIcon("alex.jpg");
        else
            image = new ImageIcon("taylor.jpg");
        
        if ("Easy".equals(difficulty))
            time = 1000;
        else if ("Medium".equals(difficulty))
            time = 500;
        else
            time = 0;
        
        frame.add(new CatchTheCreaturePanel(time, image));
		frame.pack();
        frame.setVisible(true);
	}
	
}
