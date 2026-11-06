package com.android.billingclient.api;

import android.text.TextUtils;
import com.anythink.core.d.b.e;
import com.taptap.sdk.compilance.constants.BundleKey;
import com.taptap.sdk.core.internal.event.iap.lib2plus.BillingClientConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.3.0 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class SkuDetails {
    private final String zza;
    private final JSONObject zzb;

    public SkuDetails(String str) throws JSONException {
        this.zza = str;
        JSONObject jSONObject = new JSONObject(str);
        this.zzb = jSONObject;
        if (TextUtils.isEmpty(jSONObject.optString(BillingClientConstants.PRODUCT_ID))) {
            throw new IllegalArgumentException("SKU cannot be empty.");
        }
        if (TextUtils.isEmpty(jSONObject.optString("type"))) {
            throw new IllegalArgumentException("SkuType cannot be empty.");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SkuDetails) {
            return TextUtils.equals(this.zza, ((SkuDetails) obj).zza);
        }
        return false;
    }

    public String getDescription() {
        return this.zzb.optString(BundleKey.DESCRIPTION);
    }

    public String getFreeTrialPeriod() {
        return this.zzb.optString("freeTrialPeriod");
    }

    public String getIconUrl() {
        return this.zzb.optString("iconUrl");
    }

    public String getIntroductoryPrice() {
        return this.zzb.optString("introductoryPrice");
    }

    public long getIntroductoryPriceAmountMicros() {
        return this.zzb.optLong("introductoryPriceAmountMicros");
    }

    public int getIntroductoryPriceCycles() {
        return this.zzb.optInt("introductoryPriceCycles");
    }

    public String getIntroductoryPricePeriod() {
        return this.zzb.optString("introductoryPricePeriod");
    }

    public String getOriginalJson() {
        return this.zza;
    }

    public String getOriginalPrice() {
        JSONObject jSONObject = this.zzb;
        return jSONObject.has("original_price") ? jSONObject.optString("original_price") : getPrice();
    }

    public long getOriginalPriceAmountMicros() {
        JSONObject jSONObject = this.zzb;
        return jSONObject.has("original_price_micros") ? jSONObject.optLong("original_price_micros") : getPriceAmountMicros();
    }

    public String getPrice() {
        return this.zzb.optString(e.a.h);
    }

    public long getPriceAmountMicros() {
        return this.zzb.optLong("price_amount_micros");
    }

    public String getPriceCurrencyCode() {
        return this.zzb.optString("price_currency_code");
    }

    public String getSku() {
        return this.zzb.optString(BillingClientConstants.PRODUCT_ID);
    }

    public String getSubscriptionPeriod() {
        return this.zzb.optString("subscriptionPeriod");
    }

    public String getTitle() {
        return this.zzb.optString("title");
    }

    public String getType() {
        return this.zzb.optString("type");
    }

    public int hashCode() {
        return this.zza.hashCode();
    }

    public String toString() {
        return "SkuDetails: ".concat(String.valueOf(this.zza));
    }

    public int zza() {
        return this.zzb.optInt("offer_type");
    }

    public String zzb() {
        return this.zzb.optString("offer_id");
    }

    public String zzc() {
        JSONObject jSONObject = this.zzb;
        String strOptString = jSONObject.optString("offerIdToken");
        return strOptString.isEmpty() ? jSONObject.optString("offer_id_token") : strOptString;
    }

    public final String zzd() {
        return this.zzb.optString(BillingClientConstants.PACKAGE_NAME);
    }

    public String zze() {
        return this.zzb.optString("serializedDocid");
    }

    final String zzf() {
        return this.zzb.optString("skuDetailsToken");
    }
}
