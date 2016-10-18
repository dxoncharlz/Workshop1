/**
 * 
 */
package Model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Interface.Boat;
import Interface.Member;

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
		this.memberList =new ArrayList<Member>();
		
		String name="";
		long uniqId=0;
		long personalNumber=0;
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
					Member singleMember;
					try {
						singleMember = new Member(name,personalNumber);
						singleMember.setMemberId(uniqId);
						String dataBackUp= Data;
						singleMember.setBoatsList(this.fetchBoatsByOwnerId(uniqId));
						Data = dataBackUp;
						memberList.add(singleMember);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				if(c==',' && counter==0){
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
					personalNumber=Long.parseLong(temp);
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
			Member singleMember;
			try {
				singleMember = new Member(name,personalNumber);
				singleMember.setMemberId(uniqId);
				String dataBackUp= Data;
				singleMember.setBoatsList(this.fetchBoatsByOwnerId(uniqId));
				Data = dataBackUp;
				memberList.add(singleMember);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		else{
			System.out.println("Sys.msg_/DataFetcher:  WARRNING-  no members were found!");
			}
		
		return memberList;
	}
	public Member getMemberById(long in){
		
		try {
			memberList=this.fetchAllMembers();
			for(int i=0;i<memberList.size();i++){
				if(memberList.get(i).getMemberId() == in){
					singleMember = new Member(memberList.get(i).getName(),memberList.get(i).getPersonalNumber());
					singleMember.setMemberId(in);
					return singleMember;
				}
			}
			System.out.println("Sys_Msg/DataFetcher: Info- No member Were found with this memberId!");
		} catch (FileNotFoundException e) {
			System.out.println("Sys_Msg/DataFetcher: Error- members could not be fetched!");
		} catch (Exception e) {
			
		}
		return null;
	}
	public ArrayList<Boat> fetchAllBoats() throws FileNotFoundException{
		this.boatList =new ArrayList<Boat>();
		String boatName="";
		long ownerId=0;
		double length=0;
		String boatType="";
		String temp="";
		Data="";
		scan = new Scanner(boatData);
		while(scan.hasNext()){
			Data+= scan.next();
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
				if(c==',' && counter==0){
					ownerId =Long.parseLong(temp);
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
			/*System.out.println("Sys.msg_/DataFetcher:  WARRNING- System can not Fetch Boats, no boat were found!");
			}*/
		}
		return boatList;
	}
	
	public ArrayList<Boat> fetchBoatsByOwnerId(long id) throws FileNotFoundException{
		ArrayList<Boat> boatList= new ArrayList<Boat>();
		
		boatList=this.fetchAllBoats();
		ArrayList<Boat> retArr = new ArrayList<Boat>();
		for(int i=0;i<boatList.size();i++){
			if(boatList.get(i).getOwnerMemberId() == id){
				retArr.add(boatList.get(i));
			}
		}
		
	return retArr;
	}
	
}
