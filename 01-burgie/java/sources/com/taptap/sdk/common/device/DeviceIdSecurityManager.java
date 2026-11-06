package com.taptap.sdk.common.device;

import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.utils.CryptoUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DeviceIdSecurityManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/taptap/sdk/common/device/DeviceIdSecurityManager;", "", "cryptoUtils", "Lcom/taptap/sdk/kit/internal/utils/CryptoUtils;", "deviceIdStorage", "Lcom/taptap/sdk/common/device/DeviceIdStorage;", "deviceIdValidator", "Lcom/taptap/sdk/common/device/DeviceIdValidator;", "(Lcom/taptap/sdk/kit/internal/utils/CryptoUtils;Lcom/taptap/sdk/common/device/DeviceIdStorage;Lcom/taptap/sdk/common/device/DeviceIdValidator;)V", "decryptAndValidate", "", "encryptedData", "encryptAndSave", "", "plainData", "Companion", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DeviceIdSecurityManager {
    private static final String ENCODE_PREFIX = "_encode_identify_prefix_";
    private static final String TAG = "DeviceIdSecurityWrapper";
    private final CryptoUtils cryptoUtils;
    private final DeviceIdStorage deviceIdStorage;
    private final DeviceIdValidator deviceIdValidator;

    public DeviceIdSecurityManager(CryptoUtils cryptoUtils, DeviceIdStorage deviceIdStorage, DeviceIdValidator deviceIdValidator) {
        Intrinsics.checkNotNullParameter(deviceIdStorage, "deviceIdStorage");
        Intrinsics.checkNotNullParameter(deviceIdValidator, "deviceIdValidator");
        this.cryptoUtils = cryptoUtils;
        this.deviceIdStorage = deviceIdStorage;
        this.deviceIdValidator = deviceIdValidator;
    }

    public final String decryptAndValidate(String encryptedData) {
        Intrinsics.checkNotNullParameter(encryptedData, "encryptedData");
        if (this.cryptoUtils == null) {
            TapLogger.loge$default(TAG, "CryptoUtils is null, cannot decrypt", null, 4, null);
            return null;
        }
        if (!StringsKt.startsWith$default(encryptedData, ENCODE_PREFIX, false, 2, (Object) null)) {
            TapLogger.loge$default(TAG, "Data does not have encryption prefix", null, 4, null);
            return null;
        }
        try {
            String encrypted = encryptedData.substring(24);
            Intrinsics.checkNotNullExpressionValue(encrypted, "this as java.lang.String).substring(startIndex)");
            String decrypted = this.cryptoUtils.aesDecrypt(encrypted);
            if (decrypted == null) {
                TapLogger.loge$default(TAG, "Decryption failed", null, 4, null);
                return null;
            }
            if (!this.deviceIdValidator.isValid(decrypted)) {
                TapLogger.loge$default(TAG, "Decrypted data is invalid: " + this.deviceIdValidator.toDebugString(decrypted), null, 4, null);
                return null;
            }
            TapLogger.logd(TAG, "Decryption and validation succeeded");
            return decrypted;
        } catch (Exception e) {
            TapLogger.loge(TAG, "Error during decryption", e);
            return null;
        }
    }

    public final void encryptAndSave(String plainData) {
        Intrinsics.checkNotNullParameter(plainData, "plainData");
        CryptoUtils cryptoUtils = this.cryptoUtils;
        if (cryptoUtils == null) {
            TapLogger.loge$default(TAG, "CryptoUtils is null, cannot encrypt", null, 4, null);
            return;
        }
        try {
            String encrypted = cryptoUtils.aesEncrypt(plainData);
            if (encrypted == null) {
                TapLogger.loge$default(TAG, "Data:" + plainData + " encryption failed, not saving", null, 4, null);
            } else {
                String dataToSave = ENCODE_PREFIX + encrypted;
                this.deviceIdStorage.saveDeviceId(dataToSave);
                TapLogger.logd(TAG, "Data:" + dataToSave + " saved successfully to private SP");
            }
        } catch (Exception e) {
            TapLogger.loge(TAG, "Error encrypting/saving data", e);
        }
    }
}
