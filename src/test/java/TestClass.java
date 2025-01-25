import model.*;
import org.junit.jupiter.api.Test;
import service.VideoStore;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

  VideoStore videoStore = new VideoStore();

  @Test
  public void generateStatementForUser_OneRegularMovie_OneDay() {
    String name = "Tester McGee";
    User user = new User(name);
    Movie crazyNotes = new RegularMovie("Crazynotes");
    Integer numberOfDays = 1;
    Rental rental = new Rental(crazyNotes, numberOfDays);

    Statement statement = videoStore.getStatement(user, rental);
    assertEquals(1, statement.getRentalPoints());
    assertEquals(2.0, statement.getTotalCost());
    assertEquals(name, statement.getUser().getName());
  }
}
