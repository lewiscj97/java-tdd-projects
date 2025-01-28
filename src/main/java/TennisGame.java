import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import model.Player;

@Slf4j
@Getter
@AllArgsConstructor
public class TennisGame {

  Player player1;
  Player player2;

  public String getScore() {
    if (player1.getScore() > 3 && player2.getScore() < player1.getScore() - 2) {
      return player1.getName() + " wins!";
    } else if (player2.getScore() > 3 && player1.getScore() < player2.getScore() - 2) {
      return player2.getName() + " wins!";
    } else {
      return getTennisScore(player1.getScore()) + "," + getTennisScore(player2.getScore());
    }
  }

  public void score(Player player) {
    int currentScore = player.getScore();
    player.setScore(currentScore + 1);
  }

  private int getTennisScore(int score) {
    return switch (score) {
      case 1 -> 15;
      case 2 -> 30;
      default -> 0;
    };
  }

}
