package com.taptap.sdk.update.bean;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
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

/* JADX INFO: compiled from: ForceUpdateResult.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.BO\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB7\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\rJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\bHÖ\u0001J!\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,HÇ\u0001R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0018¨\u0006/"}, d2 = {"Lcom/taptap/sdk/update/bean/ForceUpdateInfo;", "", "seen1", "", "apkId", "releaseTime", TTDownloadField.TT_VERSION_CODE, TTDownloadField.TT_VERSION_NAME, "", "whatsNew", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIIILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(IIILjava/lang/String;Ljava/lang/String;)V", "getApkId$annotations", "()V", "getApkId", "()I", "getReleaseTime$annotations", "getReleaseTime", "getVersionCode$annotations", "getVersionCode", "getVersionName$annotations", "getVersionName", "()Ljava/lang/String;", "getWhatsNew$annotations", "getWhatsNew", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class ForceUpdateInfo {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int apkId;
    private final int releaseTime;
    private final int versionCode;
    private final String versionName;
    private final String whatsNew;

    public ForceUpdateInfo() {
        this(0, 0, 0, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ForceUpdateInfo copy$default(ForceUpdateInfo forceUpdateInfo, int i, int i2, int i3, String str, String str2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = forceUpdateInfo.apkId;
        }
        if ((i4 & 2) != 0) {
            i2 = forceUpdateInfo.releaseTime;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            i3 = forceUpdateInfo.versionCode;
        }
        int i6 = i3;
        if ((i4 & 8) != 0) {
            str = forceUpdateInfo.versionName;
        }
        String str3 = str;
        if ((i4 & 16) != 0) {
            str2 = forceUpdateInfo.whatsNew;
        }
        return forceUpdateInfo.copy(i, i5, i6, str3, str2);
    }

    @SerialName("apk_id")
    public static /* synthetic */ void getApkId$annotations() {
    }

    @SerialName("release_time")
    public static /* synthetic */ void getReleaseTime$annotations() {
    }

    @SerialName("version_code")
    public static /* synthetic */ void getVersionCode$annotations() {
    }

    @SerialName(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME)
    public static /* synthetic */ void getVersionName$annotations() {
    }

    @SerialName("whats_new")
    public static /* synthetic */ void getWhatsNew$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getApkId() {
        return this.apkId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getReleaseTime() {
        return this.releaseTime;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getVersionCode() {
        return this.versionCode;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getVersionName() {
        return this.versionName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getWhatsNew() {
        return this.whatsNew;
    }

    public final ForceUpdateInfo copy(int apkId, int releaseTime, int versionCode, String versionName, String whatsNew) {
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(whatsNew, "whatsNew");
        return new ForceUpdateInfo(apkId, releaseTime, versionCode, versionName, whatsNew);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ForceUpdateInfo)) {
            return false;
        }
        ForceUpdateInfo forceUpdateInfo = (ForceUpdateInfo) other;
        return this.apkId == forceUpdateInfo.apkId && this.releaseTime == forceUpdateInfo.releaseTime && this.versionCode == forceUpdateInfo.versionCode && Intrinsics.areEqual(this.versionName, forceUpdateInfo.versionName) && Intrinsics.areEqual(this.whatsNew, forceUpdateInfo.whatsNew);
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.apkId) * 31) + Integer.hashCode(this.releaseTime)) * 31) + Integer.hashCode(this.versionCode)) * 31) + this.versionName.hashCode()) * 31) + this.whatsNew.hashCode();
    }

    public String toString() {
        return "ForceUpdateInfo(apkId=" + this.apkId + ", releaseTime=" + this.releaseTime + ", versionCode=" + this.versionCode + ", versionName=" + this.versionName + ", whatsNew=" + this.whatsNew + ')';
    }

    /* JADX INFO: compiled from: ForceUpdateResult.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/update/bean/ForceUpdateInfo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/update/bean/ForceUpdateInfo;", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ForceUpdateInfo> serializer() {
            return ForceUpdateInfo$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ForceUpdateInfo(int i, @SerialName("apk_id") int i2, @SerialName("release_time") int i3, @SerialName("version_code") int i4, @SerialName(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME) String str, @SerialName("whats_new") String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, ForceUpdateInfo$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.apkId = 0;
        } else {
            this.apkId = i2;
        }
        if ((i & 2) == 0) {
            this.releaseTime = 0;
        } else {
            this.releaseTime = i3;
        }
        if ((i & 4) == 0) {
            this.versionCode = 0;
        } else {
            this.versionCode = i4;
        }
        if ((i & 8) == 0) {
            this.versionName = "";
        } else {
            this.versionName = str;
        }
        if ((i & 16) == 0) {
            this.whatsNew = "";
        } else {
            this.whatsNew = str2;
        }
    }

    public ForceUpdateInfo(int i, int i2, int i3, String versionName, String whatsNew) {
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(whatsNew, "whatsNew");
        this.apkId = i;
        this.releaseTime = i2;
        this.versionCode = i3;
        this.versionName = versionName;
        this.whatsNew = whatsNew;
    }

    @JvmStatic
    public static final void write$Self(ForceUpdateInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.apkId != 0) {
            output.encodeIntElement(serialDesc, 0, self.apkId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.releaseTime != 0) {
            output.encodeIntElement(serialDesc, 1, self.releaseTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.versionCode != 0) {
            output.encodeIntElement(serialDesc, 2, self.versionCode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.versionName, "")) {
            output.encodeStringElement(serialDesc, 3, self.versionName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.whatsNew, "")) {
            output.encodeStringElement(serialDesc, 4, self.whatsNew);
        }
    }

    public /* synthetic */ ForceUpdateInfo(int i, int i2, int i3, String str, String str2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) == 0 ? i3 : 0, (i4 & 8) != 0 ? "" : str, (i4 & 16) != 0 ? "" : str2);
    }

    public final int getApkId() {
        return this.apkId;
    }

    public final int getReleaseTime() {
        return this.releaseTime;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final String getWhatsNew() {
        return this.whatsNew;
    }
}
