package com.byazt.nk;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v4.view.PointerIconCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.byazt.hg.of;
import com.byazt.is.k;
import com.byazt.sd.a;
import com.byazt.sd.cz;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.C;
import com.mar.sdk.MARCode;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, 37})
public class pr {
    public hw a;
    public boolean c;
    public volatile C0140pr g;
    public final String gz;
    public volatile boolean hn;
    public volatile C0140pr ho;
    public volatile boolean hw;
    public int[] iu;
    public int k;
    public float[] lb;
    public volatile C0140pr m;
    public int nl;
    public volatile SensorEventListener nt;
    public volatile boolean pr;
    public float[] qa;
    public com.byazt.ak.hn ve;
    public final k vk;
    public int w;
    public View x;
    public int y;
    public final String yb;
    public volatile JSONObject zo;
    public long uc = -1;
    public long fw = -1;
    public final List<JSONObject> aj = new ArrayList();
    public float cz = 360.0f;
    public float ny = 360.0f;
    public float fo = 360.0f;
    public float rc = 360.0f;
    public float z = 360.0f;
    public float b = 360.0f;

    /* JADX INFO: renamed from: com.byazt.nk.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    private static final class C0140pr {
        public int hn;
        public final int hw;
        public final JSONObject[] pr;
        public int x;

        private C0140pr(int i) {
            this.hw = i;
            this.pr = new JSONObject[i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void pr(JSONObject jSONObject, boolean z) {
            if (jSONObject == null) {
                return;
            }
            try {
                if (z) {
                    int i = this.hn;
                    int i2 = this.hw;
                    if (i >= i2) {
                        return;
                    }
                    this.pr[(this.x + i) % i2] = jSONObject;
                    this.hn = i + 1;
                    return;
                }
                int i3 = this.hn;
                int i4 = this.hw;
                if (i3 < i4) {
                    this.pr[(this.x + i3) % i4] = jSONObject;
                    this.hn = i3 + 1;
                } else {
                    JSONObject[] jSONObjectArr = this.pr;
                    int i5 = this.x;
                    jSONObjectArr[i5] = jSONObject;
                    this.x = (i5 + 1) % i4;
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean pr() {
            return this.hn >= this.hw;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized JSONArray hw() {
            JSONArray jSONArray;
            jSONArray = new JSONArray();
            for (int i = 0; i < this.hn; i++) {
                jSONArray.put(this.pr[(this.x + i) % this.hw]);
            }
            return jSONArray;
        }
    }

    public pr(of ofVar) {
        this.yb = ofVar.z();
        this.gz = ofVar.le();
        k kVarIa = a.hw().ia();
        this.vk = kVarIa;
        com.byazt.qe.hw hwVarP = ofVar.p();
        if (kVarIa != null && hwVarP != null) {
            this.nl = kVarIa.x();
            int iA = hwVarP.a();
            this.y = iA;
            if (iA == 0) {
                this.y = ls.k(ofVar);
            }
            this.pr = kVarIa.pr(this.y);
            this.hw = kVarIa.hw(this.y);
            this.hn = kVarIa.hn(this.y) && hn();
        }
    }

    private boolean hn() {
        com.byazt.ca.x xVarPr = com.byazt.ca.x.pr(a.getContext());
        return (xVarPr.pr(10) == null || xVarPr.pr(4) == null || xVarPr.pr(15) == null) ? false : true;
    }

    public void pr(ViewGroup viewGroup, MotionEvent motionEvent, boolean z) {
        if (this.pr) {
            try {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.x = pr(viewGroup, motionEvent.getX(), motionEvent.getY());
                        this.c = z;
                        this.uc = motionEvent.getEventTime();
                        this.zo = new JSONObject();
                        this.zo.putOpt("began", pr(motionEvent));
                        this.aj.clear();
                        break;
                    case 1:
                    case 3:
                        View view = this.x;
                        if (view == null || !view.equals(pr(viewGroup, motionEvent.getX(), motionEvent.getY())) || !this.c || !z) {
                            if (this.zo != null && this.vk != null) {
                                this.zo.putOpt("ended", pr(motionEvent));
                                this.zo.putOpt("moves", pr(this.aj, this.vk.pr()));
                            }
                            x();
                        }
                        break;
                    case 2:
                        this.aj.add(pr(motionEvent));
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
            }
        }
    }

    private void x() {
        Object objX = com.byazt.qd.hw.x(this.yb, 1);
        if (objX instanceof JSONArray) {
            ((JSONArray) objX).put(this.zo);
        } else {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.zo);
            com.byazt.qd.hw.pr(this.yb, 1, jSONArray);
        }
        this.zo = null;
    }

    private JSONArray pr(List<JSONObject> list, int i) {
        int i2;
        if (!list.isEmpty()) {
            int size = list.size();
            int i3 = 0;
            if (size <= i) {
                i2 = 0;
            } else {
                i2 = (size / i) - 1;
            }
            JSONArray jSONArray = new JSONArray();
            if (i2 > 0) {
                while (i3 < i) {
                    i3++;
                    int i4 = (i3 * i2) - 1;
                    if (i4 < size) {
                        jSONArray.put(list.get(i4));
                    }
                }
            } else {
                int iMin = Math.min(size, i);
                while (i3 < iMin) {
                    jSONArray.put(list.get(i3));
                    i3++;
                }
            }
            return jSONArray;
        }
        return null;
    }

    private View pr(ViewGroup viewGroup, float f, float f2) {
        View view = null;
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt.getVisibility() == 0 && pr(f, f2, childAt)) {
                if (childAt instanceof ViewGroup) {
                    View viewPr = pr((ViewGroup) childAt, f, f2);
                    if (viewPr != null) {
                        childAt = viewPr;
                    }
                    if (!childAt.isClickable()) {
                        view = childAt;
                    } else {
                        return childAt;
                    }
                } else if (childAt.isClickable()) {
                    return childAt;
                }
            }
        }
        return view;
    }

    private boolean pr(float f, float f2, View view) {
        return f >= ((float) view.getLeft()) && f <= ((float) view.getRight()) && f2 >= ((float) view.getTop()) && f2 <= ((float) view.getBottom());
    }

    private JSONObject pr(MotionEvent motionEvent) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("nums", motionEvent.getPointerCount());
            jSONObject.put("x", String.format("%.2f", Float.valueOf(motionEvent.getX())));
            jSONObject.put("y", String.format("%.2f", Float.valueOf(motionEvent.getY())));
            jSONObject.put("ts", motionEvent.getEventTime() - this.uc);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(com.byazt.ik.hn hnVar) {
        try {
            hw hwVar = new hw(this);
            this.a = hwVar;
            JSONObject jSONObjectPr = hwVar.pr(hnVar);
            if (jSONObjectPr == null) {
                return;
            }
            com.byazt.qd.hw.pr(this.yb, 0, jSONObjectPr);
        } catch (Exception e) {
        }
    }

    public void pr() {
        k kVar;
        if (this.hn && this.nt == null && (kVar = this.vk) != null) {
            this.lb = new float[9];
            this.qa = new float[3];
            int iHw = kVar.hw();
            this.w = iHw;
            if (iHw <= 0) {
                return;
            }
            this.m = new C0140pr(iHw);
            this.g = new C0140pr(this.w);
            this.ho = new C0140pr(this.w);
            this.k = this.vk.hn();
            this.nt = new SensorEventListener() { // from class: com.byazt.nk.pr.1
                @Override // android.hardware.SensorEventListener
                public void onSensorChanged(SensorEvent sensorEvent) {
                    pr.this.pr(sensorEvent);
                }

                @Override // android.hardware.SensorEventListener
                public void onAccuracyChanged(Sensor sensor, int i) {
                }
            };
            com.byazt.ca.x xVarPr = com.byazt.ca.x.pr(a.getContext());
            xVarPr.pr(this.nt, xVarPr.pr(10), this.k);
            xVarPr.pr(this.nt, xVarPr.pr(4), this.k);
            xVarPr.pr(this.nt, xVarPr.pr(15), this.k);
        }
    }

    public void hw() {
        if (this.nt != null) {
            SensorEventListener sensorEventListener = this.nt;
            this.nt = null;
            com.byazt.ca.x.pr(a.getContext()).pr(sensorEventListener);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("accelerometer", hw(this.m));
                jSONObject.putOpt("gyro", hw(this.g));
                jSONObject.putOpt("device", hw(this.ho));
                com.byazt.qd.hw.pr(this.yb, 2, jSONObject);
            } catch (Exception e) {
            }
            c();
        }
    }

    private void c() {
        float f = this.cz - this.ny;
        float f2 = this.fo - this.rc;
        float f3 = this.z - this.b;
        try {
            JSONObject jSONObjectPr = com.byazt.ak.hw.pr(this.yb);
            if (jSONObjectPr != null) {
                jSONObjectPr.putOpt("x", Integer.valueOf(this.iu[0]));
                jSONObjectPr.putOpt("y", Integer.valueOf(this.iu[1]));
                jSONObjectPr.putOpt("width", Integer.valueOf(this.iu[2]));
                jSONObjectPr.putOpt("height", Integer.valueOf(this.iu[3]));
                jSONObjectPr.putOpt("screen_width", Integer.valueOf(er.c((Context) null)));
                jSONObjectPr.putOpt("screen_height", Integer.valueOf(er.uc((Context) null)));
            }
            if (this.cz != 360.0f && this.fo != 360.0f && this.z != 360.0f && this.ny != 360.0f && this.rc != 360.0f && this.b != 360.0f) {
                if (jSONObjectPr != null) {
                    jSONObjectPr.putOpt("x_rotate", Float.valueOf(f));
                    jSONObjectPr.putOpt("y_rotate", Float.valueOf(f2));
                    jSONObjectPr.putOpt("z_rotate", Float.valueOf(f3));
                }
                Boolean bool = (Boolean) cz.pr(this.gz, Boolean.class);
                if (bool != null && !bool.booleanValue()) {
                    return;
                }
                int[] iArr = this.iu;
                if (iArr == null || iArr.length < 4) {
                    this.iu = new int[]{0, 0, 0, 0};
                }
                if (bool == null && Math.abs(f) < 1.0f && Math.abs(f2) < 1.0f && Math.abs(f3) < 1.0f) {
                    return;
                }
                com.byazt.ak.pr prVarHw = com.byazt.ak.pr.hw();
                int[] iArr2 = this.iu;
                prVarHw.pr(iArr2[0], iArr2[1], iArr2[2], iArr2[3], f, f2, f3, this.y);
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (this.fw < 0) {
            this.fw = sensorEvent.timestamp;
        }
        switch (type) {
            case 4:
                pr(this.g, hn(sensorEvent));
                break;
            case 10:
                pr(this.m, hn(sensorEvent));
                break;
            case 15:
                if (sensorEvent.values == null || sensorEvent.values.length < 3) {
                    return;
                }
                pr(this.ho, hw(sensorEvent));
                break;
                break;
        }
        if (this.nl == 0 && pr(this.m) && pr(this.g) && pr(this.ho)) {
            hw();
        }
    }

    private JSONObject hw(SensorEvent sensorEvent) {
        if (sensorEvent == null || this.lb == null || this.qa == null || sensorEvent.values == null || sensorEvent.values.length < 3) {
            return null;
        }
        SensorManager.getRotationMatrixFromVector(this.lb, sensorEvent.values);
        SensorManager.getOrientation(this.lb, this.qa);
        float degrees = (float) Math.toDegrees(this.qa[0]);
        float degrees2 = (float) Math.toDegrees(this.qa[1]);
        float degrees3 = (float) Math.toDegrees(this.qa[2]);
        float f = (degrees + 360.0f) % 360.0f;
        float fMax = Math.max(-90.0f, Math.min(90.0f, degrees2));
        float f2 = (degrees3 + 360.0f) % 360.0f;
        if (this.b == 360.0f) {
            this.b = f;
        }
        if (this.ny == 360.0f) {
            this.ny = fMax;
        }
        if (this.rc == 360.0f) {
            this.rc = f2;
        }
        this.z = f;
        this.cz = fMax;
        this.fo = f2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pitch", Math.round(((double) fMax) * 100.0d) / 100.0d);
            jSONObject.put("roll", Math.round(((double) f2) * 100.0d) / 100.0d);
            jSONObject.put("yaw", Math.round(((double) f) * 100.0d) / 100.0d);
            jSONObject.put("ts", (sensorEvent.timestamp - this.fw) / C.MICROS_PER_SECOND);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    private JSONObject hn(SensorEvent sensorEvent) {
        if (sensorEvent == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", Math.round(((double) sensorEvent.values[0]) * 100.0d) / 100.0d);
            jSONObject.put("y", Math.round(((double) sensorEvent.values[1]) * 100.0d) / 100.0d);
            jSONObject.put(an.aD, Math.round(((double) sensorEvent.values[2]) * 100.0d) / 100.0d);
            jSONObject.put("ts", (sensorEvent.timestamp - this.fw) / C.MICROS_PER_SECOND);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    private void pr(C0140pr c0140pr, JSONObject jSONObject) {
        if (c0140pr != null && jSONObject != null) {
            c0140pr.pr(jSONObject, this.nl == 0);
        }
    }

    private boolean pr(C0140pr c0140pr) {
        return c0140pr != null && c0140pr.pr();
    }

    private JSONArray hw(C0140pr c0140pr) {
        if (c0140pr != null) {
            return c0140pr.hw();
        }
        return null;
    }

    public void pr(final com.byazt.ik.hn hnVar) {
        pr();
        if (this.hw) {
            this.hw = false;
            final View viewAj = hnVar.aj();
            if (viewAj != null) {
                viewAj.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.byazt.nk.pr.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        viewAj.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        pr.this.hw(hnVar);
                    }
                });
            }
        }
    }

    public void pr(com.byazt.ak.hn hnVar) {
        if (hnVar == null) {
            this.ve = null;
            return;
        }
        int[] iArr = this.iu;
        if (iArr != null && iArr.length == 4) {
            hnVar.pr(iArr[0], iArr[1], iArr[2], iArr[3]);
        } else {
            this.ve = hnVar;
        }
    }

    public void pr(int[] iArr) {
        this.iu = iArr;
        com.byazt.ak.hn hnVar = this.ve;
        if (hnVar != null && iArr != null && iArr.length == 4) {
            hnVar.pr(iArr[0], iArr[1], iArr[2], iArr[3]);
        }
    }
}
