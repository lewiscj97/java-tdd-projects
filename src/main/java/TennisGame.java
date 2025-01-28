import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import model.Player;

@Slf4j
@Getter
@AllArgsConstructor
public class TennisGame {

  private final int DEUCE_THRESHOLD = 3;
  private final int WINNING_DIFFERENCE = 2;
  private final int ADVANTAGE_DIFFERENCE = 1;

  Player player1;
  Player player2;

  public String getScore() {
    if (hasWinner(player1, player2)) {
      return formatWinningMessage(player1);
    } else if (hasWinner(player2, player1)) {
      return formatWinningMessage(player2);
    } else if (hasDeuce()) {
      return "Deuce!";
    } else if (hasAdvantage(player1, player2)) {
      return formatAdvantageMessage(player1);
    } else if (hasAdvantage(player2, player1)) {
      return formatAdvantageMessage(player2);
    } else {
      return getTennisScore(player1.getScore()) + "," + getTennisScore(player2.getScore());
    }
  }

  private String formatAdvantageMessage(Player advantaged) {
    return "Advantage " + advantaged.getName() + "!";
  }

  private String formatWinningMessage(Player player) {
    return player.getName() + " wins!";
  }

  private boolean hasAdvantage(Player advantaged, Player notAdvantaged) {
    return advantaged.getScore() > DEUCE_THRESHOLD && advantaged.getScore() == notAdvantaged.getScore() + ADVANTAGE_DIFFERENCE;
  }

  private boolean hasWinner(Player winner, Player loser) {
    return winner.getScore() > DEUCE_THRESHOLD && loser.getScore() <= (winner.getScore() - WINNING_DIFFERENCE);
  }

  private boolean hasDeuce() {
    return player1.getScore() == player2.getScore() && player1.getScore() >= DEUCE_THRESHOLD;
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
