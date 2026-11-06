package com.taptap.sdk.openlog.model;

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

/* JADX INFO: compiled from: StaticDeviceInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\bE\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 n2\u00020\u0001:\u0002mnB\u0095\u0002\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cB¿\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u001dJ\t\u0010J\u001a\u00020\u0005HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0005HÆ\u0003J\t\u0010O\u001a\u00020\u0005HÆ\u0003J\t\u0010P\u001a\u00020\u0005HÆ\u0003J\t\u0010Q\u001a\u00020\u0005HÆ\u0003J\t\u0010R\u001a\u00020\u0005HÆ\u0003J\t\u0010S\u001a\u00020\u0005HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010U\u001a\u00020\u0005HÆ\u0003J\t\u0010V\u001a\u00020\u0005HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010X\u001a\u00020\u0005HÆ\u0003J\t\u0010Y\u001a\u00020\u0005HÆ\u0003J\t\u0010Z\u001a\u00020\u0005HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\\\u001a\u00020\u0005HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010^\u001a\u00020\u0005HÆ\u0003Jç\u0001\u0010_\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010`\u001a\u00020a2\b\u0010b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010c\u001a\u00020\u0003HÖ\u0001J\t\u0010d\u001a\u00020\u0005HÖ\u0001J&\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020\u00002\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020kHÁ\u0001¢\u0006\u0002\blR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010!R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!R\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u001f\u001a\u0004\b'\u0010!R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u001f\u001a\u0004\b)\u0010!R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u001f\u001a\u0004\b+\u0010!R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u001f\u001a\u0004\b-\u0010!R\u001c\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u001f\u001a\u0004\b/\u0010!R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u001f\u001a\u0004\b1\u0010!R\u001c\u0010\u0014\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\u001f\u001a\u0004\b3\u0010!R\u001c\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010\u001f\u001a\u0004\b5\u0010!R\u001c\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010\u001f\u001a\u0004\b7\u0010!R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b8\u0010\u001f\u001a\u0004\b9\u0010!R\u001c\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010\u001f\u001a\u0004\b;\u0010!R\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010\u001f\u001a\u0004\b=\u0010!R\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b>\u0010\u001f\u001a\u0004\b?\u0010!R\u001c\u0010\u0018\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010\u001f\u001a\u0004\bA\u0010!R\u001c\u0010\u0012\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bB\u0010\u001f\u001a\u0004\bC\u0010!R\u001c\u0010\u0016\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bD\u0010\u001f\u001a\u0004\bE\u0010!R\u001c\u0010\u0015\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bF\u0010\u001f\u001a\u0004\bG\u0010!R\u001c\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bH\u0010\u001f\u001a\u0004\bI\u0010!¨\u0006o"}, d2 = {"Lcom/taptap/sdk/openlog/model/StaticDeviceInfo;", "", "seen1", "", "appPackageName", "", "appVersion", "appVersionCode", "pn", "platform", "deviceId", "installUuid", "androidId", Common.Predefined.SUB_DV, "md", "cpu", "cpuAbis", "os", Common.Predefined.SUB_SV, "width", "height", "totalRom", "totalRam", "hardware", "sdkLocale", "openId", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAndroidId$annotations", "()V", "getAndroidId", "()Ljava/lang/String;", "getAppPackageName$annotations", "getAppPackageName", "getAppVersion$annotations", "getAppVersion", "getAppVersionCode$annotations", "getAppVersionCode", "getCpu$annotations", "getCpu", "getCpuAbis$annotations", "getCpuAbis", "getDeviceId$annotations", "getDeviceId", "getDv$annotations", "getDv", "getHardware$annotations", "getHardware", "getHeight$annotations", "getHeight", "getInstallUuid$annotations", "getInstallUuid", "getMd$annotations", "getMd", "getOpenId$annotations", "getOpenId", "getOs$annotations", "getOs", "getPlatform$annotations", "getPlatform", "getPn$annotations", "getPn", "getSdkLocale$annotations", "getSdkLocale", "getSv$annotations", "getSv", "getTotalRam$annotations", "getTotalRam", "getTotalRom$annotations", "getTotalRom", "getWidth$annotations", "getWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$tap_core_release", "$serializer", "Companion", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class StaticDeviceInfo {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String androidId;
    private final String appPackageName;
    private final String appVersion;
    private final String appVersionCode;
    private final String cpu;
    private final String cpuAbis;
    private final String deviceId;
    private final String dv;
    private final String hardware;
    private final String height;
    private final String installUuid;
    private final String md;
    private final String openId;
    private final String os;
    private final String platform;
    private final String pn;
    private final String sdkLocale;
    private final String sv;
    private final String totalRam;
    private final String totalRom;
    private final String width;

    @SerialName(Common.Predefined.SUB_ANDROID_ID)
    public static /* synthetic */ void getAndroidId$annotations() {
    }

    @SerialName("app_package_name")
    public static /* synthetic */ void getAppPackageName$annotations() {
    }

    @SerialName("app_version")
    public static /* synthetic */ void getAppVersion$annotations() {
    }

    @SerialName("app_version_code")
    public static /* synthetic */ void getAppVersionCode$annotations() {
    }

    @SerialName("cpu")
    public static /* synthetic */ void getCpu$annotations() {
    }

    @SerialName("cpu_abis")
    public static /* synthetic */ void getCpuAbis$annotations() {
    }

    @SerialName("device_id")
    public static /* synthetic */ void getDeviceId$annotations() {
    }

    @SerialName(Common.Predefined.SUB_DV)
    public static /* synthetic */ void getDv$annotations() {
    }

    @SerialName("hardware")
    public static /* synthetic */ void getHardware$annotations() {
    }

    @SerialName("height")
    public static /* synthetic */ void getHeight$annotations() {
    }

    @SerialName(Common.Predefined.SUB_INSTALL_UUID)
    public static /* synthetic */ void getInstallUuid$annotations() {
    }

    @SerialName("md")
    public static /* synthetic */ void getMd$annotations() {
    }

    @SerialName(Common.Predefined.OPEN_ID)
    public static /* synthetic */ void getOpenId$annotations() {
    }

    @SerialName("os")
    public static /* synthetic */ void getOs$annotations() {
    }

    @SerialName("platform")
    public static /* synthetic */ void getPlatform$annotations() {
    }

    @SerialName("pn")
    public static /* synthetic */ void getPn$annotations() {
    }

    @SerialName("sdk_locale")
    public static /* synthetic */ void getSdkLocale$annotations() {
    }

    @SerialName(Common.Predefined.SUB_SV)
    public static /* synthetic */ void getSv$annotations() {
    }

    @SerialName(Common.Predefined.SUB_TOTAL_RAM)
    public static /* synthetic */ void getTotalRam$annotations() {
    }

    @SerialName(Common.Predefined.SUB_TOTAL_ROM)
    public static /* synthetic */ void getTotalRom$annotations() {
    }

    @SerialName("width")
    public static /* synthetic */ void getWidth$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAppPackageName() {
        return this.appPackageName;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getMd() {
        return this.md;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getCpu() {
        return this.cpu;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getCpuAbis() {
        return this.cpuAbis;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getOs() {
        return this.os;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getSv() {
        return this.sv;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getTotalRom() {
        return this.totalRom;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getTotalRam() {
        return this.totalRam;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getHardware() {
        return this.hardware;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getSdkLocale() {
        return this.sdkLocale;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getOpenId() {
        return this.openId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAppVersionCode() {
        return this.appVersionCode;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPn() {
        return this.pn;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPlatform() {
        return this.platform;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getInstallUuid() {
        return this.installUuid;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getAndroidId() {
        return this.androidId;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getDv() {
        return this.dv;
    }

    public final StaticDeviceInfo copy(String appPackageName, String appVersion, String appVersionCode, String pn, String platform, String deviceId, String installUuid, String androidId, String dv, String md, String cpu, String cpuAbis, String os, String sv, String width, String height, String totalRom, String totalRam, String hardware, String sdkLocale, String openId) {
        Intrinsics.checkNotNullParameter(appPackageName, "appPackageName");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(appVersionCode, "appVersionCode");
        Intrinsics.checkNotNullParameter(pn, "pn");
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(installUuid, "installUuid");
        Intrinsics.checkNotNullParameter(dv, "dv");
        Intrinsics.checkNotNullParameter(md, "md");
        Intrinsics.checkNotNullParameter(os, "os");
        Intrinsics.checkNotNullParameter(sv, "sv");
        Intrinsics.checkNotNullParameter(width, "width");
        Intrinsics.checkNotNullParameter(height, "height");
        Intrinsics.checkNotNullParameter(totalRom, "totalRom");
        Intrinsics.checkNotNullParameter(totalRam, "totalRam");
        Intrinsics.checkNotNullParameter(sdkLocale, "sdkLocale");
        return new StaticDeviceInfo(appPackageName, appVersion, appVersionCode, pn, platform, deviceId, installUuid, androidId, dv, md, cpu, cpuAbis, os, sv, width, height, totalRom, totalRam, hardware, sdkLocale, openId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StaticDeviceInfo)) {
            return false;
        }
        StaticDeviceInfo staticDeviceInfo = (StaticDeviceInfo) other;
        return Intrinsics.areEqual(this.appPackageName, staticDeviceInfo.appPackageName) && Intrinsics.areEqual(this.appVersion, staticDeviceInfo.appVersion) && Intrinsics.areEqual(this.appVersionCode, staticDeviceInfo.appVersionCode) && Intrinsics.areEqual(this.pn, staticDeviceInfo.pn) && Intrinsics.areEqual(this.platform, staticDeviceInfo.platform) && Intrinsics.areEqual(this.deviceId, staticDeviceInfo.deviceId) && Intrinsics.areEqual(this.installUuid, staticDeviceInfo.installUuid) && Intrinsics.areEqual(this.androidId, staticDeviceInfo.androidId) && Intrinsics.areEqual(this.dv, staticDeviceInfo.dv) && Intrinsics.areEqual(this.md, staticDeviceInfo.md) && Intrinsics.areEqual(this.cpu, staticDeviceInfo.cpu) && Intrinsics.areEqual(this.cpuAbis, staticDeviceInfo.cpuAbis) && Intrinsics.areEqual(this.os, staticDeviceInfo.os) && Intrinsics.areEqual(this.sv, staticDeviceInfo.sv) && Intrinsics.areEqual(this.width, staticDeviceInfo.width) && Intrinsics.areEqual(this.height, staticDeviceInfo.height) && Intrinsics.areEqual(this.totalRom, staticDeviceInfo.totalRom) && Intrinsics.areEqual(this.totalRam, staticDeviceInfo.totalRam) && Intrinsics.areEqual(this.hardware, staticDeviceInfo.hardware) && Intrinsics.areEqual(this.sdkLocale, staticDeviceInfo.sdkLocale) && Intrinsics.areEqual(this.openId, staticDeviceInfo.openId);
    }

    public int hashCode() {
        int iHashCode = ((((((((this.appPackageName.hashCode() * 31) + this.appVersion.hashCode()) * 31) + this.appVersionCode.hashCode()) * 31) + this.pn.hashCode()) * 31) + this.platform.hashCode()) * 31;
        String str = this.deviceId;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.installUuid.hashCode()) * 31;
        String str2 = this.androidId;
        int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.dv.hashCode()) * 31) + this.md.hashCode()) * 31;
        String str3 = this.cpu;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.cpuAbis;
        int iHashCode5 = (((((((((((((iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.os.hashCode()) * 31) + this.sv.hashCode()) * 31) + this.width.hashCode()) * 31) + this.height.hashCode()) * 31) + this.totalRom.hashCode()) * 31) + this.totalRam.hashCode()) * 31;
        String str5 = this.hardware;
        int iHashCode6 = (((iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.sdkLocale.hashCode()) * 31;
        String str6 = this.openId;
        return iHashCode6 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StaticDeviceInfo(appPackageName=").append(this.appPackageName).append(", appVersion=").append(this.appVersion).append(", appVersionCode=").append(this.appVersionCode).append(", pn=").append(this.pn).append(", platform=").append(this.platform).append(", deviceId=").append(this.deviceId).append(", installUuid=").append(this.installUuid).append(", androidId=").append(this.androidId).append(", dv=").append(this.dv).append(", md=").append(this.md).append(", cpu=").append(this.cpu).append(", cpuAbis=");
        sb.append(this.cpuAbis).append(", os=").append(this.os).append(", sv=").append(this.sv).append(", width=").append(this.width).append(", height=").append(this.height).append(", totalRom=").append(this.totalRom).append(", totalRam=").append(this.totalRam).append(", hardware=").append(this.hardware).append(", sdkLocale=").append(this.sdkLocale).append(", openId=").append(this.openId).append(')');
        return sb.toString();
    }

    /* JADX INFO: compiled from: StaticDeviceInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/openlog/model/StaticDeviceInfo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/openlog/model/StaticDeviceInfo;", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<StaticDeviceInfo> serializer() {
            return StaticDeviceInfo$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ StaticDeviceInfo(int seen1, @SerialName("app_package_name") String appPackageName, @SerialName("app_version") String appVersion, @SerialName("app_version_code") String appVersionCode, @SerialName("pn") String pn, @SerialName("platform") String platform, @SerialName("device_id") String deviceId, @SerialName(Common.Predefined.SUB_INSTALL_UUID) String installUuid, @SerialName(Common.Predefined.SUB_ANDROID_ID) String androidId, @SerialName(Common.Predefined.SUB_DV) String dv, @SerialName("md") String md, @SerialName("cpu") String cpu, @SerialName("cpu_abis") String cpuAbis, @SerialName("os") String os, @SerialName(Common.Predefined.SUB_SV) String sv, @SerialName("width") String width, @SerialName("height") String height, @SerialName(Common.Predefined.SUB_TOTAL_ROM) String totalRom, @SerialName(Common.Predefined.SUB_TOTAL_RAM) String totalRam, @SerialName("hardware") String hardware, @SerialName("sdk_locale") String sdkLocale, @SerialName(Common.Predefined.OPEN_ID) String openId, SerializationConstructorMarker serializationConstructorMarker) {
        if (2093031 != (seen1 & 2093031)) {
            PluginExceptionsKt.throwMissingFieldException(seen1, 2093031, StaticDeviceInfo$$serializer.INSTANCE.getDescriptor());
        }
        this.appPackageName = appPackageName;
        this.appVersion = appVersion;
        this.appVersionCode = appVersionCode;
        if ((seen1 & 8) == 0) {
            this.pn = "TapSDK";
        } else {
            this.pn = pn;
        }
        if ((seen1 & 16) == 0) {
            this.platform = "Android";
        } else {
            this.platform = platform;
        }
        this.deviceId = deviceId;
        this.installUuid = installUuid;
        this.androidId = androidId;
        this.dv = dv;
        this.md = md;
        this.cpu = cpu;
        this.cpuAbis = cpuAbis;
        if ((seen1 & 4096) == 0) {
            this.os = "android";
        } else {
            this.os = os;
        }
        this.sv = sv;
        this.width = width;
        this.height = height;
        this.totalRom = totalRom;
        this.totalRam = totalRam;
        this.hardware = hardware;
        this.sdkLocale = sdkLocale;
        this.openId = openId;
    }

    public StaticDeviceInfo(String appPackageName, String appVersion, String appVersionCode, String pn, String platform, String deviceId, String installUuid, String androidId, String dv, String md, String cpu, String cpuAbis, String os, String sv, String width, String height, String totalRom, String totalRam, String hardware, String sdkLocale, String openId) {
        Intrinsics.checkNotNullParameter(appPackageName, "appPackageName");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(appVersionCode, "appVersionCode");
        Intrinsics.checkNotNullParameter(pn, "pn");
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(installUuid, "installUuid");
        Intrinsics.checkNotNullParameter(dv, "dv");
        Intrinsics.checkNotNullParameter(md, "md");
        Intrinsics.checkNotNullParameter(os, "os");
        Intrinsics.checkNotNullParameter(sv, "sv");
        Intrinsics.checkNotNullParameter(width, "width");
        Intrinsics.checkNotNullParameter(height, "height");
        Intrinsics.checkNotNullParameter(totalRom, "totalRom");
        Intrinsics.checkNotNullParameter(totalRam, "totalRam");
        Intrinsics.checkNotNullParameter(sdkLocale, "sdkLocale");
        this.appPackageName = appPackageName;
        this.appVersion = appVersion;
        this.appVersionCode = appVersionCode;
        this.pn = pn;
        this.platform = platform;
        this.deviceId = deviceId;
        this.installUuid = installUuid;
        this.androidId = androidId;
        this.dv = dv;
        this.md = md;
        this.cpu = cpu;
        this.cpuAbis = cpuAbis;
        this.os = os;
        this.sv = sv;
        this.width = width;
        this.height = height;
        this.totalRom = totalRom;
        this.totalRam = totalRam;
        this.hardware = hardware;
        this.sdkLocale = sdkLocale;
        this.openId = openId;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$tap_core_release(StaticDeviceInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean z = false;
        output.encodeStringElement(serialDesc, 0, self.appPackageName);
        output.encodeStringElement(serialDesc, 1, self.appVersion);
        output.encodeStringElement(serialDesc, 2, self.appVersionCode);
        boolean z2 = output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.pn, "TapSDK");
        if (z2) {
            output.encodeStringElement(serialDesc, 3, self.pn);
        }
        boolean z3 = output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.platform, "Android");
        if (z3) {
            output.encodeStringElement(serialDesc, 4, self.platform);
        }
        output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.deviceId);
        output.encodeStringElement(serialDesc, 6, self.installUuid);
        output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.androidId);
        output.encodeStringElement(serialDesc, 8, self.dv);
        output.encodeStringElement(serialDesc, 9, self.md);
        output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.cpu);
        output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.cpuAbis);
        if (output.shouldEncodeElementDefault(serialDesc, 12) || !Intrinsics.areEqual(self.os, "android")) {
            z = true;
        }
        if (z) {
            output.encodeStringElement(serialDesc, 12, self.os);
        }
        output.encodeStringElement(serialDesc, 13, self.sv);
        output.encodeStringElement(serialDesc, 14, self.width);
        output.encodeStringElement(serialDesc, 15, self.height);
        output.encodeStringElement(serialDesc, 16, self.totalRom);
        output.encodeStringElement(serialDesc, 17, self.totalRam);
        output.encodeNullableSerializableElement(serialDesc, 18, StringSerializer.INSTANCE, self.hardware);
        output.encodeStringElement(serialDesc, 19, self.sdkLocale);
        output.encodeNullableSerializableElement(serialDesc, 20, StringSerializer.INSTANCE, self.openId);
    }

    public /* synthetic */ StaticDeviceInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? "TapSDK" : str4, (i & 16) != 0 ? "Android" : str5, str6, str7, str8, str9, str10, str11, str12, (i & 4096) != 0 ? "android" : str13, str14, str15, str16, str17, str18, str19, str20, str21);
    }

    public final String getAppPackageName() {
        return this.appPackageName;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getAppVersionCode() {
        return this.appVersionCode;
    }

    public final String getPn() {
        return this.pn;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getInstallUuid() {
        return this.installUuid;
    }

    public final String getAndroidId() {
        return this.androidId;
    }

    public final String getDv() {
        return this.dv;
    }

    public final String getMd() {
        return this.md;
    }

    public final String getCpu() {
        return this.cpu;
    }

    public final String getCpuAbis() {
        return this.cpuAbis;
    }

    public final String getOs() {
        return this.os;
    }

    public final String getSv() {
        return this.sv;
    }

    public final String getWidth() {
        return this.width;
    }

    public final String getHeight() {
        return this.height;
    }

    public final String getTotalRom() {
        return this.totalRom;
    }

    public final String getTotalRam() {
        return this.totalRam;
    }

    public final String getHardware() {
        return this.hardware;
    }

    public final String getSdkLocale() {
        return this.sdkLocale;
    }

    public final String getOpenId() {
        return this.openId;
    }
}
