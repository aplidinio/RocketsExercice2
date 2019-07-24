package rocketsRaces;

import java.util.concurrent.Callable;

public class Thruster extends Thread  {
	
	private int rocket;
	private int identification;
	private int maxPower;
	private int accelerate;
	private int currentPower;
	
	public Thruster(int rocket, int identification, int maxPower, int accelerate) {
		
		this.rocket=rocket;
		this.identification=identification;
		this.maxPower=maxPower;
		this.accelerate=accelerate;
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
		
		int z=((this.getMaxPower()/accelerate));
		System.out.println("Valor de " + accelerate + " " + z);
		
		if (z<1 && z>=0) {//Necesario porque si no, falla el thruster de 10 de potencia al dar z=0 en la 3ï¿½ fase
			z=1;
		} else if (z>-1 && z<0) z=-1;
			
			if (accelerate>0) {
				
			//eliminat todo, incluso accelerate. Generar aquí un único impulso
				for (int i=0; i<=this.getMaxPower(); i+=z) {
			
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
			
				for (int i=this.getMaxPower(); i>=0; i+=z) {
				
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
			
	
		}


}
