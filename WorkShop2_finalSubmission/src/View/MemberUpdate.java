/**
 * 
 */
package View;

import java.io.IOException;
import java.util.Scanner;

import Interface.Member;
import Model.DataUpdater;

/**
 * @author as224fg
 *
 */
public class MemberUpdate extends MainManu {
	public MemberUpdate(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	private SelectAMemberOrBoat selector;
	
	public void memberUpdate() throws Exception {
		
		selector= new SelectAMemberOrBoat(super.path);
		String name=null;
		long persNum = 0;
		singleMember= selector.listAndSelectMember();
		scan= new Scanner(System.in);
		System.out.println("Now Enter the new information ");
		
		System.out.print("New Name--> ");
		if(scan.hasNextLine())
			name = scan.nextLine();
		System.out.print("new Personal--> ");
		if(scan.hasNextLong())
			persNum= scan.nextLong();
		
		try {
			Member temp= new Member(name, persNum);
		} catch (Exception e1) {
			System.out.println("Oops! could not update,, see system msg and try again!");
			super.mainListPrintOut();
		}
		
		try {
		
			dataUpdater.updateMember(singleMember, name, persNum);
		} catch (IOException e) {
			System.err.println("ERROR_ couldnt update the member!");
		} catch (Exception e) {
			System.err.println("ERROR_404: Members file not found!");
		}
		super.mainListPrintOut();
	}
}
