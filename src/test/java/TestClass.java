import model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

  @Test
  public void setupOfTennisGame() {
    Player player1 = new Player("player 1");
    Player player2 = new Player("player 2");

    TennisGame game = new TennisGame(player1, player2);

    assertEquals("player 1", game.getPlayer1().getName());
    assertEquals(0, game.getPlayer1().getScore());
    assertEquals("player 2", game.getPlayer2().getName());
    assertEquals(0, game.getPlayer2().getScore());
  }

}
