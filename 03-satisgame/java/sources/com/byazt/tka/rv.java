package com.byazt.tka;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.core.view.PointerIconCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 689, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv {
    public static volatile boolean n = false;

    public static void n(Context context) {
        if (n || context == null) {
            return;
        }
        qg(context);
        s(context);
        q(context);
        l(context);
        n = true;
    }

    private static void qg(Context context) {
        boolean booleanExtra;
        double intExtra = -0.1d;
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver != null) {
                booleanExtra = intentRegisterReceiver.getBooleanExtra("present", false);
                try {
                    intExtra = ((double) intentRegisterReceiver.getIntExtra("temperature", -1)) / 10.0d;
                } catch (Throwable unused) {
                }
            } else {
                booleanExtra = true;
            }
        } catch (Throwable unused2) {
        }
        tj.n(1006, new Object[]{Boolean.valueOf(booleanExtra), Double.valueOf(intExtra)});
    }

    private static void s(Context context) {
        int i;
        int i2;
        CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
        if (cameraManager != null) {
            try {
                i = 0;
                i2 = 0;
                for (String str : cameraManager.getCameraIdList()) {
                    int iIntValue = ((Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING)).intValue();
                    if (iIntValue == 0) {
                        i++;
                    } else if (iIntValue == 1) {
                        i2++;
                    }
                }
            } catch (Throwable unused) {
                i = -1;
                i2 = i;
            }
            tj.n(1007, new Object[]{Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(i), Integer.valueOf(i2)});
        }
        i = -2;
        i2 = i;
        tj.n(1007, new Object[]{Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(i), Integer.valueOf(i2)});
    }

    private static void q(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        tj.n(PointerIconCompat.TYPE_TEXT, new Object[]{Boolean.valueOf(configuration == null || !(configuration.touchscreen == 1 || configuration.touchscreen == 0))});
    }

    private static void l(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        tj.n(PointerIconCompat.TYPE_VERTICAL_TEXT, new Object[]{Integer.valueOf(telephonyManager != null ? telephonyManager.getSimState() : -1)});
    }
}
