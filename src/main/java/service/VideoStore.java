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
      ProcessMoviePointsCost moviePointsCost;

      if (movieType.equals(RegularMovie.class)) {
        moviePointsCost = processRegularMovies(numberOfDays);
      } else if (movieType.equals(NewReleaseMovie.class)) {
        moviePointsCost = processNewMovies(numberOfDays);
      } else {
        moviePointsCost = new ProcessMoviePointsCost();
      }

      totalCost += moviePointsCost.getCost();
      rentalPoints += moviePointsCost.getPoints();
    }

    statement.setTotalCost(totalCost);
    statement.setRentalPoints(rentalPoints);

    return statement;
  }

  private ProcessMoviePointsCost processRegularMovies(int numberOfDays) {
    int points = 1;
    double cost = (numberOfDays <= 2) ? 2 : 2 + (numberOfDays - 2) * 1.5;

    return new ProcessMoviePointsCost(points, cost);
  }

  private ProcessMoviePointsCost processNewMovies(int numberOfDays) {
    double cost = numberOfDays * 3;
    int points = (numberOfDays == 1) ? 1 : 2;

    return new ProcessMoviePointsCost(points, cost);
  }

}
