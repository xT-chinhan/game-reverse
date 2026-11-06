package com.taptap.sdk.db.event;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taptap.sdk.core.TapTapPurchasedEvent;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.core.internal.event.constants.TapPredefinedEventsConstants;
import com.taptap.sdk.db.event.model.TapEventType;
import com.taptap.sdk.db.event.model.TapUserDurationBean;
import com.taptap.sdk.db.event.utils.TapEventLogger;
import com.taptap.sdk.db.event.utils.TapEventParameterKitKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TapPredefinedEvents.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0018\u0010\u0015\u001a\u00020\u00062\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007J\u0012\u0010\u0019\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\u001a\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\u001b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/taptap/sdk/db/event/TapPredefinedEvents;", "", "()V", "TAG", "", "deviceAdd", "", TapEventParamConstants.PARAM_PROPERTIES, "Lorg/json/JSONObject;", "deviceInitialise", "deviceUpdate", "trackDeviceLogin", "trackDevicePlayGame", "deviceDuration", "", "trackGoogleIAPPurchase", "purchasedEvent", "Lcom/taptap/sdk/core/TapTapPurchasedEvent;", "trackPaymentPurchase", "trackPurchasedEvent", "trackUserLogin", "trackUserPlayGame", "userDuration", "", "Lcom/taptap/sdk/db/event/model/TapUserDurationBean;", "userAdd", "userInitialise", "userUpdate", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapPredefinedEvents {
    public static final TapPredefinedEvents INSTANCE = new TapPredefinedEvents();
    private static final String TAG = "TapPredefinedEvents";

    private TapPredefinedEvents() {
    }

    @JvmStatic
    public static final void deviceInitialise(JSONObject properties) {
        TapEventLogger.logEventInner$tap_db_release$default(TapEventLogger.INSTANCE, TapEventType.DEVICE_INITIALISE, null, false, properties, null, 16, null);
    }

    @JvmStatic
    public static final void deviceUpdate(JSONObject properties) {
        TapEventLogger.logEventInner$tap_db_release$default(TapEventLogger.INSTANCE, TapEventType.DEVICE_UPDATE, null, false, properties, null, 16, null);
    }

    @JvmStatic
    public static final void deviceAdd(JSONObject properties) {
        TapEventLogger.logEventInner$tap_db_release$default(TapEventLogger.INSTANCE, TapEventType.DEVICE_ADD, null, false, properties, null, 16, null);
    }

    @JvmStatic
    public static final void userInitialise(JSONObject properties) {
        TapEventLogger.INSTANCE.validateUserId$tap_db_release("userInitialise");
        TapEventLogger.logEventInner$tap_db_release$default(TapEventLogger.INSTANCE, TapEventType.USER_INITIALISE, null, false, properties, null, 16, null);
    }

    @JvmStatic
    public static final void userUpdate(JSONObject properties) {
        TapEventLogger.INSTANCE.validateUserId$tap_db_release("userUpdate");
        TapEventLogger.logEventInner$tap_db_release$default(TapEventLogger.INSTANCE, TapEventType.USER_UPDATE, null, false, properties, null, 16, null);
    }

    @JvmStatic
    public static final void userAdd(JSONObject properties) {
        TapEventLogger.INSTANCE.validateUserId$tap_db_release("userAdd");
        TapEventLogger.logEventInner$tap_db_release$default(TapEventLogger.INSTANCE, TapEventType.USER_ADD, null, false, properties, null, 16, null);
    }

    @JvmStatic
    public static final void trackPurchasedEvent(TapTapPurchasedEvent purchasedEvent) throws JSONException {
        Intrinsics.checkNotNullParameter(purchasedEvent, "purchasedEvent");
        JSONObject properties = purchasedEvent.getProperties();
        if (properties == null) {
            properties = new JSONObject();
        }
        JSONObject jSONObject = properties;
        TapEventParameterKitKt.putProperty(jSONObject, "order_id", purchasedEvent.getOrderId());
        TapEventParameterKitKt.putProperty(jSONObject, "product", purchasedEvent.getProductName());
        TapEventParameterKitKt.putProperty(jSONObject, "amount", Double.valueOf(purchasedEvent.getAmount()));
        TapEventParameterKitKt.putProperty(jSONObject, "currency_type", purchasedEvent.getCurrencyType());
        TapEventParameterKitKt.putProperty(jSONObject, "payment", purchasedEvent.getPaymentMethod());
        TapEventLogger.logEventInner$tap_db_release$default(TapEventLogger.INSTANCE, TapEventType.TRACK, TapPredefinedEventsConstants.EVENT_CHARGE, false, jSONObject, null, 16, null);
    }

    @JvmStatic
    public static final void trackUserLogin(JSONObject properties) {
        TapEventLogger.logEventInner$tap_db_release$default(TapEventLogger.INSTANCE, TapEventType.TRACK, TapPredefinedEventsConstants.EVENT_USER_LOGIN, true, properties, null, 16, null);
    }

    @JvmStatic
    public static final void trackDeviceLogin(JSONObject properties) {
        TapEventLogger.logEventInner$tap_db_release$default(TapEventLogger.INSTANCE, TapEventType.TRACK, TapPredefinedEventsConstants.EVENT_DEVICE_LOGIN, true, properties, null, 16, null);
    }

    @JvmStatic
    public static final void trackUserPlayGame(List<TapUserDurationBean> userDuration) throws JSONException {
        if (userDuration != null) {
            for (TapUserDurationBean tapUserDurationBean : userDuration) {
                long duration = tapUserDurationBean.getDuration() / ((long) 1000);
                if (duration > 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(MediationConstant.EXTRA_DURATION, duration);
                    TapEventLogger.INSTANCE.logEventInner$tap_db_release(TapEventType.TRACK, TapPredefinedEventsConstants.EVENT_USER_PLAY_GAME, true, jSONObject, tapUserDurationBean.getUserId());
                }
            }
        }
    }

    @JvmStatic
    public static final void trackDevicePlayGame(long deviceDuration) throws JSONException {
        long j = deviceDuration / ((long) 1000);
        if (j > 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MediationConstant.EXTRA_DURATION, j);
            TapEventLogger.logEventInner$tap_db_release$default(TapEventLogger.INSTANCE, TapEventType.TRACK, TapPredefinedEventsConstants.EVENT_DEVICE_PLAY_GAME, true, jSONObject, null, 16, null);
        }
    }

    public final void trackGoogleIAPPurchase(TapTapPurchasedEvent purchasedEvent) throws JSONException {
        Intrinsics.checkNotNullParameter(purchasedEvent, "purchasedEvent");
        JSONObject properties = purchasedEvent.getProperties();
        if (properties == null) {
            properties = new JSONObject();
        }
        JSONObject jSONObject = properties;
        TapEventParameterKitKt.putProperty(jSONObject, "order_id", purchasedEvent.getOrderId());
        TapEventParameterKitKt.putProperty(jSONObject, "product", purchasedEvent.getProductName());
        TapEventParameterKitKt.putProperty(jSONObject, "amount", Double.valueOf(purchasedEvent.getAmount()));
        TapEventParameterKitKt.putProperty(jSONObject, "currency_type", purchasedEvent.getCurrencyType());
        TapEventParameterKitKt.putProperty(jSONObject, "payment", purchasedEvent.getPaymentMethod());
        TapEventLogger.logEventInner$tap_db_release$default(TapEventLogger.INSTANCE, TapEventType.TRACK, TapPredefinedEventsConstants.EVENT_CHARGE, true, jSONObject, null, 16, null);
    }

    public final void trackPaymentPurchase(TapTapPurchasedEvent purchasedEvent) throws JSONException {
        Intrinsics.checkNotNullParameter(purchasedEvent, "purchasedEvent");
        JSONObject properties = purchasedEvent.getProperties();
        if (properties == null) {
            properties = new JSONObject();
        }
        JSONObject jSONObject = properties;
        TapEventParameterKitKt.putProperty(jSONObject, "order_id", purchasedEvent.getOrderId());
        TapEventParameterKitKt.putProperty(jSONObject, "product", purchasedEvent.getProductName());
        TapEventParameterKitKt.putProperty(jSONObject, "amount", Double.valueOf(purchasedEvent.getAmount()));
        TapEventParameterKitKt.putProperty(jSONObject, "currency_type", purchasedEvent.getCurrencyType());
        TapEventParameterKitKt.putProperty(jSONObject, "payment", purchasedEvent.getPaymentMethod());
        TapEventLogger.logEventInner$tap_db_release$default(TapEventLogger.INSTANCE, TapEventType.TRACK, TapPredefinedEventsConstants.EVENT_CHARGE, true, jSONObject, null, 16, null);
    }
}
