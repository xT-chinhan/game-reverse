package com.byazt.wg;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.byazt.fvm.w;
import com.byazt.fvm.x;
import com.byazt.tk.k;
import com.byazt.tk.rv;
import com.kwad.sdk.api.model.AdnName;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 204, 26})
public class qg extends x {
    public static final String AD_TAG_BANNER = "banner_ad";
    public static final String AD_TAG_DISLIKE = "dislike";
    public static final String AD_TAG_EXPRESS_BANNER = "slide_banner_ad";
    public static final String AD_TAG_FEED = "embeded_ad";
    public final List<com.byazt.ae.n> cp;
    public SoftReference<View> fs;
    public TTDislikeToast l;
    public final Context n;
    public s q;
    public com.byazt.oj.qg qg;
    public HandlerC0384qg rv;
    public q s;
    public n tj;
    public AtomicBoolean w;
    public boolean x;

    public interface n {
        void n();

        void n(int i, String str, boolean z);

        void qg();
    }

    public qg(Context context, com.byazt.oj.qg qgVar, String str, boolean z, final com.byazt.wg.n nVar) {
        this.w = new AtomicBoolean(false);
        this.cp = new ArrayList();
        qgVar.qg(str);
        qgVar.n(AdnName.OTHER);
        this.n = context;
        if (context == null) {
            return;
        }
        if (!(context instanceof Activity)) {
            k.n("Dislike 初始化必须使用activity,请在TTAdManager.createAdNative(activity)中传入");
            return;
        }
        this.qg = qgVar;
        this.x = z;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            n(nVar);
        } else {
            rv.qg().post(new Runnable() { // from class: com.byazt.wg.qg.1
                @Override // java.lang.Runnable
                public void run() {
                    qg.this.n(nVar);
                }
            });
        }
    }

    public qg(Context context, com.byazt.oj.qg qgVar, boolean z, com.byazt.wg.n nVar) {
        this(context, qgVar, null, z, nVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.wg.n nVar) {
        ViewGroup viewGroup;
        q qVar = new q(this.n, this.qg, nVar);
        this.s = qVar;
        qVar.n(new com.byazt.ae.s() { // from class: com.byazt.wg.qg.2
            @Override // com.byazt.ae.s
            public void n() {
                qg.this.q();
            }

            @Override // com.byazt.ae.s
            public void n(int i, w wVar) {
                try {
                    if (!qg.this.cp.isEmpty()) {
                        String strQ = qg.this.q != null ? qg.this.q.q() : "";
                        Iterator it = qg.this.cp.iterator();
                        while (it.hasNext()) {
                            ((com.byazt.ae.n) it.next()).n(wVar, strQ, qg.this.q);
                        }
                    }
                    if (!wVar.x()) {
                        if (qg.this.tj != null) {
                            qg.this.tj.n(i, wVar.qg(), qg.this.qg != null ? qg.this.qg.rv() : false);
                        }
                        qg.this.w.set(true);
                        if ("99:1".equals(wVar.n())) {
                            return;
                        }
                        if (qg.this.l != null) {
                            qg.this.l.n("感谢您的反馈！\n我们将为您带来更优质的广告体验");
                        }
                        qg.this.l();
                    }
                    k.qg("TTAdDislikeImpl", "onDislikeSelected: " + i + ", " + wVar.qg());
                } catch (Throwable th) {
                    k.n("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }

            @Override // com.byazt.ae.s
            public void qg() {
                if (qg.this.tj != null) {
                    qg.this.tj.n();
                }
            }

            @Override // com.byazt.ae.s
            public void s() {
                k.qg("TTAdDislikeImpl", "onDislikeHide: ");
                try {
                    if (qg.this.tj == null || qg.this.s()) {
                        return;
                    }
                    qg.this.tj.qg();
                } catch (Throwable th) {
                    k.n("TTAdDislikeImpl", "dislike callback cancel error: ", th);
                }
            }
        });
        s sVar = new s(this.n, this.qg);
        this.q = sVar;
        sVar.n(new com.byazt.ae.qg() { // from class: com.byazt.wg.qg.3
            @Override // com.byazt.ae.qg
            public void n() {
                try {
                    if (qg.this.w.get()) {
                        return;
                    }
                    qg.this.s.show();
                    if (qg.this.q != null) {
                        String strQ = qg.this.q.q();
                        if (TextUtils.isEmpty(strQ)) {
                            return;
                        }
                        qg.this.s.n(strQ);
                    }
                } catch (Throwable th) {
                    k.n("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }

            @Override // com.byazt.ae.qg
            public void n(int i, w wVar) {
                try {
                    if (wVar.x()) {
                        return;
                    }
                    if (qg.this.tj != null) {
                        qg.this.tj.n(i, wVar.qg(), qg.this.qg != null ? qg.this.qg.rv() : false);
                    }
                    qg.this.w.set(true);
                    if (qg.this.l != null) {
                        qg.this.l.n("感谢您的反馈！\n我们将为您带来更优质的广告体验");
                    }
                    qg.this.l();
                } catch (Throwable th) {
                    k.n("TTAdDislikeImpl", "comment callback selected error: ", th);
                }
            }
        });
        if ((this.n instanceof Activity) && this.x) {
            this.l = new TTDislikeToast(this.n);
            Window window = ((Activity) this.n).getWindow();
            if (window == null || (viewGroup = (ViewGroup) window.getDecorView()) == null) {
                return;
            }
            viewGroup.addView(this.l);
        }
    }

    @Override // com.byazt.fvm.x
    public void n() {
        TTDislikeToast tTDislikeToast;
        Context context = this.n;
        boolean z = (context instanceof Activity) && !((Activity) context).isFinishing();
        if (this.w.get() && this.x && (tTDislikeToast = this.l) != null) {
            try {
                tTDislikeToast.n("您已成功提交反馈，请勿重复提交哦！");
            } catch (Throwable unused) {
            }
        } else {
            if (!z || s()) {
                return;
            }
            this.s.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        Context context = this.n;
        if ((context instanceof Activity) && (!((Activity) context).isFinishing()) && !this.q.isShowing()) {
            this.q.show();
        }
    }

    public void n(com.byazt.oj.qg qgVar) {
        if ((this.n instanceof Activity) && qgVar != null) {
            this.s.n(qgVar);
            this.q.n(qgVar);
        }
    }

    @Override // com.byazt.fvm.x
    public void n(final com.byazt.lr.n nVar) {
        this.tj = new n() { // from class: com.byazt.wg.qg.4
            @Override // com.byazt.wg.qg.n
            public void n() {
                com.byazt.lr.n nVar2 = nVar;
                if (nVar2 != null) {
                    nVar2.n();
                }
            }

            @Override // com.byazt.wg.qg.n
            public void n(int i, String str, boolean z) {
                com.byazt.lr.n nVar2 = nVar;
                if (nVar2 != null) {
                    nVar2.n(i, str, z);
                }
            }

            @Override // com.byazt.wg.qg.n
            public void qg() {
                com.byazt.lr.n nVar2 = nVar;
                if (nVar2 != null) {
                    nVar2.qg();
                }
            }
        };
    }

    public void n(n nVar) {
        this.tj = nVar;
    }

    @Override // com.byazt.fvm.x
    public void n(String str) {
        com.byazt.oj.qg qgVar = this.qg;
        if (qgVar != null) {
            qgVar.n(str);
        }
    }

    @Override // com.byazt.fvm.x
    public void qg() {
        if (this.n instanceof Activity) {
            q qVar = this.s;
            if (qVar != null) {
                qVar.hide();
            }
            s sVar = this.q;
            if (sVar != null) {
                sVar.n();
            }
            TTDislikeToast tTDislikeToast = this.l;
            if (tTDislikeToast != null) {
                tTDislikeToast.n();
            }
            this.w.set(false);
        }
    }

    @Override // com.byazt.fvm.x
    public boolean s() {
        if (!(this.n instanceof Activity)) {
            return false;
        }
        q qVar = this.s;
        boolean zIsShowing = qVar != null ? qVar.isShowing() : false;
        s sVar = this.q;
        return sVar != null ? zIsShowing | sVar.isShowing() : zIsShowing;
    }

    public void n(View view) {
        this.fs = new SoftReference<>(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        com.byazt.oj.qg qgVar = this.qg;
        if (qgVar == null) {
            return;
        }
        final String strFs = qgVar.fs();
        if (AD_TAG_EXPRESS_BANNER.equals(strFs) || AD_TAG_BANNER.equals(strFs) || AD_TAG_FEED.equals(strFs)) {
            if (this.fs.get() != null && this.qg.rv()) {
                this.fs.get().setVisibility(8);
            }
            if (this.rv == null) {
                this.rv = new HandlerC0384qg(this.n);
            }
            this.rv.postDelayed(new Runnable() { // from class: com.byazt.wg.qg.5
                @Override // java.lang.Runnable
                public void run() {
                    qg.this.qg.qg(qg.AD_TAG_DISLIKE);
                    if (qg.this.fs == null || qg.this.fs.get() == null || !((View) qg.this.fs.get()).isShown()) {
                        com.byazt.nnl.n.n().n(qg.this.n, qg.this.qg, "close_success");
                    } else {
                        com.byazt.nnl.n.n().n(qg.this.n, qg.this.qg, "close_fail");
                    }
                    qg.this.qg.qg(strFs);
                }
            }, 500L);
        }
    }

    public void n(com.byazt.ae.n nVar) {
        this.cp.add(nVar);
        s sVar = this.q;
        if (sVar != null) {
            sVar.n(nVar);
        }
    }

    /* JADX INFO: renamed from: com.byazt.wg.qg$qg, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 204, 201})
    public static class HandlerC0384qg extends Handler {
        public WeakReference<Context> n;

        public HandlerC0384qg(Context context) {
            this.n = new WeakReference<>(context);
        }
    }
}
