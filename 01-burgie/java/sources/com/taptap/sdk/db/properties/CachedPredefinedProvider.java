package com.taptap.sdk.db.properties;

import android.os.Build;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.initializer.api.option.TapTapSdkOptions;
import com.taptap.sdk.kit.internal.identifier.TapIdentifierUtil;
import com.taptap.sdk.kit.internal.utils.DeviceUtils;
import com.taptap.sdk.kit.internal.utils.OSUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CachedPredefinedProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/taptap/sdk/db/properties/CachedPredefinedProvider;", "", "options", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "(Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;)V", "provide", "", "", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CachedPredefinedProvider {
    private final TapTapSdkOptions options;

    public CachedPredefinedProvider(TapTapSdkOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.options = options;
    }

    public final Map<String, Object> provide() {
        String gameVersion;
        HashMap properties = new HashMap();
        Pair pair = TuplesKt.to("os", "Android");
        properties.put(pair.getFirst(), pair.getSecond());
        Pair pair2 = TuplesKt.to(Common.Predefined.SUB_DV, DeviceUtils.getDeviceBrand());
        properties.put(pair2.getFirst(), pair2.getSecond());
        Pair pair3 = TuplesKt.to("md", DeviceUtils.getDeviceModel());
        properties.put(pair3.getFirst(), pair3.getSecond());
        Pair pair4 = TuplesKt.to("provider", DeviceUtils.getCarrier(this.options.getContext()));
        properties.put(pair4.getFirst(), pair4.getSecond());
        Pair pair5 = TuplesKt.to("cpu", DeviceUtils.getCPUAbi());
        properties.put(pair5.getFirst(), pair5.getSecond());
        Pair pair6 = TuplesKt.to(Common.Predefined.SUB_TOTAL_ROM, Long.valueOf(DeviceUtils.getDeviceTotalRom(this.options.getContext())));
        properties.put(pair6.getFirst(), pair6.getSecond());
        Pair pair7 = TuplesKt.to(Common.Predefined.SUB_TOTAL_RAM, Long.valueOf(DeviceUtils.getDeviceTotalRam(this.options.getContext())));
        properties.put(pair7.getFirst(), pair7.getSecond());
        Pair pair8 = TuplesKt.to(Common.Predefined.SUB_HARDWARE, DeviceUtils.getCPUHardware());
        properties.put(pair8.getFirst(), pair8.getSecond());
        Pair pair9 = TuplesKt.to(Common.Predefined.SUB_OS_TYPE, DeviceUtils.getOSType());
        properties.put(pair9.getFirst(), pair9.getSecond());
        Pair pair10 = TuplesKt.to(Common.Predefined.SUB_MOS, OSUtil.getCustomOS(Build.BRAND));
        properties.put(pair10.getFirst(), pair10.getSecond());
        Pair pair11 = TuplesKt.to(Common.Predefined.SUB_MOSV, OSUtil.getCustomOSVersion(Build.BRAND));
        properties.put(pair11.getFirst(), pair11.getSecond());
        Pair pair12 = TuplesKt.to(Common.Predefined.SUB_SV, DeviceUtils.getOS());
        properties.put(pair12.getFirst(), pair12.getSecond());
        Pair pair13 = TuplesKt.to(Common.Predefined.SUB_INSTALL_UUID, TapIdentifierUtil.INSTANCE.getInstallUUID());
        properties.put(pair13.getFirst(), pair13.getSecond());
        Pair pair14 = TuplesKt.to(Common.Predefined.SUB_ANDROID_ID, TapIdentifierUtil.getAndroidID(this.options.getContext()));
        properties.put(pair14.getFirst(), pair14.getSecond());
        Pair pair15 = TuplesKt.to(Common.Predefined.SUB_DEVICE_ID5, TapIdentifierUtil.INSTANCE.getUniqueDeviceId(this.options.getContext()));
        properties.put(pair15.getFirst(), pair15.getSecond());
        HashMap map = properties;
        String gameVersion2 = this.options.getGameVersion();
        if (gameVersion2 == null || gameVersion2.length() == 0) {
            gameVersion = DeviceUtils.getPackageVersion(this.options.getContext());
        } else {
            gameVersion = this.options.getGameVersion();
        }
        Pair pair16 = TuplesKt.to("app_version", gameVersion);
        map.put(pair16.getFirst(), pair16.getSecond());
        Pair pair17 = TuplesKt.to("sdk_version", "4.10.9");
        properties.put(pair17.getFirst(), pair17.getSecond());
        Pair pair18 = TuplesKt.to("package_name", this.options.getContext().getPackageName());
        properties.put(pair18.getFirst(), pair18.getSecond());
        return properties;
    }
}
