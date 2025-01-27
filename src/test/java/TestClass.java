import model.Product;
import model.ProductType;
import org.junit.jupiter.api.Test;
import service.ApiService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

  ApiService apiService = new ApiService();

  @Test
  public void getProductsList() throws Exception{
    List<Product> productList = apiService.callApi();

    assertEquals(10, productList.size());
    assertEquals("Sainsbury's Skin on ASC Scottish Salmon Fillets x2 240g", productList.getFirst().name());
    assertEquals("6447344", productList.getFirst().productUid());
    assertEquals(ProductType.BASIC, productList.getFirst().productType());
    assertEquals("https://www.sainsburys.co.uk/gol-ui/product/sainsburys-responsibly-sourced-scottish-salmon-fillet-x2-240g", productList.getFirst().fullUrl());
  }

}
