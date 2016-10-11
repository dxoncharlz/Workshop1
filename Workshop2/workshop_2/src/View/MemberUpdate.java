/**
 * 
 */
package View;

import java.io.IOException;
import java.util.Scanner;

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

	private SelectAMember selector;
	
	public void memberUpdate() throws Exception{
		
		selector= new SelectAMember(super.path);
		String name=null;
		int persNum = 0;
		singleMember= selector.listAndSelectMember();
		scan= new Scanner(System.in);
		System.out.println("To be able to update a member, select a memeber first... ");
		
		System.out.print("New Name--> ");
		if(scan.hasNextLine())
			name = scan.nextLine();
		System.out.print("new Personal--> ");
		if(scan.hasNextLine())
			persNum= scan.nextInt();
		
		try {
		
			memberDataUpdater.updateData(singleMember, name, persNum);
		} catch (IOException e) {
			System.err.println("ERROR_ couldnt update the member!");
		} catch (Exception e) {
			System.err.println("ERROR_404: Members file not found!");
		}
		super.mainListPrintOut();
	}
}
