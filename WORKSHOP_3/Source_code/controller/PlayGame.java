package controller;

import model.Game;
import model.rules.WinnerVariationRule;
import view.IView;

public class PlayGame {

  public boolean Play(Game a_game, IView a_view) {
    a_view.DisplayWelcomeMessage();
    
    a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
    a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());

    if (a_game.IsGameOver())
    {
    	if(a_game.GetPlayerScore() > 21){
    		a_view.DisplayGameOver(true);
    	}
    	else if(a_game.GetDealerScore() == a_game.GetPlayerScore()){
    		a_view.DisplayGameOver(new WinnerVariationRule().playerWinner());
    	}
    	else if (a_game.GetDealerScore() < a_game.GetPlayerScore() ){
    		a_view.DisplayGameOver(false);
    	}
    	else if (a_game.GetDealerScore() > a_game.GetPlayerScore()){
    		a_view.DisplayGameOver(true);
    	}
    }

    int input = a_view.GetInput();
    
    if (input == 'p')
    {
        a_game.NewGame();
    }
    else if (input == 'h')
    {
        a_game.Hit();
    }
    else if (input == 's')
    {
        a_game.Stand();
    }

    return input != 'q';
  }
}