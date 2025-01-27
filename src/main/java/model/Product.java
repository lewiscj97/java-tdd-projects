package model;

import com.google.gson.annotations.SerializedName;

public record Product(
    @SerializedName("product_uid") String productUid,
    @SerializedName("product_type") ProductType productType,
    String name,
    @SerializedName("full_url") String fullUrl) {
}
