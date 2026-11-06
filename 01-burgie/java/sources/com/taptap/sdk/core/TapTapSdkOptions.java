package com.taptap.sdk.core;

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

/* JADX INFO: compiled from: TapTapSdkOptions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 C2\u00020\u0001:\u0002BCBg\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0001\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010BI\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u0011J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00101\u001a\u00020\nHÆ\u0003J\t\u00102\u001a\u00020\fHÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003JQ\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u00105\u001a\u00020\n2\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u00020\u0003HÖ\u0001J\t\u00109\u001a\u00020\u0005HÖ\u0001J&\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@HÁ\u0001¢\u0006\u0002\bAR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R$\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR&\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010 R$\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b!\u0010\u0013\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0013\u001a\u0004\b'\u0010(R$\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b)\u0010\u0013\u001a\u0004\b*\u0010(\"\u0004\b+\u0010,¨\u0006D"}, d2 = {"Lcom/taptap/sdk/core/TapTapSdkOptions;", "Lcom/taptap/sdk/core/TapTapSdkBaseOptions;", "seen1", "", "clientId", "", "clientToken", "region", "gameVersion", "enableLog", "", "preferredLanguage", "Lcom/taptap/sdk/core/TapTapLanguage;", "screenOrientation", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;ZLcom/taptap/sdk/core/TapTapLanguage;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZLcom/taptap/sdk/core/TapTapLanguage;I)V", "getClientId$annotations", "()V", "getClientId", "()Ljava/lang/String;", "getClientToken$annotations", "getClientToken", "getEnableLog$annotations", "getEnableLog", "()Z", "setEnableLog", "(Z)V", "getGameVersion$annotations", "getGameVersion", "setGameVersion", "(Ljava/lang/String;)V", "getPreferredLanguage$annotations", "getPreferredLanguage", "()Lcom/taptap/sdk/core/TapTapLanguage;", "setPreferredLanguage", "(Lcom/taptap/sdk/core/TapTapLanguage;)V", "getRegion$annotations", "getRegion", "()I", "getScreenOrientation$annotations", "getScreenOrientation", "setScreenOrientation", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$tap_core_release", "$serializer", "Companion", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class TapTapSdkOptions implements TapTapSdkBaseOptions {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String clientId;
    private final String clientToken;
    private boolean enableLog;
    private String gameVersion;
    private TapTapLanguage preferredLanguage;
    private final int region;
    private int screenOrientation;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TapTapSdkOptions(String clientId, String clientToken, int i) {
        this(clientId, clientToken, i, (String) null, false, (TapTapLanguage) null, 0, 120, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(clientToken, "clientToken");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TapTapSdkOptions(String clientId, String clientToken, int i, String str) {
        this(clientId, clientToken, i, str, false, (TapTapLanguage) null, 0, 112, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(clientToken, "clientToken");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TapTapSdkOptions(String clientId, String clientToken, int i, String str, boolean z) {
        this(clientId, clientToken, i, str, z, (TapTapLanguage) null, 0, 96, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(clientToken, "clientToken");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TapTapSdkOptions(String clientId, String clientToken, int i, String str, boolean z, TapTapLanguage preferredLanguage) {
        this(clientId, clientToken, i, str, z, preferredLanguage, 0, 64, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(clientToken, "clientToken");
        Intrinsics.checkNotNullParameter(preferredLanguage, "preferredLanguage");
    }

    public static /* synthetic */ TapTapSdkOptions copy$default(TapTapSdkOptions tapTapSdkOptions, String str, String str2, int i, String str3, boolean z, TapTapLanguage tapTapLanguage, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = tapTapSdkOptions.clientId;
        }
        if ((i3 & 2) != 0) {
            str2 = tapTapSdkOptions.clientToken;
        }
        String str4 = str2;
        if ((i3 & 4) != 0) {
            i = tapTapSdkOptions.region;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            str3 = tapTapSdkOptions.gameVersion;
        }
        String str5 = str3;
        if ((i3 & 16) != 0) {
            z = tapTapSdkOptions.enableLog;
        }
        boolean z2 = z;
        if ((i3 & 32) != 0) {
            tapTapLanguage = tapTapSdkOptions.preferredLanguage;
        }
        TapTapLanguage tapTapLanguage2 = tapTapLanguage;
        if ((i3 & 64) != 0) {
            i2 = tapTapSdkOptions.screenOrientation;
        }
        return tapTapSdkOptions.copy(str, str4, i4, str5, z2, tapTapLanguage2, i2);
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

    @SerialName("preferredLanguage")
    public static /* synthetic */ void getPreferredLanguage$annotations() {
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

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getClientToken() {
        return this.clientToken;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getRegion() {
        return this.region;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getGameVersion() {
        return this.gameVersion;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getEnableLog() {
        return this.enableLog;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final TapTapLanguage getPreferredLanguage() {
        return this.preferredLanguage;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getScreenOrientation() {
        return this.screenOrientation;
    }

    public final TapTapSdkOptions copy(String clientId, String clientToken, int region, String gameVersion, boolean enableLog, TapTapLanguage preferredLanguage, int screenOrientation) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(clientToken, "clientToken");
        Intrinsics.checkNotNullParameter(preferredLanguage, "preferredLanguage");
        return new TapTapSdkOptions(clientId, clientToken, region, gameVersion, enableLog, preferredLanguage, screenOrientation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TapTapSdkOptions)) {
            return false;
        }
        TapTapSdkOptions tapTapSdkOptions = (TapTapSdkOptions) other;
        return Intrinsics.areEqual(this.clientId, tapTapSdkOptions.clientId) && Intrinsics.areEqual(this.clientToken, tapTapSdkOptions.clientToken) && this.region == tapTapSdkOptions.region && Intrinsics.areEqual(this.gameVersion, tapTapSdkOptions.gameVersion) && this.enableLog == tapTapSdkOptions.enableLog && this.preferredLanguage == tapTapSdkOptions.preferredLanguage && this.screenOrientation == tapTapSdkOptions.screenOrientation;
    }

    public int hashCode() {
        int iHashCode = ((((this.clientId.hashCode() * 31) + this.clientToken.hashCode()) * 31) + Integer.hashCode(this.region)) * 31;
        String str = this.gameVersion;
        return ((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.enableLog)) * 31) + this.preferredLanguage.hashCode()) * 31) + Integer.hashCode(this.screenOrientation);
    }

    public String toString() {
        return "TapTapSdkOptions(clientId=" + this.clientId + ", clientToken=" + this.clientToken + ", region=" + this.region + ", gameVersion=" + this.gameVersion + ", enableLog=" + this.enableLog + ", preferredLanguage=" + this.preferredLanguage + ", screenOrientation=" + this.screenOrientation + ')';
    }

    /* JADX INFO: compiled from: TapTapSdkOptions.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/core/TapTapSdkOptions$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/core/TapTapSdkOptions;", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<TapTapSdkOptions> serializer() {
            return TapTapSdkOptions$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ TapTapSdkOptions(int seen1, @SerialName("clientId") String clientId, @SerialName("clientToken") String clientToken, @SerialName("region") int region, @SerialName("gameVersion") String gameVersion, @SerialName("enableLog") boolean enableLog, @SerialName("preferredLanguage") TapTapLanguage preferredLanguage, @SerialName("screenOrientation") int screenOrientation, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (seen1 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(seen1, 7, TapTapSdkOptions$$serializer.INSTANCE.getDescriptor());
        }
        this.clientId = clientId;
        this.clientToken = clientToken;
        this.region = region;
        if ((seen1 & 8) == 0) {
            this.gameVersion = null;
        } else {
            this.gameVersion = gameVersion;
        }
        if ((seen1 & 16) == 0) {
            this.enableLog = false;
        } else {
            this.enableLog = enableLog;
        }
        if ((seen1 & 32) == 0) {
            this.preferredLanguage = TapTapLanguage.AUTO;
        } else {
            this.preferredLanguage = preferredLanguage;
        }
        if ((seen1 & 64) == 0) {
            this.screenOrientation = 1;
        } else {
            this.screenOrientation = screenOrientation;
        }
    }

    public TapTapSdkOptions(String clientId, String clientToken, int region, String gameVersion, boolean enableLog, TapTapLanguage preferredLanguage, int screenOrientation) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(clientToken, "clientToken");
        Intrinsics.checkNotNullParameter(preferredLanguage, "preferredLanguage");
        this.clientId = clientId;
        this.clientToken = clientToken;
        this.region = region;
        this.gameVersion = gameVersion;
        this.enableLog = enableLog;
        this.preferredLanguage = preferredLanguage;
        this.screenOrientation = screenOrientation;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$tap_core_release(TapTapSdkOptions self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean z = false;
        output.encodeStringElement(serialDesc, 0, self.clientId);
        output.encodeStringElement(serialDesc, 1, self.clientToken);
        output.encodeIntElement(serialDesc, 2, self.region);
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.gameVersion != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.gameVersion);
        }
        boolean z2 = output.shouldEncodeElementDefault(serialDesc, 4) || self.enableLog;
        if (z2) {
            output.encodeBooleanElement(serialDesc, 4, self.enableLog);
        }
        boolean z3 = output.shouldEncodeElementDefault(serialDesc, 5) || self.preferredLanguage != TapTapLanguage.AUTO;
        if (z3) {
            output.encodeSerializableElement(serialDesc, 5, TapTapLanguage$$serializer.INSTANCE, self.preferredLanguage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.screenOrientation != 1) {
            z = true;
        }
        if (z) {
            output.encodeIntElement(serialDesc, 6, self.screenOrientation);
        }
    }

    public /* synthetic */ TapTapSdkOptions(String str, String str2, int i, String str3, boolean z, TapTapLanguage tapTapLanguage, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, (i3 & 8) != 0 ? null : str3, (i3 & 16) != 0 ? false : z, (i3 & 32) != 0 ? TapTapLanguage.AUTO : tapTapLanguage, (i3 & 64) != 0 ? 1 : i2);
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

    public final String getGameVersion() {
        return this.gameVersion;
    }

    public final void setGameVersion(String str) {
        this.gameVersion = str;
    }

    public final boolean getEnableLog() {
        return this.enableLog;
    }

    public final void setEnableLog(boolean z) {
        this.enableLog = z;
    }

    public final TapTapLanguage getPreferredLanguage() {
        return this.preferredLanguage;
    }

    public final void setPreferredLanguage(TapTapLanguage tapTapLanguage) {
        Intrinsics.checkNotNullParameter(tapTapLanguage, "<set-?>");
        this.preferredLanguage = tapTapLanguage;
    }

    public final int getScreenOrientation() {
        return this.screenOrientation;
    }

    public final void setScreenOrientation(int i) {
        this.screenOrientation = i;
    }
}
