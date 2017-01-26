package Splashscreen;

public class SplashThread extends Thread
{
	private SplashPanel splashpanel = null;
	private boolean isFinished = false;
	
	public SplashThread(){}
	
	public SplashThread(SplashPanel panel)
	{
		this.splashpanel = panel;		
	}
	
	@Override
	public void run()
	{		
		int i = 0;
		while(i < 4)
		{
			this.splashpanel.repaint();
			
			try
			{
				this.sleep(4000);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
		isFinished = true;
	}

	public boolean isFinished()
	{
		return isFinished;
	}
	
	
}
