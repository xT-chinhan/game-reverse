package com.smartdigimkt.d1;

import android.hardware.SensorEvent;
import com.smartdigimkt.b3.u;
import com.smartdigimkt.z.o;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements d {
    public a b;
    public boolean c;
    public float d;
    public float e;
    public float f;
    public long g;
    public long h;
    public long i;
    public long j;
    public boolean k;
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public float r;
    public float s;
    public float t;
    public u a = u.i;
    public int l = -1;

    @Override // com.smartdigimkt.d1.d
    public final void a(a aVar) {
        this.b = aVar;
    }

    public final boolean b(float f, double d) {
        int i = this.m;
        return (i > 0 && ((double) f) >= d) || (i < 0 && ((double) f) <= (-d));
    }

    @Override // com.smartdigimkt.d1.d
    public final boolean a(SensorEvent sensorEvent) {
        float[] fArr;
        int i;
        if (this.q || sensorEvent == null || (fArr = sensorEvent.values) == null || fArr.length < 3) {
            return false;
        }
        if (!this.a.a()) {
            return false;
        }
        long j = sensorEvent.timestamp;
        if (j == this.j) {
            return false;
        }
        this.j = j;
        float[] fArr2 = sensorEvent.values;
        float f = fArr2[0];
        float f2 = fArr2[1];
        float f3 = fArr2[2];
        if (this.a.e == 1) {
            float fAbs = Math.abs(f);
            float fAbs2 = Math.abs(f2);
            float fAbs3 = Math.abs(f3);
            if (fAbs > this.r) {
                this.r = fAbs;
            }
            if (fAbs2 > this.s) {
                this.s = fAbs2;
            }
            if (fAbs3 > this.t) {
                this.t = fAbs3;
            }
        }
        if (!this.c) {
            this.i = System.currentTimeMillis();
            this.d = f;
            this.e = f2;
            this.f = f3;
            this.c = true;
            Math.sqrt((f3 * f3) + (f2 * f2) + (f * f));
            return false;
        }
        float f4 = f - this.d;
        float f5 = f2 - this.e;
        float f6 = f3 - this.f;
        double dSqrt = Math.sqrt((f6 * f6) + (f5 * f5) + (f4 * f4));
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = jCurrentTimeMillis - this.i;
        this.i = jCurrentTimeMillis;
        u uVar = this.a;
        if (uVar.e == 2) {
            if (dSqrt >= uVar.h) {
                this.h = 0L;
            } else if (this.g > 0) {
                if (this.h <= 0) {
                    this.h = jCurrentTimeMillis;
                }
                if (jCurrentTimeMillis - this.h >= 500) {
                    b();
                }
            }
        } else if ((this.g > 0 || this.l >= 0) && j2 > 500) {
            b();
        }
        u uVar2 = this.a;
        if (uVar2.e == 2 && dSqrt >= uVar2.h) {
            float fAbs4 = Math.abs(f);
            float fAbs5 = Math.abs(f2);
            float fAbs6 = Math.abs(f3);
            if (fAbs4 > this.r) {
                this.r = fAbs4;
            }
            if (fAbs5 > this.s) {
                this.s = fAbs5;
            }
            if (fAbs6 > this.t) {
                this.t = fAbs6;
            }
        }
        u uVar3 = this.a;
        if (uVar3.e == 1) {
            if (uVar3.a == 1) {
                a(f4, f5, f6);
                if (dSqrt >= this.a.f && this.o) {
                    return a();
                }
            } else if (dSqrt >= uVar3.f) {
                return a();
            }
            return false;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        u uVar4 = this.a;
        if (dSqrt < uVar4.h) {
            return a(jCurrentTimeMillis2, dSqrt);
        }
        if (this.g <= 0) {
            this.g = jCurrentTimeMillis2;
        }
        if (dSqrt >= uVar4.f) {
            i = 1;
            this.k = true;
        } else {
            i = 1;
        }
        if (uVar4.a == i) {
            a(f4, f5, f6);
        }
        return a(jCurrentTimeMillis2, dSqrt);
    }

    public final void b() {
        if (this.a.e == 2) {
            this.r = 0.0f;
            this.s = 0.0f;
            this.t = 0.0f;
        }
        this.g = 0L;
        this.h = 0L;
        this.k = false;
        this.l = -1;
        this.m = 0;
        this.n = false;
        this.o = false;
        this.p = false;
    }

    public final boolean a(long j, double d) {
        long j2 = this.g;
        boolean zA = false;
        if (j2 <= 0) {
            return false;
        }
        long j3 = j - j2;
        u uVar = this.a;
        if (j3 < uVar.g) {
            if (this.k && !this.p) {
                this.p = true;
            }
            return false;
        }
        double d2 = uVar.h;
        if (d >= d2 && uVar.a == 2 && this.k) {
            zA = a();
        } else if (d >= d2 && uVar.a == 1 && this.n) {
            zA = a();
        }
        if (!zA) {
            long j4 = this.a.g;
            b();
        }
        return zA;
    }

    public final void a(float f, float f2, float f3) {
        double d = this.a.f;
        if (this.l < 0) {
            if (Math.abs(f) >= d) {
                this.l = 0;
                this.m = f < 0.0f ? -1 : 1;
                return;
            } else if (Math.abs(f2) >= d) {
                this.l = 1;
                this.m = f2 < 0.0f ? -1 : 1;
                return;
            } else {
                if (Math.abs(f3) >= d) {
                    this.l = 2;
                    this.m = f3 < 0.0f ? -1 : 1;
                    return;
                }
                return;
            }
        }
        boolean z = a(f, d) || a(f2, d) || a(f3, d);
        boolean z2 = b(f, d) || b(f2, d) || b(f3, d);
        boolean z3 = this.n;
        if (!z3 && z) {
            this.n = true;
        } else if (z3 && !this.o && z2) {
            this.o = true;
        }
    }

    public final boolean a(float f, double d) {
        int i = this.m;
        return (i > 0 && ((double) f) <= (-d)) || (i < 0 && ((double) f) >= d);
    }

    public final boolean a() {
        o oVarA = o.a();
        float[] fArr = {this.r, this.s, this.t};
        synchronized (oVarA) {
            oVarA.c = fArr;
        }
        a aVar = this.b;
        if (aVar == null) {
            return false;
        }
        boolean zA = aVar.a();
        if (zA) {
            this.q = true;
        }
        int i = this.a.a;
        this.b.getClass();
        return zA;
    }
}
