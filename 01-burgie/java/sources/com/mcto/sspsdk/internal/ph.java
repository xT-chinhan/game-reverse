package com.mcto.sspsdk.internal;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.bykv.vk.component.ttvideo.player.C;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class ph implements SensorEventListener {
    public float a = 0.0f;
    public float b = 0.0f;
    public int c = 0;
    public final ArrayList d = new ArrayList(32);
    public long e = 0;
    public final /* synthetic */ qh f;

    public ph(qh qhVar) {
        this.f = qhVar;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* JADX WARN: Code duplicated, block: B:47:0x011b  */
    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        boolean z;
        if (this.f.e) {
            return;
        }
        if (sensorEvent.sensor.getType() == 1) {
            oh ohVar = this.f.k;
            float f = ohVar.e;
            if (f != Float.MAX_VALUE) {
                float f2 = ohVar.f;
                if (f2 != Float.MIN_VALUE && (f2 - f > 0.46f || ohVar.h - ohVar.g > 0.46f || ohVar.j - ohVar.i > 0.46f)) {
                    float[] fArr = sensorEvent.values;
                    float f3 = fArr[0];
                    float f4 = fArr[1];
                    if (Math.abs(f3) >= this.f.h && (this.a * f3 <= 0.0f || this.c != 1)) {
                        this.c = 1;
                        this.a = f3;
                        this.d.add(Long.valueOf(sensorEvent.timestamp));
                        this.f.k.a();
                    } else if (Math.abs(f4) < this.f.h || (this.b * f4 > 0.0f && this.c == 2)) {
                        z = false;
                    } else {
                        this.c = 2;
                        this.b = f4;
                        this.d.add(Long.valueOf(sensorEvent.timestamp));
                        this.f.k.a();
                    }
                    if (this.d.size() >= this.f.i) {
                        ArrayList arrayList = this.d;
                        long jLongValue = ((Long) arrayList.get(arrayList.size() - 1)).longValue();
                        ArrayList arrayList2 = this.d;
                        z = jLongValue - ((Long) arrayList2.get(arrayList2.size() - this.f.i)).longValue() < ((long) this.f.g) * C.MICROS_PER_SECOND;
                        this.d.clear();
                        if (z) {
                            this.a = 0.0f;
                            this.b = 0.0f;
                            this.c = 0;
                            long j = this.e;
                            if (j == 0 || sensorEvent.timestamp - j >= 5000000000L) {
                                this.e = sensorEvent.timestamp;
                            } else {
                                z = false;
                            }
                        } else {
                            this.d.add(Long.valueOf(sensorEvent.timestamp));
                        }
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        if (z) {
            try {
                this.f.e = true;
                qh.a(this.f);
                this.f.e = false;
            } catch (Throwable th) {
            }
        }
    }
}
