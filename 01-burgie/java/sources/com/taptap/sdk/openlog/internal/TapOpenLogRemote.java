package com.taptap.sdk.openlog.internal;

import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.TapSdkFileLogger;
import com.taptap.sdk.openlog.TapTapOpenlogSdk;
import com.taptap.sdk.openlog.model.DynamicDeviceInfo;
import com.taptap.sdk.openlog.utils.OpenlogExtrasUtils;
import com.taptap.sdk.openlog.utils.SerializeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: TapOpenLogRemote.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0014\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086 J\u0011\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086 J\u0006\u0010\b\u001a\u00020\u0006J&\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006J\u0011\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0006H\u0086 J\t\u0010\u0011\u001a\u00020\u0004H\u0086 J\t\u0010\u0012\u001a\u00020\u0004H\u0086 J\t\u0010\u0013\u001a\u00020\u0004H\u0086 J\u0011\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0006H\u0086 J\t\u0010\u0016\u001a\u00020\u0004H\u0086 J\u0019\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0086 J\u0011\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0006H\u0086 J!\u0010\u001c\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0086 ¨\u0006\u001f"}, d2 = {"Lcom/taptap/sdk/openlog/internal/TapOpenLogRemote;", "", "()V", "disableModules", "", "modules", "", "enableModules", "getCommonVariables", "log", "logLevel", "", "codeLocation", "tag", "message", "onAppStarted", "configStr", "onAppStopped", "onBackground", "onForeground", "onLogin", "userInfo", "onLogout", "sendOpenlog", "logStore", "logContent", "setExtraAppDurationParams", "params", "setLogLevel", "logToConsole", "enableAutoTestLog", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapOpenLogRemote {
    public static final TapOpenLogRemote INSTANCE = new TapOpenLogRemote();

    public final native void disableModules(String modules);

    public final native void enableModules(String modules);

    public final native int onAppStarted(String configStr);

    public final native void onAppStopped();

    public final native void onBackground();

    public final native void onForeground();

    public final native void onLogin(String userInfo);

    public final native void onLogout();

    public final native void sendOpenlog(String logStore, String logContent);

    public final native void setExtraAppDurationParams(String params);

    public final native void setLogLevel(int logLevel, int logToConsole, int enableAutoTestLog);

    private TapOpenLogRemote() {
    }

    public final void log(int logLevel, String codeLocation, String tag, String message) {
        Intrinsics.checkNotNullParameter(codeLocation, "codeLocation");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        String logTag = "TapSDK-" + tag;
        String logMessage = AbstractJsonLexerKt.BEGIN_LIST + codeLocation + "] " + message;
        switch (logLevel) {
            case 1:
                TapLogger.logv(logTag, logMessage);
                break;
            case 2:
                TapLogger.logd(logTag, logMessage);
                break;
            case 3:
                TapLogger.logi(logTag, logMessage);
                break;
            case 4:
                TapLogger.logw(logTag, logMessage, false);
                break;
            default:
                TapLogger.loge$default(logTag, logMessage, null, 4, null);
                break;
        }
        TapSdkFileLogger.INSTANCE.writeLog(logLevel, codeLocation, tag, message);
    }

    public final String getCommonVariables() {
        SerializeUtils this_$iv = SerializeUtils.INSTANCE;
        DynamicDeviceInfo dynamicDeviceInfo = OpenlogExtrasUtils.INSTANCE.getDynamicDeviceInfo(TapTapOpenlogSdk.INSTANCE.getContext$tap_core_release());
        StringFormat $this$encodeToString$iv$iv = this_$iv.getJson();
        SerializersModule $this$serializer$iv$iv$iv = $this$encodeToString$iv$iv.getSerializersModule();
        KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(DynamicDeviceInfo.class));
        Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        return $this$encodeToString$iv$iv.encodeToString(kSerializerSerializer, dynamicDeviceInfo);
    }
}
