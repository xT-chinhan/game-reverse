package com.bytedance.sdk.component.panglearmor;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.core.view.PointerIconCompat;

/* JADX INFO: loaded from: classes2.dex */
public class ka {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile boolean f1309ms = false;

    public static void ms(Context context) {
        if (f1309ms || context == null) {
            return;
        }
        xr(context);
        ah(context);
        d(context);
        ka(context);
        f1309ms = true;
    }

    private static void xr(Context context) {
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
        c.ms(1006, new Object[]{Boolean.valueOf(booleanExtra), Double.valueOf(intExtra)});
    }

    private static void ah(Context context) {
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
            c.ms(1007, new Object[]{Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(i), Integer.valueOf(i2)});
        }
        i = -2;
        i2 = i;
        c.ms(1007, new Object[]{Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(i), Integer.valueOf(i2)});
    }

    private static void d(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        c.ms(PointerIconCompat.TYPE_TEXT, new Object[]{Boolean.valueOf(configuration == null || !(configuration.touchscreen == 1 || configuration.touchscreen == 0))});
    }

    private static void ka(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        c.ms(PointerIconCompat.TYPE_VERTICAL_TEXT, new Object[]{Integer.valueOf(telephonyManager != null ? telephonyManager.getSimState() : -1)});
    }
}
