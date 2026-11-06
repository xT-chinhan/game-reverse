package com.byazt.tk;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 350, 849})
public class ou implements SensorEventListener {
    public static wm lq;
    public JSONObject an;
    public float cd;
    public tj cp;
    public Context cx;
    public Sensor cy;
    public s e;
    public float fi;
    public float h;
    public Sensor hd;
    public int ic;
    public Sensor k;
    public float l;
    public int m;
    public float oj;
    public float q;
    public volatile long qg;
    public float s;
    public Sensor sz;
    public float u;
    public int um;
    public volatile long x;
    public boolean yw;
    public final long n = 2000;
    public boolean w = false;
    public float fs = 13.0f;
    public float rv = 50.0f;
    public int tj = 0;
    public n d = null;
    public qg oa = null;
    public final long a = 500;
    public volatile long py = 0;
    public volatile boolean ou = false;
    public volatile boolean wm = false;
    public final float hu = 1.0E-9f;
    public float[] t = new float[3];
    public long ur = 0;
    public float bb = 0.0f;
    public float ln = 4.0f;
    public float lh = 0.0f;
    public float[] v = new float[3];
    public final float j = 0.0f;
    public boolean ae = false;
    public boolean f = false;
    public boolean df = false;
    public boolean dg = false;
    public int pk = 0;
    public int wo = 0;
    public int sh = 0;
    public int y = 0;
    public int rf = 0;
    public int dh = 0;
    public boolean b = false;
    public int ri = 0;
    public int nf = 0;
    public float pe = 0.0f;

    public interface n {
        void n(int i);
    }

    public interface qg {
        void n(float f, float f2, float f3);
    }

    public interface s {
        void n();
    }

    private float n(double d) {
        if (d <= 0.0d || d > 180.0d) {
            d = 50.0d;
        }
        return (float) d;
    }

    private boolean n(float f, float f2) {
        return f2 > 0.0f && f > f2;
    }

    private boolean n(int i, int i2) {
        return (i | i2) == 3;
    }

    private boolean n(int i, int i2, int i3) {
        return i2 == 3 && (i | i3) == 3;
    }

