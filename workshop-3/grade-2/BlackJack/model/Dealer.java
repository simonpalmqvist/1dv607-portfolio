package BlackJack.model;

import BlackJack.model.rules.*;

public class Dealer extends Player {

    private Deck m_deck;
    private INewGameStrategy m_newGameRule;
    private IHitStrategy m_hitRule;
    private IWinStrategy m_winRule;
    private java.util.ArrayList<INewCardObserver> m_subscribers;

    public Dealer(RulesFactory a_rulesFactory) {
        m_newGameRule = a_rulesFactory.GetNewGameRule();
        m_hitRule = a_rulesFactory.GetHitRule();
        m_winRule = a_rulesFactory.GetWinRule();
        m_subscribers = new java.util.ArrayList<>();
    }

    public boolean NewGame(Player a_player) {
        if (m_deck == null || IsGameOver()) {
            m_deck = new Deck();
            ClearHand();
            a_player.ClearHand();
            return m_newGameRule.NewGame(this, a_player);
        }
        return false;
    }

    public boolean Hit(Player a_player) {
        if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
            GetNewCardAndDealTo(a_player);

            return true;
        }
        return false;
    }

    public boolean IsDealerWinner(Player a_player) {
        return m_winRule.IsDealerWinner(this, a_player);
    }

    public boolean IsGameOver() {
        if (m_deck != null && !m_hitRule.DoHit(this)) {
            return true;
        }
        return false;
    }

    public boolean Stand() {
        if (m_deck != null) {
            ShowHand();
            callSubscribers();
            while (m_hitRule.DoHit(this)) {
                GetNewCardAndDealTo(this);
            }
            return true;
        }

        return false;
    }

    public void GetNewCardAndDealTo(Player a_player) {
        GetNewCardAndDealTo(a_player, true);
    }

    public void GetNewCardAndDealTo(Player a_player, boolean show) {
        Card c = m_deck.GetCard();
        c.Show(show);
        a_player.DealCard(c);
        callSubscribers();
    }

    public void addSubscriber(INewCardObserver a_subscriber) {
        m_subscribers.add(a_subscriber);
    }

    private void callSubscribers() {
        for(INewCardObserver subscriber : m_subscribers) {
            subscriber.NewCard();
        }
    }

}