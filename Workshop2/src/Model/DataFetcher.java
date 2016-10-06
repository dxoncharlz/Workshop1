/**
 * 
 */
package Model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author as224fg
 *
 */
public class DataFetcher extends DataManager {

	private ArrayList<Member> memberList;
	private ArrayList<Boat> boatList;
	private Member singleMember;
	private Boat singleBoat;
	private String Data;
	private Scanner scan;
	public DataFetcher(String path) throws Exception {
		super(path);
		this.memberList =new ArrayList<Member>();
		this.boatList =new ArrayList<Boat>();
	}
	public ArrayList<Member> fetchAllMembers() throws FileNotFoundException{
		
		
		String name="";
		int uniqId=0;
		int personalNumber=0;
		int numOfBoat=0;
		String temp="";
		Data="";
		scan = new Scanner(memberData);
		while(scan.hasNextLine()){
			Data+= scan.nextLine();
		}
		scan.close();
		int counter=0;
		if(!Data.isEmpty()){
			
			for(int i=0;i<Data.length();i++){
				char c=Data.charAt(i);
				if(counter==4){
					counter=0;
					Member singleMember= new Member(name,personalNumber);
					singleMember.setMemberId(uniqId);
					
					
					/*for(int k=0;k<numOfBoat;k++){
						if(boatList.get(k).getOwnerMemberId() == singleMember.getMemberId()){
							singleMember.addBoat(boatList.get(k));
							}
					}*/
					for(int k=0;k<numOfBoat;k++){
						singleMember.addBoat(new Boat());
					}
				memberList.add(singleMember);
				}
				else if(c==',' && counter==0){
					uniqId=Integer.parseInt(temp);
					counter++;
				
					temp="";
				}
				else if(c==',' && counter==1){
					name=temp;
					counter++;
					temp="";
				}
				else if(c==',' && counter==2){
					personalNumber=Integer.parseInt(temp);
					counter++;
					temp="";
				}
				else if(c==',' && counter==3){
					numOfBoat = Integer.parseInt(temp);
					counter++;
					temp="";
				}
				else{
				
					temp+=c;
				}
			}
			Member singleMember= new Member(name,personalNumber);
			singleMember.setMemberId(uniqId);
			memberList.add(singleMember);
			}
		else{
			System.out.println("Sys.msg_/DataFetcher:  WARRNING- System can not Fetch members, no members were found!");
			}
		
		return memberList;
	}
	public Member getMemberById(int memberId){
		
		try {
			memberList=this.fetchAllMembers();
			for(int i=0;i<memberList.size();i++){
				if(memberList.get(i).getMemberId() == memberId){
					singleMember = new Member(memberList.get(i).getName(),memberList.get(i).getPersonalNumber());
					singleMember.setMemberId(memberId);
					return singleMember;
				}
				System.out.println("Sys_Msg/DataFetcher: Info- No member Were found with this memberId!");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Sys_Msg/DataFetcher: Error- members could not be fetched!");
		}
		return null;
	}
	public ArrayList<Boat> fetchAllBoats() throws FileNotFoundException{
		
		String boatName="";
		int ownerId=0;
		double length=0;
		String boatType="";
		String temp="";
		Data="";
		scan = new Scanner(boatData);
		while(scan.hasNextLine()){
			Data+= scan.nextLine();
		}
		scan.close();
		int counter=0;
		if(!Data.isEmpty()){
			for(int i=0;i<Data.length();i++){
				char c=Data.charAt(i);
				if(counter==4){
					counter=0;
					singleBoat= new Boat(boatName,boatType,length);
					singleBoat.setOwnerMemberId(ownerId);
					boatList.add(singleBoat);
				}
				else if(c==',' && counter==0){
					ownerId =Integer.parseInt(temp);
					counter++;
				
					temp="";
				}
				else if(c==',' && counter==1){
					boatName = temp;
					counter++;
					temp="";
				}
				else if(c==',' && counter==2){
					boatType = temp;
					counter++;
					temp="";
				}
				else if(c==',' && counter==3){
					length = Double.parseDouble(temp);
					counter++;
					temp="";
				}
				else{
				
					temp+=c;
				}
			}
			singleBoat= new Boat(boatName,boatType,length);
			singleBoat.setOwnerMemberId(ownerId);
			boatList.add(singleBoat);
			}
		else{
			System.out.println("Sys.msg_/DataFetcher:  WARRNING- System can not Fetch Boats, no boat were found!");
			}
		
		return boatList;
	}

	
}
