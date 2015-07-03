/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.listener;

import classes.GUI;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Christian
 */
public class KL implements KeyListener
{
  public static boolean keys[]=new boolean[1024];
  private GUI f;
  
  public KL(GUI f) 
  {
    this.f=f;
  }
  
  
  
  @Override
  public void keyTyped(KeyEvent e){
    
  }
  @Override
  public void keyPressed(KeyEvent e)
  {
    if(e.getKeyCode()==KeyEvent.VK_F)
    {
      f.setFullscreen();
    }
    keys[e.getKeyCode()]=true;
  }
  @Override
  public void keyReleased(KeyEvent e)
  {
    keys[e.getKeyCode()]=false;
  }
}
