package com.byazt.cd;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.nf.rv;
import com.byazt.tk.k;
import com.byazt.vyf.l;
import com.byazt.ys.q;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 86, 26})
public final class qg {
    public static final ConcurrentHashMap<ViewGroup, Object> n = new ConcurrentHashMap<>();
    public static final Object qg = new Object();
    public static volatile boolean s = false;

    private qg() {
    }

    public static void n(WeakReference<ViewGroup> weakReference, q qVar) {
        if (weakReference == null || qVar == null) {
            return;
        }
        ViewGroup viewGroup = weakReference.get();
        if (!com.byazt.okk.q.n(viewGroup)) {
            n(viewGroup, false);
            return;
        }
        n.put(viewGroup, qVar);
        if (s) {
            n(viewGroup, false);
            return;
        }
        synchronized (qg.class) {
            if (s) {
                n(viewGroup, false);
            } else {
                s = true;
                l.q().postDelayed(new Runnable() { // from class: com.byazt.cd.qg.1
                    @Override // java.lang.Runnable
                    public void run() {
                        qg.s();
                    }
                }, 50L);
            }
        }
    }

    public static boolean n(View view) {
        if (view == null) {
            return false;
        }
        Object tag = view.getTag(2114387349);
        if (tag instanceof Map) {
            Object obj = ((Map) tag).get("is_shake_efficient");
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
        }
        return false;
    }

    private static void n(ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("is_shake_efficient", Boolean.valueOf(z));
        Object tag = viewGroup.getTag(2114387349);
        if (tag != null) {
            try {
                if (!(tag instanceof HashMap)) {
                    return;
                }
            } catch (Throwable th) {
                k.qg("TTShakeChecker", th.getMessage());
                n(2114387349, th.getMessage());
                return;
            }
        }
        viewGroup.setTag(2114387349, map);
    }

