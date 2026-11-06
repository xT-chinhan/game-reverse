package com.taptap.sdk.openlog;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.taptap.sdk.initializer.api.option.TapTapSdkOptions;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.openlog.ITapOpenlog;
import com.taptap.sdk.kit.internal.utils.TapActivityLifecycleCallbacks;
import com.taptap.sdk.kit.internal.utils.TapActivityLifecycleTracker;
import com.taptap.sdk.openlog.internal.OpenLogImpl;
import com.taptap.sdk.openlog.internal.TapOpenLogRemote;
import com.taptap.sdk.openlog.utils.JsonUtils;
import com.taptap.sdk.openlog.utils.OpenlogExtrasUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.json.JSONArray;

/* JADX INFO: compiled from: TapTapOpenlogSdk.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004*\u0001\u0004\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H\u0002J\u0016\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u000eJ\u0006\u0010\n\u001a\u00020\u000eJ\b\u0010\u0017\u001a\u00020\fH\u0002J\u0010\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\u001a\u001a\u00020\fJ\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007J\u000e\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u0007J\u001c\u0010\u001f\u001a\u00020\f2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\"J\b\u0010#\u001a\u00020\fH\u0002J\b\u0010$\u001a\u00020\fH\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/taptap/sdk/openlog/TapTapOpenlogSdk;", "", "()V", "activityLifecycleCallbacks", "com/taptap/sdk/openlog/TapTapOpenlogSdk$activityLifecycleCallbacks$1", "Lcom/taptap/sdk/openlog/TapTapOpenlogSdk$activityLifecycleCallbacks$1;", "currentOpenId", "", "heartbeatEnabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isHeartbeatStarted", "enableHeartbeat", "", "enabled", "", "getWhiteList", "", "initialize", "ctx", "Landroid/content/Context;", "options", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "isHeartbeatEnabled", "loadNativeLibrary", "login", "openId", "logout", "obtainOpenlog", "Lcom/taptap/sdk/kit/internal/openlog/ITapOpenlog;", "project", "version", "setExtraAppDurationParams", "jsonStr", "extras", "", "start", "stop", "Companion", "tap-openlog_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapTapOpenlogSdk {
    private static final String TAG = "OpenLogInitializer";
    private String currentOpenId;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ReadWriteProperty<Object, Context> context$delegate = Delegates.INSTANCE.notNull();
    private static final ReadWriteProperty<Object, Integer> region$delegate = Delegates.INSTANCE.notNull();
    private static final ReadWriteProperty<Object, String> clientId$delegate = Delegates.INSTANCE.notNull();
    private static final ReadWriteProperty<Object, String> clientToken$delegate = Delegates.INSTANCE.notNull();
    private final AtomicBoolean isHeartbeatStarted = new AtomicBoolean(false);
    private final AtomicBoolean heartbeatEnabled = new AtomicBoolean(false);
    private final TapTapOpenlogSdk$activityLifecycleCallbacks$1 activityLifecycleCallbacks = new TapActivityLifecycleCallbacks() { // from class: com.taptap.sdk.openlog.TapTapOpenlogSdk$activityLifecycleCallbacks$1
        @Override // com.taptap.sdk.kit.internal.utils.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            TapActivityLifecycleCallbacks.DefaultImpls.onActivityCreated(this, activity, bundle);
        }

        @Override // com.taptap.sdk.kit.internal.utils.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            TapActivityLifecycleCallbacks.DefaultImpls.onActivityDestroyed(this, activity);
        }

        @Override // com.taptap.sdk.kit.internal.utils.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            TapActivityLifecycleCallbacks.DefaultImpls.onActivityPaused(this, activity);
        }

        @Override // com.taptap.sdk.kit.internal.utils.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            TapActivityLifecycleCallbacks.DefaultImpls.onActivityResumed(this, activity);
        }

        @Override // com.taptap.sdk.kit.internal.utils.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            TapActivityLifecycleCallbacks.DefaultImpls.onActivitySaveInstanceState(this, activity, bundle);
        }

        @Override // com.taptap.sdk.kit.internal.utils.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            TapActivityLifecycleCallbacks.DefaultImpls.onActivityStarted(this, activity);
        }

        @Override // com.taptap.sdk.kit.internal.utils.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            TapActivityLifecycleCallbacks.DefaultImpls.onActivityStopped(this, activity);
        }

        @Override // com.taptap.sdk.kit.internal.utils.TapActivityLifecycleCallbacks
        public void onForeground(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            TapActivityLifecycleCallbacks.DefaultImpls.onForeground(this, context);
            if (this.this$0.isHeartbeatEnabled()) {
                TapOpenLogRemote.INSTANCE.onForeground();
            }
        }

        @Override // com.taptap.sdk.kit.internal.utils.TapActivityLifecycleCallbacks
        public void onBackground(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            TapActivityLifecycleCallbacks.DefaultImpls.onBackground(this, context);
            if (this.this$0.isHeartbeatEnabled()) {
                TapOpenLogRemote.INSTANCE.onBackground();
            }
        }
    };

    public final void initialize(Context ctx, TapTapSdkOptions options) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(options, "options");
        Companion companion = INSTANCE;
        companion.setContext$tap_openlog_release(ctx);
        companion.setRegion$tap_openlog_release(options.getRegion());
        companion.setClientId$tap_openlog_release(options.getClientId());
        companion.setClientToken$tap_openlog_release(options.getClientToken());
        loadNativeLibrary();
        TapOpenLogRemote.INSTANCE.onAppStarted(JsonUtils.INSTANCE.stringify(OpenlogExtrasUtils.INSTANCE.getConfig(companion.getContext$tap_openlog_release())));
    }

    private final void loadNativeLibrary() {
        try {
            System.loadLibrary("tapsdkcore");
            TapLogger.logd(TAG, "initialize end");
        } catch (Throwable th) {
            TapLogger.loge(TAG, "initialize failure", th);
        }
    }

    public final void enableHeartbeat(boolean enabled) {
        if (isHeartbeatEnabled() == enabled) {
            return;
        }
        this.heartbeatEnabled.set(enabled);
        if (enabled) {
            start();
        } else {
            stop();
        }
    }

    private final void start() {
        if (!isHeartbeatEnabled() || isHeartbeatStarted()) {
            return;
        }
        TapActivityLifecycleTracker.INSTANCE.registerActivityLifecycleCallbacks(this.activityLifecycleCallbacks);
        this.isHeartbeatStarted.set(TapOpenLogRemote.INSTANCE.onAppStarted(JsonUtils.INSTANCE.stringify(OpenlogExtrasUtils.INSTANCE.getConfig(INSTANCE.getContext$tap_openlog_release()))) == 0);
        TapOpenLogRemote tapOpenLogRemote = TapOpenLogRemote.INSTANCE;
        String string = new JSONArray(new String[]{"app_duration"}).toString();
        Intrinsics.checkNotNullExpressionValue(string, "JSONArray(arrayOf(\"app_duration\")).toString()");
        tapOpenLogRemote.enableModules(string);
    }

    private final void stop() {
        TapActivityLifecycleTracker.INSTANCE.unregisterActivityLifecycleCallbacks(this.activityLifecycleCallbacks);
        this.isHeartbeatStarted.set(false);
        TapOpenLogRemote tapOpenLogRemote = TapOpenLogRemote.INSTANCE;
        String string = new JSONArray(new String[]{"app_duration"}).toString();
        Intrinsics.checkNotNullExpressionValue(string, "JSONArray(arrayOf(\"app_duration\")).toString()");
        tapOpenLogRemote.disableModules(string);
    }

    public final boolean isHeartbeatStarted() {
        return this.isHeartbeatStarted.get();
    }

    public final boolean isHeartbeatEnabled() {
        return this.heartbeatEnabled.get();
    }

    public final void login(String openId) {
        String str = openId;
        if (str == null || str.length() == 0) {
            TapLogger.logd(TAG, "openId 非法, openId = " + openId);
        } else if (Intrinsics.areEqual(this.currentOpenId, openId)) {
            TapLogger.logd(TAG, "openId 与当前一致 currentOpenId = " + this.currentOpenId + " , openId = " + openId);
        } else {
            this.currentOpenId = openId;
            TapOpenLogRemote.INSTANCE.onLogin(JsonUtils.INSTANCE.stringify(MapsKt.mapOf(TuplesKt.to("open_id", openId))));
        }
    }

    public final void logout() {
        this.currentOpenId = null;
        TapOpenLogRemote.INSTANCE.onLogout();
    }

    public final void setExtraAppDurationParams(Map<String, ? extends Object> extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        TapOpenLogRemote.INSTANCE.setExtraAppDurationParams(JsonUtils.INSTANCE.stringify(extras));
    }

    public final void setExtraAppDurationParams(String jsonStr) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        TapOpenLogRemote.INSTANCE.setExtraAppDurationParams(jsonStr);
    }

    public final ITapOpenlog obtainOpenlog(String project, String version) {
        Intrinsics.checkNotNullParameter(project, "project");
        Intrinsics.checkNotNullParameter(version, "version");
        if (getWhiteList().contains(project)) {
            return new OpenLogImpl(project, version);
        }
        return null;
    }

    private final List<String> getWhiteList() {
        TapSdkProject[] tapSdkProjectArrValues = TapSdkProject.values();
        ArrayList arrayList = new ArrayList(tapSdkProjectArrValues.length);
        for (TapSdkProject tapSdkProject : tapSdkProjectArrValues) {
            arrayList.add(tapSdkProject.getValue());
        }
        return CollectionsKt.toList(arrayList);
    }

    /* JADX INFO: compiled from: TapTapOpenlogSdk.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R+\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\nR+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00118@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R+\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00188@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/taptap/sdk/openlog/TapTapOpenlogSdk$Companion;", "", "()V", "TAG", "", "<set-?>", "clientId", "getClientId$tap_openlog_release", "()Ljava/lang/String;", "setClientId$tap_openlog_release", "(Ljava/lang/String;)V", "clientId$delegate", "Lkotlin/properties/ReadWriteProperty;", "clientToken", "getClientToken$tap_openlog_release", "setClientToken$tap_openlog_release", "clientToken$delegate", "Landroid/content/Context;", "context", "getContext$tap_openlog_release", "()Landroid/content/Context;", "setContext$tap_openlog_release", "(Landroid/content/Context;)V", "context$delegate", "", "region", "getRegion$tap_openlog_release", "()I", "setRegion$tap_openlog_release", "(I)V", "region$delegate", "tap-openlog_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(Companion.class, "context", "getContext$tap_openlog_release()Landroid/content/Context;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Companion.class, "region", "getRegion$tap_openlog_release()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Companion.class, "clientId", "getClientId$tap_openlog_release()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Companion.class, "clientToken", "getClientToken$tap_openlog_release()Ljava/lang/String;", 0))};

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Context getContext$tap_openlog_release() {
            return (Context) TapTapOpenlogSdk.context$delegate.getValue(this, $$delegatedProperties[0]);
        }

        public final void setContext$tap_openlog_release(Context context) {
            Intrinsics.checkNotNullParameter(context, "<set-?>");
            TapTapOpenlogSdk.context$delegate.setValue(this, $$delegatedProperties[0], context);
        }

        public final int getRegion$tap_openlog_release() {
            return ((Number) TapTapOpenlogSdk.region$delegate.getValue(this, $$delegatedProperties[1])).intValue();
        }

        public final void setRegion$tap_openlog_release(int i) {
            TapTapOpenlogSdk.region$delegate.setValue(this, $$delegatedProperties[1], Integer.valueOf(i));
        }

        public final String getClientId$tap_openlog_release() {
            return (String) TapTapOpenlogSdk.clientId$delegate.getValue(this, $$delegatedProperties[2]);
        }

        public final void setClientId$tap_openlog_release(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            TapTapOpenlogSdk.clientId$delegate.setValue(this, $$delegatedProperties[2], str);
        }

        public final String getClientToken$tap_openlog_release() {
            return (String) TapTapOpenlogSdk.clientToken$delegate.getValue(this, $$delegatedProperties[3]);
        }

        public final void setClientToken$tap_openlog_release(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            TapTapOpenlogSdk.clientToken$delegate.setValue(this, $$delegatedProperties[3], str);
        }
    }
}
