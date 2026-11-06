package com.mcto.sspsdk.component.interaction;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Vibrator;
import com.mcto.sspsdk.internal.jd;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements SensorEventListener {
    public float a = 0.0f;
    public float b = 0.0f;
    public float c = -1.0f;
    public final /* synthetic */ QyTwistView d;

    public d(QyTwistView qyTwistView) {
        this.d = qyTwistView;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 4) {
            float f = this.c;
            if (f < 0.0f) {
                this.c = sensorEvent.timestamp;
                return;
            }
            float f2 = sensorEvent.timestamp;
            float f3 = (f2 - f) / 1.0E9f;
            this.c = f2;
            float degrees = this.a + ((float) Math.toDegrees((-sensorEvent.values[2]) * f3));
            this.a = degrees;
            float fMax = degrees / this.d.l;
            if (this.d.k != 1) {
                float degrees2 = this.b + ((float) Math.toDegrees((-sensorEvent.values[1]) * f3));
                this.b = degrees2;
                fMax = Math.max(Math.abs(degrees2 / this.d.l), Math.abs(fMax));
            }
            this.d.b.a(fMax);
            if (Math.abs(fMax) < 1.0f || this.d.m == null) {
                return;
            }
            this.d.b();
            try {
                Vibrator vibrator = (Vibrator) jd.a.getSystemService("vibrator");
                if (vibrator != null) {
                    vibrator.vibrate(100L);
                }
            } catch (Exception e) {
            }
            this.d.m.a();
        }
    }
}
