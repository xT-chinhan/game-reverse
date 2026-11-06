package com.byazt.hw;

import android.content.Context;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import com.byazt.gct.el;
import com.byazt.gct.tj;
import com.byazt.nf.rv;
import com.byazt.okk.s;
import com.byazt.tk.t;
import com.byazt.vf.wo;
import com.byazt.za.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 203, 2343})
public class SlideInterceptView extends View implements wo.n {
    public final t cp;
    public final Map<Integer, qg> d;
    public final el fs;
    public float l;
    public float n;
    public MotionEvent q;
    public float qg;
    public final n rv;
    public long s;
    public final com.byazt.uy.n tj;
    public float w;
    public boolean x;

    public interface n {
        w n();

        void n(View view, tj tjVar);
    }

    private boolean n(float f, float f2, int i, int i2) {
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        boolean z3 = (i & 4) == 4;
        boolean z4 = (i & 8) == 8;
        if (z && (-f2) > i2) {
            return true;
        }
        if (z2 && f2 > i2) {
            return true;
        }
        if (!z3 || (-f) <= i2) {
            return z4 && f > ((float) i2);
        }
        return true;
    }

    @com.byazt.cp.n(n = {0, 1, 203, 1457})
    private static class qg {
        public float l;
        public float n;
        public float q;
        public float qg;
        public long s;
        public boolean w = false;
        public MotionEvent x;

        public qg(float f, float f2, long j, MotionEvent motionEvent) {
            this.n = f;
            this.qg = f2;
            this.s = j;
            this.q = f;
            this.l = f2;
            this.x = motionEvent;
        }
    }

