package com.taptap.sdk.core.unity.config;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.taptap.sdk.core.TapTapLanguage;
import com.taptap.sdk.core.TapTapSdkOptions;
import com.taptap.sdk.db.constant.Common;
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
import org.json.JSONObject;

/* JADX INFO: compiled from: CoreInitConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 Z2\u00020\u0001:\u0002YZB±\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\u000b\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u000b\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u000b\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016B\u0093\u0001\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003¢\u0006\u0002\u0010\u0017J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u000bHÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u000bHÆ\u0003J\t\u0010A\u001a\u00020\u000bHÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J\t\u0010F\u001a\u00020\u0005HÆ\u0003J\t\u0010G\u001a\u00020\u000bHÆ\u0003J\t\u0010H\u001a\u00020\u000bHÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\u0006\u0010K\u001a\u00020LJ\u0097\u0001\u0010M\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u0003HÆ\u0001J\u0013\u0010N\u001a\u00020\u000b2\b\u0010O\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010P\u001a\u00020\u0003HÖ\u0001J\t\u0010Q\u001a\u00020\u0005HÖ\u0001J!\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020XHÇ\u0001R\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u001eR\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u001eR$\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b#\u0010\u0019\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010&R$\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b'\u0010\u0019\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010&R\u001c\u0010\u000f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0019\u001a\u0004\b+\u0010\u001bR\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0019\u001a\u0004\b-\u0010\u001eR\u001c\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u0019\u001a\u0004\b/\u0010\u001eR\u001c\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u0019\u001a\u0004\b1\u0010\u001bR\u001c\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\u0019\u001a\u0004\b3\u00104R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010\u0019\u001a\u0004\b6\u0010\u001eR\u001c\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010\u0019\u001a\u0004\b8\u00104R$\u0010\u0013\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b9\u0010\u0019\u001a\u0004\b:\u00104\"\u0004\b;\u0010<¨\u0006["}, d2 = {"Lcom/taptap/sdk/core/unity/config/CoreInitConfig;", "", "seen1", "", "clientId", "", "clientToken", "region", "channel", "gameVersion", "autoIAPEventEnabled", "", "overrideBuiltInParameters", Common.Predefined.PROPERTIES, "oaidCert", "enableLog", "preferredLanguage", "disableReflectionOAID", "disableAutoLogDeviceLogin", "screenOrientation", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;ZIZZILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;ZIZZI)V", "getAutoIAPEventEnabled$annotations", "()V", "getAutoIAPEventEnabled", "()Z", "getChannel$annotations", "getChannel", "()Ljava/lang/String;", "getClientId$annotations", "getClientId", "getClientToken$annotations", "getClientToken", "getDisableAutoLogDeviceLogin$annotations", "getDisableAutoLogDeviceLogin", "setDisableAutoLogDeviceLogin", "(Z)V", "getDisableReflectionOAID$annotations", "getDisableReflectionOAID", "setDisableReflectionOAID", "getEnableLog$annotations", "getEnableLog", "getGameVersion$annotations", "getGameVersion", "getOaidCert$annotations", "getOaidCert", "getOverrideBuiltInParameters$annotations", "getOverrideBuiltInParameters", "getPreferredLanguage$annotations", "getPreferredLanguage", "()I", "getProperties$annotations", "getProperties", "getRegion$annotations", "getRegion", "getScreenOrientation$annotations", "getScreenOrientation", "setScreenOrientation", "(I)V", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "convertToTapTapRegion", "Lcom/taptap/sdk/core/TapTapSdkOptions;", "copy", "equals", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "tap-core-unity_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class CoreInitConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r0v25, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v22, types: [int] */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((((this.clientId.hashCode() * 31) + this.clientToken.hashCode()) * 31) + Integer.hashCode(this.region)) * 31) + this.channel.hashCode()) * 31) + this.gameVersion.hashCode()) * 31;
        boolean z = this.autoIAPEventEnabled;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.overrideBuiltInParameters;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        String str = this.properties;
        int iHashCode2 = (((i2 + (str == null ? 0 : str.hashCode())) * 31) + this.oaidCert.hashCode()) * 31;
        boolean z3 = this.enableLog;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int iHashCode3 = (((iHashCode2 + r3) * 31) + Integer.hashCode(this.preferredLanguage)) * 31;
        boolean z4 = this.disableReflectionOAID;
        ?? r4 = z4;
        if (z4) {
            r4 = 1;
        }
        int i3 = (iHashCode3 + r4) * 31;
        boolean z5 = this.disableAutoLogDeviceLogin;
        return ((i3 + (z5 ? 1 : z5)) * 31) + Integer.hashCode(this.screenOrientation);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CoreInitConfig(clientId=");
        sb.append(this.clientId).append(", clientToken=").append(this.clientToken).append(", region=").append(this.region).append(", channel=").append(this.channel).append(", gameVersion=").append(this.gameVersion).append(", autoIAPEventEnabled=").append(this.autoIAPEventEnabled).append(", overrideBuiltInParameters=").append(this.overrideBuiltInParameters).append(", properties=").append(this.properties).append(", oaidCert=").append(this.oaidCert).append(", enableLog=").append(this.enableLog).append(", preferredLanguage=").append(this.preferredLanguage).append(", disableReflectionOAID=");
        sb.append(this.disableReflectionOAID).append(", disableAutoLogDeviceLogin=").append(this.disableAutoLogDeviceLogin).append(", screenOrientation=").append(this.screenOrientation).append(')');
        return sb.toString();
    }

    /* JADX INFO: compiled from: CoreInitConfig.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/core/unity/config/CoreInitConfig$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/core/unity/config/CoreInitConfig;", "tap-core-unity_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
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

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ CoreInitConfig(int i, @SerialName("clientId") String str, @SerialName("clientToken") String str2, @SerialName("region") int i2, @SerialName("channel") String str3, @SerialName("gameVersion") String str4, @SerialName("autoIAPEventEnabled") boolean z, @SerialName("overrideBuiltInParameters") boolean z2, @SerialName(Common.Predefined.PROPERTIES) String str5, @SerialName("oaidCert") String str6, @SerialName("enableLog") boolean z3, @SerialName("preferredLanguage") int i3, @SerialName("disableReflectionOAID") boolean z4, @SerialName("disableAutoLogDeviceLogin") boolean z5, @SerialName("screenOrientation") int i4, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, CoreInitConfig$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.clientId = "";
        } else {
            this.clientId = str;
        }
        if ((i & 2) == 0) {
            this.clientToken = "";
        } else {
            this.clientToken = str2;
        }
        if ((i & 4) == 0) {
            this.region = -1;
        } else {
            this.region = i2;
        }
        if ((i & 8) == 0) {
            this.channel = "";
        } else {
            this.channel = str3;
        }
        if ((i & 16) == 0) {
            this.gameVersion = "";
        } else {
            this.gameVersion = str4;
        }
        if ((i & 32) == 0) {
            this.autoIAPEventEnabled = false;
        } else {
            this.autoIAPEventEnabled = z;
        }
        if ((i & 64) == 0) {
            this.overrideBuiltInParameters = false;
        } else {
            this.overrideBuiltInParameters = z2;
        }
        this.properties = (i & 128) == 0 ? null : str5;
        if ((i & 256) == 0) {
            this.oaidCert = "";
        } else {
            this.oaidCert = str6;
        }
        if ((i & 512) == 0) {
            this.enableLog = false;
        } else {
            this.enableLog = z3;
        }
        if ((i & 1024) == 0) {
            this.preferredLanguage = -1;
        } else {
            this.preferredLanguage = i3;
        }
        if ((i & 2048) == 0) {
            this.disableReflectionOAID = true;
        } else {
            this.disableReflectionOAID = z4;
        }
        if ((i & 4096) == 0) {
            this.disableAutoLogDeviceLogin = false;
        } else {
            this.disableAutoLogDeviceLogin = z5;
        }
        if ((i & 8192) == 0) {
            this.screenOrientation = 1;
        } else {
            this.screenOrientation = i4;
        }
    }

    public CoreInitConfig(String clientId, String clientToken, int i, String channel, String gameVersion, boolean z, boolean z2, String str, String oaidCert, boolean z3, int i2, boolean z4, boolean z5, int i3) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(clientToken, "clientToken");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(gameVersion, "gameVersion");
        Intrinsics.checkNotNullParameter(oaidCert, "oaidCert");
        this.clientId = clientId;
        this.clientToken = clientToken;
        this.region = i;
        this.channel = channel;
        this.gameVersion = gameVersion;
        this.autoIAPEventEnabled = z;
        this.overrideBuiltInParameters = z2;
        this.properties = str;
        this.oaidCert = oaidCert;
        this.enableLog = z3;
        this.preferredLanguage = i2;
        this.disableReflectionOAID = z4;
        this.disableAutoLogDeviceLogin = z5;
        this.screenOrientation = i3;
    }

    @JvmStatic
    public static final void write$Self(CoreInitConfig self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.clientId, "")) {
            output.encodeStringElement(serialDesc, 0, self.clientId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.clientToken, "")) {
            output.encodeStringElement(serialDesc, 1, self.clientToken);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.region != -1) {
            output.encodeIntElement(serialDesc, 2, self.region);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.channel, "")) {
            output.encodeStringElement(serialDesc, 3, self.channel);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.gameVersion, "")) {
            output.encodeStringElement(serialDesc, 4, self.gameVersion);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.autoIAPEventEnabled) {
            output.encodeBooleanElement(serialDesc, 5, self.autoIAPEventEnabled);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.overrideBuiltInParameters) {
            output.encodeBooleanElement(serialDesc, 6, self.overrideBuiltInParameters);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.properties != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.properties);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || !Intrinsics.areEqual(self.oaidCert, "")) {
            output.encodeStringElement(serialDesc, 8, self.oaidCert);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.enableLog) {
            output.encodeBooleanElement(serialDesc, 9, self.enableLog);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.preferredLanguage != -1) {
            output.encodeIntElement(serialDesc, 10, self.preferredLanguage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || !self.disableReflectionOAID) {
            output.encodeBooleanElement(serialDesc, 11, self.disableReflectionOAID);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.disableAutoLogDeviceLogin) {
            output.encodeBooleanElement(serialDesc, 12, self.disableAutoLogDeviceLogin);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.screenOrientation != 1) {
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
        String str = this.clientId;
        String str2 = this.clientToken;
        int i = this.region != 1 ? 0 : 1;
        String str3 = this.channel;
        String str4 = this.gameVersion;
        boolean z = this.autoIAPEventEnabled;
        boolean z2 = this.overrideBuiltInParameters;
        String str5 = this.properties;
        JSONObject jSONObject = null;
        if (str5 != null) {
            try {
                jSONObject = new JSONObject(str5);
            } catch (Exception unused) {
            }
        }
        return new TapTapSdkOptions(str, str2, i, str3, str4, z, z2, jSONObject, this.oaidCert, this.enableLog, TapTapLanguage.INSTANCE.from(this.preferredLanguage), this.disableReflectionOAID, this.disableAutoLogDeviceLogin, this.screenOrientation);
    }
}
