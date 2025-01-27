package service;

import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import model.Product;
import model.ProductPrice;
import util.RestUtil;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ProductPriceService {

  private static final String productUrl = "https://s3.eu-west-1.amazonaws.com/hackajob-assets1.p.hackajob/challenges/sainsbury_products/products_v2.json";
  private static final String productPriceUrl = "https://s3.eu-west-1.amazonaws.com/hackajob-assets1.p.hackajob/challenges/sainsbury_products/products_price_v2.json";

  public List<ProductPrice> getProductPriceList() throws Exception {
    Type listType = new TypeToken<ArrayList<ProductPrice>>(){}.getType();
    return RestUtil.getResponseFromApi(productPriceUrl, listType);
  }

  public List<Product> getProductList() throws Exception {
    Type listType = new TypeToken<ArrayList<Product>>(){}.getType();
    return RestUtil.getResponseFromApi(productUrl, listType);
  }

}
