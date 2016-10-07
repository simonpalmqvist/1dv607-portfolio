package BlackJack.model.rules;

public interface IWinStrategy {
    boolean IsDealerWinner(BlackJack.model.Player a_dealer, BlackJack.model.Player a_player);
}
