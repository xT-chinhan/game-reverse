package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.g;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.sa;
import com.bytedance.sdk.openadsdk.core.pc;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class NativeExpressView extends FrameLayout implements com.bytedance.sdk.component.adexpress.dynamic.d, com.bytedance.sdk.component.adexpress.theme.ms, com.bytedance.sdk.component.adexpress.xr.ub, com.bytedance.sdk.component.adexpress.xr.x, hi {
    public static int qv = 500;
    protected String ab;
    private com.bytedance.sdk.openadsdk.core.dislike.ui.ms ah;
    private com.bytedance.sdk.component.adexpress.xr.d<? extends View> am;
    protected com.bytedance.sdk.component.adexpress.xr.ah ao;
    private ThemeStatusBroadcastReceiver az;
    private com.bytedance.sdk.openadsdk.core.xr.xr b;
    protected final Context c;
    protected ExpressVideoView ch;
    private sa cv;
    private Dialog d;
    private com.bytedance.sdk.component.adexpress.xr.ch.ms e;
    private com.bytedance.sdk.component.adexpress.xr.ao eg;
    private final Runnable f;
    private com.bytedance.sdk.component.adexpress.xr.xr fm;
    private com.bytedance.sdk.openadsdk.core.ugeno.ch.ms g;
    private View gy;
    protected boolean h;
    protected com.bykv.vk.openvk.component.video.api.d.ah.d hi;
    private String i;
    private com.bytedance.sdk.openadsdk.core.ugeno.express.ka il;
    private final Runnable jw;
    private List<com.bytedance.sdk.component.adexpress.xr.ch> k;
    private ms ka;
    private com.bytedance.sdk.component.adexpress.xr.ny l;
    private boolean le;
    private com.bytedance.sdk.openadsdk.core.ugeno.express.c lm;
    private yu m;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f2945ms;
    private com.bytedance.sdk.openadsdk.core.xr.ms nw;
    protected lm ny;
    private FrameLayout of;
    private com.bytedance.sdk.openadsdk.c.ms op;
    private FrameLayout p;
    private final ViewTreeObserver.OnScrollChangedListener pc;
    private volatile com.bytedance.sdk.component.adexpress.xr.u qf;
    private SparseArray<com.bytedance.sdk.openadsdk.core.xr.d.ms> qk;
    private final AtomicBoolean re;
    private float rt;
    private b s;
    private com.bytedance.sdk.component.adexpress.xr.zb sa;
    private long sk;
    protected com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah sl;
    protected FrameLayout t;
    private boolean ti;
    private h tz;
    protected boolean u;
    protected boolean ub;
    private final Runnable ul;
    private com.bytedance.sdk.openadsdk.core.component.splash.countdown.ah v;
    private float vm;
    private float vy;
    private float w;
    protected com.bytedance.sdk.openadsdk.ao.xr.ah.xr x;
    private com.bytedance.sdk.component.adexpress.xr.c xn;
    private int xr;
    protected boolean y;
    private float yu;
    protected FrameLayout zb;
    private float zf;

    public int ah() {
        return 0;
    }

    public void c() {
    }

    public void ch() {
    }

    public void d() {
    }

    public long getActualPlayDuration() {
        return 0L;
    }

    public com.bykv.vk.openvk.component.video.api.d.ah getVideoController() {
        return null;
    }

    public void hi() {
    }

    public void ka() {
    }

    public long ms() {
        return 0L;
    }

    public void ms(float f) {
    }

    public void ms(float f, float f2, float f3, float f4, int i) {
    }

    public void ms(int i) {
    }

    public void ms(int i, String str) {
    }

    public void ny() {
    }

    public void setPauseFromExpressView(boolean z) {
    }

    public void setTimeUpdate(int i) {
    }

    public int xr() {
        return 0;
    }

    public void xr(int i) {
    }

    public NativeExpressView(Context context, lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, String str) {
        super(context);
        this.f2945ms = true;
        this.xr = 0;
        this.ab = "embeded_ad";
        this.re = new AtomicBoolean(false);
        this.i = null;
        this.ub = false;
        this.h = false;
        this.y = false;
        this.le = false;
        this.pc = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.jw);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.jw, 500L);
            }
        };
        this.jw = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.2
            @Override // java.lang.Runnable
            public void run() {
                if (f.xr(NativeExpressView.this, 0, 5)) {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.d(nativeExpressView.getVisibility());
                } else {
                    NativeExpressView.this.d(8);
                }
            }
        };
        this.f = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.3
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.d(0);
            }
        };
        this.ul = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.4
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.d(8);
            }
        };
        this.qk = new SparseArray<>();
        this.vm = -1.0f;
        this.zf = -1.0f;
        this.rt = -1.0f;
        this.vy = -1.0f;
        this.sk = 0L;
        this.ab = str;
        this.c = context;
        this.ny = lmVar;
        this.x = xrVar;
        sl();
    }

    public NativeExpressView(boolean z, Context context, lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, String str, boolean z2) {
        super(context);
        this.f2945ms = true;
        this.xr = 0;
        this.ab = "embeded_ad";
        this.re = new AtomicBoolean(false);
        this.i = null;
        this.ub = false;
        this.h = false;
        this.y = false;
        this.le = false;
        this.pc = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.jw);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.jw, 500L);
            }
        };
        this.jw = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.2
            @Override // java.lang.Runnable
            public void run() {
                if (f.xr(NativeExpressView.this, 0, 5)) {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.d(nativeExpressView.getVisibility());
                } else {
                    NativeExpressView.this.d(8);
                }
            }
        };
        this.f = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.3
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.d(0);
            }
        };
        this.ul = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.4
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.d(8);
            }
        };
        this.qk = new SparseArray<>();
        this.vm = -1.0f;
        this.zf = -1.0f;
        this.rt = -1.0f;
        this.vy = -1.0f;
        this.sk = 0L;
        this.ab = str;
        this.c = context;
        this.ny = lmVar;
        this.x = xrVar;
        this.ub = z;
        this.y = z2;
        sl();
    }

    public NativeExpressView(Context context, lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, String str, boolean z) {
        super(context);
        this.f2945ms = true;
        this.xr = 0;
        this.ab = "embeded_ad";
        this.re = new AtomicBoolean(false);
        this.i = null;
        this.ub = false;
        this.h = false;
        this.y = false;
        this.le = false;
        this.pc = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.jw);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.jw, 500L);
            }
        };
        this.jw = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.2
            @Override // java.lang.Runnable
            public void run() {
                if (f.xr(NativeExpressView.this, 0, 5)) {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.d(nativeExpressView.getVisibility());
                } else {
                    NativeExpressView.this.d(8);
                }
            }
        };
        this.f = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.3
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.d(0);
            }
        };
        this.ul = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.4
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.d(8);
            }
        };
        this.qk = new SparseArray<>();
        this.vm = -1.0f;
        this.zf = -1.0f;
        this.rt = -1.0f;
        this.vy = -1.0f;
        this.sk = 0L;
        this.ab = str;
        this.c = context;
        this.ny = lmVar;
        this.x = xrVar;
        this.y = z;
        if (xrVar.t() == 9) {
            this.ub = xrVar.ub() == 2;
        }
        sl();
    }

    protected void sl() {
        this.t = new FrameLayout(this.c);
        this.of = new FrameLayout(this.c);
        this.p = new FrameLayout(this.c);
        addView(this.t);
        addView(this.of);
        addView(this.p);
        this.k = new ArrayList();
        com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar = this.x;
        if (xrVar != null) {
            this.w = xrVar.x();
            this.yu = this.x.ny();
            re();
            this.i = this.x.d();
        }
        if (!ub()) {
            setBackgroundColor(0);
            setBackgroundResource(R.color.transparent);
            u();
        }
        w();
        of();
        com.bytedance.sdk.component.adexpress.xr.ao aoVar = this.eg;
        if (aoVar != null) {
            this.m = (yu) aoVar.xr();
        }
        if (yu()) {
            this.tz = new h(this);
        }
    }

    private void u() {
        ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver = new ThemeStatusBroadcastReceiver();
        this.az = themeStatusBroadcastReceiver;
        themeStatusBroadcastReceiver.ms(this);
    }

    private boolean ub() {
        return g() && this.ny.fm() == 1;
    }

    private void re() {
        com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar;
        if (TextUtils.equals(this.ab, "splash_ad") && (xrVar = this.x) != null && this.yu == xrVar.ab() && this.w == this.x.c()) {
            this.yu = ul.d(this.c, this.yu);
            int iD = ul.d(this.c);
            float f = this.w;
            float f2 = iD;
            if (f < f2) {
                this.w = ul.d(this.c, f2);
            } else {
                this.w = ul.d(this.c, f);
            }
        }
    }

    public SSWebView getWebView() {
        yu yuVar = this.m;
        if (yuVar == null) {
            return null;
        }
        return yuVar.ms();
    }

    private void i() {
        try {
            if (this.az == null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.bytedance.openadsdk.themeTypeChangeReceiver");
            this.c.registerReceiver(this.az, intentFilter, com.bytedance.sdk.openadsdk.core.jw.f.op(), null);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
        }
    }

    private void w() {
        com.bytedance.sdk.component.adexpress.xr.zb.ms msVar;
        List<g> listFk;
        g gVar;
        boolean zNa = this.ny.na();
        JSONObject jSONObjectMs = null;
        if (!ub()) {
            if (zNa) {
                jSONObjectMs = com.bytedance.sdk.openadsdk.core.nativeexpress.xr.xr.ms(this.ny, com.bytedance.sdk.openadsdk.core.nativeexpress.xr.xr.ms(this.w, this.yu, this.ub), com.bytedance.sdk.openadsdk.core.nativeexpress.xr.xr.ms(this.ny), false);
            } else if (com.bytedance.sdk.openadsdk.core.ugeno.ch.ny(this.ny)) {
                if (this.ny.si() != null && !TextUtils.isEmpty(this.ny.si().ny())) {
                    jSONObjectMs = com.bytedance.sdk.openadsdk.core.ugeno.ch.xr(this.ny.si().ch(), this.ny.si().ny());
                }
            } else {
                jSONObjectMs = com.bytedance.sdk.openadsdk.core.nativeexpress.xr.xr.ms(this.w, this.yu, this.ub, this.ny);
            }
            if (this.ny.si() != null) {
                com.bytedance.sdk.openadsdk.core.d.ms().ms(this.ny.si().xr());
            }
            if (this.ny.pl() != null) {
                com.bytedance.sdk.openadsdk.core.d.ms().ms(this.ny.pl().ms());
            }
        }
        this.op = cv();
        if (ub()) {
            this.l = new t();
        } else {
            this.l = new ch(this.op, this.ab, this.ny, this.i);
        }
        boolean zLe = le();
        if (com.bytedance.sdk.openadsdk.core.ugeno.ch.ny(this.ny) || com.bytedance.sdk.openadsdk.core.ugeno.ch.ch(this.ny) || com.bytedance.sdk.openadsdk.core.ugeno.ms.ms.xr(this.ny) || yu()) {
            com.bytedance.sdk.openadsdk.core.ugeno.express.xr.ms msVar2 = new com.bytedance.sdk.openadsdk.core.ugeno.express.xr.ms();
            msVar2.ka(com.bytedance.sdk.openadsdk.core.ugeno.ch.ms(this.ny, (View) this, false));
            msVar2.ms((com.bytedance.adsdk.ugeno.ah.qv) this.l);
            msVar2.ms(this.w);
            msVar2.xr(this.yu);
            msVar2.d(yu());
            msVar = msVar2;
        } else {
            msVar = new com.bytedance.sdk.component.adexpress.xr.zb.ms();
        }
        msVar.ah(zNa);
        if (TextUtils.equals(this.ab, "splash_ad")) {
            msVar.c(com.bytedance.sdk.openadsdk.op.ny.ka());
        }
        if (this.ny.du() == 3 && com.bytedance.sdk.openadsdk.ka.ms.d(this.ny) && (listFk = this.ny.fk()) != null && !listFk.isEmpty() && (gVar = listFk.get(0)) != null) {
            msVar.ny(gVar.ms());
            msVar.ms(new UpieImageView(this.c, com.bytedance.sdk.openadsdk.ka.ms.ny(this.ny), com.bytedance.sdk.openadsdk.ka.ms.ch(this.ny)));
        }
        this.sa = msVar.ms(this.ab).xr(this.ny.df()).ah(com.bytedance.sdk.openadsdk.core.jw.f.ao(this.ny)).d(this.ny.lx()).ms(jSONObjectMs).ms(this.l).ms(com.bytedance.sdk.openadsdk.core.re.xr().ms(this.ab, this.ny.du())).xr(zLe).xr(this.ny.v()).ah(this.ny.jr()).ka(com.bytedance.sdk.openadsdk.core.nativeexpress.xr.xr.d(this.ny)).ms(com.bytedance.sdk.openadsdk.core.nativeexpress.xr.xr.ka(this.ny)).d(getRenderThread()).ka(this.ny.on()).c(this.ny.iw()).ab(this.ny.ia()).xr(this.ny.ax()).ah(this.ny.wr()).d(this.ny.rg()).ny(this.ny.ec()).x(this.ny.n()).ab(this.ny.ze()).x("https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/").ms(com.bytedance.sdk.openadsdk.core.ch.ub().ka()).ch(this.ny.ka()).ms();
    }

    private int getRenderThread() {
        if (op()) {
            return 1;
        }
        if ((com.bytedance.sdk.openadsdk.core.ah.ka.ms().sl() & 2) == 2) {
            return 1;
        }
        return this.ny.ht();
    }

    private boolean yu() {
        return this.x != null && com.bytedance.sdk.openadsdk.core.g.xr >= 5900 && this.x.yu();
    }

    private boolean op() {
        return com.bytedance.sdk.openadsdk.core.re.xr().ny(com.bytedance.sdk.openadsdk.core.jw.f.ny(this.ny)) == 4 && g();
    }

    private boolean le() {
        if (TextUtils.equals(this.ab, "rewarded_video") || TextUtils.equals(this.ab, "fullscreen_interstitial_ad")) {
            return this.ny.rk();
        }
        return true;
    }

    private com.bytedance.sdk.openadsdk.c.ms cv() {
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.core.zb.x xVar = new com.bytedance.sdk.openadsdk.core.zb.x(this.ab, this.ny, jSONObject);
        xVar.ms(jSONObject, "webview_source", (Object) 1);
        return xVar;
    }

    private boolean g() {
        return TextUtils.equals(this.ab, "splash_ad") || TextUtils.equals(this.ab, "cache_splash_ad");
    }

    private void of() {
        this.xr = this.ny.du();
        if (g() && this.ny.fm() == 1) {
            this.xr = 1000;
        }
        com.bytedance.sdk.openadsdk.core.sl.ms.ms msVar = new com.bytedance.sdk.openadsdk.core.sl.ms.ms(this.ny, new WeakReference(this));
        int i = this.xr;
        if (i == 3) {
            com.bytedance.sdk.component.adexpress.xr.xr xrVar = new com.bytedance.sdk.component.adexpress.xr.xr(this.c, this.sa, this.az, this.y, new com.bytedance.sdk.component.adexpress.dynamic.d.ab(), this, msVar);
            this.fm = xrVar;
            this.k.add(xrVar);
            this.fm.ms(com.bytedance.sdk.openadsdk.core.re.xr().zh());
        } else if (i == 7) {
            com.bytedance.sdk.openadsdk.core.ugeno.express.d dVar = new com.bytedance.sdk.openadsdk.core.ugeno.express.d(this.c, this.ny, (com.bytedance.sdk.openadsdk.core.ugeno.express.xr) this.sa, this);
            this.le = dVar.ny();
            com.bytedance.sdk.openadsdk.core.ugeno.express.ka kaVar = new com.bytedance.sdk.openadsdk.core.ugeno.express.ka(this.c, dVar, this, this.sa);
            this.il = kaVar;
            this.k.add(kaVar);
        } else if (i == 10) {
            com.bytedance.sdk.openadsdk.core.ugeno.express.c cVar = new com.bytedance.sdk.openadsdk.core.ugeno.express.c(this.c, this.ny, (com.bytedance.sdk.openadsdk.core.ugeno.express.xr) this.sa, this);
            this.lm = cVar;
            this.le = cVar.ny();
            com.bytedance.sdk.openadsdk.core.ugeno.express.ka kaVar2 = new com.bytedance.sdk.openadsdk.core.ugeno.express.ka(this.c, this.lm, this, this.sa);
            this.il = kaVar2;
            this.k.add(kaVar2);
        } else if (i != 1000) {
            this.m = new yu(this.c, this.sa, this.az, this.op, this.ny, this.l);
            com.bytedance.sdk.component.adexpress.xr.ao aoVar = new com.bytedance.sdk.component.adexpress.xr.ao(this.c, this.sa, this.m, this);
            this.eg = aoVar;
            this.k.add(aoVar);
        }
        int iHa = this.ny.ha();
        if (iHa > 0 && yu() && TextUtils.equals(this.ab, "embeded_ad")) {
            this.k.add(new com.bytedance.sdk.openadsdk.core.ugeno.express.ka(this.c, new com.bytedance.sdk.openadsdk.core.ugeno.ms.ah(this.c, this.ny, (com.bytedance.sdk.openadsdk.core.ugeno.express.xr) this.sa, this), this, this.sa));
        } else {
            boolean z = iHa == 1;
            this.f2945ms = z;
            if (z || this.xr == 1000) {
                com.bytedance.sdk.component.adexpress.xr.c cVar2 = new com.bytedance.sdk.component.adexpress.xr.c(this.c, this.sa, new y(this, this.az, this.sa));
                this.xn = cVar2;
                this.k.add(cVar2);
            } else if (com.bytedance.sdk.openadsdk.core.ugeno.ms.ms.xr(this.ny)) {
                this.k.add(new com.bytedance.sdk.openadsdk.core.ugeno.express.ka(this.c, new com.bytedance.sdk.openadsdk.core.ugeno.ms.ah(this.c, this.ny, (com.bytedance.sdk.openadsdk.core.ugeno.express.xr) this.sa, this), this, this.sa));
            }
        }
        this.e = new com.bytedance.sdk.component.adexpress.xr.sl(this.k, this.l);
    }

    public void setVideoAdListener(com.bykv.vk.openvk.component.video.api.d.ah.d dVar) {
        this.hi = dVar;
    }

    public void setVideoAdInteractionListener(com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah interfaceC0177ah) {
        this.sl = interfaceC0177ah;
    }

    public void setOuterDislike(Dialog dialog) {
        BackupView backupView;
        com.bytedance.sdk.component.adexpress.xr.d<? extends View> dVar = this.am;
        if (dVar != null && (dVar instanceof y) && (backupView = (BackupView) dVar.ab()) != null) {
            backupView.setDislikeOuter(dialog);
        }
        this.d = dialog;
    }

    public void setDislike(com.bytedance.sdk.openadsdk.core.dislike.ui.ms msVar) {
        BackupView backupView;
        com.bytedance.sdk.component.adexpress.xr.d<? extends View> dVar = this.am;
        if (dVar != null && (dVar instanceof y) && (backupView = (BackupView) dVar.ab()) != null) {
            backupView.setDislikeInner(msVar);
        }
        this.ah = msVar;
    }

    public void setExpressInteractionListener(ms msVar) {
        this.ka = msVar;
    }

    public void setClickCreativeListener(com.bytedance.sdk.openadsdk.core.xr.ms msVar) {
        this.nw = msVar;
    }

    public com.bytedance.sdk.openadsdk.core.xr.ms getClickCreativeListener() {
        return this.nw;
    }

    public com.bytedance.sdk.openadsdk.core.xr.xr getClickListener() {
        return this.b;
    }

    public void setClickListener(com.bytedance.sdk.openadsdk.core.xr.xr xrVar) {
        this.b = xrVar;
    }

    public void setBackupListener(com.bytedance.sdk.component.adexpress.xr.ah ahVar) {
        this.ao = ahVar;
        com.bytedance.sdk.component.adexpress.xr.c cVar = this.xn;
        if (cVar != null) {
            cVar.ms(ahVar);
        }
    }

    public void ao() {
        com.bytedance.sdk.component.adexpress.xr.d<? extends View> dVar = this.am;
        if (dVar instanceof u) {
            ((u) dVar).x();
        }
        p();
    }

    private void p() {
        if (ub()) {
            return;
        }
        i();
    }

    public void d(int i) {
        com.bytedance.sdk.component.adexpress.xr.d<? extends View> dVar = this.am;
        if (dVar == null || !(dVar instanceof u)) {
            return;
        }
        ((u) dVar).xr(i);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        removeCallbacks(this.ul);
        removeCallbacks(this.f);
        if (i == 0) {
            postDelayed(this.f, 50L);
        } else {
            postDelayed(this.ul, 50L);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (Build.VERSION.SDK_INT < 28) {
            onWindowVisibilityChanged(z ? getVisibility() : 8);
        }
    }

    public void ka(int i) {
        this.sa.ms(i);
    }

    public void h() {
        if (com.bytedance.sdk.openadsdk.core.re.xr().zh() && com.bytedance.sdk.openadsdk.op.ab.ms()) {
            com.bytedance.sdk.component.utils.x.ah().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.5
                @Override // java.lang.Runnable
                public void run() {
                    NativeExpressView.this.pc();
                }
            });
        } else {
            pc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pc() {
        com.bytedance.sdk.openadsdk.c.ms msVar = this.op;
        if (msVar instanceof com.bytedance.sdk.openadsdk.core.zb.x) {
            ((com.bytedance.sdk.openadsdk.core.zb.x) msVar).xr(this.sa.x());
        }
        this.op.ms();
        this.e.ms(this);
        this.e.ms();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        h hVar;
        if (yu() && (hVar = this.tz) != null) {
            return hVar.ms(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        h hVar;
        if (yu() && (hVar = this.tz) != null) {
            return hVar.xr(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00b1  */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i;
        SparseArray<com.bytedance.sdk.openadsdk.core.xr.d.ms> sparseArray;
        com.bytedance.sdk.openadsdk.core.xr.ms msVar = this.nw;
        int i2 = 0;
        if (msVar != null) {
            msVar.ah(motionEvent.getDeviceId());
            this.nw.xr(motionEvent.getSource());
            this.nw.d(motionEvent.getToolType(0));
        }
        com.bytedance.sdk.openadsdk.core.xr.xr xrVar = this.b;
        if (xrVar != null) {
            xrVar.ah(motionEvent.getDeviceId());
            this.b.xr(motionEvent.getSource());
            this.b.d(motionEvent.getToolType(0));
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.vm = motionEvent.getRawX();
            this.zf = motionEvent.getRawY();
            this.sk = System.currentTimeMillis();
        } else {
            i2 = 3;
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    i2 = actionMasked != 3 ? -1 : 4;
                } else {
                    this.rt += Math.abs(motionEvent.getX() - this.vm);
                    this.vy += Math.abs(motionEvent.getY() - this.zf);
                    this.vm = motionEvent.getX();
                    this.zf = motionEvent.getY();
                    i = (System.currentTimeMillis() - this.sk <= 200 || (this.rt <= 8.0f && this.vy <= 8.0f)) ? 2 : 1;
                }
            }
            sparseArray = this.qk;
            if (sparseArray != null) {
                sparseArray.put(motionEvent.getActionMasked(), new com.bytedance.sdk.openadsdk.core.xr.d.ms(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        i = i2;
        sparseArray = this.qk;
        if (sparseArray != null) {
            sparseArray.put(motionEvent.getActionMasked(), new com.bytedance.sdk.openadsdk.core.xr.d.ms(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void ms(View view, int i, com.bytedance.sdk.component.adexpress.ah ahVar, sa saVar) {
        this.cv = saVar;
        ms(view, i, ahVar);
        this.cv = null;
    }

    public void ms(View view, int i, com.bytedance.sdk.component.adexpress.ah ahVar) {
        com.bytedance.sdk.openadsdk.core.nw.hi hiVar;
        com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms msVar;
        com.bytedance.sdk.openadsdk.core.xr.ms msVar2;
        com.bytedance.sdk.openadsdk.core.xr.xr xrVar;
        if (i == -1 || ahVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.nw.i iVar = (com.bytedance.sdk.openadsdk.core.nw.i) ahVar;
        com.bytedance.sdk.openadsdk.core.xr.ms msVar3 = this.nw;
        if (msVar3 != null) {
            msVar3.ka(getDynamicShowType());
        }
        com.bytedance.sdk.openadsdk.core.xr.xr xrVar2 = this.b;
        if (xrVar2 != null) {
            xrVar2.ka(getDynamicShowType());
        }
        if (i != 1 || (xrVar = this.b) == null) {
            hiVar = null;
            msVar = null;
        } else {
            hiVar = xrVar.xr();
            msVar = (com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) this.b.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class);
            msVar.ms(msVar.ka());
        }
        if (i == 2 && (msVar2 = this.nw) != null) {
            hiVar = msVar2.xr();
            msVar = (com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) this.nw.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class);
            msVar.ms(msVar.ka());
        }
        try {
            Object obj = iVar.ms().get("click_extra_map");
            if (msVar != null && (obj instanceof Map)) {
                msVar.ms((Map<String, Object>) obj);
            }
        } catch (JSONException unused) {
        }
        if (hiVar == null) {
            hiVar = new com.bytedance.sdk.openadsdk.core.nw.hi();
        }
        if (this.cv != null) {
            hiVar.xr(this);
        }
        hiVar.ms(iVar.f3057ms);
        hiVar.xr(iVar.xr);
        hiVar.ah(iVar.ah);
        hiVar.d(iVar.d);
        hiVar.ms(iVar.ub);
        hiVar.ab(iVar.qv);
        hiVar.ms(com.bytedance.sdk.openadsdk.core.nw.re.d(this.ny, iVar.h));
        hiVar.xr(iVar.h);
        SparseArray<com.bytedance.sdk.openadsdk.core.xr.d.ms> sparseArray = iVar.ao;
        if (sparseArray == null || sparseArray.size() == 0) {
            sparseArray = this.qk;
        }
        hiVar.ms(sparseArray);
        JSONObject jSONObjectMs = iVar.ms();
        hiVar.ah(jSONObjectMs.optBoolean("is_compliant_download"));
        String strOptString = jSONObjectMs.optString("uchain_event_name");
        hiVar.ah(strOptString);
        int iOptInt = jSONObjectMs.optInt("convertActionType", Integer.MIN_VALUE);
        if (iOptInt == 1) {
            if (i == 2) {
                com.bytedance.sdk.openadsdk.core.xr.ms msVar4 = this.nw;
                if (msVar4 != null) {
                    msVar4.ah();
                }
            } else {
                com.bytedance.sdk.openadsdk.core.xr.xr xrVar3 = this.b;
                if (xrVar3 != null) {
                    xrVar3.ah();
                }
            }
        } else if (iOptInt == 2) {
            if (i == 2) {
                com.bytedance.sdk.openadsdk.core.xr.ms msVar5 = this.nw;
                if (msVar5 != null) {
                    msVar5.d();
                }
            } else {
                com.bytedance.sdk.openadsdk.core.xr.xr xrVar4 = this.b;
                if (xrVar4 != null) {
                    xrVar4.d();
                }
            }
        }
        View view2 = view == null ? this : view;
        String str = iVar.hi;
        lm lmVar = this.ny;
        int iJr = lmVar != null ? lmVar.jr() : 0;
        switch (i) {
            case 1:
                FrameLayout frameLayout = this.zb;
                if (frameLayout != null) {
                    frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                xr(view2, iVar, hiVar, 0, str, iJr);
                break;
            case 2:
                ms(view2, iVar, hiVar, 0, str, iJr);
                break;
            case 3:
                jw();
                break;
            case 4:
                FrameLayout frameLayout2 = this.zb;
                if (frameLayout2 != null) {
                    frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                com.bytedance.sdk.openadsdk.core.jw.f.nw(this.ny);
                if ("embeded_ad".equals(this.ab) && f() && !this.u && com.bytedance.sdk.openadsdk.core.jw.f.nw(this.ny)) {
                    ms(view2, iVar, hiVar, 0, str, iJr);
                } else {
                    xr(view2, iVar, hiVar, 0, str, iJr);
                }
                break;
            case 5:
                ms(!this.y);
                break;
            case 6:
                ab();
                break;
            case 7:
                if (!ms(strOptString)) {
                    com.bytedance.sdk.openadsdk.core.jw.c.ms(this.c, this.ny);
                }
                break;
            case 8:
                x();
                break;
            case 9:
                xr(this.ny, this.c, this.ab);
                break;
            case 10:
                ms(this.ny, this.c, this.ab);
                break;
            case 12:
                ah(this.ny, this.c, this.ab);
                break;
            case 13:
                String strOptString2 = jSONObjectMs.optString("openCommonWebUrl", "");
                String strOptString3 = jSONObjectMs.optString("openCommonWebTitle", "");
                if (!TextUtils.isEmpty(strOptString2)) {
                    TTDelegateActivity.d(this.c, strOptString2, strOptString3);
                }
                break;
        }
    }

    private void ms(View view, com.bytedance.sdk.openadsdk.core.nw.i iVar, com.bytedance.sdk.openadsdk.core.nw.hi hiVar, int i, String str, int i2) {
        if (lm.ka(this.ny)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.xr.ms msVar = this.nw;
        if (msVar != null) {
            msVar.ms(iVar);
            com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms msVar2 = (com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) this.nw.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class);
            ms(msVar2);
            msVar2.xr(str);
            this.nw.ms(hiVar);
            ((com.bytedance.sdk.openadsdk.core.xr.ms.xr.c) this.nw.ms(com.bytedance.sdk.openadsdk.core.xr.ms.xr.c.class)).ms(iVar);
            ((com.bytedance.sdk.openadsdk.core.xr.ms.xr.ka) this.nw.ms(com.bytedance.sdk.openadsdk.core.xr.ms.xr.ka.class)).ms(iVar);
            Map<String, Object> mapMs = com.bytedance.sdk.component.hi.ka.ms.ms().ms(this.ny.hashCode() + this.ny.eu());
            mapMs.put("convert_tag", iVar.h);
            ms(iVar, mapMs);
            this.nw.ms(view, hiVar);
            com.bytedance.sdk.openadsdk.core.xr.ms.xr.c.ms(this.nw);
        }
        ms msVar3 = this.ka;
        if (msVar3 != null) {
            msVar3.ms(this, i2);
        }
    }

    public void ms(com.bytedance.sdk.openadsdk.core.nw.i iVar, Map<String, Object> map) {
        try {
            map.put("live_saas_interaction_type", Integer.valueOf(iVar.ms().optInt("live_saas_param_interaction_type", -1)));
        } catch (Exception unused) {
        }
    }

    private void ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms msVar) {
        sa saVar = this.cv;
        if (saVar != null) {
            HashMap map = new HashMap();
            map.put("custom_express_gesture", 1);
            map.put("express_gesture_type", Integer.valueOf(saVar.xr()));
            map.put("express_slide_direction", Integer.valueOf(saVar.d()));
            map.put("express_slide_threshold", Double.valueOf(saVar.ah()));
            msVar.ms(map);
        }
    }

    private void xr(View view, com.bytedance.sdk.openadsdk.core.nw.i iVar, com.bytedance.sdk.openadsdk.core.nw.hi hiVar, int i, String str, int i2) {
        if (lm.ka(this.ny)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.xr.xr xrVar = this.b;
        if (xrVar != null) {
            xrVar.ms(iVar);
            com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms msVar = (com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) this.b.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class);
            ms(msVar);
            msVar.xr(str);
            this.b.ms(hiVar);
            ((com.bytedance.sdk.openadsdk.core.xr.ms.xr.c) this.b.ms(com.bytedance.sdk.openadsdk.core.xr.ms.xr.c.class)).ms(iVar);
            ((com.bytedance.sdk.openadsdk.core.xr.ms.xr.ka) this.b.ms(com.bytedance.sdk.openadsdk.core.xr.ms.xr.ka.class)).ms(iVar);
            Map<String, Object> mapMs = com.bytedance.sdk.component.hi.ka.ms.ms().ms(this.ny.hashCode() + this.ny.eu());
            mapMs.put("convert_tag", iVar.h);
            ms(iVar, mapMs);
            this.b.ms(view, hiVar);
            com.bytedance.sdk.openadsdk.core.xr.ms.xr.c.ms(this.b);
        }
        ms msVar2 = this.ka;
        if (msVar2 != null) {
            msVar2.ms(this, i2);
        }
    }

    public void ms(View view, int i, com.bytedance.sdk.component.adexpress.ah ahVar, int i2) {
        if (i == -1 || ahVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.nw.i iVar = (com.bytedance.sdk.openadsdk.core.nw.i) ahVar;
        com.bytedance.sdk.openadsdk.core.nw.hi hiVar = new com.bytedance.sdk.openadsdk.core.nw.hi();
        hiVar.ms(iVar.ao);
        hiVar.ms(iVar.f3057ms);
        hiVar.xr(iVar.xr);
        hiVar.ah(iVar.ah);
        hiVar.d(iVar.d);
        hiVar.ms(iVar.ub);
        JSONObject jSONObjectMs = iVar.ms();
        int iOptInt = jSONObjectMs.optInt("convertActionType", Integer.MIN_VALUE);
        hiVar.ah(jSONObjectMs.optBoolean("is_compliant_download"));
        if (iOptInt == 1) {
            if (i == 2) {
                this.nw.ah();
            } else {
                this.b.ah();
            }
        } else if (iOptInt == 2) {
            if (i == 2) {
                this.nw.d();
            } else {
                this.b.d();
            }
        }
        View view2 = view == null ? this : view;
        com.bytedance.sdk.openadsdk.core.xr.ms msVar = this.nw;
        if (msVar != null) {
            msVar.ka(getDynamicShowType());
        }
        com.bytedance.sdk.openadsdk.core.xr.xr xrVar = this.b;
        if (xrVar != null) {
            xrVar.ka(getDynamicShowType());
        }
        lm lmVar = this.ny;
        int iJr = lmVar != null ? lmVar.jr() : 0;
        switch (i) {
            case 1:
                FrameLayout frameLayout = this.zb;
                if (frameLayout != null) {
                    frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                ms(view2, i2, iVar, hiVar, iJr);
                break;
            case 2:
                xr(view2, i2, iVar, hiVar, iJr);
                break;
            case 3:
                jw();
                break;
            case 4:
                FrameLayout frameLayout2 = this.zb;
                if (frameLayout2 != null) {
                    frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                com.bytedance.sdk.openadsdk.core.jw.f.nw(this.ny);
                if ("embeded_ad".equals(this.ab) && f() && !this.u && com.bytedance.sdk.openadsdk.core.jw.f.nw(this.ny)) {
                    xr(view2, i2, iVar, hiVar, iJr);
                } else {
                    ms(view2, i2, iVar, hiVar, iJr);
                }
                break;
            case 5:
                ms(!this.y);
                break;
            case 6:
                ab();
                break;
            case 8:
                x();
                break;
        }
    }

    private boolean ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.jw.f.le();
        HashMap map = new HashMap();
        map.put("material_meta", this.ny);
        map.put(com.umeng.analytics.pro.g.X, this.c);
        new com.bytedance.sdk.component.hi.ms.xr.ms(str).ms(this.ny.rm()).ms(map).ms().ms();
        return true;
    }

    private void ms(View view, int i, com.bytedance.sdk.openadsdk.core.nw.i iVar, com.bytedance.sdk.openadsdk.core.nw.hi hiVar, int i2) {
        if (lm.ka(this.ny)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.xr.xr xrVar = this.b;
        if (xrVar != null) {
            ms(((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) xrVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(), i);
            this.b.ms(iVar);
            this.b.ms(hiVar);
            this.b.ms(view, hiVar);
        }
        ms msVar = this.ka;
        if (msVar != null) {
            msVar.ms(this, i2);
        }
    }

    private void xr(View view, int i, com.bytedance.sdk.openadsdk.core.nw.i iVar, com.bytedance.sdk.openadsdk.core.nw.hi hiVar, int i2) {
        if (lm.ka(this.ny)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.xr.ms msVar = this.nw;
        if (msVar != null) {
            ms(((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) msVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(), i);
            this.nw.ms(iVar);
            this.nw.ms(hiVar);
            this.nw.ms(view, hiVar);
        }
        ms msVar2 = this.ka;
        if (msVar2 != null) {
            msVar2.ms(this, i2);
        }
    }

    private void jw() {
        Dialog dialog = this.d;
        if (dialog != null) {
            dialog.show();
            return;
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.ms msVar = this.ah;
        if (msVar != null) {
            msVar.ms();
        } else {
            TTDelegateActivity.ms(getContext(), this.ny);
        }
    }

    private void ms(com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar, int i) {
        if (ahVar != null && (ahVar instanceof com.bytedance.sdk.openadsdk.core.hi.ah.x)) {
            com.bytedance.sdk.openadsdk.core.hi.ah.ah.ah ahVarHi = ((com.bytedance.sdk.openadsdk.core.hi.ah.x) ahVar).hi();
            ahVarHi.xr(true);
            ahVarHi.ms(i);
        }
    }

    private boolean f() {
        lm lmVar = this.ny;
        return lmVar != null && lmVar.ti() == 1 && lm.xr(this.ny);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.sdk.component.utils.sl.d("webviewpool", "onAttachedToWindow+++");
        getViewTreeObserver().addOnScrollChangedListener(this.pc);
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.bytedance.sdk.component.utils.sl.d("webviewpool", "onFinishTemporaryDetach+++");
    }

    public void qv() {
        yu yuVar = this.m;
        if (yuVar == null || yuVar.ab() == null) {
            return;
        }
        this.m.ka();
    }

    public void zb() {
        ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver;
        try {
            removeAllViews();
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            Iterator<com.bytedance.sdk.component.adexpress.xr.ch> it = this.k.iterator();
            while (it.hasNext()) {
                it.next().ms();
            }
            this.ah = null;
            this.d = null;
            this.x = null;
            this.ny = null;
            this.nw = null;
            this.ao = null;
            this.b = null;
            this.hi = null;
            this.sl = null;
            this.ka = null;
            Context context = this.c;
            if (context != null && (themeStatusBroadcastReceiver = this.az) != null) {
                context.unregisterReceiver(themeStatusBroadcastReceiver);
            }
            ExpressVideoView expressVideoView = this.ch;
            if (expressVideoView != null) {
                expressVideoView.y();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ah("NativeExpressView", "detach error", th);
        }
    }

    public void y() {
        try {
            FrameLayout frameLayout = this.zb;
            if (frameLayout == null || frameLayout.getParent() == null) {
                return;
            }
            removeView(this.zb);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            com.bytedance.sdk.openadsdk.c.ms msVar = this.op;
            if (msVar != null) {
                msVar.xr(true);
            }
            getViewTreeObserver().removeOnScrollChangedListener(this.pc);
        } catch (Exception unused) {
        }
        com.bytedance.sdk.component.utils.sl.d("webviewpool", "onDetachedFromWindow===");
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.bytedance.sdk.component.utils.sl.d("webviewpool", "onStartTemporaryDetach===");
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ub
    public void ms(final com.bytedance.sdk.component.adexpress.xr.d<? extends View> dVar, final com.bytedance.sdk.component.adexpress.xr.u uVar) {
        com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.6
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.xr(dVar, uVar);
            }
        });
    }

    public void xr(com.bytedance.sdk.component.adexpress.xr.d<? extends View> dVar, com.bytedance.sdk.component.adexpress.xr.u uVar) {
        try {
            this.am = dVar;
            this.qf = uVar;
            if (dVar.ah() != 1) {
                View viewAb = dVar.ab();
                this.gy = viewAb;
                if (viewAb.getParent() != null) {
                    ((ViewGroup) this.gy.getParent()).removeView(this.gy);
                }
                this.of.addView(this.gy);
                ViewGroup.LayoutParams layoutParams = this.gy.getLayoutParams();
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    ((FrameLayout.LayoutParams) layoutParams).gravity = 1;
                }
                if (this.s != null && (dVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.d) && !(dVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.c)) {
                    this.s.ms(((com.bytedance.sdk.openadsdk.core.ugeno.express.d) dVar).x());
                    this.s.ms(this);
                }
            }
            com.bytedance.sdk.component.adexpress.xr.ny nyVar = this.l;
            if (nyVar instanceof ch) {
                ((ch) nyVar).u();
            }
            if (this.op != null && dVar.ah() != 0) {
                this.op.ms(dVar.ah(), uVar.hi(), uVar.ch());
            }
            com.bytedance.sdk.component.adexpress.xr.d<? extends View> dVar2 = this.am;
            if ((dVar2 instanceof ub) && ((ub) dVar2).E_() != null) {
                ((ub) this.am).E_().ms((hi) this);
            }
            if (uVar.xr() == 10 && (uVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.ah)) {
                this.g = ((com.bytedance.sdk.openadsdk.core.ugeno.express.ah) uVar).qv();
            }
            ms msVar = this.ka;
            if (msVar != null) {
                msVar.ms(this, (float) uVar.d(), (float) uVar.ka());
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void ms(MotionEvent motionEvent) {
        View view = this.gy;
        if (view != null) {
            view.dispatchTouchEvent(motionEvent);
        }
    }

    public void t() {
        com.bytedance.sdk.component.adexpress.xr.d<? extends View> dVar = this.am;
        if (!(dVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.d) || (dVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.c)) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.core.ugeno.express.d) dVar).xr();
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ub
    public void a_(final int i) {
        if (!this.f2945ms) {
            this.l.hi();
        }
        this.l.sl();
        com.bytedance.sdk.component.adexpress.xr.ny nyVar = this.l;
        if (nyVar instanceof ch) {
            ((ch) nyVar).u();
        }
        if (this.ka != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.ka.ms(this, com.bytedance.sdk.openadsdk.core.ny.ms(i), i);
            } else {
                com.bytedance.sdk.openadsdk.core.nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NativeExpressView.this.ka != null) {
                            NativeExpressView.this.ka.ms(NativeExpressView.this, com.bytedance.sdk.openadsdk.core.ny.ms(i), i);
                        }
                    }
                });
            }
        }
    }

    public boolean nw() {
        com.bytedance.sdk.component.adexpress.xr.d<? extends View> dVar = this.am;
        return dVar != null && dVar.ah() == 1;
    }

    public int getDynamicShowType() {
        com.bytedance.sdk.component.adexpress.xr.d<? extends View> dVar = this.am;
        if (dVar != null) {
            return dVar.ah();
        }
        return 0;
    }

    public int getRenderEngineCacheType() {
        ab abVarUb;
        com.bytedance.sdk.component.adexpress.xr.d<? extends View> dVar = this.am;
        if (!(dVar instanceof yu) || (abVarUb = ((yu) dVar).ub()) == null) {
            return 0;
        }
        return abVarUb.ms();
    }

    public int getExpectExpressWidth() {
        return Float.valueOf(this.w).intValue();
    }

    public int getExpectExpressHeight() {
        return Float.valueOf(this.yu).intValue();
    }

    public pc getJsObject() {
        yu yuVar = this.m;
        if (yuVar != null) {
            return yuVar.E_();
        }
        return null;
    }

    public com.bytedance.sdk.openadsdk.core.ugeno.express.c getUGenV3Render() {
        return this.lm;
    }

    public ms getExpressInteractionListener() {
        return this.ka;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.d
    public void ms(CharSequence charSequence, int i, int i2, boolean z) {
        ms(Integer.parseInt(String.valueOf(charSequence)), i, z);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.d
    public void setSoundMute(boolean z) {
        this.y = z;
        com.bytedance.sdk.component.adexpress.xr.xr xrVar = this.fm;
        if (xrVar != null && xrVar.xr() != null) {
            this.fm.xr().setSoundMute(z);
        }
        if (this.am.ah() == 7) {
            com.bytedance.sdk.component.adexpress.xr.d<? extends View> dVar = this.am;
            if (dVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.d) {
                ((com.bytedance.sdk.component.adexpress.dynamic.d) dVar).setSoundMute(z);
            }
        }
    }

    protected void ms(int i, int i2, boolean z) {
        int iKa;
        if (TextUtils.equals(this.ab, "fullscreen_interstitial_ad")) {
            iKa = pc.ms(this.x.t(), this.ny) ? 0 : com.bytedance.sdk.openadsdk.core.re.xr().c(Integer.parseInt(this.i));
        } else if (!TextUtils.equals(this.ab, "rewarded_video")) {
            return;
        } else {
            iKa = com.bytedance.sdk.openadsdk.core.re.xr().ka(Integer.parseInt(this.i));
        }
        int i3 = (i2 >= iKa || z) ? 1 : 0;
        int i4 = i2 <= iKa ? iKa - i2 : 0;
        com.bytedance.sdk.component.adexpress.xr.xr xrVar = this.fm;
        if (xrVar != null && xrVar.xr() != null) {
            this.fm.xr().ms(String.valueOf(i), i3, i4, z);
        }
        if (this.am.ah() == 7 || this.am.ah() == 10) {
            com.bytedance.sdk.component.adexpress.xr.d<? extends View> dVar = this.am;
            if (dVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.d) {
                ((com.bytedance.sdk.component.adexpress.dynamic.d) dVar).ms(String.valueOf(i), i3, i4, z);
            }
        }
    }

    private void ms(lm lmVar, Context context, String str) {
        if (lmVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.jw.c.ah(lmVar, context, str);
    }

    private void xr(lm lmVar, Context context, String str) {
        if (lmVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.jw.c.xr(lmVar, context, str);
    }

    private void ah(lm lmVar, Context context, String str) {
        if (lmVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.jw.c.ms(context, lmVar, str);
    }

    public void ms(boolean z) {
        if (this.am.ah() == 7) {
            com.bytedance.sdk.component.adexpress.xr.d<? extends View> dVar = this.am;
            if (dVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.d) {
                ((com.bytedance.sdk.component.adexpress.dynamic.d) dVar).setSoundMute(z);
            }
        }
    }

    public void ab() {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.ah ahVar = this.v;
        if (ahVar != null) {
            ahVar.ms();
        }
    }

    public void x() {
        if (yu() && TextUtils.equals(this.ab, "embeded_ad")) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            com.bytedance.sdk.openadsdk.core.dislike.ah.xr xrVar = new com.bytedance.sdk.openadsdk.core.dislike.ah.xr(this.ny.rm(), com.bytedance.sdk.openadsdk.core.dislike.xr.ms());
            xrVar.xr("dislike");
            com.bytedance.sdk.openadsdk.core.dislike.ms.ms.ms().ms(this.c, xrVar, "close_success");
        }
    }

    public ViewGroup getVideoContainer() {
        return this.zb;
    }

    @Override // com.bytedance.sdk.component.adexpress.theme.ms
    public void b_(int i) {
        com.bytedance.sdk.component.adexpress.xr.d<? extends View> dVar = this.am;
        if (dVar == null || !(dVar instanceof u)) {
            return;
        }
        ((u) dVar).b_(i);
    }

    public void xr(int i, String str) {
        pc pcVarE_;
        com.bytedance.sdk.component.adexpress.xr.d<? extends View> dVar = this.am;
        if (dVar == null || !(dVar instanceof yu) || (pcVarE_ = ((yu) dVar).E_()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("time", i);
            jSONObject.put("flag", str);
            pcVarE_.ms("onVideoPaused", jSONObject);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    public void ms(JSONObject jSONObject) {
        boolean zZb = com.bytedance.sdk.openadsdk.core.re.xr().zb();
        this.ti = zZb;
        if (zZb && com.bytedance.sdk.openadsdk.core.jw.f.d(this.ny)) {
            this.s = new b(this.ny, jSONObject, this);
        }
    }

    public void b() {
        b bVar = this.s;
        if (bVar != null) {
            bVar.d();
        }
    }

    public void setEasyPlayableSender(com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ab abVar) {
        ExpressVideoView expressVideoView = this.ch;
        if (expressVideoView == null) {
            return;
        }
        expressVideoView.setEasyPlayableEventSender(abVar);
    }

    public FrameLayout getEasyPlayableLayout() {
        return this.p;
    }

    public void setDynamicSkipListener(com.bytedance.sdk.openadsdk.core.component.splash.countdown.ah ahVar) {
        this.v = ahVar;
    }

    public void xr(int i, int i2) {
        com.bytedance.sdk.openadsdk.core.ugeno.ch.ms msVar = this.g;
        if (msVar != null) {
            msVar.ms(i, i2);
        }
    }
}
