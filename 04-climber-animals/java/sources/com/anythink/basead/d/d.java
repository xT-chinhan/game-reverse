package com.anythink.basead.d;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* JADX INFO: loaded from: classes.dex */
public abstract class d implements SensorEventListener {
    public long a = 0;
    private long b = com.anythink.basead.exoplayer.i.a.f;

    public abstract boolean a(SensorEvent sensorEvent);

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.a <= this.b || !a(sensorEvent)) {
            return;
        }
        this.a = jCurrentTimeMillis;
    }
}
