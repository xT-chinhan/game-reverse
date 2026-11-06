package com.byazt.uy;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.byazt.hb.fs;
import com.byazt.vh.cd;
import com.byazt.vh.cy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 819, 18})
public class l {
    public String cp;
    public n cy;
    public Context d;
    public boolean k;
    public boolean oa;
    public cy rv;
    public boolean sz;
    public cy tj;
    public int n = 0;
    public int qg = Integer.MAX_VALUE;
    public int s = Integer.MAX_VALUE;
    public AtomicBoolean q = new AtomicBoolean(true);
    public float l = Float.MIN_VALUE;
    public float w = Float.MIN_VALUE;
    public Map<Integer, Float> x = new HashMap();
    public Map<Integer, Float> fs = new HashMap();

    public l(Context context, cy cyVar, boolean z, boolean z2, boolean z3) {
        this.d = context;
        this.rv = cyVar;
        this.oa = z;
        this.sz = z2;
        this.k = z3;
        s();
    }

    public l(Context context, cy cyVar, cy cyVar2, boolean z, boolean z2, boolean z3) {
        this.d = context;
        this.rv = cyVar;
        this.tj = cyVar2;
        this.oa = z;
        this.sz = z2;
        this.k = z3;
        s();
    }

    private void s() {
        if (this.sz) {
            this.cy = new n();
        }
        cy cyVar = this.rv;
        if (cyVar == null) {
            return;
        }
        this.n = cyVar.s().optInt("slideThreshold");
        this.cp = this.rv.s().optString("slideDirection");
        this.qg = this.rv.s().optInt("frequency", Integer.MAX_VALUE);
        this.s = this.rv.s().optInt("effectiveDuration", Integer.MAX_VALUE);
        this.q.get();
    }

