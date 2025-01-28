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
    if (hasWinner(player1, player2)) {
      return player1.getName() + " wins!";
    } else if (hasWinner(player2, player1)) {
      return player2.getName() + " wins!";
    } else if (player1.getScore() == player2.getScore() && player1.getScore() >= 3) {
      return "Deuce!";
    } else if (hasAdvantage(player1, player2)) {
      return "Advantage " + player1.getName() + "!";
    } else if (hasAdvantage(player2, player1)) {
      return "Advantage " + player2.getName() + "!";
    } else {
      return getTennisScore(player1.getScore()) + "," + getTennisScore(player2.getScore());
    }
  }

  private boolean hasAdvantage(Player advantaged, Player notAdvantaged) {
    return advantaged.getScore() > 3 && advantaged.getScore() == notAdvantaged.getScore() + 1;
  }

  private boolean hasWinner(Player winner, Player loser) {
    return winner.getScore() > 3 && loser.getScore() <= (winner.getScore() - 2);
  }

  public void score(Player player) {
    int currentScore = player.getScore();
    player.setScore(currentScore + 1);
  }

  private int getTennisScore(int score) {
    return switch (score) {
      case 1 -> 15;
      case 2 -> 30;
      case 3 -> 40;
      default -> 0;
    };
  }

}
