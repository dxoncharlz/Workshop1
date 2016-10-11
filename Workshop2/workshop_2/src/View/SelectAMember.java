/**
 * 
 */
package View;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import Interface.Member;
import Model.DataFetcher;

/**
 * @author as224fg
 *
 */
public class SelectAMember extends MainManu {
	
	

	public SelectAMember(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	public  Member listAndSelectMember() throws Exception{
		
	
		ArrayList<Member> tempList = null;
		
		System.out.println("Choose the correspoding number to select a member(press 99 to go to home)");
		try {
			tempList = fetcher.fetchAllMembers();
			
		} 
		catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		}
		if(tempList != null  && tempList.size()!=0 ){
			int counter=0;
			int counter2=1;
			for(int i = 0; i<tempList.size(); i++){
				System.out.print(counter2+", "+tempList.get(i).getName()+"\n");
				counter++;
				counter2++;
				if(counter == 4){
					System.out.println();
					counter=0;
				}
			}
			command = takeCommand(tempList.size());
		}
		else{
			System.err.println("Ooops! There was a problem, see system msg and try again!");
			super.mainListPrintOut();
		}
		if(command==99){
			super.mainListPrintOut();
		}
		else{
			System.out.println("\n"+tempList.get(command-1).getName()+ " is selected");
		}
		
		return tempList.get(command-1); 
		
		
	}
}
