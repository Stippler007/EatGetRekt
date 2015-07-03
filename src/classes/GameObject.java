/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

/**
 *
 * @author Stippler
 */
public class GameObject
{
  public boolean alive=true;
  
  private float x;
  private float y;
  
  protected float speedX;
  protected float speedY;
  
  private float maxLive = 100;
  private float live = maxLive;
  
  private float realoadTime=0;
  private float maxRealoadTime=0.3f;
  
  private int speed;
  private Rectangle bounding;
  
  private boolean move=false;
  
  private BufferedImage look[];
  public float zoom=1f;
  
  public GameObject(float x, float y, int speed,String imageTag,int length,int width,int height)
  {
    this.x = x;
    this.y = y;
    this.speed = speed;
    bounding=new Rectangle((int)x, (int)y, width, height);
    setLook(imageTag, length, width, height);
//    setZoom(0.5f);
  }
  public void setZoom(float zoom)
  {
    this.zoom=zoom;
    
    bounding.width*=zoom;
    bounding.height*=zoom;
    
  }
  public void setLook(String imageTag, int length,int width,int height)
  {
    look=new BufferedImage[length];
    for (int i = 0; i < look.length; i++)
    {
      look[i]=ImageFactory.getIF().getLook(imageTag).getSubimage(i*width, 0,width,height);
    }
  }
  
  public void damage(float damage)
  {
    live-=damage;
  }
  
  
  public void collide()
  {
    collideMap();
  }
  private void collideMap()
  {
//    for (int i =(int)((Background.x/25*-1)+((x/25)-2)); i <= (int)((Background.x/25*-1)+((x/25)+2)); i++) 
//    {
//      for (int j = (int)((Background.y/25*-1)+((y/25-2))); j <= (int)((Background.y/25*-1)+((y/25+2))); j++) 
//      {
//        if(!(i<0)&&!(j<0)&&map[i][j]!=null&&map[i][j].isSolid())
//        {
//          Rectangle help2=map[i][j].getBounding();
//          rebound(help2);
//        }
//      }
//    }
  }
  public void update(float tslf)
  {
    x+=speedX*tslf;
    y+=speedY*tslf;
  }
  public void moveToTarget(float targetX,float targetY)
  {
    float speedX = (targetX) - (x+bounding.width/2);
    float speedY = (targetY) - (y+bounding.height/2);
    
    float help = (float)Math.sqrt(speedX*speedX+speedY*speedY);
    
    speedX/=help;
    speedY/=help;
    
    speedX*=speed;
    speedY*=speed;
    
    this.speedX+=speedX;
    this.speedY+=speedY;
  }
  public void rebound(Rectangle help)
  {
    float x=this.x-speedX;
    float y=this.y-speedY;
    float w=bounding.width;
    float h=bounding.height; 
    
    if(x < help.x + help.width && x+w > help.x &&
       y < help.y + help.height && y+h > help.y)
    {
      double vonlinks=x+w-help.x;
      double vonoben=y+h-help.y;
      double vonrechts=help.x+help.width-x;
      double vonunten=help.y + help.height - y;

      if(vonlinks<vonoben&&vonlinks<vonrechts&&vonlinks<vonunten)
      {
        speedX+=vonlinks;
      }
      else if(vonoben<vonrechts&&vonoben<vonunten)
      {
        speedY+=vonoben;
      }
      else if(vonrechts<vonunten)
      {
        speedX-=vonrechts;
      }
      else
      {
        speedY-=vonunten;
      }
    }
  }
  public void draw(Graphics2D g)
  {
    g.scale(zoom, zoom);
    g.drawImage(look[0], null, (int)x, (int)y);
    g.scale(zoom/zoom, zoom/zoom);
  }
  public Rectangle getBounding()
  {
    return bounding;
  }
  public float getX()
  {
    return x;
  }
  public float getY()
  {
    return y;
  }
  public float getLive()
  {
      return live;
  }
  public float getMaxLive()
  {
      return maxLive;
  }
  public BufferedImage getLook() 
  {
    return look[0];
  }
}
