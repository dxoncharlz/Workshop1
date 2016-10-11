/**
 * 
 */
package View;

import java.util.Scanner;

import Interface.Member;
import Model.DataStorer;

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
		long personalNumber=0;
		scan = new Scanner(System.in);
		
		System.out.print("Fill out the information about the new memebr.\n Name --> ");
		if(scan.hasNextLine()){
			name =scan.nextLine();
			if(name.isEmpty() || name.contains(" ")){
				System.err.println("Sys_Msg/ VIEW_CreatNewMember-  ERROR- name can not be blank or it can not contain withspace! please try again...");
				return false;
			}
		}
		System.out.print("\n Personal number --> ");
		if(scan.hasNextLong()){
			try{
				personalNumber = scan.nextLong();
				if(personalNumber<=0)
					throw new Exception();
			}
			catch(Exception e){
				System.err.println("Sys_Msg/ VIEW_CreatNewMember-  ERROR- personal number must be a number and greater than zero! please try again...");
				return false;
			}
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
