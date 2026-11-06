package com.taptap.sdk.openlog;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks;
import com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleTracker;
import com.taptap.sdk.initializer.api.model.RegionType;
import com.taptap.sdk.initializer.api.option.TapTapSdkOptions;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.openlog.ITapOpenlog;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.taptap.sdk.openlog.internal.OpenLogImpl;
import com.taptap.sdk.openlog.internal.TapOpenLogRemote;
import com.taptap.sdk.openlog.model.OpenLogConfig;
import com.taptap.sdk.openlog.model.UserLoginInfo;
import com.taptap.sdk.openlog.utils.OpenlogExtrasUtils;
import com.taptap.sdk.openlog.utils.SerializeUtils;
import com.umeng.analytics.pro.d;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.modules.SerializersModule;
import org.json.JSONArray;

/* JADX INFO: compiled from: TapTapOpenlogSdk.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003*\u0001\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001cJ\u0016\u00100\u001a\u00020.2\u0006\u00101\u001a\u00020\u00142\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u00020\u001cJ\u0006\u0010%\u001a\u00020\u001cJ\b\u00105\u001a\u00020.H\u0002J\u0010\u00106\u001a\u00020.2\b\u00107\u001a\u0004\u0018\u00010\u0004J\u0006\u00108\u001a\u00020.J\u0018\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u0004J\u000e\u0010=\u001a\u00020.2\u0006\u0010>\u001a\u00020\u0004J\u001c\u0010=\u001a\u00020.2\u0014\u0010?\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010@J\b\u0010A\u001a\u00020.H\u0002J\b\u0010B\u001a\u00020.H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R+\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00048@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR+\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00048@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00148@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\u001c8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u000f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010'\u001a\u00020&2\u0006\u0010\b\u001a\u00020&8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b,\u0010\u000f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006C"}, d2 = {"Lcom/taptap/sdk/openlog/TapTapOpenlogSdk;", "", "()V", "TAG", "", "activityLifecycleCallbacks", "com/taptap/sdk/openlog/TapTapOpenlogSdk$activityLifecycleCallbacks$1", "Lcom/taptap/sdk/openlog/TapTapOpenlogSdk$activityLifecycleCallbacks$1;", "<set-?>", "clientId", "getClientId$tap_core_release", "()Ljava/lang/String;", "setClientId$tap_core_release", "(Ljava/lang/String;)V", "clientId$delegate", "Lkotlin/properties/ReadWriteProperty;", "clientToken", "getClientToken$tap_core_release", "setClientToken$tap_core_release", "clientToken$delegate", "Landroid/content/Context;", d.R, "getContext$tap_core_release", "()Landroid/content/Context;", "setContext$tap_core_release", "(Landroid/content/Context;)V", "context$delegate", "currentOpenId", "", "enableLog", "getEnableLog$tap_core_release", "()Z", "setEnableLog$tap_core_release", "(Z)V", "enableLog$delegate", "heartbeatEnabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isHeartbeatStarted", "Lcom/taptap/sdk/initializer/api/model/RegionType;", "region", "getRegion$tap_core_release", "()Lcom/taptap/sdk/initializer/api/model/RegionType;", "setRegion$tap_core_release", "(Lcom/taptap/sdk/initializer/api/model/RegionType;)V", "region$delegate", "enableHeartbeat", "", "enabled", "initialize", "ctx", "options", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "isHeartbeatEnabled", "loadNativeLibrary", "login", "openId", "logout", "obtainOpenlog", "Lcom/taptap/sdk/kit/internal/openlog/ITapOpenlog;", "project", "version", "setExtraAppDurationParams", "jsonStr", "extras", "", TrackAction.START, "stop", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapTapOpenlogSdk {
    private static final String TAG = "OpenLogInitializeTask";
    private static String currentOpenId;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(TapTapOpenlogSdk.class, d.R, "getContext$tap_core_release()Landroid/content/Context;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TapTapOpenlogSdk.class, "region", "getRegion$tap_core_release()Lcom/taptap/sdk/initializer/api/model/RegionType;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TapTapOpenlogSdk.class, "clientId", "getClientId$tap_core_release()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TapTapOpenlogSdk.class, "clientToken", "getClientToken$tap_core_release()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TapTapOpenlogSdk.class, "enableLog", "getEnableLog$tap_core_release()Z", 0))};
    public static final TapTapOpenlogSdk INSTANCE = new TapTapOpenlogSdk();

    /* JADX INFO: renamed from: context$delegate, reason: from kotlin metadata */
    private static final ReadWriteProperty context = Delegates.INSTANCE.notNull();

    /* JADX INFO: renamed from: region$delegate, reason: from kotlin metadata */
    private static final ReadWriteProperty region = Delegates.INSTANCE.notNull();

    /* JADX INFO: renamed from: clientId$delegate, reason: from kotlin metadata */
    private static final ReadWriteProperty clientId = Delegates.INSTANCE.notNull();

    /* JADX INFO: renamed from: clientToken$delegate, reason: from kotlin metadata */
    private static final ReadWriteProperty clientToken = Delegates.INSTANCE.notNull();

    /* JADX INFO: renamed from: enableLog$delegate, reason: from kotlin metadata */
    private static final ReadWriteProperty enableLog = Delegates.INSTANCE.notNull();
    private static final AtomicBoolean isHeartbeatStarted = new AtomicBoolean(false);
    private static final AtomicBoolean heartbeatEnabled = new AtomicBoolean(false);
    private static final TapTapOpenlogSdk$activityLifecycleCallbacks$1 activityLifecycleCallbacks = new TapActivityLifecycleCallbacks() { // from class: com.taptap.sdk.openlog.TapTapOpenlogSdk$activityLifecycleCallbacks$1
        @Override // com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            TapActivityLifecycleCallbacks.DefaultImpls.onActivityCreated(this, activity, savedInstanceState);
        }

        @Override // com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            TapActivityLifecycleCallbacks.DefaultImpls.onActivityDestroyed(this, activity);
        }

        @Override // com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            TapActivityLifecycleCallbacks.DefaultImpls.onActivityPaused(this, activity);
        }

        @Override // com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            TapActivityLifecycleCallbacks.DefaultImpls.onActivityResumed(this, activity);
        }

        @Override // com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            TapActivityLifecycleCallbacks.DefaultImpls.onActivitySaveInstanceState(this, activity, outState);
        }

        @Override // com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            TapActivityLifecycleCallbacks.DefaultImpls.onActivityStarted(this, activity);
        }

        @Override // com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            TapActivityLifecycleCallbacks.DefaultImpls.onActivityStopped(this, activity);
        }

        @Override // com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks
        public void onForeground(Context context2) {
            Intrinsics.checkNotNullParameter(context2, "context");
            TapActivityLifecycleCallbacks.DefaultImpls.onForeground(this, context2);
            if (TapTapOpenlogSdk.INSTANCE.isHeartbeatEnabled()) {
                TapOpenLogRemote.INSTANCE.onForeground();
            }
        }

        @Override // com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks
        public void onBackground(Context context2) {
            Intrinsics.checkNotNullParameter(context2, "context");
            TapActivityLifecycleCallbacks.DefaultImpls.onBackground(this, context2);
            if (TapTapOpenlogSdk.INSTANCE.isHeartbeatEnabled()) {
                TapOpenLogRemote.INSTANCE.onBackground();
            }
        }
    };

    private TapTapOpenlogSdk() {
    }

    public final Context getContext$tap_core_release() {
        return (Context) context.getValue(this, $$delegatedProperties[0]);
    }

    public final void setContext$tap_core_release(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        context.setValue(this, $$delegatedProperties[0], context2);
    }

    public final RegionType getRegion$tap_core_release() {
        return (RegionType) region.getValue(this, $$delegatedProperties[1]);
    }

    public final void setRegion$tap_core_release(RegionType regionType) {
        Intrinsics.checkNotNullParameter(regionType, "<set-?>");
        region.setValue(this, $$delegatedProperties[1], regionType);
    }

    public final String getClientId$tap_core_release() {
        return (String) clientId.getValue(this, $$delegatedProperties[2]);
    }

    public final void setClientId$tap_core_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        clientId.setValue(this, $$delegatedProperties[2], str);
    }

    public final String getClientToken$tap_core_release() {
        return (String) clientToken.getValue(this, $$delegatedProperties[3]);
    }

    public final void setClientToken$tap_core_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        clientToken.setValue(this, $$delegatedProperties[3], str);
    }

    public final boolean getEnableLog$tap_core_release() {
        return ((Boolean) enableLog.getValue(this, $$delegatedProperties[4])).booleanValue();
    }

    public final void setEnableLog$tap_core_release(boolean z) {
        enableLog.setValue(this, $$delegatedProperties[4], Boolean.valueOf(z));
    }

    public final void initialize(Context ctx, TapTapSdkOptions options) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(options, "options");
        setContext$tap_core_release(ctx);
        setRegion$tap_core_release(options.getRegion());
        setClientId$tap_core_release(options.getClientId());
        setClientToken$tap_core_release(options.getClientToken());
        setEnableLog$tap_core_release(options.getEnableLog());
        loadNativeLibrary();
        OpenLogConfig config = OpenlogExtrasUtils.INSTANCE.createConfig(getContext$tap_core_release(), getEnableLog$tap_core_release());
        TapOpenLogRemote.INSTANCE.setLogLevel(config.getLogLevel(), config.getLogToConsole(), config.getEnableAutoTestLog());
        SerializeUtils this_$iv = SerializeUtils.INSTANCE;
        StringFormat $this$encodeToString$iv$iv = this_$iv.getJson();
        SerializersModule $this$serializer$iv$iv$iv = $this$encodeToString$iv$iv.getSerializersModule();
        KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(OpenLogConfig.class));
        Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        String configString = $this$encodeToString$iv$iv.encodeToString(kSerializerSerializer, config);
        TapOpenLogRemote.INSTANCE.onAppStarted(configString);
    }

    private final void loadNativeLibrary() {
        try {
            System.loadLibrary("tapsdkcore");
            TapLogger.logd(TAG, "initialize end");
        } catch (Throwable e) {
            TapLogger.loge(TAG, "initialize failure", e);
        }
    }

    public final void enableHeartbeat(boolean enabled) {
        if (isHeartbeatEnabled() == enabled) {
            return;
        }
        heartbeatEnabled.set(enabled);
        if (!enabled) {
            stop();
        } else {
            start();
        }
    }

    private final void start() {
        if (!isHeartbeatEnabled() || isHeartbeatStarted()) {
            return;
        }
        TapActivityLifecycleTracker.INSTANCE.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        OpenLogConfig config = OpenlogExtrasUtils.INSTANCE.createConfig(getContext$tap_core_release(), getEnableLog$tap_core_release());
        TapOpenLogRemote.INSTANCE.setLogLevel(config.getLogLevel(), config.getLogToConsole(), config.getEnableAutoTestLog());
        AtomicBoolean atomicBoolean = isHeartbeatStarted;
        TapOpenLogRemote tapOpenLogRemote = TapOpenLogRemote.INSTANCE;
        SerializeUtils this_$iv = SerializeUtils.INSTANCE;
        StringFormat $this$encodeToString$iv$iv = this_$iv.getJson();
        SerializersModule $this$serializer$iv$iv$iv = $this$encodeToString$iv$iv.getSerializersModule();
        KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(OpenLogConfig.class));
        Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        atomicBoolean.set(tapOpenLogRemote.onAppStarted($this$encodeToString$iv$iv.encodeToString(kSerializerSerializer, config)) == 0);
        TapOpenLogRemote tapOpenLogRemote2 = TapOpenLogRemote.INSTANCE;
        String string = new JSONArray(new String[]{"app_duration"}).toString();
        Intrinsics.checkNotNullExpressionValue(string, "JSONArray(arrayOf(\"app_duration\")).toString()");
        tapOpenLogRemote2.enableModules(string);
    }

    private final void stop() {
        TapActivityLifecycleTracker.INSTANCE.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        isHeartbeatStarted.set(false);
        TapOpenLogRemote tapOpenLogRemote = TapOpenLogRemote.INSTANCE;
        String string = new JSONArray(new String[]{"app_duration"}).toString();
        Intrinsics.checkNotNullExpressionValue(string, "JSONArray(arrayOf(\"app_duration\")).toString()");
        tapOpenLogRemote.disableModules(string);
    }

    public final boolean isHeartbeatStarted() {
        return isHeartbeatStarted.get();
    }

    public final boolean isHeartbeatEnabled() {
        return heartbeatEnabled.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void login(String openId) {
        String str = openId;
        if (str == null || str.length() == 0) {
            TapLogger.logd(TAG, "openId 非法, openId = " + openId);
            return;
        }
        if (Intrinsics.areEqual(currentOpenId, openId)) {
            TapLogger.logd(TAG, "openId 与当前一致 currentOpenId = " + currentOpenId + " , openId = " + openId);
            return;
        }
        currentOpenId = openId;
        UserLoginInfo userLoginInfo = new UserLoginInfo(openId, (String) null, 2, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        TapOpenLogRemote tapOpenLogRemote = TapOpenLogRemote.INSTANCE;
        Json json = SerializeUtils.INSTANCE.getJson();
        KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(UserLoginInfo.class));
        Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        tapOpenLogRemote.onLogin(json.encodeToString(kSerializerSerializer, userLoginInfo));
    }

    public final void logout() {
        currentOpenId = null;
        TapOpenLogRemote.INSTANCE.onLogout();
    }

    public final void setExtraAppDurationParams(Map<String, ? extends Object> extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        TapOpenLogRemote.INSTANCE.setExtraAppDurationParams(SerializeUtils.INSTANCE.stringify(extras));
    }

    public final void setExtraAppDurationParams(String jsonStr) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        TapOpenLogRemote.INSTANCE.setExtraAppDurationParams(jsonStr);
    }

    public final ITapOpenlog obtainOpenlog(String project, String version) {
        Intrinsics.checkNotNullParameter(project, "project");
        Intrinsics.checkNotNullParameter(version, "version");
        return new OpenLogImpl(project, version);
    }
}
