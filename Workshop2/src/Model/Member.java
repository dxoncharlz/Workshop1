/**
 * 
 */
package Model;

import java.util.ArrayList;

/**
 * @author abelt
 *
 */
public class Member {
	private String name;
	private int personalNumber;
	private int memberId;
	private ArrayList<Boat> boatsList;
	private memebrIdGenerator idGenrator;
	
	public Member(String name, int personalNumber){
		this.name = name;
		this.personalNumber = personalNumber;
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
	public int getPersonalNumber() {
		return personalNumber;
	}
	public void setPersonalNumber(int personalNumber) {
		this.personalNumber = personalNumber;
	}
	public ArrayList<Boat> getBoatsList() {
		return boatsList;
	}
	public void setBoatsList(ArrayList<Boat> boatsList) {
		this.boatsList = boatsList;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public void addBoat(Boat newBoat){
		boatsList.add(newBoat);
	}
	public void deletBoat(Boat boatToDelete){
		boatsList.remove(boatToDelete);
	}
	@Override
	public boolean equals(Object memberIn){
		Member temp=(Member) memberIn;
		return this.name.equals(temp.name) && this.personalNumber==temp.personalNumber;
	}
}
