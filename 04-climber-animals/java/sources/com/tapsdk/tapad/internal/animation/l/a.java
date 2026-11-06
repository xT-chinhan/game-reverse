package com.tapsdk.tapad.internal.animation.l;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tapsdk.tapad.internal.animation.g;

/* JADX INFO: loaded from: classes3.dex */
public class a implements SensorEventListener, com.tapsdk.tapad.internal.animation.a {
    private static final int n = 70;
    private float a;
    private float b;
    private float c;
    private boolean d = true;
    private float e = 30.0f;
    private float f = 30.0f;
    private float g = 30.0f;
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private g l;
    private long m;

    @Override // com.tapsdk.tapad.internal.animation.a
    public void a(g gVar) {
        this.l = gVar;
    }

    public void a(boolean z, boolean z2, boolean z3, float f, float f2, float f3) {
        this.h = z;
        this.i = z2;
        this.j = z3;
        this.e = f;
        this.f = f2;
        this.g = f3;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.l != null && sensorEvent.sensor.getType() == 1) {
            if (this.d) {
                float[] fArr = sensorEvent.values;
                this.a = fArr[0];
                this.b = fArr[1];
                this.c = fArr[2];
                this.m = System.currentTimeMillis();
                this.d = false;
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.m < 70) {
                return;
            }
            this.m = jCurrentTimeMillis;
            float fAbs = Math.abs(sensorEvent.values[0] - this.a) * 100.0f;
            float fAbs2 = Math.abs(sensorEvent.values[1] - this.b) * 100.0f;
            float fAbs3 = Math.abs(sensorEvent.values[2] - this.c) * 100.0f;
            float[] fArr2 = sensorEvent.values;
            this.a = fArr2[0];
            this.b = fArr2[1];
            this.c = fArr2[2];
            if (this.j && fAbs3 > this.g) {
                this.l.a(9);
                return;
            }
            if (this.i && fAbs2 > this.f) {
                this.l.a(8);
            } else {
                if (!this.h || fAbs <= this.e) {
                    return;
                }
                this.l.a(7);
            }
        }
    }

    @Override // com.tapsdk.tapad.internal.animation.a
    public void reset() {
        this.d = true;
    }
}
