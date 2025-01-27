package service;

import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import model.Product;
import model.ProductPrice;
import model.UnifiedProduct;
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

  public List<UnifiedProduct> getUnifiedProductList() {
    List<UnifiedProduct> unifiedProducts = new ArrayList<>();
    for (Product product : this.productList) {
      ProductPrice productPrice = this.productPriceList
          .stream()
          .filter(price -> price.productUid().equals(product.productUid()))
          .findFirst()
          .get();

      UnifiedProduct unifiedProduct = new UnifiedProduct(
          product.productUid(),
          product.name(),
          product.productType(),
          product.fullUrl(),
          productPrice.unitPrice(),
          productPrice.unitPriceMeasure(),
          productPrice.unitPriceMeasureAmount()
      );
      unifiedProducts.add(unifiedProduct);
    }

    return unifiedProducts;
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
