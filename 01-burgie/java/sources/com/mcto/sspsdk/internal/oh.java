package com.mcto.sspsdk.internal;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* JADX INFO: loaded from: classes2.dex */
public final class oh implements SensorEventListener {
    public final float[] a = new float[3];
    public final float[] b = new float[3];
    public final float[] c = new float[9];
    public final float[] d = new float[3];
    public float e = Float.MAX_VALUE;
    public float f = Float.MIN_VALUE;
    public float g = Float.MAX_VALUE;
    public float h = Float.MIN_VALUE;
    public float i = Float.MAX_VALUE;
    public float j = Float.MIN_VALUE;

    public final void a() {
        this.e = Float.MAX_VALUE;
        this.f = Float.MIN_VALUE;
        this.g = Float.MAX_VALUE;
        this.h = Float.MIN_VALUE;
        this.i = Float.MAX_VALUE;
        this.j = Float.MIN_VALUE;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (type == 1) {
            float[] fArr = sensorEvent.values;
            float[] fArr2 = this.a;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        } else if (type == 2) {
            float[] fArr3 = sensorEvent.values;
            float[] fArr4 = this.b;
            System.arraycopy(fArr3, 0, fArr4, 0, fArr4.length);
        }
        SensorManager.getRotationMatrix(this.c, null, this.a, this.b);
        SensorManager.getOrientation(this.c, this.d);
        this.e = Math.min(this.d[0], this.e);
        this.f = Math.max(this.d[0], this.f);
        this.g = Math.min(this.d[1], this.g);
        this.h = Math.max(this.d[1], this.h);
        this.i = Math.min(this.d[2], this.i);
        this.j = Math.max(this.d[2], this.j);
    }
}
