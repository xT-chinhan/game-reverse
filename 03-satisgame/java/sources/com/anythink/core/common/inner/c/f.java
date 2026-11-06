package com.anythink.core.common.inner.c;

import android.hardware.SensorEvent;

/* JADX INFO: loaded from: classes.dex */
public final class f extends b {
    a h;
    public float d = 0.0f;
    public float e = 0.0f;
    public float f = 0.0f;
    public long g = 0;
    private int i = 10;
    private long j = 5000;

    @Override // com.anythink.core.common.inner.c.d
    public final void a(e eVar) {
        this.i = eVar.b();
        this.j = eVar.d();
    }

    @Override // com.anythink.core.common.inner.c.d
    public final void a(a aVar) {
        this.h = aVar;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0059  */
    /* JADX WARN: Code duplicated, block: B:22:0x0067  */
    /* JADX WARN: Code duplicated, block: B:24:0x0072  */
    @Override // com.anythink.core.common.inner.c.d
    public final boolean b(SensorEvent sensorEvent) {
        long jCurrentTimeMillis;
        if (this.h != null && sensorEvent.values != null && sensorEvent.values.length >= 3) {
            float[] fArr = sensorEvent.values;
            float f = -fArr[0];
            float f2 = -fArr[1];
            float f3 = -fArr[2];
            a(sensorEvent);
            float f4 = this.d;
            if (f4 == 0.0f || Math.abs(f - f4) <= this.i) {
                float f5 = this.e;
                if (f5 == 0.0f || Math.abs(f2 - f5) <= this.i) {
                    float f6 = this.f;
                    if (f6 != 0.0f && Math.abs(f3 - f6) > this.i) {
                        jCurrentTimeMillis = System.currentTimeMillis();
                        if (jCurrentTimeMillis - this.g > this.j) {
                            b();
                            if (this.h.a()) {
                                this.g = jCurrentTimeMillis;
                                a();
                                return true;
                            }
                        }
                    }
                } else {
                    jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - this.g > this.j) {
                        b();
                        if (this.h.a()) {
                            this.g = jCurrentTimeMillis;
                            a();
                            return true;
                        }
                    }
                }
            } else {
                jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.g > this.j) {
                    b();
                    if (this.h.a()) {
                        this.g = jCurrentTimeMillis;
                        a();
                        return true;
                    }
                }
            }
            this.d = f;
            this.e = f2;
            this.f = f3;
        }
        return false;
    }

    @Override // com.anythink.core.common.inner.c.b
    protected final void a() {
        super.a();
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 0.0f;
    }
}
