package com.taptap.sdk.initializer.api.option;

import com.kwad.sdk.api.model.AdnName;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.initializer.api.model.Language;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: TapTapSdkOptions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b+\b\u0086\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\n¢\u0006\u0002\u0010\u0015J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\nHÆ\u0003J\t\u0010+\u001a\u00020\u0011HÆ\u0003J\t\u0010,\u001a\u00020\nHÆ\u0003J\t\u0010-\u001a\u00020\nHÆ\u0003J\t\u0010.\u001a\u00020\nHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00103\u001a\u00020\nHÆ\u0003J\t\u00104\u001a\u00020\nHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u009d\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\nHÆ\u0001J\u0013\u00108\u001a\u00020\n2\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\u0006HÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\u0014\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0013\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u0011\u0010\u0012\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017¨\u0006<"}, d2 = {"Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "", "clientId", "", "clientToken", "region", "", "channel", "gameVersion", "autoIAPEventEnabled", "", "overrideBuiltInParameters", TapEventParamConstants.PARAM_PROPERTIES, "Lorg/json/JSONObject;", "oaidCert", "enableLog", "preferredLanguage", "Lcom/taptap/sdk/initializer/api/model/Language;", "useAgeRange", "showSwitchAccount", "enableToast", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZZLorg/json/JSONObject;Ljava/lang/String;ZLcom/taptap/sdk/initializer/api/model/Language;ZZZ)V", "getAutoIAPEventEnabled", "()Z", "getChannel", "()Ljava/lang/String;", "getClientId", "getClientToken", "getEnableLog", "getEnableToast", "getGameVersion", "getOaidCert", "getOverrideBuiltInParameters", "getPreferredLanguage", "()Lcom/taptap/sdk/initializer/api/model/Language;", "getProperties", "()Lorg/json/JSONObject;", "getRegion", "()I", "getShowSwitchAccount", "getUseAgeRange", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", AdnName.OTHER, "hashCode", "toString", "tap-initializer-api_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class TapTapSdkOptions {
    private final boolean autoIAPEventEnabled;
    private final String channel;
    private final String clientId;
    private final String clientToken;
    private final boolean enableLog;
    private final boolean enableToast;
    private final String gameVersion;
    private final String oaidCert;
    private final boolean overrideBuiltInParameters;
    private final Language preferredLanguage;
    private final JSONObject properties;
    private final int region;
    private final boolean showSwitchAccount;
    private final boolean useAgeRange;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getEnableLog() {
        return this.enableLog;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Language getPreferredLanguage() {
        return this.preferredLanguage;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getUseAgeRange() {
        return this.useAgeRange;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getShowSwitchAccount() {
        return this.showSwitchAccount;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final boolean getEnableToast() {
        return this.enableToast;
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
    public final JSONObject getProperties() {
        return this.properties;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getOaidCert() {
        return this.oaidCert;
    }

    public final TapTapSdkOptions copy(String clientId, String clientToken, int region, String channel, String gameVersion, boolean autoIAPEventEnabled, boolean overrideBuiltInParameters, JSONObject properties, String oaidCert, boolean enableLog, Language preferredLanguage, boolean useAgeRange, boolean showSwitchAccount, boolean enableToast) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(clientToken, "clientToken");
        Intrinsics.checkNotNullParameter(preferredLanguage, "preferredLanguage");
        return new TapTapSdkOptions(clientId, clientToken, region, channel, gameVersion, autoIAPEventEnabled, overrideBuiltInParameters, properties, oaidCert, enableLog, preferredLanguage, useAgeRange, showSwitchAccount, enableToast);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TapTapSdkOptions)) {
            return false;
        }
        TapTapSdkOptions tapTapSdkOptions = (TapTapSdkOptions) other;
        return Intrinsics.areEqual(this.clientId, tapTapSdkOptions.clientId) && Intrinsics.areEqual(this.clientToken, tapTapSdkOptions.clientToken) && this.region == tapTapSdkOptions.region && Intrinsics.areEqual(this.channel, tapTapSdkOptions.channel) && Intrinsics.areEqual(this.gameVersion, tapTapSdkOptions.gameVersion) && this.autoIAPEventEnabled == tapTapSdkOptions.autoIAPEventEnabled && this.overrideBuiltInParameters == tapTapSdkOptions.overrideBuiltInParameters && Intrinsics.areEqual(this.properties, tapTapSdkOptions.properties) && Intrinsics.areEqual(this.oaidCert, tapTapSdkOptions.oaidCert) && this.enableLog == tapTapSdkOptions.enableLog && this.preferredLanguage == tapTapSdkOptions.preferredLanguage && this.useAgeRange == tapTapSdkOptions.useAgeRange && this.showSwitchAccount == tapTapSdkOptions.showSwitchAccount && this.enableToast == tapTapSdkOptions.enableToast;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r0v25, types: [int] */
    /* JADX WARN: Type inference failed for: r0v27, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19, types: [int] */
    /* JADX WARN: Type inference failed for: r1v23, types: [int] */
    /* JADX WARN: Type inference failed for: r1v25, types: [int] */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int iHashCode = ((((this.clientId.hashCode() * 31) + this.clientToken.hashCode()) * 31) + Integer.hashCode(this.region)) * 31;
        String str = this.channel;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.gameVersion;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        boolean z = this.autoIAPEventEnabled;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode3 + r1) * 31;
        boolean z2 = this.overrideBuiltInParameters;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        JSONObject jSONObject = this.properties;
        int iHashCode4 = (i2 + (jSONObject == null ? 0 : jSONObject.hashCode())) * 31;
        String str3 = this.oaidCert;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z3 = this.enableLog;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int iHashCode6 = (((iHashCode5 + r3) * 31) + this.preferredLanguage.hashCode()) * 31;
        boolean z4 = this.useAgeRange;
        ?? r4 = z4;
        if (z4) {
            r4 = 1;
        }
        int i3 = (iHashCode6 + r4) * 31;
        boolean z5 = this.showSwitchAccount;
        ?? r5 = z5;
        if (z5) {
            r5 = 1;
        }
        int i4 = (i3 + r5) * 31;
        boolean z6 = this.enableToast;
        return i4 + (z6 ? 1 : z6);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TapTapSdkOptions(clientId=");
        sb.append(this.clientId).append(", clientToken=").append(this.clientToken).append(", region=").append(this.region).append(", channel=").append(this.channel).append(", gameVersion=").append(this.gameVersion).append(", autoIAPEventEnabled=").append(this.autoIAPEventEnabled).append(", overrideBuiltInParameters=").append(this.overrideBuiltInParameters).append(", properties=").append(this.properties).append(", oaidCert=").append(this.oaidCert).append(", enableLog=").append(this.enableLog).append(", preferredLanguage=").append(this.preferredLanguage).append(", useAgeRange=");
        sb.append(this.useAgeRange).append(", showSwitchAccount=").append(this.showSwitchAccount).append(", enableToast=").append(this.enableToast).append(')');
        return sb.toString();
    }

    public TapTapSdkOptions(String clientId, String clientToken, int i, String str, String str2, boolean z, boolean z2, JSONObject jSONObject, String str3, boolean z3, Language preferredLanguage, boolean z4, boolean z5, boolean z6) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(clientToken, "clientToken");
        Intrinsics.checkNotNullParameter(preferredLanguage, "preferredLanguage");
        this.clientId = clientId;
        this.clientToken = clientToken;
        this.region = i;
        this.channel = str;
        this.gameVersion = str2;
        this.autoIAPEventEnabled = z;
        this.overrideBuiltInParameters = z2;
        this.properties = jSONObject;
        this.oaidCert = str3;
        this.enableLog = z3;
        this.preferredLanguage = preferredLanguage;
        this.useAgeRange = z4;
        this.showSwitchAccount = z5;
        this.enableToast = z6;
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

    public final JSONObject getProperties() {
        return this.properties;
    }

    public final String getOaidCert() {
        return this.oaidCert;
    }

    public final boolean getEnableLog() {
        return this.enableLog;
    }

    public /* synthetic */ TapTapSdkOptions(String str, String str2, int i, String str3, String str4, boolean z, boolean z2, JSONObject jSONObject, String str5, boolean z3, Language language, boolean z4, boolean z5, boolean z6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? false : z, (i2 & 64) != 0 ? false : z2, (i2 & 128) != 0 ? null : jSONObject, (i2 & 256) != 0 ? null : str5, (i2 & 512) != 0 ? false : z3, (i2 & 1024) != 0 ? Language.AUTO : language, (i2 & 2048) != 0 ? false : z4, (i2 & 4096) != 0 ? false : z5, (i2 & 8192) != 0 ? false : z6);
    }

    public final Language getPreferredLanguage() {
        return this.preferredLanguage;
    }

    public final boolean getUseAgeRange() {
        return this.useAgeRange;
    }

    public final boolean getShowSwitchAccount() {
        return this.showSwitchAccount;
    }

    public final boolean getEnableToast() {
        return this.enableToast;
    }
}