    private int w(float f) {
        return f < 0.0f ? 1 : 2;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public ou(Context context, int i, boolean z) {
        this.cp = null;
        this.yw = z;
        this.m = i;
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.cx = applicationContext;
        if (applicationContext != null && z) {
            this.cp = q.n(context);
        }
    }

    public void n(boolean z) {
        Context context;
        if (!z) {
            tj tjVar = this.cp;
            if (tjVar != null) {
                tjVar.n(this);
                this.cp = null;
                return;
            }
            return;
        }
        if (this.yw || this.cp != null || (context = this.cx) == null) {
            return;
        }
        this.cp = q.n(context);
    }

    public void n(n nVar) {
        this.d = nVar;
    }

    public void n(qg qgVar) {
        this.oa = qgVar;
    }

    private boolean qg() {
        tj tjVar = this.cp;
        if (tjVar == null) {
            return false;
        }
        try {
            if (this.tj == 4) {
                return s();
            }
            if (this.sz == null) {
                this.sz = tjVar.n(1);
            }
            boolean zN = this.cp.n(this, this.sz, 3);
            w();
            return zN;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean s() {
        int i;
        tj tjVar = this.cp;
        boolean zN = false;
        if (tjVar == null) {
            return false;
        }
        try {
            if (this.um == 0) {
                if (this.k == null) {
                    this.k = tjVar.n(15);
                }
                this.w = false;
                zN = this.cp.n(this, this.k, 1);
            }
            int i2 = this.um;
            if (i2 == 3 || i2 == 2 || i2 == 4 || i2 == 7) {
                if (this.cy == null) {
                    this.cy = this.cp.n(4);
                }
                float f = this.ln;
                if (f != 0.0f && ((i = this.um) == 2 || i == 4)) {
                    this.pe = (float) Math.pow(f, 2.0d);
                    if (this.hd == null) {
                        this.hd = this.cp.n(10);
                    }
                    this.cp.n(this, this.hd, 1);
                }
                zN = this.cp.n(this, this.cy, 1);
            }
            x();
        } catch (Throwable unused) {
        }
        return zN;
    }

    public static void n(wm wmVar) {
        lq = wmVar;
    }

    public boolean n(int i) {
        wm wmVar;
        rv(i);
        if (i > 0 && (wmVar = lq) != null && !wmVar.n(i)) {
            lq.n(i, hashCode(), new Runnable() { // from class: com.byazt.tk.ou.1
                @Override // java.lang.Runnable
                public void run() {
                    ou.this.q();
                }
            });
            return true;
        }
        return q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        if (this.cp == null || this.b) {
            return false;
        }
        int i = this.m;
        if (i == 1) {
            return qg();
        }
        if (i == 2) {
            return s();
        }
        return false;
    }

    public void qg(int i) {
        l();
        this.ic = i;
        wm wmVar = lq;
        if (wmVar != null) {
            wmVar.n(i, hashCode());
        }
        tj();
    }

    private void l() {
        tj tjVar = this.cp;
        if (tjVar == null) {
            return;
        }
        tjVar.n(this);
    }

    public void s(int i) {
        this.b = false;
        n(i);
    }

    public void q(int i) {
        this.b = true;
        qg(i);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        s sVar = this.e;
        if (sVar != null) {
            sVar.n();
        }
        int type = sensorEvent.sensor.getType();
        float[] fArr = sensorEvent.values;
        if (fArr == null || fArr.length < 3) {
            return;
        }
        float fAbs = Math.abs(fArr[0]);
        float fAbs2 = Math.abs(fArr[1]);
        float fAbs3 = Math.abs(fArr[2]);
        if (type == 1) {
            if (this.d == null || System.currentTimeMillis() - this.qg <= 2000) {
                return;
            }
            int i = this.tj;
            if (i == 1) {
                double dSqrt = Math.sqrt(Math.pow(fAbs, 2.0d) + Math.pow(fAbs2, 2.0d) + Math.pow(fAbs3, 2.0d));
                n(dSqrt > ((double) this.fs), dSqrt, sensorEvent);
                return;
            } else if (i == 2) {
                qg(Math.sqrt((Math.pow((double) fAbs, 2.0d) + Math.pow((double) fAbs2, 2.0d)) + Math.pow((double) fAbs3, 2.0d)) > ((double) this.fs), sensorEvent);
                return;
            } else if (i == 3) {
                n(Math.sqrt((Math.pow((double) fAbs, 2.0d) + Math.pow((double) fAbs2, 2.0d)) + Math.pow((double) fAbs3, 2.0d)) > ((double) this.fs), sensorEvent);
                return;
            } else {
                double dN = n(fAbs, fAbs2, fAbs3);
                n(dN > ((double) this.fs), dN, sensorEvent);
                return;
            }
        }
        if (type == 4) {
            int i2 = this.um;
            if (i2 == 3) {
                qg(sensorEvent);
                return;
            } else {
                if (i2 == 2 || i2 == 4 || i2 == 7) {
                    n(sensorEvent);
                    return;
                }
                return;
            }
        }
        if (type == 10) {
            this.lh = (float) (Math.pow(sensorEvent.values[0], 2.0d) + Math.pow(sensorEvent.values[1], 2.0d) + Math.pow(sensorEvent.values[2], 2.0d));
            return;
        }
        if (type != 15) {
            return;
        }
        float fAbs4 = Math.abs(fArr[0]);
        float fAbs5 = Math.abs(fArr[1]);
        float fAbs6 = Math.abs(fArr[2]);
        qg qgVar = this.oa;
        if (qgVar != null) {
            qgVar.n(fArr[0], fArr[1], fArr[2]);
        }
        if (fAbs4 == 0.0f && fAbs5 == 0.0f && fAbs6 == 0.0f) {
            return;
        }
        if (!this.w) {
            this.w = true;
            this.s = fAbs4;
            this.q = fAbs5;
            this.l = fAbs6;
            return;
        }
        float fAbs7 = Math.abs(fAbs4 - this.s) * 180.0f;
        float fAbs8 = Math.abs(fAbs5 - this.q) * 180.0f;
        float fAbs9 = Math.abs(fAbs6 - this.l) * 180.0f;
        float[] fArr2 = {fAbs7, fAbs8, fAbs9};
        if (this.ae) {
            boolean z = this.f && fAbs7 > this.fi;
            boolean z2 = this.df && fAbs8 > this.oj;
            boolean z3 = this.dg && fAbs9 > this.u;
            if ((z || z2 || z3) && this.d != null && System.currentTimeMillis() - this.x > 2000) {
                n(2, fArr2);
                fs(11);
                this.d.n(getType());
                this.x = System.currentTimeMillis();
                this.w = false;
                return;
            }
            return;
        }
        float f = this.rv;
        if ((fAbs7 > f || fAbs8 > f || fAbs9 > f) && this.d != null && System.currentTimeMillis() - this.x > 2000) {
            n(2, fArr2);
            fs(11);
            this.d.n(getType());
            this.x = System.currentTimeMillis();
            this.w = false;
        }
    }

    private void n(SensorEvent sensorEvent) {
        if (this.ur != 0) {
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            float f4 = (sensorEvent.timestamp - this.ur) * 1.0E-9f;
            float f5 = this.bb;
            if (f5 != 0.0f) {
                if (!qg(f5, f) || !qg(this.bb, f2) || !qg(this.bb, f3)) {
                    qg(true);
                } else {
                    n(f, f2, f3, f4);
                }
            } else {
                float f6 = this.pe;
                if (f6 != 0.0f && this.lh >= f6) {
                    qg(true);
                } else {
                    n(f, f2, f3, f4);
                }
            }
            if (this.um == 7) {
                x(this.rv);
            } else {
                q(this.rv);
            }
            qg qgVar = this.oa;
            if (qgVar != null) {
                float[] fArr = this.v;
                qgVar.n(fArr[0], fArr[1], fArr[2]);
            }
        }
        this.ur = sensorEvent.timestamp;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00c0  */
    private void qg(SensorEvent sensorEvent) {
        boolean z;
        if (this.h != 0.0f) {
            float f = (sensorEvent.timestamp - this.h) * 1.0E-9f;
            float[] fArr = this.t;
            fArr[0] = fArr[0] + (sensorEvent.values[0] * f);
            float[] fArr2 = this.t;
            fArr2[1] = fArr2[1] + (sensorEvent.values[1] * f);
            float[] fArr3 = this.t;
            fArr3[2] = fArr3[2] + (sensorEvent.values[2] * f);
            float fAbs = Math.abs((float) Math.toDegrees(this.t[0]));
            float fAbs2 = Math.abs((float) Math.toDegrees(this.t[1]));
            float fAbs3 = Math.abs((float) Math.toDegrees(this.t[2]));
            if (this.ae) {
                boolean z2 = this.f && n(fAbs, this.fi);
                boolean z3 = this.df && n(fAbs2, this.oj);
                boolean z4 = this.dg && n(fAbs3, this.u);
                if (z2 || z3 || z4) {
                    n(2, this.t);
                    float[] fArr4 = this.t;
                    fArr4[0] = 0.0f;
                    fArr4[1] = 0.0f;
                    fArr4[2] = 0.0f;
                    z = true;
                } else {
                    z = false;
                }
            } else if (n(fAbs, this.rv) || n(fAbs2, this.rv) || n(fAbs3, this.rv)) {
                n(2, this.t);
                float[] fArr5 = this.t;
                fArr5[0] = 0.0f;
                fArr5[1] = 0.0f;
                fArr5[2] = 0.0f;
                z = true;
            } else {
                z = false;
            }
            if (z && System.currentTimeMillis() - this.x > 2000) {
                if (this.d != null) {
                    fs(11);
                    this.d.n(getType());
                }
                this.x = System.currentTimeMillis();
            }
            qg qgVar = this.oa;
            if (qgVar != null) {
                float[] fArr6 = this.t;
                qgVar.n(fArr6[0], fArr6[1], fArr6[2]);
            }
        }
        this.h = sensorEvent.timestamp;
    }

    private void q(float f) {
        boolean z = this.um == 4;
        if (!n(z, f) || System.currentTimeMillis() - this.x <= 2000) {
            return;
        }
        if (this.d != null) {
            fs(z ? 12 : 11);
            this.d.n(getType());
        }
        this.x = System.currentTimeMillis();
    }

    private boolean n(boolean z, float f) {
        float fAbs = Math.abs((float) Math.toDegrees(this.v[0]));
        float fAbs2 = Math.abs((float) Math.toDegrees(this.v[1]));
        float fAbs3 = Math.abs((float) Math.toDegrees(this.v[2]));
        if (this.ae) {
            boolean z2 = this.f && n(fAbs, this.fi);
            boolean z3 = this.df && n(fAbs2, this.oj);
            boolean z4 = this.dg && n(fAbs3, this.u);
            if (!z2 && !z3 && !z4) {
                return false;
            }
            n(2, this.v);
            return n(z, z2, z3, z4);
        }
        boolean zN = n(fAbs, f);
        boolean zN2 = n(fAbs2, f);
        boolean zN3 = n(fAbs3, f);
        if (!zN && !zN2 && !zN3) {
            return false;
        }
        n(2, this.v);
        return n(z, zN, zN2, zN3);
    }

    private void n(float f, float f2, float f3, float f4) {
        float[] fArr = this.v;
        fArr[0] = fArr[0] + (f * f4);
        fArr[1] = fArr[1] + (f2 * f4);
        fArr[2] = fArr[2] + (f3 * f4);
    }

    private boolean qg(float f, float f2) {
        return Math.abs(f2) < f;
    }

    private void qg(boolean z) {
        float[] fArr = this.v;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
    }

    public void n(float f) {
        this.fs = f;
    }

    public void n(s sVar) {
        this.e = sVar;
    }

    public void qg(float f) {
        this.rv = f;
    }

    public void n(JSONObject jSONObject) {
        if (this.m != 2) {
            return;
        }
        this.an = jSONObject;
        if (jSONObject == null) {
            this.f = false;
            this.df = false;
            this.dg = false;
        } else {
            this.f = jSONObject.has("x_threshold");
            this.fi = n(this.an.optDouble("x_threshold", 50.0d));
            this.df = this.an.has("y_threshold");
            this.oj = n(this.an.optDouble("y_threshold", 50.0d));
            this.dg = this.an.has("z_threshold");
            this.u = n(this.an.optDouble("z_threshold", 50.0d));
        }
        this.ae = this.f || this.df || this.dg;
    }

    public void qg(JSONObject jSONObject) {
        if (this.m != 2) {
            return;
        }
        if (jSONObject == null) {
            this.nf = 0;
        } else {
            this.nf = jSONObject.optInt("double_direct_match", 0);
        }
    }

    public void s(JSONObject jSONObject) {
        if (this.m != 1) {
            return;
        }
        if (jSONObject == null) {
            this.ri = 0;
            this.nf = 0;
        } else {
            this.ri = jSONObject.optInt("double_direct_conf", 0);
            this.nf = jSONObject.optInt("double_direct_match", 0);
        }
    }

    public void l(int i) {
        this.tj = i;
    }

    private void w() {
        this.py = 0L;
        this.ou = false;
        this.wm = false;
        this.pk = 0;
        this.wo = 0;
        this.sh = 0;
        this.y = 0;
        this.rf = 0;
        this.dh = 0;
    }

    private void x() {
        this.pk = 0;
        this.wo = 0;
        this.sh = 0;
    }

    private void l(float f) {
        if (System.currentTimeMillis() - this.py >= 500) {
            this.ou = false;
            rv();
        } else if (f >= this.cd) {
            this.ou = true;
            rv();
        }
    }

    public boolean n() {
        return this.ou;
    }

    private boolean fs() {
        return this.cd > this.fs;
    }

    private void x(int i) {
        if (this.d != null) {
            fs(i);
            this.d.n(getType());
        }
        this.qg = System.currentTimeMillis();
    }

    private void rv() {
        x(1);
        this.py = 0L;
        this.wm = false;
    }

    private float n(float f, float f2, float f3) {
        return Math.max(Math.max(f2, f), f3);
    }

    public void s(float f) {
        this.cd = f;
    }

    public void w(int i) {
        tj tjVar = this.cp;
        if (tjVar == null) {
            return;
        }
        if (i == 3 || i == 2 || i == 4 || i == 7) {
            if (this.cy == null && tjVar != null) {
                this.cy = tjVar.n(4);
            }
            if (this.cy != null) {
                this.um = i;
                return;
            }
        }
        this.um = 0;
    }

    private void n(boolean z, double d, SensorEvent sensorEvent) {
        if (!fs() && z) {
            x(1);
        } else if (z) {
            this.py = System.currentTimeMillis();
            this.wm = true;
            l((float) d);
        } else if (this.wm && System.currentTimeMillis() - this.py >= 500) {
            this.ou = false;
            rv();
        }
        if (z) {
            n(1, sensorEvent.values);
        }
    }

    private void n(boolean z, SensorEvent sensorEvent) {
        if (z) {
            float[] fArr = sensorEvent.values;
            int iN = n(fArr[0], this.pk);
            int iN2 = n(fArr[1], this.wo);
            int iN3 = n(fArr[2], this.sh);
            if (qg(iN, iN2, iN3, false)) {
                n(iN, iN2, iN3, true);
                x(3);
            } else {
                this.pk |= iN;
                if (iN <= 0) {
                    iN = this.y;
                }
                this.y = iN;
                this.wo |= iN2;
                if (iN2 <= 0) {
                    iN2 = this.rf;
                }
                this.rf = iN2;
                this.sh |= iN3;
                if (iN3 <= 0) {
                    iN3 = this.dh;
                }
                this.dh = iN3;
            }
            n(1, sensorEvent.values);
        }
    }

    private void qg(boolean z, SensorEvent sensorEvent) {
        if (z) {
            float[] fArr = sensorEvent.values;
            int iN = n(fArr[0], this.pk);
            int iN2 = n(fArr[1], this.wo);
            int iN3 = n(fArr[2], this.sh);
            if (qg(iN, iN2, iN3, true)) {
                n(iN, iN2, iN3, true);
                x(2);
            } else if (this.nf == 1) {
                this.pk = iN;
                this.wo = iN2;
                this.sh = iN3;
            } else {
                this.pk = iN | this.pk;
                this.wo |= iN2;
                this.sh = iN3 | this.sh;
            }
            n(1, sensorEvent.values);
        }
    }

    private boolean n(boolean z, boolean z2, boolean z3, boolean z4) {
        if (!z) {
            qg(false);
            return true;
        }
        int iW = z2 ? w(this.v[0]) : 0;
        int iW2 = z3 ? w(this.v[1]) : 0;
        int iW3 = z4 ? w(this.v[2]) : 0;
        if (this.um != 7) {
            qg(false);
        }
        if (n(iW, this.pk) || n(iW2, this.wo) || n(iW3, this.sh)) {
            n(iW, iW2, iW3, true);
            return true;
        }
        if (this.nf != 1) {
            n(iW, iW2, iW3, false);
        } else if (z2 || z3 || z4) {
            this.pk = iW;
            this.wo = iW2;
            this.sh = iW3;
        }
        return false;
    }

    private void n(int i, int i2, int i3, boolean z) {
        if (z) {
            this.pk = 0;
            this.wo = 0;
            this.sh = 0;
            this.y = 0;
            this.rf = 0;
            this.dh = 0;
            return;
        }
        if (i == 0) {
            i = this.pk;
        }
        this.pk = i;
        if (i2 == 0) {
            i2 = this.wo;
        }
        this.wo = i2;
        if (i3 == 0) {
            i3 = this.sh;
        }
        this.sh = i3;
    }

    private int n(float f, int i) {
        if (f != 0.0f) {
            return w(f);
        }
        if (i == 0) {
            return 0;
        }
        return i == 2 ? 1 : 2;
    }

    private boolean qg(int i, int i2, int i3, boolean z) {
        boolean zN;
        boolean zN2;
        boolean zN3;
        boolean zN4;
        int i4 = this.ri;
        if (i4 == 1) {
            int i5 = this.sh;
            zN = z ? n(i3, i5) : n(i3, i5, this.dh);
        } else if (i4 == 2) {
            int i6 = this.wo;
            zN = z ? n(i2, i6) : n(i2, i6, this.rf);
        } else {
            if (i4 != 4) {
                if (i4 != 7) {
                    if (z) {
                        zN2 = n(i, this.pk);
                        zN3 = n(i2, this.wo);
                        zN4 = n(i3, this.sh);
                    } else {
                        zN2 = n(i, this.pk, this.y);
                        zN3 = n(i2, this.wo, this.rf);
                        zN4 = n(i3, this.sh, this.dh);
                    }
                    if (zN2 || zN3 || zN4) {
                        return true;
                    }
                } else if (z) {
                    if (n(i, this.pk) && n(i2, this.wo) && n(i3, this.sh)) {
                        return true;
                    }
                } else if (n(i, this.pk, this.y) && n(i2, this.wo, this.rf) && n(i3, this.sh, this.dh)) {
                    return true;
                }
                return false;
            }
            int i7 = this.pk;
            zN = z ? n(i, i7) : n(i, i7, this.y);
        }
        return zN;
    }

    private void x(float f) {
        if (!n(this.um == 7, f) || System.currentTimeMillis() - this.x <= 2000) {
            return;
        }
        qg(false);
        if (this.d != null) {
            fs(13);
            this.d.n(getType());
        }
        this.x = System.currentTimeMillis();
    }

    private int getType() {
        return this.m == 2 ? 2 : 1;
    }

    private void fs(int i) {
        py.n().n(this.ic, i);
    }

    private void rv(int i) {
        try {
            this.ic = i;
            py.n().n(this.ic, "calculation_method", Integer.valueOf(this.tj));
            py.n().n(this.ic, "calculation_method_twist", Integer.valueOf(this.um));
            py.n().n(this.ic, "shake_threshold", Float.valueOf(this.fs));
            py.n().n(this.ic, "twist_threshold", Float.valueOf(this.rv));
            py.n().n(this.ic, "twist_single_threshold", Boolean.valueOf(this.ae));
            py.n().n(this.ic, "twist_x_threshold", Float.valueOf(this.fi));
            py.n().n(this.ic, "twist_y_threshold", Float.valueOf(this.oj));
            py.n().n(this.ic, "twist_z_threshold", Float.valueOf(this.u));
        } catch (Throwable unused) {
        }
    }

    private void tj() {
        py.n().s(this.ic);
    }

    private void n(int i, float[] fArr) {
        py.n().n(this.ic, i, fArr);
    }
}
