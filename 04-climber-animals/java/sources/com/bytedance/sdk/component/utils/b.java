package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.anythink.basead.exoplayer.i.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b implements SensorEventListener {
    private static re vm;
    private volatile long ab;
    private float ah;
    private Sensor ao;
    private float az;
    private float d;
    private Sensor h;
    private nw hi;
    private int i;
    private JSONObject jw;
    private float k;
    private float ka;
    private float lm;
    private Context qk;
    private float qv;
    private ah s;
    private Sensor u;
    private Sensor ub;
    private boolean v;
    private volatile long xr;
    private int y;
    private float yu;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final long f1351ms = a.f;
    private boolean c = false;
    private float x = 13.0f;
    private float ny = 50.0f;
    private int ch = 0;
    private ms sl = null;
    private xr zb = null;
    private final long t = 500;
    private volatile long nw = 0;
    private volatile boolean b = false;
    private volatile boolean re = false;
    private final float w = 1.0E-9f;
    private float[] op = new float[3];
    private long le = 0;
    private float cv = 0.0f;
    private float g = 4.0f;
    private float of = 0.0f;
    private float[] p = new float[3];
    private final float pc = 0.0f;
    private boolean f = false;
    private boolean ul = false;
    private boolean m = false;
    private boolean e = false;
    private int eg = 0;
    private int fm = 0;
    private int xn = 0;
    private int il = 0;
    private int qf = 0;
    private int l = 0;
    private boolean am = false;
    private int sa = 0;
    private int tz = 0;
    private float ti = 0.0f;

    public interface ah {
        void ms();
    }

    public interface ms {
        void ms(int i);
    }

    public interface xr {
        void ms(float f, float f2, float f3);
    }

    private int c(float f) {
        return f < 0.0f ? 1 : 2;
    }

    private float ms(double d) {
        if (d <= 0.0d || d > 180.0d) {
            d = 50.0d;
        }
        return (float) d;
    }

    private boolean ms(float f, float f2) {
        return f2 > 0.0f && f > f2;
    }

    private boolean ms(int i, int i2) {
        return (i | i2) == 3;
    }

    private boolean ms(int i, int i2, int i3) {
        return i2 == 3 && (i | i3) == 3;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public b(Context context, int i, boolean z) {
        this.hi = null;
        this.v = z;
        this.i = i;
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.qk = applicationContext;
        if (applicationContext == null) {
            return;
        }
        sl.ms("xgc_cus", "cus:" + z);
        if (z) {
            this.hi = nw.ms(this.qk);
        }
    }

    public void ms(boolean z) {
        Context context;
        sl.ms("xgcc", "cus:" + z + " m:" + this.v + " equ:" + (this.hi != null));
        if (!z) {
            nw nwVar = this.hi;
            if (nwVar != null) {
                nwVar.ms(this);
                this.hi = null;
                return;
            }
            return;
        }
        if (this.v || this.hi != null || (context = this.qk) == null) {
            return;
        }
        this.hi = nw.ms(context);
    }

    public void ms(ms msVar) {
        this.sl = msVar;
    }

    public void ms(xr xrVar) {
        this.zb = xrVar;
    }

    private boolean xr() {
        nw nwVar = this.hi;
        if (nwVar == null) {
            return false;
        }
        try {
            if (this.ch == 4) {
                return ah();
            }
            if (this.u == null) {
                this.u = nwVar.ms(1);
            }
            boolean zMs = this.hi.ms(this, this.u, 3);
            c();
            return zMs;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean ah() {
        int i;
        nw nwVar = this.hi;
        boolean zMs = false;
        if (nwVar == null) {
            return false;
        }
        try {
            if (this.y == 0) {
                if (this.ub == null) {
                    this.ub = nwVar.ms(15);
                }
                this.c = false;
                zMs = this.hi.ms(this, this.ub, 1);
            }
            int i2 = this.y;
            if (i2 == 3 || i2 == 2 || i2 == 4 || i2 == 7) {
                if (this.ao == null) {
                    this.ao = this.hi.ms(4);
                }
                float f = this.g;
                if (f != 0.0f && ((i = this.y) == 2 || i == 4)) {
                    this.ti = (float) Math.pow(f, 2.0d);
                    if (this.h == null) {
                        this.h = this.hi.ms(10);
                    }
                    this.hi.ms(this, this.h, 1);
                }
                zMs = this.hi.ms(this, this.ao, 1);
            }
            ab();
        } catch (Throwable unused) {
        }
        return zMs;
    }

    public static void ms(re reVar) {
        vm = reVar;
    }

    public boolean ms(int i) {
        re reVar;
        if (i > 0 && (reVar = vm) != null && !reVar.ms(i)) {
            vm.ms(i, hashCode(), new Runnable() { // from class: com.bytedance.sdk.component.utils.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.d();
                }
            });
            return true;
        }
        return d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        if (this.hi == null || this.am) {
            return false;
        }
        int i = this.i;
        if (i == 1) {
            return xr();
        }
        if (i == 2) {
            return ah();
        }
        return false;
    }

    public void xr(int i) {
        ka();
        re reVar = vm;
        if (reVar != null) {
            reVar.ms(i, hashCode());
        }
    }

    private void ka() {
        nw nwVar = this.hi;
        if (nwVar == null) {
            return;
        }
        nwVar.ms(this);
    }

    public void ah(int i) {
        this.am = false;
        ms(i);
    }

    public void d(int i) {
        this.am = true;
        xr(i);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        ah ahVar = this.s;
        if (ahVar != null) {
            ahVar.ms();
        }
        int type = sensorEvent.sensor.getType();
        float[] fArr = sensorEvent.values;
        float fAbs = Math.abs(fArr[0]);
        float fAbs2 = Math.abs(fArr[1]);
        float fAbs3 = Math.abs(fArr[2]);
        if (type == 1) {
            if (this.sl == null || System.currentTimeMillis() - this.xr <= a.f) {
                return;
            }
            int i = this.ch;
            if (i == 1) {
                double dSqrt = Math.sqrt(Math.pow(fAbs, 2.0d) + Math.pow(fAbs2, 2.0d) + Math.pow(fAbs3, 2.0d));
                ms(dSqrt > ((double) this.x), dSqrt);
                return;
            } else if (i == 2) {
                xr(Math.sqrt((Math.pow((double) fAbs, 2.0d) + Math.pow((double) fAbs2, 2.0d)) + Math.pow((double) fAbs3, 2.0d)) > ((double) this.x), sensorEvent);
                return;
            } else if (i == 3) {
                ms(Math.sqrt((Math.pow((double) fAbs, 2.0d) + Math.pow((double) fAbs2, 2.0d)) + Math.pow((double) fAbs3, 2.0d)) > ((double) this.x), sensorEvent);
                return;
            } else {
                double dMs = ms(fAbs, fAbs2, fAbs3);
                ms(dMs > ((double) this.x), dMs);
                return;
            }
        }
        if (type == 4) {
            int i2 = this.y;
            if (i2 == 3) {
                xr(sensorEvent);
                return;
            } else {
                if (i2 == 2 || i2 == 4 || i2 == 7) {
                    ms(sensorEvent);
                    return;
                }
                return;
            }
        }
        if (type == 10) {
            this.of = (float) (Math.pow(sensorEvent.values[0], 2.0d) + Math.pow(sensorEvent.values[1], 2.0d) + Math.pow(sensorEvent.values[2], 2.0d));
            return;
        }
        if (type != 15) {
            return;
        }
        float fAbs4 = Math.abs(fArr[0]);
        float fAbs5 = Math.abs(fArr[1]);
        float fAbs6 = Math.abs(fArr[2]);
        xr xrVar = this.zb;
        if (xrVar != null) {
            xrVar.ms(fArr[0], fArr[1], fArr[2]);
        }
        if (fAbs4 == 0.0f && fAbs5 == 0.0f && fAbs6 == 0.0f) {
            return;
        }
        if (!this.c) {
            this.c = true;
            this.ah = fAbs4;
            this.d = fAbs5;
            this.ka = fAbs6;
            return;
        }
        float fAbs7 = Math.abs(fAbs4 - this.ah) * 180.0f;
        float fAbs8 = Math.abs(fAbs5 - this.d) * 180.0f;
        float fAbs9 = Math.abs(fAbs6 - this.ka) * 180.0f;
        if (this.f) {
            boolean z = this.ul && fAbs7 > this.az;
            boolean z2 = this.m && fAbs8 > this.lm;
            boolean z3 = this.e && fAbs9 > this.k;
            if ((z || z2 || z3) && this.sl != null && System.currentTimeMillis() - this.ab > a.f) {
                this.sl.ms(getType());
                this.ab = System.currentTimeMillis();
                this.c = false;
                return;
            }
            return;
        }
        float f = this.ny;
        if ((fAbs7 > f || fAbs8 > f || fAbs9 > f) && this.sl != null && System.currentTimeMillis() - this.ab > a.f) {
            this.sl.ms(getType());
            this.ab = System.currentTimeMillis();
            this.c = false;
        }
    }

    private void ms(SensorEvent sensorEvent) {
        if (this.le != 0) {
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            float f4 = (sensorEvent.timestamp - this.le) * 1.0E-9f;
            float f5 = this.cv;
            if (f5 != 0.0f) {
                if (!xr(f5, f) || !xr(this.cv, f2) || !xr(this.cv, f3)) {
                    xr(true);
                } else {
                    ms(f, f2, f3, f4);
                }
            } else {
                float f6 = this.ti;
                if (f6 != 0.0f && this.of >= f6) {
                    xr(true);
                } else {
                    ms(f, f2, f3, f4);
                }
            }
            if (this.y == 7) {
                ab(this.ny);
            } else {
                d(this.ny);
            }
            xr xrVar = this.zb;
            if (xrVar != null) {
                float[] fArr = this.p;
                xrVar.ms(fArr[0], fArr[1], fArr[2]);
            }
        }
        this.le = sensorEvent.timestamp;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00bb  */
    private void xr(SensorEvent sensorEvent) {
        boolean z;
        if (this.yu != 0.0f) {
            float f = (sensorEvent.timestamp - this.yu) * 1.0E-9f;
            float[] fArr = this.op;
            fArr[0] = fArr[0] + (sensorEvent.values[0] * f);
            float[] fArr2 = this.op;
            fArr2[1] = fArr2[1] + (sensorEvent.values[1] * f);
            float[] fArr3 = this.op;
            fArr3[2] = fArr3[2] + (sensorEvent.values[2] * f);
            float fAbs = Math.abs((float) Math.toDegrees(this.op[0]));
            float fAbs2 = Math.abs((float) Math.toDegrees(this.op[1]));
            float fAbs3 = Math.abs((float) Math.toDegrees(this.op[2]));
            if (this.f) {
                boolean z2 = this.ul && ms(fAbs, this.az);
                boolean z3 = this.m && ms(fAbs2, this.lm);
                boolean z4 = this.e && ms(fAbs3, this.k);
                if (z2 || z3 || z4) {
                    float[] fArr4 = this.op;
                    fArr4[0] = 0.0f;
                    fArr4[1] = 0.0f;
                    fArr4[2] = 0.0f;
                    z = true;
                } else {
                    z = false;
                }
            } else if (ms(fAbs, this.ny) || ms(fAbs2, this.ny) || ms(fAbs3, this.ny)) {
                float[] fArr5 = this.op;
                fArr5[0] = 0.0f;
                fArr5[1] = 0.0f;
                fArr5[2] = 0.0f;
                z = true;
            } else {
                z = false;
            }
            if (z && System.currentTimeMillis() - this.ab > a.f) {
                this.sl.ms(getType());
                this.ab = System.currentTimeMillis();
            }
            xr xrVar = this.zb;
            if (xrVar != null) {
                float[] fArr6 = this.op;
                xrVar.ms(fArr6[0], fArr6[1], fArr6[2]);
            }
        }
        this.yu = sensorEvent.timestamp;
    }

    private void d(float f) {
        if (!ms(this.y == 4, f) || System.currentTimeMillis() - this.ab <= a.f) {
            return;
        }
        this.sl.ms(getType());
        this.ab = System.currentTimeMillis();
    }

    private boolean ms(boolean z, float f) {
        float fAbs = Math.abs((float) Math.toDegrees(this.p[0]));
        float fAbs2 = Math.abs((float) Math.toDegrees(this.p[1]));
        float fAbs3 = Math.abs((float) Math.toDegrees(this.p[2]));
        if (this.f) {
            boolean z2 = this.ul && ms(fAbs, this.az);
            boolean z3 = this.m && ms(fAbs2, this.lm);
            boolean z4 = this.e && ms(fAbs3, this.k);
            if (z2 || z3 || z4) {
                return ms(z, z2, z3, z4);
            }
            return false;
        }
        boolean zMs = ms(fAbs, f);
        boolean zMs2 = ms(fAbs2, f);
        boolean zMs3 = ms(fAbs3, f);
        if (zMs || zMs2 || zMs3) {
            return ms(z, zMs, zMs2, zMs3);
        }
        return false;
    }

    private void ms(float f, float f2, float f3, float f4) {
        float[] fArr = this.p;
        fArr[0] = fArr[0] + (f * f4);
        fArr[1] = fArr[1] + (f2 * f4);
        fArr[2] = fArr[2] + (f3 * f4);
    }

    private boolean xr(float f, float f2) {
        return Math.abs(f2) < f;
    }

    private void xr(boolean z) {
        float[] fArr = this.p;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
    }

    public void ms(float f) {
        this.x = f;
    }

    public void ms(ah ahVar) {
        this.s = ahVar;
    }

    public void xr(float f) {
        this.ny = f;
    }

    public void ms(JSONObject jSONObject) {
        if (this.i != 2) {
            return;
        }
        this.jw = jSONObject;
        if (jSONObject == null) {
            this.ul = false;
            this.m = false;
            this.e = false;
        } else {
            this.ul = jSONObject.has("x_threshold");
            this.az = ms(this.jw.optDouble("x_threshold", 50.0d));
            this.m = this.jw.has("y_threshold");
            this.lm = ms(this.jw.optDouble("y_threshold", 50.0d));
            this.e = this.jw.has("z_threshold");
            this.k = ms(this.jw.optDouble("z_threshold", 50.0d));
        }
        this.f = this.ul || this.m || this.e;
    }

    public void xr(JSONObject jSONObject) {
        if (this.i != 2) {
            return;
        }
        if (jSONObject == null) {
            this.tz = 0;
        } else {
            this.tz = jSONObject.optInt("double_direct_match", 0);
        }
    }

    public void ah(JSONObject jSONObject) {
        if (this.i != 1) {
            return;
        }
        if (jSONObject == null) {
            this.sa = 0;
            this.tz = 0;
        } else {
            this.sa = jSONObject.optInt("double_direct_conf", 0);
            this.tz = jSONObject.optInt("double_direct_match", 0);
        }
    }

    public void ka(int i) {
        this.ch = i;
    }

    private void c() {
        this.nw = 0L;
        this.b = false;
        this.re = false;
        this.eg = 0;
        this.fm = 0;
        this.xn = 0;
        this.il = 0;
        this.qf = 0;
        this.l = 0;
    }

    private void ab() {
        this.eg = 0;
        this.fm = 0;
        this.xn = 0;
    }

    private void ka(float f) {
        if (System.currentTimeMillis() - this.nw >= 500) {
            this.b = false;
            ch();
        } else if (f >= this.qv) {
            this.b = true;
            ch();
        }
    }

    public boolean ms() {
        return this.b;
    }

    private boolean x() {
        return this.qv > this.x;
    }

    private void ny() {
        this.sl.ms(getType());
        this.xr = System.currentTimeMillis();
    }

    private void ch() {
        this.sl.ms(getType());
        this.xr = System.currentTimeMillis();
        this.nw = 0L;
        this.re = false;
    }

    private float ms(float f, float f2, float f3) {
        return Math.max(Math.max(f2, f), f3);
    }

    public void ah(float f) {
        this.qv = f;
    }

    public void c(int i) {
        nw nwVar = this.hi;
        if (nwVar == null) {
            return;
        }
        if (i == 3 || i == 2 || i == 4 || i == 7) {
            if (this.ao == null && nwVar != null) {
                this.ao = nwVar.ms(4);
            }
            if (this.ao != null) {
                this.y = i;
                return;
            }
        }
        this.y = 0;
    }

    private void ms(boolean z, double d) {
        if (!x() && z) {
            ny();
            return;
        }
        if (z) {
            this.nw = System.currentTimeMillis();
            this.re = true;
            ka((float) d);
        } else {
            if (!this.re || System.currentTimeMillis() - this.nw < 500) {
                return;
            }
            this.b = false;
            ch();
        }
    }

    private void ms(boolean z, SensorEvent sensorEvent) {
        if (z) {
            float[] fArr = sensorEvent.values;
            int iMs = ms(fArr[0], this.eg);
            int iMs2 = ms(fArr[1], this.fm);
            int iMs3 = ms(fArr[2], this.xn);
            if (xr(iMs, iMs2, iMs3, false)) {
                ms(iMs, iMs2, iMs3, true);
                ny();
                return;
            }
            this.eg |= iMs;
            if (iMs <= 0) {
                iMs = this.il;
            }
            this.il = iMs;
            this.fm |= iMs2;
            if (iMs2 <= 0) {
                iMs2 = this.qf;
            }
            this.qf = iMs2;
            this.xn |= iMs3;
            if (iMs3 <= 0) {
                iMs3 = this.l;
            }
            this.l = iMs3;
        }
    }

    private void xr(boolean z, SensorEvent sensorEvent) {
        if (z) {
            float[] fArr = sensorEvent.values;
            int iMs = ms(fArr[0], this.eg);
            int iMs2 = ms(fArr[1], this.fm);
            int iMs3 = ms(fArr[2], this.xn);
            if (xr(iMs, iMs2, iMs3, true)) {
                ms(iMs, iMs2, iMs3, true);
                ny();
            } else if (this.tz == 1) {
                this.eg = iMs;
                this.fm = iMs2;
                this.xn = iMs3;
            } else {
                this.eg = iMs | this.eg;
                this.fm |= iMs2;
                this.xn = iMs3 | this.xn;
            }
        }
    }

    private boolean ms(boolean z, boolean z2, boolean z3, boolean z4) {
        if (!z) {
            xr(false);
            return true;
        }
        int iC = z2 ? c(this.p[0]) : 0;
        int iC2 = z3 ? c(this.p[1]) : 0;
        int iC3 = z4 ? c(this.p[2]) : 0;
        if (this.y != 7) {
            xr(false);
        }
        if (ms(iC, this.eg) || ms(iC2, this.fm) || ms(iC3, this.xn)) {
            ms(iC, iC2, iC3, true);
            return true;
        }
        if (this.tz != 1) {
            ms(iC, iC2, iC3, false);
        } else if (z2 || z3 || z4) {
            this.eg = iC;
            this.fm = iC2;
            this.xn = iC3;
        }
        return false;
    }

    private void ms(int i, int i2, int i3, boolean z) {
        if (z) {
            this.eg = 0;
            this.fm = 0;
            this.xn = 0;
            this.il = 0;
            this.qf = 0;
            this.l = 0;
            return;
        }
        if (i == 0) {
            i = this.eg;
        }
        this.eg = i;
        if (i2 == 0) {
            i2 = this.fm;
        }
        this.fm = i2;
        if (i3 == 0) {
            i3 = this.xn;
        }
        this.xn = i3;
    }

    private int ms(float f, int i) {
        if (f != 0.0f) {
            return c(f);
        }
        if (i == 0) {
            return 0;
        }
        return i == 2 ? 1 : 2;
    }

    private boolean xr(int i, int i2, int i3, boolean z) {
        boolean zMs;
        boolean zMs2;
        boolean zMs3;
        boolean zMs4;
        int i4 = this.sa;
        if (i4 == 1) {
            int i5 = this.xn;
            zMs = z ? ms(i3, i5) : ms(i3, i5, this.l);
        } else if (i4 == 2) {
            int i6 = this.fm;
            zMs = z ? ms(i2, i6) : ms(i2, i6, this.qf);
        } else {
            if (i4 != 4) {
                if (i4 != 7) {
                    if (z) {
                        zMs2 = ms(i, this.eg);
                        zMs3 = ms(i2, this.fm);
                        zMs4 = ms(i3, this.xn);
                    } else {
                        zMs2 = ms(i, this.eg, this.il);
                        zMs3 = ms(i2, this.fm, this.qf);
                        zMs4 = ms(i3, this.xn, this.l);
                    }
                    if (zMs2 || zMs3 || zMs4) {
                        return true;
                    }
                } else if (z) {
                    if (ms(i, this.eg) && ms(i2, this.fm) && ms(i3, this.xn)) {
                        return true;
                    }
                } else if (ms(i, this.eg, this.il) && ms(i2, this.fm, this.qf) && ms(i3, this.xn, this.l)) {
                    return true;
                }
                return false;
            }
            int i7 = this.eg;
            zMs = z ? ms(i, i7) : ms(i, i7, this.il);
        }
        return zMs;
    }

    private void ab(float f) {
        if (!ms(this.y == 7, f) || System.currentTimeMillis() - this.ab <= a.f) {
            return;
        }
        xr(false);
        this.sl.ms(getType());
        this.ab = System.currentTimeMillis();
    }

    private int getType() {
        return this.i == 2 ? 2 : 1;
    }
}
