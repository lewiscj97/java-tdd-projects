package util;

import com.google.gson.Gson;

import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URL;

public class RestUtil {

  private static final Gson gson = new Gson();

  public static  <T> T getResponseFromApi(String inputUrl, Type type) throws Exception{
    URL url = new URI(inputUrl).toURL();
    InputStreamReader reader = new InputStreamReader(url.openStream());
    return gson.fromJson(reader, type);
  }
}
