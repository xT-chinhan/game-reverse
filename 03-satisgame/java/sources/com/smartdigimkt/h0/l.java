package com.smartdigimkt.h0;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l implements SensorEventListener {
    public com.smartdigimkt.d1.d a;
    public final k b = new k(this);

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        com.smartdigimkt.d1.d dVar = this.a;
        if (dVar == null) {
            return;
        }
        dVar.a(this.b);
        this.a.a(sensorEvent);
    }
}
