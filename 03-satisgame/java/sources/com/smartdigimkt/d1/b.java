package com.smartdigimkt.d1;

import android.hardware.SensorEvent;
import com.smartdigimkt.z.o;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements d {
    public float a = 0.0f;
    public float b = 0.0f;
    public float c = 0.0f;

    public final void a() {
        float[] fArr;
        o oVarA = o.a();
        try {
            fArr = new float[]{this.a, this.b, this.c};
        } catch (Throwable unused) {
            fArr = null;
        }
        synchronized (oVarA) {
            oVarA.c = fArr;
        }
    }

    public abstract void a(g gVar);

    public final void b(SensorEvent sensorEvent) {
        try {
            float[] fArr = sensorEvent.values;
            if (Math.abs(fArr[0]) > this.a) {
                this.a = Math.abs(fArr[0]);
            }
            if (Math.abs(fArr[1]) > this.b) {
                this.b = Math.abs(fArr[1]);
            }
            if (Math.abs(fArr[2]) > this.c) {
                this.c = Math.abs(fArr[2]);
            }
        } catch (Throwable unused) {
        }
    }
}
