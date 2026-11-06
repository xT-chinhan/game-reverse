package com.tapsdk.tapad.internal.animation;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.renderscript.Matrix3f;

/* JADX INFO: loaded from: classes3.dex */
public class i implements SensorEventListener, a {
    private g a;
    private double b = 120.0d;
    final float[] c = new float[9];
    final float[] d = new float[3];
    final float[] e = new float[3];
    final float[] f = new float[3];
    private double g = Double.MIN_VALUE;
    private double h = 0.0d;
    private double i = 0.0d;

    private void a(float f) {
        double dMax;
        if (this.g == Double.MIN_VALUE) {
            dMax = f;
            this.g = dMax;
            this.h = dMax;
        } else {
            double d = f;
            double d2 = this.h;
            double d3 = d - d2;
            double d4 = this.b;
            if (d3 >= d4 || this.i - d >= d4) {
                g gVar = this.a;
                if (gVar != null) {
                    gVar.a(2);
                    return;
                }
                return;
            }
            this.h = Math.min(d2, d);
            dMax = Math.max(this.i, d);
        }
        this.i = dMax;
    }

    private static double[] a(Matrix3f matrix3f) {
        double dSqrt = Math.sqrt(((((double) matrix3f.get(0, 0)) + 1.0d) + ((double) matrix3f.get(1, 1))) + ((double) matrix3f.get(2, 2))) / 2.0d;
        double d = 4.0d * dSqrt;
        return new double[]{dSqrt, ((double) (matrix3f.get(2, 1) - matrix3f.get(1, 2))) / d, ((double) (matrix3f.get(0, 2) - matrix3f.get(2, 0))) / d, ((double) (matrix3f.get(1, 0) - matrix3f.get(0, 1))) / d};
    }

    public void a(double d) {
        this.b = d;
    }

    @Override // com.tapsdk.tapad.internal.animation.a
    public void a(g gVar) {
        this.a = gVar;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            System.arraycopy(sensorEvent.values, 0, this.e, 0, 3);
        } else if (sensorEvent.sensor.getType() == 4) {
            System.arraycopy(sensorEvent.values, 0, this.f, 0, 3);
        }
        if (SensorManager.getRotationMatrix(this.c, null, this.e, this.f)) {
            SensorManager.getOrientation(this.c, this.d);
            a((float) Math.toDegrees(this.d[2]));
        }
    }

    @Override // com.tapsdk.tapad.internal.animation.a
    public void reset() {
        this.h = 0.0d;
        this.i = 0.0d;
        this.g = Double.MIN_VALUE;
    }
}
