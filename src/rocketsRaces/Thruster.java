package rocketsRaces;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thruster extends Thread {
	
	private int identification;
	private int maxPower;
	private int rocket;
	private int currentPower;
	
	public Thruster(int identification, int maxPower, int rocket) {
		
		this.maxPower=maxPower;
		this.identification=identification;
		this.rocket=rocket;
	}
	
	public int getMaxPower() {
		return maxPower;
	}

	public void setMaxPower(int maxPower) {
		this.maxPower = maxPower;
	}

	public int getIdentification() {
		return identification;
	}

	public void setIdentification(int identification) {
		this.identification = identification;
	}

	public int getRocket() {
		return rocket;
	}

	public void setRocket(int rocket) {
		this.rocket = rocket;

	}
	
	public int getCurrentPower() {
		return currentPower;
	}
	
	@Override
	public String toString() {
		
		return "Rocket " + rocket + " Thruster " + identification + " -->  Current Power: " + currentPower;
	}
		
	public void run() {
		
		//shutDown.lock();
		try {
		
			for (int i=0; i<=Rocket.maxPower(); i+=10) {
			
				if(this.getMaxPower()>=i) 
					currentPower=i;
				
			try {
				sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			System.out.println(toString());
			getCurrentPower();
				
		}
			for (int i=100; i>=0; i-=10) {
						
				if(this.getMaxPower()>=i) 
					currentPower=i;
		
			try {
				sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			System.out.println(toString());
			getCurrentPower();	
			}
			
		}finally {
			
			//shutDown.unlock();
		}
		
	}

}
