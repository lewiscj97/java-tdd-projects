import model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import service.VideoStore;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

  VideoStore videoStore = new VideoStore();

  String name = "Tester McGee";
  User user = new User(name);

  @ParameterizedTest
  @ValueSource(ints = {1, 2})
  public void generateStatementForUser_OneRegularMovie_2Pound_FirstTwoDays(int numberOfDays) throws Exception {
    Movie crazyNotes = new RegularMovie("Crazynotes");
    Rental rental = new Rental(crazyNotes, numberOfDays);

    Statement statement = videoStore.getStatement(user, rental);
    assertEquals(1, statement.getRentalPoints());
    assertEquals(2.0, statement.getTotalCost());
    assertEquals(name, statement.getUser().getName());
  }

  @Test
  public void generateStatementForUser_OneRegularMovie_ExtraOneFiftySubsequentDays() throws Exception {
    Movie crazyNotes = new RegularMovie("Crazynotes");
    Rental rental = new Rental(crazyNotes, 3);

    Statement statement = videoStore.getStatement(user, rental);
    assertEquals(1, statement.getRentalPoints());
    assertEquals(3.5, statement.getTotalCost());
    assertEquals(name, statement.getUser().getName());
  }

  @Test
  public void generateStatementForUser_OneNewReleaseMovie_OneDay() throws Exception {
    Movie newMovie = new NewReleaseMovie("New movie");
    Rental rental = new Rental(newMovie, 1);

    Statement statement = videoStore.getStatement(user, rental);
    assertEquals(1, statement.getRentalPoints());
    assertEquals(3.0, statement.getTotalCost());
    assertEquals(name, statement.getUser().getName());
  }

  @Test
  public void generateStatementForUser_OneNewReleaseMovie_TwoDays() throws Exception {
    Movie newMovie = new NewReleaseMovie("New movie");
    Rental rental = new Rental(newMovie, 2);

    Statement statement = videoStore.getStatement(user, rental);
    assertEquals(2, statement.getRentalPoints());
    assertEquals(6.0, statement.getTotalCost());
    assertEquals(name, statement.getUser().getName());
  }

  @Test
  public void generateStatementForUser_OneChildrensMovie_OneDay() throws Exception {
    Movie childrensMovie = new ChildrensMovie("Children's movie");
    Rental rental = new Rental(childrensMovie, 1);

    Statement statement = videoStore.getStatement(user, rental);
    assertEquals(1, statement.getRentalPoints());
    assertEquals(1.5, statement.getTotalCost());
    assertEquals(name, statement.getUser().getName());
  }
}
