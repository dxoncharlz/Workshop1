/**
 * 
 */
package Model;

/**
 * @author abelt
 *
 */
public class Boat {
	private String type;
	private double length;
	private String name;
	private int ownerMemberId;
	public Boat(){
	}
	public Boat(String name,String type, double length){
		this.name = name;
		this.type = type;
		this.length = length;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOwnerMemberId() {
		return ownerMemberId;
	}
	public void setOwnerMemberId(int ownerMemberId) {
		this.ownerMemberId = ownerMemberId;
	}
	

}
