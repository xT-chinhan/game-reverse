package com.byazt.ca;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Build;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, 36})
public class ny implements SensorEventListener {
    public static fo vj;
    public float b;
    public float c;
    public JSONObject e;
    public float er;
    public volatile long fw;
    public Sensor g;
    public float hn;
    public Sensor ho;
    public volatile long hw;
    public hn l;
    public float lb;
    public boolean lv;
    public int mw;
    public Sensor nt;
    public Context od;
    public float of;
    public int qa;
    public float qi;
    public int rc;
    public vk w;
    public float x;
    public Sensor yb;
    public final long pr = 2000;
    public boolean uc = false;
    public float zo = 13.0f;
    public float aj = 50.0f;
    public int vk = 0;
    public pr k = null;
    public hw m = null;
    public final long a = 500;
    public volatile long cz = 0;
    public volatile boolean ny = false;
    public volatile boolean fo = false;
    public final float z = 1.0E-9f;
    public float[] iu = new float[3];
    public long ve = 0;
    public float gz = 0.0f;
    public float nl = 4.0f;
    public float y = 0.0f;
    public float[] ww = new float[3];
    public final float n = 0.0f;
    public boolean s = false;
    public boolean ls = false;
    public boolean v = false;
    public boolean qn = false;
    public int ii = 0;
    public int i = 0;
    public int r = 0;
    public int hs = 0;
    public int nw = 0;
    public int ie = 0;
    public boolean o = false;
    public int f = 0;
    public int bm = 0;
    public float jn = 0.0f;

    public interface hn {
        void pr();
    }

    public interface hw {
        void pr(float f, float f2, float f3);
    }

    public interface pr {
        void pr(int i);
    }

    public ny(Context context, int i, boolean z) {
        this.w = null;
        this.lv = z;
        this.rc = i;
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.od = applicationContext;
        if (applicationContext != null && z) {
            this.w = x.pr(context);
        }
    }

    public void pr(boolean z) {
        Context context;
        if (!z) {
            vk vkVar = this.w;
            if (vkVar != null) {
                vkVar.pr(this);
                this.w = null;
                return;
            }
            return;
        }
        if (!this.lv && this.w == null && (context = this.od) != null) {
            this.w = x.pr(context);
        }
    }

    public void pr(pr prVar) {
        this.k = prVar;
    }

    public void pr(hw hwVar) {
        this.m = hwVar;
    }

    private boolean hw() {
        vk vkVar = this.w;
        if (vkVar == null) {
            return false;
        }
        try {
            if (this.vk == 4) {
                return hn();
            }
            if (this.g == null) {
                this.g = vkVar.pr(1);
            }
            boolean zPr = this.w.pr(this, this.g, 3);
            uc();
            return zPr;
        } catch (Throwable th) {
            return false;
        }
    }

    private boolean hn() {
        int i;
        vk vkVar = this.w;
        boolean zPr = false;
        if (vkVar == null) {
            return false;
        }
        try {
            if (this.qa == 0) {
                if (this.ho == null) {
                    this.ho = vkVar.pr(15);
                }
                this.uc = false;
                if (Build.VERSION.SDK_INT > 18) {
                    zPr = this.w.pr(this, this.ho, 1);
                }
            }
            int i2 = this.qa;
            if (i2 == 3 || i2 == 2 || i2 == 4 || i2 == 7) {
                if (this.nt == null) {
                    this.nt = this.w.pr(4);
                }
                float f = this.nl;
                if (f != 0.0f && ((i = this.qa) == 2 || i == 4)) {
                    this.jn = (float) Math.pow(f, 2.0d);
                    if (this.yb == null) {
                        this.yb = this.w.pr(10);
                    }
                    this.w.pr(this, this.yb, 1);
                }
                zPr = this.w.pr(this, this.nt, 1);
            }
            fw();
        } catch (Throwable th) {
        }
        return zPr;
    }

    public static void pr(fo foVar) {
        vj = foVar;
    }

