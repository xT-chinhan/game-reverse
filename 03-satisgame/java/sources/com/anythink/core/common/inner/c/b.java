package com.anythink.core.common.inner.c;

import android.hardware.SensorEvent;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements d {
    protected final int a = 0;
    protected final int b = 1;
    protected final int c = 2;
    private float d = 0.0f;
    private float e = 0.0f;
    private float f = 0.0f;

    protected final void a(SensorEvent sensorEvent) {
        try {
            float[] fArr = sensorEvent.values;
            if (Math.abs(fArr[0]) > this.d) {
                this.d = Math.abs(fArr[0]);
            }
            if (Math.abs(fArr[1]) > this.e) {
                this.e = Math.abs(fArr[1]);
            }
            if (Math.abs(fArr[2]) > this.f) {
                this.f = Math.abs(fArr[2]);
            }
        } catch (Throwable unused) {
        }
    }

    protected void a() {
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 0.0f;
    }

    protected final void b() {
        com.anythink.core.b.a.a().a(c());
    }

    private float[] c() {
        try {
            return new float[]{this.d, this.e, this.f};
        } catch (Throwable unused) {
            return null;
        }
    }
}
