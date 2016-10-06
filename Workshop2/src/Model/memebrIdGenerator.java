/**
 * 
 */
package Model;

/**
 * @author abelt
 *
 */
public class memebrIdGenerator {
	private static int id;
	
	public int getUniqueId(){
		id = (int)System.nanoTime();
		if(id<0)
			id*=-1;
		return id;
	}
}
