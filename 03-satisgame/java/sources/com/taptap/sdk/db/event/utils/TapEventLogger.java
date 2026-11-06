package com.taptap.sdk.db.event.utils;

import android.content.Context;
import com.anythink.core.common.f.e;
import com.taptap.sdk.core.TapTapEvent;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.db.event.TapEventQueue;
import com.taptap.sdk.db.event.iap.InAppPurchaseManager;
import com.taptap.sdk.db.event.model.TapEventBean;
import com.taptap.sdk.db.event.model.TapEventType;
import com.taptap.sdk.db.event.playgame.TapPlayGameDurationTracker;
import com.taptap.sdk.initializer.api.option.TapTapSdkOptions;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.exception.TapSdkException;
import com.taptap.sdk.kit.internal.exception.TapSdkNotInitializedException;
import com.taptap.sdk.kit.internal.identifier.TapIdentifierUtil;
import java.util.Arrays;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;

/* JADX INFO: compiled from: TapEventLogger.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u001c\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0002\b%J\u001d\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)H\u0000¢\u0006\u0002\b*J\u001a\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0010H\u0002J6\u00100\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\b\u00101\u001a\u0004\u0018\u00010\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u00062\u0006\u00102\u001a\u0002032\b\u0010/\u001a\u0004\u0018\u00010\u0010H\u0003J$\u00104\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00062\b\u0010/\u001a\u0004\u0018\u00010\u0010H\u0003J\r\u00105\u001a\u00020#H\u0000¢\u0006\u0002\b6J#\u00107\u001a\u00020#2\u0012\u00108\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000609\"\u00020\u0006H\u0000¢\u0006\u0004\b:\u0010;J\r\u0010<\u001a\u00020#H\u0000¢\u0006\u0002\b=J\r\u0010>\u001a\u00020#H\u0000¢\u0006\u0002\b?J\u0010\u0010@\u001a\u00020#2\u0006\u0010A\u001a\u00020\bH\u0002J\b\u0010B\u001a\u00020#H\u0002J\u001d\u0010C\u001a\u00020#2\u0006\u0010A\u001a\u00020\b2\u0006\u0010D\u001a\u00020\u0018H\u0001¢\u0006\u0002\bEJ\b\u0010F\u001a\u000203H\u0002J=\u0010G\u001a\u00020#2\u0006\u0010-\u001a\u00020.2\b\u00101\u001a\u0004\u0018\u00010\u00062\u0006\u00102\u001a\u0002032\b\u0010$\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0006H\u0001¢\u0006\u0002\bHJ\u0017\u0010I\u001a\u00020#2\b\u0010J\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0002\bKJ\u0015\u0010L\u001a\u00020#2\u0006\u0010M\u001a\u000203H\u0000¢\u0006\u0002\bNJ\u0015\u0010O\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u0006H\u0000¢\u0006\u0002\bPJ\b\u0010Q\u001a\u00020#H\u0002J\r\u0010R\u001a\u00020#H\u0000¢\u0006\u0002\bSJ\u0015\u0010R\u001a\u00020#2\u0006\u0010T\u001a\u00020\u0006H\u0000¢\u0006\u0002\bSR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u001f\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006U"}, d2 = {"Lcom/taptap/sdk/db/event/utils/TapEventLogger;", "Lorg/koin/core/component/KoinComponent;", "()V", "LOCK", "Ljava/util/concurrent/locks/ReentrantLock;", "TAG", "", "applicationContext", "Landroid/content/Context;", "getApplicationContext$tap_db_release", "()Landroid/content/Context;", "setApplicationContext$tap_db_release", "(Landroid/content/Context;)V", "autoEventEnable", "Ljava/util/concurrent/atomic/AtomicBoolean;", "commonProperties", "Lorg/json/JSONObject;", "dynamicProperties", "Lcom/taptap/sdk/core/TapTapEvent$TapEventDynamicProperties;", "eventIndex", "", "generalParameter", "initialized", "sdkOptions", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "getSdkOptions", "()Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "setSdkOptions", "(Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;)V", "sessionUUID", "<set-?>", "userId", "getUserId$tap_db_release", "()Ljava/lang/String;", "addCommonProperties", "", TapEventParamConstants.PARAM_PROPERTIES, "addCommonProperties$tap_db_release", "addCommonProperty", e.a.b, e.a.d, "", "addCommonProperty$tap_db_release", "buildDeviceEventBean", "Lcom/taptap/sdk/db/event/model/TapEventBean;", "eventType", "Lcom/taptap/sdk/db/event/model/TapEventType;", "eventProperties", "buildTrackEventBean", "eventName", "isAutomatically", "", "buildUserEventBean", "clearAllCommonProperties", "clearAllCommonProperties$tap_db_release", "clearCommonProperties", "keys", "", "clearCommonProperties$tap_db_release", "([Ljava/lang/String;)V", "clearUser", "clearUser$tap_db_release", "flush", "flush$tap_db_release", "initGeneralParameter", "context", "initSecretParameter", "initialize", "option", "initialize$tap_db_release", "isInitialized", "logEventInner", "logEventInner$tap_db_release", "registerDynamicProperties", "eventDynamicProperties", "registerDynamicProperties$tap_db_release", "setAutoEventEnable", "enable", "setAutoEventEnable$tap_db_release", "setUserId", "setUserId$tap_db_release", "validateInitialized", "validateUserId", "validateUserId$tap_db_release", "methodName", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapEventLogger implements KoinComponent {
    private static final String TAG = "TapEventLogger";
    public static Context applicationContext;
    private static final JSONObject commonProperties;
    private static TapTapEvent.TapEventDynamicProperties dynamicProperties;
    private static long eventIndex;
    public static TapTapSdkOptions sdkOptions;
    private static final String sessionUUID;
    private static String userId;
    public static final TapEventLogger INSTANCE = new TapEventLogger();
    private static final ReentrantLock LOCK = new ReentrantLock();
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    private static final AtomicBoolean autoEventEnable = new AtomicBoolean(false);
    private static final JSONObject generalParameter = new JSONObject();

    /* JADX INFO: compiled from: TapEventLogger.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TapEventType.values().length];
            try {
                iArr[TapEventType.TRACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TapEventType.DEVICE_INITIALISE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TapEventType.DEVICE_UPDATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TapEventType.DEVICE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TapEventType.USER_INITIALISE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TapEventType.USER_UPDATE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TapEventType.USER_ADD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final void logEventInner$tap_db_release(TapEventType eventType, String str, boolean z, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        logEventInner$tap_db_release$default(this, eventType, str, z, jSONObject, null, 16, null);
    }

    private TapEventLogger() {
    }

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    static {
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        sessionUUID = string;
        commonProperties = new JSONObject();
    }

    public final TapTapSdkOptions getSdkOptions() {
        TapTapSdkOptions tapTapSdkOptions = sdkOptions;
        if (tapTapSdkOptions != null) {
            return tapTapSdkOptions;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sdkOptions");
        return null;
    }

    public final void setSdkOptions(TapTapSdkOptions tapTapSdkOptions) {
        Intrinsics.checkNotNullParameter(tapTapSdkOptions, "<set-?>");
        sdkOptions = tapTapSdkOptions;
    }

    public final Context getApplicationContext$tap_db_release() {
        Context context = applicationContext;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
        return null;
    }

    public final void setApplicationContext$tap_db_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        applicationContext = context;
    }

    public final String getUserId$tap_db_release() {
        return userId;
    }

    @JvmStatic
    public static final synchronized void initialize$tap_db_release(Context context, TapTapSdkOptions option) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(option, "option");
        if (initialized.compareAndSet(false, true)) {
            TapLogger.logi(TapLogger.TAG, "TapEvent initialize start");
            TapEventLogger tapEventLogger = INSTANCE;
            tapEventLogger.setApplicationContext$tap_db_release(context);
            tapEventLogger.setSdkOptions(option);
            tapEventLogger.initGeneralParameter(context);
            tapEventLogger.initSecretParameter();
            TapPlayGameDurationTracker.INSTANCE.initializeIfNotInitialized();
            TapLogger.logi(TapLogger.TAG, "TapEvent initialize end");
        }
    }

    public static /* synthetic */ void logEventInner$tap_db_release$default(TapEventLogger tapEventLogger, TapEventType tapEventType, String str, boolean z, JSONObject jSONObject, String str2, int i, Object obj) {
        if ((i & 16) != 0) {
            str2 = userId;
        }
        tapEventLogger.logEventInner$tap_db_release(tapEventType, str, z, jSONObject, str2);
    }

    public final void logEventInner$tap_db_release(final TapEventType eventType, final String eventName, final boolean isAutomatically, final JSONObject properties, final String userId2) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        validateInitialized();
        TapLogger.logd(TAG, "logEventInner eventType = " + eventType + " , eventName = " + eventName + " , properties = \n" + properties);
        TapEventQueue.singleThreadExecutor.execute(new Runnable() { // from class: com.taptap.sdk.db.event.utils.TapEventLogger$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                TapEventLogger.logEventInner$lambda$0(eventType, eventName, userId2, isAutomatically, properties);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void logEventInner$lambda$0(TapEventType eventType, String str, String str2, boolean z, JSONObject jSONObject) {
        TapEventBean tapEventBeanBuildTrackEventBean;
        Intrinsics.checkNotNullParameter(eventType, "$eventType");
        try {
            switch (WhenMappings.$EnumSwitchMapping$0[eventType.ordinal()]) {
                case 1:
                    tapEventBeanBuildTrackEventBean = INSTANCE.buildTrackEventBean(eventType, str, str2, z, jSONObject);
                    break;
                case 2:
                case 3:
                case 4:
                    tapEventBeanBuildTrackEventBean = INSTANCE.buildDeviceEventBean(eventType, jSONObject);
                    break;
                case 5:
                case 6:
                case 7:
                    tapEventBeanBuildTrackEventBean = INSTANCE.buildUserEventBean(eventType, str2, jSONObject);
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            String str3 = str;
            TapLogger.logi(TapLogger.TAG, "TapEvent insert event waiting to be send , eventType[" + eventType + AbstractJsonLexerKt.END_LIST + (!(str3 == null || str3.length() == 0) ? " eventName[" + str + AbstractJsonLexerKt.END_LIST : "") + '.');
            TapEventQueue.add(tapEventBeanBuildTrackEventBean);
        } catch (Exception e) {
            TapLogger.loge$default(TAG, null, e, 2, null);
        }
    }

    public final void flush$tap_db_release() {
        validateInitialized();
        TapLogger.logd(TAG, "flush");
        TapEventQueue.INSTANCE.flush$tap_db_release();
    }

    public final void setAutoEventEnable$tap_db_release(boolean enable) {
        AtomicBoolean atomicBoolean = autoEventEnable;
        if (atomicBoolean.get() == enable) {
            return;
        }
        atomicBoolean.set(enable);
        TapLogger.logd(TAG, "autoEventEnable = " + enable);
        TapPlayGameDurationTracker.INSTANCE.setAutoEventEnable(enable);
        if (getSdkOptions().getRegion() == 1 && enable && getSdkOptions().getAutoIAPEventEnabled()) {
            TapLogger.logd(TAG, "InAppPurchaseManager setEnable true");
            InAppPurchaseManager.setEnableAutoLogging(true);
        }
        TapLogger.logi(TapLogger.TAG, "TapEvent setAutoEventEnable = " + enable);
    }

    public final void setUserId$tap_db_release(String userId2) {
        Intrinsics.checkNotNullParameter(userId2, "userId");
        validateInitialized();
        ReentrantLock reentrantLock = LOCK;
        reentrantLock.lock();
        try {
            TapLogger.logd(TAG, "setUserId = " + userId2);
            userId = userId2;
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void clearUser$tap_db_release() {
        validateInitialized();
        ReentrantLock reentrantLock = LOCK;
        reentrantLock.lock();
        try {
            TapLogger.logd(TAG, "clearUser");
            userId = null;
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void addCommonProperty$tap_db_release(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        validateInitialized();
        ReentrantLock reentrantLock = LOCK;
        reentrantLock.lock();
        try {
            TapLogger.logd(TAG, "addCommonProperty key = " + key + ", value = " + value);
            TapEventParameterKitKt.putProperty(commonProperties, key, value);
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void addCommonProperties$tap_db_release(JSONObject properties) {
        validateInitialized();
        ReentrantLock reentrantLock = LOCK;
        reentrantLock.lock();
        try {
            TapLogger.logd(TAG, "addCommonProperties = \n" + properties);
            TapCoreKit.INSTANCE.filterProperties("addCommonProperties Error", properties);
            TapEventParameterKitKt.putProperties(commonProperties, properties, true);
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void clearCommonProperties$tap_db_release(String... keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        validateInitialized();
        ReentrantLock reentrantLock = LOCK;
        reentrantLock.lock();
        try {
            TapLogger.logd(TAG, "clearCommonProperty = " + CollectionsKt.listOf(Arrays.copyOf(keys, keys.length)));
            for (String str : keys) {
                commonProperties.remove(str);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void clearAllCommonProperties$tap_db_release() {
        validateInitialized();
        ReentrantLock reentrantLock = LOCK;
        reentrantLock.lock();
        try {
            TapLogger.logd(TAG, "clearAllCommonProperties");
            Iterator<String> keys = commonProperties.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "keys");
            while (keys.hasNext()) {
                keys.next();
                keys.remove();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void registerDynamicProperties$tap_db_release(TapTapEvent.TapEventDynamicProperties eventDynamicProperties) {
        validateInitialized();
        ReentrantLock reentrantLock = LOCK;
        reentrantLock.lock();
        try {
            TapLogger.logd(TAG, "registerDynamicProperties");
            dynamicProperties = eventDynamicProperties;
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void initGeneralParameter(Context context) {
        TapEventParameterKit tapEventParameterKit = TapEventParameterKit.INSTANCE;
        JSONObject jSONObject = generalParameter;
        tapEventParameterKit.fillingGeneralParameter(context, jSONObject);
        TapLogger.logd(TAG, "init generalParameter = \n" + jSONObject);
    }

    private final void initSecretParameter() {
        int region = getSdkOptions().getRegion();
        if (region == 0) {
            TapIdentifierUtil.INSTANCE.queryOAID(new Function1<String, Unit>() { // from class: com.taptap.sdk.db.event.utils.TapEventLogger.initSecretParameter.2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    TapLogger.logd(TapEventLogger.TAG, "TapOAIDUtil.queryOAID = " + str);
                }
            });
        } else {
            if (region != 1) {
                return;
            }
            TapIdentifierUtil.INSTANCE.queryGAID(new Function1<TapIdentifierUtil.GAID, Unit>() { // from class: com.taptap.sdk.db.event.utils.TapEventLogger.initSecretParameter.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TapIdentifierUtil.GAID gaid) {
                    invoke2(gaid);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TapIdentifierUtil.GAID gaid) {
                    TapLogger.logd(TapEventLogger.TAG, "TapGAIDUtil.queryGAID = " + gaid);
                }
            });
        }
    }

    private final TapEventBean buildUserEventBean(TapEventType eventType, String userId2, JSONObject eventProperties) throws Exception {
        TapCoreKit.assertIsNotMainThread();
        JSONObject jSONObject = new JSONObject();
        TapEventParameterKitKt.putProperty(jSONObject, "type", eventType.getType());
        TapEventParameterKitKt.putProperty(jSONObject, TapEventParamConstants.PARAM_CLIENT_ID, getSdkOptions().getClientId());
        TapEventParameterKitKt.putProperty(jSONObject, "user_id", userId2);
        JSONObject jSONObjectObtainJSONObject = TapEventParameterKitKt.obtainJSONObject(jSONObject, TapEventParamConstants.PARAM_PROPERTIES);
        TapEventParameterKitKt.putProperty(jSONObjectObtainJSONObject, "sdk_version", "4.5.0");
        TapCoreKit.INSTANCE.filterProperties("UserEvent[" + eventType + "] Properties Error", eventProperties);
        TapEventParameterKitKt.putProperties(jSONObjectObtainJSONObject, eventProperties, true);
        return new TapEventBean(eventType.getType(), null, jSONObject);
    }

    private final TapEventBean buildDeviceEventBean(TapEventType eventType, JSONObject eventProperties) throws Exception {
        TapCoreKit.assertIsNotMainThread();
        JSONObject jSONObject = new JSONObject();
        TapEventParameterKitKt.putProperty(jSONObject, "type", eventType.getType());
        TapEventParameterKitKt.putProperty(jSONObject, TapEventParamConstants.PARAM_CLIENT_ID, getSdkOptions().getClientId());
        TapEventParameterKitKt.putProperty(jSONObject, TapEventParamConstants.PARAM_DEVICE_ID, TapIdentifierUtil.INSTANCE.getDeviceId(getApplicationContext$tap_db_release()));
        JSONObject jSONObjectObtainJSONObject = TapEventParameterKitKt.obtainJSONObject(jSONObject, TapEventParamConstants.PARAM_PROPERTIES);
        TapEventParameterKitKt.putProperty(jSONObjectObtainJSONObject, "sdk_version", "4.5.0");
        TapCoreKit.INSTANCE.filterProperties("DeviceEvent[" + eventType + "] Properties Error", eventProperties);
        TapEventParameterKitKt.putProperties(jSONObjectObtainJSONObject, eventProperties, true);
        return new TapEventBean(eventType.getType(), null, jSONObject);
    }

    private final TapEventBean buildTrackEventBean(TapEventType eventType, String eventName, String userId2, boolean isAutomatically, JSONObject eventProperties) throws Exception {
        TapCoreKit.assertIsNotMainThread();
        TapCoreKit.assertEventName(eventName);
        JSONObject jSONObject = new JSONObject();
        TapEventParameterKitKt.putProperty(jSONObject, "type", eventType.getType());
        TapEventParameterKitKt.putProperty(jSONObject, TapEventParamConstants.PARAM_NAME, eventName);
        TapEventParameterKitKt.putProperty(jSONObject, TapEventParamConstants.PARAM_CLIENT_ID, getSdkOptions().getClientId());
        TapEventParameterKitKt.putProperty(jSONObject, TapEventParamConstants.PARAM_DEVICE_ID, TapIdentifierUtil.INSTANCE.getDeviceId(getApplicationContext$tap_db_release()));
        TapEventParameterKitKt.putProperty(jSONObject, "user_id", userId2);
        JSONObject jSONObjectObtainJSONObject = TapEventParameterKitKt.obtainJSONObject(jSONObject, TapEventParamConstants.PARAM_PROPERTIES);
        TapEventParameterKitKt.putProperties$default(jSONObjectObtainJSONObject, generalParameter, false, 2, null);
        String strQueryGID = TapIdentifierUtil.INSTANCE.queryGID();
        if (strQueryGID == null) {
            strQueryGID = "";
        }
        TapEventParameterKitKt.putProperty(jSONObjectObtainJSONObject, TapEventParamConstants.PARAM_SUB_GID, strQueryGID);
        int region = getSdkOptions().getRegion();
        if (region == 0) {
            TapEventParameterKitKt.putProperty(jSONObjectObtainJSONObject, "oaid", TapIdentifierUtil.INSTANCE.getOAID());
        } else if (region == 1) {
            TapIdentifierUtil.GAID gaid = TapIdentifierUtil.INSTANCE.getGAID();
            TapEventParameterKitKt.putProperty(jSONObjectObtainJSONObject, TapEventParamConstants.PARAM_SUB_DEVICE_ID2, gaid != null ? gaid.getAndroidAdvertiserIdValue() : null);
        }
        TapEventParameterKitKt.putProperty(jSONObjectObtainJSONObject, "open_id", TapIdentifierUtil.INSTANCE.getOpenId());
        TapEventParameterKitKt.putProperty(jSONObjectObtainJSONObject, "android_id", TapIdentifierUtil.getAndroidID(getApplicationContext$tap_db_release()));
        TapEventParameterKitKt.putProperty(jSONObjectObtainJSONObject, TapEventParamConstants.PARAM_SUB_T_LOG_ID, UUID.randomUUID().toString());
        TapEventParameterKitKt.putProperty(jSONObjectObtainJSONObject, TapEventParamConstants.PARAM_SUB_SESSION_UUID, sessionUUID);
        TapEventParameterKitKt.putProperty(jSONObjectObtainJSONObject, TapEventParamConstants.PARAM_SUB_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
        long j = eventIndex + 1;
        eventIndex = j;
        TapEventParameterKitKt.putProperty(jSONObjectObtainJSONObject, TapEventParamConstants.PARAM_SUB_EVENT_INDEX, Long.valueOf(j));
        if (isAutomatically) {
            TapEventParameterKitKt.putProperty(jSONObjectObtainJSONObject, TapEventParamConstants.PARAM_SUB_IS_AUTOMATICALLY_LOG, true);
        }
        JSONObject jSONObject2 = new JSONObject();
        TapEventParameterKitKt.putProperties(jSONObject2, commonProperties, true);
        TapTapEvent.TapEventDynamicProperties tapEventDynamicProperties = dynamicProperties;
        JSONObject dynamicProperties2 = tapEventDynamicProperties != null ? tapEventDynamicProperties.getDynamicProperties() : null;
        TapCoreKit.INSTANCE.filterProperties("Event[" + eventName + "] dynamicProperties Error", dynamicProperties2);
        TapEventParameterKitKt.putProperties(jSONObject2, dynamicProperties2, true);
        TapCoreKit.INSTANCE.filterProperties("Event[" + eventName + "] Properties Error", eventProperties);
        TapEventParameterKitKt.putProperties(jSONObject2, eventProperties, true);
        if (getSdkOptions().getOverrideBuiltInParameters()) {
            TapEventParameterKitKt.putProperties(jSONObjectObtainJSONObject, jSONObject2, true);
        } else {
            TapEventParameterKitKt.putProperties(jSONObjectObtainJSONObject, jSONObject2, false);
        }
        return new TapEventBean(eventType.getType(), eventName, jSONObject);
    }

    private final void validateInitialized() {
        if (!isInitialized()) {
            throw new TapSdkNotInitializedException("The TapEvent has not been initialized successfully, Please call TapTapSdk.init to initialize before calling.");
        }
    }

    private final boolean isInitialized() {
        return initialized.get();
    }

    public final void validateUserId$tap_db_release() {
        String str = userId;
        if (str == null || str.length() == 0) {
            throw new TapSdkException("TapTapEvent setUser method not called, please call setUser method first");
        }
    }

    public final void validateUserId$tap_db_release(String methodName) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        String str = userId;
        if (str == null || str.length() == 0) {
            throw new TapSdkException(methodName + " method called error, TapEvent.setUser method not called, please call setUser method first.");
        }
    }
}
