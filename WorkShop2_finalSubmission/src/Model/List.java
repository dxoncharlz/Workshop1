/**
 * 
 */
package Model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import Interface.Boat;
import Interface.Member;

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
			output += counter +" \t " +memberList.get(i).getName()+" \t\t "+memberList.get(i).getBoatsList().size() +" \t\t\t "+memberList.get(i).getMemberId()+"\n";
			counter++;
		}
		return output;
	}
	public String VerboseList() throws FileNotFoundException{
		memberList= dataFetcher.fetchAllMembers();
		output="No \t Member name \t Personal Number \t Member Id \n";
		
		counter=1;
		for (int i= 0; i<memberList.size();i++){
			output+="__ \t _____ ____ \t ______ __ _____ \t ______ __\n\n";
			output += "\n"+ counter +", \t " +memberList.get(i).getName()+" \t\t "+ memberList.get(i).getPersonalNumber()+" \t\t "+memberList.get(i).getMemberId()+"\n";
			
			
			
	
			output += "\n\t Boats("+memberList.get(i).getName()+"'s)\n\t_____ _______\n\n";
			int boatCounter=1;
			ArrayList<Boat> list=memberList.get(i).getBoatsList();
			for(int k=0; k<list.size();k++){
				output+="\n\t"+counter+"."+boatCounter+"-->"+"): Boat name: "+list.get(k).getName()+"\n\t     -->"+"Boat type: "+list.get(k).getType()+"\n\t     -->"+"Boat length: "+list.get(k).getLength()+"\n";
				boatCounter++;
			}
			output+="\n";
			counter++;
		}
		return output;
	}
	
}
