package model.rules;

import model.Player;

class BasicHitStrategy implements IHitStrategy {
    private final int g_hitLimit = 17;
    private final int g_player_hitlimit = 21;
    public boolean DoHit(Player a_dealer) {
      return a_dealer.CalcScore() < g_hitLimit;  
    }
}