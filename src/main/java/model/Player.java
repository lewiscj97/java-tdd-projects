package model;

import lombok.Getter;

@Getter
public class Player {

  private final String name;
  private double score;

  public Player(String name) {
    this.name = name;
    this.score = 0;
  }

}
