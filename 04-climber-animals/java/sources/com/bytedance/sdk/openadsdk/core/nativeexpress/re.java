package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.le;
import com.bytedance.sdk.openadsdk.core.jw.pc;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.mediation.MediationNativeManagerDefault;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class re extends xr {
    private com.bytedance.sdk.openadsdk.core.hi.xr.ms ab;
    protected lm ah;
    private final FrameLayout b;
    private ms c;
    private com.bytedance.sdk.openadsdk.core.dislike.ui.ms ch;
    private com.bytedance.sdk.openadsdk.core.hi.xr.ah hi;
    protected WeakReference<zb> ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected NativeExpressView f2987ms;
    private final com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d re;
    private ka t;
    private EmptyView w;
    protected final Context xr;
    private c y;
    private boolean yu;
    protected String d = "embeded_ad";
    private long sl = 0;
    private Double zb = null;
    private boolean u = false;
    private boolean ub = false;
    private AtomicBoolean ao = new AtomicBoolean(false);
    private AtomicBoolean h = new AtomicBoolean(false);
    private AtomicBoolean qv = new AtomicBoolean(false);
    private volatile boolean nw = false;
    private final ViewGroup i = new FrameLayout(com.bytedance.sdk.openadsdk.core.re.getContext());
    private final ms op = new ms() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.re.1
        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ms
        public void ms(View view, int i) {
            if (re.this.c != null) {
                re.this.c.ms(re.this.i, i);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ms
        public void xr(View view, int i) {
            boolean zOy = com.bytedance.sdk.openadsdk.core.re.xr().oy();
            if (re.this.c != null && (!re.this.qv.getAndSet(true) || zOy)) {
                re.this.c.xr(re.this.i, i);
            }
            if (re.this.re == null || re.this.re.ms() == null) {
                return;
            }
            re.this.re.ms().d();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ms
        public void ms(View view, String str, int i) {
            if (re.this.c != null) {
                re.this.c.ms(re.this.i, str, i);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ms
        public void ms(View view, float f, float f2) {
            if (re.this.f2987ms != null && re.this.re != null) {
                re.this.f2987ms.setEasyPlayableSender(re.this.re.ms());
                re.this.re.ms(re.this.f2987ms.getEasyPlayableLayout(), re.this.f2987ms.getVideoContainer());
            }
            re.this.i.removeAllViews();
            re.this.i.addView(view);
            re.this.i.addView(re.this.b, new FrameLayout.LayoutParams((int) f, (int) f2));
            if (re.this.c != null) {
                re.this.c.ms(re.this.i, f, f2);
            }
        }
    };

    public re(Context context, final lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        this.yu = false;
        this.xr = context;
        this.ah = lmVar;
        this.yu = com.bytedance.sdk.openadsdk.core.re.xr().gz() || com.bytedance.sdk.openadsdk.core.re.xr().xf();
        ms(context, lmVar, xrVar);
        this.b = new FrameLayout(context);
        this.re = new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d(lmVar, false, new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ms() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.re.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ms
            public void ms(ViewGroup viewGroup) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void ms(int i) {
                if (re.this.f2987ms != null) {
                    re.this.f2987ms.ms(i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public long ms() {
                if (re.this.f2987ms != null) {
                    return re.this.f2987ms.ms();
                }
                return 0L;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public int xr() {
                if (re.this.f2987ms != null) {
                    return re.this.f2987ms.xr();
                }
                return 0;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public int ah() {
                if (re.this.f2987ms != null) {
                    return re.this.f2987ms.ah();
                }
                return 0;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public long getActualPlayDuration() {
                if (re.this.f2987ms != null) {
                    return re.this.f2987ms.getActualPlayDuration();
                }
                return 0L;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void d() {
                if (re.this.f2987ms != null) {
                    re.this.f2987ms.d();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void xr(int i) {
                if (re.this.f2987ms != null) {
                    re.this.f2987ms.xr(i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void ka() {
                if (re.this.f2987ms != null) {
                    re.this.f2987ms.ka();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void ms(int i, String str) {
                if (re.this.f2987ms != null) {
                    re.this.f2987ms.ms(i, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void setPauseFromExpressView(boolean z) {
                if (re.this.f2987ms != null) {
                    re.this.f2987ms.setPauseFromExpressView(z);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void ms(float f) {
                if (re.this.f2987ms != null) {
                    re.this.f2987ms.ms(f);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void c() {
                if (re.this.f2987ms != null) {
                    re.this.f2987ms.c();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ms
            public void ms(View view) {
                re.this.op.ms(view, lmVar.jr());
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ms
            public void ms(View view, int i, com.bytedance.sdk.component.adexpress.ah ahVar) {
                if (re.this.f2987ms != null) {
                    re.this.f2987ms.ms(view, i, ahVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ms
            public void xr(View view, int i, com.bytedance.sdk.component.adexpress.ah ahVar) {
                if (re.this.f2987ms != null) {
                    re.this.f2987ms.ms(view, i, ahVar);
                }
            }
        });
    }

    public void ms(Context context, lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        NativeExpressView nativeExpressView = new NativeExpressView(context, lmVar, xrVar, this.d);
        this.f2987ms = nativeExpressView;
        this.i.addView(nativeExpressView);
        ms(this.f2987ms, this.ah);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public View ms() {
        com.bytedance.sdk.openadsdk.core.ab.d.ms().ms(this.ah);
        return this.i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public int xr() {
        lm lmVar = this.ah;
        if (lmVar == null) {
            return -1;
        }
        return lmVar.kz();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public com.bytedance.sdk.openadsdk.ao.xr.xr.d ah() {
        lm lmVar = this.ah;
        if (lmVar == null || lmVar.ca() == null) {
            return null;
        }
        this.ah.ca().xr(this.d);
        return new com.bytedance.sdk.openadsdk.core.dislike.ah.ms(this.ah.ca());
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public void ms(com.bytedance.sdk.openadsdk.w.ms.xr.ms.xr xrVar) {
        this.c = ms.ms(xrVar);
        this.f2987ms.setExpressInteractionListener(this.op);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public void ms(com.bytedance.sdk.openadsdk.w.ms.xr.ms.ms msVar) {
        this.c = ms.ms(msVar);
        this.f2987ms.setExpressInteractionListener(this.op);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public void ms(com.bytedance.sdk.openadsdk.ao.xr.ms.xr xrVar) {
        this.ab = com.bytedance.sdk.openadsdk.core.hi.xr.ms.C0291ms.ms(xrVar);
        if (this.x != null) {
            this.x.ms(this.ab);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public Map<String, Object> x() {
        lm lmVar = this.ah;
        if (lmVar != null) {
            return lmVar.ou();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.d ny() {
        return new MediationNativeManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public int d() {
        lm lmVar = this.ah;
        if (lmVar == null) {
            return -1;
        }
        return lmVar.jr();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public void ka() {
        com.bytedance.sdk.openadsdk.core.dislike.ui.ms msVar = this.ch;
        if (msVar != null) {
            msVar.ms(this.f2987ms);
        }
        this.f2987ms.h();
        com.bytedance.sdk.openadsdk.core.ab.d.ms().ms(this.ah);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public void c() {
        super.c();
        NativeExpressView nativeExpressView = this.f2987ms;
        if (nativeExpressView != null) {
            nativeExpressView.zb();
        }
        com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar = this.hi;
        if (ahVar != null) {
            ahVar.ny();
        }
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d dVar = this.re;
        if (dVar != null) {
            dVar.xr();
        }
        lm lmVar = this.ah;
        pc.xr(lmVar != null ? lmVar.ka() : 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public void ms(Activity activity, com.bytedance.sdk.openadsdk.y.ms.xr.ms.ms msVar) {
        if (msVar == null || activity == null) {
            return;
        }
        xr(activity, msVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public void ms(String str) {
        com.bytedance.sdk.openadsdk.core.zb.ah.xr(this.ah, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr
    protected void ms(Dialog dialog) {
        if (dialog == null) {
            com.bytedance.sdk.component.utils.sl.xr("dialog is null, please check");
            return;
        }
        NativeExpressView nativeExpressView = this.f2987ms;
        if (nativeExpressView != null) {
            nativeExpressView.setOuterDislike(dialog);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr
    public lm ab() {
        return this.ah;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public com.bytedance.sdk.openadsdk.ao.xr.xr.ab ms(Activity activity) {
        if (this.ch == null) {
            xr(activity, null);
        }
        return this.ch;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public void ms(JSONObject jSONObject) {
        NativeExpressView nativeExpressView = this.f2987ms;
        if (nativeExpressView != null) {
            nativeExpressView.ms(jSONObject);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public void ch() {
        NativeExpressView nativeExpressView = this.f2987ms;
        if (nativeExpressView != null) {
            nativeExpressView.b();
        }
    }

    private void xr(Activity activity, com.bytedance.sdk.openadsdk.y.ms.xr.ms.ms msVar) {
        if (this.ch == null) {
            com.bytedance.sdk.openadsdk.core.dislike.ui.ms msVar2 = new com.bytedance.sdk.openadsdk.core.dislike.ui.ms(activity, this.ah.ca(), this.d, false);
            this.ch = msVar2;
            com.bytedance.sdk.openadsdk.core.dislike.ah.ms(activity, msVar2, this.ah);
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.ms msVar3 = this.ch;
        if (msVar3 != null) {
            msVar3.ms(this.f2987ms);
        }
        this.ch.ms(msVar);
        NativeExpressView nativeExpressView = this.f2987ms;
        if (nativeExpressView != null) {
            nativeExpressView.setDislike(this.ch);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sl() {
        if (this.nw) {
            if (this.hi != null) {
                c cVar = this.y;
                if (cVar != null) {
                    ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) cVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this.hi);
                }
                ka kaVar = this.t;
                if (kaVar != null) {
                    ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) kaVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this.hi);
                }
                try {
                    ms(this.hi, this.f2987ms);
                    this.hi.ka(false);
                    this.hi.ms(this.x);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            return;
        }
        this.nw = true;
        if (this.ah.jr() == 4) {
            com.bytedance.sdk.openadsdk.op.ab.ms(new com.bytedance.sdk.component.ch.ny("native_register_download") { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.re.3
                @Override // java.lang.Runnable
                public void run() {
                    re reVar = re.this;
                    reVar.hi = com.bytedance.sdk.openadsdk.core.hi.ka.ms(reVar.xr, re.this.ah, re.this.d, false);
                    if (re.this.y != null) {
                        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) re.this.y.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(re.this.hi);
                    }
                    if (re.this.t != null) {
                        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) re.this.t.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(re.this.hi);
                    }
                    if (re.this.xr instanceof Activity) {
                        re.this.hi.ms((Activity) re.this.xr);
                    }
                    re reVar2 = re.this;
                    reVar2.ms(reVar2.hi, re.this.f2987ms);
                    re.this.hi.ka(false);
                    re.this.hi.ms(re.this.x);
                }
            });
        }
    }

    protected void ms(NativeExpressView nativeExpressView, final lm lmVar) {
        this.ah = lmVar;
        nativeExpressView.setBackupListener(new com.bytedance.sdk.component.adexpress.xr.ah() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.re.4
            @Override // com.bytedance.sdk.component.adexpress.xr.ah
            public boolean ms(ViewGroup viewGroup, int i) {
                try {
                    ((NativeExpressView) viewGroup).y();
                    zb zbVar = new zb(viewGroup.getContext());
                    com.bytedance.sdk.openadsdk.core.video.d.ms.ms(Integer.valueOf(lmVar.hashCode()), re.this);
                    zbVar.ms(re.this.ah, (NativeExpressView) viewGroup, re.this.hi);
                    zbVar.setDislikeInner(re.this.ch);
                    zbVar.setDislikeOuter(re.this.ny);
                    if (re.this.ah != null) {
                        re reVar = re.this;
                        reVar.ms(reVar.ah.ca());
                    }
                    re.this.ka = new WeakReference<>(zbVar);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.zb.ah.ms(lmVar);
        EmptyView emptyViewMs = ms(nativeExpressView);
        this.w = emptyViewMs;
        if (emptyViewMs == null) {
            EmptyView emptyView = new EmptyView(this.xr, nativeExpressView, lmVar != null ? lmVar.kf() : 1000);
            this.w = emptyView;
            emptyView.ms(this.ah, this.d);
            nativeExpressView.addView(this.w);
        }
        this.w.setCallback(new EmptyView.ms() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.re.5
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.ms
            public void ms(boolean z) {
                if (re.this.hi != null) {
                    if (z) {
                        re.this.hi.x();
                    } else {
                        com.bytedance.sdk.openadsdk.core.hi.xr.ah unused = re.this.hi;
                    }
                }
                re reVar = re.this;
                reVar.sl = com.bytedance.sdk.openadsdk.core.zb.ah.ms(reVar.sl, z, lmVar, re.this.d, 2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.ms
            public void ms() {
                re.this.sl();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.ms
            public void xr() {
                if (re.this.hi != null) {
                    re.this.hi.ny();
                }
                re reVar = re.this;
                reVar.sl = com.bytedance.sdk.openadsdk.core.zb.ah.ms(reVar.sl, lmVar, re.this.d, 22);
                re.this.ao.set(false);
                re.this.h.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.ms
            public void ms(View view, Map<String, Object> map) {
                re.this.sl();
                re.this.sl = System.currentTimeMillis();
                Map mapZb = re.this.zb();
                mapZb.put("is_repeat", Boolean.valueOf(re.this.qv.get()));
                if (map != null && map.containsKey("show_send_type")) {
                    mapZb.put("show_send_type", map.get("show_send_type"));
                }
                mapZb.put("is_repeat", Boolean.valueOf(re.this.qv.get()));
                re.this.ao.set(true);
                if (!re.this.h.get()) {
                    re.this.h.set(true);
                    com.bytedance.sdk.openadsdk.core.zb.ah.ms(lmVar, re.this.d, (Map<String, Object>) mapZb, re.this.zb);
                    com.bytedance.sdk.openadsdk.core.op.ms.ms().d();
                    lm lmVar2 = lmVar;
                    pc.ms(lmVar2 != null ? lmVar2.ka() : 0);
                }
                re.this.op.xr(view, lmVar.jr());
                if (re.this.f2987ms != null) {
                    re.this.f2987ms.qv();
                    re.this.f2987ms.ao();
                }
            }
        });
        Context context = this.xr;
        String str = this.d;
        c cVar = new c(context, lmVar, str, f.xr(str));
        this.y = cVar;
        ms((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah) cVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.class));
        this.y.ms(nativeExpressView);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.y.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this);
        this.f2987ms.setClickListener(this.y);
        Context context2 = this.xr;
        String str2 = this.d;
        ka kaVar = new ka(context2, lmVar, str2, f.xr(str2));
        this.t = kaVar;
        ms((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah) kaVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.class));
        this.t.ms(nativeExpressView);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.t.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this);
        this.f2987ms.setClickCreativeListener(this.t);
        if (this.yu) {
            return;
        }
        this.w.setNeedCheckingShow(true);
    }

    public void ms(final com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah ahVar) {
        ahVar.ms(new com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.ms() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.re.6
            @Override // com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.ms
            public boolean ms() {
                ahVar.ms(re.this.w);
                ahVar.ms(re.this.zb());
                ahVar.ms(re.this.d);
                ahVar.ms(re.this.zb);
                return re.this.ao.get();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> zb() {
        HashMap map = new HashMap();
        yu.ms(map, this.ah, this.f2987ms);
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar, NativeExpressView nativeExpressView) {
        if (ahVar == null || nativeExpressView == null) {
            return;
        }
        lm lmVar = this.ah;
        this.x = new xr.ms(this.ab, lmVar != null ? lmVar.df() : "");
        ahVar.ms(this.x);
    }

    private EmptyView ms(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.x
    public void ms(Double d) {
        if (this.u) {
            return;
        }
        le.ms(this.ah, d);
        this.u = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.x
    public void ms(Double d, String str, String str2) {
        if (this.ub) {
            return;
        }
        le.ms(this.ah, d, str, str2);
        this.ub = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.x
    public void xr(Double d) {
        this.zb = d;
    }
}
