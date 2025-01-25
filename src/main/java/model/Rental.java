package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Rental {

  private Movie movie;
  private int numberOfDays;
}
