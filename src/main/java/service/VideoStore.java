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

    double totalCost = 0.0;
    int rentalPoints = 0;

    for (Rental rental : rentals) {
      if (rental.getMovie().getClass().equals(RegularMovie.class)) {
        rentalPoints++;
        int numberOfDays = rental.getNumberOfDays();
        if (numberOfDays <= 2) {
          totalCost += 2;
        } else {
          totalCost = 2 + (numberOfDays - 2) * 1.5;
        }
      }
    }

    statement.setTotalCost(totalCost);
    statement.setRentalPoints(rentalPoints);

    return statement;
  }

}
