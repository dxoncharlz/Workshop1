/**
 * 
 */
package Model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import Interface.Boat;
import Interface.Member;

/**
 * @author as224fg
 *
 */
public class DataAuthenticate  {
	private DataFetcher fetcher;
	
	public DataAuthenticate(String path) throws Exception {
		fetcher = new DataFetcher(path);

	}
	
	public boolean atunticateMember(Member newMember) throws FileNotFoundException{
		
		ArrayList<Member> memberList = fetcher.fetchAllMembers();
		for(int i=0;i<memberList.size();i++){
			if(newMember.equals(memberList.get(i))){
				return false;
			}
		}
	
	return true;
}

	public boolean atunticateBoat(Boat newBoat) {
		// TODO Auto-generated method stub
		return false;
	}
	
			
}
