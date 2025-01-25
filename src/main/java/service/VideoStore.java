package service;

import lombok.extern.slf4j.Slf4j;
import model.*;

@Slf4j
public class VideoStore {

  public Statement getStatement(User user, Rental... rentals) {
    Statement statement = new Statement();
    statement.setUser(user);

    double totalCost = 0.0;
    int rentalPoints = 0;

    for (Rental rental : rentals) {
      Class<? extends Movie> movieType = rental.getMovie().getClass();
      int numberOfDays = rental.getNumberOfDays();
      if (movieType.equals(RegularMovie.class)) {
        rentalPoints++;
        if (numberOfDays <= 2) {
          totalCost += 2;
        } else {
          totalCost = 2 + (numberOfDays - 2) * 1.5;
        }
      } else if (movieType.equals(NewReleaseMovie.class)) {
        if (numberOfDays == 1) {
          rentalPoints++;
        }
        totalCost += numberOfDays * 3;
      }
    }

    statement.setTotalCost(totalCost);
    statement.setRentalPoints(rentalPoints);

    return statement;
  }

}
