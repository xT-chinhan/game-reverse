package com.smartdigimkt.c;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.smartdigimkt.china.based.twist.TwistG2CV2View;
import com.smartdigimkt.z.p;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements SensorEventListener {
    public final float a;
    public final float b;
    public final float c;
    public float d = 0.0f;
    public float e = 0.0f;
    public float f = 0.0f;
    public long g = 0;
    public long h = 0;
    public long i = 0;
    public boolean j = false;
    public final e k;

    public k(float f, float f2, float f3, e eVar) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.k = eVar;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* JADX WARN: Code duplicated, block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:0x014a A[Catch: all -> 0x0161, TryCatch #0 {all -> 0x0161, blocks: (B:3:0x0002, B:6:0x0008, B:8:0x000f, B:10:0x0015, B:13:0x001a, B:15:0x0022, B:17:0x0032, B:19:0x0039, B:21:0x0048, B:24:0x004e, B:27:0x0079, B:30:0x0082, B:33:0x008b, B:35:0x00ae, B:39:0x00b8, B:41:0x00bc, B:42:0x00c2, B:44:0x00c8, B:46:0x00ce, B:50:0x00d8, B:55:0x00e2, B:57:0x00e8, B:62:0x00f2, B:64:0x00f8, B:70:0x0105, B:72:0x010b, B:76:0x0125, B:82:0x0139, B:84:0x014a, B:86:0x0152, B:87:0x0155, B:89:0x0159, B:79:0x012c, B:75:0x011d), top: B:92:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x0152 A[Catch: all -> 0x0161, TryCatch #0 {all -> 0x0161, blocks: (B:3:0x0002, B:6:0x0008, B:8:0x000f, B:10:0x0015, B:13:0x001a, B:15:0x0022, B:17:0x0032, B:19:0x0039, B:21:0x0048, B:24:0x004e, B:27:0x0079, B:30:0x0082, B:33:0x008b, B:35:0x00ae, B:39:0x00b8, B:41:0x00bc, B:42:0x00c2, B:44:0x00c8, B:46:0x00ce, B:50:0x00d8, B:55:0x00e2, B:57:0x00e8, B:62:0x00f2, B:64:0x00f8, B:70:0x0105, B:72:0x010b, B:76:0x0125, B:82:0x0139, B:84:0x014a, B:86:0x0152, B:87:0x0155, B:89:0x0159, B:79:0x012c, B:75:0x011d), top: B:92:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x0159 A[Catch: all -> 0x0161, TRY_LEAVE, TryCatch #0 {all -> 0x0161, blocks: (B:3:0x0002, B:6:0x0008, B:8:0x000f, B:10:0x0015, B:13:0x001a, B:15:0x0022, B:17:0x0032, B:19:0x0039, B:21:0x0048, B:24:0x004e, B:27:0x0079, B:30:0x0082, B:33:0x008b, B:35:0x00ae, B:39:0x00b8, B:41:0x00bc, B:42:0x00c2, B:44:0x00c8, B:46:0x00ce, B:50:0x00d8, B:55:0x00e2, B:57:0x00e8, B:62:0x00f2, B:64:0x00f8, B:70:0x0105, B:72:0x010b, B:76:0x0125, B:82:0x0139, B:84:0x014a, B:86:0x0152, B:87:0x0155, B:89:0x0159, B:79:0x012c, B:75:0x011d), top: B:92:0x0002 }] */
    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        long jCurrentTimeMillis;
        f fVar;
        TwistG2CV2View twistG2CV2View;
        com.smartdigimkt.b2.e eVar;
        if (sensorEvent != null) {
            try {
                Sensor sensor = sensorEvent.sensor;
                if (sensor == null) {
                    return;
                }
                if (sensor.getType() != 4) {
                    sensorEvent.sensor.getType();
                    return;
                }
                if (this.j) {
                    return;
                }
                long j = this.g;
                if (j == 0) {
                    this.g = sensorEvent.timestamp;
                    this.h = System.currentTimeMillis();
                    if (this.i <= 0) {
                        this.i = System.currentTimeMillis();
                        return;
                    }
                    return;
                }
                long j2 = sensorEvent.timestamp;
                float f = (j2 - j) * 1.0E-9f;
                this.g = j2;
                float[] fArr = sensorEvent.values;
                if (fArr != null && fArr.length >= 3) {
                    float f2 = fArr[0];
                    float f3 = fArr[1];
                    float f4 = fArr[2];
                    float degrees = ((float) Math.toDegrees(f2)) * f;
                    float degrees2 = ((float) Math.toDegrees(f3)) * f;
                    float degrees3 = ((float) Math.toDegrees(f4)) * f;
                    if (Math.abs(degrees) < 0.01f) {
                        degrees = 0.0f;
                    }
                    if (Math.abs(degrees2) < 0.01f) {
                        degrees2 = 0.0f;
                    }
                    if (Math.abs(degrees3) < 0.01f) {
                        degrees3 = 0.0f;
                    }
                    this.d += Math.abs(degrees);
                    this.e += Math.abs(degrees2);
                    float fAbs = this.f + Math.abs(degrees3);
                    this.f = fAbs;
                    if (this.d <= 5.0f && this.e <= 5.0f && fAbs <= 5.0f && !this.j) {
                        this.i = System.currentTimeMillis();
                    }
                    float f5 = this.a;
                    if (f5 > 0.0f || this.b > 0.0f || this.c > 0.0f) {
                        boolean z = f5 <= 0.0f || this.d >= f5;
                        float f6 = this.b;
                        boolean z2 = f6 <= 0.0f || this.e >= f6;
                        float f7 = this.c;
                        boolean z3 = f7 <= 0.0f || this.f >= f7;
                        if (z && z2 && z3) {
                            this.j = true;
                            if (this.k != null) {
                                p pVarA = p.a();
                                float f8 = this.d;
                                float f9 = this.e;
                                float f10 = this.f;
                                long jCurrentTimeMillis2 = this.h <= 0 ? 0L : System.currentTimeMillis() - this.h;
                                if (this.i > 0) {
                                    jCurrentTimeMillis = System.currentTimeMillis() - this.i;
                                    if (jCurrentTimeMillis < 0) {
                                    }
                                    pVarA.a(f8, f9, f10, jCurrentTimeMillis2, jCurrentTimeMillis);
                                    TwistG2CV2View twistG2CV2View2 = this.k.a;
                                    int i = TwistG2CV2View.t;
                                    twistG2CV2View2.getClass();
                                    fVar = twistG2CV2View2.r;
                                    if (fVar != null) {
                                        j jVar = ((h) fVar).a;
                                        twistG2CV2View = jVar.i;
                                        if (twistG2CV2View != null) {
                                            twistG2CV2View.getTwistSensorEventListener();
                                        }
                                        eVar = jVar.h;
                                        if (eVar != null) {
                                            eVar.a(19, 50);
                                        }
                                    }
                                }
                                jCurrentTimeMillis = 10;
                                pVarA.a(f8, f9, f10, jCurrentTimeMillis2, jCurrentTimeMillis);
                                TwistG2CV2View twistG2CV2View3 = this.k.a;
                                int i2 = TwistG2CV2View.t;
                                twistG2CV2View3.getClass();
                                fVar = twistG2CV2View3.r;
                                if (fVar != null) {
                                    j jVar2 = ((h) fVar).a;
                                    twistG2CV2View = jVar2.i;
                                    if (twistG2CV2View != null) {
                                        twistG2CV2View.getTwistSensorEventListener();
                                    }
                                    eVar = jVar2.h;
                                    if (eVar != null) {
                                        eVar.a(19, 50);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
