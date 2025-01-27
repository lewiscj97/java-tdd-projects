package service;

import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import model.Product;
import model.ProductPrice;
import util.RestUtil;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Getter
@Slf4j
public class ProductPriceService {

  private static final String productUrl = "https://s3.eu-west-1.amazonaws.com/hackajob-assets1.p.hackajob/challenges/sainsbury_products/products_v2.json";
  private static final String productPriceUrl = "https://s3.eu-west-1.amazonaws.com/hackajob-assets1.p.hackajob/challenges/sainsbury_products/products_price_v2.json";

  List<Product> productList;
  List<ProductPrice> productPriceList;

  public ProductPriceService() {
    try {
      this.productList = callApiGetProductList();
      this.productPriceList = callApiGetProductPriceList();
    } catch (Exception e) {
      log.error("Failed to fetch data during initialization", e);
      this.productList = new ArrayList<>();
      this.productPriceList = new ArrayList<>();
    }
  }

  private List<ProductPrice> callApiGetProductPriceList() throws Exception {
    Type listType = new TypeToken<ArrayList<ProductPrice>>(){}.getType();
    return RestUtil.getResponseFromApi(productPriceUrl, listType);
  }

  private List<Product> callApiGetProductList() throws Exception {
    Type listType = new TypeToken<ArrayList<Product>>(){}.getType();
    return RestUtil.getResponseFromApi(productUrl, listType);
  }

}
