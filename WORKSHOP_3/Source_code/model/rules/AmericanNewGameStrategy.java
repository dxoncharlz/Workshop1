package model.rules;

import model.Card;
import model.Dealer;
import model.Deck;
import model.Player;  

class AmericanNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
  
    a_player.DealCard(a_deck.GetShowableCard());

    
    a_dealer.DealCard(a_deck.GetShowableCard());

   
    a_player.DealCard(a_deck.GetShowableCard());

  
    a_dealer.DealCard(a_deck.GetCard());

    return true;
  }
}