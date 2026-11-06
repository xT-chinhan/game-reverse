package com.byazt.vzj;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.byazt.ej.k;
import com.byazt.ej.oa;
import com.byazt.ej.x;
import com.byazt.pp.LottieAnimationView;
import com.byazt.pp.py;
import com.byazt.pp.q;
import com.byazt.pp.rv;
import com.byazt.zsl.l;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX, 26})
public class qg implements x {
    public boolean cd;
    public Bitmap cp;
    public final x cy;
    public n fi;
    public final oa fs;
    public boolean h;
    public boolean hd;
    public boolean hu;
    public boolean j;
    public final JSONObject k;
    public final int l;
    public long lh;
    public int ln;
    public boolean m;
    public boolean ou;
    public boolean py;
    public final int q;
    public final String qg;
    public String rv;
    public final long s;
    public final String sz;
    public boolean t;
    public LottieAnimationView tj;
    public x.n um;
    public boolean ur;
    public final com.byazt.hlq.qg w;
    public boolean wm;
    public final Context x;
    public final String n = "TTLottieFakeVideoPlayer";
    public final Map<String, Bitmap> d = new HashMap();
    public final Map<String, Integer> oa = new HashMap();
    public final Set<x.n> a = new HashSet();
    public volatile int bb = 200;
    public float v = 1.0f;
    public int an = 0;
    public int ae = 0;
    public final Handler df = new Handler(Looper.getMainLooper());
    public final Runnable oj = new Runnable() { // from class: com.byazt.vzj.qg.5
        @Override // java.lang.Runnable
        public void run() {
            for (x.n nVar : qg.this.a) {
                qg qgVar = qg.this;
                nVar.n(qgVar, qgVar.ln, qg.this.a());
            }
            if (qg.this.ln >= qg.this.a()) {
                if (qg.this.tj != null) {
                    qg.this.tj.w();
                }
                if (!qg.this.cd && qg.this.wm && !qg.this.hu && qg.this.cy != null && qg.this.cy.tj()) {
                    qg.this.cy.q();
                }
                qg.this.ou = false;
                qg.this.m = true;
                qg.this.bb();
                Iterator it = qg.this.a.iterator();
                while (it.hasNext()) {
                    ((x.n) it.next()).n(qg.this);
                }
                return;
            }
            qg.this.ln += qg.this.bb;
            qg.this.df.postDelayed(qg.this.oj, qg.this.bb);
        }
    };
    public long f = SystemClock.elapsedRealtime();

    @Override // com.byazt.ej.x
    public String h() {
        return "";
    }

    @Override // com.byazt.ej.x
    public SurfaceTexture hu() {
        return null;
    }

    @Override // com.byazt.ej.x
    public SurfaceHolder m() {
        return null;
    }

    @Override // com.byazt.ej.x
    public void n(SurfaceTexture surfaceTexture) {
    }

    @Override // com.byazt.ej.x
    public void n(SurfaceHolder surfaceHolder) {
    }

    @Override // com.byazt.ej.x
    public void n(k kVar) {
    }

    @Override // com.byazt.ej.x
    public void n(oa oaVar) {
    }

    @Override // com.byazt.ej.x
    public void n(boolean z) {
    }

    @Override // com.byazt.ej.x
    public void qg(int i) {
    }

    @Override // com.byazt.ej.x
    public int um() {
        return 1;
    }

    public static /* synthetic */ int hu(qg qgVar) {
        int i = qgVar.an;
        qgVar.an = i + 1;
        return i;
    }

    public static /* synthetic */ int wm(qg qgVar) {
        int i = qgVar.ae;
        qgVar.ae = i + 1;
        return i;
    }

    @com.byazt.cp.n(n = {0, 1, TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX, 48})
    private class n implements ViewTreeObserver.OnGlobalLayoutListener {
        public final ViewGroup qg;
        public int s;

