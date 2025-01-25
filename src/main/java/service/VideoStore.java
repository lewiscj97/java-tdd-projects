package service;

import lombok.extern.slf4j.Slf4j;
import model.RegularMovie;
import model.Rental;
import model.Statement;
import model.User;

@Slf4j
public class VideoStore {

  public Statement getStatement(User user, Rental... rentals) {
    Statement statement = new Statement();
    statement.setUser(user);

    Double totalCost = 0.0;
    Integer rentalPoints = 0;

    for (Rental rental : rentals) {
      if (rental.getMovie().getClass().equals(RegularMovie.class)) {
        rentalPoints++;
        if (rental.getNumberOfDays() == 1) {
          totalCost += 2;
        }
      }
    }

    statement.setTotalCost(totalCost);
    statement.setRentalPoints(rentalPoints);

    return statement;
  }

}
