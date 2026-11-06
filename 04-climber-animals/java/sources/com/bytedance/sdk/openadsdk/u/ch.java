package com.bytedance.sdk.openadsdk.u;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;

/* JADX INFO: loaded from: classes2.dex */
public class ch {
    private static SensorManager c;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static ms f4198ms;
    protected static final float[] xr = new float[3];
    protected static final float[] ah = new float[3];
    protected static final float[] d = new float[9];
    protected static final float[] ka = new float[3];

    private static int ms(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 3) {
            return i;
        }
        return 2;
    }

    public static void ms(ms msVar) {
        f4198ms = msVar;
    }

    private static SensorManager ms(Context context) {
        if (c == null) {
            synchronized (ch.class) {
                if (c == null) {
                    c = (SensorManager) context.getSystemService("sensor");
                }
            }
        }
        return c;
    }

    private static boolean ms() {
        ms msVar = f4198ms;
        return msVar == null || !msVar.xr();
    }

    public static void ms(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            if (ms()) {
                return;
            }
            ms msVar = f4198ms;
            if (msVar == null || !msVar.ah()) {
                SensorManager sensorManagerMs = ms(context);
                sensorManagerMs.registerListener(sensorEventListener, sensorManagerMs.getDefaultSensor(1), ms(i));
            }
        } catch (Throwable th) {
            ab.ms("SensorHub", "startListenAccelerometer error", th);
        }
    }

    public static void xr(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            if (ms()) {
                return;
            }
            ms msVar = f4198ms;
            if (msVar == null || !msVar.ah()) {
                SensorManager sensorManagerMs = ms(context);
                sensorManagerMs.registerListener(sensorEventListener, sensorManagerMs.getDefaultSensor(4), ms(i));
            }
        } catch (Throwable th) {
            ab.ms("SensorHub", "startListenGyroscope error", th);
        }
    }

    public static void ah(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            if (ms()) {
                return;
            }
            ms msVar = f4198ms;
            if (msVar == null || !msVar.ah()) {
                SensorManager sensorManagerMs = ms(context);
                sensorManagerMs.registerListener(sensorEventListener, sensorManagerMs.getDefaultSensor(10), ms(i));
            }
        } catch (Throwable th) {
            ab.ms("SensorHub", "startListenLinearAcceleration error", th);
        }
    }

    public static void d(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            if (ms()) {
                return;
            }
            ms msVar = f4198ms;
            if (msVar == null || !msVar.ah()) {
                SensorManager sensorManagerMs = ms(context);
                sensorManagerMs.registerListener(sensorEventListener, sensorManagerMs.getDefaultSensor(1), ms(i));
                sensorManagerMs.registerListener(sensorEventListener, sensorManagerMs.getDefaultSensor(2), ms(i));
            }
        } catch (Throwable th) {
            ab.ms("SensorHub", "startListenRotationVector err", th);
        }
    }

    public static void ms(Context context, SensorEventListener sensorEventListener) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            ms(context).unregisterListener(sensorEventListener);
        } catch (Throwable th) {
            ab.ms("SensorHub", "stopListen error", th);
        }
    }

    public static void ms(Context context, long j) {
        if (context == null) {
            return;
        }
        ((Vibrator) context.getSystemService("vibrator")).vibrate(j);
    }
}
