import model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

  Player player1;
  Player player2;
  TennisGame game;

  @BeforeEach
  public void setup() {
    player1 = new Player("player 1");
    player2 = new Player("player 2");
    game = new TennisGame(player1, player2);
  }

  @Test
  public void setupOfTennisGame() {
    assertEquals("player 1", game.getPlayer1().getName());
    assertEquals(0, game.getPlayer1().getScore());
    assertEquals("player 2", game.getPlayer2().getName());
    assertEquals(0, game.getPlayer2().getScore());
  }

  @Test
  public void tennisGameScore() {
    game.score(player1);

    assertEquals(1, player1.getScore());
  }

}