    public boolean pr(int i) {
        fo foVar;
        aj(i);
        if (i > 0 && (foVar = vj) != null && !foVar.pr(i)) {
            vj.pr(i, hashCode(), new Runnable() { // from class: com.byazt.ca.ny.1
                @Override // java.lang.Runnable
                public void run() {
                    ny.this.x();
                }
            });
            return true;
        }
        return x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x() {
        if (this.w == null || this.o) {
            return false;
        }
        int i = this.rc;
        if (i == 1) {
            return hw();
        }
        if (i == 2) {
            return hn();
        }
        return false;
    }

    public void hw(int i) {
        c();
        this.mw = i;
        fo foVar = vj;
        if (foVar != null) {
            foVar.pr(i, hashCode());
        }
        vk();
    }

    private void c() {
        vk vkVar = this.w;
        if (vkVar == null) {
            return;
        }
        vkVar.pr(this);
    }

    public void hn(int i) {
        this.o = false;
        pr(i);
    }

    public void x(int i) {
        this.o = true;
        hw(i);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        hn hnVar = this.l;
        if (hnVar != null) {
            hnVar.pr();
        }
        int type = sensorEvent.sensor.getType();
        float[] fArr = sensorEvent.values;
        if (fArr == null || fArr.length < 3) {
            return;
        }
        float fAbs = Math.abs(fArr[0]);
        boolean z4 = true;
        float fAbs2 = Math.abs(fArr[1]);
        float fAbs3 = Math.abs(fArr[2]);
        switch (type) {
            case 1:
                if (this.k != null && System.currentTimeMillis() - this.hw > 2000) {
                    switch (this.vk) {
                        case 1:
                            double dSqrt = Math.sqrt(Math.pow(fAbs, 2.0d) + Math.pow(fAbs2, 2.0d) + Math.pow(fAbs3, 2.0d));
                            pr(dSqrt > ((double) this.zo), dSqrt, sensorEvent);
                            break;
                        case 2:
                            hw(Math.sqrt((Math.pow((double) fAbs, 2.0d) + Math.pow((double) fAbs2, 2.0d)) + Math.pow((double) fAbs3, 2.0d)) > ((double) this.zo), sensorEvent);
                            break;
                        case 3:
                            pr(Math.sqrt((Math.pow((double) fAbs, 2.0d) + Math.pow((double) fAbs2, 2.0d)) + Math.pow((double) fAbs3, 2.0d)) > ((double) this.zo), sensorEvent);
                            break;
                        default:
                            double dPr = pr(fAbs, fAbs2, fAbs3);
                            if (dPr > this.zo) {
                                z = true;
                            } else {
                                z = false;
                            }
                            pr(z, dPr, sensorEvent);
                            break;
                    }
                }
                break;
            case 4:
                int i = this.qa;
                if (i == 3) {
                    hw(sensorEvent);
                } else if (i == 2 || i == 4 || i == 7) {
                    pr(sensorEvent);
                }
                break;
            case 10:
                this.y = (float) (Math.pow(sensorEvent.values[0], 2.0d) + Math.pow(sensorEvent.values[1], 2.0d) + Math.pow(sensorEvent.values[2], 2.0d));
                break;
            case 15:
                float fAbs4 = Math.abs(fArr[0]);
                float fAbs5 = Math.abs(fArr[1]);
                float fAbs6 = Math.abs(fArr[2]);
                hw hwVar = this.m;
                if (hwVar != null) {
                    hwVar.pr(fArr[0], fArr[1], fArr[2]);
                }
                if (fAbs4 != 0.0f || fAbs5 != 0.0f || fAbs6 != 0.0f) {
                    if (!this.uc) {
                        this.uc = true;
                        this.hn = fAbs4;
                        this.x = fAbs5;
                        this.c = fAbs6;
                    } else {
                        float fAbs7 = Math.abs(fAbs4 - this.hn) * 180.0f;
                        float fAbs8 = Math.abs(fAbs5 - this.x) * 180.0f;
                        float fAbs9 = Math.abs(fAbs6 - this.c) * 180.0f;
                        float[] fArr2 = {fAbs7, fAbs8, fAbs9};
                        if (this.s) {
                            if (!this.ls || fAbs7 <= this.er) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            if (!this.v || fAbs8 <= this.qi) {
                                z3 = false;
                            } else {
                                z3 = true;
                            }
                            if (!this.qn || fAbs9 <= this.of) {
                                z4 = false;
                            }
                            if ((z2 || z3 || z4) && this.k != null && System.currentTimeMillis() - this.fw > 2000) {
                                pr(2, fArr2);
                                zo(11);
                                this.k.pr(getType());
                                this.fw = System.currentTimeMillis();
                                this.uc = false;
                            }
                        } else {
                            float f = this.aj;
                            if ((fAbs7 > f || fAbs8 > f || fAbs9 > f) && this.k != null && System.currentTimeMillis() - this.fw > 2000) {
                                pr(2, fArr2);
                                zo(11);
                                this.k.pr(getType());
                                this.fw = System.currentTimeMillis();
                                this.uc = false;
                            }
                        }
                    }
                }
                break;
        }
    }

    private void pr(SensorEvent sensorEvent) {
        if (this.ve != 0) {
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            float f4 = (sensorEvent.timestamp - this.ve) * 1.0E-9f;
            float f5 = this.gz;
            if (f5 != 0.0f) {
                if (!hw(f5, f) || !hw(this.gz, f2) || !hw(this.gz, f3)) {
                    hw(true);
                } else {
                    pr(f, f2, f3, f4);
                }
            } else {
                float f6 = this.jn;
                if (f6 != 0.0f && this.y >= f6) {
                    hw(true);
                } else {
                    pr(f, f2, f3, f4);
                }
            }
            if (this.qa == 7) {
                fw(this.aj);
            } else {
                x(this.aj);
            }
            hw hwVar = this.m;
            if (hwVar != null) {
                float[] fArr = this.ww;
                hwVar.pr(fArr[0], fArr[1], fArr[2]);
            }
        }
        this.ve = sensorEvent.timestamp;
    }

    private void hw(SensorEvent sensorEvent) {
        boolean z;
        if (this.b != 0.0f) {
            float f = (sensorEvent.timestamp - this.b) * 1.0E-9f;
            float[] fArr = this.iu;
            fArr[0] = fArr[0] + (sensorEvent.values[0] * f);
            float[] fArr2 = this.iu;
            fArr2[1] = fArr2[1] + (sensorEvent.values[1] * f);
            float[] fArr3 = this.iu;
            fArr3[2] = fArr3[2] + (sensorEvent.values[2] * f);
            float fAbs = Math.abs((float) Math.toDegrees(this.iu[0]));
            float fAbs2 = Math.abs((float) Math.toDegrees(this.iu[1]));
            float fAbs3 = Math.abs((float) Math.toDegrees(this.iu[2]));
            if (this.s) {
                boolean z2 = this.ls && pr(fAbs, this.er);
                boolean z3 = this.v && pr(fAbs2, this.qi);
                boolean z4 = this.qn && pr(fAbs3, this.of);
                if (z2 || z3 || z4) {
                    pr(2, this.iu);
                    float[] fArr4 = this.iu;
                    fArr4[0] = 0.0f;
                    fArr4[1] = 0.0f;
                    fArr4[2] = 0.0f;
                    z = true;
                } else {
                    z = false;
                }
            } else if (pr(fAbs, this.aj) || pr(fAbs2, this.aj) || pr(fAbs3, this.aj)) {
                pr(2, this.iu);
                float[] fArr5 = this.iu;
                fArr5[0] = 0.0f;
                fArr5[1] = 0.0f;
                fArr5[2] = 0.0f;
                z = true;
            } else {
                z = false;
            }
            if (z && System.currentTimeMillis() - this.fw > 2000) {
                if (this.k != null) {
                    zo(11);
                    this.k.pr(getType());
                }
                this.fw = System.currentTimeMillis();
            }
            hw hwVar = this.m;
            if (hwVar != null) {
                float[] fArr6 = this.iu;
                hwVar.pr(fArr6[0], fArr6[1], fArr6[2]);
            }
        }
        this.b = sensorEvent.timestamp;
    }

    private void x(float f) {
        boolean z = this.qa == 4;
        if (pr(z, f) && System.currentTimeMillis() - this.fw > 2000) {
            if (this.k != null) {
                zo(z ? 12 : 11);
                this.k.pr(getType());
            }
            this.fw = System.currentTimeMillis();
        }
    }

    private boolean pr(boolean z, float f) {
        float fAbs = Math.abs((float) Math.toDegrees(this.ww[0]));
        float fAbs2 = Math.abs((float) Math.toDegrees(this.ww[1]));
        float fAbs3 = Math.abs((float) Math.toDegrees(this.ww[2]));
        if (this.s) {
            boolean z2 = this.ls && pr(fAbs, this.er);
            boolean z3 = this.v && pr(fAbs2, this.qi);
            boolean z4 = this.qn && pr(fAbs3, this.of);
            if (!z2 && !z3 && !z4) {
                return false;
            }
            pr(2, this.ww);
            return pr(z, z2, z3, z4);
        }
        boolean zPr = pr(fAbs, f);
        boolean zPr2 = pr(fAbs2, f);
        boolean zPr3 = pr(fAbs3, f);
        if (!zPr && !zPr2 && !zPr3) {
            return false;
        }
        pr(2, this.ww);
        return pr(z, zPr, zPr2, zPr3);
    }

    private boolean pr(float f, float f2) {
        return f2 > 0.0f && f > f2;
    }

    private void pr(float f, float f2, float f3, float f4) {
        float[] fArr = this.ww;
        fArr[0] = fArr[0] + (f * f4);
        fArr[1] = fArr[1] + (f2 * f4);
        fArr[2] = fArr[2] + (f3 * f4);
    }

    private boolean hw(float f, float f2) {
        return Math.abs(f2) < f;
    }

    private void hw(boolean z) {
        float[] fArr = this.ww;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
    }

    public void pr(float f) {
        this.zo = f;
    }

    public void pr(hn hnVar) {
        this.l = hnVar;
    }

    public void hw(float f) {
        this.aj = f;
    }

    public void pr(JSONObject jSONObject) {
        if (this.rc != 2) {
            return;
        }
        this.e = jSONObject;
        if (jSONObject == null) {
            this.ls = false;
            this.v = false;
            this.qn = false;
        } else {
            this.ls = jSONObject.has("x_threshold");
            this.er = pr(this.e.optDouble("x_threshold", 50.0d));
            this.v = this.e.has("y_threshold");
            this.qi = pr(this.e.optDouble("y_threshold", 50.0d));
            this.qn = this.e.has("z_threshold");
            this.of = pr(this.e.optDouble("z_threshold", 50.0d));
        }
        this.s = this.ls || this.v || this.qn;
    }

    public void hw(JSONObject jSONObject) {
        if (this.rc != 2) {
            return;
        }
        if (jSONObject != null) {
            this.bm = jSONObject.optInt("double_direct_match", 0);
        } else {
            this.bm = 0;
        }
    }

    public void hn(JSONObject jSONObject) {
        if (this.rc != 1) {
            return;
        }
        if (jSONObject != null) {
            this.f = jSONObject.optInt("double_direct_conf", 0);
            this.bm = jSONObject.optInt("double_direct_match", 0);
        } else {
            this.f = 0;
            this.bm = 0;
        }
    }

    private float pr(double d) {
        if (d <= 0.0d || d > 180.0d) {
            d = 50.0d;
        }
        return (float) d;
    }

    public void c(int i) {
        this.vk = i;
    }

    private void uc() {
        this.cz = 0L;
        this.ny = false;
        this.fo = false;
        this.ii = 0;
        this.i = 0;
        this.r = 0;
        this.hs = 0;
        this.nw = 0;
        this.ie = 0;
    }

    private void fw() {
        this.ii = 0;
        this.i = 0;
        this.r = 0;
    }

    private void c(float f) {
        if (System.currentTimeMillis() - this.cz >= 500) {
            this.ny = false;
            aj();
        } else if (f >= this.lb) {
            this.ny = true;
            aj();
        }
    }

    public boolean pr() {
        return this.ny;
    }

    private boolean zo() {
        return this.lb > this.zo;
    }

    private void fw(int i) {
        if (this.k != null) {
            zo(i);
            this.k.pr(getType());
        }
        this.hw = System.currentTimeMillis();
    }

    private void aj() {
        fw(1);
        this.cz = 0L;
        this.fo = false;
    }

    private float pr(float f, float f2, float f3) {
        return Math.max(Math.max(f2, f), f3);
    }

    public void hn(float f) {
        this.lb = f;
    }

    public void uc(int i) {
        vk vkVar = this.w;
        if (vkVar == null) {
            return;
        }
        if (i == 3 || i == 2 || i == 4 || i == 7) {
            if (this.nt == null && vkVar != null) {
                this.nt = vkVar.pr(4);
            }
            if (this.nt != null) {
                this.qa = i;
                return;
            }
        }
        this.qa = 0;
    }

    private void pr(boolean z, double d, SensorEvent sensorEvent) {
        if (!zo() && z) {
            fw(1);
        } else if (z) {
            this.cz = System.currentTimeMillis();
            this.fo = true;
            c((float) d);
        } else if (this.fo && System.currentTimeMillis() - this.cz >= 500) {
            this.ny = false;
            aj();
        }
        if (z) {
            pr(1, sensorEvent.values);
        }
    }

    private void pr(boolean z, SensorEvent sensorEvent) {
        if (!z) {
            return;
        }
        float[] fArr = sensorEvent.values;
        int iPr = pr(fArr[0], this.ii);
        int iPr2 = pr(fArr[1], this.i);
        int iPr3 = pr(fArr[2], this.r);
        if (hw(iPr, iPr2, iPr3, false)) {
            pr(iPr, iPr2, iPr3, true);
            fw(3);
        } else {
            this.ii |= iPr;
            if (iPr <= 0) {
                iPr = this.hs;
            }
            this.hs = iPr;
            this.i |= iPr2;
            if (iPr2 <= 0) {
                iPr2 = this.nw;
            }
            this.nw = iPr2;
            this.r |= iPr3;
            if (iPr3 <= 0) {
                iPr3 = this.ie;
            }
            this.ie = iPr3;
        }
        pr(1, sensorEvent.values);
    }

    private void hw(boolean z, SensorEvent sensorEvent) {
        if (!z) {
            return;
        }
        float[] fArr = sensorEvent.values;
        int iPr = pr(fArr[0], this.ii);
        int iPr2 = pr(fArr[1], this.i);
        int iPr3 = pr(fArr[2], this.r);
        if (!hw(iPr, iPr2, iPr3, true)) {
            if (this.bm == 1) {
                this.ii = iPr;
                this.i = iPr2;
                this.r = iPr3;
            } else {
                this.ii = iPr | this.ii;
                this.i |= iPr2;
                this.r = iPr3 | this.r;
            }
        } else {
            pr(iPr, iPr2, iPr3, true);
            fw(2);
        }
        pr(1, sensorEvent.values);
    }

    private boolean pr(boolean z, boolean z2, boolean z3, boolean z4) {
        int iUc;
        int iUc2;
        int iUc3;
        if (!z) {
            hw(false);
            return true;
        }
        if (!z2) {
            iUc = 0;
        } else {
            iUc = uc(this.ww[0]);
        }
        if (z3) {
            iUc2 = uc(this.ww[1]);
        } else {
            iUc2 = 0;
        }
        if (!z4) {
            iUc3 = 0;
        } else {
            iUc3 = uc(this.ww[2]);
        }
        if (this.qa != 7) {
            hw(false);
        }
        if (!pr(iUc, this.ii) && !pr(iUc2, this.i) && !pr(iUc3, this.r)) {
            if (this.bm == 1) {
                if (z2 || z3 || z4) {
                    this.ii = iUc;
                    this.i = iUc2;
                    this.r = iUc3;
                }
            } else {
                pr(iUc, iUc2, iUc3, false);
            }
            return false;
        }
        pr(iUc, iUc2, iUc3, true);
        return true;
    }

    private void pr(int i, int i2, int i3, boolean z) {
        if (z) {
            this.ii = 0;
            this.i = 0;
            this.r = 0;
            this.hs = 0;
            this.nw = 0;
            this.ie = 0;
            return;
        }
        if (i == 0) {
            i = this.ii;
        }
        this.ii = i;
        if (i2 == 0) {
            i2 = this.i;
        }
        this.i = i2;
        if (i3 == 0) {
            i3 = this.r;
        }
        this.r = i3;
    }

    private int pr(float f, int i) {
        if (f != 0.0f) {
            return uc(f);
        }
        if (i == 0) {
            return 0;
        }
        if (i != 2) {
            return 2;
        }
        return 1;
    }

    private int uc(float f) {
        return f < 0.0f ? 1 : 2;
    }

    private boolean pr(int i, int i2) {
        return (i | i2) == 3;
    }

    private boolean pr(int i, int i2, int i3) {
        return i2 == 3 && (i | i3) == 3;
    }

    private boolean hw(int i, int i2, int i3, boolean z) {
        boolean zPr;
        boolean zPr2;
        boolean zPr3;
        switch (this.f) {
            case 1:
                int i4 = this.r;
                return z ? pr(i3, i4) : pr(i3, i4, this.ie);
            case 2:
                int i5 = this.i;
                return z ? pr(i2, i5) : pr(i2, i5, this.nw);
            case 3:
            case 5:
            case 6:
            default:
                if (z) {
                    zPr = pr(i, this.ii);
                    zPr2 = pr(i2, this.i);
                    zPr3 = pr(i3, this.r);
                } else {
                    zPr = pr(i, this.ii, this.hs);
                    zPr2 = pr(i2, this.i, this.nw);
                    zPr3 = pr(i3, this.r, this.ie);
                }
                return zPr || zPr2 || zPr3;
            case 4:
                int i6 = this.ii;
                return z ? pr(i, i6) : pr(i, i6, this.hs);
            case 7:
                if (z) {
                    return pr(i, this.ii) && pr(i2, this.i) && pr(i3, this.r);
                }
                return pr(i, this.ii, this.hs) && pr(i2, this.i, this.nw) && pr(i3, this.r, this.ie);
        }
    }

    private void fw(float f) {
        if (pr(this.qa == 7, f) && System.currentTimeMillis() - this.fw > 2000) {
            hw(false);
            if (this.k != null) {
                zo(13);
                this.k.pr(getType());
            }
            this.fw = System.currentTimeMillis();
        }
    }

    private int getType() {
        return this.rc == 2 ? 2 : 1;
    }

    private void zo(int i) {
        cz.pr().pr(this.mw, i);
    }

    private void aj(int i) {
        try {
            this.mw = i;
            cz.pr().pr(this.mw, "calculation_method", Integer.valueOf(this.vk));
            cz.pr().pr(this.mw, "calculation_method_twist", Integer.valueOf(this.qa));
            cz.pr().pr(this.mw, "shake_threshold", Float.valueOf(this.zo));
            cz.pr().pr(this.mw, "twist_threshold", Float.valueOf(this.aj));
            cz.pr().pr(this.mw, "twist_single_threshold", Boolean.valueOf(this.s));
            cz.pr().pr(this.mw, "twist_x_threshold", Float.valueOf(this.er));
            cz.pr().pr(this.mw, "twist_y_threshold", Float.valueOf(this.qi));
            cz.pr().pr(this.mw, "twist_z_threshold", Float.valueOf(this.of));
        } catch (Throwable th) {
        }
    }

    private void vk() {
        cz.pr().hn(this.mw);
    }

    private void pr(int i, float[] fArr) {
        cz.pr().pr(this.mw, i, fArr);
    }
}
