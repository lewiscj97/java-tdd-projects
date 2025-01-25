package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Statement {

  private User user;
  private Double totalCost;
  private Integer rentalPoints;

}
