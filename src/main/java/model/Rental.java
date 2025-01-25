package model;

import lombok.*;

@RequiredArgsConstructor
@Getter
public class Rental {

  @NonNull private Movie movie;
  @NonNull private int numberOfDays;
  @Setter
  private double cost;
}
