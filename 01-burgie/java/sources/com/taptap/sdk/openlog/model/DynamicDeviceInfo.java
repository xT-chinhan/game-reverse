package com.taptap.sdk.openlog.model;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.db.constant.Common;
import com.umeng.analytics.pro.an;
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

/* JADX INFO: compiled from: DynamicDeviceInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 J2\u00020\u0001:\u0002IJB©\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013B\u0081\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0014J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u008f\u0001\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020\u0003HÖ\u0001J\t\u0010@\u001a\u00020\u0005HÖ\u0001J&\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00002\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GHÁ\u0001¢\u0006\u0002\bHR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u0018R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0018R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010\u0018R\u001c\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0016\u001a\u0004\b$\u0010\u0018R\u001c\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u0018R\u001c\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0016\u001a\u0004\b(\u0010\u0018R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0016\u001a\u0004\b*\u0010\u0018R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0016\u001a\u0004\b,\u0010\u0018R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u0016\u001a\u0004\b.\u0010\u0018¨\u0006K"}, d2 = {"Lcom/taptap/sdk/openlog/model/DynamicDeviceInfo;", "", "seen1", "", an.M, "", "tapSdkArtifact", "gameUserId", "openId", Common.Predefined.GID, Common.Predefined.SUB_ROM, Common.Predefined.SUB_RAM, "networkType", "mobileType", "sdkLocale", Common.Predefined.TDID, "gaid", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getGaid$annotations", "()V", "getGaid", "()Ljava/lang/String;", "getGameUserId$annotations", "getGameUserId", "getGid$annotations", "getGid", "getMobileType$annotations", "getMobileType", "getNetworkType$annotations", "getNetworkType", "getOpenId$annotations", "getOpenId", "getRam$annotations", "getRam", "getRom$annotations", "getRom", "getSdkLocale$annotations", "getSdkLocale", "getTapSdkArtifact$annotations", "getTapSdkArtifact", "getTdid$annotations", "getTdid", "getTimezone$annotations", "getTimezone", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$tap_core_release", "$serializer", "Companion", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class DynamicDeviceInfo {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String gaid;
    private final String gameUserId;
    private final String gid;
    private final String mobileType;
    private final String networkType;
    private final String openId;
    private final String ram;
    private final String rom;
    private final String sdkLocale;
    private final String tapSdkArtifact;
    private final String tdid;
    private final String timezone;

    @SerialName("gaid")
    public static /* synthetic */ void getGaid$annotations() {
    }

    @SerialName("game_user_id")
    public static /* synthetic */ void getGameUserId$annotations() {
    }

    @SerialName(Common.Predefined.GID)
    public static /* synthetic */ void getGid$annotations() {
    }

    @SerialName(Common.Predefined.SUB_MOBILE_TYPE)
    public static /* synthetic */ void getMobileType$annotations() {
    }

    @SerialName("network_type")
    public static /* synthetic */ void getNetworkType$annotations() {
    }

    @SerialName(Common.Predefined.OPEN_ID)
    public static /* synthetic */ void getOpenId$annotations() {
    }

    @SerialName(Common.Predefined.SUB_RAM)
    public static /* synthetic */ void getRam$annotations() {
    }

    @SerialName(Common.Predefined.SUB_ROM)
    public static /* synthetic */ void getRom$annotations() {
    }

    @SerialName("sdk_locale")
    public static /* synthetic */ void getSdkLocale$annotations() {
    }

    @SerialName("tapsdk_artifact")
    public static /* synthetic */ void getTapSdkArtifact$annotations() {
    }

    @SerialName(Common.Predefined.TDID)
    public static /* synthetic */ void getTdid$annotations() {
    }

    @SerialName(an.M)
    public static /* synthetic */ void getTimezone$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTimezone() {
        return this.timezone;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getSdkLocale() {
        return this.sdkLocale;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getTdid() {
        return this.tdid;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getGaid() {
        return this.gaid;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTapSdkArtifact() {
        return this.tapSdkArtifact;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getGameUserId() {
        return this.gameUserId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getOpenId() {
        return this.openId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getGid() {
        return this.gid;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getRom() {
        return this.rom;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getRam() {
        return this.ram;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getNetworkType() {
        return this.networkType;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getMobileType() {
        return this.mobileType;
    }

    public final DynamicDeviceInfo copy(String timezone, String tapSdkArtifact, String gameUserId, String openId, String gid, String rom, String ram, String networkType, String mobileType, String sdkLocale, String tdid, String gaid) {
        Intrinsics.checkNotNullParameter(timezone, "timezone");
        Intrinsics.checkNotNullParameter(tapSdkArtifact, "tapSdkArtifact");
        Intrinsics.checkNotNullParameter(rom, "rom");
        Intrinsics.checkNotNullParameter(ram, "ram");
        Intrinsics.checkNotNullParameter(sdkLocale, "sdkLocale");
        return new DynamicDeviceInfo(timezone, tapSdkArtifact, gameUserId, openId, gid, rom, ram, networkType, mobileType, sdkLocale, tdid, gaid);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DynamicDeviceInfo)) {
            return false;
        }
        DynamicDeviceInfo dynamicDeviceInfo = (DynamicDeviceInfo) other;
        return Intrinsics.areEqual(this.timezone, dynamicDeviceInfo.timezone) && Intrinsics.areEqual(this.tapSdkArtifact, dynamicDeviceInfo.tapSdkArtifact) && Intrinsics.areEqual(this.gameUserId, dynamicDeviceInfo.gameUserId) && Intrinsics.areEqual(this.openId, dynamicDeviceInfo.openId) && Intrinsics.areEqual(this.gid, dynamicDeviceInfo.gid) && Intrinsics.areEqual(this.rom, dynamicDeviceInfo.rom) && Intrinsics.areEqual(this.ram, dynamicDeviceInfo.ram) && Intrinsics.areEqual(this.networkType, dynamicDeviceInfo.networkType) && Intrinsics.areEqual(this.mobileType, dynamicDeviceInfo.mobileType) && Intrinsics.areEqual(this.sdkLocale, dynamicDeviceInfo.sdkLocale) && Intrinsics.areEqual(this.tdid, dynamicDeviceInfo.tdid) && Intrinsics.areEqual(this.gaid, dynamicDeviceInfo.gaid);
    }

    public int hashCode() {
        int iHashCode = ((this.timezone.hashCode() * 31) + this.tapSdkArtifact.hashCode()) * 31;
        String str = this.gameUserId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.openId;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.gid;
        int iHashCode4 = (((((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.rom.hashCode()) * 31) + this.ram.hashCode()) * 31;
        String str4 = this.networkType;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.mobileType;
        int iHashCode6 = (((iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.sdkLocale.hashCode()) * 31;
        String str6 = this.tdid;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.gaid;
        return iHashCode7 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DynamicDeviceInfo(timezone=").append(this.timezone).append(", tapSdkArtifact=").append(this.tapSdkArtifact).append(", gameUserId=").append(this.gameUserId).append(", openId=").append(this.openId).append(", gid=").append(this.gid).append(", rom=").append(this.rom).append(", ram=").append(this.ram).append(", networkType=").append(this.networkType).append(", mobileType=").append(this.mobileType).append(", sdkLocale=").append(this.sdkLocale).append(", tdid=").append(this.tdid).append(", gaid=");
        sb.append(this.gaid).append(')');
        return sb.toString();
    }

    /* JADX INFO: compiled from: DynamicDeviceInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/openlog/model/DynamicDeviceInfo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/openlog/model/DynamicDeviceInfo;", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DynamicDeviceInfo> serializer() {
            return DynamicDeviceInfo$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ DynamicDeviceInfo(int seen1, @SerialName(an.M) String timezone, @SerialName("tapsdk_artifact") String tapSdkArtifact, @SerialName("game_user_id") String gameUserId, @SerialName(Common.Predefined.OPEN_ID) String openId, @SerialName(Common.Predefined.GID) String gid, @SerialName(Common.Predefined.SUB_ROM) String rom, @SerialName(Common.Predefined.SUB_RAM) String ram, @SerialName("network_type") String networkType, @SerialName(Common.Predefined.SUB_MOBILE_TYPE) String mobileType, @SerialName("sdk_locale") String sdkLocale, @SerialName(Common.Predefined.TDID) String tdid, @SerialName("gaid") String gaid, SerializationConstructorMarker serializationConstructorMarker) {
        if (611 != (seen1 & MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE)) {
            PluginExceptionsKt.throwMissingFieldException(seen1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE, DynamicDeviceInfo$$serializer.INSTANCE.getDescriptor());
        }
        this.timezone = timezone;
        this.tapSdkArtifact = tapSdkArtifact;
        if ((seen1 & 4) == 0) {
            this.gameUserId = null;
        } else {
            this.gameUserId = gameUserId;
        }
        if ((seen1 & 8) == 0) {
            this.openId = null;
        } else {
            this.openId = openId;
        }
        if ((seen1 & 16) == 0) {
            this.gid = null;
        } else {
            this.gid = gid;
        }
        this.rom = rom;
        this.ram = ram;
        if ((seen1 & 128) == 0) {
            this.networkType = null;
        } else {
            this.networkType = networkType;
        }
        if ((seen1 & 256) == 0) {
            this.mobileType = null;
        } else {
            this.mobileType = mobileType;
        }
        this.sdkLocale = sdkLocale;
        if ((seen1 & 1024) == 0) {
            this.tdid = null;
        } else {
            this.tdid = tdid;
        }
        if ((seen1 & 2048) == 0) {
            this.gaid = null;
        } else {
            this.gaid = gaid;
        }
    }

    public DynamicDeviceInfo(String timezone, String tapSdkArtifact, String gameUserId, String openId, String gid, String rom, String ram, String networkType, String mobileType, String sdkLocale, String tdid, String gaid) {
        Intrinsics.checkNotNullParameter(timezone, "timezone");
        Intrinsics.checkNotNullParameter(tapSdkArtifact, "tapSdkArtifact");
        Intrinsics.checkNotNullParameter(rom, "rom");
        Intrinsics.checkNotNullParameter(ram, "ram");
        Intrinsics.checkNotNullParameter(sdkLocale, "sdkLocale");
        this.timezone = timezone;
        this.tapSdkArtifact = tapSdkArtifact;
        this.gameUserId = gameUserId;
        this.openId = openId;
        this.gid = gid;
        this.rom = rom;
        this.ram = ram;
        this.networkType = networkType;
        this.mobileType = mobileType;
        this.sdkLocale = sdkLocale;
        this.tdid = tdid;
        this.gaid = gaid;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$tap_core_release(DynamicDeviceInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.timezone);
        output.encodeStringElement(serialDesc, 1, self.tapSdkArtifact);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.gameUserId != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.gameUserId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.openId != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.openId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.gid != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.gid);
        }
        output.encodeStringElement(serialDesc, 5, self.rom);
        output.encodeStringElement(serialDesc, 6, self.ram);
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.networkType != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.networkType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.mobileType != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.mobileType);
        }
        output.encodeStringElement(serialDesc, 9, self.sdkLocale);
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.tdid != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.tdid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.gaid != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.gaid);
        }
    }

    public /* synthetic */ DynamicDeviceInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, str6, str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, str10, (i & 1024) != 0 ? null : str11, (i & 2048) != 0 ? null : str12);
    }

    public final String getTimezone() {
        return this.timezone;
    }

    public final String getTapSdkArtifact() {
        return this.tapSdkArtifact;
    }

    public final String getGameUserId() {
        return this.gameUserId;
    }

    public final String getOpenId() {
        return this.openId;
    }

    public final String getGid() {
        return this.gid;
    }

    public final String getRom() {
        return this.rom;
    }

    public final String getRam() {
        return this.ram;
    }

    public final String getNetworkType() {
        return this.networkType;
    }

    public final String getMobileType() {
        return this.mobileType;
    }

    public final String getSdkLocale() {
        return this.sdkLocale;
    }

    public final String getTdid() {
        return this.tdid;
    }

    public final String getGaid() {
        return this.gaid;
    }
}
