package ch08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
  Map<String, Product> products = new HashMap<>();

  public ProductService() {
    Product p = new Product();
    products.put("101", p);

    p = new Product();
    products.put("102", p);

    p = new Product();
    products.put("103", p);
  }

  // 전체 상품정보를 가져와서 list에 반환해주는 메서드
  public List<Product> findAll() {
    return new ArrayList<>(products.values());
  }

  // 특정 상품정보를 가져와서  반환해주는 메서드
  public Product find(String id) {
    return products.get(id);
  }

}
