package rocketsRaces;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainRocket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList <Thruster> thrustersRocket1=new ArrayList<Thruster>();
		Thruster t1R1= new Thruster (1,10,1);
		Thruster t2R1= new Thruster (2,30,1);
		Thruster t3R1= new Thruster (3,80,1);

		thrustersRocket1.add(t1R1);
		thrustersRocket1.add(t2R1);
		thrustersRocket1.add(t3R1);
		
		ArrayList <Thruster> thrustersRocket2=new ArrayList<Thruster>();
		Thruster t1R2= new Thruster (1,30,2);
		Thruster t2R2= new Thruster (2,40,2);
		Thruster t3R2= new Thruster (3,50,2);
		Thruster t4R2= new Thruster (4,50,2);
		Thruster t5R2= new Thruster (5,30,2);
		Thruster t6R2= new Thruster (6,10,2);

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
		rocket1.start();

		Scanner sc = new Scanner(System.in);
		String a= sc.nextLine();
		System.out.println();
		
		System.out.println("Rocket " + rocket2.getCodeRocket() + " has " + rocket2.getThrusters().size() + " trusters. \n");
		System.out.println("");
		rocket2.start();

	}

}
