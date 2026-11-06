package com.taptap.sdk.core.unity.config;

import com.taptap.sdk.core.TapTapLanguage;
import com.taptap.sdk.core.TapTapSdkOptions;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.kit.internal.TapLogger;
import java.util.ArrayList;
import java.util.List;
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
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: CoreInitConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \\2\u00020\u0001:\u0002[\\B±\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\u000b\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u000b\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u000b\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016B\u0093\u0001\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003¢\u0006\u0002\u0010\u0017J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u000bHÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u000bHÆ\u0003J\t\u0010A\u001a\u00020\u000bHÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J\t\u0010F\u001a\u00020\u0005HÆ\u0003J\t\u0010G\u001a\u00020\u000bHÆ\u0003J\t\u0010H\u001a\u00020\u000bHÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\u0006\u0010K\u001a\u00020LJ\u0097\u0001\u0010M\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u0003HÆ\u0001J\u0013\u0010N\u001a\u00020\u000b2\b\u0010O\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010P\u001a\u00020\u0003HÖ\u0001J\t\u0010Q\u001a\u00020\u0005HÖ\u0001J\b\u0010R\u001a\u00020SH\u0002J&\u0010T\u001a\u00020S2\u0006\u0010U\u001a\u00020\u00002\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020YHÁ\u0001¢\u0006\u0002\bZR\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u001eR\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u001eR$\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b#\u0010\u0019\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010&R$\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b'\u0010\u0019\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010&R\u001c\u0010\u000f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0019\u001a\u0004\b+\u0010\u001bR\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0019\u001a\u0004\b-\u0010\u001eR\u001c\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u0019\u001a\u0004\b/\u0010\u001eR\u001c\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u0019\u001a\u0004\b1\u0010\u001bR\u001c\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\u0019\u001a\u0004\b3\u00104R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010\u0019\u001a\u0004\b6\u0010\u001eR\u001c\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010\u0019\u001a\u0004\b8\u00104R$\u0010\u0013\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b9\u0010\u0019\u001a\u0004\b:\u00104\"\u0004\b;\u0010<¨\u0006]"}, d2 = {"Lcom/taptap/sdk/core/unity/config/CoreInitConfig;", "", "seen1", "", "clientId", "", "clientToken", "region", "channel", "gameVersion", "autoIAPEventEnabled", "", "overrideBuiltInParameters", Common.Predefined.PROPERTIES, "oaidCert", "enableLog", "preferredLanguage", "disableReflectionOAID", "disableAutoLogDeviceLogin", "screenOrientation", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;ZIZZILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;ZIZZI)V", "getAutoIAPEventEnabled$annotations", "()V", "getAutoIAPEventEnabled", "()Z", "getChannel$annotations", "getChannel", "()Ljava/lang/String;", "getClientId$annotations", "getClientId", "getClientToken$annotations", "getClientToken", "getDisableAutoLogDeviceLogin$annotations", "getDisableAutoLogDeviceLogin", "setDisableAutoLogDeviceLogin", "(Z)V", "getDisableReflectionOAID$annotations", "getDisableReflectionOAID", "setDisableReflectionOAID", "getEnableLog$annotations", "getEnableLog", "getGameVersion$annotations", "getGameVersion", "getOaidCert$annotations", "getOaidCert", "getOverrideBuiltInParameters$annotations", "getOverrideBuiltInParameters", "getPreferredLanguage$annotations", "getPreferredLanguage", "()I", "getProperties$annotations", "getProperties", "getRegion$annotations", "getRegion", "getScreenOrientation$annotations", "getScreenOrientation", "setScreenOrientation", "(I)V", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "convertToTapTapRegion", "Lcom/taptap/sdk/core/TapTapSdkOptions;", "copy", "equals", "other", "hashCode", "toString", "warnDeprecatedEventFields", "", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$tap_core_release", "$serializer", "Companion", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class CoreInitConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "CoreInitConfig";
    private final boolean autoIAPEventEnabled;
    private final String channel;
    private final String clientId;
    private final String clientToken;
    private boolean disableAutoLogDeviceLogin;
    private boolean disableReflectionOAID;
    private final boolean enableLog;
    private final String gameVersion;
    private final String oaidCert;
    private final boolean overrideBuiltInParameters;
    private final int preferredLanguage;
    private final String properties;
    private final int region;
    private int screenOrientation;

    public CoreInitConfig() {
        this((String) null, (String) null, 0, (String) null, (String) null, false, false, (String) null, (String) null, false, 0, false, false, 0, 16383, (DefaultConstructorMarker) null);
    }

    @SerialName("autoIAPEventEnabled")
    public static /* synthetic */ void getAutoIAPEventEnabled$annotations() {
    }

    @SerialName("channel")
    public static /* synthetic */ void getChannel$annotations() {
    }

    @SerialName("clientId")
    public static /* synthetic */ void getClientId$annotations() {
    }

    @SerialName("clientToken")
    public static /* synthetic */ void getClientToken$annotations() {
    }

    @SerialName("disableAutoLogDeviceLogin")
    public static /* synthetic */ void getDisableAutoLogDeviceLogin$annotations() {
    }

    @SerialName("disableReflectionOAID")
    public static /* synthetic */ void getDisableReflectionOAID$annotations() {
    }

    @SerialName("enableLog")
    public static /* synthetic */ void getEnableLog$annotations() {
    }

    @SerialName("gameVersion")
    public static /* synthetic */ void getGameVersion$annotations() {
    }

    @SerialName("oaidCert")
    public static /* synthetic */ void getOaidCert$annotations() {
    }

    @SerialName("overrideBuiltInParameters")
    public static /* synthetic */ void getOverrideBuiltInParameters$annotations() {
    }

    @SerialName("preferredLanguage")
    public static /* synthetic */ void getPreferredLanguage$annotations() {
    }

    @SerialName(Common.Predefined.PROPERTIES)
    public static /* synthetic */ void getProperties$annotations() {
    }

    @SerialName("region")
    public static /* synthetic */ void getRegion$annotations() {
    }

    @SerialName("screenOrientation")
    public static /* synthetic */ void getScreenOrientation$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getEnableLog() {
        return this.enableLog;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getPreferredLanguage() {
        return this.preferredLanguage;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getDisableReflectionOAID() {
        return this.disableReflectionOAID;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getDisableAutoLogDeviceLogin() {
        return this.disableAutoLogDeviceLogin;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getScreenOrientation() {
        return this.screenOrientation;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getClientToken() {
        return this.clientToken;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getRegion() {
        return this.region;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getGameVersion() {
        return this.gameVersion;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getAutoIAPEventEnabled() {
        return this.autoIAPEventEnabled;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getOverrideBuiltInParameters() {
        return this.overrideBuiltInParameters;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getProperties() {
        return this.properties;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getOaidCert() {
        return this.oaidCert;
    }

    public final CoreInitConfig copy(String clientId, String clientToken, int region, String channel, String gameVersion, boolean autoIAPEventEnabled, boolean overrideBuiltInParameters, String properties, String oaidCert, boolean enableLog, int preferredLanguage, boolean disableReflectionOAID, boolean disableAutoLogDeviceLogin, int screenOrientation) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(clientToken, "clientToken");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(gameVersion, "gameVersion");
        Intrinsics.checkNotNullParameter(oaidCert, "oaidCert");
        return new CoreInitConfig(clientId, clientToken, region, channel, gameVersion, autoIAPEventEnabled, overrideBuiltInParameters, properties, oaidCert, enableLog, preferredLanguage, disableReflectionOAID, disableAutoLogDeviceLogin, screenOrientation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CoreInitConfig)) {
            return false;
        }
        CoreInitConfig coreInitConfig = (CoreInitConfig) other;
        return Intrinsics.areEqual(this.clientId, coreInitConfig.clientId) && Intrinsics.areEqual(this.clientToken, coreInitConfig.clientToken) && this.region == coreInitConfig.region && Intrinsics.areEqual(this.channel, coreInitConfig.channel) && Intrinsics.areEqual(this.gameVersion, coreInitConfig.gameVersion) && this.autoIAPEventEnabled == coreInitConfig.autoIAPEventEnabled && this.overrideBuiltInParameters == coreInitConfig.overrideBuiltInParameters && Intrinsics.areEqual(this.properties, coreInitConfig.properties) && Intrinsics.areEqual(this.oaidCert, coreInitConfig.oaidCert) && this.enableLog == coreInitConfig.enableLog && this.preferredLanguage == coreInitConfig.preferredLanguage && this.disableReflectionOAID == coreInitConfig.disableReflectionOAID && this.disableAutoLogDeviceLogin == coreInitConfig.disableAutoLogDeviceLogin && this.screenOrientation == coreInitConfig.screenOrientation;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((this.clientId.hashCode() * 31) + this.clientToken.hashCode()) * 31) + Integer.hashCode(this.region)) * 31) + this.channel.hashCode()) * 31) + this.gameVersion.hashCode()) * 31) + Boolean.hashCode(this.autoIAPEventEnabled)) * 31) + Boolean.hashCode(this.overrideBuiltInParameters)) * 31;
        String str = this.properties;
        return ((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.oaidCert.hashCode()) * 31) + Boolean.hashCode(this.enableLog)) * 31) + Integer.hashCode(this.preferredLanguage)) * 31) + Boolean.hashCode(this.disableReflectionOAID)) * 31) + Boolean.hashCode(this.disableAutoLogDeviceLogin)) * 31) + Integer.hashCode(this.screenOrientation);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CoreInitConfig(clientId=").append(this.clientId).append(", clientToken=").append(this.clientToken).append(", region=").append(this.region).append(", channel=").append(this.channel).append(", gameVersion=").append(this.gameVersion).append(", autoIAPEventEnabled=").append(this.autoIAPEventEnabled).append(", overrideBuiltInParameters=").append(this.overrideBuiltInParameters).append(", properties=").append(this.properties).append(", oaidCert=").append(this.oaidCert).append(", enableLog=").append(this.enableLog).append(", preferredLanguage=").append(this.preferredLanguage).append(", disableReflectionOAID=");
        sb.append(this.disableReflectionOAID).append(", disableAutoLogDeviceLogin=").append(this.disableAutoLogDeviceLogin).append(", screenOrientation=").append(this.screenOrientation).append(')');
        return sb.toString();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ CoreInitConfig(int seen1, @SerialName("clientId") String clientId, @SerialName("clientToken") String clientToken, @SerialName("region") int region, @SerialName("channel") String channel, @SerialName("gameVersion") String gameVersion, @SerialName("autoIAPEventEnabled") boolean autoIAPEventEnabled, @SerialName("overrideBuiltInParameters") boolean overrideBuiltInParameters, @SerialName(Common.Predefined.PROPERTIES) String properties, @SerialName("oaidCert") String oaidCert, @SerialName("enableLog") boolean enableLog, @SerialName("preferredLanguage") int preferredLanguage, @SerialName("disableReflectionOAID") boolean disableReflectionOAID, @SerialName("disableAutoLogDeviceLogin") boolean disableAutoLogDeviceLogin, @SerialName("screenOrientation") int screenOrientation, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen1 & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(seen1, 0, CoreInitConfig$$serializer.INSTANCE.getDescriptor());
        }
        if ((seen1 & 1) == 0) {
            this.clientId = "";
        } else {
            this.clientId = clientId;
        }
        if ((seen1 & 2) == 0) {
            this.clientToken = "";
        } else {
            this.clientToken = clientToken;
        }
        if ((seen1 & 4) == 0) {
            this.region = -1;
        } else {
            this.region = region;
        }
        if ((seen1 & 8) == 0) {
            this.channel = "";
        } else {
            this.channel = channel;
        }
        if ((seen1 & 16) == 0) {
            this.gameVersion = "";
        } else {
            this.gameVersion = gameVersion;
        }
        if ((seen1 & 32) == 0) {
            this.autoIAPEventEnabled = false;
        } else {
            this.autoIAPEventEnabled = autoIAPEventEnabled;
        }
        if ((seen1 & 64) == 0) {
            this.overrideBuiltInParameters = false;
        } else {
            this.overrideBuiltInParameters = overrideBuiltInParameters;
        }
        if ((seen1 & 128) == 0) {
            this.properties = null;
        } else {
            this.properties = properties;
        }
        if ((seen1 & 256) == 0) {
            this.oaidCert = "";
        } else {
            this.oaidCert = oaidCert;
        }
        if ((seen1 & 512) == 0) {
            this.enableLog = false;
        } else {
            this.enableLog = enableLog;
        }
        if ((seen1 & 1024) == 0) {
            this.preferredLanguage = -1;
        } else {
            this.preferredLanguage = preferredLanguage;
        }
        if ((seen1 & 2048) == 0) {
            this.disableReflectionOAID = true;
        } else {
            this.disableReflectionOAID = disableReflectionOAID;
        }
        if ((seen1 & 4096) == 0) {
            this.disableAutoLogDeviceLogin = false;
        } else {
            this.disableAutoLogDeviceLogin = disableAutoLogDeviceLogin;
        }
        if ((seen1 & 8192) == 0) {
            this.screenOrientation = 1;
        } else {
            this.screenOrientation = screenOrientation;
        }
    }

    public CoreInitConfig(String clientId, String clientToken, int region, String channel, String gameVersion, boolean autoIAPEventEnabled, boolean overrideBuiltInParameters, String properties, String oaidCert, boolean enableLog, int preferredLanguage, boolean disableReflectionOAID, boolean disableAutoLogDeviceLogin, int screenOrientation) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(clientToken, "clientToken");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(gameVersion, "gameVersion");
        Intrinsics.checkNotNullParameter(oaidCert, "oaidCert");
        this.clientId = clientId;
        this.clientToken = clientToken;
        this.region = region;
        this.channel = channel;
        this.gameVersion = gameVersion;
        this.autoIAPEventEnabled = autoIAPEventEnabled;
        this.overrideBuiltInParameters = overrideBuiltInParameters;
        this.properties = properties;
        this.oaidCert = oaidCert;
        this.enableLog = enableLog;
        this.preferredLanguage = preferredLanguage;
        this.disableReflectionOAID = disableReflectionOAID;
        this.disableAutoLogDeviceLogin = disableAutoLogDeviceLogin;
        this.screenOrientation = screenOrientation;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$tap_core_release(CoreInitConfig self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean z = false;
        boolean z2 = output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.clientId, "");
        if (z2) {
            output.encodeStringElement(serialDesc, 0, self.clientId);
        }
        boolean z3 = output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.clientToken, "");
        if (z3) {
            output.encodeStringElement(serialDesc, 1, self.clientToken);
        }
        boolean z4 = output.shouldEncodeElementDefault(serialDesc, 2) || self.region != -1;
        if (z4) {
            output.encodeIntElement(serialDesc, 2, self.region);
        }
        boolean z5 = output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.channel, "");
        if (z5) {
            output.encodeStringElement(serialDesc, 3, self.channel);
        }
        boolean z6 = output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.gameVersion, "");
        if (z6) {
            output.encodeStringElement(serialDesc, 4, self.gameVersion);
        }
        boolean z7 = output.shouldEncodeElementDefault(serialDesc, 5) || self.autoIAPEventEnabled;
        if (z7) {
            output.encodeBooleanElement(serialDesc, 5, self.autoIAPEventEnabled);
        }
        boolean z8 = output.shouldEncodeElementDefault(serialDesc, 6) || self.overrideBuiltInParameters;
        if (z8) {
            output.encodeBooleanElement(serialDesc, 6, self.overrideBuiltInParameters);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.properties != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.properties);
        }
        boolean z9 = output.shouldEncodeElementDefault(serialDesc, 8) || !Intrinsics.areEqual(self.oaidCert, "");
        if (z9) {
            output.encodeStringElement(serialDesc, 8, self.oaidCert);
        }
        boolean z10 = output.shouldEncodeElementDefault(serialDesc, 9) || self.enableLog;
        if (z10) {
            output.encodeBooleanElement(serialDesc, 9, self.enableLog);
        }
        boolean z11 = output.shouldEncodeElementDefault(serialDesc, 10) || self.preferredLanguage != -1;
        if (z11) {
            output.encodeIntElement(serialDesc, 10, self.preferredLanguage);
        }
        boolean z12 = output.shouldEncodeElementDefault(serialDesc, 11) || !self.disableReflectionOAID;
        if (z12) {
            output.encodeBooleanElement(serialDesc, 11, self.disableReflectionOAID);
        }
        boolean z13 = output.shouldEncodeElementDefault(serialDesc, 12) || self.disableAutoLogDeviceLogin;
        if (z13) {
            output.encodeBooleanElement(serialDesc, 12, self.disableAutoLogDeviceLogin);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.screenOrientation != 1) {
            z = true;
        }
        if (z) {
            output.encodeIntElement(serialDesc, 13, self.screenOrientation);
        }
    }

    public /* synthetic */ CoreInitConfig(String str, String str2, int i, String str3, String str4, boolean z, boolean z2, String str5, String str6, boolean z3, int i2, boolean z4, boolean z5, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? "" : str2, (i4 & 4) != 0 ? -1 : i, (i4 & 8) != 0 ? "" : str3, (i4 & 16) != 0 ? "" : str4, (i4 & 32) != 0 ? false : z, (i4 & 64) != 0 ? false : z2, (i4 & 128) != 0 ? null : str5, (i4 & 256) == 0 ? str6 : "", (i4 & 512) != 0 ? false : z3, (i4 & 1024) == 0 ? i2 : -1, (i4 & 2048) != 0 ? true : z4, (i4 & 4096) == 0 ? z5 : false, (i4 & 8192) == 0 ? i3 : 1);
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getClientToken() {
        return this.clientToken;
    }

    public final int getRegion() {
        return this.region;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final String getGameVersion() {
        return this.gameVersion;
    }

    public final boolean getAutoIAPEventEnabled() {
        return this.autoIAPEventEnabled;
    }

    public final boolean getOverrideBuiltInParameters() {
        return this.overrideBuiltInParameters;
    }

    public final String getProperties() {
        return this.properties;
    }

    public final String getOaidCert() {
        return this.oaidCert;
    }

    public final boolean getEnableLog() {
        return this.enableLog;
    }

    public final int getPreferredLanguage() {
        return this.preferredLanguage;
    }

    public final boolean getDisableReflectionOAID() {
        return this.disableReflectionOAID;
    }

    public final void setDisableReflectionOAID(boolean z) {
        this.disableReflectionOAID = z;
    }

    public final boolean getDisableAutoLogDeviceLogin() {
        return this.disableAutoLogDeviceLogin;
    }

    public final void setDisableAutoLogDeviceLogin(boolean z) {
        this.disableAutoLogDeviceLogin = z;
    }

    public final int getScreenOrientation() {
        return this.screenOrientation;
    }

    public final void setScreenOrientation(int i) {
        this.screenOrientation = i;
    }

    public final TapTapSdkOptions convertToTapTapRegion() {
        warnDeprecatedEventFields();
        return new TapTapSdkOptions(this.clientId, this.clientToken, this.region != 1 ? 0 : 1, this.gameVersion, this.enableLog, TapTapLanguage.INSTANCE.from(this.preferredLanguage), this.screenOrientation);
    }

    private final void warnDeprecatedEventFields() {
        List deprecated = new ArrayList();
        if (this.channel.length() > 0) {
            deprecated.add("channel");
        }
        if (this.autoIAPEventEnabled) {
            deprecated.add("autoIAPEventEnabled");
        }
        if (this.overrideBuiltInParameters) {
            deprecated.add("overrideBuiltInParameters");
        }
        if (this.properties != null) {
            deprecated.add(Common.Predefined.PROPERTIES);
        }
        if (this.oaidCert.length() > 0) {
            deprecated.add("oaidCert");
        }
        if (!this.disableReflectionOAID) {
            deprecated.add("disableReflectionOAID");
        }
        if (this.disableAutoLogDeviceLogin) {
            deprecated.add("disableAutoLogDeviceLogin");
        }
        if (!deprecated.isEmpty()) {
            TapLogger.logw$default(TAG, "CoreInitConfig 中以下字段已废弃且不再生效，请改用 TapTapEventOptions 通过 otherOptions 传递: " + deprecated, false, 4, null);
        }
    }

    /* JADX INFO: compiled from: CoreInitConfig.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/taptap/sdk/core/unity/config/CoreInitConfig$Companion;", "", "()V", "TAG", "", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/core/unity/config/CoreInitConfig;", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CoreInitConfig> serializer() {
            return CoreInitConfig$$serializer.INSTANCE;
        }
    }
}
