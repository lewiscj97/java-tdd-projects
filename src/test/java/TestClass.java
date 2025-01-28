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
  public void tennisGameScoreAddsPointToPlayerScore() {
    game.score(player1);

    assertEquals(1, player1.getScore());
    assertEquals(0, player2.getScore());
  }

  @Test
  public void getScoreReturnsScoreInCorrectFormat_NilNil() {
    String score = game.getScore();

    assertEquals("0,0", score);
  }

  @Test
  public void getScoreReturnsScoreInCorrectFormat_15Nill() {
    game.score(player1);
    String score = game.getScore();

    assertEquals("15,0", score);
  }

  @Test
  public void getScoreReturnsScoreInCorrectFormat_Player1Wins() {
    game.score(player1);
    game.score(player1);
    game.score(player1);
    game.score(player1);
    String score = game.getScore();

    assertEquals("player 1 wins!", score);
  }

  @Test
  public void getScoreReturnsScoreInCorrectFormat_Player2Wins() {
    game.score(player2);
    game.score(player2);
    game.score(player2);
    game.score(player2);
    String score = game.getScore();

    assertEquals("player 2 wins!", score);
  }

  @Test
  public void getScoreReturnsScoreInCorrectFormat_ThirtyFifteen() {
    game.score(player1);
    game.score(player1);
    game.score(player2);
    String score = game.getScore();

    assertEquals("30,15", score);
  }

  @Test
  public void getScoreReturnsScoreInCorrectFormat_FourtyFifteen() {
    game.score(player1);
    game.score(player1);
    game.score(player1);
    game.score(player2);
    String score = game.getScore();

    assertEquals("40,15", score);
  }

  @Test
  public void getDeuce() {
    game.score(player1);
    game.score(player1);
    game.score(player1);
    game.score(player2);
    game.score(player2);
    game.score(player2);
    String score = game.getScore();

    assertEquals("Deuce!", score);
  }

  @Test
  public void getDeuce_advantagePlayer1() {
    game.score(player1);
    game.score(player1);
    game.score(player1);
    game.score(player2);
    game.score(player2);
    game.score(player2);
    game.score(player1);
    String score = game.getScore();

    assertEquals("Advantage player 1!", score);
  }

  @Test
  public void getDeuce_advantagePlayer2() {
    game.score(player1);
    game.score(player1);
    game.score(player1);
    game.score(player2);
    game.score(player2);
    game.score(player2);
    game.score(player2);
    String score = game.getScore();

    assertEquals("Advantage player 2!", score);
  }

  @Test
  public void getDeuce_advantageReturnsToDeuce() {
    game.score(player1);
    game.score(player1);
    game.score(player1);
    game.score(player2);
    game.score(player2);
    game.score(player2);
    game.score(player2);
    game.score(player1);
    String score = game.getScore();

    assertEquals("Deuce!", score);
  }

  @Test
  public void getDeuce_player1WinsAfterDeuce() {
    game.score(player1);
    game.score(player1);
    game.score(player1);
    game.score(player2);
    game.score(player2);
    game.score(player2);
    game.score(player1);
    game.score(player1);
    String score = game.getScore();

    assertEquals("player 1 wins!", score);
  }

  @Test
  public void getDeuce_player2WinsAfterDeuce() {
    game.score(player1);
    game.score(player1);
    game.score(player1);
    game.score(player2);
    game.score(player2);
    game.score(player2);
    game.score(player2);
    game.score(player2);
    String score = game.getScore();

    assertEquals("player 2 wins!", score);
  }

  @Test
  public void getDeuce_player2WinsAfterDeuceReturnsToDeuce() {
    game.score(player1);
    game.score(player1);
    game.score(player1);
    game.score(player2);
    game.score(player2);
    game.score(player2); // deuce
    game.score(player2); // advantage player 1
    game.score(player1); // deuce
    game.score(player2); // advantage player 2
    game.score(player2); // deuce
    String score = game.getScore();

    assertEquals("player 2 wins!", score);
  }
}
