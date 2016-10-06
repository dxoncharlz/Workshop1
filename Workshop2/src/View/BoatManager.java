/**
 * 
 */
package View;

import java.util.Scanner;

import Model.Boat;

/**
 * @author as224fg
 *
 */
public class BoatManager extends MainManu{
	
	private SelectAMember selector;
	private String path;
	public BoatManager(String path) {
		
		super(path);
		this.path = path;
		// TODO Auto-generated constructor stub
	}
	
	public void boatManager() throws Exception {
		System.out.println("To be able manage ur boat, identifay urself first...");
		selector = new SelectAMember(path);
		try {
			super.singleMember = selector.listAndSelectMember();
		} catch (Exception e) {
			return;
		}
		System.out.println("Welcome "+super.singleMember.getName()+",\nSelect what you want to do..");
		System.out.println("\n1. Add a boat"
						   + "\n2. Delete a boat"
						   + "\n3.Update boat Information"
						   + "\n99. back to main");
		super.takeCommand(3);
		while(command == 1){
			if(this.addBoat()){
				System.out.print("Do you want to add more boat? "
						+ "\n1.yes "
						+ "\n99. back to boat manager");
				super.takeCommand(1);
				if(command == 1){
					continue;
				}
				else{
					this.boatManager();
				}
			}
			else{
				System.out.println("\nDo you want to try again? "
						+ "\n1.yes "
						+ "\n99. back to boat manager");
				super.takeCommand(1);
				if(command == 1){
					continue;
				}
				else{
					this.boatManager();
				}
			}
		
		}
		if(command == 2){
			
		}
		else if(command == 3){
			
		}
		else if (command == 99){
			super.mainListPrintOut();
		}
		this.boatManager();
	}
	public boolean addBoat() {
		scan = new Scanner(System.in);
		System.out.print("Adding a new boat.\n New boat name --> ");
		String boatName= scan.nextLine();
		System.out.print("\n New boat Type --> ");
		String boatType= scan.nextLine();
		System.out.print("\n New boat Length --> ");
		double boatLength = 0;
		try{
			
			boatLength = scan.nextDouble();
			if(boatLength<=0){
				throw new Exception();
			}
			
		}
		catch(Exception e){
			System.err.print("\n ERROR: Boat legth must be a number and greater than 0!");
			return false;
		}
		
		try {
			super.singleBoat = new Boat(boatName, boatType, boatLength);
			super.singleBoat.setOwnerMemberId(super.singleMember.getMemberId());
			super.dataStorer.storeNewBoat(singleBoat);
			
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;		
		}
		return true;
	}
	
}
