package com.taptap.sdk.db.event.utils;

import android.content.Context;
import android.os.Build;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.kit.internal.identifier.TapIdentifierUtil;
import com.taptap.sdk.kit.internal.utils.DeviceUtils;
import com.taptap.sdk.kit.internal.utils.NetworkUtil;
import com.taptap.sdk.kit.internal.utils.OSUtil;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: TapEventParameterKit.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/taptap/sdk/db/event/utils/TapEventParameterKit;", "", "()V", "fillingGeneralParameter", "", "context", "Landroid/content/Context;", "parameter", "Lorg/json/JSONObject;", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapEventParameterKit {
    public static final TapEventParameterKit INSTANCE = new TapEventParameterKit();

    private TapEventParameterKit() {
    }

    public final void fillingGeneralParameter(Context context, JSONObject parameter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parameter, "parameter");
        TapEventParameterKitKt.putProperty(parameter, TapEventParamConstants.PARAM_SUB_OS, "Android");
        TapEventParameterKitKt.putProperty(parameter, TapEventParamConstants.PARAM_SUB_DV, DeviceUtils.getDeviceBrand());
        TapEventParameterKitKt.putProperty(parameter, "md", DeviceUtils.getDeviceModel());
        TapEventParameterKitKt.putProperty(parameter, TapEventParamConstants.PARAM_SUB_INSTALL_UUID, TapIdentifierUtil.INSTANCE.getInstallUUID());
        int[] deviceSize = DeviceUtils.getDeviceSize(context);
        Intrinsics.checkNotNullExpressionValue(deviceSize, "getDeviceSize(context)");
        TapEventParameterKitKt.putProperty(parameter, "width", Integer.valueOf(deviceSize[0]));
        TapEventParameterKitKt.putProperty(parameter, "height", Integer.valueOf(deviceSize[1]));
        TapEventParameterKitKt.putProperty(parameter, TapEventParamConstants.PARAM_SUB_SV, DeviceUtils.getOS());
        TapEventParameterKitKt.putProperty(parameter, TapEventParamConstants.PARAM_SUB_PROVIDER, DeviceUtils.getCarrier(context));
        String gameVersion = TapEventLogger.INSTANCE.getSdkOptions().getGameVersion();
        String str = gameVersion;
        if (str == null || str.length() == 0) {
            TapEventParameterKitKt.putProperty(parameter, "app_version", DeviceUtils.getPackageVersion(context));
        } else {
            TapEventParameterKitKt.putProperty(parameter, "app_version", gameVersion);
        }
        TapEventParameterKitKt.putProperty(parameter, "sdk_version", "4.5.0");
        TapEventParameterKitKt.putProperty(parameter, "network_type", NetworkUtil.getConnectedType(context));
        TapEventParameterKitKt.putProperty(parameter, TapEventParamConstants.PARAM_SUB_MOBILE_TYPE, NetworkUtil.getNetworkType(context));
        TapEventParameterKitKt.putProperty(parameter, "cpu", DeviceUtils.getCPUAbi());
        TapEventParameterKitKt.putProperty(parameter, TapEventParamConstants.PARAM_SUB_ROM, Long.valueOf(DeviceUtils.getRemainingRomSize()));
        TapEventParameterKitKt.putProperty(parameter, TapEventParamConstants.PARAM_SUB_RAM, Long.valueOf(DeviceUtils.getRemainingRamSize(context)));
        TapEventParameterKitKt.putProperty(parameter, TapEventParamConstants.PARAM_SUB_TOTAL_ROM, Long.valueOf(DeviceUtils.getDeviceTotalRom(context)));
        TapEventParameterKitKt.putProperty(parameter, TapEventParamConstants.PARAM_SUB_TOTAL_RAM, Long.valueOf(DeviceUtils.getDeviceTotalRam(context)));
        TapEventParameterKitKt.putProperty(parameter, TapEventParamConstants.PARAM_SUB_HARDWARE, DeviceUtils.getCPUHardware());
        TapEventParameterKitKt.putProperty(parameter, TapEventParamConstants.PARAM_SUB_LANG_SYSTEM, Locale.getDefault().getLanguage());
        TapEventParameterKitKt.putProperty(parameter, TapEventParamConstants.PARAM_SUB_OS_TYPE, DeviceUtils.getOSType());
        TapEventParameterKitKt.putProperty(parameter, TapEventParamConstants.PARAM_SUB_MOS, OSUtil.getCustomOS(Build.BRAND));
        TapEventParameterKitKt.putProperty(parameter, TapEventParamConstants.PARAM_SUB_MOSV, OSUtil.getCustomOSVersion(Build.BRAND));
        TapEventParameterKitKt.putProperty(parameter, TapEventParamConstants.PARAM_SUB_DEVICE_ID5, TapIdentifierUtil.INSTANCE.getUniqueDeviceId(context));
        TapEventParameterKitKt.putProperty(parameter, "channel", TapEventLogger.INSTANCE.getSdkOptions().getChannel());
        TapEventParameterKitKt.putProperty(parameter, TapEventParamConstants.PARAM_SUB_DEVICE_ID1, DeviceUtils.getIMEI(context));
        TapEventParameterKitKt.putProperty(parameter, "android_id", TapIdentifierUtil.getAndroidID(context));
    }
}
