/**
 * 
 */
package Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author as224fg
 *
 */
public class DataUpdater extends DataManager {
	private DataFetcher fetcher;
	private ArrayList<Member> memberList;
	private DataAuthenticate authenticate ;
	public DataUpdater(String path) throws Exception {
		super(path);
		authenticate = new DataAuthenticate(path);
		fetcher = new DataFetcher(path);
	
	}
	public void updateData(Member memberIn, String newName,int newPersonalNum) throws IOException{
		if(fetcher.fetchAllMembers().size() != 0){
			memberList= fetcher.fetchAllMembers();
			if(!authenticate.atunticateMember(memberIn)){
				for(int i=0;i<memberList.size(); i++){
					if(memberList.get(i).equals(memberIn)){
						memberList.get(i).setName(newName);
						memberList.get(i).setPersonalNumber(newPersonalNum);
						for(int k=0; k<memberIn.getBoatsList().size();k++){
							memberList.get(i).addBoat(new Boat());
						}
						this.storeMembersInTheList(memberList);
						return;
					}
				}
				
			}
			else{
				System.out.println("Sys.msg_/MemberDataUpdater: INFO- the member you are trying to update deas not exist!");
			}
		}
		else{
			System.out.println("Sys.msg_/MemberDataUpdater: INFO- There are no members is file!");
		}
	}
	public void deletMember(Member memberIn) throws IOException{
		if(!authenticate.atunticateMember(memberIn)){
			ArrayList<Member> temp= fetcher.fetchAllMembers();
			for(int i=0;i<temp.size();i++){
				if(temp.get(i).equals(memberIn)){
					temp.remove(i);
					this.storeMembersInTheList(temp);
					System.out.println("Sys.msg_/MemberDataUpdater: INFO- the member \""+memberIn.getName() +"\" is removed!");
					return;
				}
			}
		}
		else{
			System.out.println("Sys.msg_/MemberDataUpdater: INFO- the member you are trying to delate can not be found!");
		}
	}
	private void storeMembersInTheList(ArrayList<Member> listIn) throws IOException{
		/*member data fill form
		 * MemberId		MemberName 		MemberPersonalNumber 
		 */
		ArrayList<Member> memberList=new ArrayList<Member>();
		for(int i=0;i<listIn.size();i++){
			memberList.add(listIn.get(i));
		}
		memberData.delete();
		memberData.createNewFile();
		String temp="";
		if(memberData.exists()){
			for(int i=0;i<memberList.size();i++){
				Member newMember=memberList.get(i);
				temp += newMember.getMemberId()+","+newMember.getName()+","+newMember.getPersonalNumber()+",\n"+newMember.getBoatsList().size()+",\n";
			}
			try(FileWriter fw = new FileWriter(memberData, true);
				    BufferedWriter bw = new BufferedWriter(fw);
				    PrintWriter out = new PrintWriter(bw))
				{
				    out.println(temp);
				    System.out.println("Sys.msg_ Updated!"  );
				} catch (IOException e) {
				    System.out.println("Sys.msg_/MemberDataUpdater: ERROR- there was a problem adding the new member, maybe member already exist!"  );
				}
		}
		else{
			System.out.println("Sys.msg_/MemberDataUpdater: ERROR- file MEMBER.txt can not be found!");
		}
	}

}
