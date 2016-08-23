import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class snake extends Applet implements KeyListener,Runnable 
{
  int x=0,y=0,l=1,n=2;
  Random rx=new Random();
  Image img1;
  AudioClip audioClip;
  int rx1=Math.abs((rx.nextInt()%30)*20);
  Random ry=new Random();
  int ry1=Math.abs((ry.nextInt()%43)*20);
  int x1[]=new int[20];
  int y1[]=new int[20];  
  boolean b=true;
  Thread t;
  public void init()
  {
   img1 = getImage(getCodeBase(),"index2.jpg");
   audioClip = getAudioClip(getCodeBase(),"gameover.wav");
   for(int i=0;i<=19;i++)
   {
    x1[i]=-20;
	y1[i]=0;
   }
   for(int i=0;i<=n;i++)
		{
			if(rx1==x1[i] && ry1==y1[i])
			{
				rx1=Math.abs((rx.nextInt()%30)*20);
				ry1=Math.abs((ry.nextInt()%30)*20);
			}
		}
   t=new Thread(this);
   setFocusable(true);
   addKeyListener(this);
   System.out.println(rx1+"$"+ry1);
   t.start();
  }
  
  public void start()
  {
  
  }

  public void stop()
  {
  
  }

  public void destroy()
  {
  
  }
  
  public void run()
  {
   while(b)
   {
    if(l==0)
	{
	  if(x==0)
	   {
	    x=860;
	   }
	   else
	   {
	    x-=20;
	   }
	 }
	 if(l==1)
	 {
	   if(x==860)
	   {
	    x=0;
	   }
	   else
	   {
	    x+=20;
	   }	   
	 }
	 
	 if(l==2)
	 {
	  if(y==0)
	   {
	    y=600;
	   }
	   else
	   {
	    y-=20;
	   }
     }
	 
	 if(l==3)
	 {
	   if(y==600)
	   {
	    y=0;
	   }
	   else
	   {
	    y+=20;
	   }
	 }
	  if(x==rx1 && y==ry1)
	  {
	    n++;
		rx1=Math.abs((rx.nextInt()%30)*20);
		ry1=Math.abs((ry.nextInt()%30)*20);
		for(int i=0;i<=n;i++)
		{
			if(rx1==x1[i] && ry1==y1[i])
			{
				rx1=Math.abs((rx.nextInt()%30)*20);
				ry1=Math.abs((ry.nextInt()%30)*20);
			}
		}
	  }
	 for(int i=0;i<=n;i++)
		{
			if(x==x1[i] && y==y1[i])
			{
				b=false;
			}
		}
	 repaint();
	 try{
	 t.sleep(100);}catch(Exception e){}
     x1[0]=x;
	 y1[0]=y;

   for(int i=19;i>=1;i--)	
   {
    x1[i]=x1[i-1];
	y1[i]=y1[i-1];
   }  
   }
  }
  public void keyPressed(KeyEvent e)
  {
    
    if(e.getKeyCode()==KeyEvent.VK_LEFT)
	{
	 if(l!=1)
	{
	   l=0;
	  
	}
    }
    
    if(e.getKeyCode()==KeyEvent.VK_RIGHT)
	{
	if(l!=0)
    {	
	   
	   l=1;
	}
	}
	if(e.getKeyCode()==KeyEvent.VK_UP)
	{
	  if(l!=3)
	  {
	   
	    l=2;
	   
	}
	}
	if(e.getKeyCode()==KeyEvent.VK_DOWN)
	{
	   if(l!=2)
	   {
	   
	    l=3;
	  
	}
	}
  }
  
  public void keyReleased(KeyEvent ae) 
  {}
    
  public void keyTyped(KeyEvent ee)
  {}
  public void paint(Graphics g)
  {
   if(b)
   {
     g.setColor(Color.BLACK);
	 g.fillRect(x,y,20,20);
	 for(int i=0;i<=n;i++)
	 {
	  g.fillRect(x1[i],y1[i],20,20);
	 }
	/*for(int i=0;i<=860;i+=20)
    {	
	  for(int j=0;j<=600;j+=20)
	  {
        g.drawRect(i,j,20,20);
      }
    }*/
	 g.fillRect(rx1,ry1,20,20);
   }
    else
   {
     g.drawImage(img1,30,30,500,500,this);
	 audioClip.play();
   }
}
}
/*
<applet code="snake" width="900" height="640">
</applet>
*/