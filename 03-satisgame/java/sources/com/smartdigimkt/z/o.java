package com.smartdigimkt.z;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public final class o {
    public static volatile o d;
    public final SensorManager a;
    public final Sensor b;
    public float[] c;

    public o() {
        Context contextD = SDKContext.getInstance().d();
        if (contextD != null) {
            try {
                if (this.a == null) {
                    this.a = (SensorManager) contextD.getSystemService("sensor");
                }
                SensorManager sensorManager = this.a;
                if (sensorManager == null || this.b != null) {
                    return;
                }
                this.b = sensorManager.getDefaultSensor(1);
            } catch (Throwable unused) {
            }
        }
    }

    public static o a() {
        if (d == null) {
            synchronized (o.class) {
                if (d == null) {
                    d = new o();
                }
            }
        }
        return d;
    }

    public final void b(SensorEventListener sensorEventListener) {
        SensorManager sensorManager = this.a;
        if (sensorManager == null || sensorEventListener == null) {
            return;
        }
        try {
            sensorManager.unregisterListener(sensorEventListener);
            sensorEventListener.hashCode();
        } catch (Throwable unused) {
        }
    }

    public final void a(SensorEventListener sensorEventListener) {
        Sensor sensor;
        SensorManager sensorManager = this.a;
        if (sensorManager == null || (sensor = this.b) == null || sensorEventListener == null) {
            return;
        }
        try {
            sensorManager.registerListener(sensorEventListener, sensor, 2);
            sensorEventListener.hashCode();
        } catch (Throwable unused) {
        }
    }
}
