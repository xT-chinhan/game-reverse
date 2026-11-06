package com.bytedance.sdk.openadsdk.core.component.splash.d;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.anythink.basead.c.b;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.component.utils.le;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn;
import com.bytedance.sdk.openadsdk.core.component.splash.TsView;
import com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab;
import com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c;
import com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ny;
import com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.hi.ka;
import com.bytedance.sdk.openadsdk.core.hi.xr.ah;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.pc;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.hi;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.ti;
import com.bytedance.sdk.openadsdk.core.nw.v;
import com.bytedance.sdk.openadsdk.core.nw.vm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.d;
import com.bytedance.sdk.openadsdk.mediation.MediationSplashManagerDefault;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends com.bytedance.sdk.openadsdk.ao.xr.xr.xr implements le.ms, TsView.ms {
    protected xr ab;
    protected ah ah;
    protected boolean b;
    protected View.OnTouchListener c;
    protected boolean cv;
    protected SoftReference<com.bytedance.sdk.openadsdk.ao.xr.ms.xr> d;
    private float e;
    protected c h;
    private float k;
    protected com.bytedance.sdk.openadsdk.core.xr.ms ka;
    private boolean l;
    protected com.bytedance.sdk.openadsdk.core.re.ms.xr le;
    private String lm;
    private Context m;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected TsView f2400ms;
    protected boolean nw;
    protected d of;
    protected x qv;
    private com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.d<ny, ab> rt;
    private Activity s;
    private com.bytedance.sdk.openadsdk.d.ms.xr.ms.xr ti;
    private boolean v;
    private com.bytedance.sdk.openadsdk.core.component.splash.ab vm;
    private com.bytedance.sdk.openadsdk.core.component.splash.ms.ms vy;
    protected ab w;
    protected com.bytedance.sdk.openadsdk.d.ms.xr.ms.ms x;
    protected lm xr;
    private com.bytedance.sdk.openadsdk.ao.xr.ah.xr zf;
    protected AtomicBoolean ny = new AtomicBoolean(false);
    protected final Map<String, Object> ch = new HashMap();
    private Double eg = null;
    private boolean fm = false;
    private boolean xn = false;
    protected boolean hi = false;
    protected int sl = 3;
    protected int zb = -1;
    private final le il = new le(Looper.getMainLooper(), this);
    protected boolean u = false;
    protected boolean ub = false;
    protected long ao = 0;
    protected Map<String, Object> y = new HashMap();
    protected AtomicBoolean t = new AtomicBoolean(false);
    protected boolean re = true;
    protected boolean i = false;
    private com.bytedance.sdk.openadsdk.core.component.splash.ms qf = new com.bytedance.sdk.openadsdk.core.component.splash.ms();
    private boolean am = false;
    private long sa = 0;
    private long tz = 5;
    protected AtomicBoolean yu = new AtomicBoolean(false);
    protected AtomicBoolean op = new AtomicBoolean(false);
    protected AtomicBoolean g = new AtomicBoolean(false);
    private boolean qk = true;
    protected AtomicBoolean p = new AtomicBoolean(false);
    protected int pc = -1;
    protected int jw = -1;
    protected final AtomicBoolean f = new AtomicBoolean(false);
    private final AtomicBoolean sk = new AtomicBoolean(false);
    protected final AtomicInteger ul = new AtomicInteger(0);
    protected com.bytedance.sdk.openadsdk.core.component.splash.countdown.xr az = null;
    private boolean gy = false;
    private int vl = 0;

    public interface xr {
        void v_();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.xr
    public void ms(ViewGroup viewGroup) {
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.xr
    public View u() {
        return null;
    }

    protected void ms(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ah ahVar, com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.d<ny, ab> dVar, com.bytedance.sdk.openadsdk.core.component.splash.ms.ms msVar) {
        if (ahVar == null || dVar == null) {
            return;
        }
        this.vy = msVar;
        this.p.set(ahVar.ny());
        this.rt = dVar;
        ab abVar = new ab();
        this.w = abVar;
        abVar.xr(ahVar.ny());
        this.w.ms(ahVar.xr());
        this.w.ms(this);
        this.m = ahVar.getContext();
        this.lm = ahVar.c();
        this.h = ahVar.d();
        boolean z = true;
        ms(ahVar.ka(), true);
        this.zf = ahVar.ab();
        c cVar = this.h;
        if (cVar == null) {
            this.w.xr(3);
            this.w.ms("render splash ad model is null");
            dVar.ms(this.w);
        } else {
            if (this.qv == null) {
                this.w.xr(3);
                this.w.ms("render splash material is null");
                dVar.ms(this.w);
                return;
            }
            this.xr = cVar.xr();
            boolean zXf = re.xr().xf();
            if (!re.xr().gz() && !zXf) {
                z = false;
            }
            this.gy = z;
            ms();
        }
    }

    public synchronized void ms(x xVar, boolean z) {
        if (this.qv == null || !z) {
            this.qv = xVar;
            if (xVar != null) {
                xr(xVar.ka());
                this.le = xVar.d();
            }
        }
    }

    public void xr(boolean z) {
        this.cv = z;
        xr();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.x, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bykv.ms.ms.ms.ms.xr.ms(super.values()).ms(1, g.xr).xr();
    }

    private void ms() {
        if (this.xr == null) {
            return;
        }
        try {
            this.hi = false;
            TsView tsView = new TsView(this.m, this.lm, this.xr);
            this.f2400ms = tsView;
            tsView.setAttachedToWindowListener(this);
            xr();
            this.f2400ms.setCountDownViewPosition(this.xr);
            if (this.xr.qk() == 0) {
                TsView tsView2 = this.f2400ms;
                if (tsView2 != null) {
                    tsView2.setAdlogoViewVisibility(8);
                }
            } else {
                TsView tsView3 = this.f2400ms;
                if (tsView3 != null) {
                    tsView3.setAdlogoViewVisibility(0);
                }
            }
            if (this.xr.fb() <= 0) {
                xr(3);
            } else {
                int iFb = this.xr.fb();
                this.sl = iFb;
                xr(iFb);
            }
            ms(this.xr);
            ah();
        } catch (ArrayIndexOutOfBoundsException e) {
            sl.d("sbr", e.getMessage());
        }
    }

    private void xr() {
        if (!this.cv || this.f2400ms == null) {
            return;
        }
        lm lmVar = this.xr;
        if ((lmVar == null || lmVar.m22do() == null || this.xr.m22do().xr() != 0) ? false : true) {
            this.f2400ms.setVideoViewVisibility(8);
        } else {
            this.f2400ms.setVideoViewVisibility(0);
            this.f2400ms.setVoiceViewListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.ms.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ms.this.f2400ms.setVoiceViewImageDrawable(ms.this.qk ? t.ah(ms.this.m, "tt_splash_unmute") : t.ah(ms.this.m, "tt_splash_mute"));
                    ms msVar = ms.this;
                    msVar.qk = !msVar.qk;
                    if (ms.this.of != null) {
                        ms.this.of.xr(ms.this.qk);
                    }
                }
            });
        }
    }

    private void xr(int i) {
        TsView tsView = this.f2400ms;
        if (tsView != null) {
            tsView.setCountDownTime(i);
        }
    }

    protected void ms(xr xrVar) {
        this.ab = xrVar;
    }

    private void ms(lm lmVar) {
        TsView tsView;
        if (lmVar == null || (tsView = this.f2400ms) == null) {
            return;
        }
        tsView.ms(lmVar);
    }

    protected void ah(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.splash.ms.ms msVar = this.vy;
        if (msVar != null) {
            msVar.ms(this.rt, this.xr, this.zf, z);
        }
    }

    private void ah() {
        EmptyView emptyView = new EmptyView(this.m, this.f2400ms, this.xr.kf());
        emptyView.ms(this.xr, this.lm);
        emptyView.setAdType(3);
        this.f2400ms.addView(emptyView);
        emptyView.setCallback(new EmptyView.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.ms.4
            private volatile boolean xr = false;

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.ms
            public void xr() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.ms
            public void ms(boolean z) {
                if (ms.this.ah == null || !z) {
                    return;
                }
                ms.this.ah.x();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.ms
            public void ms() {
                ah();
            }

            private void ah() {
                boolean z = true;
                if (this.xr) {
                    if (ms.this.ah != null) {
                        try {
                            ms.this.ah.ka(false);
                            ms msVar = ms.this;
                            if (msVar.xr.fm() == 1) {
                                z = false;
                            }
                            msVar.c(z);
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    }
                    return;
                }
                this.xr = true;
                if (ms.this.xr.jr() == 4) {
                    com.bytedance.sdk.openadsdk.op.ab.ms(new com.bytedance.sdk.component.ch.ny("splash_register_download") { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.ms.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Context context;
                            ms.this.ka(ms.this.xr.fm() != 1);
                            if (ms.this.ah != null) {
                                ms.this.ah.ka(false);
                            }
                            if (ms.this.ah == null || ms.this.f2400ms == null || ms.this.f2400ms.getParent() == null) {
                                return;
                            }
                            try {
                                context = ((View) ms.this.f2400ms.getParent()).getContext();
                            } catch (Exception unused2) {
                                context = null;
                            }
                            if (context instanceof Activity) {
                                ms.this.ah.ms((Activity) context);
                            }
                        }
                    });
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.ms
            public void ms(View view, Map<String, Object> map) {
                ah();
                ms.this.ao = System.currentTimeMillis();
                if (ms.this.ab != null) {
                    ms.this.ab.v_();
                }
                if (ms.this.xr != null && ms.this.h != null) {
                    ms.this.xr.x(ms.this.h.ka());
                    ms.this.y.put("cache_type", Integer.valueOf(re.xr().ny(f.ny(ms.this.xr))));
                    ms.this.y.put("splash_show_time_type", Integer.valueOf(ms.this.jw));
                }
                if (map != null && map.containsKey("show_send_type")) {
                    ms.this.y.put("show_send_type", map.get("show_send_type"));
                }
                ms.this.y.put("is_repeat", Boolean.valueOf(ms.this.t.get()));
                ms.this.f.set(true);
                if (!ms.this.sk.get()) {
                    ms.this.sk.set(true);
                    com.bytedance.sdk.openadsdk.core.zb.ah.ms(ms.this.xr, ms.this.lm, ms.this.y, ms.this.eg);
                    com.bytedance.sdk.openadsdk.core.op.ms.ms().d();
                    pc.ms(ms.this.xr != null ? ms.this.xr.ka() : 0);
                }
                ms.this.ny();
                if (!ms.this.gy) {
                    ms.this.ka();
                }
                ms msVar = ms.this;
                msVar.d(msVar.ny.get());
                boolean zOy = re.xr().oy();
                if (ms.this.x != null && (!ms.this.t.getAndSet(true) || zOy)) {
                    ms.this.x.ms(ms.this);
                }
                ms.this.d();
                ms.this.g.set(true);
                if (ms.this.f2400ms != null) {
                    ms.this.f2400ms.setIsShowSuccess(true);
                }
                ms.this.ah(true);
            }
        });
        if (!this.gy) {
            emptyView.setNeedCheckingShow(true);
        }
        this.ch.put("splash_show_type", Integer.valueOf(this.zb));
        com.bytedance.sdk.openadsdk.core.xr.ms msVar = new com.bytedance.sdk.openadsdk.core.xr.ms(this.m, this.xr, this.lm, 4) { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.ms.5
            @Override // com.bytedance.sdk.openadsdk.core.xr.xr, com.bytedance.sdk.openadsdk.core.xr.d
            public void ms(View view, hi hiVar) {
                if ((view instanceof SplashClickBarBtn) && ms.this.hi) {
                    return;
                }
                super.ms(view, hiVar);
            }
        };
        this.ka = msVar;
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) msVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) this.ka.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ms(this.ch);
        ms((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah) this.ka.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.class), emptyView);
        this.ka.xr(this.f2400ms.getDislikeView());
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.ka.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(new com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.ms.6
            @Override // com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.ms
            public void ms(View view, int i) {
                com.bytedance.sdk.openadsdk.core.zb.ah.xr(ms.this.ao, ms.this.xr);
                if (ms.this.x != null) {
                    ms.this.x.xr(ms.this);
                }
                ms.this.ch();
            }
        });
        this.f2400ms.setSkipListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.ms.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ms.this.x();
            }
        });
    }

    protected void x() {
        if (!this.ub) {
            this.ub = true;
            this.hi = true;
            if (!TextUtils.isEmpty(this.xr.lx())) {
                com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.ao > 0 ? System.currentTimeMillis() - this.ao : 0L, this.xr);
            }
            nw();
            com.bytedance.sdk.openadsdk.core.zb.ah.xr(this.ao, this.xr);
            ah(false);
            zb();
        }
        com.bytedance.sdk.openadsdk.d.ms.xr.ms.ms msVar = this.x;
        if (msVar != null) {
            msVar.ms(this, 1);
        }
    }

    public void ms(final com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah ahVar, final EmptyView emptyView) {
        ahVar.ms(new com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.ms.8
            @Override // com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.ms
            public boolean ms() {
                ahVar.ms(emptyView);
                ahVar.ms(ms.this.y);
                ahVar.ms(ms.this.lm);
                ahVar.ms(ms.this.eg);
                return ms.this.f.get();
            }
        });
    }

    protected void ch() {
        this.il.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.ms.9
            @Override // java.lang.Runnable
            public void run() {
                ms.this.u = true;
                if (!com.bytedance.sdk.openadsdk.core.hi.ah.ah.c.f2579ms) {
                    if (ms.this.vm != null) {
                        ms.this.vm.xr();
                    }
                } else {
                    com.bytedance.sdk.openadsdk.core.hi.ah.ah.c.f2579ms = false;
                    if (ms.this.ah instanceof com.bytedance.sdk.openadsdk.core.hi.ah.x) {
                        ((com.bytedance.sdk.openadsdk.core.hi.ah.x) ms.this.ah).hi().ms(new com.bytedance.sdk.openadsdk.core.hi.ah.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.ms.9.1
                            @Override // com.bytedance.sdk.openadsdk.core.hi.ah.ms.ms
                            public void ms() {
                                if (ms.this.vm != null) {
                                    ms.this.vm.xr();
                                }
                            }
                        });
                    }
                }
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        ch.ub().d().xr(new C0283ms(this.xr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ka() {
        TsView tsView = this.f2400ms;
        if (tsView != null && tsView.getChildCount() > 0) {
            for (int i = 0; i < this.f2400ms.getChildCount(); i++) {
                View childAt = this.f2400ms.getChildAt(i);
                if (childAt != null && (childAt instanceof EmptyView)) {
                    this.f2400ms.removeView(childAt);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ny() {
        TsView tsView = this.f2400ms;
        if (tsView != null) {
            tsView.ms(this.xr.jm(), this.ka);
            if (this.xr.fm() == 1) {
                hi();
            }
        }
    }

    protected void hi() {
        v vVarKk;
        lm lmVar = this.xr;
        if (lmVar == null || (vVarKk = lmVar.kk()) == null || vVarKk.ny() != 5) {
            return;
        }
        final int iUb = vVarKk.ub();
        final v.ms msVarU = vVarKk.u();
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.ms.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int iD = ul.d(ms.this.m, view.getWidth());
                int iD2 = ul.d(ms.this.m, view.getHeight());
                int iD3 = ul.d(ms.this.m, motionEvent.getX());
                int iD4 = ul.d(ms.this.m, motionEvent.getY());
                boolean z = iD3 >= msVarU.ms() && iD4 >= msVarU.ah() && iD - iD3 >= msVarU.xr() && iD2 - iD4 >= msVarU.d();
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            ms.this.k = motionEvent.getY();
                        }
                    } else {
                        if (!z) {
                            return false;
                        }
                        ms.this.k = motionEvent.getY();
                        int iD5 = ul.d(ms.this.m, Math.abs(ms.this.k - ms.this.e));
                        if (ms.this.k - ms.this.e < 0.0f && iD5 > iUb && ms.this.ka != null && ms.this.f2400ms != null) {
                            ms.this.ka.onClick(ms.this.f2400ms);
                        }
                    }
                } else {
                    if (!z) {
                        return false;
                    }
                    ms.this.e = motionEvent.getY();
                }
                return true;
            }
        };
        this.c = onTouchListener;
        TsView tsView = this.f2400ms;
        if (tsView != null) {
            tsView.setSlideUpTouchListener(onTouchListener);
        }
    }

    protected void d(boolean z) {
        if (z || this.f2400ms == null) {
            return;
        }
        if (this.ul.get() == 2 && vm.ms(this.xr)) {
            com.bytedance.sdk.openadsdk.core.component.splash.countdown.xr xrVar = this.az;
            if (xrVar != null) {
                xrVar.xr();
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.d countDownView = this.f2400ms.getCountDownView();
        if (countDownView != null) {
            countDownView.setCountdownListener(new com.bytedance.sdk.openadsdk.core.component.splash.countdown.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.ms.11
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.ms
                public void ms() {
                    ms.this.sl();
                }
            });
            countDownView.ms(false);
            countDownView.ms();
        }
    }

    protected void sl() {
        nw();
        com.bytedance.sdk.openadsdk.core.zb.ah.xr(this.ao, this.xr);
        com.bytedance.sdk.openadsdk.d.ms.xr.ms.ms msVar = this.x;
        if (msVar != null && !this.hi) {
            this.hi = true;
            msVar.ms(this, 2);
            ah(false);
        }
        zb();
    }

    protected void zb() {
        ch.ub().ny(true);
        com.bytedance.sdk.openadsdk.core.jw.ms msVarD = ch.ub().d();
        if (msVarD == null) {
            return;
        }
        msVarD.xr((com.bytedance.sdk.openadsdk.core.jw.ms.xr) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ka(boolean z) {
        this.ah = ka.ms(this.m, this.xr, this.lm, false);
        c(z);
        com.bytedance.sdk.openadsdk.core.xr.ms msVar = this.ka;
        if (msVar != null) {
            ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) msVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this.ah);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final boolean z) {
        final String strDf = this.xr.df();
        this.ah.ms(new com.bytedance.sdk.openadsdk.core.hi.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.ms.2
            @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
            public void ms() {
                if (ms.this.d != null && ms.this.d.get() != null) {
                    ms.this.d.get().ms();
                }
                if (z) {
                    com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(strDf, 1, 0);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
            public void ms(long j, long j2, String str, String str2) {
                if (ms.this.d != null && ms.this.d.get() != null) {
                    ms.this.d.get().ms(j, j2, str, str2);
                }
                if (!z || j <= 0) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(strDf, 3, (int) ((j2 * 100) / j));
            }

            @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
            public void xr(long j, long j2, String str, String str2) {
                if (ms.this.d != null && ms.this.d.get() != null) {
                    ms.this.d.get().xr(j, j2, str, str2);
                }
                if (!z || j <= 0) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(strDf, 2, (int) ((j2 * 100) / j));
            }

            @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
            public void ah(long j, long j2, String str, String str2) {
                if (ms.this.d != null && ms.this.d.get() != null) {
                    ms.this.d.get().ah(j, j2, str, str2);
                }
                if (!z || j <= 0) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(strDf, 4, (int) ((j2 * 100) / j));
            }

            @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
            public void ms(long j, String str, String str2) {
                if (ms.this.d != null && ms.this.d.get() != null) {
                    ms.this.d.get().ms(j, str, str2);
                }
                if (z) {
                    com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(strDf, 5, 100);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
            public void ms(String str, String str2) {
                if (ms.this.d != null && ms.this.d.get() != null) {
                    ms.this.d.get().ms(str, str2);
                }
                if (z) {
                    com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(strDf, 6, 100);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.utils.le.ms
    public void ms(Message message) {
        int i = message.what;
        if (i == 1) {
            long j = this.sa + 1;
            this.sa = j;
            if (j >= this.tz) {
                this.il.sendEmptyMessage(2);
                return;
            } else {
                this.il.sendEmptyMessageDelayed(1, 1000L);
                return;
            }
        }
        if (i != 2) {
            return;
        }
        if (!this.v && ti.ms(this.xr)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("splash_card_close_type", 0);
                com.bytedance.sdk.openadsdk.core.zb.ah.xr(this.xr, "splash_ad", "splash_card_close", jSONObject);
            } catch (JSONException e) {
                sl.ms(e);
            }
        }
        b();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.TsView.ms
    public void c() {
        AtomicBoolean atomicBoolean = this.g;
        if (atomicBoolean != null && atomicBoolean.get()) {
            sl.xr("开屏view重复展示");
            TsView tsView = this.f2400ms;
            if (tsView != null && tsView.getCountDownView() != null && this.f2400ms.getCountDownView().getView() != null) {
                this.f2400ms.getCountDownView().getView().setVisibility(0);
            }
            d(this.ny.get());
        }
        this.vl = 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.TsView.ms
    public void ab() {
        ah ahVar = this.ah;
        if (ahVar != null) {
            ahVar.ny();
        }
        lm lmVar = this.xr;
        if (lmVar != null) {
            i.ms(lmVar.da());
        }
        lm lmVar2 = this.xr;
        pc.xr(lmVar2 != null ? lmVar2.ka() : 0);
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.xr xrVar = this.az;
        if (xrVar != null) {
            xrVar.ms();
        }
        com.bytedance.sdk.openadsdk.core.component.splash.ka.ms(1, this.xr, this.lm, this.vl);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.TsView.ms
    public void ms(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.xr xrVar = this.az;
        if (xrVar != null) {
            xrVar.ms(z);
        }
        this.vl++;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.component.splash.d.ms$ms, reason: collision with other inner class name */
    private static class C0283ms implements com.bytedance.sdk.openadsdk.core.jw.ms.xr {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        lm f2413ms;

        public C0283ms(lm lmVar) {
            this.f2413ms = lmVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.jw.ms.xr
        public void ms() {
            com.bytedance.sdk.openadsdk.core.zb.ah.xr(this.f2413ms, "splash_ad", "splash_enter_background", System.currentTimeMillis());
        }

        @Override // com.bytedance.sdk.openadsdk.core.jw.ms.xr
        public void xr() {
            com.bytedance.sdk.openadsdk.core.zb.ah.xr(this.f2413ms, "splash_ad", "splash_enter_foreground", System.currentTimeMillis());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.xr
    public View ub() {
        com.bytedance.sdk.openadsdk.core.component.splash.ab abVar;
        if (this.b && (abVar = this.vm) != null) {
            return abVar.ms();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.xr
    public int h() {
        lm lmVar = this.xr;
        if (lmVar == null) {
            return -1;
        }
        return lmVar.jr();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.xr
    public void ms(com.bytedance.sdk.openadsdk.ao.xr.ms.xr xrVar) {
        if (xrVar == null) {
            return;
        }
        this.d = new SoftReference<>(xrVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.xr
    public void ms(com.bytedance.sdk.openadsdk.d.ms.xr.ms.ms msVar) {
        this.x = msVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.xr
    public void qv() {
        if (!this.ny.getAndSet(true)) {
            com.bytedance.sdk.openadsdk.core.component.splash.ka.ms(2, this.xr, this.lm, 0);
        }
        TsView tsView = this.f2400ms;
        if (tsView != null) {
            tsView.setSkipIconVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.xr
    public void ms(com.bytedance.sdk.openadsdk.d.ms.xr.ms.xr xrVar) {
        this.ti = xrVar;
        com.bytedance.sdk.openadsdk.core.component.splash.ms msVar = this.qf;
        if (msVar != null) {
            msVar.ms(xrVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.xr
    public void ms(ViewGroup viewGroup, Activity activity) {
        this.s = activity;
        xr(viewGroup);
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.xr
    public com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.c y() {
        return new MediationSplashManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.xr
    public Map<String, Object> t() {
        lm lmVar = this.xr;
        if (lmVar == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.nw.g gVar = lmVar.fk().get(0);
        if (gVar == null) {
            return this.xr.ou();
        }
        if (!gVar.c()) {
            return this.xr.ou();
        }
        String strMs = gVar.ms();
        Map<String, Object> mapOu = this.xr.ou();
        mapOu.put(b.a.h, strMs);
        return mapOu;
    }

    private void xr(ViewGroup viewGroup) {
        TsView tsView;
        if (!this.b || (tsView = this.f2400ms) == null || this.xr == null || this.vm == null || this.l) {
            return;
        }
        ViewParent parent = tsView.getParent();
        this.l = true;
        ViewGroup viewGroupMs = this.vm.ms();
        if (viewGroupMs == null) {
            return;
        }
        d dVar = this.of;
        if (dVar != null) {
            dVar.c();
        }
        if (viewGroupMs.getParent() != null) {
            ((ViewGroup) viewGroupMs.getParent()).removeView(viewGroupMs);
        }
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).addView(viewGroupMs);
            ul.x(this.f2400ms);
            this.f2400ms.removeAllViews();
            this.f2400ms = null;
        }
        viewGroupMs.setOnClickListener(null);
        viewGroupMs.setOnTouchListener(null);
        if (this.i) {
            d dVar2 = this.of;
            if (dVar2 != null) {
                dVar2.ch();
            }
            this.of = null;
        }
        this.vm.ms(this.of, new com.bytedance.sdk.openadsdk.core.component.splash.ab.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.ms.3
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.ab.ms
            public void ms(long j) {
                ms.this.il.removeMessages(1);
                if (j < 0) {
                    ms.this.il.sendEmptyMessageDelayed(1, 1000L);
                } else {
                    if (j == 0) {
                        ms.this.il.sendEmptyMessage(2);
                        return;
                    }
                    ms.this.tz = j;
                    ms.this.sa = 0L;
                    ms.this.il.sendEmptyMessageDelayed(1, 1000L);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.ab.ms
            public void ms() {
                ms.this.il.removeMessages(1);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.ab.ms
            public void xr() {
                ms.this.v = true;
                ms.this.b();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.ab.ms
            public Context getActivity() {
                return ms.this.s;
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.x
    public void ms(Double d) {
        if (this.fm) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.jw.le.ms(this.xr, d);
        this.fm = true;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.x
    public void ms(Double d, String str, String str2) {
        if (this.xn) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.jw.le.ms(this.xr, d, str, str2);
        this.xn = true;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.x
    public void xr(Double d) {
        this.eg = d;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.x
    public void ms(com.bytedance.sdk.openadsdk.ao.xr.ms.ms msVar) {
        lm lmVar = this.xr;
        if (lmVar != null) {
            i.ms(lmVar.da(), msVar, com.bytedance.sdk.openadsdk.ao.xr.ms.ms.class);
        }
    }

    private boolean ao() {
        return (!ti.ms(this.xr) || this.u || this.ub || this.nw) ? false : true;
    }

    private void nw() {
        boolean z = false;
        this.v = false;
        com.bytedance.sdk.openadsdk.core.component.splash.ab abVar = new com.bytedance.sdk.openadsdk.core.component.splash.ab();
        this.vm = abVar;
        abVar.ms(this.m, this.xr);
        if (!this.qf.ah() && ao()) {
            z = true;
        }
        if (z) {
            SoftReference<com.bytedance.sdk.openadsdk.ao.xr.ms.xr> softReference = this.d;
            if (softReference == null) {
                this.vm.ms(this.lm, this.zb, this.qf, null);
            } else {
                this.vm.ms(this.lm, this.zb, this.qf, softReference.get());
            }
            this.b = true;
            this.vm.ms(2);
            com.bytedance.sdk.openadsdk.core.component.splash.ms msVar = this.qf;
            if (msVar != null) {
                msVar.ms(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (!this.l) {
            this.re = false;
            return;
        }
        if (this.am) {
            return;
        }
        this.am = true;
        com.bytedance.sdk.openadsdk.core.component.splash.ms msVar = this.qf;
        if (msVar != null) {
            msVar.ms();
            this.qf = null;
        }
        d dVar = this.of;
        if (dVar != null) {
            dVar.ch();
        }
        this.x = null;
        this.ah = null;
        this.s = null;
    }

    public void ms(int i) {
        this.pc = i;
    }
}
