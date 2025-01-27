package model;

import com.google.gson.annotations.SerializedName;

public record UnifiedProduct(
    String productUid,
    String name,
    ProductType productType,
    String fullUrl,
    double unitPrice,
    @SerializedName("unit_price_measure") String unitPriceMeasure,
    @SerializedName("unit_price_measure_amount") double unitPriceMeasureAmount
) {
}
