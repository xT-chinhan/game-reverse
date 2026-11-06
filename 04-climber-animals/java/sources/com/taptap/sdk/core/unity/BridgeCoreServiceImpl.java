package com.taptap.sdk.core.unity;

import android.app.Activity;
import com.anythink.core.common.e.f;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tapsdk.tapad.internal.tracker.experiment.d;
import com.taptap.sdk.core.TapTapEvent;
import com.taptap.sdk.core.TapTapPurchasedEvent;
import com.taptap.sdk.core.TapTapSdk;
import com.taptap.sdk.core.TapTapSdkOptions;
import com.taptap.sdk.core.unity.config.CoreInitConfig;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.initializer.api.model.Language;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.kit.internal.p000const.TrackAction;
import com.taptap.sdk.kit.internal.utils.PlatformXUA;
import com.taptap.sdk.kit.internal.utils.localize.TapLocalizeUtil;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: BridgeCoreServiceImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 52\u00020\u0001:\u00015B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u001f\u0010\u000b\u001a\u00020\u00042\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J1\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0004H\u0016J\u001c\u0010\u001c\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016JB\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00062\b\u0010 \u001a\u0004\u0018\u00010\u00062\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u00062\b\u0010$\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010%\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010'\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\u00062\b\u0010)\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010*\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0006H\u0016J\u001a\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/H\u0016J\u0012\u00100\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u00101\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u00102\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u00103\u001a\u0004\u0018\u000104*\u00020\u0006H\u0002¨\u00066"}, d2 = {"Lcom/taptap/sdk/core/unity/BridgeCoreServiceImpl;", "Lcom/taptap/sdk/core/unity/BridgeCoreService;", "()V", "addCommonProperties", "", Common.Predefined.PROPERTIES, "", "addCommonProperty", f.a.b, f.a.d, "clearAllCommonProperties", "clearCommonProperties", "keys", "", "([Ljava/lang/String;)V", "clearCommonProperty", "clearUser", "deviceAdd", "deviceInitialize", "deviceUpdate", "getDeviceId", TrackAction.INIT, TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "coreOption", "otherOptions", "(Landroid/app/Activity;Ljava/lang/String;[Ljava/lang/String;)V", "logDeviceLoginEvent", "logEvent", Common.System.NAME, "logPurchasedEvent", "orderID", "productName", d.q, "", "currencyType", "paymentMethod", "setOAID", "oaid", "setPlatformAndVersion", "platform", "version", "setSDKArtifact", "setUserID", "userId", "updateLanguage", "language", "", "userAdd", "userInitialize", "userUpdate", "safeToJson", "Lorg/json/JSONObject;", "Companion", "tap-core-unity_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BridgeCoreServiceImpl implements BridgeCoreService {
    public static final String TAG = "BridgeCoreServiceImpl";

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void init(Activity activity, String coreOption, String[] otherOptions) {
        Object objDecodeFromString;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (activity.isDestroyed() || activity.isFinishing()) {
            TapLogger.loge$default(TAG, "init activity is destroyed or finishing", null, 4, null);
            return;
        }
        String str = coreOption;
        boolean z = true;
        if (str == null || StringsKt.isBlank(str)) {
            TapLogger.loge$default(TAG, "init coreOption is null or blank", null, 4, null);
            return;
        }
        TapJson tapJson = TapJson.INSTANCE;
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            objDecodeFromString = null;
        } else {
            try {
                Json json = tapJson.getJson();
                KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(CoreInitConfig.class));
                Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                objDecodeFromString = json.decodeFromString(kSerializerSerializer, coreOption);
            } catch (Exception e) {
                TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                objDecodeFromString = null;
            }
        }
        CoreInitConfig coreInitConfig = (CoreInitConfig) objDecodeFromString;
        if (coreInitConfig == null) {
            TapLogger.loge$default(TAG, "init config is null", null, 4, null);
            return;
        }
        Activity activity2 = activity;
        TapTapSdkOptions tapTapSdkOptionsConvertToTapTapRegion = coreInitConfig.convertToTapTapRegion();
        if (otherOptions == null) {
            otherOptions = new String[0];
        }
        TapTapSdk.init(activity2, tapTapSdkOptionsConvertToTapTapRegion, otherOptions);
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void setPlatformAndVersion(String platform, String version) {
        TapLogger.logi(TAG, "setPlatformAndVersion: " + platform + ", " + version);
        String str = platform;
        boolean z = true;
        if (!(str == null || StringsKt.isBlank(str))) {
            String str2 = version;
            if (str2 != null && !StringsKt.isBlank(str2)) {
                z = false;
            }
            if (!z) {
                PlatformXUA.addUA(platform, version);
                return;
            }
        }
        TapLogger.logw$default(TAG, "setPlatformAndVersion arg error , K: " + platform + ", V: " + version, false, 4, null);
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void setSDKArtifact(String value) {
        TapLogger.logi(TAG, "setSDKArtifact: " + value);
        String str = value;
        if (str == null || StringsKt.isBlank(str)) {
            TapLogger.logw$default(TAG, "setSDKArtifact value is null or blank , Value: " + value, false, 4, null);
        } else {
            PlatformXUA.setSDKArtifact(value);
        }
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void updateLanguage(int language) {
        TapLogger.logi(TAG, "updateLanguage: " + language);
        TapLocalizeUtil.INSTANCE.setPreferredLanguage(Language.INSTANCE.from(language).getLanguage());
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void setUserID(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        setUserID(userId, null);
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void setUserID(String userId, String properties) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (userId.length() == 0) {
            TapLogger.loge$default(TAG, "setUserID userId is blank", null, 4, null);
            return;
        }
        JSONObject jSONObjectSafeToJson = properties != null ? safeToJson(properties) : null;
        TapLogger.logi(TAG, "setUserID: properties: " + jSONObjectSafeToJson);
        TapTapEvent.setUserId(userId, jSONObjectSafeToJson);
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void clearUser() {
        TapLogger.logi(TAG, "clearUser");
        TapTapEvent.clearUser();
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public String getDeviceId() {
        TapLogger.logi(TAG, "clearUser");
        String deviceId = TapTapEvent.INSTANCE.getDeviceId();
        return deviceId == null ? "" : deviceId;
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void logEvent(String name, String properties) {
        TapLogger.logi(TAG, "logEvent: name: " + name + ", properties: " + properties);
        String str = name;
        if (str == null || StringsKt.isBlank(str)) {
            String str2 = properties;
            if (str2 == null || StringsKt.isBlank(str2)) {
                TapLogger.loge$default(TAG, "logEvent: empty arg return", null, 4, null);
                return;
            }
        }
        JSONObject jSONObjectSafeToJson = properties != null ? safeToJson(properties) : null;
        if (name == null) {
            name = "";
        }
        TapTapEvent.logEvent(name, jSONObjectSafeToJson);
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void deviceInitialize(String properties) {
        JSONObject jSONObjectSafeToJson;
        TapLogger.logi(TAG, "deviceInitialize: properties: " + properties);
        if (properties == null || (jSONObjectSafeToJson = safeToJson(properties)) == null) {
            return;
        }
        TapTapEvent.deviceInitialize(jSONObjectSafeToJson);
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void deviceUpdate(String properties) {
        JSONObject jSONObjectSafeToJson;
        TapLogger.logi(TAG, "deviceUpdate: properties: " + properties);
        if (properties == null || (jSONObjectSafeToJson = safeToJson(properties)) == null) {
            return;
        }
        TapTapEvent.deviceUpdate(jSONObjectSafeToJson);
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void deviceAdd(String properties) {
        JSONObject jSONObjectSafeToJson;
        TapLogger.logi(TAG, "deviceAdd: properties: " + properties);
        if (properties == null || (jSONObjectSafeToJson = safeToJson(properties)) == null) {
            return;
        }
        TapTapEvent.deviceAdd(jSONObjectSafeToJson);
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void userInitialize(String properties) {
        JSONObject jSONObjectSafeToJson;
        TapLogger.logi(TAG, "userInitialize: properties: " + properties);
        if (properties == null || (jSONObjectSafeToJson = safeToJson(properties)) == null) {
            return;
        }
        TapTapEvent.userInitialize(jSONObjectSafeToJson);
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void userAdd(String properties) {
        JSONObject jSONObjectSafeToJson;
        TapLogger.logi(TAG, "userAdd: properties: " + properties);
        if (properties == null || (jSONObjectSafeToJson = safeToJson(properties)) == null) {
            return;
        }
        TapTapEvent.userAdd(jSONObjectSafeToJson);
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void userUpdate(String properties) {
        JSONObject jSONObjectSafeToJson;
        TapLogger.logi(TAG, "userUpdate: properties: " + properties);
        if (properties == null || (jSONObjectSafeToJson = safeToJson(properties)) == null) {
            return;
        }
        TapTapEvent.userUpdate(jSONObjectSafeToJson);
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void addCommonProperty(String key, String value) {
        TapLogger.logi(TAG, "addCommonProperty: key: " + key + ", value: " + value);
        String str = key;
        if (!(str == null || StringsKt.isBlank(str))) {
            String str2 = value;
            if (!(str2 == null || StringsKt.isBlank(str2))) {
                TapTapEvent.addCommon(key, value);
                return;
            }
        }
        TapLogger.loge$default(TAG, "addCommonProperty: empty arg return", null, 4, null);
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void addCommonProperties(String properties) {
        TapLogger.logi(TAG, "addCommonProperties: properties: " + properties);
        TapTapEvent.addCommon(properties != null ? safeToJson(properties) : null);
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void clearCommonProperty(String key) {
        TapLogger.logi(TAG, "clearCommonProperty key = " + key);
        if (key == null) {
            TapLogger.loge$default(TAG, "clearCommonProperty key is null", null, 4, null);
        } else {
            TapTapEvent.clearCommonProperties(key);
        }
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void clearCommonProperties(String[] keys) {
        TapLogger.logi(TAG, "clearCommonProperty keys = " + keys);
        if (keys == null) {
            TapLogger.loge$default(TAG, "clearCommonProperty keys is null", null, 4, null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : keys) {
            if (str != null) {
                arrayList.add(str);
            }
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        TapTapEvent.clearCommonProperties((String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void clearAllCommonProperties() {
        TapLogger.logi(TAG, "clearAllCommonProperties");
        TapTapEvent.clearAllCommonProperties();
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void logPurchasedEvent(String orderID, String productName, long amount, String currencyType, String paymentMethod, String properties) {
        TapLogger.logi(TAG, "logPurchasedEvent: orderID: " + orderID + ", productName: " + productName + ", amount: " + amount + ", currencyType: " + currencyType + ", paymentMethod: " + paymentMethod + ", properties: " + properties);
        TapTapEvent.logPurchasedEvent(new TapTapPurchasedEvent(orderID, productName, amount, currencyType, paymentMethod, properties != null ? safeToJson(properties) : null));
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void setOAID(String oaid) {
        TapTapEvent.setOAID(oaid);
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void logDeviceLoginEvent() {
        TapTapEvent.logDeviceLoginEvent();
    }

    private final JSONObject safeToJson(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            TapLogger.loge$default(TAG, "safeToJson error = " + e, null, 4, null);
            return null;
        }
    }
}
