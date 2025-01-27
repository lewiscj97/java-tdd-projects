# Java TDD Projects

This is a collection of Java projects and Katas built following Test-Driven Development (TDD).
Each problem will have its own feature branch (`f-<project-name>`).

## REST calls

## GSON

GSON is an easy way to make calls to an API using REST.

Dependency:

```xml
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.11.0</version>
</dependency>
```

Method:

```java
  public static  <T> T getResponseFromApi(String inputUrl, Type type) throws Exception{
    URL url = new URI(inputUrl).toURL();
    InputStreamReader reader = new InputStreamReader(url.openStream());
    return gson.fromJson(reader, type);
  }
```

- Generics used to return different types
- Pass in a `Type` for the GSON to pass the JSON into
- Create a URL using Java 20+ methods (create URI and convert to URL)
- Create an `InputStreamReader` to open the URL
- Different types returned, compiler checks correctness

## Generics

We can use [generics](https://www.baeldung.com/java-generics#generic-methods) to create a helper function to call an endpoint and retrieve a response.

A single method declaration can be called with arguments of different types, compiler will ensure correctness. Properties of generic methods:

- Generic methods have a type parameter (the diamond operator enclosing the type `<T>`) before the return type of the method declaration.
- Type parameters can be bounded.
- Generic methods can have different type parameters separated by commas in the method signature.
- Method body for a generic method is just like a normal method.

**Generics are used in the above example so we can return either an object or a list of objects, which are created by parsing a JSON response.**

## Implementation

### Method

This util method is called as follows:

```java
private List<Product> callApiGetProductList() throws Exception {
  Type listType = new TypeToken<ArrayList<Product>>(){}.getType();
  return RestUtil.getResponseFromApi(productUrl, listType);
}
```

- `new TypeToken<ArrayList<Product>>(){}.getType()` is used to specify that the JSON response should be parsed into a list of `Product` objects

### `Product` record

```java
public record Product(
    @SerializedName("product_uid") String productUid,
    @SerializedName("product_type") ProductType productType,
    String name,
    @SerializedName("full_url") String fullUrl) {
}
```

- `@SerializedName` is used to tell GSON to parse `{"product_uid":"1234"}` to `productUid`, etc. during `gson.fromJson(reader, type)`

# Records

```java
public record Person(
	String name,
	double age) {
}
```

- Records are useful for passing information around and creating POJOs with accessors/constructors
- A `record` can be used as follows:

```java
Product product = new Product("1234", "BASIC", "Test item", "http://...");
product.productUid() // "1234"
product.productType() // "BASIC"
product.name() // "Test item"
product.fullUrl() // "http://..."
```

- **When parsing into records, ensure `@JsonProperty` or `@SerializedName` annotations used**