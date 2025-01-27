package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import model.Product;

import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ProductPriceService {

  private static final String productUrl = "https://s3.eu-west-1.amazonaws.com/hackajob-assets1.p.hackajob/challenges/sainsbury_products/products_v2.json";

  private static final Gson gson = new Gson();

  public List<Product> callApi() throws Exception {
    Type listType = new TypeToken<ArrayList<Product>>(){}.getType();
    URL url = new URI(productUrl).toURL();
    InputStreamReader reader = new InputStreamReader(url.openStream());
    return gson.fromJson(reader, listType);
  }

}