    public void n() {
        if (this.s == Integer.MAX_VALUE) {
            return;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.byazt.uy.l.1
            @Override // java.lang.Runnable
            public void run() {
                l.this.q.set(false);
            }
        }, this.s);
    }

    public void qg() {
        this.l = Float.MIN_VALUE;
        this.w = Float.MIN_VALUE;
        this.x.clear();
        this.fs.clear();
    }

    private void n(int i) {
        this.x.remove(Integer.valueOf(i));
        this.fs.remove(Integer.valueOf(i));
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0047  */
    /* JADX WARN: Code duplicated, block: B:44:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:49:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:53:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:54:0x010f  */
    /* JADX WARN: Code duplicated, block: B:57:0x0114 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:58:0x0116  */
    /* JADX WARN: Code duplicated, block: B:60:0x011f  */
    /* JADX WARN: Code duplicated, block: B:62:0x0126  */
    private boolean qg(cd cdVar, com.byazt.ih.s sVar, MotionEvent motionEvent, boolean z) {
        float fFloatValue;
        float fFloatValue2;
        float x;
        float y;
        int iQg;
        int iQg2;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        if (actionMasked == 0) {
            this.x.put(Integer.valueOf(pointerId), Float.valueOf(motionEvent.getX(actionIndex)));
            this.fs.put(Integer.valueOf(pointerId), Float.valueOf(motionEvent.getY(actionIndex)));
            new StringBuilder("ACTION_DOWN/POINTER_DOWN for pointer ").append(pointerId).append(" at (").append(this.x.get(Integer.valueOf(pointerId))).append(", ").append(this.fs.get(Integer.valueOf(pointerId)));
        } else {
            if (actionMasked == 1) {
                if (this.x.containsKey(Integer.valueOf(pointerId)) && this.fs.containsKey(Integer.valueOf(pointerId))) {
                    fFloatValue = this.x.get(Integer.valueOf(pointerId)).floatValue();
                    fFloatValue2 = this.fs.get(Integer.valueOf(pointerId)).floatValue();
                    x = motionEvent.getX(actionIndex);
                    y = motionEvent.getY(actionIndex);
                    if (!this.oa && Math.abs(x - fFloatValue) <= 10.0f && Math.abs(y - fFloatValue2) <= 10.0f && cdVar != null) {
                        n(pointerId);
                        cdVar.n(this.tj, sVar, sVar);
                        return true;
                    }
                    if (this.n != 0 && cdVar != null) {
                        n(pointerId);
                        n(cdVar, this.rv, sVar);
                        return true;
                    }
                    iQg = fs.qg(this.d, x - fFloatValue);
                    iQg2 = fs.qg(this.d, y - fFloatValue2);
                    if (TextUtils.equals(this.cp, "up")) {
                        iQg = -iQg2;
                    } else if (!TextUtils.equals(this.cp, "down")) {
                        iQg = iQg2;
                    } else if (TextUtils.equals(this.cp, "left")) {
                        iQg = -iQg;
                    } else if (!TextUtils.equals(this.cp, "right")) {
                        iQg = (int) Math.abs(Math.sqrt(Math.pow(iQg, 2.0d) + Math.pow(iQg2, 2.0d)));
                    }
                    if (iQg >= this.n) {
                        n(pointerId);
                        n(sVar);
                    } else if (cdVar != null) {
                        n(pointerId);
                        n(cdVar, this.rv, sVar);
                        return true;
                    }
                }
                return false;
            }
            if (actionMasked == 3) {
                for (int i = 0; i < motionEvent.getPointerCount(); i++) {
                    int pointerId2 = motionEvent.getPointerId(i);
                    if (this.x.containsKey(Integer.valueOf(pointerId2)) && this.fs.containsKey(Integer.valueOf(pointerId2))) {
                        n(pointerId2);
                    }
                }
                return false;
            }
            if (actionMasked == 5) {
                this.x.put(Integer.valueOf(pointerId), Float.valueOf(motionEvent.getX(actionIndex)));
                this.fs.put(Integer.valueOf(pointerId), Float.valueOf(motionEvent.getY(actionIndex)));
                new StringBuilder("ACTION_DOWN/POINTER_DOWN for pointer ").append(pointerId).append(" at (").append(this.x.get(Integer.valueOf(pointerId))).append(", ").append(this.fs.get(Integer.valueOf(pointerId)));
            } else if (actionMasked == 6) {
                if (this.x.containsKey(Integer.valueOf(pointerId))) {
                    fFloatValue = this.x.get(Integer.valueOf(pointerId)).floatValue();
                    fFloatValue2 = this.fs.get(Integer.valueOf(pointerId)).floatValue();
                    x = motionEvent.getX(actionIndex);
                    y = motionEvent.getY(actionIndex);
                    if (!this.oa) {
                    }
                    if (this.n != 0) {
                    }
                    iQg = fs.qg(this.d, x - fFloatValue);
                    iQg2 = fs.qg(this.d, y - fFloatValue2);
                    if (TextUtils.equals(this.cp, "up")) {
                        iQg = -iQg2;
                    } else if (!TextUtils.equals(this.cp, "down")) {
                        iQg = iQg2;
                    } else if (TextUtils.equals(this.cp, "left")) {
                        iQg = -iQg;
                    } else if (!TextUtils.equals(this.cp, "right")) {
                        iQg = (int) Math.abs(Math.sqrt(Math.pow(iQg, 2.0d) + Math.pow(iQg2, 2.0d)));
                    }
                    if (iQg >= this.n) {
                        n(pointerId);
                        n(sVar);
                    } else if (cdVar != null) {
                        n(pointerId);
                        n(cdVar, this.rv, sVar);
                        return true;
                    }
                }
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0030  */
    /* JADX WARN: Code duplicated, block: B:36:0x008c  */
    /* JADX WARN: Code duplicated, block: B:37:0x008e  */
    /* JADX WARN: Code duplicated, block: B:39:0x0098  */
    /* JADX WARN: Code duplicated, block: B:41:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:45:0x00af  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:49:0x00cb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:53:0x00da  */
    private boolean s(cd cdVar, com.byazt.ih.s sVar, MotionEvent motionEvent, boolean z) {
        float x;
        float y;
        int iQg;
        int iQg2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.l = motionEvent.getX();
            this.w = motionEvent.getY();
        } else if (action == 1) {
            x = motionEvent.getX();
            y = motionEvent.getY();
            if (!this.oa && Math.abs(x - this.l) <= 10.0f && Math.abs(y - this.w) <= 10.0f && cdVar != null) {
                qg();
                cdVar.n(this.tj, sVar, sVar);
                return true;
            }
            if (this.n != 0 && cdVar != null) {
                qg();
                n(cdVar, this.rv, sVar);
                return true;
            }
            iQg = fs.qg(this.d, x - this.l);
            iQg2 = fs.qg(this.d, y - this.w);
            if (TextUtils.equals(this.cp, "up")) {
                iQg = -iQg2;
            } else if (!TextUtils.equals(this.cp, "down")) {
                iQg = iQg2;
            } else if (TextUtils.equals(this.cp, "left")) {
                iQg = -iQg;
            } else if (!TextUtils.equals(this.cp, "right")) {
                iQg = (int) Math.abs(Math.sqrt(Math.pow(iQg, 2.0d) + Math.pow(iQg2, 2.0d)));
            }
            if (iQg >= this.n) {
                qg();
                n(sVar);
                return false;
            }
            if (cdVar != null) {
                qg();
                n(cdVar, this.rv, sVar);
                return true;
            }
            qg();
        } else if (action == 3) {
            if (this.l == Float.MIN_VALUE || this.w == Float.MIN_VALUE) {
                return false;
            }
            float rawX = motionEvent.getRawX();
            if (motionEvent.getRawY() != 0.0f || rawX != 0.0f) {
                x = motionEvent.getX();
                y = motionEvent.getY();
                if (!this.oa) {
                }
                if (this.n != 0) {
                }
                iQg = fs.qg(this.d, x - this.l);
                iQg2 = fs.qg(this.d, y - this.w);
                if (TextUtils.equals(this.cp, "up")) {
                    iQg = -iQg2;
                } else if (!TextUtils.equals(this.cp, "down")) {
                    iQg = iQg2;
                } else if (TextUtils.equals(this.cp, "left")) {
                    iQg = -iQg;
                } else if (!TextUtils.equals(this.cp, "right")) {
                    iQg = (int) Math.abs(Math.sqrt(Math.pow(iQg, 2.0d) + Math.pow(iQg2, 2.0d)));
                }
                if (iQg >= this.n) {
                    qg();
                    n(sVar);
                    return false;
                }
                if (cdVar != null) {
                    qg();
                    n(cdVar, this.rv, sVar);
                    return true;
                }
                qg();
            }
        }
        return true;
    }

    public boolean n(cd cdVar, com.byazt.ih.s sVar, MotionEvent motionEvent, boolean z) {
        n nVar = this.cy;
        if (nVar != null) {
            if (nVar.n(motionEvent)) {
                return false;
            }
            this.cy.n(sVar, motionEvent);
        }
        if (this.k) {
            return qg(cdVar, sVar, motionEvent, z);
        }
        return s(cdVar, sVar, motionEvent, z);
    }

    private void n(com.byazt.ih.s sVar) {
        n nVar = this.cy;
        if (nVar != null) {
            nVar.n(sVar);
        }
    }

    private void n(cd cdVar, cy cyVar, com.byazt.ih.s sVar) {
        if (this.qg <= 0) {
            n(sVar);
            return;
        }
        if (!this.q.get()) {
            n(sVar);
            return;
        }
        cdVar.n(cyVar, sVar, sVar);
        int i = this.qg;
        if (i != Integer.MAX_VALUE) {
            this.qg = i - 1;
        }
    }
}
