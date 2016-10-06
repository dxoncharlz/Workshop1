/**
 * 
 */
package View;

import java.io.FileNotFoundException;

import Model.List;

/**
 * @author as224fg
 *
 */
public class Lister extends MainManu{
	private List list;
	public Lister(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	
	
	public  void list() throws Exception{
		System.out.println("\nChoose list type.."
				+"\n 1) Compact List "
				+"\n 2) Verbose List "
				+"\n 99) back ");
		command = takeCommand(2);
		try {
			list = new List(super.path);
		} catch (Exception e) {
			System.err.print("ERROR - there was a problem creating the list, please try again.. ");
			super.mainListPrintOut();
		}
		
		if(command == 1){
			try {
				System.out.println(list.compactList());
				super.mainListPrintOut();
			} catch (FileNotFoundException e) {
				System.err.println("ERROR- system cant fetch ");
				e.printStackTrace();
			}
		}
		else if( command == 2){
			try {
				System.out.println(list.VerboseList());
				super.mainListPrintOut();
			} catch (FileNotFoundException e) {
				System.err.println("ERROR- system cant fetch ");
				e.printStackTrace();
			}
		}
		else{
			super.mainListPrintOut();
		}
		
	}

}
