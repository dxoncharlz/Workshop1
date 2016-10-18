/**
 * 
 */
package View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Interface.Boat;
import Model.DataFetcher;
import Model.DataStorer;
import Model.DataUpdater;

/**
 * @author as224fg
 *
 */
public class MainManu extends GeneralMain{
	
	private CreatNewMember creat;
	protected Lister list;
	private DeleteAMember delet;
	private MemberUpdate update;
	private BoatManager boatManage;
	private SeeSpecificMember seeMember;
	protected  DataStorer dataStorer;
	protected  DataFetcher fetcher;
	protected  DataUpdater dataUpdater;
	protected String path;
	
	public MainManu(String path){
		this.path = path;
		try {
			dataStorer = new DataStorer(this.path);
			fetcher = new DataFetcher(this.path);
			dataUpdater = new DataUpdater(this.path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	
	
	public  void mainListPrintOut() throws Exception{
		System.out.println("\nAll functions are listed below, select the cooreponding number.."
				+"\n 1) Create a new member "
				+"\n 2) List all members (Compact List, Verbose List)  "
				+"\n 3) Delete a member "
				+"\n 4) Change a member’s information"
				+"\n 5) Look at a specific member’s information "
				+"\n 6) Manage boat (Add, delete, update) "
				+ "\n 99) Change file path");
		
			super.command = takeCommand(6);
			if(command == 1){
				creat = new CreatNewMember(this.path);
				creat.creatController();
				
			}
			else if(command == 2){
				list = new Lister(this.path);
				list.list();
			}
			else if(command == 3){
				delet = new DeleteAMember(this.path);
				delet.DeleteAMember();
			}
			else if(command == 4){
				update = new MemberUpdate(this.path);
				update.memberUpdate();
				
			}
			else if(command == 5){
				seeMember = new SeeSpecificMember(this.path);
				seeMember.SeeSpecificMember();
			}
			else if(command == 6){
				boatManage = new BoatManager(this.path);
				boatManage.boatManager();
				
			}
			else if (command == 99){
				super.connectWithDataFile();
			}
			
			
	}

}
