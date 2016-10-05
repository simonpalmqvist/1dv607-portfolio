package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

class AmericanNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Dealer a_dealer, Player a_player) {
    a_dealer.GetNewCardAndDealTo(a_player);
    a_dealer.GetNewCardAndDealTo(a_dealer);
    a_dealer.GetNewCardAndDealTo(a_player);
    a_dealer.GetNewCardAndDealTo(a_dealer, false);

    return true;
  }
}