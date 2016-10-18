/**
 * 
 */
package Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Interface.Boat;
import Interface.Member;

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
	public void updateMember(Member memberIn, String newName,long l) throws Exception{
		
			
			if(!authenticate.atunticateMember(memberIn)){
				memberList= new ArrayList<Member>();
				memberList= fetcher.fetchAllMembers();
				for(int i=0;i<memberList.size(); i++){
					if(memberList.get(i).equals(memberIn)){
						memberList.get(i).setName(newName);
						memberList.get(i).setPersonalNumber(l);
						for(int k=0; k<memberIn.getBoatsList().size();k++){
							memberList.get(i).addBoat(new Boat());
						}
						this.storeMembersInTheList(memberList);
						break;
					}
					
					
				}
				
			}
			else{
				System.out.println("Sys.msg_/DataUpdater: INFO- the member you are trying to update deas not exist!");
			}
		
		
	}
	public void deletMember(Member memberIn) throws IOException{
		if(!authenticate.atunticateMember(memberIn)){
			ArrayList<Member> temp= fetcher.fetchAllMembers();
			for(int i=0;i<temp.size();i++){
				if(temp.get(i).equals(memberIn)){
					temp.remove(i);
					this.storeMembersInTheList(temp);
					System.out.println("Sys.msg_/DataUpdater: INFO- the member \""+memberIn.getName() +"\" is removed!");
					return;
				}
			}
		}
		else{
			System.out.println("Sys.msg_/DataUpdater: INFO- the member you are trying to delate can not be found!");
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
				    System.out.println("Sys.msg_/DataUpdater: ERROR- there was a problem adding the new member, try again!"  );
				}
		}
		else{
			System.out.println("Sys.msg_/DataUpdater: ERROR- file MEMBER.txt can not be found!");
		}
	}
	
	
	private void storeBoatsInTheList(ArrayList<Boat> listIn) throws IOException{
		/*member data fill form
		 * MemberId		MemberName 		MemberPersonalNumber 
		 */
		ArrayList<Boat> boatList=new ArrayList<Boat>();
		for(int i=0;i<listIn.size();i++){
			boatList.add(listIn.get(i));
		}
		boatData.delete();
		boatData.createNewFile();
		String temp="";
		if(boatData.exists()){
			for(int i=0;i<boatList.size();i++){
				Boat newBoat=boatList.get(i);
				temp += newBoat.getOwnerMemberId()+","+newBoat.getName()+","+newBoat.getType()+",\n"+newBoat.getLength()+",\n";
			}
			try(FileWriter fw = new FileWriter(boatData, true);
				    BufferedWriter bw = new BufferedWriter(fw);
				    PrintWriter out = new PrintWriter(bw))
				{
				    out.println(temp);
				    System.out.println("Sys.msg_ Updated!"  );
				} catch (IOException e) {
				    System.out.println("Sys.msg_DataUpdater: ERROR- there was a problem adding the new boat, try again!"  );
				}
		}
		else{
			System.out.println("Sys.msg_/DataUpdater: ERROR- file MEMBER.txt can not be found!");
		}
	}
	public void deletBoat(Boat boatIn) throws Exception{
		ArrayList<Boat> temp= fetcher.fetchAllBoats();
		for(int i=0;i<temp.size();i++){
			if(temp.get(i).equals(boatIn)){
				temp.remove(i);
				Member tempMemb=fetcher.getMemberById(boatIn.getOwnerMemberId());
				tempMemb.deletBoat(boatIn);
				this.updateMember(tempMemb, tempMemb.getName(), tempMemb.getPersonalNumber());
				
				this.storeBoatsInTheList(temp);
				System.out.println("Sys.msg_/DataUpdater: INFO- the Boat \""+boatIn.getName() +"\" is removed!");
				return;
			}
		}
	}
	public void updateBoat(Boat boatIn, String newName, String type, Double length) throws Exception{
		
		
		if(!authenticate.atunticateBoat(boatIn)){
			ArrayList<Boat> boatList= fetcher.fetchAllBoats();
			for(int i=0;i<boatList.size(); i++){
				if(boatList.get(i).equals(boatIn)){
					boatList.get(i).setName(newName);
					boatList.get(i).setType(type);
					boatList.get(i).setLength(length);
					this.storeBoatsInTheList(boatList);
					break;
				}
				
				
			}
			
		}
		else{
			System.out.println("Sys.msg_/DataUpdater: INFO- the member you are trying to update deas not exist!");
		}
	
	
}
}
