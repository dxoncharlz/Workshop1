/**
 * 
 */
package Interface;

/**
 * @author abelt
 *
 */
public class Boat {
	private String type;
	private double length;
	private String name;
	private long ownerMemberId;
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
	public void setType(String type) throws Exception {
		if(type.isEmpty()){
			System.err.println("Sys_Msg/Boat-  ERROR- type can not be blank!");
			throw new Exception();
		}
		else{
			this.type = type;
		}
	}
	public double getLength() {
		return length;
	}
	public void setLength(Double length2) throws Exception {
		if(length2<=0){
			System.err.println("Sys_Msg/Boat-  ERROR- Boat length must be atleast more than 1!");
			throw new Exception();
		}
		else{
			this.length = length2;
		}
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) throws Exception {
		if(name.isEmpty()){
			System.err.println("Sys_Msg/Boat-  ERROR- Boat name can not be blank!");
			throw new Exception();
		}
		else{
			this.name= name;
		}
	}
	public long getOwnerMemberId() {
		return ownerMemberId;
	}
	public void setOwnerMemberId(long ownerId) {
		
			this.ownerMemberId = ownerId;
		
	}
	public boolean equals(Object in){
		if(in  instanceof  Boat ){
			Boat temp= (Boat)in;
			if(temp.getName().equals(this.name) && temp.type.equals(this.type) && temp.getLength()==this.length && temp.getOwnerMemberId()== this.ownerMemberId)
				return true;
		}
		return false;
	}
	

}
