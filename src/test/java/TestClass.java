import model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import service.VideoStore;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

  VideoStore videoStore = new VideoStore();

  String name = "Tester McGee";
  User user = new User(name);

  @ParameterizedTest
  @ValueSource(ints = {1, 2})
  public void generateStatementForUser_OneRegularMovie_2Pound_FirstTwoDays(int numberOfDays) {
    Movie crazyNotes = new Movie("Crazynotes", BookType.REGULAR);
    Rental rental = new Rental(crazyNotes, numberOfDays);

    Statement statement = videoStore.generateStatement(user, rental);
    assertEquals(1, statement.getRentalPoints());
    assertEquals(2.0, statement.getTotalCost());
    assertEquals(name, statement.getUser().getName());
  }

  @Test
  public void generateStatementForUser_OneRegularMovie_ExtraOneFiftySubsequentDays() {
    Movie crazyNotes = new Movie("Crazynotes", BookType.REGULAR);
    Rental rental = new Rental(crazyNotes, 3);

    Statement statement = videoStore.generateStatement(user, rental);
    assertEquals(1, statement.getRentalPoints());
    assertEquals(3.5, statement.getTotalCost());
    assertEquals(name, statement.getUser().getName());
  }

  @Test
  public void generateStatementForUser_OneNewReleaseMovie_OneDay() {
    Movie newMovie = new Movie("New movie", BookType.NEW);
    Rental rental = new Rental(newMovie, 1);

    Statement statement = videoStore.generateStatement(user, rental);
    assertEquals(1, statement.getRentalPoints());
    assertEquals(3.0, statement.getTotalCost());
    assertEquals(name, statement.getUser().getName());
  }

  @Test
  public void generateStatementForUser_OneNewReleaseMovie_TwoDays() {
    Movie newMovie = new Movie("New movie", BookType.NEW);
    Rental rental = new Rental(newMovie, 2);

    Statement statement = videoStore.generateStatement(user, rental);
    assertEquals(2, statement.getRentalPoints());
    assertEquals(6.0, statement.getTotalCost());
    assertEquals(name, statement.getUser().getName());
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  public void generateStatementForUser_OneChildrensMovie_OneToThreeDays(int numberOfDays) {
    Movie childrensMovie = new Movie("Children's movie", BookType.CHILDRENS);
    Rental rental = new Rental(childrensMovie, numberOfDays);

    Statement statement = videoStore.generateStatement(user, rental);
    assertEquals(1, statement.getRentalPoints());
    assertEquals(1.5, statement.getTotalCost());
    assertEquals(name, statement.getUser().getName());
  }

  @Test
  public void generateStatementForUser_OneChildrensMovie_MoreThanThreeDays() {
    Movie childrensMovie = new Movie("Children's movie", BookType.CHILDRENS);
    Rental rental = new Rental(childrensMovie, 4);

    Statement statement = videoStore.generateStatement(user, rental);
    assertEquals(1, statement.getRentalPoints());
    assertEquals(3.0, statement.getTotalCost());
    assertEquals(name, statement.getUser().getName());
  }

  @Test
  public void generateStatementForUser_OneEachTypeMovie_OneDay() {
    Movie crazyNotes = new Movie("Crazynotes", BookType.REGULAR);
    Movie newMovie = new Movie("New movie", BookType.NEW);
    Movie childrensMovie = new Movie("Children's movie", BookType.CHILDRENS);
    int numberOfDays = 1;

    Rental regularRental = new Rental(crazyNotes, numberOfDays);
    Rental newRental = new Rental(newMovie, numberOfDays);
    Rental childrensRental = new Rental(childrensMovie, numberOfDays);

    Statement statement = videoStore.generateStatement(user, regularRental, newRental, childrensRental);
    assertEquals(3, statement.getRentalPoints());
    assertEquals(6.5, statement.getTotalCost());
    assertEquals(name, statement.getUser().getName());
  }

  @Test
  public void generateStatementForUser_String() {
    Movie crazyNotes = new Movie("Crazynotes", BookType.REGULAR);
    Movie teeth = new Movie("Teeth", BookType.REGULAR);
    Movie theWeb = new Movie("The Web", BookType.REGULAR);

    Rental regularRental = new Rental(crazyNotes, 1);
    Rental newRental = new Rental(teeth, 2);
    Rental childrensRental = new Rental(theWeb, 3);

    Statement statement = videoStore.generateStatement(user, regularRental, newRental, childrensRental);

    String expectedStatement = """
        Rental Record for Tester McGee
          Crazynotes  £2.0
          Teeth  £2.0
          The Web  £3.5
        You owe £7.5
        You earned 3 frequent renter points
        """;

    assertEquals(expectedStatement, statement.toString());
  }

  @Test
  public void generateStatementForUser_StringDifferentBookTypes() {
    Movie crazyNotes = new Movie("Crazynotes", BookType.REGULAR);
    Movie teeth = new Movie("Teeth", BookType.NEW);
    Movie theWeb = new Movie("The Web", BookType.CHILDRENS);

    Rental regularRental = new Rental(crazyNotes, 1);
    Rental newRental = new Rental(teeth, 4);
    Rental childrensRental = new Rental(theWeb, 2);

    Statement statement = videoStore.generateStatement(user, regularRental, newRental, childrensRental);

    String expectedStatement = """
        Rental Record for Tester McGee
          Crazynotes  £2.0
          Teeth  £12.0
          The Web  £1.5
        You owe £15.5
        You earned 4 frequent renter points
        """;

    assertEquals(expectedStatement, statement.toString());
  }
}
