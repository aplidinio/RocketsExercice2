package rocketsRaces;

import java.util.ArrayList;
import java.util.Scanner;

public class MainRocket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList <Thruster> thrustersRocket1=new ArrayList<Thruster>();
		Thruster t1R1= new Thruster (1,1,10,0);
		Thruster t2R1= new Thruster (1,2,30,0);
		Thruster t3R1= new Thruster (1,3,80,0);

		thrustersRocket1.add(t1R1);
		thrustersRocket1.add(t2R1);
		thrustersRocket1.add(t3R1);
		
		ArrayList <Thruster> thrustersRocket2=new ArrayList<Thruster>();
		Thruster t1R2= new Thruster (2,1,30,0);
		Thruster t2R2= new Thruster (2,2,40,0);
		Thruster t3R2= new Thruster (2,3,50,0);
		Thruster t4R2= new Thruster (2,4,50,0);
		Thruster t5R2= new Thruster (2,5,30,0);
		Thruster t6R2= new Thruster (2,6,10,0);

		thrustersRocket2.add(t1R2);
		thrustersRocket2.add(t2R2);
		thrustersRocket2.add(t3R2);
		thrustersRocket2.add(t4R2);
		thrustersRocket2.add(t5R2);
		thrustersRocket2.add(t6R2);
		
		int [] speed1= {3,-5,15};
		int [] speed2= {3,7,15};
		
		Rocket rocket1 = new Rocket ("32WESSDS", thrustersRocket1, speed1);
		Rocket rocket2 = new Rocket ("LDSFJA32", thrustersRocket2, speed2);
		
		System.out.println("Rocket " + rocket1.getCodeRocket() + " has " + rocket1.getThrusters().size() + " trusters. \n");
		System.out.println("");
		
		rocket1.setAcceleration(speed1);
		
		System.out.println();		
		System.out.println("Rocket " + rocket2.getCodeRocket() + " has " + rocket2.getThrusters().size() + " trusters. \n");
		System.out.println("");
	
		
		Scanner sc = new Scanner(System.in);
		String a= sc.nextLine();
		System.out.println();
		
		rocket2.setAcceleration(speed2);


	}

}
