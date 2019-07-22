package rocketsRaces;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Rocket extends Thread{
	
	private String codeRocket;
	private ArrayList <Thruster> thrusters= new ArrayList<Thruster>();
	private int []speed;
	
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
		
	@Override
	public String toString() {
		return "Rocket [codeRocket=" + this.getCodeRocket() + " thrusters=" + this.getThrusters().size() + "]";
	}
	
	public void setAcceleration(int []speed) {
			
		
		ExecutorService executor = Executors.newFixedThreadPool(thrusters.size());
			
			//for (int i=0; i<speed.length; i++) {
			for (int j=0; j<thrusters.size(); j++) {
				
				Runnable thruster = new Thruster(1,thrusters.get(j).getIdentification(), thrusters.get(j).getMaxPower(), speed[0]);
				executor.execute(thruster);
			}
		//	}
			for (int j=0; j<thrusters.size(); j++) {
				
				Runnable thruster = new Thruster(1,thrusters.get(j).getIdentification(), thrusters.get(j).getMaxPower(), speed[1]);
				executor.execute(thruster);
			}
			for (int j=0; j<thrusters.size(); j++) {
				
				Runnable thruster = new Thruster(1,thrusters.get(j).getIdentification(), thrusters.get(j).getMaxPower(), speed[2]);
				executor.execute(thruster);
			}
			
		
			
			
			executor.shutdown();
			while (!executor.isTerminated()) {//pillamos un thruster cualquiera
				showSpeed();
				try {
					sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			while(!executor.isTerminated()) {}
			}
			
			
			
		
}
		
		
	
	
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public void run() {
		
		
		for(int i=0; i<thrusters.size(); i++) {
			
			thrusters.get(i).setAccelerate(5);//PROBAR UNA MATRIZ EN THRUSTERS CON LA ACELERACI�N
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
		for(int i=0; i<thrusters.size(); i++) {
			thrusters.get(i).s
		}
		
		
		for(int i=0; i<thrusters.size(); i++) {
			
			thrusters.get(i).setAccelerate(-5);
			
			
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

	}*/
	

