package com.anythink.core.common.inner.c;

import android.hardware.SensorEvent;
import com.anythink.core.common.d.s;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c extends b {
    List<Double> e;
    long f;
    a n;
    float o;
    float p;
    float q;
    public long d = 0;
    private long t = 0;
    String r = "";
    List<Double> k = new ArrayList();
    List<Double> l = new ArrayList();
    List<Double> m = new ArrayList();
    long g = 0;
    int h = 0;
    int i = 0;
    int j = 0;
    boolean s = false;

    @Override // com.anythink.core.common.inner.c.d
    public final void a(e eVar) {
        this.t = eVar.d();
        this.e = eVar.a;
        this.f = eVar.b;
        this.r = eVar.toString();
    }

    @Override // com.anythink.core.common.inner.c.d
    public final void a(a aVar) {
        this.n = aVar;
    }

    @Override // com.anythink.core.common.inner.c.d
    public final boolean b(SensorEvent sensorEvent) {
        if (this.n != null && sensorEvent.values != null && sensorEvent.values.length >= 3) {
            try {
                float[] fArr = sensorEvent.values;
                float f = this.o;
                if (f == 0.0f) {
                    this.o = -fArr[0];
                    this.p = -fArr[1];
                    this.q = -fArr[2];
                    return false;
                }
                float f2 = (-fArr[0]) - f;
                float f3 = (-fArr[1]) - this.p;
                float f4 = (-fArr[2]) - this.q;
                a(sensorEvent);
                if (this.g == 0) {
                    this.g = a(f2, f3, f4);
                } else if (System.currentTimeMillis() - this.g > this.f) {
                    c();
                } else {
                    if (this.h > 0 && this.k.size() > 0) {
                        if (this.h >= this.k.size()) {
                            c();
                            return d();
                        }
                        double dDoubleValue = this.k.get(this.h).doubleValue();
                        if (((double) f2) * dDoubleValue > 0.0d && Math.abs(f2) > Math.abs(dDoubleValue)) {
                            this.h++;
                        }
                    }
                    if (this.i > 0 && this.l.size() > 0) {
                        if (this.i >= this.l.size()) {
                            c();
                            return d();
                        }
                        double dDoubleValue2 = this.l.get(this.i).doubleValue();
                        if (((double) f3) * dDoubleValue2 > 0.0d && Math.abs(f3) > Math.abs(dDoubleValue2)) {
                            this.i++;
                        }
                    }
                    if (this.j > 0 && this.m.size() > 0) {
                        if (this.j >= this.m.size()) {
                            c();
                            return d();
                        }
                        double dDoubleValue3 = this.m.get(this.j).doubleValue();
                        if (((double) f4) * dDoubleValue3 > 0.0d && Math.abs(f4) > Math.abs(dDoubleValue3)) {
                            this.j++;
                        }
                    }
                    a(f2, f3, f4);
                }
            } catch (Throwable th) {
                if (!this.s) {
                    com.anythink.core.common.t.f.b("ShakeHandler", "Throwable:" + th.getMessage() + ",params:" + this.r, s.b().r());
                    this.s = true;
                }
            }
        }
        return false;
    }

    private void c() {
        this.g = 0L;
        this.h = 0;
        this.k.clear();
        this.i = 0;
        this.l.clear();
        this.j = 0;
        this.m.clear();
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0025  */
    private long a(float f, float f2, float f3) {
        long jCurrentTimeMillis;
        double dA = a(0);
        if (this.h != 0 || Math.abs(f) < dA) {
            jCurrentTimeMillis = 0;
        } else {
            a(0, f);
            this.h = 1;
            if (this.g == 0) {
                jCurrentTimeMillis = System.currentTimeMillis();
            } else {
                jCurrentTimeMillis = 0;
            }
        }
        if (this.i == 0 && Math.abs(f2) >= dA) {
            a(1, f2);
            this.i = 1;
            if (this.g == 0) {
                jCurrentTimeMillis = System.currentTimeMillis();
            }
        }
        if (this.j != 0 || Math.abs(f3) < dA) {
            return jCurrentTimeMillis;
        }
        a(2, f3);
        this.j = 1;
        return this.g == 0 ? System.currentTimeMillis() : jCurrentTimeMillis;
    }

    private boolean d() {
        if (this.n == null) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.d <= this.t) {
            return false;
        }
        b();
        if (!this.n.a()) {
            return false;
        }
        this.d = jCurrentTimeMillis;
        a();
        return true;
    }

    private void a(int i, float f) {
        List<Double> list;
        if (i == 1) {
            list = this.l;
        } else if (i == 2) {
            list = this.m;
        } else {
            list = this.k;
        }
        list.clear();
        for (int i2 = 0; i2 < this.e.size() - 1; i2++) {
            double dA = a(i2);
            if (f < 0.0f) {
                list.add(Double.valueOf((-1.0d) * dA));
                list.add(Double.valueOf(dA * 1.0d));
            } else {
                list.add(Double.valueOf(1.0d * dA));
                list.add(Double.valueOf(dA * (-1.0d)));
            }
        }
        double dA2 = a(this.e.size() - 1);
        if (f < 0.0f) {
            list.add(Double.valueOf(dA2 * (-1.0d)));
        } else {
            list.add(Double.valueOf(dA2 * 1.0d));
        }
    }

    private double a(int i) {
        List<Double> list = this.e;
        if (list == null || list.size() <= i) {
            return Double.MAX_VALUE;
        }
        return this.e.get(i).doubleValue();
    }

    @Override // com.anythink.core.common.inner.c.b
    protected final void a() {
        super.a();
        c();
    }
}
