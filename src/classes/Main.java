package classes;

import javax.swing.JFrame;

public class Main
{
  public static void main(String[] args)
  {
    GUI  f=new GUI();
    f.setVisible(true);
    f.setResizable(false);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(800, 600);
    f.setLocationRelativeTo(null);
    f.setTitle("EatGetRekt");
  }
}
