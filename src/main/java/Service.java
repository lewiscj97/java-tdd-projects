import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Service {

  public String helloWorld() {
    log.debug("Calling helloWorld()...");
    
    return "Hello, World!";
  }

}
