package com.byazt.pk;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 36, 8})
public class s implements com.byazt.sx.n, com.byazt.sx.s {
    public final Map<String, qg> n = new HashMap();

    @com.byazt.cp.n(n = {0, 1, 36, 782})
    private static class qg {
        public boolean cp;
        public int d;
        public int fs;
        public final Map<String, n> k;
        public int l;
        public float n;
        public boolean oa;
        public AtomicInteger q;
        public float qg;
        public String rv;
        public int s;
        public boolean sz;
        public int tj;
        public long w;
        public boolean x;

        private qg() {
            this.s = 0;
            this.q = new AtomicInteger(Integer.MAX_VALUE);
            this.l = Integer.MAX_VALUE;
            this.w = -1L;
            this.x = true;
            this.fs = 0;
            this.rv = "up";
            this.tj = 0;
            this.cp = false;
            this.d = -1;
            this.oa = false;
            this.sz = true;
            this.k = new HashMap();
        }
    }

    @com.byazt.cp.n(n = {0, 1, 36, 546})
    private static class n {
        public float n;
        public float qg;
        public boolean s;

        private n() {
        }
    }

    @Override // com.byazt.sx.s
    public boolean qg(String str) {
        return "slide".equals(str);
    }

    @Override // com.byazt.sx.s
    public boolean n(String str, String str2, int i, Map<String, Object> map, Map<String, Object> map2, com.byazt.xz.l lVar) {
        String strN = com.byazt.sx.qg.n(str, i);
        qg qgVar = this.n.get(strN);
        if (qgVar == null) {
            qgVar = new qg();
            this.n.put(strN, qgVar);
        }
        qg qgVar2 = qgVar;
        n(qgVar2, map);
        qgVar2.sz = com.byazt.pk.n.s(map2);
        long jQ = com.byazt.pk.n.q(map2);
        if (jQ > 0) {
            qgVar2.w = jQ;
        } else if (qgVar2.w <= 0) {
            qgVar2.w = System.currentTimeMillis();
        }
        MotionEvent motionEventN = com.byazt.pk.n.n(map2);
        if (motionEventN == null) {
            return false;
        }
        n(qgVar2);
        View viewQg = com.byazt.pk.n.qg(map2);
        if (qgVar2.cp) {
            return q(qgVar2, motionEventN, viewQg, str, i, lVar);
        }
        return n(qgVar2, motionEventN, viewQg, str, i, lVar);
    }

    private static void n(qg qgVar, Map<String, Object> map) {
        Object obj;
        Object obj2;
        if (map == null) {
            return;
        }
        Object obj3 = map.get("direction");
        String str = "all";
        if (obj3 != null) {
            String strValueOf = String.valueOf(obj3);
            if (!TextUtils.isEmpty(strValueOf)) {
                str = strValueOf;
            }
        }
        qgVar.rv = str;
        Object obj4 = map.get("distance");
        boolean zBooleanValue = false;
        if (obj4 == null) {
            qgVar.s = 0;
        } else {
            qgVar.s = com.byazt.hb.s.n(String.valueOf(obj4), 0);
        }
        if (qgVar.q.get() == Integer.MAX_VALUE && (obj2 = map.get("frequency")) != null) {
            qgVar.q.set(com.byazt.hb.s.n(String.valueOf(obj2), Integer.MAX_VALUE));
        }
        if (qgVar.l == Integer.MAX_VALUE && (obj = map.get("effectiveDuration")) != null) {
            qgVar.l = com.byazt.hb.s.n(String.valueOf(obj), Integer.MAX_VALUE);
        }
        Object obj5 = map.get("inView");
        if (obj5 != null) {
            qgVar.fs = com.byazt.hb.s.n(String.valueOf(obj5), 0);
        }
        Object obj6 = map.get("ignoreUp");
        if (obj6 != null) {
            qgVar.tj = com.byazt.hb.s.n(String.valueOf(obj6), 0);
        }
        Object obj7 = map.get("adaptTwoFinger");
        if (obj7 != null) {
            if (obj7 instanceof Boolean) {
                zBooleanValue = ((Boolean) obj7).booleanValue();
            } else if (com.byazt.hb.s.n(String.valueOf(obj7), 0) == 1) {
                zBooleanValue = true;
            }
            qgVar.cp = zBooleanValue;
        }
        Object obj8 = map.get("slideMinThreshold");
        if (obj8 != null) {
            qgVar.d = com.byazt.hb.s.n(String.valueOf(obj8), -1);
        }
    }

    private static void n(qg qgVar) {
        if (qgVar.l != Integer.MAX_VALUE && System.currentTimeMillis() - qgVar.w >= qgVar.l) {
            qgVar.x = false;
        }
    }

    private boolean n(qg qgVar, MotionEvent motionEvent, View view, String str, int i, com.byazt.xz.l lVar) {
        int action = motionEvent.getAction();
        if (action == 0) {
            qgVar.oa = false;
            qgVar.n = motionEvent.getX();
            qgVar.qg = motionEvent.getY();
            return true;
        }
        if (action != 1) {
            if (action == 2) {
                return qg(qgVar, motionEvent, view, str, i, lVar);
            }
            if (action != 3) {
                return true;
            }
            if (motionEvent.getRawX() == 0.0f && motionEvent.getRawY() == 0.0f) {
                return true;
            }
        }
        return s(qgVar, motionEvent, view, str, i, lVar);
    }

