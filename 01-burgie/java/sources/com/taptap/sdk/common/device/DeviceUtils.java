package com.taptap.sdk.common.device;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.taptap.sdk.common.device.generator.AndroidIdGenerator;
import com.taptap.sdk.common.device.generator.UUIDGenerator;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.utils.CryptoUtils;
import com.umeng.analytics.pro.d;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeviceUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/taptap/sdk/common/device/DeviceUtils;", "", "()V", "TAG", "", "TAP_SDK_SP_NAME", "generateAndroidId", d.R, "Landroid/content/Context;", "generateUUID", "getDeviceId", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DeviceUtils {
    public static final DeviceUtils INSTANCE = new DeviceUtils();
    private static final String TAG = "DeviceUtils";
    private static final String TAP_SDK_SP_NAME = "tapsdk_device_storage";

    private DeviceUtils() {
    }

    @JvmStatic
    public static final String getDeviceId(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        TapLogger.logd(TAG, "Starting device ID retrieval process");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences(TAP_SDK_SP_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        DeviceIdStorage deviceIdStorage = new DeviceIdStorage(defaultSharedPreferences, sharedPreferences);
        DeviceIdSecurityManager securityManager = new DeviceIdSecurityManager(CryptoUtils.getInstance(context), deviceIdStorage, DeviceIdValidator.INSTANCE);
        String storedData = deviceIdStorage.migrateDeviceId();
        if (storedData != null) {
            String deviceId = securityManager.decryptAndValidate(storedData);
            if (deviceId != null) {
                TapLogger.logd(TAG, "Device ID loaded from storage");
                return deviceId;
            }
            TapLogger.logw$default(TAG, "Stored device ID is invalid, clearing and regenerating", false, 4, null);
            deviceIdStorage.clearDeviceId();
        }
        TapLogger.logd(TAG, "Generating new device ID");
        DeviceUtils deviceUtils = INSTANCE;
        String androidId = deviceUtils.generateAndroidId(context);
        if (androidId == null) {
            TapLogger.logd(TAG, "Android ID not available, generating UUID");
            String uuid = deviceUtils.generateUUID();
            securityManager.encryptAndSave(uuid);
            return uuid;
        }
        securityManager.encryptAndSave(androidId);
        return androidId;
    }

    private final String generateAndroidId(Context context) {
        try {
            return new AndroidIdGenerator(context).generate();
        } catch (Exception e) {
            TapLogger.logw$default(TAG, "Failed to generate Android ID: " + e.getMessage(), false, 4, null);
            return null;
        }
    }

    private final String generateUUID() {
        return new UUIDGenerator().generate();
    }
}
