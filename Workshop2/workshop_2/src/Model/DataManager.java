/**
 * 
 */
package Model;

import java.io.File;

/**
 * @author as224fg
 *
 */
public class DataManager {
	protected File file;
	protected String path;
	protected String[] fileList;
	protected File memberData;
	protected File boatData;
	private String connectionStatus="";

	public DataManager(String path) throws Exception{
		
		if(new File(path).isDirectory() && new File(path).exists() ){
			file = new File(path+"\\file");
			file.mkdir();
			this.path = file.getPath();
		}
		else{
			if(!new File(path).exists()){
				System.err.println("Sys.msg/DataManager:  ERROR - The file provided deas not exist!");
				throw new Exception();
			}
			else if(!new File(path).isDirectory()){
				System.err.println("Sys.msg/DataManager:  ERROR - The file provided is not a directory!");
				throw new Exception();
			}
		}
	
		
			
		memberData=new File(this.path+"\\MEMBERS.txt");
		memberData.setWritable(true);
		if(!memberData.exists()){
			connectionStatus="\n"+"Sys.msg_/DataManager: INFO - Member datafile not found, Creating new member datafile..." +
								"\nSys.msg_/DataManager: Succesfull - System is sessufully connected with Member datafile";
			memberData.createNewFile();
			}
		else{
			connectionStatus+="\n"+"Sys.msg_/DataManager: Succesfull - System is sessufully connected with Member datafile";
		}
		
		
		
		
		boatData=new File(this.path+"\\BOATS.txt");
		boatData.setWritable(true);
		if(!boatData.exists()){
			connectionStatus+="\n"+"Sys.msg_/DataManager: INFO - BOATS datafile not found, Creating new boats datafile..."+
								"\nSys.msg_/DataManager: Succesfull - System is sessufully connected with Boat datafile.";
			boatData.createNewFile();
			}
		else{
			connectionStatus+="\n"+"Sys.msg_/DataManager: Succesfull - System is sessufully connected with Boat datafile.";
		}
		
		
		
	}

	public String getConnectionStatus() {
		return connectionStatus;
	}

		
}