    private boolean qg(qg qgVar, MotionEvent motionEvent, View view, String str, int i, com.byazt.xz.l lVar) {
        if (qgVar.tj != 1 || qgVar.oa) {
            return true;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (!n(qgVar, x, y, qgVar.n, qgVar.qg)) {
            return true;
        }
        qgVar.n = 0.0f;
        qgVar.qg = 0.0f;
        return n(qgVar, view, x, y, str, i, lVar);
    }

    private boolean s(qg qgVar, MotionEvent motionEvent, View view, String str, int i, com.byazt.xz.l lVar) {
        if (qgVar.oa) {
            return true;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (qgVar.s == 0) {
            qgVar.n = 0.0f;
            qgVar.qg = 0.0f;
            return n(qgVar, view, x, y, str, i, lVar);
        }
        if (!n(qgVar, x, y, qgVar.n, qgVar.qg)) {
            return false;
        }
        qgVar.n = 0.0f;
        qgVar.qg = 0.0f;
        return n(qgVar, view, x, y, str, i, lVar);
    }

    private boolean q(qg qgVar, MotionEvent motionEvent, View view, String str, int i, com.byazt.xz.l lVar) {
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        String strN = n(pointerId, i);
        motionEvent.getPointerCount();
        if (actionMasked == 0) {
            qgVar.oa = false;
        } else {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    return n(qgVar, motionEvent, view, i, str, lVar);
                }
                if (actionMasked == 3) {
                    qgVar.k.clear();
                    return true;
                }
                if (actionMasked != 5) {
                    if (actionMasked != 6) {
                        return true;
                    }
                }
            }
            return n(qgVar, motionEvent, view, actionIndex, pointerId, strN, str, i, lVar);
        }
        n(qgVar, motionEvent, actionIndex, strN);
        return true;
    }

    private static void n(qg qgVar, MotionEvent motionEvent, int i, String str) {
        n nVar = new n();
        nVar.n = motionEvent.getX(i);
        nVar.qg = motionEvent.getY(i);
        qgVar.k.put(str, nVar);
    }

    private boolean n(qg qgVar, MotionEvent motionEvent, View view, int i, String str, com.byazt.xz.l lVar) {
        if (qgVar.tj != 1) {
            return true;
        }
        for (int i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
            n nVar = qgVar.k.get(n(motionEvent.getPointerId(i2), i));
            if (nVar != null && !nVar.s && !qgVar.oa) {
                float x = motionEvent.getX(i2);
                float y = motionEvent.getY(i2);
                if (n(qgVar, x, y, nVar.n, nVar.qg)) {
                    nVar.s = true;
                    n(qgVar, view, x, y, str, i, lVar);
                    return true;
                }
            }
        }
        return true;
    }

    private boolean n(qg qgVar, MotionEvent motionEvent, View view, int i, int i2, String str, String str2, int i3, com.byazt.xz.l lVar) {
        n nVar = qgVar.k.get(str);
        if (nVar != null) {
            try {
                if (!nVar.s && !qgVar.oa) {
                    float x = motionEvent.getX(i);
                    float y = motionEvent.getY(i);
                    if (qgVar.s == 0 || n(qgVar, x, y, nVar.n, nVar.qg)) {
                        nVar.s = true;
                        n(qgVar, view, x, y, str2, i3, lVar);
                    }
                }
                return true;
            } finally {
                qgVar.k.remove(str);
            }
        }
        return false;
    }

    private static String n(int i, int i2) {
        return i + "_" + i2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x004a  */
    private boolean n(qg qgVar, float f, float f2, float f3, float f4) {
        byte b;
        int iN = n(f - f3);
        int iN2 = n(f2 - f4);
        switch (qgVar.rv) {
            case "up":
                b = 0;
                break;
            case "all":
                b = 4;
                break;
            case "down":
                b = 1;
                break;
            case "left":
                b = 2;
                break;
            case "right":
                b = 3;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            iN = -iN2;
        } else if (b == 1) {
            iN = iN2;
        } else if (b == 2) {
            iN = -iN;
        } else if (b != 3) {
            iN = (int) Math.abs(Math.sqrt(Math.pow(iN, 2.0d) + Math.pow(iN2, 2.0d)));
        }
        if (qgVar.d >= 0) {
            return iN >= qgVar.d;
        }
        return iN >= qgVar.s;
    }

    private boolean n(qg qgVar, View view, float f, float f2, String str, int i, com.byazt.xz.l lVar) {
        if (qgVar.q.get() <= 0 || !qgVar.x) {
            return false;
        }
        if (qgVar.fs == 1 && (!n(view, f, f2) || !qgVar.sz)) {
            return false;
        }
        qgVar.oa = true;
        if (qgVar.q.get() != Integer.MAX_VALUE) {
            qgVar.q.decrementAndGet();
        }
        if (lVar != null) {
            lVar.n();
        }
        return true;
    }

    private static boolean n(View view, float f, float f2) {
        if (view == null) {
            return true;
        }
        return f >= 0.0f && f < ((float) view.getWidth()) && f2 >= 0.0f && f2 < ((float) view.getHeight());
    }

    private static int n(float f) {
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        if (f2 <= 0.0f) {
            f2 = 1.0f;
        }
        return (int) ((f / f2) + 0.5f);
    }

    @Override // com.byazt.sx.n
    public void n(String str, int i) {
        qg qgVarRemove = this.n.remove(com.byazt.sx.qg.n(str, i));
        if (qgVarRemove != null) {
            qgVarRemove.k.clear();
        }
    }

    @Override // com.byazt.sx.n
    public void n(String str) {
        String strN = com.byazt.sx.qg.n(str);
        Iterator<Map.Entry<String, qg>> it = this.n.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, qg> next = it.next();
            if (next.getKey() != null && next.getKey().startsWith(strN)) {
                if (next.getValue() != null) {
                    next.getValue().k.clear();
                }
                it.remove();
            }
        }
    }
}
