/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.background;

import classes.background.back.Grass;
import java.awt.Graphics2D;

/**
 *
 * @author Stippler
 */
public class Background
{
  private BackgroundPart[][] map=new BackgroundPart[32][24];
  
  public Background()
  {
    for (int i = 0; i < map.length; i++)
    {
      for (int j = 0; j < map[0].length; j++)
      {
        map[i][j]=new Grass(1);
      }
    }
  }
  
  public void setMap(BackgroundPart[][] map) 
  {
    this.map = map;
  }
  
  public void update(float tslf)
  {
    for (int i = 0; i < map.length; i++)
    {
      for (int j = 0; j < map[i].length; j++)
      {
        map[i][j].bounding.x=i*25;
        map[i][j].bounding.y=j*25;
      }
    }
  }
  
  public void updateBackgroundParts()
  {
    
  }
  
  public void drawBG(Graphics2D g, float scale)
  {
    g.scale(scale, scale);
    for (int i = 0; i < map.length; i++)
    {
      for (int j = 0; j < map[i].length; j++)
      {
        map[i][j].draw(g);
      }
    }
  }

  public BackgroundPart[][] getMap()
  {
    return map;
  }
}
