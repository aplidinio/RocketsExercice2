package rocketsRaces;


public class Thruster extends Thread  {
	
	private int rocket;
	private int identification;
	private int maxPower;
	private int initialPower;
	private int finalPower;
	private int currentPower;
	private int accelerate;
	
	public Thruster(int rocket, int identification, int maxPower) {
		
		this.rocket=rocket;
		this.identification=identification;
		this.maxPower=maxPower;
		//this.initialPower=initialPower;
		//this.finalPower=finalPower;
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
	public int getInitialPower() {
		return initialPower;
	}
	public void setInitialPower(int initialPower) {
		this.initialPower = initialPower;
	}
	public int getFinalPower() {
		return finalPower;
	}
	public void setFinalPower(int finalPower) {
		this.finalPower = finalPower;
	}
	public int getCurrentPower() {
		return currentPower;
	}
	
	public void setAccelerate(int accelerate) {
		// TODO Auto-generated method stub
		this.accelerate=accelerate;
	}
	public int getAccelerate() {
		return accelerate;
	}	
	
	@Override
	public String toString() {
		
		return "Rocket " + rocket + " Thruster " + identification + " -->  Current Power: " + currentPower;
	}
		
	public void run() {
		
		int z=Math.round((finalPower-initialPower)/accelerate);
		System.out.println("Valor de " + finalPower + " " + initialPower+ " " + z);
		
		/*if (z<1 && z>=0) {//Necesario porque si no, falla el thruster de 10 de potencia al dar z=0 en la 3� fase
			z=1;
		} else if (z>-1 && z<0) z=-1;*/
		
			if (finalPower>=initialPower) {
				
				for (int i=initialPower; i<=finalPower; i+=z) {
			
					//if(this.getMaxPower()>=i) 
						currentPower=Math.round(i*this.maxPower/100);
				
					try {
						sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println(toString());
					//System.out.println("acelerando");
					getCurrentPower();
				}
				
			} else {
			
				for (int i=initialPower; i>=finalPower; i+=z) {
				
				//	if(this.getMaxPower()>=i) 
						currentPower=Math.round(i*this.maxPower/100);
					try {
						sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					System.out.println(toString());
					//System.out.println("DECELERANDO");

					getCurrentPower();	
			}
			
		
			}

	}
}
