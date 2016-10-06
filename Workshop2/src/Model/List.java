/**
 * 
 */
package Model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * @author abelt
 *
 */

public class List {
	private String path;
	private DataFetcher dataFetcher;
	private String output;
	private ArrayList<Member> memberList;
	private ArrayList<Boat> boatList;
	private int counter;
	
	public List(String path) throws Exception{
		this.path =path;
		dataFetcher= new DataFetcher(path);
	}
	public String compactList() throws FileNotFoundException{
		memberList= dataFetcher.fetchAllMembers();
		output="No \t Member name \t Number of Boats \t Member Id\n";
		output+="__ \t ______ ____ \t ______ __ _____ \t ______ __\n\n";
		counter=1;
		for (int i= 0; i<memberList.size();i++){
			output += counter +" \t " +memberList.get(i).getName()+" \t\t "+ memberList.get(i).getBoatsList().size()+" \t\t\t "+memberList.get(i).getMemberId()+"\n";
			counter++;
		}
		return output;
	}
	public String VerboseList() throws FileNotFoundException{
		memberList= dataFetcher.fetchAllMembers();
		boatList = dataFetcher.fetchAllBoats();
		output="No \t Member name \t Personal Number \t Member Id \t Boats\n";
		
		counter=1;
		for (int i= 0; i<memberList.size();i++){
			output+="__ \t _____ ____ \t ______ __ _____ \t ______ __\t_____ _______\n\n";
			output += "\n"+ counter +", \t " +memberList.get(i).getName()+" \t\t "+ memberList.get(i).getBoatsList().size()+" \t\t\t "+memberList.get(i).getMemberId();
			
			
			int boatCounter=1;
			String boatData="";
			for(int k=0; k<boatList.size();k++){
				if(memberList.get(i).getMemberId() == boatList.get(k).getOwnerMemberId()){
					output+="\n\t\t\t\t\t\t\t\t"+counter+"."+boatCounter+"-->"+"): Boat name: "+boatList.get(k).getName()+"\n\t\t\t\t\t\t\t\t\t-->"+"Boat type: "+boatList.get(k).getType()+"\n\t\t\t\t\t\t\t\t\t-->"+"Boat length: "+boatList.get(k).getLength()+"\n";
				}
				boatCounter++;
			}
			output+="\n";
			counter++;
		}
		return output;
	}
	
}
