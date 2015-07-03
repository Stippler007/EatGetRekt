package classes;

import classes.background.Background;
import classes.listener.KL;
import classes.player.Player;
import java.awt.event.KeyEvent;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main
{
  public static void main(String[] args)
  {
    
    Background bg=new Background();
    
    Player player=new Player(100, 100, 200, 1);
    
    LinkedList<GameObject> gameObjects=new LinkedList<>();
    
    gameObjects.sort(new Comparator<GameObject>()
    {
      @Override
      public int compare(GameObject t, GameObject t1)
      {
        if(t.getY()>t.getY())
        {
          return 1;
        }
        if(t.getY()<t.getY())
        {
          return -1;
        }
        return 0;
      }
    });
    
    gameObjects.add(player);
    
    GUI  f=new GUI(bg,gameObjects);
    f.setVisible(true);
    f.setResizable(false);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(800, 600);
    f.setLocationRelativeTo(null);
    f.setTitle("EatGetRekt");
    f.makeStrat();
    
    long lastFrame=System.currentTimeMillis();
    while(true)
    {
      long thisFrame=System.currentTimeMillis();
      float tslf=(float)(thisFrame-lastFrame)/1000;
      lastFrame=thisFrame;
      
      f.repaintScreen();
      
      bg.update(tslf);
      for (GameObject gameObject : gameObjects)
      {
        gameObject.update(tslf);
      }
      try
      {
        Thread.sleep(15);
      } catch (InterruptedException ex)
      {
        JOptionPane.showMessageDialog(null, "You can not travel backwards in time. "
                + "Error: "+ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
      }
      if(KL.keys[KeyEvent.VK_ESCAPE])
      {
        System.exit(0);
      }
    }
  }
}
