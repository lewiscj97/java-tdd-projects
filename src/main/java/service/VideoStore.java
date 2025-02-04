package service;

import lombok.extern.slf4j.Slf4j;
import model.*;

@Slf4j
public class VideoStore {

  // Would possibly make more sense for this to be static - future refactor?
  public Statement generateStatement(User user, Rental... rentals) {
    double totalCost = 0.0;
    int rentalPoints = 0;

    Statement statement = new Statement();
    statement.setUser(user);

    for (Rental rental : rentals) {
      int numberOfDays = rental.getNumberOfDays();
      BookType bookType = rental.getMovie().getType();

      ProcessMoviePointsCost moviePointsCost = processMoviePointsCost(numberOfDays, bookType);
      double cost = moviePointsCost.getCost();

      rental.setCost(cost);

      totalCost += cost;
      rentalPoints += moviePointsCost.getPoints();

      statement.getRentals().add(rental);
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

  // TODO: extract these hardcoded values into env vars, make more configurable

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
