package com.byazt.eq;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import com.umeng.analytics.pro.an;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 661, 50})
public class vk {
    public static pr pr;
    public static SensorManager uc;
    public static final float[] hw = new float[3];
    public static final float[] hn = new float[3];
    public static final float[] x = new float[9];
    public static final float[] c = new float[3];

    public static void pr(pr prVar) {
        pr = prVar;
    }

    private static SensorManager pr(Context context) {
        if (uc == null) {
            synchronized (vk.class) {
                if (uc == null) {
                    uc = (SensorManager) context.getSystemService(an.ac);
                }
            }
        }
        return uc;
    }

    private static boolean pr() {
        pr prVar = pr;
        return prVar == null || !prVar.hw();
    }

    public static void pr(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            if (pr()) {
                return;
            }
            pr prVar = pr;
            if (prVar == null || !prVar.hn()) {
                SensorManager sensorManagerPr = pr(context);
                sensorManagerPr.registerListener(sensorEventListener, sensorManagerPr.getDefaultSensor(1), pr(i));
            }
        } catch (Throwable th) {
            fw.pr("SensorHub", "startListenAccelerometer error", th);
        }
    }

    public static void hw(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            if (pr()) {
                return;
            }
            pr prVar = pr;
            if (prVar == null || !prVar.hn()) {
                SensorManager sensorManagerPr = pr(context);
                sensorManagerPr.registerListener(sensorEventListener, sensorManagerPr.getDefaultSensor(4), pr(i));
            }
        } catch (Throwable th) {
            fw.pr("SensorHub", "startListenGyroscope error", th);
        }
    }

    public static void hn(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            if (pr()) {
                return;
            }
            pr prVar = pr;
            if (prVar == null || !prVar.hn()) {
                SensorManager sensorManagerPr = pr(context);
                sensorManagerPr.registerListener(sensorEventListener, sensorManagerPr.getDefaultSensor(10), pr(i));
            }
        } catch (Throwable th) {
            fw.pr("SensorHub", "startListenLinearAcceleration error", th);
        }
    }

    public static void x(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            if (pr()) {
                return;
            }
            pr prVar = pr;
            if (prVar == null || !prVar.hn()) {
                SensorManager sensorManagerPr = pr(context);
                sensorManagerPr.registerListener(sensorEventListener, sensorManagerPr.getDefaultSensor(1), pr(i));
                sensorManagerPr.registerListener(sensorEventListener, sensorManagerPr.getDefaultSensor(2), pr(i));
            }
        } catch (Throwable th) {
            fw.pr("SensorHub", "startListenRotationVector err", th);
        }
    }

    public static void pr(Context context, SensorEventListener sensorEventListener) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            pr(context).unregisterListener(sensorEventListener);
        } catch (Throwable th) {
            fw.pr("SensorHub", "stopListen error", th);
        }
    }

    public static void pr(Context context, long j) {
        Vibrator vibrator;
        if (context == null || (vibrator = (Vibrator) context.getSystemService("vibrator")) == null) {
            return;
        }
        vibrator.vibrate(j);
    }

    private static int pr(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
                return i;
            default:
                return 2;
        }
    }
}
