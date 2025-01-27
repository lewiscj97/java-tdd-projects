package service;

import model.Product;
import model.ProductPrice;
import model.ProductType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductPriceServiceTest {

  ProductPriceService productPriceService = new ProductPriceService();

  @Test
  public void getProductsList() throws Exception {
    List<Product> productList = productPriceService.getProductList();

    assertEquals(10, productList.size());
    assertEquals("Sainsbury's Skin on ASC Scottish Salmon Fillets x2 240g", productList.getFirst().name());
    assertEquals("6447344", productList.getFirst().productUid());
    assertEquals(ProductType.BASIC, productList.getFirst().productType());
    assertEquals("https://www.sainsburys.co.uk/gol-ui/product/sainsburys-responsibly-sourced-scottish-salmon-fillet-x2-240g", productList.getFirst().fullUrl());
  }

  @Test
  public void getProductPriceList() throws Exception {
    List<ProductPrice> productPriceList = productPriceService.getProductPriceList();

    assertEquals(10, productPriceList.size());
    assertEquals("6447344", productPriceList.getFirst().productUid());
    assertEquals(15.63, productPriceList.getFirst().unitPrice());
    assertEquals("kg", productPriceList.getFirst().unitPriceMeasure());
    assertEquals(1, productPriceList.getFirst().unitPriceMeasureAmount());
  }

  @Test
  public void getUnifiedProductList() throws Exception {
    List<UnifiedProduct> unifiedProducts = productPriceService.getUnifiedProductList();

    assertEquals(10, unifiedProducts.size());
    assertEquals("6447344", unifiedProducts.getFirst().productUid());
    assertEquals("Sainsbury's Skin on ASC Scottish Salmon Fillets x2 240g", unifiedProducts.getFirst().name());
    assertEquals(ProductType.BASIC, unifiedProducts.getFirst().productType());
    assertEquals("https://www.sainsburys.co.uk/gol-ui/product/sainsburys-responsibly-sourced-scottish-salmon-fillet-x2-240g", unifiedProducts.getFirst().fullUrl());
    assertEquals(15.63, unifiedProducts.getFirst().unitPrice());
    assertEquals("kg", unifiedProducts.getFirst().unitPriceMeasure());
    assertEquals(1, unifiedProducts.getFirst().unitPriceMeasureAmount());
  }

}
