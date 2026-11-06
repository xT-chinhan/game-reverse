package com.taptap.sdk.core;

import androidx.core.app.NotificationCompat;
import com.anythink.core.common.e.f;
import com.taptap.sdk.db.TapDB;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.db.data.model.Event;
import com.taptap.sdk.db.data.model.EventType;
import com.taptap.sdk.db.data.model.WrapEvent;
import com.taptap.sdk.db.event.DeviceAddEvent;
import com.taptap.sdk.db.event.DeviceInitializeEvent;
import com.taptap.sdk.db.event.DeviceLoginEvent;
import com.taptap.sdk.db.event.DeviceUpdateEvent;
import com.taptap.sdk.db.event.PurchasedEvent;
import com.taptap.sdk.db.event.UserAddEvent;
import com.taptap.sdk.db.event.UserInitializeEvent;
import com.taptap.sdk.db.event.UserLoginEvent;
import com.taptap.sdk.db.event.UserUpdateEvent;
import com.taptap.sdk.db.utils.JSONObjectUtils;
import com.taptap.sdk.db.utils.UserIdVerifyTools;
import com.taptap.sdk.initializer.api.check.TapSdkChecker;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.identifier.TapIdentifierUtil;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: TapTapEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001$B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0007J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\b\u0010\n\u001a\u00020\u0004H\u0007J!\u0010\u000b\u001a\u00020\u00042\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\r\"\u00020\u0006H\u0007¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0004H\u0007J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006J\b\u0010\u0014\u001a\u00020\u0004H\u0007J\u001c\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006H\u0007J\u001c\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0012\u0010!\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0012\u0010\"\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0012\u0010#\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¨\u0006%"}, d2 = {"Lcom/taptap/sdk/core/TapTapEvent;", "", "()V", "addCommon", "", f.a.b, "", f.a.d, Common.Predefined.PROPERTIES, "Lorg/json/JSONObject;", "clearAllCommonProperties", "clearCommonProperties", "keys", "", "([Ljava/lang/String;)V", "clearUser", "deviceAdd", "deviceInitialize", "deviceUpdate", "getDeviceId", "logDeviceLoginEvent", "logEvent", Common.System.NAME, "logPurchasedEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/taptap/sdk/core/TapTapPurchasedEvent;", "registerDynamicProperties", "dynamicProperties", "Lcom/taptap/sdk/core/TapTapEvent$TapEventDynamicProperties;", "setOAID", "oaid", "setUserId", "userId", "userAdd", "userInitialize", "userUpdate", "TapEventDynamicProperties", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapTapEvent {
    public static final TapTapEvent INSTANCE = new TapTapEvent();

    /* JADX INFO: compiled from: TapTapEvent.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/taptap/sdk/core/TapTapEvent$TapEventDynamicProperties;", "", "getDynamicProperties", "Lorg/json/JSONObject;", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface TapEventDynamicProperties {
        JSONObject getDynamicProperties();
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
        if (TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null) && TapDB.INSTANCE.checkEnable()) {
            TapDB companion = TapDB.INSTANCE.getInstance();
            WrapEvent.Builder builder = new WrapEvent.Builder();
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
            String value = EventType.TRACK.getValue();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (properties == null) {
                properties = new JSONObject();
            }
            companion.submitEvent(builder.setEvent(new Event(string, name, value, jCurrentTimeMillis, properties)).setEventType(EventType.TRACK).isAutomatically(false).isCustomEvent(true).build());
        }
    }

    @JvmStatic
    public static final void logPurchasedEvent(TapTapPurchasedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null) && TapDB.INSTANCE.checkEnable()) {
            new PurchasedEvent.Builder(event.getProperties()).isAutomatically(false).setOrderId(event.getOrderId()).setProductName(event.getProductName()).setAmount(event.getAmount()).setCurrencyType(event.getCurrencyType()).setPaymentMethod(event.getPaymentMethod()).build().submit();
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
        if (TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null) && TapDB.INSTANCE.checkEnable()) {
            try {
                UserIdVerifyTools.INSTANCE.verify(userId);
                TapDB.INSTANCE.getInstance().setUserId(userId);
                new UserLoginEvent.Builder(properties).isAutomatically(true).build().submit();
                new DeviceUpdateEvent.Builder(MapsKt.hashMapOf(TuplesKt.to("has_user", true))).isAutomatically(false).build().submit();
                TapIdentifierUtil.INSTANCE.setGameUserId(userId);
            } catch (Exception e) {
                TapLogger.loge$default(null, null, e, 3, null);
            }
        }
    }

    @JvmStatic
    public static final void clearUser() {
        if (TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null) && TapDB.INSTANCE.checkEnable()) {
            TapDB.INSTANCE.getInstance().setUserId(null);
            TapIdentifierUtil.INSTANCE.setGameUserId(null);
        }
    }

    public final String getDeviceId() {
        if (TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null) && TapDB.INSTANCE.checkEnable()) {
            return TapIdentifierUtil.INSTANCE.getDeviceId(TapDB.INSTANCE.getOptions$tap_db_release().getContext());
        }
        return null;
    }

    @JvmStatic
    public static final void deviceInitialize(JSONObject properties) {
        if (TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null) && TapDB.INSTANCE.checkEnable()) {
            new DeviceInitializeEvent.Builder(properties).isAutomatically(false).build().submit();
        }
    }

    @JvmStatic
    public static final void deviceUpdate(JSONObject properties) {
        Map<String, Object> mapEmptyMap;
        if (TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null) && TapDB.INSTANCE.checkEnable()) {
            if (properties == null || (mapEmptyMap = JSONObjectUtils.INSTANCE.toMap(properties)) == null) {
                mapEmptyMap = MapsKt.emptyMap();
            }
            new DeviceUpdateEvent.Builder(mapEmptyMap).isAutomatically(false).build().submit();
        }
    }

    @JvmStatic
    public static final void deviceAdd(JSONObject properties) {
        if (TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null) && TapDB.INSTANCE.checkEnable()) {
            new DeviceAddEvent.Builder(properties).isAutomatically(false).build().submit();
        }
    }

    @JvmStatic
    public static final void userInitialize(JSONObject properties) {
        if (TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null) && TapDB.INSTANCE.checkEnable()) {
            new UserInitializeEvent.Builder(properties).isAutomatically(false).build().submit();
        }
    }

    @JvmStatic
    public static final void userUpdate(JSONObject properties) {
        if (TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null) && TapDB.INSTANCE.checkEnable()) {
            new UserUpdateEvent.Builder(properties).isAutomatically(false).build().submit();
        }
    }

    @JvmStatic
    public static final void userAdd(JSONObject properties) {
        if (TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null) && TapDB.INSTANCE.checkEnable()) {
            new UserAddEvent.Builder(properties).isAutomatically(false).build().submit();
        }
    }

    @JvmStatic
    public static final void addCommon(JSONObject properties) {
        Map<String, Object> mapEmptyMap;
        if (TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null) && TapDB.INSTANCE.checkEnable()) {
            TapDB companion = TapDB.INSTANCE.getInstance();
            if (properties == null || (mapEmptyMap = JSONObjectUtils.INSTANCE.toMap(properties)) == null) {
                mapEmptyMap = MapsKt.emptyMap();
            }
            companion.addCommon(mapEmptyMap);
        }
    }

    @JvmStatic
    public static final void addCommon(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null) && TapDB.INSTANCE.checkEnable()) {
            TapDB.INSTANCE.getInstance().addCommon(MapsKt.mapOf(TuplesKt.to(key, value)));
        }
    }

    @JvmStatic
    public static final void clearCommonProperties(String... keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        if (TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null) && TapDB.INSTANCE.checkEnable()) {
            TapDB.INSTANCE.getInstance().clearCommonProperties(ArraysKt.toSet(keys));
        }
    }

    @JvmStatic
    public static final void clearAllCommonProperties() {
        if (TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null) && TapDB.INSTANCE.checkEnable()) {
            TapDB.INSTANCE.getInstance().clearAllCommonProperties();
        }
    }

    @JvmStatic
    public static final void registerDynamicProperties(TapEventDynamicProperties dynamicProperties) {
        if (TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null) && TapDB.INSTANCE.checkEnable()) {
            TapDB.INSTANCE.getInstance().registerDynamicPropertiesGetter(dynamicProperties);
        }
    }

    @JvmStatic
    public static final void setOAID(String oaid) {
        if (TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null) && TapDB.INSTANCE.checkEnable()) {
            TapDB.INSTANCE.getInstance().setOAID(oaid);
        }
    }

    @JvmStatic
    public static final void logDeviceLoginEvent() {
        if (TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null) && TapDB.INSTANCE.checkEnable()) {
            new DeviceLoginEvent.Builder(TapDB.INSTANCE.getOptions$tap_db_release().getProperties()).isAutomatically(true).build().submitNow();
        }
    }
}
