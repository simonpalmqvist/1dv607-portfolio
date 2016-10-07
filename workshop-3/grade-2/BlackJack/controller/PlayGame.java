package BlackJack.controller;

import BlackJack.model.INewCardObserver;
import BlackJack.view.IView;
import BlackJack.model.Game;

public class PlayGame implements INewCardObserver {

  private Game m_game;
  private IView m_view;

  public PlayGame(Game a_game, IView a_view) {
    m_game = a_game;
    m_view = a_view;
    a_game.addSubscriber(this);
  }

  public boolean Play() {

    m_view.DisplayWelcomeMessage();

    IView.UserAction input = m_view.GetInput();

    if (input == IView.UserAction.Play)
    {
      m_game.NewGame();
    }
    else if (input == IView.UserAction.Hit)
    {
      m_game.Hit();
    }
    else if (input == IView.UserAction.Stand)
    {
      m_game.Stand();
    }

    return input != IView.UserAction.Quit;
  }

  public void NewCard() {
    try {
      presentCards();
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void presentCards() {
    m_view.DisplayNewView();
    m_view.DisplayDealerHand(m_game.GetDealerHand(), m_game.GetDealerScore());
    m_view.DisplayPlayerHand(m_game.GetPlayerHand(), m_game.GetPlayerScore());

    if (m_game.IsGameOver())
    {
      m_view.DisplayGameOver(m_game.IsDealerWinner());
    }
  }
}