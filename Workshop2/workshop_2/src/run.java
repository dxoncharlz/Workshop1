

import View.GeneralMain;

/**
 * @author as224fg
 *
 */
public class run {

	/**
	 * @param args
	 */
	private static GeneralMain programStart;
	public static void main(String[] args) {
		programStart = new GeneralMain();
		
		try {
			programStart.connectWithDataFile();
		} catch (Exception e) {
			
			//e.printStackTrace();
		}

	}

}
