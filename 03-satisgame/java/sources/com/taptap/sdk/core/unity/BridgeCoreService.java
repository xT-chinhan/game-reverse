package com.taptap.sdk.core.unity;

import android.app.Activity;
import com.anythink.core.common.f.e;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.kit.internal.enginebridge.IEngineBridgeService;
import com.taptap.sdk.kit.internal.enginebridge.annotation.EngineBridgeMethod;
import com.taptap.sdk.kit.internal.enginebridge.annotation.EngineBridgeParams;
import com.taptap.sdk.kit.internal.enginebridge.annotation.EngineBridgeService;
import kotlin.Metadata;

/* JADX INFO: compiled from: BridgeCoreService.kt */
/* JADX INFO: loaded from: classes3.dex */
@EngineBridgeService("BridgeCoreService")
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005H'J \u0010\u0006\u001a\u00020\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005H'J\b\u0010\t\u001a\u00020\u0003H'J!\u0010\n\u001a\u00020\u00032\u0012\b\u0003\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\fH'¢\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u00020\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0005H'J\b\u0010\u000f\u001a\u00020\u0003H'J\u0014\u0010\u0010\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005H'J\u0014\u0010\u0011\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005H'J\u0014\u0010\u0012\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005H'J\b\u0010\u0013\u001a\u00020\u0005H'J5\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0012\b\u0001\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\fH'¢\u0006\u0002\u0010\u0019J \u0010\u001a\u001a\u00020\u00032\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005H'JN\u0010\u001c\u001a\u00020\u00032\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u001f\u001a\u00020 2\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005H'J \u0010#\u001a\u00020\u00032\n\b\u0001\u0010$\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\u0005H'J\u0014\u0010&\u001a\u00020\u00032\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005H'J\u0012\u0010'\u001a\u00020\u00032\b\b\u0001\u0010(\u001a\u00020\u0005H'J\u001e\u0010'\u001a\u00020\u00032\b\b\u0001\u0010(\u001a\u00020\u00052\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005H'J\u0012\u0010)\u001a\u00020\u00032\b\b\u0001\u0010*\u001a\u00020+H'J\u0014\u0010,\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005H'J\u0014\u0010-\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005H'J\u0014\u0010.\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005H'¨\u0006/"}, d2 = {"Lcom/taptap/sdk/core/unity/BridgeCoreService;", "Lcom/taptap/sdk/kit/internal/enginebridge/IEngineBridgeService;", "addCommonProperties", "", TapEventParamConstants.PARAM_PROPERTIES, "", "addCommonProperty", e.a.b, e.a.d, "clearAllCommonProperties", "clearCommonProperties", "keys", "", "([Ljava/lang/String;)V", "clearCommonProperty", "clearUser", "deviceAdd", "deviceInitialize", "deviceUpdate", "getDeviceId", "init", "activity", "Landroid/app/Activity;", "coreOption", "otherOptions", "(Landroid/app/Activity;Ljava/lang/String;[Ljava/lang/String;)V", "logEvent", TapEventParamConstants.PARAM_NAME, "logPurchasedEvent", "orderID", "productName", "amount", "", "currencyType", "paymentMethod", "setPlatformAndVersion", "platform", "version", "setSDKArtifact", "setUserID", "userId", "updateLanguage", "language", "", "userAdd", "userInitialize", "userUpdate", "tap-db-unity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface BridgeCoreService extends IEngineBridgeService {
    @EngineBridgeMethod("addCommonProperties")
    void addCommonProperties(@EngineBridgeParams(TapEventParamConstants.PARAM_PROPERTIES) String properties);

    @EngineBridgeMethod("addCommonProperty")
    void addCommonProperty(@EngineBridgeParams(e.a.b) String key, @EngineBridgeParams(e.a.d) String value);

    @EngineBridgeMethod("clearAllCommonProperties")
    void clearAllCommonProperties();

    @EngineBridgeMethod("clearCommonProperties")
    void clearCommonProperties(@EngineBridgeParams("keys") String[] keys);

    @EngineBridgeMethod("clearCommonProperty")
    void clearCommonProperty(@EngineBridgeParams(e.a.b) String key);

    @EngineBridgeMethod("clearUser")
    void clearUser();

    @EngineBridgeMethod("deviceAdd")
    void deviceAdd(@EngineBridgeParams(TapEventParamConstants.PARAM_PROPERTIES) String properties);

    @EngineBridgeMethod("deviceInitialize")
    void deviceInitialize(@EngineBridgeParams(TapEventParamConstants.PARAM_PROPERTIES) String properties);

    @EngineBridgeMethod("deviceUpdate")
    void deviceUpdate(@EngineBridgeParams(TapEventParamConstants.PARAM_PROPERTIES) String properties);

    @EngineBridgeMethod("getDeviceId")
    String getDeviceId();

    @EngineBridgeMethod("init")
    void init(Activity activity, @EngineBridgeParams("coreOption") String coreOption, @EngineBridgeParams("otherOptions") String[] otherOptions);

    @EngineBridgeMethod("logEvent")
    void logEvent(@EngineBridgeParams(TapEventParamConstants.PARAM_NAME) String name, @EngineBridgeParams(TapEventParamConstants.PARAM_PROPERTIES) String properties);

    @EngineBridgeMethod("logPurchasedEvent")
    void logPurchasedEvent(@EngineBridgeParams("orderID") String orderID, @EngineBridgeParams("productName") String productName, @EngineBridgeParams("amount") long amount, @EngineBridgeParams("currencyType") String currencyType, @EngineBridgeParams("paymentMethod") String paymentMethod, @EngineBridgeParams(TapEventParamConstants.PARAM_PROPERTIES) String properties);

    @EngineBridgeMethod("setPlatformAndVersion")
    void setPlatformAndVersion(@EngineBridgeParams("platform") String platform, @EngineBridgeParams("version") String version);

    @EngineBridgeMethod("setSDKArtifact")
    void setSDKArtifact(@EngineBridgeParams("artifact") String value);

    @EngineBridgeMethod("setUserID")
    void setUserID(@EngineBridgeParams("userID") String userId);

    @EngineBridgeMethod("setUserID")
    void setUserID(@EngineBridgeParams("userID") String userId, @EngineBridgeParams(TapEventParamConstants.PARAM_PROPERTIES) String properties);

    @EngineBridgeMethod("updateLanguage")
    void updateLanguage(@EngineBridgeParams("language") int language);

    @EngineBridgeMethod("userAdd")
    void userAdd(@EngineBridgeParams(TapEventParamConstants.PARAM_PROPERTIES) String properties);

    @EngineBridgeMethod("userInitialize")
    void userInitialize(@EngineBridgeParams(TapEventParamConstants.PARAM_PROPERTIES) String properties);

    @EngineBridgeMethod("userUpdate")
    void userUpdate(@EngineBridgeParams(TapEventParamConstants.PARAM_PROPERTIES) String properties);

    /* JADX INFO: compiled from: BridgeCoreService.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void setUserID$default(BridgeCoreService bridgeCoreService, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setUserID");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            bridgeCoreService.setUserID(str, str2);
        }

        public static /* synthetic */ void logEvent$default(BridgeCoreService bridgeCoreService, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logEvent");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            bridgeCoreService.logEvent(str, str2);
        }

        public static /* synthetic */ void deviceInitialize$default(BridgeCoreService bridgeCoreService, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deviceInitialize");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            bridgeCoreService.deviceInitialize(str);
        }

        public static /* synthetic */ void deviceUpdate$default(BridgeCoreService bridgeCoreService, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deviceUpdate");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            bridgeCoreService.deviceUpdate(str);
        }

        public static /* synthetic */ void deviceAdd$default(BridgeCoreService bridgeCoreService, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deviceAdd");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            bridgeCoreService.deviceAdd(str);
        }

        public static /* synthetic */ void userInitialize$default(BridgeCoreService bridgeCoreService, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userInitialize");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            bridgeCoreService.userInitialize(str);
        }

        public static /* synthetic */ void userAdd$default(BridgeCoreService bridgeCoreService, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userAdd");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            bridgeCoreService.userAdd(str);
        }

        public static /* synthetic */ void userUpdate$default(BridgeCoreService bridgeCoreService, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userUpdate");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            bridgeCoreService.userUpdate(str);
        }

        public static /* synthetic */ void addCommonProperty$default(BridgeCoreService bridgeCoreService, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addCommonProperty");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            bridgeCoreService.addCommonProperty(str, str2);
        }

        public static /* synthetic */ void addCommonProperties$default(BridgeCoreService bridgeCoreService, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addCommonProperties");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            bridgeCoreService.addCommonProperties(str);
        }

        public static /* synthetic */ void clearCommonProperty$default(BridgeCoreService bridgeCoreService, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clearCommonProperty");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            bridgeCoreService.clearCommonProperty(str);
        }

        public static /* synthetic */ void clearCommonProperties$default(BridgeCoreService bridgeCoreService, String[] strArr, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clearCommonProperties");
            }
            if ((i & 1) != 0) {
                strArr = null;
            }
            bridgeCoreService.clearCommonProperties(strArr);
        }

        public static /* synthetic */ void logPurchasedEvent$default(BridgeCoreService bridgeCoreService, String str, String str2, long j, String str3, String str4, String str5, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logPurchasedEvent");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                j = -1;
            }
            if ((i & 8) != 0) {
                str3 = null;
            }
            if ((i & 16) != 0) {
                str4 = null;
            }
            if ((i & 32) != 0) {
                str5 = null;
            }
            bridgeCoreService.logPurchasedEvent(str, str2, j, str3, str4, str5);
        }
    }
}
