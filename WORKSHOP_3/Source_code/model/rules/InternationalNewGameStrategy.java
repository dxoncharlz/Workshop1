package model.rules;

import model.Card;
import model.Dealer;
import model.Deck;
import model.Player;  

class InternationalNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
    Card c;
  
 
    a_player.DealCard(a_deck.GetShowableCard());
  
 
    a_dealer.DealCard(a_deck.GetShowableCard());
  
  
    a_player.DealCard(a_deck.GetShowableCard());
  
    return true;
  }
}