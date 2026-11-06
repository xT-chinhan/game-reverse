package com.bytedance.sdk.openadsdk.core.jw;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final int f2724ms = com.bytedance.sdk.component.utils.t.c(com.bytedance.sdk.openadsdk.core.re.getContext(), "tt_shake_tag_key");
    private static final ConcurrentHashMap<ViewGroup, Object> xr = new ConcurrentHashMap<>();
    private static final Object ah = new Object();
    private static volatile boolean d = false;

    private p() {
    }

    public static void ms(WeakReference<ViewGroup> weakReference, com.bytedance.sdk.openadsdk.core.xr.ah ahVar) {
        if (weakReference == null || ahVar == null) {
            return;
        }
        ViewGroup viewGroup = weakReference.get();
        if (!com.bytedance.sdk.openadsdk.core.f.ms(viewGroup)) {
            ms(viewGroup, false);
            return;
        }
        xr.put(viewGroup, ahVar);
        if (d) {
            ms(viewGroup, false);
            return;
        }
        synchronized (p.class) {
            if (d) {
                ms(viewGroup, false);
            } else {
                d = true;
                com.bytedance.sdk.openadsdk.core.nw.c().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jw.p.1
                    @Override // java.lang.Runnable
                    public void run() {
                        p.ah();
                    }
                }, 50L);
            }
        }
    }

    public static boolean ms(View view) {
        if (view == null) {
            return false;
        }
        Object tag = view.getTag(f2724ms);
        if (tag instanceof Map) {
            Object obj = ((Map) tag).get("is_shake_efficient");
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
        }
        return false;
    }

    private static void ms(ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("is_shake_efficient", Boolean.valueOf(z));
        int i = f2724ms;
        Object tag = viewGroup.getTag(i);
        if (tag != null) {
            try {
                if (!(tag instanceof HashMap)) {
                    return;
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.sl.d("TTShakeChecker", th.getMessage());
                ms(f2724ms, th.getMessage());
                return;
            }
        }
        viewGroup.setTag(i, map);
    }

    public static void ms(final int i, final String str) {
        com.bytedance.sdk.openadsdk.core.t.xr.ah().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.jw.p.2
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("shake_tag", i);
                    jSONObject.put("error_msg", str);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("stats_shake_tag_key").xr(jSONObject.toString());
            }
        }, "stats_shake_tag_key", false);
    }

    public static void ms(WeakReference<ViewGroup> weakReference, float f, float f2, long j) {
        if (weakReference == null) {
            return;
        }
        ViewGroup viewGroup = weakReference.get();
        if (com.bytedance.sdk.openadsdk.core.f.ms(viewGroup) && ms(f, f2, j)) {
            xr.put(viewGroup, ah);
            if (d) {
                return;
            }
            synchronized (p.class) {
                if (d) {
                    return;
                }
                d = true;
                com.bytedance.sdk.openadsdk.core.nw.c().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jw.p.3
                    @Override // java.lang.Runnable
                    public void run() {
                        p.d();
                    }
                }, 50L);
            }
        }
    }

    private static boolean ms(float f, float f2, long j) {
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
    public static void ah() {
        ConcurrentHashMap<ViewGroup, Object> concurrentHashMap = xr;
        if (concurrentHashMap.isEmpty()) {
            return;
        }
        int iKa = ul.ka(com.bytedance.sdk.openadsdk.core.re.getContext());
        int i = Integer.MAX_VALUE;
        ViewGroup viewGroup = null;
        ViewGroup viewGroup2 = null;
        for (ViewGroup viewGroup3 : concurrentHashMap.keySet()) {
            if (viewGroup3 != null) {
                Rect rect = new Rect();
                if (!viewGroup3.getGlobalVisibleRect(rect)) {
                    xr.remove(viewGroup3);
                } else if (!com.bytedance.sdk.openadsdk.core.f.ms(viewGroup3)) {
                    xr.remove(viewGroup3);
                } else {
                    int i2 = iKa / 2;
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
        ConcurrentHashMap<ViewGroup, Object> concurrentHashMap2 = xr;
        com.bytedance.sdk.openadsdk.core.xr.ah ahVar = concurrentHashMap2.get(viewGroup2) instanceof com.bytedance.sdk.openadsdk.core.xr.ah ? (com.bytedance.sdk.openadsdk.core.xr.ah) concurrentHashMap2.get(viewGroup2) : null;
        ms(viewGroup2, true);
        concurrentHashMap2.clear();
        d = false;
        if (ahVar != null) {
            ahVar.ms();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:40:0x0094  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ba  */
    public static void d() {
        com.bytedance.sdk.openadsdk.core.xr.ms msVar;
        ConcurrentHashMap<ViewGroup, Object> concurrentHashMap = xr;
        if (concurrentHashMap.isEmpty()) {
            return;
        }
        int iKa = ul.ka(com.bytedance.sdk.openadsdk.core.re.getContext());
        int i = Integer.MAX_VALUE;
        ViewGroup viewGroup = null;
        ViewGroup viewGroup2 = null;
        for (ViewGroup viewGroup3 : concurrentHashMap.keySet()) {
            if (viewGroup3 != null) {
                Rect rect = new Rect();
                if (!viewGroup3.getGlobalVisibleRect(rect)) {
                    xr.remove(viewGroup3);
                } else if (!com.bytedance.sdk.openadsdk.core.f.ms(viewGroup3)) {
                    xr.remove(viewGroup3);
                } else {
                    int i2 = iKa / 2;
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
            Object tag = viewGroup2.getChildAt(i5).getTag(f2724ms);
            if (tag instanceof Map) {
                Object obj = ((Map) tag).get("click_listener");
                if (obj instanceof com.bytedance.sdk.openadsdk.core.xr.ms) {
                    msVar = (com.bytedance.sdk.openadsdk.core.xr.ms) obj;
                } else {
                    msVar = null;
                }
            } else {
                msVar = null;
            }
            if (msVar != null) {
                HashMap map = new HashMap();
                map.put("click_type", 2);
                com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms msVar2 = (com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) msVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class);
                msVar2.ms(map);
                msVar2.ms();
                msVar.onClick(viewGroup2);
                break;
            }
        }
        xr.clear();
        d = false;
    }
}
