package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.le;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.ao.xr.xr.ab;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.ab.d;
import com.bytedance.sdk.openadsdk.core.jw.pc;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.c;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ka;
import com.bytedance.sdk.openadsdk.core.nativeexpress.yu;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.mediation.MediationNativeManagerDefault;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends com.bytedance.sdk.openadsdk.core.nativeexpress.xr implements le.ms {
    protected WeakReference<BannerExpressBackupView> ab;
    protected lm ah;
    protected com.bytedance.sdk.openadsdk.core.hi.xr.ms c;
    private com.bytedance.sdk.openadsdk.core.hi.xr.ah ch;
    protected com.bytedance.sdk.openadsdk.ao.xr.ah.xr d;
    private com.bytedance.sdk.openadsdk.core.dislike.ui.ms hi;
    private c i;
    protected com.bytedance.sdk.openadsdk.core.nativeexpress.ms ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected ms f2018ms;
    private boolean op;
    private volatile View re;
    private le sl;
    private com.bytedance.sdk.openadsdk.y.ms.xr.ms.ms u;
    private ka w;
    protected final Context xr;
    private NativeExpressView yu;
    private int zb;
    private String ub = "banner_ad";
    private final Queue<Long> ao = new LinkedList();
    private Double h = null;
    private boolean qv = false;
    private boolean y = false;
    private AtomicBoolean t = new AtomicBoolean(false);
    private AtomicBoolean nw = new AtomicBoolean(false);
    private AtomicBoolean b = new AtomicBoolean(false);

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public void ch() {
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public void ms(JSONObject jSONObject) {
    }

    public xr(Context context, lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        this.op = false;
        this.xr = context;
        this.ah = lmVar;
        this.d = xrVar;
        this.op = re.xr().gz() || re.xr().xf();
        ms(context, lmVar, xrVar);
        ms(this.f2018ms.getCurView(), this.ah, false);
    }

    protected void ms(Context context, lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        this.f2018ms = new ms(context, lmVar, xrVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public View ms() {
        d.ms().ms(this.ah).ms(1);
        return this.f2018ms;
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
        this.ah.ca().xr(this.ub);
        return new com.bytedance.sdk.openadsdk.core.dislike.ah.ms(this.ah.ca());
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public void ms(com.bytedance.sdk.openadsdk.w.ms.xr.ms.xr xrVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.ms msVarMs = com.bytedance.sdk.openadsdk.core.nativeexpress.ms.ms(xrVar);
        this.ka = msVarMs;
        this.f2018ms.setExpressInteractionListener(msVarMs);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public void ms(com.bytedance.sdk.openadsdk.w.ms.xr.ms.ms msVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.ms msVarMs = com.bytedance.sdk.openadsdk.core.nativeexpress.ms.ms(msVar);
        this.ka = msVarMs;
        this.f2018ms.setExpressInteractionListener(msVarMs);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public void ms(com.bytedance.sdk.openadsdk.ao.xr.ms.xr xrVar) {
        this.c = com.bytedance.sdk.openadsdk.core.hi.xr.ms.C0291ms.ms(xrVar);
        if (this.x != null) {
            this.x.ms(this.c);
        }
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
        com.bytedance.sdk.openadsdk.core.dislike.ui.ms msVar = this.hi;
        if (msVar != null) {
            msVar.ms(this.f2018ms);
        }
        this.f2018ms.ka();
        d.ms().ms(this.ah).ms(1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public void c() {
        super.c();
        ms msVar = this.f2018ms;
        if (msVar != null) {
            msVar.d();
        }
        le leVar = this.sl;
        if (leVar != null) {
            leVar.removeCallbacksAndMessages(null);
            this.sl = null;
        }
        lm lmVar = this.ah;
        pc.xr(lmVar != null ? lmVar.ka() : 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public void ms(Activity activity, com.bytedance.sdk.openadsdk.y.ms.xr.ms.ms msVar) {
        if (msVar == null || activity == null) {
            return;
        }
        this.u = msVar;
        xr(activity, msVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public void ms(String str) {
        com.bytedance.sdk.openadsdk.core.zb.ah.xr(this.ah, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr
    protected void ms(Dialog dialog) {
        if (dialog == null) {
            sl.xr("dialog is null, please check");
            return;
        }
        ms msVar = this.f2018ms;
        if (msVar == null || msVar.getCurView() == null) {
            return;
        }
        this.f2018ms.getCurView().setOuterDislike(dialog);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr
    public lm ab() {
        return this.ah;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public ab ms(Activity activity) {
        if (this.hi == null) {
            xr(activity, (com.bytedance.sdk.openadsdk.y.ms.xr.ms.ms) null);
        }
        return this.hi;
    }

    private void xr(Activity activity, com.bytedance.sdk.openadsdk.y.ms.xr.ms.ms msVar) {
        if (this.hi == null) {
            com.bytedance.sdk.openadsdk.core.dislike.ui.ms msVar2 = new com.bytedance.sdk.openadsdk.core.dislike.ui.ms(activity, this.ah.ca(), this.ub, false);
            this.hi = msVar2;
            com.bytedance.sdk.openadsdk.core.dislike.ah.ms(activity, msVar2, this.ah);
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.ms msVar3 = this.hi;
        if (msVar3 != null) {
            msVar3.ms(this.f2018ms);
        }
        this.hi.ms(msVar);
        ms msVar4 = this.f2018ms;
        if (msVar4 == null || msVar4.getCurView() == null) {
            return;
        }
        this.f2018ms.getCurView().setDislike(this.hi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sl() {
        if (this.ah.jr() == 4) {
            com.bytedance.sdk.openadsdk.op.ab.ms(new ny("banner_express_register_download") { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.xr.1
                @Override // java.lang.Runnable
                public void run() {
                    if (xr.this.ah.jr() == 4) {
                        xr xrVar = xr.this;
                        xrVar.ch = com.bytedance.sdk.openadsdk.core.hi.ka.ms(xrVar.xr, xr.this.ah, xr.this.ub, false);
                        xr.this.ch.x();
                        if (xr.this.xr instanceof Activity) {
                            xr.this.ch.ms((Activity) xr.this.xr);
                        }
                        if (xr.this.i != null) {
                            ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) xr.this.i.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(xr.this.ch);
                        }
                        if (xr.this.w != null) {
                            ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) xr.this.w.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(xr.this.ch);
                        }
                        xr xrVar2 = xr.this;
                        xrVar2.ms(xrVar2.ch, xr.this.yu);
                        xr.this.ch.ka(false);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zb() {
        le leVar;
        if (this.re == null || !this.re.isShown() || (leVar = this.sl) == null) {
            return;
        }
        leVar.removeCallbacksAndMessages(null);
        this.sl.sendEmptyMessageDelayed(112201, this.zb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        le leVar = this.sl;
        if (leVar != null) {
            leVar.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(lm lmVar) {
        if (this.f2018ms.getNextView() == null || !this.f2018ms.xr()) {
            return;
        }
        ms(this.f2018ms.getNextView(), lmVar.ca());
        this.b.set(false);
        ms(this.f2018ms.getNextView(), lmVar, true);
    }

    private void ms(NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.core.dislike.ah.xr xrVar) {
        if (xrVar == null) {
            return;
        }
        if (this.u != null) {
            this.hi.ms(xrVar);
            if (nativeExpressView != null) {
                nativeExpressView.setDislike(this.hi);
            }
        }
        if (this.ny != null) {
            ms(xrVar);
            if (nativeExpressView != null) {
                nativeExpressView.setOuterDislike(this.ny);
            }
        }
    }

    protected void ms(final NativeExpressView nativeExpressView, final lm lmVar, boolean z) {
        if (nativeExpressView == null || lmVar == null) {
            return;
        }
        this.yu = nativeExpressView;
        lm lmVar2 = this.ah;
        if (lmVar2 != null) {
            pc.xr(lmVar2.ka());
        }
        this.ah = lmVar;
        nativeExpressView.setBackupListener(new com.bytedance.sdk.component.adexpress.xr.ah() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.xr.2
            @Override // com.bytedance.sdk.component.adexpress.xr.ah
            public boolean ms(ViewGroup viewGroup, int i) {
                try {
                    ((NativeExpressView) viewGroup).y();
                    BannerExpressBackupView bannerExpressBackupView = new BannerExpressBackupView(viewGroup.getContext());
                    bannerExpressBackupView.ms(xr.this.ah, (NativeExpressView) viewGroup, xr.this.ch);
                    bannerExpressBackupView.setDislikeInner(xr.this.hi);
                    bannerExpressBackupView.setDislikeOuter(xr.this.ny);
                    if (xr.this.ah != null) {
                        xr.this.ms(lmVar.ca());
                    }
                    xr.this.ab = new WeakReference<>(bannerExpressBackupView);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.zb.ah.ms(lmVar);
        EmptyView emptyViewMs = ms(nativeExpressView);
        if (emptyViewMs == null) {
            EmptyView emptyView = new EmptyView(this.xr, nativeExpressView, lmVar != null ? lmVar.kf() : 1000);
            emptyView.ms(this.ah, this.ub);
            nativeExpressView.addView(emptyView);
            emptyViewMs = emptyView;
        }
        this.re = emptyViewMs;
        emptyViewMs.setCallback(new EmptyView.ms() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.xr.3
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.ms
            public void ms(boolean z2) {
                String unused = xr.this.ub;
                if (xr.this.ch != null) {
                    if (z2) {
                        xr.this.ch.x();
                    } else {
                        com.bytedance.sdk.openadsdk.core.hi.xr.ah unused2 = xr.this.ch;
                    }
                }
                if (z2) {
                    xr.this.zb();
                } else {
                    xr.this.u();
                }
                xr.this.ms(z2, lmVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.ms
            public void ms() {
                xr.this.sl();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.ms
            public void xr() {
                if (xr.this.ch != null) {
                    xr.this.ch.ny();
                }
                xr.this.xr(lmVar);
                xr.this.t.set(false);
                xr.this.nw.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.ms
            public void ms(View view, Map<String, Object> map) {
                if (xr.this.ao != null) {
                    xr.this.ao.offer(Long.valueOf(System.currentTimeMillis()));
                }
                Map mapMs = xr.this.ms(nativeExpressView, lmVar);
                if (map != null && map.containsKey("show_send_type")) {
                    mapMs.put("show_send_type", map.get("show_send_type"));
                }
                mapMs.put("is_repeat", Boolean.valueOf(xr.this.b.get()));
                xr.this.t.set(true);
                if (!xr.this.nw.get()) {
                    xr.this.nw.set(true);
                    com.bytedance.sdk.openadsdk.core.zb.ah.ms(lmVar, xr.this.ub, (Map<String, Object>) mapMs, xr.this.h);
                    com.bytedance.sdk.openadsdk.core.op.ms.ms().d();
                    lm lmVar3 = lmVar;
                    pc.ms(lmVar3 != null ? lmVar3.ka() : 0);
                }
                boolean zOy = re.xr().oy();
                if (xr.this.ka != null && (!xr.this.b.getAndSet(true) || zOy)) {
                    xr.this.ka.xr(view, lmVar.jr());
                }
                xr.this.zb();
                if (xr.this.f2018ms == null || xr.this.f2018ms.getCurView() == null) {
                    return;
                }
                xr.this.f2018ms.getCurView().qv();
                xr.this.f2018ms.getCurView().ao();
            }
        });
        c cVar = new c(this.xr, lmVar, this.ub, 2);
        this.i = cVar;
        final com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah ahVar = (com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah) cVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.class);
        final EmptyView emptyView2 = emptyViewMs;
        ahVar.ms(new com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.ms() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.xr.4
            @Override // com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.ms
            public boolean ms() {
                ahVar.ms(emptyView2);
                ahVar.ms(xr.this.ms(nativeExpressView, lmVar));
                ahVar.ms(xr.this.ub);
                ahVar.ms(xr.this.h);
                return xr.this.t.get();
            }
        });
        this.i.ms(nativeExpressView);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.i.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this);
        nativeExpressView.setClickListener(this.i);
        ka kaVar = new ka(this.xr, lmVar, this.ub, 2);
        this.w = kaVar;
        final com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah ahVar2 = (com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah) kaVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.class);
        ahVar2.ms(new com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.ms() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.xr.5
            @Override // com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.ms
            public boolean ms() {
                ahVar2.ms(emptyView2);
                ahVar2.ms(xr.this.ms(nativeExpressView, lmVar));
                ahVar2.ms(xr.this.ub);
                ahVar2.ms(xr.this.h);
                return xr.this.t.get();
            }
        });
        this.w.ms(nativeExpressView);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.w.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this);
        nativeExpressView.setClickCreativeListener(this.w);
        if (!this.op) {
            emptyViewMs.setNeedCheckingShow(true);
        }
        if (z) {
            sl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> ms(NativeExpressView nativeExpressView, lm lmVar) {
        HashMap map = new HashMap();
        yu.ms(map, this.ah, nativeExpressView);
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar, NativeExpressView nativeExpressView) {
        if (ahVar == null || nativeExpressView == null) {
            return;
        }
        lm lmVar = this.ah;
        this.x = new com.bytedance.sdk.openadsdk.core.nativeexpress.xr.ms(this.c, lmVar != null ? lmVar.df() : "");
        ahVar.ms(this.x);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(lm lmVar) {
        Queue<Long> queue = this.ao;
        if (queue == null || queue.size() <= 0 || lmVar == null) {
            return;
        }
        try {
            long jLongValue = this.ao.poll().longValue();
            if (jLongValue > 0) {
                com.bytedance.sdk.openadsdk.core.zb.ah.ms(new StringBuilder().append(System.currentTimeMillis() - jLongValue).toString(), lmVar, this.ub, 21);
            }
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(boolean z, lm lmVar) {
        Queue<Long> queue = this.ao;
        if (queue == null) {
            return;
        }
        try {
            if (z) {
                queue.offer(Long.valueOf(System.currentTimeMillis()));
            } else if (queue.size() > 0) {
                com.bytedance.sdk.openadsdk.core.zb.ah.ms(new StringBuilder().append(System.currentTimeMillis() - this.ao.poll().longValue()).toString(), lmVar, this.ub, 1);
            }
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    private EmptyView ms(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            try {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof EmptyView) {
                    return (EmptyView) childAt;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
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

    /* JADX WARN: Code duplicated, block: B:6:0x001e A[PHI: r0
      0x001e: PHI (r0v7 int) = (r0v4 int), (r0v5 int) binds: [B:5:0x001c, B:8:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public void ms(int i) {
        if (i <= 0) {
            return;
        }
        this.ub = "slide_banner_ad";
        ms(this.f2018ms.getCurView(), this.ah, false);
        this.f2018ms.setDuration(1000);
        int i2 = 30000;
        if (i < 30000) {
            i = i2;
        } else {
            i2 = 120000;
            if (i > 120000) {
                i = i2;
            }
        }
        this.zb = i;
        this.sl = new le(Looper.getMainLooper(), this);
    }

    private void ub() {
        com.bytedance.sdk.openadsdk.core.nativeexpress.d.ms(this.xr).ms(this.d, 1, null, new com.bytedance.sdk.openadsdk.core.nativeexpress.d.xr(new com.bytedance.sdk.openadsdk.core.nativeexpress.d.ms() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.xr.6
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.d.ms
            public void ms(List<lm> list) {
                if (list == null || list.isEmpty()) {
                    xr.this.zb();
                    return;
                }
                lm lmVar = list.get(0);
                xr.this.f2018ms.ms(lmVar, xr.this.d);
                xr.this.ms(lmVar);
                xr.this.f2018ms.ah();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.d.ms
            public void ms() {
                xr.this.zb();
            }
        }), 5000);
    }

    @Override // com.bytedance.sdk.component.utils.le.ms
    public void ms(Message message) {
        if (message.what == 112201 && this.re != null && this.re.isShown()) {
            ub();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.x
    public void ms(Double d) {
        if (this.qv) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.jw.le.ms(this.ah, d);
        this.qv = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.x
    public void ms(Double d, String str, String str2) {
        if (this.y) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.jw.le.ms(this.ah, d, str, str2);
        this.y = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.x
    public void xr(Double d) {
        this.h = d;
    }
}
