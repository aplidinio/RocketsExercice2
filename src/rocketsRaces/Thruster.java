package rocketsRaces;

public class Thruster extends Thread {
	
	private int rocket;
	private int identification;
	private int maxPower;
	private int accelerate;
	private int currentPower;
	
	public Thruster(int rocket, int identification, int maxPower) {
		
		this.rocket=rocket;
		this.identification=identification;
		this.maxPower=maxPower;
	}
	
	public int getRocket() {
		return rocket;
	}

	public void setRocket(int rocket) {
		this.rocket = rocket;
	}

	public int getIdentification() {
		return identification;
	}

	public void setIdentification(int identification) {
		this.identification = identification;
	}

	public int getMaxPower() {
		return maxPower;
	}

	public void setMaxPower(int maxPower) {
		this.maxPower = maxPower;
	}

	public int getAccelerate() {
		return accelerate;
	}

	public void setAccelerate(int accelerate) {
		this.accelerate = accelerate;
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
			
			if (accelerate>0) {
			
				for (int i=0; i<=100; i+=accelerate) {
			
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
				
			} else if (accelerate<0) {
			
				for (int i=100; i>=0; i-=accelerate) {
				
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
			
			
			} else currentPower=accelerate;
			
			
		}finally {
			
			//shutDown.unlock();
		}
		
	}

}
