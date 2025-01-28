package model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Player {

  private final String name;
  @Setter private int score;

  public Player(String name) {
    this.name = name;
    this.score = 0;
  }

}
