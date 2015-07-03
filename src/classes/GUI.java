package classes;

import classes.background.Background;
import classes.background.BackgroundPart;
import classes.listener.KL;
import classes.listener.MML;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class GUI extends JFrame
{
  private Background bg;
  private BufferStrategy strat;
  private List<GameObject> gameObjects;
  
  public GUI(Background bg,List<GameObject> gameObjects)
  {
    this.bg=bg;
    this.gameObjects=gameObjects;
    addKeyListener(new KL(this));
    addMouseMotionListener(new MML(this));
  }
  
  public void makeStrat(){
      createBufferStrategy(2);
      strat = getBufferStrategy();
  }
  private float xScaling = 1;
  private float yScaling = 1;
  public void setFullscreen()
  {
    if(xScaling==1&&yScaling==1)
    {
      setExtendedState(Frame.MAXIMIZED_BOTH);
      xScaling = (float)getWidth()/800f;
      yScaling = (float)getHeight()/600f;
      setLocationRelativeTo(null);
      setVisible(false);
      setVisible(true);
    }
    else
    {
      setSize(800, 600);
      xScaling=1;
      yScaling=1;
      setLocationRelativeTo(null);
    }
  }
  public void repaintScreen()
  {
    Graphics2D g=(Graphics2D)strat.getDrawGraphics();
    g.scale(xScaling, yScaling);
    draw(g);
    g.dispose();
    strat.show();
  }
  private void draw(Graphics2D g)
  {
    bg.drawBG(g,1);
    for (GameObject gameObject : gameObjects)
    {
      gameObject.draw(g);
    }
  }

  public float getxScaling()
  {
    return xScaling;
  }

  public float getyScaling()
  {
    return yScaling;
  }
  
}
