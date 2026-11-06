package com.taptap.sdk.db.event.iap.common;

import android.util.Log;
import com.anythink.core.common.f.e;
import com.taptap.sdk.compilance.constants.BundleKey;
import com.taptap.sdk.core.TapTapPurchasedEvent;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.core.internal.event.iap.lib2plus.BillingClientConstants;
import com.taptap.sdk.db.event.TapPredefinedEvents;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AutomaticAnalyticsLogger.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J \u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0007J\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0004*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/taptap/sdk/db/event/iap/common/AutomaticAnalyticsLogger;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "generateTapPurchasedEvent", "Lcom/taptap/sdk/core/TapTapPurchasedEvent;", "purchase", "skuDetails", "logPurchase", "", "isSubscription", "", "getLongValue", "", "Lorg/json/JSONObject;", e.a.b, "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Long;", "getStringValue", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AutomaticAnalyticsLogger {
    public static final AutomaticAnalyticsLogger INSTANCE = new AutomaticAnalyticsLogger();
    private static final String TAG = AutomaticAnalyticsLogger.class.getCanonicalName();

    private AutomaticAnalyticsLogger() {
    }

    @JvmStatic
    public static final void logPurchase(String purchase, String skuDetails, boolean isSubscription) throws JSONException {
        TapTapPurchasedEvent tapTapPurchasedEventGenerateTapPurchasedEvent;
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        Intrinsics.checkNotNullParameter(skuDetails, "skuDetails");
        if (isSubscription || (tapTapPurchasedEventGenerateTapPurchasedEvent = INSTANCE.generateTapPurchasedEvent(purchase, skuDetails)) == null) {
            return;
        }
        TapPredefinedEvents.INSTANCE.trackGoogleIAPPurchase(tapTapPurchasedEventGenerateTapPurchasedEvent);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0055  */
    private final TapTapPurchasedEvent generateTapPurchasedEvent(String purchase, String skuDetails) {
        double dLongValue;
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(purchase);
            JSONObject jSONObject3 = new JSONObject(skuDetails);
            String stringValue = getStringValue(jSONObject2, BillingClientConstants.PRODUCT_ID);
            if (stringValue == null) {
                stringValue = getStringValue(jSONObject3, BillingClientConstants.PRODUCT_ID);
            }
            String str = stringValue;
            String stringValue2 = getStringValue(jSONObject3, TapEventParamConstants.PARAM_NAME);
            if (stringValue2 == null) {
                stringValue2 = getStringValue(jSONObject3, "title");
            }
            String str2 = stringValue2;
            Long longValue = getLongValue(jSONObject3, "price_amount_micros");
            boolean z = true;
            if (longValue == null) {
                dLongValue = 0.0d;
            } else {
                if (!(longValue.longValue() > 0)) {
                    longValue = null;
                }
                if (longValue != null) {
                    dLongValue = longValue.longValue() / ((double) 10000);
                } else {
                    dLongValue = 0.0d;
                }
            }
            String stringValue3 = getStringValue(jSONObject3, "price_currency_code");
            String stringValue4 = getStringValue(jSONObject3, BundleKey.DESCRIPTION);
            String str3 = stringValue4;
            if (str3 != null && str3.length() != 0) {
                z = false;
            }
            if (z) {
                jSONObject = null;
            } else {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(BundleKey.DESCRIPTION, stringValue4);
                jSONObject = jSONObject4;
            }
            return new TapTapPurchasedEvent(str, str2, dLongValue, stringValue3, "google", jSONObject);
        } catch (JSONException e) {
            Log.e(TAG, "Error parsing in-app subscription data.", e);
            return null;
        }
    }

    private final String getStringValue(JSONObject jSONObject, String str) {
        if (jSONObject.has(str)) {
            return jSONObject.optString(str);
        }
        return null;
    }

    private final Long getLongValue(JSONObject jSONObject, String str) {
        if (jSONObject.has(str)) {
            return Long.valueOf(jSONObject.optLong(str));
        }
        return null;
    }
}
