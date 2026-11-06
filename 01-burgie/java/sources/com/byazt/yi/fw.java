package com.byazt.yi;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 586, 62})
public class fw {
    public static volatile boolean pr = false;

    public static void pr(Context context) {
        if (pr || context == null) {
            return;
        }
        hw(context);
        hn(context);
        x(context);
        c(context);
        pr = true;
    }

    private static void hw(Context context) {
        boolean booleanExtra;
        double intExtra = -0.1d;
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver == null) {
                booleanExtra = true;
            } else {
                booleanExtra = intentRegisterReceiver.getBooleanExtra("present", false);
                try {
                    intExtra = ((double) intentRegisterReceiver.getIntExtra("temperature", -1)) / 10.0d;
                } catch (Throwable th) {
                }
            }
        } catch (Throwable th2) {
            booleanExtra = true;
        }
        zo.pr(1006, new Object[]{Boolean.valueOf(booleanExtra), Double.valueOf(intExtra)});
    }

    private static void hn(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
            int i = -1;
            int i2 = -2;
            if (cameraManager != null) {
                try {
                    int i3 = 0;
                    int i4 = 0;
                    for (String str : cameraManager.getCameraIdList()) {
                        int iIntValue = ((Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING)).intValue();
                        if (iIntValue == 0) {
                            i3++;
                        } else if (iIntValue == 1) {
                            i4++;
                        }
                    }
                    i = i3;
                    i2 = i4;
                } catch (Throwable th) {
                    i2 = -1;
                }
            } else {
                i = -2;
            }
            zo.pr(1007, new Object[]{Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        zo.pr(1007, new Object[]{Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(Camera.getNumberOfCameras())});
    }

    private static void x(Context context) {
        boolean z;
        Configuration configuration = context.getResources().getConfiguration();
        if (configuration == null) {
            z = true;
        } else {
            z = (configuration.touchscreen == 1 || configuration.touchscreen == 0) ? false : true;
        }
        zo.pr(1008, new Object[]{Boolean.valueOf(z)});
    }

    private static void c(Context context) {
        int simState;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            simState = -1;
        } else {
            simState = telephonyManager.getSimState();
        }
        zo.pr(1009, new Object[]{Integer.valueOf(simState)});
    }
}
