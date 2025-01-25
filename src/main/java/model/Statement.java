package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Statement {

  private User user;
  private double totalCost;
  private int rentalPoints;
  private List<Rental> rentals = new ArrayList<>();

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Rental Record for ")
        .append(user.getName())
        .append("\n");

    for (Rental rental : rentals) {
      Movie movie = rental.getMovie();
      stringBuilder.append("  ")
          .append(movie.getName())
          .append("  £")
          .append(rental.getCost())
          .append("\n");
    }

    stringBuilder.append("You owe £")
        .append(totalCost)
        .append("\n")
        .append("You earned ")
        .append(rentalPoints)
        .append(" frequent renter points")
        .append("\n");


    return stringBuilder.toString();
  }
}
