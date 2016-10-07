package BlackJack.model.rules;

class AdvantagePlayerWinStrategy implements IWinStrategy {

    public boolean IsDealerWinner(BlackJack.model.Player a_dealer, BlackJack.model.Player a_player) {
        int maxScore = a_dealer.getMaxScore();

        if (a_player.CalcScore() > maxScore) {
            return true;
        } else if (a_dealer.CalcScore() > maxScore) {
            return false;
        }
        return a_dealer.CalcScore() > a_player.CalcScore();
    }
}
