package BlackJack.model.rules;

import BlackJack.model.Player;

class SoftSeventeenHitStrategy extends BasicHitStrategy {
    private final int g_hitLimit = 17;

    public boolean DoHit(Player a_dealer) {
        return a_dealer.HasSoftSeventeen() || a_dealer.CalcScore() < g_hitLimit;
    }
}
