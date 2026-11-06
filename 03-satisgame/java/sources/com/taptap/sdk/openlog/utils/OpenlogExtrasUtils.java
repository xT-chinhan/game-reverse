package com.taptap.sdk.openlog.utils;

import android.content.Context;
import com.anythink.core.common.l.f;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.kit.internal.identifier.TapIdentifierUtil;
import com.taptap.sdk.kit.internal.utils.DeviceUtils;
import com.taptap.sdk.kit.internal.utils.NetworkUtil;
import com.taptap.sdk.kit.internal.utils.PlatformXUA;
import com.taptap.sdk.kit.internal.utils.localize.TapLocalizeUtil;
import com.taptap.sdk.openlog.TapTapOpenlogSdk;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OpenlogExtrasUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b)\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010.H\u0002J\u001c\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010.2\u0006\u00100\u001a\u000201J\u0018\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0004H\u0002J\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010.J\b\u00107\u001a\u00020\u0004H\u0002J\u0016\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000409H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/taptap/sdk/openlog/utils/OpenlogExtrasUtils;", "", "()V", "PARAM_ANDROID_ID", "", "PARAM_APP_PACKAGE_NAME", "PARAM_APP_VERSION", "PARAM_APP_VERSION_CODE", "PARAM_CLIENT_ID", "PARAM_CLIENT_TOKEN", "PARAM_COMMON_OPEN_ID", "PARAM_CPU", "PARAM_CPU_ABIS", "PARAM_DATA_DIR", "PARAM_DEVICE_ID", "PARAM_DV", "PARAM_ENV", "PARAM_GAID", "PARAM_GAME_USER_ID", "PARAM_GID", "PARAM_HARDWARE", "PARAM_HEIGHT", "PARAM_INSTALL_UUID", "PARAM_LOG_LEVEL", "PARAM_LOG_TO_CONSOLE", "PARAM_MD", "PARAM_MOBILE_TYPE", "PARAM_NETWORK_TYPE", "PARAM_OAID", "PARAM_OPEN_ID", "PARAM_OS", "PARAM_PLATFORM", "PARAM_PN", "PARAM_RAM", "PARAM_REGION", "PARAM_ROM", "PARAM_SDK_LOCALE", "PARAM_SV", "PARAM_TAPSDK_ARTIFACT", "PARAM_TIMEZONE", "PARAM_TOTAL_RAM", "PARAM_TOTAL_ROM", "PARAM_UA", "PARAM_WIDTH", "PATH_DATA_DIR", "getCommonExtras", "", "getConfig", "context", "Landroid/content/Context;", "getDataDir", "filesDir", "Ljava/io/File;", "path", "getDynamicExtras", "getEnvironment", "getOaidOrGaid", "Lkotlin/Pair;", "tap-openlog_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class OpenlogExtrasUtils {
    public static final OpenlogExtrasUtils INSTANCE = new OpenlogExtrasUtils();
    private static final String PARAM_ANDROID_ID = "android_id";
    private static final String PARAM_APP_PACKAGE_NAME = "app_package_name";
    private static final String PARAM_APP_VERSION = "app_version";
    private static final String PARAM_APP_VERSION_CODE = "app_version_code";
    private static final String PARAM_CLIENT_ID = "client_id";
    private static final String PARAM_CLIENT_TOKEN = "client_token";
    public static final String PARAM_COMMON_OPEN_ID = "open_id";
    private static final String PARAM_CPU = "cpu";
    private static final String PARAM_CPU_ABIS = "cpu_abis";
    private static final String PARAM_DATA_DIR = "data_dir";
    private static final String PARAM_DEVICE_ID = "device_id";
    private static final String PARAM_DV = "dv";
    private static final String PARAM_ENV = "env";
    private static final String PARAM_GAID = "gaid";
    private static final String PARAM_GAME_USER_ID = "game_user_id";
    private static final String PARAM_GID = "gid";
    private static final String PARAM_HARDWARE = "hardware";
    private static final String PARAM_HEIGHT = "height";
    private static final String PARAM_INSTALL_UUID = "install_uuid";
    private static final String PARAM_LOG_LEVEL = "log_level";
    private static final String PARAM_LOG_TO_CONSOLE = "log_to_console";
    private static final String PARAM_MD = "md";
    private static final String PARAM_MOBILE_TYPE = "mobile_type";
    private static final String PARAM_NETWORK_TYPE = "network_type";
    private static final String PARAM_OAID = "oaid";
    private static final String PARAM_OPEN_ID = "open_id";
    private static final String PARAM_OS = "os";
    private static final String PARAM_PLATFORM = "platform";
    private static final String PARAM_PN = "pn";
    private static final String PARAM_RAM = "ram";
    private static final String PARAM_REGION = "region";
    private static final String PARAM_ROM = "rom";
    private static final String PARAM_SDK_LOCALE = "sdk_locale";
    private static final String PARAM_SV = "sv";
    private static final String PARAM_TAPSDK_ARTIFACT = "tapsdk_artifact";
    private static final String PARAM_TIMEZONE = "timezone";
    private static final String PARAM_TOTAL_RAM = "total_ram";
    private static final String PARAM_TOTAL_ROM = "total_rom";
    private static final String PARAM_UA = "ua";
    private static final String PARAM_WIDTH = "width";
    private static final String PATH_DATA_DIR = "tapsdk";

    private OpenlogExtrasUtils() {
    }

    public final Map<String, Object> getConfig(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Pair[] pairArr = new Pair[11];
        pairArr[0] = TuplesKt.to(PARAM_REGION, Integer.valueOf(TapTapKit.INSTANCE.isRND() ? 2 : TapTapOpenlogSdk.INSTANCE.getRegion$tap_openlog_release()));
        pairArr[1] = TuplesKt.to(PARAM_LOG_TO_CONSOLE, 0);
        pairArr[2] = TuplesKt.to(PARAM_LOG_LEVEL, 1);
        File filesDir = context.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "context.filesDir");
        pairArr[3] = TuplesKt.to(PARAM_DATA_DIR, getDataDir(filesDir, PATH_DATA_DIR));
        pairArr[4] = TuplesKt.to(PARAM_ENV, getEnvironment());
        pairArr[5] = TuplesKt.to("platform", "Android");
        pairArr[6] = TuplesKt.to("ua", PlatformXUA.getTrackUA());
        pairArr[7] = TuplesKt.to("client_id", TapTapOpenlogSdk.INSTANCE.getClientId$tap_openlog_release());
        pairArr[8] = TuplesKt.to(PARAM_CLIENT_TOKEN, TapTapOpenlogSdk.INSTANCE.getClientToken$tap_openlog_release());
        pairArr[9] = TuplesKt.to(f.Z, getCommonExtras());
        pairArr[10] = TuplesKt.to("app_duration", MapsKt.mapOf(TuplesKt.to("tapsdk_version", "4.5.0")));
        return MapsKt.mapOf(pairArr);
    }

    private final Map<String, Object> getCommonExtras() {
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to(PARAM_APP_PACKAGE_NAME, TapTapOpenlogSdk.INSTANCE.getContext$tap_openlog_release().getPackageName()), TuplesKt.to("app_version", DeviceUtils.getPackageVersion(TapTapOpenlogSdk.INSTANCE.getContext$tap_openlog_release())), TuplesKt.to(PARAM_APP_VERSION_CODE, String.valueOf(DeviceUtils.getPackageVersionCode(TapTapOpenlogSdk.INSTANCE.getContext$tap_openlog_release()))), TuplesKt.to(PARAM_PN, "TapSDK"), TuplesKt.to("platform", "Android"), TuplesKt.to("device_id", TapIdentifierUtil.INSTANCE.getDeviceId(TapTapOpenlogSdk.INSTANCE.getContext$tap_openlog_release())), TuplesKt.to("install_uuid", TapIdentifierUtil.INSTANCE.getInstallUUID()), TuplesKt.to("android_id", TapIdentifierUtil.getAndroidID(TapTapOpenlogSdk.INSTANCE.getContext$tap_openlog_release())), TuplesKt.to("dv", DeviceUtils.getManufacturer()), TuplesKt.to("md", DeviceUtils.getModel()), TuplesKt.to("cpu", DeviceUtils.getCpuInfo()), TuplesKt.to(PARAM_CPU_ABIS, DeviceUtils.getCpuABIS()), TuplesKt.to("os", DeviceUtils.getPlatform()), TuplesKt.to("sv", DeviceUtils.getOS()), TuplesKt.to("width", String.valueOf(DeviceUtils.getDeviceSize(TapTapOpenlogSdk.INSTANCE.getContext$tap_openlog_release())[0])), TuplesKt.to("height", String.valueOf(DeviceUtils.getDeviceSize(TapTapOpenlogSdk.INSTANCE.getContext$tap_openlog_release())[1])), TuplesKt.to("total_rom", String.valueOf(DeviceUtils.getDeviceTotalRom(TapTapOpenlogSdk.INSTANCE.getContext$tap_openlog_release()))), TuplesKt.to("total_ram", String.valueOf(DeviceUtils.getDeviceTotalRam(TapTapOpenlogSdk.INSTANCE.getContext$tap_openlog_release()))), TuplesKt.to(PARAM_HARDWARE, DeviceUtils.getCPUHardware()), TuplesKt.to(PARAM_SDK_LOCALE, TapLocalizeUtil.getPreferredLanguage().getLanguage()), TuplesKt.to("open_id", TapIdentifierUtil.INSTANCE.getOpenId()));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapMapOf.entrySet()) {
            if (((String) entry.getValue()) != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public final Map<String, Object> getDynamicExtras() {
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to("timezone", TimeZone.getDefault().getID()), TuplesKt.to(PARAM_TAPSDK_ARTIFACT, PlatformXUA.getTrackSDKArtifact()), getOaidOrGaid(), TuplesKt.to(PARAM_GAME_USER_ID, TapIdentifierUtil.INSTANCE.getGameUserId()), TuplesKt.to("open_id", TapIdentifierUtil.INSTANCE.getOpenId()), TuplesKt.to("gid", TapIdentifierUtil.INSTANCE.queryGID()), TuplesKt.to("rom", String.valueOf(DeviceUtils.getRemainingRomSize())), TuplesKt.to("ram", String.valueOf(DeviceUtils.getRemainingRamSize(TapTapOpenlogSdk.INSTANCE.getContext$tap_openlog_release()))), TuplesKt.to("network_type", NetworkUtil.getConnectedType(TapTapOpenlogSdk.INSTANCE.getContext$tap_openlog_release())), TuplesKt.to("mobile_type", NetworkUtil.getNetworkType(TapTapOpenlogSdk.INSTANCE.getContext$tap_openlog_release())), TuplesKt.to(PARAM_SDK_LOCALE, TapLocalizeUtil.getPreferredLanguage().getLanguage()));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapMapOf.entrySet()) {
            if (((String) entry.getValue()) != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    private final Pair<String, String> getOaidOrGaid() {
        int region$tap_openlog_release = TapTapOpenlogSdk.INSTANCE.getRegion$tap_openlog_release();
        if (region$tap_openlog_release == 0) {
            return TuplesKt.to("oaid", TapIdentifierUtil.INSTANCE.getOAID());
        }
        if (region$tap_openlog_release == 1) {
            TapIdentifierUtil.GAID gaid = TapIdentifierUtil.INSTANCE.getGAID();
            return TuplesKt.to("gaid", gaid != null ? gaid.getAndroidAdvertiserIdValue() : null);
        }
        throw new IllegalArgumentException("do not support region: " + region$tap_openlog_release);
    }

    private final String getDataDir(File filesDir, String path) {
        File file = new File(filesDir, path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "dir.absolutePath");
        return absolutePath;
    }

    private final String getEnvironment() {
        if (DeviceUtils.isRunInSandbox()) {
            return "sandbox";
        }
        return DeviceUtils.isRunInCloud() ? "cloud" : "local";
    }
}
