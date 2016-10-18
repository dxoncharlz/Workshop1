/**
 * 
 */
package View;

import java.util.ArrayList;

import Interface.Boat;

/**
 * @author as224fg
 *
 */
public class SeeSpecificMember extends MainManu {
	
	
	public SeeSpecificMember(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	private SelectAMemberOrBoat selector;

	public void SeeSpecificMember() throws Exception{
		selector= new SelectAMemberOrBoat(super.path);
		System.out.println("To be able to see a specific  member, select a memeber first... ");
		
		ArrayList<Boat> tempboatList = null;
		try{
			singleMember= selector.listAndSelectMember();
			tempboatList= super.fetcher.fetchBoatsByOwnerId(singleMember.getMemberId()) ;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("\nMembers Name: "+singleMember.getName()
						+"\nMembers Personal number: "+singleMember.getPersonalNumber()
						+"\nMembers Id: "+singleMember.getMemberId()
						+"\nNumbers of Boats: "+tempboatList.size()
						+"\nBoats: ");
		for(int i=0;i<tempboatList.size();i++){
			System.out.println("\n\t-"+tempboatList.get(i).getName());
		}
		super.mainListPrintOut();
	}

}
