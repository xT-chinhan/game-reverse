package com.anythink.core.express.c;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements SensorEventListener {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public float d = 0.0f;
    public float e = 0.0f;
    public float f = 0.0f;
    public long g = 0;
    private int h;
    private int i;

    public abstract void a();

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public b(int i, int i2) {
        this.h = i;
        this.i = i2;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0065  */
    /* JADX WARN: Code duplicated, block: B:16:0x0074  */
    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        long jCurrentTimeMillis;
        float[] fArr = sensorEvent.values;
        float f = -fArr[0];
        float f2 = -fArr[1];
        float f3 = -fArr[2];
        String.format("mtg handleSensorData lastx:%d,lasty:%d,lastz:%d", Integer.valueOf((int) f), Integer.valueOf((int) f2), Integer.valueOf((int) f3));
        float f4 = this.d;
        if (f4 == 0.0f || Math.abs(f - f4) <= this.h) {
            float f5 = this.e;
            if (f5 == 0.0f || Math.abs(f2 - f5) <= this.h) {
                float f6 = this.f;
                if (f6 != 0.0f && Math.abs(f3 - f6) > this.h) {
                    jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - this.g > this.i) {
                        this.g = jCurrentTimeMillis;
                        a();
                    }
                }
            } else {
                jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.g > this.i) {
                    this.g = jCurrentTimeMillis;
                    a();
                }
            }
        } else {
            jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.g > this.i) {
                this.g = jCurrentTimeMillis;
                a();
            }
        }
        this.d = f;
        this.e = f2;
        this.f = f3;
    }
}
