package rocketsRaces;

import java.util.ArrayList;

public class Rocket extends Thread implements Runnable{
	
	private String codeRocket;
	private ArrayList <Thruster> thrusters= new ArrayList<Thruster>();
	private int []speed;
	private int totalPower, sum;
	
	public Rocket(String codeRocket, ArrayList<Thruster> thrusters, int []speed) {
		
		this.codeRocket=codeRocket;
		this.thrusters=thrusters;
		this.speed=speed;
	}
		
	public String getCodeRocket() {
		return codeRocket;
	}

	public void setCodeRocket(String codeRocket) {
		this.codeRocket = codeRocket;
	}

	public ArrayList<Thruster> getThrusters() {
		return thrusters;
	}

	public void setThrusters(ArrayList<Thruster> thrusters) {
		this.thrusters = thrusters;
	}

	public int [] getSpeed() {
		return speed;
	}

	public void setSpeed(int []speed) {
		this.speed = speed;
	}

	public void showAllThrustersData() {
		for (Thruster thruster : this.getThrusters()) {
			thruster.toString();
		}
	}
	
	public void showSpeed() {
		
		int totalPower=0;
		
		for (Thruster thruster : this.getThrusters()) {
			
			totalPower+=thruster.getCurrentPower();
		}
		
		int currentSpeed = 100 *(int) Math.sqrt(totalPower);
		
		System.out.println("Current speed: " +currentSpeed);
			
	}
	
	public void setMaxPower() {//esto da la potencia máxima de todos los trusters
		
		int totalPower=0;
				
		for (int i=0; i<thrusters.size(); i++) {
					
			totalPower+=thrusters.get(i).getMaxPower();
		}	
				
		this.totalPower=totalPower;
	}
	
	public int getMaxPower() {
		return totalPower;
	}
	public void setFlyProgram() {// esto da la suma de todas las acelraciones y deceleraciones
		
		int sum=0;
		
		for (int i : speed) {
			sum+=i;
		}
		this.sum=sum;
	}
	public int getFlyProgram() {
		return sum;
	}
	
	
	@Override
	public String toString() {
		return "Rocket [codeRocket=" + this.getCodeRocket() + " thrusters=" + this.getThrusters().size() + "]";
	}
	
	public void run() {
		
		for(int i=0; i<thrusters.size(); i++) {
			
			thrusters.get(i).start();// probar Executor para que empiecen todos a la vez
			
		}
		
		//buscar el thruster + potente
		while (this.getThrusters().get(0).isAlive()) {//pillamos un thruster cualquiera
			showSpeed();
			try {
				sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
	
}
