package main;

public class Screen {

	public static void main(String[] args) {
		Load l=new Load();
		l.frame.setVisible(true);
		try {
			for(int i=0;i<=100;i++)
			{
				Thread.sleep(50);
				l.per.setText(i+" %");
				l.load.setValue(i);
				
			}
			
			}
			catch(Exception e) {}
		Login ob=new Login();
		l.frame.setVisible(false);
		try {
		Thread.sleep(1000);
		}
		catch(Exception e) {}
		ob.frame.setVisible(true);

	}

}