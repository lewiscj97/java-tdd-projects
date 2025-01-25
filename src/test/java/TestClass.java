import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

  VideoStore videoStore = new VideoStore();

  @Test
  public void generateStatementForUser_OneRegularMovie_OneDay() {
    String name = "Tester McGee";
    User user = new User(name);
    RegularMovie crazyNotes = new RegularMovie("Crazynotes");
    Rental rental = new Rental(user, crazyNotes);

    Statement statement = videoStore.getStatement(rental);

    String expectedStatement = """
        Rental Record for Tester McGee
          Crazynotes £2.00
        You owe £2.00
        You earned 3 frequent renter points
        """;

    assertEquals(statement.getTotalAmount(), "£7.50");
    assertEquals(statemnt.getRenterPoints(), 3);
    assertEquals(statement.toString(), expectedStatement);
  }
}