        private n(ViewGroup viewGroup) {
            this.s = 10;
            this.qg = viewGroup;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int width = this.qg.getWidth();
            int height = this.qg.getHeight();
            this.qg.removeAllViews();
            int i = this.s;
            this.s = i - 1;
            if (i < 0) {
                this.qg.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            if (width <= 0 || height <= 0) {
                this.qg.addView(qg.this.tj);
            } else {
                this.qg.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                float f = width;
                float f2 = height;
                float f3 = f / f2;
                float f4 = qg.this.l > 0 ? qg.this.q / qg.this.l : f3;
                if (f4 <= 0.0f || f4 < f3) {
                    width = (int) (f2 * f4);
                } else {
                    height = (int) (f / f4);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
                layoutParams.gravity = 17;
                this.qg.addView(qg.this.tj, layoutParams);
            }
            if (!qg.this.py || qg.this.tj.l()) {
                return;
            }
            qg.this.tj.n();
        }
    }

    public qg(com.byazt.hlq.qg qgVar, com.byazt.ts.n nVar, x xVar, l lVar, oa oaVar) {
        this.x = qgVar.getView().getContext();
        this.w = qgVar;
        this.fs = oaVar;
        this.s = nVar.w();
        this.q = nVar.q();
        this.l = nVar.l();
        String strS = nVar.s();
        this.sz = strS;
        String strN = nVar.n();
        this.qg = strN;
        String strQg = nVar.qg();
        this.k = nVar.x();
        n(strN);
        qg(strS);
        this.cy = xVar;
        n(strQg, lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        final ViewGroup viewGroup = (ViewGroup) this.w.getView();
        viewGroup.removeAllViews();
        viewGroup.addView(this.tj);
        this.fi = new n(viewGroup);
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(this.fi);
        viewGroup.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.vzj.qg.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                ViewGroup viewGroup2 = viewGroup;
                if (viewGroup2 == view) {
                    viewGroup2.getViewTreeObserver().removeOnGlobalLayoutListener(qg.this.fi);
                    viewGroup.removeOnAttachStateChangeListener(this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(final boolean z) {
        com.byazt.oa.qg.n(new Runnable() { // from class: com.byazt.vzj.qg.9
            @Override // java.lang.Runnable
            public void run() {
                if (z && !qg.this.cd) {
                    qg.this.cd = true;
                    try {
                        qg.this.cy.w();
                    } catch (Throwable unused) {
                    }
                }
                if (qg.this.cp == null || qg.this.rv == null || !qg.this.hd || qg.this.tj != null) {
                    return;
                }
                boolean z2 = !com.byazt.ts.qg.n().n(qg.this.qg);
                qg.this.tj = new LottieAnimationView(qg.this.x);
                qg.this.tj.setVideoStats(qg.this.fs);
                qg.this.tj.setRepeatCount(-1);
                qg.this.tj.setSpeed(qg.this.v);
                qg.this.tj.setMaintainOriginalImageBounds(z2);
                qg.this.tj.setImageAssetDelegate(new q() { // from class: com.byazt.vzj.qg.9.1
                    @Override // com.byazt.pp.q
                    public Bitmap n(rv rvVar) {
                        if (rvVar != null) {
                            String strOa = rvVar.oa();
                            if (!TextUtils.isEmpty(strOa)) {
                                if (strOa.startsWith("${") && strOa.endsWith("}")) {
                                    strOa = com.byazt.oa.n.n(strOa, qg.this.k);
                                    if (TextUtils.isEmpty(strOa)) {
                                        return null;
                                    }
                                    if (!strOa.startsWith("http") || TextUtils.equals(strOa, qg.this.sz)) {
                                        return qg.this.cp;
                                    }
                                }
                                Bitmap bitmap = (Bitmap) qg.this.d.get(strOa);
                                if (bitmap != null) {
                                    return bitmap;
                                }
                                qg.this.n(strOa, rvVar.n(), rvVar.qg());
                            }
                        }
                        return null;
                    }
                });
                qg.this.tj.setTextDelegate(new py(qg.this.tj) { // from class: com.byazt.vzj.qg.9.2
                    @Override // com.byazt.pp.py
                    public String n(String str) {
                        return com.byazt.oa.n.n(str, qg.this.k != null ? qg.this.k : null);
                    }
                });
                qg.this.tj.n(qg.this.rv, qg.this.qg);
                qg.this.n();
                qg.this.wm = true;
                qg.this.f = SystemClock.elapsedRealtime() - qg.this.f;
                for (x.n nVar : qg.this.a) {
                    nVar.s(qg.this);
                    qg qgVar = qg.this;
                    nVar.n((x) qgVar, qgVar.q, qg.this.l);
                }
                if (qg.this.py) {
                    if (!qg.this.cd) {
                        qg.this.cy.qg(qg.this.j);
                        qg.this.cy.s(true);
                    }
                    if (qg.this.lh > 0) {
                        qg qgVar2 = qg.this;
                        qgVar2.qg(qgVar2.lh);
                    } else {
                        qg.this.s();
                    }
                }
                for (x.n nVar2 : qg.this.a) {
                    qg qgVar3 = qg.this;
                    nVar2.n(qgVar3, qgVar3.f);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final String str) {
        if (TextUtils.isEmpty(str)) {
            n(new com.byazt.zsl.qg(60008, 10000, "lottieJsonUrl为空"));
        } else {
            com.byazt.oa.qg.s(new Runnable() { // from class: com.byazt.vzj.qg.10
                @Override // java.lang.Runnable
                public void run() {
                    String strQg = com.byazt.ts.qg.n().qg(str);
                    if (!TextUtils.isEmpty(strQg)) {
                        qg.this.rv = strQg;
                        qg.this.q(false);
                    } else {
                        com.byazt.ts.qg.n().n(str, new com.byazt.ts.qg.n<String>() { // from class: com.byazt.vzj.qg.10.1
                            @Override // com.byazt.ts.qg.n
                            public void n(String str2) {
                                qg.this.rv = str2;
                                qg.this.q(false);
                            }

                            @Override // com.byazt.ts.qg.n
                            public void n(int i, String str2) {
                                if (i == 10006) {
                                    qg.this.n(new com.byazt.zsl.qg(60008, i, str2));
                                    return;
                                }
                                qg.wm(qg.this);
                                if (qg.this.ae <= 3) {
                                    qg.this.n(str);
                                } else {
                                    qg.this.n(new com.byazt.zsl.qg(60008, i, str2));
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(final String str) {
        if (TextUtils.isEmpty(str)) {
            n(new com.byazt.zsl.qg(60008, 10002, "广告主图url为空"));
        } else {
            com.byazt.ts.qg.n().qg(str, new com.byazt.ts.qg.n<Bitmap>() { // from class: com.byazt.vzj.qg.11
                @Override // com.byazt.ts.qg.n
                public void n(Bitmap bitmap) {
                    qg.this.cp = bitmap;
                    qg.this.q(false);
                }

                @Override // com.byazt.ts.qg.n
                public void n(int i, String str2) {
                    qg.hu(qg.this);
                    if (qg.this.an <= 3) {
                        qg.this.qg(str);
                    } else {
                        qg.this.n(new com.byazt.zsl.qg(60008, 10003, "广告主图url加载失败"));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final String str, final int i, final int i2) {
        Integer num = this.oa.get(str);
        if (num == null || num.intValue() != 1) {
            this.oa.put(str, 1);
            this.tj.n(str, new com.byazt.vk.rv() { // from class: com.byazt.vzj.qg.12
                @Override // com.byazt.vk.rv
                public void n(Bitmap bitmap) {
                    qg.this.n(bitmap, str, i, i2);
                }

                @Override // com.byazt.vk.rv
                public void n() {
                    com.byazt.ts.qg.n().n(qg.this.x, str, new com.byazt.ts.qg.n<Bitmap>() { // from class: com.byazt.vzj.qg.12.1
                        @Override // com.byazt.ts.qg.n
                        public void n(Bitmap bitmap) {
                            qg.this.n(bitmap, str, i, i2);
                        }

                        @Override // com.byazt.ts.qg.n
                        public void n(int i3, String str2) {
                            qg.this.oa.put(str, 2);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Bitmap bitmap, String str, int i, int i2) {
        if (bitmap != null) {
            this.d.put(str, bitmap);
            com.byazt.oa.qg.n(new Runnable() { // from class: com.byazt.vzj.qg.13
                @Override // java.lang.Runnable
                public void run() {
                    if (qg.this.tj != null) {
                        qg.this.tj.invalidate();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final com.byazt.zsl.qg qgVar) {
        com.byazt.oa.qg.qg(new Runnable() { // from class: com.byazt.vzj.qg.14
            @Override // java.lang.Runnable
            public void run() {
                if (!qg.this.t) {
                    qgVar.n();
                    qgVar.qg();
                    qgVar.s();
                    Iterator it = qg.this.a.iterator();
                    while (it.hasNext()) {
                        ((x.n) it.next()).n(qg.this, qgVar);
                    }
                }
                qg.this.t = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rv() {
        com.byazt.oa.qg.qg(new Runnable() { // from class: com.byazt.vzj.qg.15
            @Override // java.lang.Runnable
            public void run() {
                if (!qg.this.ur) {
                    if (qg.this.tj()) {
                        qg.this.lh();
                    }
                    Iterator it = qg.this.a.iterator();
                    while (it.hasNext()) {
                        ((x.n) it.next()).n(qg.this, -1, -1, -1);
                    }
                }
                qg.this.ur = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(final int i) {
        com.byazt.oa.qg.qg(new Runnable() { // from class: com.byazt.vzj.qg.16
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = qg.this.a.iterator();
                while (it.hasNext()) {
                    ((x.n) it.next()).qg(qg.this, i);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        com.byazt.oa.qg.qg(new Runnable() { // from class: com.byazt.vzj.qg.2
            @Override // java.lang.Runnable
            public void run() {
                if (qg.this.ur) {
                    if (qg.this.d()) {
                        qg.this.ln();
                    }
                    Iterator it = qg.this.a.iterator();
                    while (it.hasNext()) {
                        ((x.n) it.next()).n((x) qg.this, -1);
                    }
                }
                qg.this.ur = false;
            }
        });
    }

    private void l(final boolean z) {
        com.byazt.oa.qg.qg(new Runnable() { // from class: com.byazt.vzj.qg.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = qg.this.a.iterator();
                while (it.hasNext()) {
                    ((x.n) it.next()).n(qg.this, z);
                }
            }
        });
    }

    private void n(String str, l lVar) {
        if (TextUtils.isEmpty(str)) {
            n(new com.byazt.zsl.qg(60008, AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1, "lottie音频url为空"));
            return;
        }
        x.n nVar = new x.n() { // from class: com.byazt.vzj.qg.4
            @Override // com.byazt.ej.x.n
            public void l(x xVar) {
            }

            @Override // com.byazt.ej.x.n
            public void n(x xVar) {
            }

            @Override // com.byazt.ej.x.n
            public void n(x xVar, int i, int i2) {
            }

            @Override // com.byazt.ej.x.n
            public void n(x xVar, long j) {
            }

            @Override // com.byazt.ej.x.n
            public void n(x xVar, long j, long j2) {
            }

            @Override // com.byazt.ej.x.n
            public void n(x xVar, JSONObject jSONObject, String str2) {
            }

            @Override // com.byazt.ej.x.n
            public void n(x xVar, boolean z) {
            }

            @Override // com.byazt.ej.x.n
            public void q(x xVar) {
            }

            @Override // com.byazt.ej.x.n
            public void w(x xVar) {
            }

            @Override // com.byazt.ej.x.n
            public void s(x xVar) {
                qg.this.hd = true;
                qg.this.q(false);
            }

            @Override // com.byazt.ej.x.n
            public void n(x xVar, com.byazt.ej.s sVar) {
                qg.this.hd = true;
                qg.this.q(true);
                qg.this.t();
                if (sVar != null) {
                    sVar.n();
                    sVar.qg();
                    sVar.s();
                }
            }

            @Override // com.byazt.ej.x.n
            public void n(x xVar, int i, int i2, int i3) {
                qg.this.rv();
            }

            @Override // com.byazt.ej.x.n
            public void n(x xVar, int i) {
                qg.this.t();
            }

            @Override // com.byazt.ej.x.n
            public void qg(x xVar, int i) {
                qg.this.s(i);
            }

            @Override // com.byazt.ej.x.n
            public void qg(x xVar) {
                for (x.n nVar2 : qg.this.a) {
                    if (nVar2 != null) {
                        nVar2.qg(qg.this);
                    }
                }
            }
        };
        this.um = nVar;
        this.cy.n(nVar);
        this.cy.n(lVar);
    }

    private void ur() {
        this.df.removeCallbacksAndMessages(null);
        this.df.post(this.oj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb() {
        this.df.removeCallbacksAndMessages(null);
    }

    @Override // com.byazt.ej.x
    public void qg(boolean z) {
        x xVar;
        this.j = z;
        if (this.cd || (xVar = this.cy) == null) {
            return;
        }
        xVar.qg(z);
    }

    @Override // com.byazt.ej.x
    public void n(long j) {
        x xVar;
        this.ln = (int) j;
        LottieAnimationView lottieAnimationView = this.tj;
        if (lottieAnimationView != null) {
            long duration = lottieAnimationView.getDuration();
            if (duration <= 0) {
                duration = a();
            }
            if (duration > 0) {
                this.tj.setProgress((j % duration) / duration);
            }
        }
        if (!this.cd && (xVar = this.cy) != null && xVar.a() > 0) {
            this.cy.n((int) (j % this.cy.a()));
        }
        l(true);
    }

    @Override // com.byazt.ej.x
    public void n(boolean z, long j, boolean z2) {
        this.j = z2;
        this.py = true;
        this.lh = j;
        if (!this.cd) {
            this.cy.n(z, j, z2);
        }
        if (this.wm) {
            if (!this.cd) {
                this.cy.qg(z2);
                this.cy.s(true);
            }
            if (j > 0) {
                qg(j);
            } else {
                s();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(long j) {
        x xVar;
        LottieAnimationView lottieAnimationView = this.tj;
        if (lottieAnimationView != null) {
            lottieAnimationView.n();
        }
        n(j);
        if (!this.cd && (xVar = this.cy) != null) {
            xVar.s();
        }
        this.ou = true;
        ur();
    }

    @Override // com.byazt.ej.x
    public void qg() {
        bb();
        this.ln = 0;
        this.wm = true;
        this.m = false;
        this.hu = false;
        LottieAnimationView lottieAnimationView = this.tj;
        if (lottieAnimationView != null) {
            lottieAnimationView.w();
            this.tj.setProgress(0.0f);
        }
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ln() {
        x xVar;
        LottieAnimationView lottieAnimationView = this.tj;
        if (lottieAnimationView != null && this.wm && !lottieAnimationView.l()) {
            if (this.ln > 0) {
                this.tj.qg();
            } else {
                this.tj.n();
            }
        }
        if (!this.cd && this.wm && !this.hu && (xVar = this.cy) != null && !xVar.tj()) {
            if (this.ln > 0) {
                this.cy.s();
            } else {
                this.cy.n(0L);
                this.cy.s();
            }
        }
        this.ou = true;
        ur();
    }

    @Override // com.byazt.ej.x
    public void s() {
        ln();
        if (this.ln > 0) {
            com.byazt.oa.qg.qg(new Runnable() { // from class: com.byazt.vzj.qg.6
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = qg.this.a.iterator();
                    while (it.hasNext()) {
                        ((x.n) it.next()).w(qg.this);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lh() {
        x xVar;
        LottieAnimationView lottieAnimationView = this.tj;
        if (lottieAnimationView != null && this.wm && lottieAnimationView.l()) {
            this.tj.x();
        }
        if (!this.cd && this.wm && !this.hu && (xVar = this.cy) != null && xVar.tj()) {
            this.cy.q();
        }
        this.ou = false;
        bb();
    }

    @Override // com.byazt.ej.x
    public void q() {
        lh();
        com.byazt.oa.qg.qg(new Runnable() { // from class: com.byazt.vzj.qg.7
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = qg.this.a.iterator();
                while (it.hasNext()) {
                    ((x.n) it.next()).l(qg.this);
                }
            }
        });
    }

    @Override // com.byazt.ej.x
    public void x() {
        x xVar;
        LottieAnimationView lottieAnimationView = this.tj;
        if (lottieAnimationView != null) {
            lottieAnimationView.w();
            this.py = false;
        }
        if (!this.cd && this.wm && !this.hu && (xVar = this.cy) != null && xVar.tj()) {
            this.cy.q();
        }
        bb();
    }

    @Override // com.byazt.ej.x
    public void l() {
        x xVar;
        this.ln = 0;
        bb();
        LottieAnimationView lottieAnimationView = this.tj;
        if (lottieAnimationView != null) {
            lottieAnimationView.w();
            this.tj.setProgress(0.0f);
        }
        if (this.cd || !this.wm || this.hu || (xVar = this.cy) == null) {
            return;
        }
        if (xVar.tj()) {
            this.cy.q();
        }
        this.cy.n(0L);
    }

    @Override // com.byazt.ej.x
    public void w() {
        x xVar;
        this.hu = true;
        bb();
        this.d.clear();
        this.cp = null;
        if (!this.cd && (xVar = this.cy) != null) {
            if (this.wm) {
                xVar.x();
            }
            this.cy.w();
        }
        com.byazt.oa.qg.qg(new Runnable() { // from class: com.byazt.vzj.qg.8
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup viewGroup = (ViewGroup) qg.this.w.getView();
                if (viewGroup != null) {
                    viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(qg.this.fi);
                }
                Iterator it = qg.this.a.iterator();
                while (it.hasNext()) {
                    ((x.n) it.next()).q(qg.this);
                }
            }
        });
    }

    @Override // com.byazt.ej.x
    public boolean fs() {
        return this.wm;
    }

    @Override // com.byazt.ej.x
    public boolean k() {
        return this.m;
    }

    @Override // com.byazt.ej.x
    public boolean sz() {
        return this.wm;
    }

    @Override // com.byazt.ej.x
    public boolean cp() {
        return this.py;
    }

    @Override // com.byazt.ej.x
    public boolean tj() {
        return this.ou;
    }

    @Override // com.byazt.ej.x
    public boolean d() {
        return (this.ou || this.m || this.hu || !this.wm) ? false : true;
    }

    @Override // com.byazt.ej.x
    public boolean oa() {
        return this.hu;
    }

    @Override // com.byazt.ej.x
    public int hd() {
        return this.q;
    }

    @Override // com.byazt.ej.x
    public int cd() {
        return this.l;
    }

    @Override // com.byazt.ej.x
    public long cy() {
        if (this.wm) {
            return this.f;
        }
        return 0L;
    }

    @Override // com.byazt.ej.x
    public long a() {
        return this.s;
    }

    @Override // com.byazt.ej.x
    public long py() {
        return this.ln;
    }

    @Override // com.byazt.ej.x
    public void s(boolean z) {
        this.h = z;
    }

    @Override // com.byazt.ej.x
    public boolean ou() {
        return this.h;
    }

    @Override // com.byazt.ej.x
    public void n(x.n nVar) {
        this.a.add(nVar);
    }

    @Override // com.byazt.ej.x
    public void qg(x.n nVar) {
        this.a.remove(nVar);
    }

    @Override // com.byazt.ej.x
    public void n(int i) {
        this.bb = i;
    }

    @Override // com.byazt.ej.x
    public int wm() {
        return this.bb;
    }

    @Override // com.byazt.ej.x
    public void n(float f) {
        this.v = f;
    }
}
