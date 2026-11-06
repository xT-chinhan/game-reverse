package com.taptap.sdk.core.unity;

import android.app.Activity;
import com.byazt.ol.TTDownloadField;
import com.mar.sdk.IAction;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.common.services.OpenLogService;
import com.taptap.sdk.core.TapTapEvent;
import com.taptap.sdk.core.TapTapPurchasedEvent;
import com.taptap.sdk.core.TapTapSdk;
import com.taptap.sdk.core.TapTapSdkOptions;
import com.taptap.sdk.core.unity.config.CoreInitConfig;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.initializer.TapTapSdkInitializer;
import com.taptap.sdk.initializer.api.SessionAwareTapInitCallback;
import com.taptap.sdk.initializer.api.TapInitState;
import com.taptap.sdk.initializer.api.model.Language;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.TapLoggerKt;
import com.taptap.sdk.kit.internal.enginebridge.EngineBridgeCallback;
import com.taptap.sdk.kit.internal.enginebridge.EngineBridgeResult;
import com.taptap.sdk.kit.internal.enginebridge.EngineBridgeResultKt;
import com.taptap.sdk.kit.internal.extensions.JsonExtKt;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.kit.internal.openlog.ITapOpenlog;
import com.taptap.sdk.kit.internal.p001const.SdkModules;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.taptap.sdk.kit.internal.utils.PlatformXUA;
import com.taptap.sdk.kit.internal.utils.localize.TapLocalizeUtil;
import com.taptap.sdk.servicemanager.ServiceManager;
import com.taptap.sdk.servicemanager.utils.ServiceManagerComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.modules.SerializersModule;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: BridgeCoreServiceImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 J2\u00020\u0001:\u0001JB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016J\u001f\u0010\u0019\u001a\u00020\u000f2\u0010\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u001bH\u0016¢\u0006\u0002\u0010\u001cJ\u0012\u0010\u001d\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0016J\u0012\u0010\u001f\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010 \u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010!\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\"\u001a\u00020\u0011H\u0016J1\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u00112\u0010\u0010'\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u001bH\u0016¢\u0006\u0002\u0010(J1\u0010)\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u00112\u0010\u0010'\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u001bH\u0016¢\u0006\u0002\u0010*J\b\u0010+\u001a\u00020\u000fH\u0016J\u001c\u0010,\u001a\u00020\u000f2\b\u0010-\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016JB\u0010.\u001a\u00020\u000f2\b\u0010/\u001a\u0004\u0018\u00010\u00112\b\u00100\u001a\u0004\u0018\u00010\u00112\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u00112\b\u00104\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u00105\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u0011H\u0002J0\u00107\u001a\u00020\u000f2\b\u00108\u001a\u0004\u0018\u00010\u00112\b\u00109\u001a\u0004\u0018\u00010\u00112\b\u0010:\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010;\u001a\u00020\u000f2\b\u0010<\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010=\u001a\u00020\u000f2\b\u0010>\u001a\u0004\u0018\u00010\u00112\b\u00109\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010?\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u0011H\u0016J\u001a\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010B\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020DH\u0016J\u0012\u0010E\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010F\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010G\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u000e\u0010H\u001a\u0004\u0018\u00010I*\u00020\u0011H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006K"}, d2 = {"Lcom/taptap/sdk/core/unity/BridgeCoreServiceImpl;", "Lcom/taptap/sdk/core/unity/BridgeCoreService;", "()V", "openLogService", "Lcom/taptap/sdk/common/services/OpenLogService;", "getOpenLogService", "()Lcom/taptap/sdk/common/services/OpenLogService;", "openLogService$delegate", "Lkotlin/Lazy;", "openlog", "Lcom/taptap/sdk/kit/internal/openlog/ITapOpenlog;", "getOpenlog", "()Lcom/taptap/sdk/kit/internal/openlog/ITapOpenlog;", "openlog$delegate", "addCommonProperties", "", Common.Predefined.PROPERTIES, "", "addCommonProperty", "key", Constants.VALUE_FIELD, "addInitCallback", "callback", "Lcom/taptap/sdk/kit/internal/enginebridge/EngineBridgeCallback;", "clearAllCommonProperties", "clearCommonProperties", "keys", "", "([Ljava/lang/String;)V", "clearCommonProperty", "clearUser", "deviceAdd", "deviceInitialize", "deviceUpdate", "getDeviceId", TrackAction.INIT, TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "coreOption", "otherOptions", "(Landroid/app/Activity;Ljava/lang/String;[Ljava/lang/String;)V", "initWithSession", "(Landroid/app/Activity;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "logDeviceLoginEvent", "logEvent", Common.System.NAME, "logPurchasedEvent", IAction.PurchaseKey.OrderID, IAction.PurchaseKey.ProductName, IAction.BuyKey.CostAmount, "", "currencyType", "paymentMethod", "reportBridgeParamError", "message", "sendOpenLog", "project", "version", "action", "setOAID", "oaid", "setPlatformAndVersion", "platform", "setSDKArtifact", "setUserID", "userId", "updateLanguage", "language", "", "userAdd", "userInitialize", "userUpdate", "safeToJson", "Lorg/json/JSONObject;", "Companion", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BridgeCoreServiceImpl implements BridgeCoreService {
    public static final String TAG = "BridgeCoreServiceImpl";

    /* JADX INFO: renamed from: openLogService$delegate, reason: from kotlin metadata */
    private final Lazy openLogService;

    /* JADX INFO: renamed from: openlog$delegate, reason: from kotlin metadata */
    private final Lazy openlog;

    public BridgeCoreServiceImpl() {
        ServiceManagerComponent serviceManagerComponent = ServiceManagerComponent.INSTANCE;
        this.openLogService = LazyKt.lazy(new Function0<OpenLogService>() { // from class: com.taptap.sdk.core.unity.BridgeCoreServiceImpl$special$$inlined$inject$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final OpenLogService invoke() {
                ServiceManager.Service service = ServiceManager.INSTANCE.getService(OpenLogService.class);
                if (service != null) {
                    return (OpenLogService) service;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.taptap.sdk.common.services.OpenLogService");
            }
        });
        this.openlog = LazyKt.lazy(new Function0<ITapOpenlog>() { // from class: com.taptap.sdk.core.unity.BridgeCoreServiceImpl$openlog$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ITapOpenlog invoke() {
                return this.this$0.getOpenLogService().obtainOpenlog(SdkModules.CORE, "4.10.9");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OpenLogService getOpenLogService() {
        return (OpenLogService) this.openLogService.getValue();
    }

    private final ITapOpenlog getOpenlog() {
        return (ITapOpenlog) this.openlog.getValue();
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void init(Activity activity, String coreOption, String[] otherOptions) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        initWithSession(activity, coreOption, otherOptions);
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public String initWithSession(Activity activity, String coreOption, String[] otherOptions) {
        Object objDecodeFromString;
        String[] strArr;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (activity.isDestroyed() || activity.isFinishing()) {
            TapLogger.loge$default(TAG, "init activity is destroyed or finishing", null, 4, null);
            return reportBridgeParamError("activity is destroyed or finishing");
        }
        String str = coreOption;
        boolean z = true;
        if (str == null || StringsKt.isBlank(str)) {
            TapLogger.loge$default(TAG, "init coreOption is null or blank", null, 4, null);
            return reportBridgeParamError("coreOption is null or blank");
        }
        TapJson this_$iv = TapJson.INSTANCE;
        String str2 = coreOption;
        if (str2 != null && str2.length() != 0) {
            z = false;
        }
        if (z) {
            objDecodeFromString = null;
        } else {
            try {
                StringFormat $this$decodeFromString$iv$iv = this_$iv.getJson();
                SerializersModule $this$serializer$iv$iv$iv = $this$decodeFromString$iv$iv.getSerializersModule();
                KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(CoreInitConfig.class));
                Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                objDecodeFromString = $this$decodeFromString$iv$iv.decodeFromString(kSerializerSerializer, coreOption);
            } catch (Exception e$iv) {
                TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
                objDecodeFromString = null;
            }
        }
        CoreInitConfig config = (CoreInitConfig) objDecodeFromString;
        if (config == null) {
            TapLogger.loge$default(TAG, "init config is null", null, 4, null);
            return reportBridgeParamError("coreOption json decode failed");
        }
        Activity activity2 = activity;
        TapTapSdkOptions tapTapSdkOptionsConvertToTapTapRegion = config.convertToTapTapRegion();
        if (otherOptions != null) {
            strArr = otherOptions;
        } else {
            strArr = new String[0];
        }
        TapTapSdk.init(activity2, tapTapSdkOptionsConvertToTapTapRegion, strArr);
        return String.valueOf(TapTapSdkInitializer.INSTANCE.getCurrentSession());
    }

    private final String reportBridgeParamError(String message) {
        long session = TapTapSdkInitializer.INSTANCE.beginSession();
        TapTapSdkInitializer.INSTANCE.updateInitState(new TapInitState.Failed(1000, message), session);
        return String.valueOf(session);
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void addInitCallback(final EngineBridgeCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        TapTapSdk.addInitCallback(new SessionAwareTapInitCallback() { // from class: com.taptap.sdk.core.unity.BridgeCoreServiceImpl.addInitCallback.1
            @Override // com.taptap.sdk.initializer.api.SessionAwareTapInitCallback, com.taptap.sdk.initializer.api.TapInitCallback
            public void onInitFail(int errorCode, String errorMsg) {
                SessionAwareTapInitCallback.DefaultImpls.onInitFail(this, errorCode, errorMsg);
            }

            @Override // com.taptap.sdk.initializer.api.SessionAwareTapInitCallback, com.taptap.sdk.initializer.api.TapInitCallback
            public void onInitSuccess() {
                SessionAwareTapInitCallback.DefaultImpls.onInitSuccess(this);
            }

            @Override // com.taptap.sdk.initializer.api.SessionAwareTapInitCallback
            public void onInitSuccess(long session) {
                EngineBridgeCallback engineBridgeCallback = callback;
                TapJson this_$iv = TapJson.INSTANCE;
                EngineBridgeResult engineBridgeResultGenerateBridgeSuccessResult = EngineBridgeResultKt.generateBridgeSuccessResult(String.valueOf(session));
                String strEncodeToString = null;
                try {
                    StringFormat $this$encodeToString$iv$iv = this_$iv.getJson();
                    SerializersModule $this$serializer$iv$iv$iv = $this$encodeToString$iv$iv.getSerializersModule();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(EngineBridgeResult.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    strEncodeToString = $this$encodeToString$iv$iv.encodeToString(kSerializerSerializer, engineBridgeResultGenerateBridgeSuccessResult);
                } catch (Exception e$iv) {
                    TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
                }
                if (strEncodeToString == null) {
                    strEncodeToString = "";
                }
                engineBridgeCallback.onResult(strEncodeToString);
            }

            @Override // com.taptap.sdk.initializer.api.SessionAwareTapInitCallback
            public void onInitFail(int errorCode, String errorMsg, long session) {
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                EngineBridgeCallback engineBridgeCallback = callback;
                TapJson this_$iv = TapJson.INSTANCE;
                EngineBridgeResult engineBridgeResult = new EngineBridgeResult(errorCode, errorMsg, String.valueOf(session));
                String strEncodeToString = null;
                try {
                    StringFormat $this$encodeToString$iv$iv = this_$iv.getJson();
                    SerializersModule $this$serializer$iv$iv$iv = $this$encodeToString$iv$iv.getSerializersModule();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(EngineBridgeResult.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    strEncodeToString = $this$encodeToString$iv$iv.encodeToString(kSerializerSerializer, engineBridgeResult);
                } catch (Exception e$iv) {
                    TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
                }
                if (strEncodeToString == null) {
                    strEncodeToString = "";
                }
                engineBridgeCallback.onResult(strEncodeToString);
            }
        });
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
        JSONObject propertyJson = properties != null ? safeToJson(properties) : null;
        TapLogger.logi(TAG, "setUserID: properties: " + propertyJson);
        TapTapEvent.setUserId(userId, propertyJson);
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
        JSONObject jsonProperties = properties != null ? safeToJson(properties) : null;
        TapTapEvent.logEvent(name == null ? "" : name, jsonProperties);
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void deviceInitialize(String properties) {
        JSONObject it;
        TapLogger.logi(TAG, "deviceInitialize: properties: " + properties);
        if (properties != null && (it = safeToJson(properties)) != null) {
            TapTapEvent.deviceInitialize(it);
        }
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void deviceUpdate(String properties) {
        JSONObject it;
        TapLogger.logi(TAG, "deviceUpdate: properties: " + properties);
        if (properties != null && (it = safeToJson(properties)) != null) {
            TapTapEvent.deviceUpdate(it);
        }
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void deviceAdd(String properties) {
        JSONObject it;
        TapLogger.logi(TAG, "deviceAdd: properties: " + properties);
        if (properties != null && (it = safeToJson(properties)) != null) {
            TapTapEvent.deviceAdd(it);
        }
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void userInitialize(String properties) {
        JSONObject it;
        TapLogger.logi(TAG, "userInitialize: properties: " + properties);
        if (properties != null && (it = safeToJson(properties)) != null) {
            TapTapEvent.userInitialize(it);
        }
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void userAdd(String properties) {
        JSONObject it;
        TapLogger.logi(TAG, "userAdd: properties: " + properties);
        if (properties != null && (it = safeToJson(properties)) != null) {
            TapTapEvent.userAdd(it);
        }
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void userUpdate(String properties) {
        JSONObject it;
        TapLogger.logi(TAG, "userUpdate: properties: " + properties);
        if (properties != null && (it = safeToJson(properties)) != null) {
            TapTapEvent.userUpdate(it);
        }
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
        Collection destination$iv$iv = new ArrayList();
        for (String str : keys) {
            if (str != null) {
                destination$iv$iv.add(str);
            }
        }
        Collection thisCollection$iv = (List) destination$iv$iv;
        String[] safeKey = (String[]) thisCollection$iv.toArray(new String[0]);
        TapTapEvent.clearCommonProperties((String[]) Arrays.copyOf(safeKey, safeKey.length));
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void clearAllCommonProperties() {
        TapLogger.logi(TAG, "clearAllCommonProperties");
        TapTapEvent.clearAllCommonProperties();
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void logPurchasedEvent(String orderID, String productName, long amount, String currencyType, String paymentMethod, String properties) {
        TapLogger.logi(TAG, "logPurchasedEvent: orderID: " + orderID + ", productName: " + productName + ", amount: " + amount + ", currencyType: " + currencyType + ", paymentMethod: " + paymentMethod + ", properties: " + properties);
        TapTapPurchasedEvent event = new TapTapPurchasedEvent(orderID, productName, amount, currencyType, paymentMethod, properties != null ? safeToJson(properties) : null);
        TapTapEvent.logPurchasedEvent(event);
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void setOAID(String oaid) {
        TapTapEvent.setOAID(oaid);
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void sendOpenLog(String project, String version, String action, String properties) {
        Map<String, String> mapEmptyMap;
        TapLoggerKt.logInfo("sendOpenLog: project: " + project + ", version: " + version + ", action: " + action + ", properties: " + properties);
        String str = action;
        if (str == null || StringsKt.isBlank(str)) {
            TapLoggerKt.logError$default("sendOpenLog: action is null or blank", null, 2, null);
            return;
        }
        if (properties == null || (mapEmptyMap = JsonExtKt.jsonToStringMap(properties)) == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        ITapOpenlog openlog = getOpenlog();
        if (openlog != null) {
            openlog.reportBusinessLog(project == null ? "" : project, action, mapEmptyMap);
        }
    }

    @Override // com.taptap.sdk.core.unity.BridgeCoreService
    public void logDeviceLoginEvent() {
        TapTapEvent.logDeviceLoginEvent();
    }

    private final JSONObject safeToJson(String $this$safeToJson) {
        try {
            return new JSONObject($this$safeToJson);
        } catch (JSONException e) {
            TapLogger.loge$default(TAG, "safeToJson error = " + e, null, 4, null);
            return null;
        }
    }
}
