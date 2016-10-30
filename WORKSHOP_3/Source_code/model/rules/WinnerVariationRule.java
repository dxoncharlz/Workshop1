/**
 * 
 */
package model.rules;

/**
 * @author as224fg
 *
 */
public class WinnerVariationRule {
	private boolean dealer_is_winner;
	
	public boolean dealerWinner(){
		dealer_is_winner = true;
		return dealer_is_winner;
	}
	public boolean playerWinner(){
		dealer_is_winner = false;
		return dealer_is_winner;
	}
}
