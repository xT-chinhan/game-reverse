package com.smartdigimkt.d1;

import android.hardware.SensorEvent;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends b {
    public float d = 0.0f;
    public float e = 0.0f;
    public float f = 0.0f;
    public int g = 10;
    public a h;

    @Override // com.smartdigimkt.d1.b
    public final void a(g gVar) {
        this.g = gVar.b;
    }

    @Override // com.smartdigimkt.d1.d
    public final void a(a aVar) {
        this.h = aVar;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0055  */
    /* JADX WARN: Code duplicated, block: B:22:0x0060  */
    @Override // com.smartdigimkt.d1.d
    public final boolean a(SensorEvent sensorEvent) {
        float[] fArr;
        if (this.h != null && (fArr = sensorEvent.values) != null && fArr.length >= 3) {
            float f = -fArr[0];
            float f2 = -fArr[1];
            float f3 = -fArr[2];
            b(sensorEvent);
            float f4 = this.d;
            if (f4 == 0.0f || Math.abs(f - f4) <= this.g) {
                float f5 = this.e;
                if (f5 == 0.0f || Math.abs(f2 - f5) <= this.g) {
                    float f6 = this.f;
                    if (f6 != 0.0f && Math.abs(f3 - f6) > this.g) {
                        a();
                        if (this.h.a()) {
                            this.a = 0.0f;
                            this.b = 0.0f;
                            this.c = 0.0f;
                            this.d = 0.0f;
                            this.e = 0.0f;
                            this.f = 0.0f;
                            return true;
                        }
                    }
                } else {
                    a();
                    if (this.h.a()) {
                        this.a = 0.0f;
                        this.b = 0.0f;
                        this.c = 0.0f;
                        this.d = 0.0f;
                        this.e = 0.0f;
                        this.f = 0.0f;
                        return true;
                    }
                }
            } else {
                a();
                if (this.h.a()) {
                    this.a = 0.0f;
                    this.b = 0.0f;
                    this.c = 0.0f;
                    this.d = 0.0f;
                    this.e = 0.0f;
                    this.f = 0.0f;
                    return true;
                }
            }
            this.d = f;
            this.e = f2;
            this.f = f3;
        }
        return false;
    }
}
