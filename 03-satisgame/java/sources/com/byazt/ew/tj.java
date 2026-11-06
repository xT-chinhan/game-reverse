package com.byazt.ew;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj {
    public static n n;
    public static SensorManager w;
    public static final float[] qg = new float[3];
    public static final float[] s = new float[3];
    public static final float[] q = new float[9];
    public static final float[] l = new float[3];

    private static int n(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 3) {
            return i;
        }
        return 2;
    }

    public static void n(n nVar) {
        n = nVar;
    }

    private static SensorManager n(Context context) {
        if (w == null) {
            synchronized (tj.class) {
                if (w == null) {
                    w = (SensorManager) context.getSystemService("sensor");
                }
            }
        }
        return w;
    }

    private static boolean n() {
        n nVar = n;
        return nVar == null || !nVar.qg();
    }

    public static void n(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            if (n()) {
                return;
            }
            n nVar = n;
            if (nVar == null || !nVar.s()) {
                SensorManager sensorManagerN = n(context);
                sensorManagerN.registerListener(sensorEventListener, sensorManagerN.getDefaultSensor(1), n(i));
            }
        } catch (Throwable th) {
            x.n("SensorHub", "startListenAccelerometer error", th);
        }
    }

    public static void qg(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            if (n()) {
                return;
            }
            n nVar = n;
            if (nVar == null || !nVar.s()) {
                SensorManager sensorManagerN = n(context);
                sensorManagerN.registerListener(sensorEventListener, sensorManagerN.getDefaultSensor(4), n(i));
            }
        } catch (Throwable th) {
            x.n("SensorHub", "startListenGyroscope error", th);
        }
    }

    public static void s(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            if (n()) {
                return;
            }
            n nVar = n;
            if (nVar == null || !nVar.s()) {
                SensorManager sensorManagerN = n(context);
                sensorManagerN.registerListener(sensorEventListener, sensorManagerN.getDefaultSensor(10), n(i));
            }
        } catch (Throwable th) {
            x.n("SensorHub", "startListenLinearAcceleration error", th);
        }
    }

    public static void q(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            if (n()) {
                return;
            }
            n nVar = n;
            if (nVar == null || !nVar.s()) {
                SensorManager sensorManagerN = n(context);
                sensorManagerN.registerListener(sensorEventListener, sensorManagerN.getDefaultSensor(1), n(i));
                sensorManagerN.registerListener(sensorEventListener, sensorManagerN.getDefaultSensor(2), n(i));
            }
        } catch (Throwable th) {
            x.n("SensorHub", "startListenRotationVector err", th);
        }
    }

    public static void n(Context context, SensorEventListener sensorEventListener) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            n(context).unregisterListener(sensorEventListener);
        } catch (Throwable th) {
            x.n("SensorHub", "stopListen error", th);
        }
    }

    public static void n(Context context, long j) {
        Vibrator vibrator;
        if (context == null || (vibrator = (Vibrator) context.getSystemService("vibrator")) == null) {
            return;
        }
        vibrator.vibrate(j);
    }
}
