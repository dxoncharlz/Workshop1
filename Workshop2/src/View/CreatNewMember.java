/**
 * 
 */
package View;

import java.util.Scanner;

import Model.DataStorer;
import Model.Member;

/**
 * @author as224fg
 *
 */
public class CreatNewMember extends MainManu {
	
	public CreatNewMember(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	public void creatController() throws Exception{
		while(!ceateNewMember()){
			System.out.println("Do you want to try again? \n 1 = yes, \n 99  = back to main ");
			
				super.command = super.takeCommand(1);
				if(super.command==1){
					continue;
				}
				else{
					break;
				}
				
				//System.out.println("Do you want to add more new memebers? \n 1 = yes, \n 99 = back to main ");
				//command=takeCommand(1);
			
		}
		super.mainListPrintOut();
	}
	
	private  boolean ceateNewMember() throws Exception{
		//super.dataStorer = new DataStorer(super.path);
		String name="";
		int personalNumber=0;
		scan = new Scanner(System.in);
		
		System.out.print("Fill out the information about the new memebr.\n Name --> ");
		if(scan.hasNextLine())
			name =scan.nextLine();
		System.out.print("\n Personal number --> ");
		if(scan.hasNextInt()){
			personalNumber = scan.nextInt();
		}
		super.singleMember= new Member(name,personalNumber );
		try {
			dataStorer.storeNewMember(super.singleMember);	
			
		} catch (Exception e) {
			System.out.println("UI_Msg/ceateNewMember: ERROR- There was a problem creating new memebr, see system message and try again..");
			return false;
		}
		return true;
	}

}
