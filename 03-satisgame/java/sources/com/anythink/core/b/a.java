package com.anythink.core.b;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.anythink.core.common.d.s;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static volatile a d;
    Sensor a;
    private final String b = "a";
    private SensorManager c;
    private float[] e;

    private a() {
        Context contextG = s.b().g();
        if (contextG != null) {
            try {
                if (this.c == null) {
                    this.c = (SensorManager) contextG.getSystemService("sensor");
                }
                if (this.a == null) {
                    this.a = this.c.getDefaultSensor(1);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static a a() {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a();
                }
            }
        }
        return d;
    }

    private boolean b() {
        return this.a != null;
    }

    public final void a(SensorEventListener sensorEventListener) {
        try {
            this.c.registerListener(sensorEventListener, this.a, 2);
        } catch (Throwable unused) {
        }
    }

    public final void b(SensorEventListener sensorEventListener) {
        SensorManager sensorManager = this.c;
        if (sensorManager != null) {
            try {
                sensorManager.unregisterListener(sensorEventListener);
            } catch (Throwable unused) {
            }
        }
    }

    private synchronized float[] c() {
        return this.e;
    }

    public final synchronized void a(float[] fArr) {
        this.e = fArr;
    }
}
