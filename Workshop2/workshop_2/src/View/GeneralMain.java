/**
 * 
 */
package View;

import java.util.Scanner;

import Interface.Boat;
import Interface.Member;
import Model.DataFetcher;
import Model.DataManager;
import Model.DataStorer;
import Model.DataUpdater;
import Model.List;

/**
 * @author as224fg
 *
 */
public class GeneralMain {
	protected  DataManager dataManage;
	protected  List list;
	protected  String path="";
	protected  Scanner scan;
	protected  int command;
	protected  Member singleMember;
	protected  Boat singleBoat;
	
	private MainManu selectionMenu; 
	
	public GeneralMain ()  {
		
	

	}
	public  void connectWithDataFile() throws Exception{
		System.out.print("WELCOME TO THE SIMPLE CRUD" +
							"\nSystem is connecting with data file... "+
							"\ncreating new file connection...,please provide folder path\n--> ");
		scan = new Scanner(System.in);
		path = scan.nextLine();
	
		try {
			dataManage = new DataManager(path);
			System.out.println(dataManage.getConnectionStatus());
			this.selectionMenu = new MainManu(path);
			selectionMenu.mainListPrintOut();
		} catch (Exception e) {
			System.out.println("ERROR- There was a problem creating files, see system message and try again..");
			this.connectWithDataFile();;
		}
		
	}
	protected  int takeCommand(int maxRange){
		System.out.print("--> ");
		scan= new Scanner(System.in);
		
			if(scan.hasNextInt()){
				command = scan.nextInt();
				if(command==99){
					return 99;
					}
				else if(command<1 || command >maxRange){
					System.err.println ("ERROR- you can only choose between 1-"+maxRange+",pleas try again...");
					takeCommand(maxRange);
				}
			}
			else{
				System.err.println ("ERROR- you can only choose numbers,please try again...");
				takeCommand(maxRange);
			}
		
		
		return command;
	}

}