    public static void n(final int i, final String str) {
        com.byazt.eji.s.n().n("stats_shake_tag_key", new com.byazt.rs.n() { // from class: com.byazt.cd.qg.2
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("shake_tag", i);
                    jSONObject2.put("error_msg", str);
                } catch (Throwable unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void n(WeakReference<ViewGroup> weakReference, float f, float f2, long j) {
        if (weakReference == null) {
            return;
        }
        ViewGroup viewGroup = weakReference.get();
        if (com.byazt.okk.q.n(viewGroup) && n(f, f2, j)) {
            n.put(viewGroup, qg);
            if (s) {
                return;
            }
            synchronized (qg.class) {
                if (s) {
                    return;
                }
                s = true;
                l.q().postDelayed(new Runnable() { // from class: com.byazt.cd.qg.3
                    @Override // java.lang.Runnable
                    public void run() {
                        qg.q();
                    }
                }, 50L);
            }
        }
    }

    private static boolean n(float f, float f2, long j) {
        if (f == -1.0f) {
            return true;
        }
        if (f < 0.0f) {
            return false;
        }
        if (f == 0.0f && f2 == 2.1474836E9f) {
            return true;
        }
        if (f2 <= f) {
            return false;
        }
        float fCurrentTimeMillis = (System.currentTimeMillis() - j) / 1000.0f;
        return fCurrentTimeMillis >= f && fCurrentTimeMillis <= f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:40:0x0093  */
    public static void s() {
        ConcurrentHashMap<ViewGroup, Object> concurrentHashMap = n;
        if (concurrentHashMap.isEmpty()) {
            return;
        }
        int iW = com.byazt.okk.s.w(rv.getContext());
        int i = Integer.MAX_VALUE;
        ViewGroup viewGroup = null;
        ViewGroup viewGroup2 = null;
        for (ViewGroup viewGroup3 : concurrentHashMap.keySet()) {
            if (viewGroup3 != null) {
                Rect rect = new Rect();
                if (!viewGroup3.getGlobalVisibleRect(rect)) {
                    n.remove(viewGroup3);
                } else if (!com.byazt.okk.q.n(viewGroup3)) {
                    n.remove(viewGroup3);
                } else {
                    int i2 = iW / 2;
                    int i3 = rect.bottom <= i2 ? i2 - rect.bottom : Integer.MAX_VALUE;
                    int i4 = rect.top >= i2 ? rect.top - i2 : Integer.MAX_VALUE;
                    if (rect.bottom > i2 && rect.top < i2) {
                        viewGroup = viewGroup3;
                        break;
                    }
                    int iMin = Math.min(i4, i3);
                    if (iMin < i) {
                        viewGroup = viewGroup3;
                        i = iMin;
                    } else if (iMin == i) {
                        viewGroup2 = viewGroup3;
                    }
                }
            }
        }
        if (viewGroup == null) {
            return;
        }
        if (viewGroup2 != null) {
            Rect rect2 = new Rect();
            viewGroup.getGlobalVisibleRect(rect2);
            Rect rect3 = new Rect();
            viewGroup2.getGlobalVisibleRect(rect3);
            if (rect2.top >= rect3.top) {
                viewGroup2 = viewGroup;
            }
        } else {
            viewGroup2 = viewGroup;
        }
        ConcurrentHashMap<ViewGroup, Object> concurrentHashMap2 = n;
        q qVar = concurrentHashMap2.get(viewGroup2) instanceof q ? (q) concurrentHashMap2.get(viewGroup2) : null;
        n(viewGroup2, true);
        concurrentHashMap2.clear();
        s = false;
        if (qVar != null) {
            qVar.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:40:0x0094  */
    /* JADX WARN: Code duplicated, block: B:49:0x00bb  */
    public static void q() {
        com.byazt.ys.n nVar;
        ConcurrentHashMap<ViewGroup, Object> concurrentHashMap = n;
        if (concurrentHashMap.isEmpty()) {
            return;
        }
        int iW = com.byazt.okk.s.w(rv.getContext());
        int i = Integer.MAX_VALUE;
        ViewGroup viewGroup = null;
        ViewGroup viewGroup2 = null;
        for (ViewGroup viewGroup3 : concurrentHashMap.keySet()) {
            if (viewGroup3 != null) {
                Rect rect = new Rect();
                if (!viewGroup3.getGlobalVisibleRect(rect)) {
                    n.remove(viewGroup3);
                } else if (!com.byazt.okk.q.n(viewGroup3)) {
                    n.remove(viewGroup3);
                } else {
                    int i2 = iW / 2;
                    int i3 = rect.bottom <= i2 ? i2 - rect.bottom : Integer.MAX_VALUE;
                    int i4 = rect.top >= i2 ? rect.top - i2 : Integer.MAX_VALUE;
                    if (rect.bottom > i2 && rect.top < i2) {
                        viewGroup = viewGroup3;
                        break;
                    }
                    int iMin = Math.min(i4, i3);
                    if (iMin < i) {
                        viewGroup = viewGroup3;
                        i = iMin;
                    } else if (iMin == i) {
                        viewGroup2 = viewGroup3;
                    }
                }
            }
        }
        if (viewGroup == null) {
            return;
        }
        if (viewGroup2 != null) {
            Rect rect2 = new Rect();
            viewGroup.getGlobalVisibleRect(rect2);
            Rect rect3 = new Rect();
            viewGroup2.getGlobalVisibleRect(rect3);
            if (rect2.top >= rect3.top) {
                viewGroup2 = viewGroup;
            }
        } else {
            viewGroup2 = viewGroup;
        }
        for (int i5 = 0; i5 < viewGroup2.getChildCount(); i5++) {
            Object tag = viewGroup2.getChildAt(i5).getTag(2114387349);
            if (tag instanceof Map) {
                Object obj = ((Map) tag).get("click_listener");
                if (obj instanceof com.byazt.ys.n) {
                    nVar = (com.byazt.ys.n) obj;
                } else {
                    nVar = null;
                }
            } else {
                nVar = null;
            }
            if (nVar != null) {
                HashMap map = new HashMap();
                map.put("click_type", 2);
                com.byazt.fq.n nVar2 = (com.byazt.fq.n) nVar.n(com.byazt.fq.n.class);
                nVar2.n(map);
                nVar2.n();
                nVar.onClick(viewGroup2);
                break;
            }
        }
        n.clear();
        s = false;
    }
}
