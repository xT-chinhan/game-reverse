package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    private com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms ab;
    private final Context ah;
    private com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms ao;
    private EmptyView b;
    private String c;
    private WeakReference<NativeVideoTsView> cv;
    private com.bytedance.sdk.openadsdk.ao.xr.xr.zb d;
    private volatile com.bytedance.sdk.openadsdk.core.xr.xr i;
    private Activity le;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final lm f1990ms;
    private com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ab of;
    private com.bytedance.sdk.openadsdk.core.xr.ms op;
    private com.bytedance.sdk.openadsdk.core.video.nativevideo.ms p;
    private com.bytedance.sdk.component.utils.b qv;
    private View re;
    private WeakReference<ViewGroup> u;
    private View ub;
    private volatile com.bytedance.sdk.openadsdk.core.xr.ms w;
    private long x;
    private volatile com.bytedance.sdk.openadsdk.core.hi.xr.ah xr;
    private com.bytedance.sdk.openadsdk.core.hi.xr.ms y;
    private com.bytedance.sdk.openadsdk.core.xr.ms yu;
    private ViewGroup zb;
    private List<View> ka = new ArrayList();
    private Double ny = null;
    private AtomicBoolean ch = new AtomicBoolean(false);
    private AtomicBoolean hi = new AtomicBoolean(false);
    private AtomicBoolean sl = new AtomicBoolean(false);
    private int h = 5;
    private volatile long t = 0;
    private volatile boolean nw = true;
    private volatile boolean g = false;

    public void ms(com.bytedance.sdk.openadsdk.ao.xr.xr.zb zbVar) {
        this.d = zbVar;
    }

    public b(Context context, com.bytedance.sdk.openadsdk.ao.xr.xr.zb zbVar, lm lmVar, String str) {
        this.c = "embeded_ad";
        this.d = zbVar;
        this.f1990ms = lmVar;
        this.ah = context;
        this.c = str;
    }

    public void ms(Activity activity) {
        this.le = activity;
        if (this.xr != null) {
            this.xr.ms(activity);
        }
    }

    public void ms(View view, int i) {
        com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms msVar = this.ab;
        if (msVar != null) {
            msVar.xr(view, this.d);
        }
    }

    public void ms(NativeExpressView nativeExpressView) {
        if (nativeExpressView != null) {
            if (this.w != null) {
                nativeExpressView.setClickCreativeListener(this.w);
            }
            if (this.i != null) {
                nativeExpressView.setClickListener(this.i);
            }
        }
    }

    public com.bytedance.sdk.openadsdk.core.hi.xr.ah ms() {
        return this.xr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah() {
        lm lmVar = this.f1990ms;
        if (lmVar == null || lmVar.jr() != 4) {
            return;
        }
        if (this.g) {
            d();
        } else {
            this.g = true;
            com.bytedance.sdk.openadsdk.op.ab.ms(new com.bytedance.sdk.component.ch.ny("feed_register_download") { // from class: com.bytedance.sdk.openadsdk.core.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.xr == null) {
                        b bVar = b.this;
                        bVar.xr = com.bytedance.sdk.openadsdk.core.hi.ka.ms(bVar.ah, b.this.f1990ms, b.this.c, false);
                    }
                    b.this.xr.ms(b.this.le);
                    b.this.d();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.xr != null) {
            if (this.i != null) {
                ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.i.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this.xr);
            }
            if (this.w != null) {
                ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.w.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this.xr);
            }
            com.bytedance.sdk.openadsdk.core.xr.ms msVar = this.op;
            if (msVar != null) {
                ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) msVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this.xr);
            }
            com.bytedance.sdk.openadsdk.core.xr.ms msVar2 = this.yu;
            if (msVar2 != null) {
                ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) msVar2.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this.xr);
            }
            try {
                this.xr.ka(false);
                this.xr.ms(this.y);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
            }
        }
    }

    public void ms(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, final com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms msVar, com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms msVar2) {
        EmptyView emptyView;
        this.ab = msVar;
        this.zb = viewGroup;
        this.u = new WeakReference<>(this.zb);
        this.ub = view;
        this.ao = msVar2;
        com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.f1990ms);
        Context context = this.ah;
        lm lmVar = this.f1990ms;
        String str = this.c;
        this.op = new com.bytedance.sdk.openadsdk.core.xr.ms(context, lmVar, str, com.bytedance.sdk.openadsdk.core.jw.f.xr(str));
        ms(viewGroup);
        EmptyView emptyViewAh = ah(viewGroup);
        if (emptyViewAh == null) {
            lm lmVar2 = this.f1990ms;
            EmptyView emptyView2 = new EmptyView(this.ah, viewGroup, lmVar2 != null ? lmVar2.kf() : 1000) { // from class: com.bytedance.sdk.openadsdk.core.b.2
                @Override // android.view.View
                protected void onVisibilityChanged(View view2, int i) {
                    super.onVisibilityChanged(view2, i);
                    com.bytedance.sdk.component.utils.b bVar = b.this.qv;
                    if (bVar == null) {
                        return;
                    }
                    try {
                        b.this.nw = isShown();
                        if (isShown()) {
                            bVar.ms(b.this.f1990ms != null ? b.this.f1990ms.ka() : 0);
                        } else {
                            bVar.xr(b.this.f1990ms != null ? b.this.f1990ms.ka() : 0);
                        }
                    } catch (Throwable unused) {
                    }
                }
            };
            emptyView2.ms(this.f1990ms, this.c);
            viewGroup.addView(emptyView2);
            emptyView = emptyView2;
        } else {
            emptyView = emptyViewAh;
        }
        emptyView.ms();
        emptyView.setRefClickViews(list2);
        emptyView.setRefCreativeViews(list3);
        emptyView.setRefDirectDownloadViews(list4);
        this.b = emptyView;
        ms(this.op, this.zb, this.ub, msVar, this.ao, 3);
        this.ka = list;
        Context context2 = this.ah;
        lm lmVar3 = this.f1990ms;
        String str2 = this.c;
        this.i = new com.bytedance.sdk.openadsdk.core.xr.xr(context2, lmVar3, str2, com.bytedance.sdk.openadsdk.core.jw.f.xr(str2));
        ms(this.i, viewGroup, view, msVar, msVar2, 0);
        Context context3 = this.ah;
        lm lmVar4 = this.f1990ms;
        String str3 = this.c;
        this.w = new com.bytedance.sdk.openadsdk.core.xr.ms(context3, lmVar4, str3, com.bytedance.sdk.openadsdk.core.jw.f.xr(str3));
        ms(this.w, viewGroup, view, msVar, msVar2, 1);
        if (!com.bytedance.sdk.component.utils.ch.ms(list4)) {
            Context context4 = this.ah;
            lm lmVar5 = this.f1990ms;
            String str4 = this.c;
            com.bytedance.sdk.openadsdk.core.xr.ms msVar3 = new com.bytedance.sdk.openadsdk.core.xr.ms(context4, lmVar5, str4, com.bytedance.sdk.openadsdk.core.jw.f.xr(str4));
            this.yu = msVar3;
            msVar3.ms(2);
            ms(this.yu, viewGroup, view, msVar, msVar2, 2);
        }
        emptyView.ms(list2, this.i);
        emptyView.ms(list3, this.w);
        emptyView.ms(list4, this.yu);
        emptyView.setCallback(new EmptyView.ms() { // from class: com.bytedance.sdk.openadsdk.core.b.3
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.ms
            public void ms(boolean z) {
                b bVar = b.this;
                bVar.x = com.bytedance.sdk.openadsdk.core.zb.ah.ms(bVar.x, z, b.this.f1990ms, b.this.c, 3);
                if (b.this.qv != null) {
                    if (z) {
                        b.this.qv.ms(b.this.f1990ms != null ? b.this.f1990ms.ka() : 0);
                        return;
                    }
                    try {
                        if (b.this.qv != null) {
                            b.this.qv.xr(b.this.f1990ms != null ? b.this.f1990ms.ka() : 0);
                        }
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.sl.d("ShakeUtils", "onPause error:" + th.getMessage());
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.ms
            public void ms() {
                b.this.ah();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.ms
            public void xr() {
                if (b.this.xr != null) {
                    b.this.xr.ny();
                }
                try {
                    if (b.this.qv != null) {
                        b.this.qv.xr(b.this.f1990ms != null ? b.this.f1990ms.ka() : 0);
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.sl.d("ShakeUtils", "onPause error:" + th.getMessage());
                }
                b.this.ch.set(false);
                b.this.hi.set(false);
                b bVar = b.this;
                bVar.x = com.bytedance.sdk.openadsdk.core.zb.ah.ms(bVar.x, b.this.f1990ms, b.this.c, 23);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.ms
            public void ms(View view2, Map<String, Object> map) {
                b.this.ah();
                b.this.x = System.currentTimeMillis();
                Map mapAb = b.this.ab();
                mapAb.put("is_repeat", Boolean.valueOf(b.this.sl.get()));
                if (map != null && map.containsKey("show_send_type")) {
                    mapAb.put("show_send_type", map.get("show_send_type"));
                }
                mapAb.put("is_repeat", Boolean.valueOf(b.this.sl.get()));
                b.this.ch.set(true);
                if (!b.this.hi.get()) {
                    b.this.hi.set(true);
                    com.bytedance.sdk.openadsdk.core.zb.ah.ms(b.this.f1990ms, b.this.c, (Map<String, Object>) mapAb, b.this.ny);
                    com.bytedance.sdk.openadsdk.core.op.ms.ms().d();
                    com.bytedance.sdk.openadsdk.core.jw.pc.ms(b.this.f1990ms != null ? b.this.f1990ms.ka() : 0);
                }
                if (msVar != null) {
                    boolean zOy = re.xr().oy();
                    if (!b.this.sl.getAndSet(true) || zOy) {
                        msVar.ms(b.this.d);
                    }
                    b.this.t = System.currentTimeMillis();
                    b.this.c();
                }
                if (b.this.p != null) {
                    b.this.p.ms();
                }
                if (b.this.of != null) {
                    b.this.of.d();
                }
            }
        });
        emptyView.setNeedCheckingShow(true);
        ah();
    }

    public void ms(com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ab abVar) {
        this.of = abVar;
    }

    public void ms(com.bytedance.sdk.openadsdk.core.video.nativevideo.ms msVar) {
        this.p = msVar;
    }

    public void ms(WeakReference<NativeVideoTsView> weakReference) {
        this.cv = weakReference;
    }

    private void ms(com.bytedance.sdk.openadsdk.core.xr.xr xrVar, ViewGroup viewGroup, View view, final com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms msVar, final com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms msVar2, int i) {
        ms((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah) xrVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.class));
        if (i != 3) {
            HashMap map = new HashMap();
            map.put("click_type", 1);
            ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) xrVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ms(map);
        }
        xrVar.ms(viewGroup);
        xrVar.xr(view);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) xrVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this.d);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) xrVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(new com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.b.4
            @Override // com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.ms
            public void ms(View view2, int i2) {
                com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms msVar3 = msVar;
                if (msVar3 != null) {
                    msVar3.xr(view2, b.this.d);
                }
                com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms msVar4 = msVar2;
                if (msVar4 != null) {
                    msVar4.xr(view2, b.this.d);
                }
                if (i2 != 2 || b.this.f1990ms == null) {
                    return;
                }
                b.this.f1990ms.ah(true);
            }
        });
    }

    public void ms(int i) {
        this.h = i;
    }

    private void ms(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        View viewXr = xr(viewGroup);
        if (viewXr != null) {
            HashMap map = new HashMap();
            map.put(TTDownloadField.TT_TAG, "shake_compat");
            map.put("click_listener", this.op);
            try {
                viewXr.setTag(com.bytedance.sdk.openadsdk.core.jw.p.f2724ms, map);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.sl.d("ShakeUtils", "onPause error:" + th.getMessage());
                com.bytedance.sdk.openadsdk.core.jw.p.ms(com.bytedance.sdk.openadsdk.core.jw.p.f2724ms, th.getMessage());
            }
            this.re = viewXr;
            return;
        }
        View view = new View(this.ah);
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.b.5
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                try {
                    if (b.this.qv != null) {
                        b.this.qv.xr(b.this.f1990ms != null ? b.this.f1990ms.ka() : 0);
                    }
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.sl.d("ShakeUtils", "onPause error:" + th2.getMessage());
                }
            }
        });
        HashMap map2 = new HashMap();
        map2.put(TTDownloadField.TT_TAG, "shake_compat");
        map2.put("click_listener", this.op);
        try {
            view.setTag(com.bytedance.sdk.openadsdk.core.jw.p.f2724ms, map2);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.sl.d("ShakeUtils", "onPause error:" + th2.getMessage());
            com.bytedance.sdk.openadsdk.core.jw.p.ms(com.bytedance.sdk.openadsdk.core.jw.p.f2724ms, th2.getMessage());
        }
        view.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        viewGroup.addView(view);
        this.re = view;
    }

    private View xr(ViewGroup viewGroup) {
        Object obj;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            Object tag = childAt.getTag();
            String string = "";
            if ((tag instanceof Map) && (obj = ((Map) tag).get(TTDownloadField.TT_TAG)) != null) {
                string = obj.toString();
            }
            if ("shake_compat".equals(string)) {
                return childAt;
            }
        }
        return null;
    }

    private com.bytedance.sdk.openadsdk.core.nw.sl ka() {
        lm lmVar;
        com.bytedance.sdk.openadsdk.core.nw.sl slVarVr;
        if (this.h == 5 && (lmVar = this.f1990ms) != null && (slVarVr = lmVar.vr()) != null && slVarVr.ms() == 1) {
            return slVarVr;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.bytedance.sdk.openadsdk.core.nw.sl slVarKa = ka();
        if (slVarKa == null) {
            return;
        }
        final float fXr = slVarKa.xr();
        final float fAh = slVarKa.ah();
        if (this.qv == null) {
            this.qv = new com.bytedance.sdk.component.utils.b(re.getContext(), 1, ch.ub().ka());
        }
        this.qv.xr(this.f1990ms.ia());
        this.qv.ms(this.f1990ms.ax());
        this.qv.xr(this.f1990ms.rg());
        this.qv.c(this.f1990ms.ec());
        this.qv.ah(this.f1990ms.wr());
        this.qv.ms(this.f1990ms.on());
        this.qv.ka(this.f1990ms.n());
        this.qv.ms(new com.bytedance.sdk.component.utils.b.ms() { // from class: com.bytedance.sdk.openadsdk.core.b.6
            @Override // com.bytedance.sdk.component.utils.b.ms
            public void ms(int i) {
                if (i == 1 && b.this.nw && f.ms(b.this.zb)) {
                    com.bytedance.sdk.openadsdk.core.jw.p.ms(b.this.u, fXr, fAh, b.this.t);
                }
            }
        });
        com.bytedance.sdk.component.utils.b bVar = this.qv;
        lm lmVar = this.f1990ms;
        bVar.ms(lmVar != null ? lmVar.ka() : 0);
    }

    public void ms(final com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah ahVar) {
        ahVar.ms(new com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.ms() { // from class: com.bytedance.sdk.openadsdk.core.b.7
            @Override // com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.ms
            public boolean ms() {
                ahVar.ms(b.this.b);
                ahVar.ms(b.this.ab());
                ahVar.ms(b.this.c);
                ahVar.ms(b.this.ny);
                return b.this.ch.get();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> ab() {
        NativeVideoTsView nativeVideoTsView;
        HashMap map = new HashMap();
        if (this.ka != null) {
            JSONArray jSONArray = new JSONArray();
            for (View view : this.ka) {
                if (view != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("width", view.getWidth());
                        jSONObject.put("height", view.getHeight());
                        jSONObject.put("alpha", view.getAlpha());
                    } catch (Throwable unused) {
                    }
                    jSONArray.put(jSONObject);
                }
            }
            map.put("image_view", jSONArray.toString());
        }
        if (this.zb != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("width", this.zb.getWidth());
                jSONObject2.put("height", this.zb.getHeight());
                jSONObject2.put("alpha", this.zb.getAlpha());
            } catch (Throwable unused2) {
            }
            map.put("root_view", jSONObject2.toString());
        }
        WeakReference<NativeVideoTsView> weakReference = this.cv;
        if (weakReference != null && (nativeVideoTsView = weakReference.get()) != null) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("width", nativeVideoTsView.getWidth());
                jSONObject3.put("height", nativeVideoTsView.getHeight());
                jSONObject3.put("alpha", nativeVideoTsView.getAlpha());
            } catch (JSONException unused3) {
            }
            map.put("video_view", jSONObject3.toString());
        }
        return map;
    }

    private EmptyView ah(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    public void ms(com.bytedance.sdk.openadsdk.core.hi.xr.ms msVar) {
        this.y = msVar;
    }

    public void ms(View view, com.bytedance.sdk.openadsdk.core.nw.hi hiVar) {
        if (this.w != null) {
            this.w.ms(view, hiVar);
        }
    }

    public void xr(View view, com.bytedance.sdk.openadsdk.core.nw.hi hiVar) {
        if (this.i != null) {
            this.i.ms(view, hiVar);
        }
    }

    public void ms(Double d) {
        this.ny = d;
    }

    public void xr() {
        if (this.xr != null) {
            this.xr.ny();
        }
        WeakReference<ViewGroup> weakReference = this.u;
        if (weakReference != null) {
            weakReference.clear();
        }
        final ViewGroup viewGroup = this.zb;
        final EmptyView emptyView = this.b;
        if (viewGroup != null && emptyView != null) {
            com.bytedance.sdk.component.utils.x.xr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.b.8
                @Override // java.lang.Runnable
                public void run() {
                    viewGroup.removeView(emptyView);
                }
            });
        }
        final View view = this.re;
        if (viewGroup != null && view != null) {
            com.bytedance.sdk.component.utils.x.xr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.b.9
                @Override // java.lang.Runnable
                public void run() {
                    viewGroup.removeView(view);
                }
            });
        }
        com.bytedance.sdk.component.utils.b bVar = this.qv;
        if (bVar != null) {
            lm lmVar = this.f1990ms;
            bVar.xr(lmVar != null ? lmVar.ka() : 0);
        }
        lm lmVar2 = this.f1990ms;
        com.bytedance.sdk.openadsdk.core.jw.pc.xr(lmVar2 != null ? lmVar2.ka() : 0);
    }
}
