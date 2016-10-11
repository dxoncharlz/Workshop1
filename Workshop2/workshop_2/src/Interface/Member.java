/**
 * 
 */
package Interface;

import java.util.ArrayList;

import Model.memebrIdGenerator;

/**
 * @author abelt
 *
 */
public class Member {
	private String name;
	private long personalNumber;
	private long memberId;
	private ArrayList<Boat> boatsList;
	private memebrIdGenerator idGenrator;
	
	public Member(String name, long l){
		this.name = name;
		this.personalNumber = l;
		idGenrator = new memebrIdGenerator();
		this.memberId = idGenrator.getUniqueId();
		boatsList =new ArrayList<Boat>();
	}
	
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPersonalNumber() {
		return personalNumber;
	}
	public void setPersonalNumber(long personalNumber) throws Exception {
		if(personalNumber>0){
			this.personalNumber = personalNumber;
		}
		else{
			System.err.println("Sys_Msg/Member   ERROR- personal number  can not be zero!");
			throw new Exception ();
		}
	}
	public ArrayList<Boat> getBoatsList() {
		return boatsList;
	}
	public void setBoatsList(ArrayList<Boat> boatsList) {
		this.boatsList = boatsList;
	}
	public long getMemberId() {
		return memberId;
	}
	public void setMemberId(long l) {
		this.memberId = l;
	}
	public void addBoat(Boat newBoat){
		boatsList.add(newBoat);
	}
	public void deletBoat(Boat boatToDelete){
		boatsList.remove(boatToDelete);
	}
	
	public boolean equals(Member memberIn){
		
		return this.name.equals(memberIn.name) && this.personalNumber==memberIn.personalNumber ;
	}
}
