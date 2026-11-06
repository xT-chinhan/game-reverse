package com.taptap.sdk.openlog.model;

import com.umeng.analytics.pro.z;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: OpenLogConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 O2\u00020\u0001:\u0002NOB¡\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015Be\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0016J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\tHÆ\u0003J\t\u00106\u001a\u00020\u0010HÆ\u0003J\t\u00107\u001a\u00020\u0012HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\tHÆ\u0003J\t\u0010<\u001a\u00020\tHÆ\u0003J\t\u0010=\u001a\u00020\tHÆ\u0003J\t\u0010>\u001a\u00020\tHÆ\u0003J\t\u0010?\u001a\u00020\tHÆ\u0003J\u0081\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010D\u001a\u00020\u0003HÖ\u0001J\t\u0010E\u001a\u00020\tHÖ\u0001J&\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u00002\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020LHÁ\u0001¢\u0006\u0002\bMR\u001c\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\r\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001dR\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u001dR\u001c\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0018\u001a\u0004\b#\u0010$R\u001c\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0018\u001a\u0004\b&\u0010\u001dR\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0018\u001a\u0004\b(\u0010$R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0018\u001a\u0004\b*\u0010$R\u001c\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0018\u001a\u0004\b,\u0010\u001dR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u0018\u001a\u0004\b.\u0010$R\u001c\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010\u0018\u001a\u0004\b0\u00101R\u001c\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\u0018\u001a\u0004\b3\u0010\u001d¨\u0006P"}, d2 = {"Lcom/taptap/sdk/openlog/model/OpenLogConfig;", "", "seen1", "", "region", "logLevel", "logToConsole", "enableAutoTestLog", "dataDir", "", z.a, "platform", z.d, "clientId", "clientToken", "staticDeviceInfo", "Lcom/taptap/sdk/openlog/model/StaticDeviceInfo;", "appDurationParams", "Lcom/taptap/sdk/openlog/model/AppDurationParams;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/taptap/sdk/openlog/model/StaticDeviceInfo;Lcom/taptap/sdk/openlog/model/AppDurationParams;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(IIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/taptap/sdk/openlog/model/StaticDeviceInfo;Lcom/taptap/sdk/openlog/model/AppDurationParams;)V", "getAppDurationParams$annotations", "()V", "getAppDurationParams", "()Lcom/taptap/sdk/openlog/model/AppDurationParams;", "getClientId$annotations", "getClientId", "()Ljava/lang/String;", "getClientToken$annotations", "getClientToken", "getDataDir$annotations", "getDataDir", "getEnableAutoTestLog$annotations", "getEnableAutoTestLog", "()I", "getEnv$annotations", "getEnv", "getLogLevel$annotations", "getLogLevel", "getLogToConsole$annotations", "getLogToConsole", "getPlatform$annotations", "getPlatform", "getRegion$annotations", "getRegion", "getStaticDeviceInfo$annotations", "getStaticDeviceInfo", "()Lcom/taptap/sdk/openlog/model/StaticDeviceInfo;", "getUa$annotations", "getUa", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$tap_core_release", "$serializer", "Companion", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class OpenLogConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AppDurationParams appDurationParams;
    private final String clientId;
    private final String clientToken;
    private final String dataDir;
    private final int enableAutoTestLog;
    private final String env;
    private final int logLevel;
    private final int logToConsole;
    private final String platform;
    private final int region;
    private final StaticDeviceInfo staticDeviceInfo;
    private final String ua;

    @SerialName("app_duration")
    public static /* synthetic */ void getAppDurationParams$annotations() {
    }

    @SerialName("client_id")
    public static /* synthetic */ void getClientId$annotations() {
    }

    @SerialName("client_token")
    public static /* synthetic */ void getClientToken$annotations() {
    }

    @SerialName("data_dir")
    public static /* synthetic */ void getDataDir$annotations() {
    }

    @SerialName("enable_auto_test_log")
    public static /* synthetic */ void getEnableAutoTestLog$annotations() {
    }

    @SerialName(z.a)
    public static /* synthetic */ void getEnv$annotations() {
    }

    @SerialName("log_level")
    public static /* synthetic */ void getLogLevel$annotations() {
    }

    @SerialName("log_to_console")
    public static /* synthetic */ void getLogToConsole$annotations() {
    }

    @SerialName("platform")
    public static /* synthetic */ void getPlatform$annotations() {
    }

    @SerialName("region")
    public static /* synthetic */ void getRegion$annotations() {
    }

    @SerialName("common")
    public static /* synthetic */ void getStaticDeviceInfo$annotations() {
    }

    @SerialName(z.d)
    public static /* synthetic */ void getUa$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getRegion() {
        return this.region;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getClientToken() {
        return this.clientToken;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final StaticDeviceInfo getStaticDeviceInfo() {
        return this.staticDeviceInfo;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final AppDurationParams getAppDurationParams() {
        return this.appDurationParams;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getLogLevel() {
        return this.logLevel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getLogToConsole() {
        return this.logToConsole;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getEnableAutoTestLog() {
        return this.enableAutoTestLog;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDataDir() {
        return this.dataDir;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getEnv() {
        return this.env;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getPlatform() {
        return this.platform;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getUa() {
        return this.ua;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    public final OpenLogConfig copy(int region, int logLevel, int logToConsole, int enableAutoTestLog, String dataDir, String env, String platform, String ua, String clientId, String clientToken, StaticDeviceInfo staticDeviceInfo, AppDurationParams appDurationParams) {
        Intrinsics.checkNotNullParameter(dataDir, "dataDir");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(ua, "ua");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(clientToken, "clientToken");
        Intrinsics.checkNotNullParameter(staticDeviceInfo, "staticDeviceInfo");
        Intrinsics.checkNotNullParameter(appDurationParams, "appDurationParams");
        return new OpenLogConfig(region, logLevel, logToConsole, enableAutoTestLog, dataDir, env, platform, ua, clientId, clientToken, staticDeviceInfo, appDurationParams);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OpenLogConfig)) {
            return false;
        }
        OpenLogConfig openLogConfig = (OpenLogConfig) other;
        return this.region == openLogConfig.region && this.logLevel == openLogConfig.logLevel && this.logToConsole == openLogConfig.logToConsole && this.enableAutoTestLog == openLogConfig.enableAutoTestLog && Intrinsics.areEqual(this.dataDir, openLogConfig.dataDir) && Intrinsics.areEqual(this.env, openLogConfig.env) && Intrinsics.areEqual(this.platform, openLogConfig.platform) && Intrinsics.areEqual(this.ua, openLogConfig.ua) && Intrinsics.areEqual(this.clientId, openLogConfig.clientId) && Intrinsics.areEqual(this.clientToken, openLogConfig.clientToken) && Intrinsics.areEqual(this.staticDeviceInfo, openLogConfig.staticDeviceInfo) && Intrinsics.areEqual(this.appDurationParams, openLogConfig.appDurationParams);
    }

    public int hashCode() {
        return (((((((((((((((((((((Integer.hashCode(this.region) * 31) + Integer.hashCode(this.logLevel)) * 31) + Integer.hashCode(this.logToConsole)) * 31) + Integer.hashCode(this.enableAutoTestLog)) * 31) + this.dataDir.hashCode()) * 31) + this.env.hashCode()) * 31) + this.platform.hashCode()) * 31) + this.ua.hashCode()) * 31) + this.clientId.hashCode()) * 31) + this.clientToken.hashCode()) * 31) + this.staticDeviceInfo.hashCode()) * 31) + this.appDurationParams.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OpenLogConfig(region=").append(this.region).append(", logLevel=").append(this.logLevel).append(", logToConsole=").append(this.logToConsole).append(", enableAutoTestLog=").append(this.enableAutoTestLog).append(", dataDir=").append(this.dataDir).append(", env=").append(this.env).append(", platform=").append(this.platform).append(", ua=").append(this.ua).append(", clientId=").append(this.clientId).append(", clientToken=").append(this.clientToken).append(", staticDeviceInfo=").append(this.staticDeviceInfo).append(", appDurationParams=");
        sb.append(this.appDurationParams).append(')');
        return sb.toString();
    }

    /* JADX INFO: compiled from: OpenLogConfig.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/openlog/model/OpenLogConfig$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/openlog/model/OpenLogConfig;", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<OpenLogConfig> serializer() {
            return OpenLogConfig$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ OpenLogConfig(int seen1, @SerialName("region") int region, @SerialName("log_level") int logLevel, @SerialName("log_to_console") int logToConsole, @SerialName("enable_auto_test_log") int enableAutoTestLog, @SerialName("data_dir") String dataDir, @SerialName(z.a) String env, @SerialName("platform") String platform, @SerialName(z.d) String ua, @SerialName("client_id") String clientId, @SerialName("client_token") String clientToken, @SerialName("common") StaticDeviceInfo staticDeviceInfo, @SerialName("app_duration") AppDurationParams appDurationParams, SerializationConstructorMarker serializationConstructorMarker) {
        if (4095 != (seen1 & 4095)) {
            PluginExceptionsKt.throwMissingFieldException(seen1, 4095, OpenLogConfig$$serializer.INSTANCE.getDescriptor());
        }
        this.region = region;
        this.logLevel = logLevel;
        this.logToConsole = logToConsole;
        this.enableAutoTestLog = enableAutoTestLog;
        this.dataDir = dataDir;
        this.env = env;
        this.platform = platform;
        this.ua = ua;
        this.clientId = clientId;
        this.clientToken = clientToken;
        this.staticDeviceInfo = staticDeviceInfo;
        this.appDurationParams = appDurationParams;
    }

    public OpenLogConfig(int region, int logLevel, int logToConsole, int enableAutoTestLog, String dataDir, String env, String platform, String ua, String clientId, String clientToken, StaticDeviceInfo staticDeviceInfo, AppDurationParams appDurationParams) {
        Intrinsics.checkNotNullParameter(dataDir, "dataDir");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(ua, "ua");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(clientToken, "clientToken");
        Intrinsics.checkNotNullParameter(staticDeviceInfo, "staticDeviceInfo");
        Intrinsics.checkNotNullParameter(appDurationParams, "appDurationParams");
        this.region = region;
        this.logLevel = logLevel;
        this.logToConsole = logToConsole;
        this.enableAutoTestLog = enableAutoTestLog;
        this.dataDir = dataDir;
        this.env = env;
        this.platform = platform;
        this.ua = ua;
        this.clientId = clientId;
        this.clientToken = clientToken;
        this.staticDeviceInfo = staticDeviceInfo;
        this.appDurationParams = appDurationParams;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$tap_core_release(OpenLogConfig self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeIntElement(serialDesc, 0, self.region);
        output.encodeIntElement(serialDesc, 1, self.logLevel);
        output.encodeIntElement(serialDesc, 2, self.logToConsole);
        output.encodeIntElement(serialDesc, 3, self.enableAutoTestLog);
        output.encodeStringElement(serialDesc, 4, self.dataDir);
        output.encodeStringElement(serialDesc, 5, self.env);
        output.encodeStringElement(serialDesc, 6, self.platform);
        output.encodeStringElement(serialDesc, 7, self.ua);
        output.encodeStringElement(serialDesc, 8, self.clientId);
        output.encodeStringElement(serialDesc, 9, self.clientToken);
        output.encodeSerializableElement(serialDesc, 10, StaticDeviceInfo$$serializer.INSTANCE, self.staticDeviceInfo);
        output.encodeSerializableElement(serialDesc, 11, AppDurationParams$$serializer.INSTANCE, self.appDurationParams);
    }

    public final int getRegion() {
        return this.region;
    }

    public final int getLogLevel() {
        return this.logLevel;
    }

    public final int getLogToConsole() {
        return this.logToConsole;
    }

    public final int getEnableAutoTestLog() {
        return this.enableAutoTestLog;
    }

    public final String getDataDir() {
        return this.dataDir;
    }

    public final String getEnv() {
        return this.env;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final String getUa() {
        return this.ua;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getClientToken() {
        return this.clientToken;
    }

    public final StaticDeviceInfo getStaticDeviceInfo() {
        return this.staticDeviceInfo;
    }

    public final AppDurationParams getAppDurationParams() {
        return this.appDurationParams;
    }
}
