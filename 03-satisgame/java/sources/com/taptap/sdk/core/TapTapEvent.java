package com.taptap.sdk.core;

import com.anythink.core.common.f.e;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.db.event.TapPredefinedEvents;
import com.taptap.sdk.db.event.model.TapEventType;
import com.taptap.sdk.db.event.playgame.TapPlayGameDurationTracker;
import com.taptap.sdk.db.event.utils.TapCoreKit;
import com.taptap.sdk.db.event.utils.TapEventLogger;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.identifier.TapIdentifierUtil;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: TapTapEvent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001!B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001H\u0007J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\b\u0010\n\u001a\u00020\u0004H\u0007J!\u0010\u000b\u001a\u00020\u00042\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\r\"\u00020\u0006H\u0007¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0004H\u0007J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0007J\u001c\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u001c\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0012\u0010 \u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¨\u0006\""}, d2 = {"Lcom/taptap/sdk/core/TapTapEvent;", "", "()V", "addCommon", "", e.a.b, "", e.a.d, TapEventParamConstants.PARAM_PROPERTIES, "Lorg/json/JSONObject;", "clearAllCommonProperties", "clearCommonProperties", "keys", "", "([Ljava/lang/String;)V", "clearUser", "deviceAdd", "deviceInitialize", "deviceUpdate", "getDeviceId", "logEvent", TapEventParamConstants.PARAM_NAME, "logPurchasedEvent", "purchasedEvent", "Lcom/taptap/sdk/core/TapTapPurchasedEvent;", "registerDynamicProperties", "dynamic", "Lcom/taptap/sdk/core/TapTapEvent$TapEventDynamicProperties;", "setUserId", "userId", "userAdd", "userInitialize", "userUpdate", "TapEventDynamicProperties", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapTapEvent {
    public static final TapTapEvent INSTANCE = new TapTapEvent();

    /* JADX INFO: compiled from: TapTapEvent.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/taptap/sdk/core/TapTapEvent$TapEventDynamicProperties;", "", "getDynamicProperties", "Lorg/json/JSONObject;", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface TapEventDynamicProperties {
        JSONObject getDynamicProperties();
    }

    @JvmStatic
    public static final void logEvent(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        logEvent$default(name, null, 2, null);
    }

    @JvmStatic
    public static final void setUserId(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        setUserId$default(userId, null, 2, null);
    }

    private TapTapEvent() {
    }

    public static /* synthetic */ void logEvent$default(String str, JSONObject jSONObject, int i, Object obj) {
        if ((i & 2) != 0) {
            jSONObject = null;
        }
        logEvent(str, jSONObject);
    }

    @JvmStatic
    public static final void logEvent(String name, JSONObject properties) {
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            TapCoreKit.assertEventName(name);
            TapEventLogger.logEventInner$tap_db_release$default(TapEventLogger.INSTANCE, TapEventType.TRACK, name, false, properties, null, 16, null);
        } catch (Exception e) {
            TapLogger.loge$default(null, null, e, 3, null);
        }
    }

    @JvmStatic
    public static final void logPurchasedEvent(TapTapPurchasedEvent purchasedEvent) {
        Intrinsics.checkNotNullParameter(purchasedEvent, "purchasedEvent");
        try {
            TapEventLogger.INSTANCE.validateUserId$tap_db_release();
            TapPredefinedEvents.trackPurchasedEvent(purchasedEvent);
        } catch (Exception e) {
            TapLogger.loge$default(null, null, e, 3, null);
        }
    }

    public static /* synthetic */ void setUserId$default(String str, JSONObject jSONObject, int i, Object obj) {
        if ((i & 2) != 0) {
            jSONObject = null;
        }
        setUserId(str, jSONObject);
    }

    @JvmStatic
    public static final void setUserId(String userId, JSONObject properties) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        try {
            TapCoreKit.INSTANCE.assertUserId(userId);
            TapEventLogger.INSTANCE.setUserId$tap_db_release(userId);
            TapPlayGameDurationTracker.INSTANCE.setUserId(userId);
            TapPredefinedEvents.trackUserLogin(properties);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("has_user", true);
            TapPredefinedEvents.deviceUpdate(jSONObject);
            TapIdentifierUtil.INSTANCE.setGameUserId(userId);
        } catch (Exception e) {
            TapLogger.loge$default(null, null, e, 3, null);
        }
    }

    @JvmStatic
    public static final void clearUser() {
        try {
            TapEventLogger.INSTANCE.clearUser$tap_db_release();
            TapPlayGameDurationTracker.INSTANCE.setUserId(null);
            TapIdentifierUtil.INSTANCE.setGameUserId(null);
        } catch (Exception e) {
            TapLogger.loge$default(null, null, e, 3, null);
        }
    }

    @JvmStatic
    public static final String getDeviceId() {
        try {
            return TapIdentifierUtil.INSTANCE.getDeviceId(TapEventLogger.INSTANCE.getApplicationContext$tap_db_release());
        } catch (Exception e) {
            TapLogger.loge$default(null, null, e, 3, null);
            return null;
        }
    }

    @JvmStatic
    public static final void deviceInitialize(JSONObject properties) {
        try {
            TapPredefinedEvents.deviceInitialise(properties);
        } catch (Exception e) {
            TapLogger.loge$default(null, null, e, 3, null);
        }
    }

    @JvmStatic
    public static final void deviceUpdate(JSONObject properties) {
        try {
            TapPredefinedEvents.deviceUpdate(properties);
        } catch (Exception e) {
            TapLogger.loge$default(null, null, e, 3, null);
        }
    }

    @JvmStatic
    public static final void deviceAdd(JSONObject properties) {
        try {
            TapPredefinedEvents.deviceAdd(properties);
        } catch (Exception e) {
            TapLogger.loge$default(null, null, e, 3, null);
        }
    }

    @JvmStatic
    public static final void userInitialize(JSONObject properties) {
        try {
            TapPredefinedEvents.userInitialise(properties);
        } catch (Exception e) {
            TapLogger.loge$default(null, null, e, 3, null);
        }
    }

    @JvmStatic
    public static final void userUpdate(JSONObject properties) {
        try {
            TapPredefinedEvents.userUpdate(properties);
        } catch (Exception e) {
            TapLogger.loge$default(null, null, e, 3, null);
        }
    }

    @JvmStatic
    public static final void userAdd(JSONObject properties) {
        try {
            TapPredefinedEvents.userAdd(properties);
        } catch (Exception e) {
            TapLogger.loge$default(null, null, e, 3, null);
        }
    }

    @JvmStatic
    public static final void addCommon(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            if (TapCoreKit.checkKey("addCommonProperty Error", key) && TapCoreKit.INSTANCE.checkValue("addCommonProperty Error", key, value)) {
                TapEventLogger.INSTANCE.addCommonProperty$tap_db_release(key, value);
            }
        } catch (Exception e) {
            TapLogger.loge$default(null, null, e, 3, null);
        }
    }

    @JvmStatic
    public static final void addCommon(JSONObject properties) {
        try {
            TapEventLogger.INSTANCE.addCommonProperties$tap_db_release(properties);
        } catch (Exception e) {
            TapLogger.loge$default(null, null, e, 3, null);
        }
    }

    @JvmStatic
    public static final void clearCommonProperties(String... keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        try {
            TapEventLogger.INSTANCE.clearCommonProperties$tap_db_release((String[]) Arrays.copyOf(keys, keys.length));
        } catch (Exception e) {
            TapLogger.loge$default(null, null, e, 3, null);
        }
    }

    @JvmStatic
    public static final void clearAllCommonProperties() {
        try {
            TapEventLogger.INSTANCE.clearAllCommonProperties$tap_db_release();
        } catch (Exception e) {
            TapLogger.loge$default(null, null, e, 3, null);
        }
    }

    @JvmStatic
    public static final void registerDynamicProperties(TapEventDynamicProperties dynamic) {
        try {
            TapEventLogger.INSTANCE.registerDynamicProperties$tap_db_release(dynamic);
        } catch (Exception e) {
            TapLogger.loge$default(null, null, e, 3, null);
        }
    }
}
