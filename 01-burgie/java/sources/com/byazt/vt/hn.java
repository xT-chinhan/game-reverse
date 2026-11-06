package com.byazt.vt;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 170, 20})
public class hn implements com.byazt.at.hn, com.byazt.at.pr {
    public final Map<String, hw> pr = new HashMap();

    @com.byazt.vzx.pr(pr = {0, 1, 170, 506})
    private static class hw {
        public String aj;
        public int c;
        public boolean fw;
        public boolean g;
        public int hn;
        public final Map<String, pr> ho;
        public float hw;
        public int k;
        public boolean m;
        public float pr;
        public long uc;
        public int vk;
        public boolean w;
        public AtomicInteger x;
        public int zo;

        private hw() {
            this.hn = 0;
            this.x = new AtomicInteger(Integer.MAX_VALUE);
            this.c = Integer.MAX_VALUE;
            this.uc = -1L;
            this.fw = true;
            this.zo = 0;
            this.aj = "up";
            this.vk = 0;
            this.w = false;
            this.k = -1;
            this.m = false;
            this.g = true;
            this.ho = new HashMap();
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 170, 116})
    private static class pr {
        public boolean hn;
        public float hw;
        public float pr;

        private pr() {
        }
    }

    @Override // com.byazt.at.hn
    public boolean hw(String str) {
        return "slide".equals(str);
    }

    @Override // com.byazt.at.hn
    public boolean pr(String str, String str2, int i, Map<String, Object> map, Map<String, Object> map2, com.byazt.dd.c cVar) {
        hw hwVar;
        String strPr = com.byazt.at.hw.pr(str, i);
        hw hwVar2 = this.pr.get(strPr);
        if (hwVar2 != null) {
            hwVar = hwVar2;
        } else {
            hw hwVar3 = new hw();
            this.pr.put(strPr, hwVar3);
            hwVar = hwVar3;
        }
        pr(hwVar, map);
        hwVar.g = com.byazt.vt.pr.hn(map2);
        long jX = com.byazt.vt.pr.x(map2);
        if (jX > 0) {
            hwVar.uc = jX;
        } else if (hwVar.uc <= 0) {
            hwVar.uc = System.currentTimeMillis();
        }
        MotionEvent motionEventPr = com.byazt.vt.pr.pr(map2);
        if (motionEventPr == null) {
            return false;
        }
        pr(hwVar);
        View viewHw = com.byazt.vt.pr.hw(map2);
        if (hwVar.w) {
            return x(hwVar, motionEventPr, viewHw, str, i, cVar);
        }
        return pr(hwVar, motionEventPr, viewHw, str, i, cVar);
    }

    private static void pr(hw hwVar, Map<String, Object> map) {
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
        hwVar.aj = str;
        Object obj4 = map.get("distance");
        boolean zBooleanValue = false;
        if (obj4 != null) {
            hwVar.hn = com.byazt.aa.hn.pr(String.valueOf(obj4), 0);
        } else {
            hwVar.hn = 0;
        }
        if (hwVar.x.get() == Integer.MAX_VALUE && (obj2 = map.get("frequency")) != null) {
            hwVar.x.set(com.byazt.aa.hn.pr(String.valueOf(obj2), Integer.MAX_VALUE));
        }
        if (hwVar.c == Integer.MAX_VALUE && (obj = map.get("effectiveDuration")) != null) {
            hwVar.c = com.byazt.aa.hn.pr(String.valueOf(obj), Integer.MAX_VALUE);
        }
        Object obj5 = map.get("inView");
        if (obj5 != null) {
            hwVar.zo = com.byazt.aa.hn.pr(String.valueOf(obj5), 0);
        }
        Object obj6 = map.get("ignoreUp");
        if (obj6 != null) {
            hwVar.vk = com.byazt.aa.hn.pr(String.valueOf(obj6), 0);
        }
        Object obj7 = map.get("adaptTwoFinger");
        if (obj7 != null) {
            if (!(obj7 instanceof Boolean)) {
                if (com.byazt.aa.hn.pr(String.valueOf(obj7), 0) == 1) {
                    zBooleanValue = true;
                }
            } else {
                zBooleanValue = ((Boolean) obj7).booleanValue();
            }
            hwVar.w = zBooleanValue;
        }
        Object obj8 = map.get("slideMinThreshold");
        if (obj8 != null) {
            hwVar.k = com.byazt.aa.hn.pr(String.valueOf(obj8), -1);
        }
    }

    private static void pr(hw hwVar) {
        if (hwVar.c != Integer.MAX_VALUE && System.currentTimeMillis() - hwVar.uc >= hwVar.c) {
            hwVar.fw = false;
        }
    }

    private boolean pr(hw hwVar, MotionEvent motionEvent, View view, String str, int i, com.byazt.dd.c cVar) {
        switch (motionEvent.getAction()) {
            case 0:
                hwVar.m = false;
                hwVar.pr = motionEvent.getX();
                hwVar.hw = motionEvent.getY();
                return true;
            case 1:
                break;
            case 2:
                return hw(hwVar, motionEvent, view, str, i, cVar);
            case 3:
                if (motionEvent.getRawX() == 0.0f && motionEvent.getRawY() == 0.0f) {
                    return true;
                }
                break;
            default:
                return true;
        }
        return hn(hwVar, motionEvent, view, str, i, cVar);
    }

