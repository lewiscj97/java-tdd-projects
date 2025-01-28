import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

  Service service = new Service();

  @Test
  public void setupOfTennisGame() {
    Player player1 = new Player("player 1");
    Player player2 = new Player("player 1");

    TennisGame game = new TennisGame(player1, player2);

    assertEquals(game.getPlayer1().getName(), "player 1");
    assertEquals(game.getPlayer1().getScore(), 0);
    assertEquals(game.getPlayer2().getName(), "player 2");
    assertEquals(game.getPlayer2().getScore(), 0);
    assertEquals(game.getServingPlayer(), player1);
  }

}
