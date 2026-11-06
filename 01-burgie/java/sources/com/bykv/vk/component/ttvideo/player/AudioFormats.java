package com.bykv.vk.component.ttvideo.player;

import android.media.audiofx.AudioEffect;
import android.os.Build;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.uc.crashsdk.export.LogType;

/* JADX INFO: loaded from: classes2.dex */
public class AudioFormats {
    private static final int[] validSampleRates = {TTAdConstant.INIT_LOCAL_FAIL_CODE, AVMDLDataLoader.KeyIsLiveSetLoaderType, 11025, 16000, 22050, LogType.UNEXP_KNOWN_REASON, 37800, 44056, 44100, 47250, 48000, 50000, 50400, 88200, 96000, 176400, 192000, 352800, 2822400, 5644800};
    private static boolean sDetectDlbDevices = false;
    private static boolean sDlbDevice = false;

    public static int getDefaultSampleRatesNB() {
        return validSampleRates.length;
    }

    public static int getMaxSupportedSampleRates(int[] iArr) {
        int i;
        int length = validSampleRates.length;
        if (Build.VERSION.SDK_INT >= 23) {
            i = length - 3;
        } else if (Build.VERSION.SDK_INT >= 21) {
            i = length - 5;
        } else {
            i = length - 9;
        }
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = validSampleRates[i2];
        }
        return i;
    }

    public static boolean isLicencedDolbyDevice() {
        if (sDetectDlbDevices) {
            return sDlbDevice;
        }
        for (AudioEffect.Descriptor descriptor : AudioEffect.queryEffects()) {
            if (descriptor.implementor.contains("Dolby Laboratories")) {
                sDlbDevice = true;
                break;
            }
        }
        sDetectDlbDevices = true;
        return sDlbDevice;
    }
}