    private boolean hw(hw hwVar, MotionEvent motionEvent, View view, String str, int i, com.byazt.dd.c cVar) {
        if (hwVar.vk != 1 || hwVar.m) {
            return true;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (!pr(hwVar, x, y, hwVar.pr, hwVar.hw)) {
            return true;
        }
        hwVar.pr = 0.0f;
        hwVar.hw = 0.0f;
        return pr(hwVar, view, x, y, str, i, cVar);
    }

    private boolean hn(hw hwVar, MotionEvent motionEvent, View view, String str, int i, com.byazt.dd.c cVar) {
        if (hwVar.m) {
            return true;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (hwVar.hn == 0) {
            hwVar.pr = 0.0f;
            hwVar.hw = 0.0f;
            return pr(hwVar, view, x, y, str, i, cVar);
        }
        if (!pr(hwVar, x, y, hwVar.pr, hwVar.hw)) {
            return false;
        }
        hwVar.pr = 0.0f;
        hwVar.hw = 0.0f;
        return pr(hwVar, view, x, y, str, i, cVar);
    }

    private boolean x(hw hwVar, MotionEvent motionEvent, View view, String str, int i, com.byazt.dd.c cVar) {
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        String strPr = pr(pointerId, i);
        motionEvent.getPointerCount();
        switch (actionMasked) {
            case 0:
                hwVar.m = false;
                break;
            case 1:
            case 6:
                return pr(hwVar, motionEvent, view, actionIndex, pointerId, strPr, str, i, cVar);
            case 2:
                return pr(hwVar, motionEvent, view, i, str, cVar);
            case 3:
                hwVar.ho.clear();
                return true;
            case 4:
            default:
                return true;
            case 5:
                break;
        }
        pr(hwVar, motionEvent, actionIndex, strPr);
        return true;
    }

    private static void pr(hw hwVar, MotionEvent motionEvent, int i, String str) {
        pr prVar = new pr();
        prVar.pr = motionEvent.getX(i);
        prVar.hw = motionEvent.getY(i);
        hwVar.ho.put(str, prVar);
    }

    private boolean pr(hw hwVar, MotionEvent motionEvent, View view, int i, String str, com.byazt.dd.c cVar) {
        if (hwVar.vk != 1) {
            return true;
        }
        for (int i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
            pr prVar = hwVar.ho.get(pr(motionEvent.getPointerId(i2), i));
            if (prVar != null && !prVar.hn && !hwVar.m) {
                float x = motionEvent.getX(i2);
                float y = motionEvent.getY(i2);
                if (pr(hwVar, x, y, prVar.pr, prVar.hw)) {
                    prVar.hn = true;
                    pr(hwVar, view, x, y, str, i, cVar);
                    return true;
                }
            }
        }
        return true;
    }

    private boolean pr(hw hwVar, MotionEvent motionEvent, View view, int i, int i2, String str, String str2, int i3, com.byazt.dd.c cVar) {
        pr prVar = hwVar.ho.get(str);
        if (prVar == null) {
            hwVar.ho.remove(str);
            return false;
        }
        try {
            if (!prVar.hn && !hwVar.m) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                if (hwVar.hn == 0) {
                    prVar.hn = true;
                    pr(hwVar, view, x, y, str2, i3, cVar);
                    return true;
                }
                if (!pr(hwVar, x, y, prVar.pr, prVar.hw)) {
                    return false;
                }
                prVar.hn = true;
                pr(hwVar, view, x, y, str2, i3, cVar);
                return true;
            }
            return true;
        } finally {
            hwVar.ho.remove(str);
        }
    }

    private static String pr(int i, int i2) {
        return i + "_" + i2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x0048  */
    private boolean pr(hw hwVar, float f, float f2, float f3, float f4) {
        int iPr = pr(f - f3);
        int iPr2 = pr(f2 - f4);
        switch (hwVar.aj) {
            case "up":
                iPr = -iPr2;
                break;
            case "down":
                iPr = iPr2;
                break;
            case "left":
                iPr = -iPr;
                break;
            case "right":
                break;
            case "all":
            default:
                iPr = (int) Math.abs(Math.sqrt(Math.pow(iPr, 2.0d) + Math.pow(iPr2, 2.0d)));
                break;
        }
        if (hwVar.k >= 0) {
            return iPr >= hwVar.k;
        }
        return iPr >= hwVar.hn;
    }

    private boolean pr(hw hwVar, View view, float f, float f2, String str, int i, com.byazt.dd.c cVar) {
        if (hwVar.x.get() <= 0 || !hwVar.fw) {
            return false;
        }
        if (hwVar.zo == 1 && (!pr(view, f, f2) || !hwVar.g)) {
            return false;
        }
        hwVar.m = true;
        if (hwVar.x.get() != Integer.MAX_VALUE) {
            hwVar.x.decrementAndGet();
        }
        if (cVar != null) {
            cVar.pr();
        }
        return true;
    }

    private static boolean pr(View view, float f, float f2) {
        if (view == null) {
            return true;
        }
        return f >= 0.0f && f < ((float) view.getWidth()) && f2 >= 0.0f && f2 < ((float) view.getHeight());
    }

    private static int pr(float f) {
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        if (f2 <= 0.0f) {
            f2 = 1.0f;
        }
        return (int) ((f / f2) + 0.5f);
    }

    @Override // com.byazt.at.pr
    public void pr(String str) {
        String strPr = com.byazt.at.hw.pr(str);
        Iterator<Map.Entry<String, hw>> it = this.pr.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, hw> next = it.next();
            if (next.getKey() != null && next.getKey().startsWith(strPr)) {
                if (next.getValue() != null) {
                    next.getValue().ho.clear();
                }
                it.remove();
            }
        }
    }
}
