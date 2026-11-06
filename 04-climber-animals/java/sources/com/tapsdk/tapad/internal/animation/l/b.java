package com.tapsdk.tapad.internal.animation.l;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tapsdk.tapad.internal.animation.g;

/* JADX INFO: loaded from: classes3.dex */
public class b implements SensorEventListener, com.tapsdk.tapad.internal.animation.a {
    private boolean a = true;
    private g b = null;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;

    @Override // com.tapsdk.tapad.internal.animation.a
    public void a(g gVar) {
        this.b = gVar;
    }

    public void a(boolean z, boolean z2, boolean z3, int i, int i2, int i3) {
        this.c = z;
        this.d = z2;
        this.e = z3;
        this.l = i;
        this.m = i2;
        this.n = i3;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        g gVar;
        int i;
        if (this.b != null && sensorEvent.sensor.getType() == 11) {
            float[] fArr = new float[16];
            SensorManager.getRotationMatrixFromVector(fArr, sensorEvent.values);
            float[] fArr2 = new float[3];
            SensorManager.getOrientation(fArr, fArr2);
            if (this.a) {
                int degrees = (int) Math.toDegrees(fArr2[0]);
                this.h = degrees;
                this.k = degrees;
                int degrees2 = (int) Math.toDegrees(fArr2[1]);
                this.f = degrees2;
                this.i = degrees2;
                int degrees3 = (int) Math.toDegrees(fArr2[2]);
                this.g = degrees3;
                this.j = degrees3;
                this.a = false;
                return;
            }
            this.k = Math.max(this.k, (int) Math.toDegrees(fArr2[0]));
            this.i = Math.max(this.i, (int) Math.toDegrees(fArr2[1]));
            this.j = Math.max(this.j, (int) Math.toDegrees(fArr2[2]));
            this.h = Math.min(this.h, (int) Math.toDegrees(fArr2[0]));
            this.f = Math.min(this.f, (int) Math.toDegrees(fArr2[1]));
            int iMin = Math.min(this.g, (int) Math.toDegrees(fArr2[2]));
            this.g = iMin;
            if (this.e && this.k - this.h > this.n) {
                gVar = this.b;
                i = 6;
            } else {
                if (!this.d || this.j - iMin <= this.m) {
                    if (!this.c || this.i - this.f <= this.l) {
                        return;
                    }
                    this.b.a(4);
                    return;
                }
                gVar = this.b;
                i = 5;
            }
            gVar.a(i);
        }
    }

    @Override // com.tapsdk.tapad.internal.animation.a
    public void reset() {
        this.a = true;
    }
}
