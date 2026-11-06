package com.bykv.vk.component.ttvideo.player;

import android.media.audiofx.AudioEffect;
import com.anythink.basead.exoplayer.d;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.uc.crashsdk.export.LogType;

/* JADX INFO: loaded from: classes.dex */
public class AudioFormats {
    private static final int[] validSampleRates = {TTAdConstant.INIT_LOCAL_FAIL_CODE, 8000, 11025, 16000, 22050, LogType.UNEXP_KNOWN_REASON, 37800, 44056, 44100, 47250, 48000, d.b, 50400, 88200, 96000, 176400, 192000, 352800, 2822400, 5644800};
    private static boolean sDetectDlbDevices = false;
    private static boolean sDlbDevice = false;

    public static int getDefaultSampleRatesNB() {
        return validSampleRates.length;
    }

    public static int getMaxSupportedSampleRates(int[] iArr) {
        int length = validSampleRates.length - 3;
        for (int i = 0; i < length; i++) {
            iArr[i] = validSampleRates[i];
        }
        return length;
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
