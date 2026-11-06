package com.taptap.sdk.core.unity.config;

import com.kwad.sdk.api.model.AdnName;
import com.taptap.sdk.core.TapTapLanguage;
import com.taptap.sdk.core.TapTapSdkOptions;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 I2\u00020\u0001:\u0002HIB\u0093\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\u000b\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013Bu\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0002\u0010\u0014J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u000bHÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u000bHÆ\u0003J\t\u00107\u001a\u00020\u000bHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\u0006\u0010:\u001a\u00020;Jy\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001J\u0013\u0010=\u001a\u00020\u000b2\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020\u0003HÖ\u0001J\t\u0010@\u001a\u00020\u0005HÖ\u0001J!\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00002\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GHÇ\u0001R\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u001bR\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001f\u0010\u001bR\u001c\u0010\u000f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018R\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0016\u001a\u0004\b#\u0010\u001bR\u001c\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0016\u001a\u0004\b%\u0010\u001bR\u001c\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0016\u001a\u0004\b'\u0010\u0018R\u001c\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010*R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0016\u001a\u0004\b,\u0010\u001bR\u001c\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u0016\u001a\u0004\b.\u0010*¨\u0006J"}, d2 = {"Lcom/taptap/sdk/core/unity/config/CoreInitConfig;", "", "seen1", "", "clientId", "", "clientToken", "region", "channel", "gameVersion", "autoIAPEventEnabled", "", "overrideBuiltInParameters", TapEventParamConstants.PARAM_PROPERTIES, "oaidCert", "enableLog", "preferredLanguage", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;ZILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;ZI)V", "getAutoIAPEventEnabled$annotations", "()V", "getAutoIAPEventEnabled", "()Z", "getChannel$annotations", "getChannel", "()Ljava/lang/String;", "getClientId$annotations", "getClientId", "getClientToken$annotations", "getClientToken", "getEnableLog$annotations", "getEnableLog", "getGameVersion$annotations", "getGameVersion", "getOaidCert$annotations", "getOaidCert", "getOverrideBuiltInParameters$annotations", "getOverrideBuiltInParameters", "getPreferredLanguage$annotations", "getPreferredLanguage", "()I", "getProperties$annotations", "getProperties", "getRegion$annotations", "getRegion", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "convertToTapTapRegion", "Lcom/taptap/sdk/core/TapTapSdkOptions;", "copy", "equals", AdnName.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "tap-db-unity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Serializable
public final /* data */ class CoreInitConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean autoIAPEventEnabled;
    private final String channel;
    private final String clientId;
    private final String clientToken;
    private final boolean enableLog;
    private final String gameVersion;
    private final String oaidCert;
    private final boolean overrideBuiltInParameters;
    private final int preferredLanguage;
    private final String properties;
    private final int region;

    public CoreInitConfig() {
        this((String) null, (String) null, 0, (String) null, (String) null, false, false, (String) null, (String) null, false, 0, 2047, (DefaultConstructorMarker) null);
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

    @SerialName(TapEventParamConstants.PARAM_PROPERTIES)
    public static /* synthetic */ void getProperties$annotations() {
    }

    @SerialName("region")
    public static /* synthetic */ void getRegion$annotations() {
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

    public final CoreInitConfig copy(String clientId, String clientToken, int region, String channel, String gameVersion, boolean autoIAPEventEnabled, boolean overrideBuiltInParameters, String properties, String oaidCert, boolean enableLog, int preferredLanguage) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(clientToken, "clientToken");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(gameVersion, "gameVersion");
        Intrinsics.checkNotNullParameter(oaidCert, "oaidCert");
        return new CoreInitConfig(clientId, clientToken, region, channel, gameVersion, autoIAPEventEnabled, overrideBuiltInParameters, properties, oaidCert, enableLog, preferredLanguage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CoreInitConfig)) {
            return false;
        }
        CoreInitConfig coreInitConfig = (CoreInitConfig) other;
        return Intrinsics.areEqual(this.clientId, coreInitConfig.clientId) && Intrinsics.areEqual(this.clientToken, coreInitConfig.clientToken) && this.region == coreInitConfig.region && Intrinsics.areEqual(this.channel, coreInitConfig.channel) && Intrinsics.areEqual(this.gameVersion, coreInitConfig.gameVersion) && this.autoIAPEventEnabled == coreInitConfig.autoIAPEventEnabled && this.overrideBuiltInParameters == coreInitConfig.overrideBuiltInParameters && Intrinsics.areEqual(this.properties, coreInitConfig.properties) && Intrinsics.areEqual(this.oaidCert, coreInitConfig.oaidCert) && this.enableLog == coreInitConfig.enableLog && this.preferredLanguage == coreInitConfig.preferredLanguage;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
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
        return ((iHashCode2 + (z3 ? 1 : z3)) * 31) + Integer.hashCode(this.preferredLanguage);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CoreInitConfig(clientId=");
        sb.append(this.clientId).append(", clientToken=").append(this.clientToken).append(", region=").append(this.region).append(", channel=").append(this.channel).append(", gameVersion=").append(this.gameVersion).append(", autoIAPEventEnabled=").append(this.autoIAPEventEnabled).append(", overrideBuiltInParameters=").append(this.overrideBuiltInParameters).append(", properties=").append(this.properties).append(", oaidCert=").append(this.oaidCert).append(", enableLog=").append(this.enableLog).append(", preferredLanguage=").append(this.preferredLanguage).append(')');
        return sb.toString();
    }

    /* JADX INFO: compiled from: CoreInitConfig.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/core/unity/config/CoreInitConfig$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/core/unity/config/CoreInitConfig;", "tap-db-unity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
    public /* synthetic */ CoreInitConfig(int i, @SerialName("clientId") String str, @SerialName("clientToken") String str2, @SerialName("region") int i2, @SerialName("channel") String str3, @SerialName("gameVersion") String str4, @SerialName("autoIAPEventEnabled") boolean z, @SerialName("overrideBuiltInParameters") boolean z2, @SerialName(TapEventParamConstants.PARAM_PROPERTIES) String str5, @SerialName("oaidCert") String str6, @SerialName("enableLog") boolean z3, @SerialName("preferredLanguage") int i3, SerializationConstructorMarker serializationConstructorMarker) {
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
        if ((i & 128) == 0) {
            this.properties = null;
        } else {
            this.properties = str5;
        }
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
    }

    public CoreInitConfig(String clientId, String clientToken, int i, String channel, String gameVersion, boolean z, boolean z2, String str, String oaidCert, boolean z3, int i2) {
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
    }

    public /* synthetic */ CoreInitConfig(String str, String str2, int i, String str3, String str4, boolean z, boolean z2, String str5, String str6, boolean z3, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? -1 : i, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? "" : str4, (i3 & 32) != 0 ? false : z, (i3 & 64) != 0 ? false : z2, (i3 & 128) != 0 ? null : str5, (i3 & 256) == 0 ? str6 : "", (i3 & 512) == 0 ? z3 : false, (i3 & 1024) == 0 ? i2 : -1);
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
        return new TapTapSdkOptions(str, str2, i, str3, str4, z, z2, jSONObject, this.oaidCert, this.enableLog, TapTapLanguage.INSTANCE.from(this.preferredLanguage));
    }
}
