package model;

import com.google.gson.annotations.SerializedName;

public record ProductPrice(
    @SerializedName("product_uid") String productUid,
    @SerializedName("unit_price") double unitPrice,
    @SerializedName("unit_price_measure") String unitPriceMeasure,
    @SerializedName("unit_price_measure_amount") double unitPriceMeasureAmount
) {
}
