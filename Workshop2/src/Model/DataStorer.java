/**
 * 
 */
package Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author as224fg
 *
 */
public class DataStorer extends DataManager {
	private DataAuthenticate authenticate;
	private DataFetcher fetcher;
	private DataUpdater updater;
	public DataStorer(String path) throws Exception {
		super(path);
		authenticate = new DataAuthenticate(path);
		fetcher = new DataFetcher(path);
		updater = new DataUpdater(path);
	}
	public void storeNewMember(Member newMember) throws Exception{
		/*member data fill form
		 * MemberId		MemberName 		MemberPersonalNumber NumberOfBoat
		 */
		
		if(super.memberData.exists()){
			if(authenticate.atunticateMember(newMember)){
				String temp = newMember.getMemberId()+","+newMember.getName()+","+newMember.getPersonalNumber()+",\n"+newMember.getBoatsList().size()+",\n";
				try(FileWriter fw = new FileWriter(memberData, true);
				    BufferedWriter bw = new BufferedWriter(fw);
				    PrintWriter out = new PrintWriter(bw))
					{
				    out.println(temp);
				    System.out.println("Sys.msg/DataStorer:  INFO- "+ newMember.getName()+"  is now a member!");
				} catch (IOException e) {
				    System.out.print("ERROR!"  );
				}
			}
			else{
				System.out.println("Sys.msg_/DataStorer: INFO- the member you are trying to add "+ newMember.getName()+"  is already a member");
				throw new Exception();
			}
		}
		else{
			System.out.println("Sys.msg_/DataStorer: ERROR- file MEMBER.txt can not be found!");
		}
	}
	
	/*
	 * BOATS
	 */
	
	public void storeNewBoat(Boat newBoat) throws Exception{
		if(newBoat.getOwnerMemberId()!=0){
		/*Boat data fill form
		 * BoatOwnerMemberId		BoatName 		BoatType	BoatLength
		 */
			
			if(super.boatData.exists()){
				Member tempMember= fetcher.getMemberById(newBoat.getOwnerMemberId());
				
					String temp = newBoat.getOwnerMemberId()+","+newBoat.getName()+","+newBoat.getType()+",\n"+newBoat.getLength()+",\n";
					try(FileWriter fw = new FileWriter(boatData, true);
						BufferedWriter bw = new BufferedWriter(fw);
						PrintWriter out = new PrintWriter(bw))
						{
		
				    	out.println(temp);
				    	tempMember.addBoat(newBoat);
				    	updater.updateData(tempMember, tempMember.getName(), tempMember.getPersonalNumber());
				    	System.out.println("Sys.msg/DataStorer: Update- "+tempMember.getName()+", You have added ur new boat "+ newBoat.getName());
					} catch (IOException e) {
				    	System.out.print("ERROR!"  );
					}
				
			}
			else{
				System.out.println("Sys.msg_/DataStorer: ERROR- file BOAT.txt can not be found!");
			}
		}
	}
}
