package com.taptap.sdk.openlog.utils;

import android.content.Context;
import com.taptap.sdk.common.services.GidService;
import com.taptap.sdk.compliance.internal.TapComplianceSettings;
import com.taptap.sdk.core.DBService;
import com.taptap.sdk.initializer.api.model.RegionType;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.kit.internal.identifier.TapIdentifierUtil;
import com.taptap.sdk.kit.internal.utils.DeviceUtils;
import com.taptap.sdk.kit.internal.utils.NetworkUtil;
import com.taptap.sdk.kit.internal.utils.PlatformXUA;
import com.taptap.sdk.kit.internal.utils.localize.TapLocalizeUtil;
import com.taptap.sdk.openlog.TapTapOpenlogSdk;
import com.taptap.sdk.openlog.model.AppDurationParams;
import com.taptap.sdk.openlog.model.DynamicDeviceInfo;
import com.taptap.sdk.openlog.model.OpenLogConfig;
import com.taptap.sdk.openlog.model.StaticDeviceInfo;
import com.taptap.sdk.servicemanager.ServiceManager;
import com.umeng.analytics.pro.d;
import java.io.File;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OpenlogExtrasUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u0014\u001a\u00020\u000eH\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\nR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/taptap/sdk/openlog/utils/OpenlogExtrasUtils;", "", "()V", "dbService", "Lcom/taptap/sdk/core/DBService;", "gidService", "Lcom/taptap/sdk/common/services/GidService;", "createConfig", "Lcom/taptap/sdk/openlog/model/OpenLogConfig;", d.R, "Landroid/content/Context;", "enableLog", "", "getDataDir", "", "filesDir", "Ljava/io/File;", "path", "getDynamicDeviceInfo", "Lcom/taptap/sdk/openlog/model/DynamicDeviceInfo;", "getEnvironment", "getStaticDeviceInfo", "Lcom/taptap/sdk/openlog/model/StaticDeviceInfo;", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class OpenlogExtrasUtils {
    public static final OpenlogExtrasUtils INSTANCE = new OpenlogExtrasUtils();
    private static final DBService dbService = (DBService) ServiceManager.INSTANCE.getService(DBService.class);
    private static final GidService gidService = (GidService) ServiceManager.INSTANCE.getService(GidService.class);

    /* JADX INFO: compiled from: OpenlogExtrasUtils.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RegionType.values().length];
            try {
                iArr[RegionType.CN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[RegionType.GLOBAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private OpenlogExtrasUtils() {
    }

    public final OpenLogConfig createConfig(Context context, boolean enableLog) {
        int code;
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        if (TapTapKit.INSTANCE.isRND()) {
            code = 2;
        } else {
            code = TapTapOpenlogSdk.INSTANCE.getRegion$tap_core_release().getCode();
        }
        if (enableLog) {
            i = 1;
        } else {
            i = 0;
        }
        File filesDir = context.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "context.filesDir");
        return new OpenLogConfig(code, 1, i, 0, getDataDir(filesDir, "tapsdk"), getEnvironment(), "Android", PlatformXUA.getTrackUA(), TapTapOpenlogSdk.INSTANCE.getClientId$tap_core_release(), TapTapOpenlogSdk.INSTANCE.getClientToken$tap_core_release(), getStaticDeviceInfo(context), new AppDurationParams("4.10.9"));
    }

    public final StaticDeviceInfo getStaticDeviceInfo(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        String packageVersion = DeviceUtils.getPackageVersion(context);
        Intrinsics.checkNotNullExpressionValue(packageVersion, "getPackageVersion(context)");
        String strValueOf = String.valueOf(DeviceUtils.getPackageVersionCode(context));
        String deviceId = TapIdentifierUtil.INSTANCE.getDeviceId(context);
        String installUUID = TapIdentifierUtil.INSTANCE.getInstallUUID();
        String androidID = TapIdentifierUtil.getAndroidID(context);
        String manufacturer = DeviceUtils.getManufacturer();
        Intrinsics.checkNotNullExpressionValue(manufacturer, "getManufacturer()");
        String model = DeviceUtils.getModel();
        Intrinsics.checkNotNullExpressionValue(model, "getModel()");
        String cpuInfo = DeviceUtils.getCpuInfo();
        String cpuABIS = DeviceUtils.getCpuABIS();
        String os = DeviceUtils.getOS();
        Intrinsics.checkNotNullExpressionValue(os, "getOS()");
        return new StaticDeviceInfo(packageName, packageVersion, strValueOf, (String) null, (String) null, deviceId, installUUID, androidID, manufacturer, model, cpuInfo, cpuABIS, (String) null, os, String.valueOf(DeviceUtils.getDeviceSize(context)[0]), String.valueOf(DeviceUtils.getDeviceSize(context)[1]), String.valueOf(DeviceUtils.getDeviceTotalRom(context)), String.valueOf(DeviceUtils.getDeviceTotalRam(context)), DeviceUtils.getCPUHardware(), TapLocalizeUtil.getPreferredLanguage().getLanguage(), TapIdentifierUtil.INSTANCE.getOpenId(), 4120, (DefaultConstructorMarker) null);
    }

    public final DynamicDeviceInfo getDynamicDeviceInfo(Context context) {
        String currentTdid;
        DBService dBService;
        Intrinsics.checkNotNullParameter(context, "context");
        String id = TimeZone.getDefault().getID();
        Intrinsics.checkNotNullExpressionValue(id, "getDefault().id");
        String trackSDKArtifact = PlatformXUA.getTrackSDKArtifact();
        String gameUserId = TapIdentifierUtil.INSTANCE.getGameUserId();
        String openId = TapIdentifierUtil.INSTANCE.getOpenId();
        GidService gidService2 = gidService;
        String currentGid = gidService2 != null ? gidService2.getCurrentGid() : null;
        String strValueOf = String.valueOf(DeviceUtils.getRemainingRomSize());
        String strValueOf2 = String.valueOf(DeviceUtils.getRemainingRamSize(context));
        String connectedType = NetworkUtil.getConnectedType(context);
        String networkType = NetworkUtil.getNetworkType(context);
        String language = TapLocalizeUtil.getPreferredLanguage().getLanguage();
        switch (WhenMappings.$EnumSwitchMapping$0[TapTapOpenlogSdk.INSTANCE.getRegion$tap_core_release().ordinal()]) {
            case 1:
            case 2:
                currentTdid = gidService2 == null ? null : gidService2.getCurrentTdid();
                break;
            default:
                currentTdid = null;
                break;
        }
        String currentGAID = (WhenMappings.$EnumSwitchMapping$0[TapTapOpenlogSdk.INSTANCE.getRegion$tap_core_release().ordinal()] != 2 || (dBService = dbService) == null) ? null : dBService.getCurrentGAID();
        return new DynamicDeviceInfo(id, trackSDKArtifact, gameUserId, openId, currentGid, strValueOf, strValueOf2, connectedType, networkType, language, currentTdid, currentGAID);
    }

    private final String getDataDir(File filesDir, String path) {
        File dir = new File(filesDir, path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String absolutePath = dir.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "dir.absolutePath");
        return absolutePath;
    }

    private final String getEnvironment() {
        if (DeviceUtils.isRunInSandbox()) {
            return "sandbox";
        }
        if (DeviceUtils.isRunInCloud()) {
            return "cloud";
        }
        return TapComplianceSettings.STRATEGY_LOCAL;
    }
}
