package service;

import lombok.extern.slf4j.Slf4j;
import model.*;

@Slf4j
public class VideoStore {

  public Statement generateStatement(User user, Rental... rentals) {
    Statement statement = new Statement();
    statement.setUser(user);

    double totalCost = 0.0;
    int rentalPoints = 0;

    for (Rental rental : rentals) {
      int numberOfDays = rental.getNumberOfDays();
      BookType bookType = rental.getMovie().getType();

      ProcessMoviePointsCost moviePointsCost = processMoviePointsCost(numberOfDays, bookType);

      totalCost += moviePointsCost.getCost();
      rentalPoints += moviePointsCost.getPoints();
    }

    statement.setTotalCost(totalCost);
    statement.setRentalPoints(rentalPoints);

    return statement;
  }

  private ProcessMoviePointsCost processMoviePointsCost(int numberOfDays, BookType bookType) {
    switch (bookType) {
      case REGULAR -> {
        return processRegularMovie(numberOfDays);
      }
      case NEW -> {
        return processNewMovie(numberOfDays);
      }
      case CHILDRENS -> {
        return processChildrensMovie(numberOfDays);
      }
      default -> throw new RuntimeException();
    }
  }

  private ProcessMoviePointsCost processChildrensMovie(int numberOfDays) {
    int points = 1;
    double cost = (numberOfDays <= 3) ? 1.5 : 1.5 + (numberOfDays - 3) * 1.5;

    return new ProcessMoviePointsCost(points, cost);
  }

  private ProcessMoviePointsCost processRegularMovie(int numberOfDays) {
    int points = 1;
    double cost = (numberOfDays <= 2) ? 2 : 2 + (numberOfDays - 2) * 1.5;

    return new ProcessMoviePointsCost(points, cost);
  }

  private ProcessMoviePointsCost processNewMovie(int numberOfDays) {
    double cost = numberOfDays * 3;
    int points = (numberOfDays == 1) ? 1 : 2;

    return new ProcessMoviePointsCost(points, cost);
  }

}
