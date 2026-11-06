package com.byazt.cv;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.byazt.af.x;
import com.byazt.gct.nf;
import com.byazt.gct.pk;
import com.byazt.nf.rv;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1039, 19})
public class n {
    public qg a;
    public com.byazt.vhv.s bb;
    public float[] cd;
    public int cp;
    public volatile SensorEventListener cy;
    public int d;
    public volatile JSONObject fs;
    public final String hd;
    public volatile C0150n k;
    public boolean l;
    public int lh;
    public final String ln;
    public volatile boolean n;
    public volatile C0150n oa;
    public View q;
    public volatile boolean qg;
    public volatile boolean s;
    public volatile C0150n sz;
    public int[] t;
    public final com.byazt.pnm.w tj;
    public float[] um;
    public boolean ur;
    public int v;
    public long w = -1;
    public long x = -1;
    public final List<JSONObject> rv = new ArrayList();
    public float py = 360.0f;
    public float ou = 360.0f;
    public float wm = 360.0f;
    public float m = 360.0f;
    public float hu = 360.0f;
    public float h = 360.0f;

    /* JADX INFO: renamed from: com.byazt.cv.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1039, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private static final class C0150n {
        public final JSONObject[] n;
        public int q;
        public final int qg;
        public int s;

        private C0150n(int i) {
            this.qg = i;
            this.n = new JSONObject[i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void n(JSONObject jSONObject, boolean z) {
            if (jSONObject == null) {
                return;
            }
            try {
                if (z) {
                    int i = this.s;
                    int i2 = this.qg;
                    if (i >= i2) {
                        return;
                    }
                    this.n[(this.q + i) % i2] = jSONObject;
                    this.s = i + 1;
                    return;
                }
                int i3 = this.s;
                int i4 = this.qg;
                if (i3 < i4) {
                    this.n[(this.q + i3) % i4] = jSONObject;
                    this.s = i3 + 1;
                } else {
                    JSONObject[] jSONObjectArr = this.n;
                    int i5 = this.q;
                    jSONObjectArr[i5] = jSONObject;
                    this.q = (i5 + 1) % i4;
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean n() {
            return this.s >= this.qg;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized JSONArray qg() {
            JSONArray jSONArray;
            jSONArray = new JSONArray();
            for (int i = 0; i < this.s; i++) {
                jSONArray.put(this.n[(this.q + i) % this.qg]);
            }
            return jSONArray;
        }
    }

    public n(pk pkVar) {
        this.hd = pkVar.h();
        this.ln = pkVar.ih();
        com.byazt.pnm.w wVarXk = rv.qg().xk();
        this.tj = wVarXk;
        if (nf.rv(pkVar)) {
            com.byazt.zq.qg qgVarXd = pkVar.xd();
            if (wVarXk == null || qgVarXd == null || !wVarXk.fs()) {
                return;
            }
            this.lh = wVarXk.q();
            int iA = qgVarXd.a();
            this.v = iA;
            if (iA == 0) {
                this.v = com.byazt.vgx.w.d(pkVar);
            }
            this.n = wVarXk.n(this.v);
            this.qg = wVarXk.qg(this.v);
            this.s = wVarXk.s(this.v) && s();
        }
    }

    private boolean s() {
        com.byazt.tk.q qVarN = com.byazt.tk.q.n(rv.getContext());
        return (qVarN.n(10) == null || qVarN.n(4) == null || qVarN.n(15) == null) ? false : true;
    }

    public void n(ViewGroup viewGroup, MotionEvent motionEvent, boolean z) {
        if (this.n) {
            try {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.q = n(viewGroup, motionEvent.getX(), motionEvent.getY());
                    this.l = z;
                    this.w = motionEvent.getEventTime();
                    this.fs = new JSONObject();
                    this.fs.putOpt("began", n(motionEvent));
                    this.rv.clear();
                    return;
                }
                if (action != 1) {
                    if (action == 2) {
                        this.rv.add(n(motionEvent));
                        return;
                    } else if (action != 3) {
                        return;
                    }
                }
                View view = this.q;
                if (view != null && view.equals(n(viewGroup, motionEvent.getX(), motionEvent.getY())) && this.l && z) {
                    return;
                }
                if (this.fs != null && this.tj != null) {
                    this.fs.putOpt("ended", n(motionEvent));
                    this.fs.putOpt("moves", n(this.rv, this.tj.n()));
                }
                q();
            } catch (Exception unused) {
            }
        }
    }

    private void q() {
        Object objQ = com.byazt.de.qg.q(this.hd, 1);
        if (objQ instanceof JSONArray) {
            ((JSONArray) objQ).put(this.fs);
        } else {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.fs);
            com.byazt.de.qg.n(this.hd, 1, jSONArray);
        }
        this.fs = null;
    }

    private JSONArray n(List<JSONObject> list, int i) {
        if (list.isEmpty()) {
            return null;
        }
        int size = list.size();
        int i2 = 0;
        int i3 = size > i ? (size / i) - 1 : 0;
        JSONArray jSONArray = new JSONArray();
        if (i3 > 0) {
            while (i2 < i) {
                i2++;
                int i4 = (i2 * i3) - 1;
                if (i4 < size) {
                    jSONArray.put(list.get(i4));
                }
            }
        } else {
            int iMin = Math.min(size, i);
            while (i2 < iMin) {
                jSONArray.put(list.get(i2));
                i2++;
            }
        }
        return jSONArray;
    }

    private View n(ViewGroup viewGroup, float f, float f2) {
        View view = null;
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt.getVisibility() == 0 && n(f, f2, childAt)) {
                if (childAt instanceof ViewGroup) {
                    View viewN = n((ViewGroup) childAt, f, f2);
                    if (viewN != null) {
                        childAt = viewN;
                    }
                    if (childAt.isClickable()) {
                        return childAt;
                    }
                    view = childAt;
                } else if (childAt.isClickable()) {
                    return childAt;
                }
            }
        }
        return view;
    }

    private boolean n(float f, float f2, View view) {
        return f >= ((float) view.getLeft()) && f <= ((float) view.getRight()) && f2 >= ((float) view.getTop()) && f2 <= ((float) view.getBottom());
    }

    private JSONObject n(MotionEvent motionEvent) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("nums", motionEvent.getPointerCount());
            jSONObject.put(x.n, String.format("%.2f", Float.valueOf(motionEvent.getX())));
            jSONObject.put("y", String.format("%.2f", Float.valueOf(motionEvent.getY())));
            jSONObject.put("ts", motionEvent.getEventTime() - this.w);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(com.byazt.ih.s sVar) {
        try {
            qg qgVar = new qg(this);
            this.a = qgVar;
            JSONObject jSONObjectN = qgVar.n(sVar);
            if (jSONObjectN == null) {
                return;
            }
            com.byazt.de.qg.n(this.hd, 0, jSONObjectN);
        } catch (Exception unused) {
        }
    }

    public void n() {
        com.byazt.pnm.w wVar;
        if (this.s && this.cy == null && (wVar = this.tj) != null) {
            this.cd = new float[9];
            this.um = new float[3];
            int iQg = wVar.qg();
            this.cp = iQg;
            if (iQg <= 0) {
                return;
            }
            this.oa = new C0150n(this.cp);
            this.sz = new C0150n(this.cp);
            this.k = new C0150n(this.cp);
            this.d = this.tj.s();
            this.cy = new SensorEventListener() { // from class: com.byazt.cv.n.1
                @Override // android.hardware.SensorEventListener
                public void onAccuracyChanged(Sensor sensor, int i) {
                }

                @Override // android.hardware.SensorEventListener
                public void onSensorChanged(SensorEvent sensorEvent) {
                    n.this.n(sensorEvent);
                }
            };
            com.byazt.tk.q qVarN = com.byazt.tk.q.n(rv.getContext());
            qVarN.n(this.cy, qVarN.n(10), this.d);
            qVarN.n(this.cy, qVarN.n(4), this.d);
            qVarN.n(this.cy, qVarN.n(15), this.d);
        }
    }

    public void qg() {
        if (this.cy != null) {
            SensorEventListener sensorEventListener = this.cy;
            this.cy = null;
            com.byazt.tk.q.n(rv.getContext()).n(sensorEventListener);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("accelerometer", qg(this.oa));
                jSONObject.putOpt("gyro", qg(this.sz));
                jSONObject.putOpt("device", qg(this.k));
                com.byazt.de.qg.n(this.hd, 2, jSONObject);
            } catch (Exception unused) {
            }
            l();
        }
    }

    private void l() {
        float f = this.py - this.ou;
        float f2 = this.wm - this.m;
        float f3 = this.hu - this.h;
        try {
            JSONObject jSONObjectN = com.byazt.vhv.qg.n(this.hd);
            if (jSONObjectN != null) {
                jSONObjectN.putOpt(x.n, Integer.valueOf(this.t[0]));
                jSONObjectN.putOpt("y", Integer.valueOf(this.t[1]));
                jSONObjectN.putOpt("width", Integer.valueOf(this.t[2]));
                jSONObjectN.putOpt("height", Integer.valueOf(this.t[3]));
                jSONObjectN.putOpt("screen_width", Integer.valueOf(com.byazt.okk.s.l((Context) null)));
                jSONObjectN.putOpt("screen_height", Integer.valueOf(com.byazt.okk.s.w((Context) null)));
            }
            if (this.py != 360.0f && this.wm != 360.0f && this.hu != 360.0f && this.ou != 360.0f && this.m != 360.0f && this.h != 360.0f) {
                if (jSONObjectN != null) {
                    jSONObjectN.putOpt("x_rotate", Float.valueOf(f));
                    jSONObjectN.putOpt("y_rotate", Float.valueOf(f2));
                    jSONObjectN.putOpt("z_rotate", Float.valueOf(f3));
                }
                Boolean bool = (Boolean) com.byazt.ikv.qg.n(this.ln, Boolean.class);
                if (bool == null || bool.booleanValue()) {
                    int[] iArr = this.t;
                    if (iArr == null || iArr.length < 4) {
                        this.t = new int[]{0, 0, 0, 0};
                    }
                    if (bool != null || Math.abs(f) >= 1.0f || Math.abs(f2) >= 1.0f || Math.abs(f3) >= 1.0f) {
                        com.byazt.vhv.n nVarQg = com.byazt.vhv.n.qg();
                        int[] iArr2 = this.t;
                        nVarQg.n(iArr2[0], iArr2[1], iArr2[2], iArr2[3], f, f2, f3, this.v);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (this.x < 0) {
            this.x = sensorEvent.timestamp;
        }
        if (type == 4) {
            n(this.sz, s(sensorEvent));
        } else if (type == 10) {
            n(this.oa, s(sensorEvent));
        } else if (type == 15) {
            if (sensorEvent.values == null || sensorEvent.values.length < 3) {
                return;
            } else {
                n(this.k, qg(sensorEvent));
            }
        }
        if (this.lh == 0 && n(this.oa) && n(this.sz) && n(this.k)) {
            qg();
        }
    }

    private JSONObject qg(SensorEvent sensorEvent) {
        if (sensorEvent == null || this.cd == null || this.um == null || sensorEvent.values == null || sensorEvent.values.length < 3) {
            return null;
        }
        SensorManager.getRotationMatrixFromVector(this.cd, sensorEvent.values);
        SensorManager.getOrientation(this.cd, this.um);
        float degrees = (float) Math.toDegrees(this.um[0]);
        float degrees2 = (float) Math.toDegrees(this.um[1]);
        float degrees3 = (float) Math.toDegrees(this.um[2]);
        float f = (degrees + 360.0f) % 360.0f;
        float fMax = Math.max(-90.0f, Math.min(90.0f, degrees2));
        float f2 = (degrees3 + 360.0f) % 360.0f;
        if (this.h == 360.0f) {
            this.h = f;
        }
        if (this.ou == 360.0f) {
            this.ou = fMax;
        }
        if (this.m == 360.0f) {
            this.m = f2;
        }
        this.hu = f;
        this.py = fMax;
        this.wm = f2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pitch", Math.round(((double) fMax) * 100.0d) / 100.0d);
            jSONObject.put("roll", Math.round(((double) f2) * 100.0d) / 100.0d);
            jSONObject.put("yaw", Math.round(((double) f) * 100.0d) / 100.0d);
            jSONObject.put("ts", (sensorEvent.timestamp - this.x) / C.MICROS_PER_SECOND);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private JSONObject s(SensorEvent sensorEvent) {
        if (sensorEvent == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(x.n, Math.round(((double) sensorEvent.values[0]) * 100.0d) / 100.0d);
            jSONObject.put("y", Math.round(((double) sensorEvent.values[1]) * 100.0d) / 100.0d);
            jSONObject.put("z", Math.round(((double) sensorEvent.values[2]) * 100.0d) / 100.0d);
            jSONObject.put("ts", (sensorEvent.timestamp - this.x) / C.MICROS_PER_SECOND);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void n(C0150n c0150n, JSONObject jSONObject) {
        if (c0150n == null || jSONObject == null) {
            return;
        }
        c0150n.n(jSONObject, this.lh == 0);
    }

    private boolean n(C0150n c0150n) {
        return c0150n != null && c0150n.n();
    }

    private JSONArray qg(C0150n c0150n) {
        if (c0150n == null) {
            return null;
        }
        return c0150n.qg();
    }

    public void n(final com.byazt.ih.s sVar) {
        n();
        if (this.qg) {
            this.qg = false;
            final View viewRv = sVar.rv();
            if (viewRv != null) {
                viewRv.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.byazt.cv.n.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        viewRv.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        n.this.qg(sVar);
                    }
                });
            }
        }
    }

    public void n(com.byazt.vhv.s sVar) {
        if (sVar == null) {
            this.bb = null;
            return;
        }
        int[] iArr = this.t;
        if (iArr != null && iArr.length == 4) {
            sVar.n(iArr[0], iArr[1], iArr[2], iArr[3], this.ur);
        } else {
            this.bb = sVar;
        }
    }

    public void n(int[] iArr, boolean z) {
        this.t = iArr;
        this.ur = z;
        com.byazt.vhv.s sVar = this.bb;
        if (sVar == null || iArr == null || iArr.length != 4) {
            return;
        }
        sVar.n(iArr[0], iArr[1], iArr[2], iArr[3], z);
    }
}
