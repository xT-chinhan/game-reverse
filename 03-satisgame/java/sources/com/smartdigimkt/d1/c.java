package com.smartdigimkt.d1;

import android.hardware.SensorEvent;
import com.smartdigimkt.n3.k;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends b {
    public List d;
    public long e;
    public a m;
    public float n;
    public float o;
    public float p;
    public String q = "";
    public final ArrayList j = new ArrayList();
    public final ArrayList k = new ArrayList();
    public final ArrayList l = new ArrayList();
    public long f = 0;
    public int g = 0;
    public int h = 0;
    public int i = 0;
    public boolean r = false;

    @Override // com.smartdigimkt.d1.b
    public final void a(g gVar) {
        this.d = gVar.c;
        this.e = gVar.d;
        this.q = gVar.toString();
    }

    public final void b() {
        this.f = 0L;
        this.g = 0;
        this.j.clear();
        this.h = 0;
        this.k.clear();
        this.i = 0;
        this.l.clear();
    }

    @Override // com.smartdigimkt.d1.d
    public final void a(a aVar) {
        this.m = aVar;
    }

    @Override // com.smartdigimkt.d1.d
    public final boolean a(SensorEvent sensorEvent) {
        float[] fArr;
        if (this.m != null && (fArr = sensorEvent.values) != null && fArr.length >= 3) {
            try {
                float f = this.n;
                if (f == 0.0f) {
                    this.n = -fArr[0];
                    this.o = -fArr[1];
                    this.p = -fArr[2];
                    return false;
                }
                float f2 = (-fArr[0]) - f;
                float f3 = (-fArr[1]) - this.o;
                float f4 = (-fArr[2]) - this.p;
                b(sensorEvent);
                if (this.f == 0) {
                    this.f = a(f2, f3, f4);
                } else if (System.currentTimeMillis() - this.f > this.e) {
                    b();
                } else {
                    if (this.g > 0 && this.j.size() > 0) {
                        if (this.g >= this.j.size()) {
                            b();
                            if (this.m == null) {
                                return false;
                            }
                            a();
                            if (!this.m.a()) {
                                return false;
                            }
                            this.a = 0.0f;
                            this.b = 0.0f;
                            this.c = 0.0f;
                            b();
                            return true;
                        }
                        double dDoubleValue = ((Double) this.j.get(this.g)).doubleValue();
                        if (((double) f2) * dDoubleValue > 0.0d && Math.abs(f2) > Math.abs(dDoubleValue)) {
                            this.g++;
                        }
                    }
                    if (this.h > 0 && this.k.size() > 0) {
                        if (this.h >= this.k.size()) {
                            b();
                            if (this.m == null) {
                                return false;
                            }
                            a();
                            if (!this.m.a()) {
                                return false;
                            }
                            this.a = 0.0f;
                            this.b = 0.0f;
                            this.c = 0.0f;
                            b();
                            return true;
                        }
                        double dDoubleValue2 = ((Double) this.k.get(this.h)).doubleValue();
                        if (((double) f3) * dDoubleValue2 > 0.0d && Math.abs(f3) > Math.abs(dDoubleValue2)) {
                            this.h++;
                        }
                    }
                    if (this.i > 0 && this.l.size() > 0) {
                        if (this.i >= this.l.size()) {
                            b();
                            if (this.m == null) {
                                return false;
                            }
                            a();
                            if (!this.m.a()) {
                                return false;
                            }
                            this.a = 0.0f;
                            this.b = 0.0f;
                            this.c = 0.0f;
                            b();
                            return true;
                        }
                        double dDoubleValue3 = ((Double) this.l.get(this.i)).doubleValue();
                        if (((double) f4) * dDoubleValue3 > 0.0d && Math.abs(f4) > Math.abs(dDoubleValue3)) {
                            this.i++;
                        }
                    }
                    a(f2, f3, f4);
                }
            } catch (Throwable th) {
                if (!this.r) {
                    k.a("ShakeHandler", "Throwable:" + (th.getMessage() + ", " + com.smartdigimkt.r4.k.a(th.getStackTrace())) + ",params:" + this.q, SDKContext.getInstance().f(), "");
                    this.r = true;
                }
            }
        }
        return false;
    }

    public final void a(int i, float f) {
        ArrayList arrayList;
        double dDoubleValue;
        if (i == 1) {
            arrayList = this.k;
        } else if (i != 2) {
            arrayList = this.j;
        } else {
            arrayList = this.l;
        }
        arrayList.clear();
        int i2 = 0;
        while (true) {
            dDoubleValue = Double.MAX_VALUE;
            if (i2 >= this.d.size() - 1) {
                break;
            }
            List list = this.d;
            if (list != null && list.size() > i2) {
                dDoubleValue = ((Double) this.d.get(i2)).doubleValue();
            }
            if (f < 0.0f) {
                arrayList.add(Double.valueOf((-1.0d) * dDoubleValue));
                arrayList.add(Double.valueOf(dDoubleValue * 1.0d));
            } else {
                arrayList.add(Double.valueOf(1.0d * dDoubleValue));
                arrayList.add(Double.valueOf(dDoubleValue * (-1.0d)));
            }
            i2++;
        }
        int size = this.d.size() - 1;
        List list2 = this.d;
        if (list2 != null && list2.size() > size) {
            dDoubleValue = ((Double) this.d.get(size)).doubleValue();
        }
        if (f < 0.0f) {
            arrayList.add(Double.valueOf(dDoubleValue * (-1.0d)));
        } else {
            arrayList.add(Double.valueOf(dDoubleValue * 1.0d));
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003d  */
    public final long a(float f, float f2, float f3) {
        long jCurrentTimeMillis;
        List list = this.d;
        double dDoubleValue = (list == null || list.size() <= 0) ? Double.MAX_VALUE : ((Double) this.d.get(0)).doubleValue();
        if (this.g != 0 || Math.abs(f) < dDoubleValue) {
            jCurrentTimeMillis = 0;
        } else {
            a(0, f);
            this.g = 1;
            if (this.f == 0) {
                jCurrentTimeMillis = System.currentTimeMillis();
            } else {
                jCurrentTimeMillis = 0;
            }
        }
        if (this.h == 0 && Math.abs(f2) >= dDoubleValue) {
            a(1, f2);
            this.h = 1;
            if (this.f == 0) {
                jCurrentTimeMillis = System.currentTimeMillis();
            }
        }
        if (this.i != 0 || Math.abs(f3) < dDoubleValue) {
            return jCurrentTimeMillis;
        }
        a(2, f3);
        this.i = 1;
        return this.f == 0 ? System.currentTimeMillis() : jCurrentTimeMillis;
    }
}
