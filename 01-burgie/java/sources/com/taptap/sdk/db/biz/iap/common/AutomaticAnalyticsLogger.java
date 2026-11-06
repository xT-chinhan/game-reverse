package com.taptap.sdk.db.biz.iap.common;

import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.core.TapTapPurchasedEvent;
import com.taptap.sdk.db.biz.iap.lib2plus.BillingClientConstants;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.db.event.LegacyEvents;
import com.taptap.sdk.kit.internal.TapLoggerKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AutomaticAnalyticsLogger.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u001b\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0006*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¨\u0006\u0012"}, d2 = {"Lcom/taptap/sdk/db/biz/iap/common/AutomaticAnalyticsLogger;", "", "()V", "generateTapPurchasedEvent", "Lcom/taptap/sdk/core/TapTapPurchasedEvent;", "purchase", "", "skuDetails", "logPurchase", "", "isSubscription", "", "getLongValue", "", "Lorg/json/JSONObject;", "key", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Long;", "getStringValue", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AutomaticAnalyticsLogger {
    public static final AutomaticAnalyticsLogger INSTANCE = new AutomaticAnalyticsLogger();

    private AutomaticAnalyticsLogger() {
    }

    @JvmStatic
    public static final void logPurchase(String purchase, String skuDetails, boolean isSubscription) {
        TapTapPurchasedEvent it;
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        Intrinsics.checkNotNullParameter(skuDetails, "skuDetails");
        if (!isSubscription && (it = INSTANCE.generateTapPurchasedEvent(purchase, skuDetails)) != null) {
            LegacyEvents.INSTANCE.submitPurchaseEvent(it);
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0061  */
    private final TapTapPurchasedEvent generateTapPurchasedEvent(String purchase, String skuDetails) {
        double priceAmountMicros;
        try {
            try {
                JSONObject purchaseJSON = new JSONObject(purchase);
                try {
                    JSONObject skuDetailsJSON = new JSONObject(skuDetails);
                    String stringValue = getStringValue(purchaseJSON, BillingClientConstants.PRODUCT_ID);
                    String id = stringValue == null ? getStringValue(skuDetailsJSON, BillingClientConstants.PRODUCT_ID) : stringValue;
                    String stringValue2 = getStringValue(skuDetailsJSON, Common.System.NAME);
                    if (stringValue2 == null) {
                        stringValue2 = getStringValue(skuDetailsJSON, BundleKey.TITLE);
                    }
                    String name = stringValue2;
                    Long longValue = getLongValue(skuDetailsJSON, "price_amount_micros");
                    if (longValue != null) {
                        long it = longValue.longValue();
                        if (!(it > 0)) {
                            longValue = null;
                        }
                        if (longValue != null) {
                            long priceAmountMicros2 = longValue.longValue();
                            priceAmountMicros = priceAmountMicros2 / ((double) 10000);
                        } else {
                            priceAmountMicros = 0.0d;
                        }
                    } else {
                        priceAmountMicros = 0.0d;
                    }
                    String currencyCode = getStringValue(skuDetailsJSON, "price_currency_code");
                    String description = getStringValue(skuDetailsJSON, BundleKey.DESCRIPTION);
                    JSONObject properties = null;
                    String str = description;
                    if (!(str == null || str.length() == 0)) {
                        properties = new JSONObject();
                        properties.put(BundleKey.DESCRIPTION, description);
                    }
                    return new TapTapPurchasedEvent(id, name, priceAmountMicros, currencyCode, "google", properties);
                } catch (JSONException e) {
                    e = e;
                    TapLoggerKt.logError("Error parsing in-app subscription data.", e);
                    return null;
                }
            } catch (JSONException e2) {
                e = e2;
                TapLoggerKt.logError("Error parsing in-app subscription data.", e);
                return null;
            }
        } catch (JSONException e3) {
            e = e3;
        }
    }

    private final String getStringValue(JSONObject $this$getStringValue, String key) {
        if ($this$getStringValue.has(key)) {
            return $this$getStringValue.optString(key);
        }
        return null;
    }

    private final Long getLongValue(JSONObject $this$getLongValue, String key) {
        if ($this$getLongValue.has(key)) {
            return Long.valueOf($this$getLongValue.optLong(key));
        }
        return null;
    }
}
