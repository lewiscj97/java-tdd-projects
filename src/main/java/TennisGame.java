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

  public void score(Player player) {
    double currentScore = player.getScore();
    player.setScore(currentScore + 1);
  }

}