    public SlideInterceptView(Context context, el elVar, n nVar) {
        super(context);
        this.x = false;
        this.tj = new com.byazt.uy.n();
        this.cp = new t(this);
        this.d = new HashMap();
        this.fs = elVar;
        this.rv = nVar;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.tj.n(motionEvent)) {
            return false;
        }
        this.tj.n(this, new StringBuilder().append(getId()).toString(), motionEvent);
        n(motionEvent);
        if (rv.qg().kn()) {
            return s(motionEvent);
        }
        return qg(motionEvent);
    }

    private void n(MotionEvent motionEvent) {
        w wVarN;
        n nVar = this.rv;
        if (nVar == null || (wVarN = nVar.n()) == null) {
            return;
        }
        wVarN.s(motionEvent.getDeviceId());
        wVarN.qg(motionEvent.getSource());
        wVarN.q(motionEvent.getToolType(0));
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00da  */
    /* JADX WARN: Code duplicated, block: B:34:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:36:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:38:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:40:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:41:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:43:0x010b  */
    /* JADX WARN: Code duplicated, block: B:45:0x0115  */
    /* JADX WARN: Code duplicated, block: B:47:0x0119  */
    /* JADX WARN: Code duplicated, block: B:49:0x011f  */
    /* JADX WARN: Code duplicated, block: B:50:0x0132  */
    /* JADX WARN: Code duplicated, block: B:52:0x0136  */
    /* JADX WARN: Code duplicated, block: B:58:0x014d  */
    /* JADX WARN: Code duplicated, block: B:61:0x0156 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:62:0x0157 A[RETURN] */
    private boolean qg(MotionEvent motionEvent) {
        boolean z;
        n nVar;
        n nVar2;
        byte b;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        this.l = motionEvent.getX();
        this.w = motionEvent.getY();
        this.q = motionEvent;
        float f = x - this.n;
        float f2 = y - this.qg;
        long jCurrentTimeMillis = System.currentTimeMillis() - this.s;
        int iCd = this.fs.cd();
        int iS = s.s(getContext(), this.fs.um());
        int iWm = this.fs.wm();
        int iS2 = s.s(getContext(), this.fs.m());
        int action = motionEvent.getAction();
        if (action == 0) {
            this.n = x;
            this.qg = y;
            this.s = System.currentTimeMillis();
            if (iWm > 0) {
                this.cp.sendEmptyMessageDelayed(1, iWm);
            }
        } else {
            if (action == 1) {
                this.cp.removeMessages(1);
                if (n(f, f2, iCd, iS)) {
                    if (!this.x) {
                        this.x = true;
                        nVar2 = this.rv;
                        if (nVar2 != null) {
                            if (motionEvent.getAction() == 3) {
                                b = 7;
                            } else {
                                b = 2;
                            }
                            nVar2.n(this, n(b, this.s, this.n, this.qg, x, y));
                        }
                    }
                } else if (n(f, f2, jCurrentTimeMillis, iWm, iS2)) {
                    if (!this.x) {
                        this.x = true;
                        nVar = this.rv;
                        if (nVar != null) {
                            nVar.n(this, n((byte) 5, this.s, this.n, this.qg, x, y));
                        }
                    }
                } else {
                    z = this.x ? false : true;
                }
            } else if (action != 2) {
                if (action == 3) {
                    float rawX = motionEvent.getRawX();
                    if (motionEvent.getRawY() == 0.0f && rawX == 0.0f) {
                        this.cp.removeMessages(1);
                        if (rv.qg().nm()) {
                            this.cp.removeMessages(1);
                            if (n(f, f2, iCd, iS)) {
                                if (!this.x) {
                                    this.x = true;
                                    nVar2 = this.rv;
                                    if (nVar2 != null) {
                                        if (motionEvent.getAction() == 3) {
                                            b = 7;
                                        } else {
                                            b = 2;
                                        }
                                        nVar2.n(this, n(b, this.s, this.n, this.qg, x, y));
                                    }
                                }
                            } else if (n(f, f2, jCurrentTimeMillis, iWm, iS2)) {
                                if (!this.x) {
                                    this.x = true;
                                    nVar = this.rv;
                                    if (nVar != null) {
                                        nVar.n(this, n((byte) 5, this.s, this.n, this.qg, x, y));
                                    }
                                }
                            } else if (this.x) {
                            }
                        }
                    } else {
                        this.cp.removeMessages(1);
                        if (n(f, f2, iCd, iS)) {
                            if (!this.x) {
                                this.x = true;
                                nVar2 = this.rv;
                                if (nVar2 != null) {
                                    if (motionEvent.getAction() == 3) {
                                        b = 7;
                                    } else {
                                        b = 2;
                                    }
                                    nVar2.n(this, n(b, this.s, this.n, this.qg, x, y));
                                }
                            }
                        } else if (n(f, f2, jCurrentTimeMillis, iWm, iS2)) {
                            if (!this.x) {
                                this.x = true;
                                nVar = this.rv;
                                if (nVar != null) {
                                    nVar.n(this, n((byte) 5, this.s, this.n, this.qg, x, y));
                                }
                            }
                        } else if (this.x) {
                        }
                    }
                }
            } else if (this.fs.ou() == 1 && n(f, f2, iCd, iS)) {
                if (!this.x) {
                    this.x = true;
                    n nVar3 = this.rv;
                    if (nVar3 != null) {
                        nVar3.n(this, n((byte) 2, this.s, this.n, this.qg, x, y));
                    }
                }
            } else if (n(f, f2, jCurrentTimeMillis, iWm, iS2) && !this.x) {
                this.x = true;
                n nVar4 = this.rv;
                if (nVar4 != null) {
                    nVar4.n(this, n((byte) 5, this.s, this.n, this.qg, x, y));
                }
            }
            if (z) {
                this.tj.n(this);
            }
            if (this.x) {
                return false;
            }
            return true;
        }
        if (z) {
            this.tj.n(this);
        }
        if (this.x) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:51:0x0132  */
    /* JADX WARN: Code duplicated, block: B:56:0x0145  */
    /* JADX WARN: Code duplicated, block: B:58:0x0148  */
    /* JADX WARN: Code duplicated, block: B:60:0x0155  */
    /* JADX WARN: Code duplicated, block: B:62:0x0174  */
    /* JADX WARN: Code duplicated, block: B:64:0x0192  */
    private boolean s(MotionEvent motionEvent) {
        qg qgVar;
        int iWm;
        qg qgVar2;
        boolean z;
        n nVar;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        if (actionMasked == 0) {
            qgVar = new qg(motionEvent.getX(actionIndex), motionEvent.getY(actionIndex), System.currentTimeMillis(), motionEvent);
            this.d.put(Integer.valueOf(pointerId), qgVar);
            if (actionMasked == 0) {
                this.n = qgVar.n;
                this.qg = qgVar.qg;
                this.s = qgVar.s;
                this.l = qgVar.n;
                this.w = qgVar.qg;
                this.q = motionEvent;
                iWm = this.fs.wm();
                if (iWm > 0) {
                    this.cp.sendEmptyMessageDelayed(1, iWm);
                }
            }
        } else if (actionMasked == 1) {
            qgVar2 = this.d.get(Integer.valueOf(pointerId));
            if (qgVar2 != null && !qgVar2.w) {
                n(qgVar2, qgVar2.q - qgVar2.n, qgVar2.l - qgVar2.qg, System.currentTimeMillis() - qgVar2.s, qgVar2.q, qgVar2.l, motionEvent, true);
            }
            this.d.remove(Integer.valueOf(pointerId));
            if (actionMasked == 1) {
                this.cp.removeMessages(1);
                if (this.x && this.d.isEmpty()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.tj.n(this);
                }
                this.d.clear();
                this.x = false;
            }
        } else if (actionMasked == 2) {
            boolean z2 = false;
            for (int i = 0; i < motionEvent.getPointerCount(); i++) {
                qg qgVar3 = this.d.get(Integer.valueOf(motionEvent.getPointerId(i)));
                if (qgVar3 != null && !qgVar3.w) {
                    float x = motionEvent.getX(i);
                    float y = motionEvent.getY(i);
                    qgVar3.q = x;
                    qgVar3.l = y;
                    qgVar3.x = motionEvent;
                    if (n(qgVar3, x - qgVar3.n, y - qgVar3.qg, System.currentTimeMillis() - qgVar3.s, x, y, motionEvent, false)) {
                        z2 = true;
                    }
                }
            }
            if (motionEvent.getPointerCount() > 0) {
                this.l = motionEvent.getX(0);
                this.w = motionEvent.getY(0);
                this.q = motionEvent;
            }
            if (z2) {
                this.x = true;
            }
        } else if (actionMasked == 3) {
            if (motionEvent.getRawX() == 0.0f && motionEvent.getRawY() == 0.0f) {
                this.cp.removeMessages(1);
                if (rv.qg().nm() && !this.x && n(0.0f - this.n, 0.0f - this.qg, this.fs.cd(), s.s(getContext(), this.fs.um())) && (nVar = this.rv) != null) {
                    nVar.n(this, n((byte) 7, this.s, this.n, this.qg, -1.0f, -1.0f));
                }
            }
            this.cp.removeMessages(1);
            this.d.clear();
            this.x = false;
        } else if (actionMasked == 5) {
            qgVar = new qg(motionEvent.getX(actionIndex), motionEvent.getY(actionIndex), System.currentTimeMillis(), motionEvent);
            this.d.put(Integer.valueOf(pointerId), qgVar);
            if (actionMasked == 0) {
                this.n = qgVar.n;
                this.qg = qgVar.qg;
                this.s = qgVar.s;
                this.l = qgVar.n;
                this.w = qgVar.qg;
                this.q = motionEvent;
                iWm = this.fs.wm();
                if (iWm > 0) {
                    this.cp.sendEmptyMessageDelayed(1, iWm);
                }
            }
        } else if (actionMasked == 6) {
            qgVar2 = this.d.get(Integer.valueOf(pointerId));
            if (qgVar2 != null) {
                n(qgVar2, qgVar2.q - qgVar2.n, qgVar2.l - qgVar2.qg, System.currentTimeMillis() - qgVar2.s, qgVar2.q, qgVar2.l, motionEvent, true);
            }
            this.d.remove(Integer.valueOf(pointerId));
            if (actionMasked == 1) {
                this.cp.removeMessages(1);
                if (this.x) {
                    z = false;
                } else {
                    z = false;
                }
                if (z) {
                    this.tj.n(this);
                }
                this.d.clear();
                this.x = false;
            }
        }
        return !this.x;
    }

    private boolean n(qg qgVar, float f, float f2, long j, float f3, float f4, MotionEvent motionEvent, boolean z) {
        int iCd = this.fs.cd();
        int iS = s.s(getContext(), this.fs.um());
        int iWm = this.fs.wm();
        int iS2 = s.s(getContext(), this.fs.m());
        if ((z || this.fs.ou() == 1) && !qgVar.w) {
            if (n(f, f2, iCd, iS)) {
                qgVar.w = true;
                n nVar = this.rv;
                if (nVar != null) {
                    nVar.n(this, n((byte) 2, qgVar.s, qgVar.n, qgVar.qg, f3, f4));
                }
                return true;
            }
        }
        if (qgVar.w || !n(f, f2, j, iWm, iS2)) {
            return false;
        }
        qgVar.w = true;
        n nVar2 = this.rv;
        if (nVar2 != null) {
            nVar2.n(this, n((byte) 5, qgVar.s, qgVar.n, qgVar.qg, f3, f4));
        }
        return true;
    }

    private boolean n(float f, float f2, long j, int i, int i2) {
        if (i <= 0 || j < i) {
            return false;
        }
        float f3 = i2;
        return Math.abs(f) <= f3 && Math.abs(f2) <= f3;
    }

    private tj n(byte b, long j, float f, float f2, float f3, float f4) {
        tj tjVar = new tj();
        tjVar.n(b);
        tjVar.n(4);
        tjVar.qg(false);
        tjVar.n(j);
        tjVar.qg(System.currentTimeMillis());
        tjVar.n(f);
        tjVar.qg(f2);
        tjVar.s(f3);
        tjVar.q(f4);
        return tjVar;
    }

    @Override // com.byazt.vf.wo.n
    public void n(Message message) {
        if (rv.qg().kn()) {
            Iterator<Map.Entry<Integer, qg>> it = this.d.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                qg value = it.next().getValue();
                if (value != null && !value.w && n(value.q - value.n, value.l - value.qg, System.currentTimeMillis() - value.s, this.fs.wm(), s.s(getContext(), this.fs.m()))) {
                    value.w = true;
                    n nVar = this.rv;
                    if (nVar != null) {
                        nVar.n(this, n((byte) 5, value.s, value.n, value.qg, value.q, value.l));
                    }
                    z = true;
                }
            }
            if (z) {
                this.x = true;
                return;
            }
            return;
        }
        if (!n(this.l - this.n, this.w - this.qg, System.currentTimeMillis() - this.s, this.fs.wm(), s.s(getContext(), this.fs.m())) || this.x) {
            return;
        }
        this.x = true;
        n nVar2 = this.rv;
        if (nVar2 != null) {
            nVar2.n(this, n((byte) 5, this.s, this.n, this.qg, this.l, this.w));
        }
    }

    public void n() {
        this.cp.removeMessages(1);
        this.d.clear();
    }
}
