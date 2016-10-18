/**
 * 
 */
package View;

import java.io.IOException;

import Model.DataUpdater;

/**
 * @author as224fg
 *
 */

public class DeleteAMember extends MainManu {
	private SelectAMemberOrBoat selector;
	public DeleteAMember(String path) {
		super(path);
		
	}

	
	
	public void DeleteAMember() throws Exception{

		selector= new SelectAMemberOrBoat(super.path);
		System.out.println("To be able to delete a member, select a memeber first... ");
		singleMember= selector.listAndSelectMember();
		try {
			dataUpdater.deletMember(singleMember);
			
		}
		catch (IOException e) {
			System.err.println("ERROR_ couldnt delet the member!");
		}
		super.mainListPrintOut();
	}
}
